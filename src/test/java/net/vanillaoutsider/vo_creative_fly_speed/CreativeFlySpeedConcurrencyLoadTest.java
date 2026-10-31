// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pillar 2: Headless Concurrency & Multi-Threaded Load Test for Creative Fly Speed (MC 1.20.1).
 * Spawns 50 concurrent worker threads executing 10,000 calculation cycles each (500,000 total ops)
 * verifying thread-safety, stateless purity, and zero mutable shared state collisions.
 */
class CreativeFlySpeedConcurrencyLoadTest {

    private static final int THREAD_COUNT = 50;
    private static final int CYCLES_PER_THREAD = 10_000;
    private static final float EPSILON = 1e-4F;

    @Test
    @DisplayName("Pillar 2: 50 concurrent worker threads execute 10,000 calculation cycles without exceptions")
    void testConcurrentSpeedCalculationLoad() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(THREAD_COUNT);

        AtomicInteger totalOpsCompleted = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);
        CopyOnWriteArrayList<Throwable> exceptions = new CopyOnWriteArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> {
                try {
                    startLatch.await();
                    ThreadLocalRandom random = ThreadLocalRandom.current();

                    for (int cycle = 0; cycle < CYCLES_PER_THREAD; cycle++) {
                        int permille = random.nextInt(-50_000, 200_001);
                        float speed = FlySpeedLogic.calculateSpeed(permille);
                        float expected = CreativeFlySpeedRules.VANILLA_BASE_SPEED * (permille / 1000.0F);

                        if (Float.isNaN(speed) || Float.isInfinite(speed) || Math.abs(speed - expected) > EPSILON) {
                            failureCount.incrementAndGet();
                        }
                        totalOpsCompleted.incrementAndGet();
                    }
                } catch (Throwable t) {
                    exceptions.add(t);
                    failureCount.incrementAndGet();
                } finally {
                    doneLatch.countDown();
                }
            });
        }

        // Fire start trigger simultaneously for all 50 threads
        startLatch.countDown();

        boolean completedInTime = doneLatch.await(30, TimeUnit.SECONDS);
        executor.shutdown();
        boolean terminated = executor.awaitTermination(5, TimeUnit.SECONDS);

        assertTrue(completedInTime, "All 50 worker threads must finish within 30 seconds");
        assertTrue(terminated, "Executor must terminate cleanly");
        assertTrue(exceptions.isEmpty(), "Zero exceptions must occur during concurrent load: " + exceptions);
        assertEquals(0, failureCount.get(), "Zero calculation mismatches must occur across threads");
        assertEquals(THREAD_COUNT * CYCLES_PER_THREAD, totalOpsCompleted.get(), "All 500,000 operations must complete");
    }
}
