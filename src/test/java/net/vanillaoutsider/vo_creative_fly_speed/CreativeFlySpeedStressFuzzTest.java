// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pillar 1: Headless Stress & Fuzz Testing Suite for Creative Fly Speed (MC 1.20.1).
 * Executes 50,000 randomized and boundary permille speed calculations,
 * verifying mathematical stability, lack of NaN/Infinity, and exact known points.
 */
class CreativeFlySpeedStressFuzzTest {

    private static final float EPSILON = 1e-6F;
    private static final int FUZZ_ITERATIONS = 50_000;

    @Test
    @DisplayName("Pillar 1: Exact mathematical values for known permille points")
    void testExactKnownPoints() {
        assertEquals(0.05F, FlySpeedLogic.calculateSpeed(1000), EPSILON, "1000‰ must yield vanilla base speed 0.05F");
        assertEquals(0.10F, FlySpeedLogic.calculateSpeed(2000), EPSILON, "2000‰ must yield 2.0x base speed 0.10F");
        assertEquals(0.025F, FlySpeedLogic.calculateSpeed(500), EPSILON, "500‰ must yield 0.5x base speed 0.025F");
        assertEquals(0.0F, FlySpeedLogic.calculateSpeed(0), EPSILON, "0‰ must yield 0.0F");
        assertEquals(5.0F, FlySpeedLogic.calculateSpeed(100_000), EPSILON, "100,000‰ must yield 100.0x base speed 5.0F");
    }

    @Test
    @DisplayName("Pillar 1: Boundary and extreme value calculations yield finite non-NaN values")
    void testBoundaryAndExtremeValues() {
        int[] edgeCases = {
                Integer.MIN_VALUE,
                -1_000_000,
                -1000,
                -1,
                0,
                1,
                500,
                1000,
                2500,
                100_000,
                1_000_000,
                Integer.MAX_VALUE
        };

        for (int permille : edgeCases) {
            float speed = FlySpeedLogic.calculateSpeed(permille);
            assertFalse(Float.isNaN(speed), "Speed calculation must not be NaN for permille: " + permille);
            assertFalse(Float.isInfinite(speed), "Speed calculation must not be Infinite for permille: " + permille);
        }
    }

    @Test
    @DisplayName("Pillar 1: 50,000 randomized permille fuzz iterations execute cleanly")
    void testFiftyThousandFuzzIterations() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < FUZZ_ITERATIONS; i++) {
            int permille;
            int branch = i % 5;
            if (branch == 0) {
                // Completely unconstrained 32-bit integer range
                permille = random.nextInt();
            } else if (branch == 1) {
                // Legal configuration range [1, 100000]
                permille = random.nextInt(1, 100_001);
            } else if (branch == 2) {
                // Negative range [-100000, 0]
                permille = random.nextInt(-100_000, 1);
            } else if (branch == 3) {
                // Typical permille multiplier range [500, 10000]
                permille = random.nextInt(500, 10_001);
            } else {
                // Boundary values
                int[] boundaries = {Integer.MIN_VALUE, -1000, 0, 1, 1000, 100000, Integer.MAX_VALUE};
                permille = boundaries[random.nextInt(boundaries.length)];
            }

            float speed = FlySpeedLogic.calculateSpeed(permille);

            assertFalse(Float.isNaN(speed), "Speed must not be NaN at iteration " + i + " for permille: " + permille);
            assertFalse(Float.isInfinite(speed), "Speed must not be Infinite at iteration " + i + " for permille: " + permille);

            float expected = CreativeFlySpeedRules.VANILLA_BASE_SPEED * (permille / 1000.0F);
            assertEquals(expected, speed, 1e-4F, "Speed must match arithmetic expectation at iteration " + i);
        }
    }
}
