// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.minecraft.world.level.GameType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pillar 4: Headless Simulation & Gamemode Transition State Machine for Creative Fly Speed (MC 1.20.1).
 * Simulates player gamemode state transitions (Survival, Creative, Spectator, Adventure),
 * replicating FlySpeedLogic.applyFlySpeedToPlayer to verify speed application,
 * automatic reset on non-flying modes, and epsilon packet guarding.
 */
class CreativeFlySpeedGameTest {

    private static final float EPSILON = 1e-6F;

    /**
     * Simulated player representation modeling ServerPlayer abilities and gamemode transitions.
     */
    static class SimulatedPlayerState {
        private float flyingSpeed;
        private GameType gameType;
        private int updateAbilitiesCalls = 0;
        private final Map<String, Integer> gameRules = new HashMap<>();

        public SimulatedPlayerState(GameType initialType, float initialSpeed) {
            this.gameType = initialType;
            this.flyingSpeed = initialSpeed;
            // Default GameRules
            this.gameRules.put("creative_fly_speed", 1000);
            this.gameRules.put("spectator_fly_speed", 1000);
        }

        public void setGameRule(String key, int permille) {
            this.gameRules.put(key, permille);
        }

        public int getGameRule(String key) {
            return this.gameRules.getOrDefault(key, 1000);
        }

        public float getFlyingSpeed() {
            return flyingSpeed;
        }

        public void setFlyingSpeed(float flyingSpeed) {
            this.flyingSpeed = flyingSpeed;
        }

        public GameType getGameType() {
            return gameType;
        }

        public void setGameType(GameType gameType) {
            this.gameType = gameType;
        }

        public int getUpdateAbilitiesCalls() {
            return updateAbilitiesCalls;
        }

        public void onUpdateAbilities() {
            this.updateAbilitiesCalls++;
        }

        /**
         * Replicates FlySpeedLogic.applyFlySpeedToPlayer logic headless.
         */
        public void tickFlySpeedLogic() {
            final boolean isCreativeOrSpectator = (gameType == GameType.CREATIVE || gameType == GameType.SPECTATOR);

            if (!isCreativeOrSpectator) {
                if (Math.abs(flyingSpeed - CreativeFlySpeedRules.VANILLA_BASE_SPEED) > EPSILON) {
                    flyingSpeed = CreativeFlySpeedRules.VANILLA_BASE_SPEED;
                    onUpdateAbilities();
                }
                return;
            }

            final float targetSpeed = (gameType == GameType.CREATIVE)
                    ? FlySpeedLogic.calculateSpeed(getGameRule("creative_fly_speed"))
                    : FlySpeedLogic.calculateSpeed(getGameRule("spectator_fly_speed"));

            if (Math.abs(flyingSpeed - targetSpeed) > EPSILON) {
                flyingSpeed = targetSpeed;
                onUpdateAbilities();
            }
        }
    }

    @Test
    @DisplayName("Pillar 4: Transition to Survival while having boosted speed resets flyingSpeed to 0.05F")
    void testTransitionToSurvivalResetsSpeed() {
        SimulatedPlayerState player = new SimulatedPlayerState(GameType.CREATIVE, 0.125F);
        player.setGameRule("creative_fly_speed", 2500);

        // Player is modified to Survival mode
        player.setGameType(GameType.SURVIVAL);
        player.tickFlySpeedLogic();

        assertEquals(CreativeFlySpeedRules.VANILLA_BASE_SPEED, player.getFlyingSpeed(), EPSILON,
                "Flying speed must reset to vanilla base 0.05F when transitioning to Survival");
        assertEquals(1, player.getUpdateAbilitiesCalls(),
                "onUpdateAbilities() must be invoked exactly once when resetting stale speed");
    }

    @Test
    @DisplayName("Pillar 4: Creative mode with 2500 permille rule sets target speed to 0.125F")
    void testCreativeTargetSpeedCalculation() {
        SimulatedPlayerState player = new SimulatedPlayerState(GameType.CREATIVE, CreativeFlySpeedRules.VANILLA_BASE_SPEED);
        player.setGameRule("creative_fly_speed", 2500);

        player.tickFlySpeedLogic();

        assertEquals(0.125F, player.getFlyingSpeed(), EPSILON,
                "Creative flying speed at 2500‰ must scale to 0.125F");
        assertEquals(1, player.getUpdateAbilitiesCalls(),
                "onUpdateAbilities() must be invoked once to sync modified speed");
    }

    @Test
    @DisplayName("Pillar 4: Spectator mode with 1500 permille rule sets target speed to 0.075F")
    void testSpectatorTargetSpeedCalculation() {
        SimulatedPlayerState player = new SimulatedPlayerState(GameType.SPECTATOR, CreativeFlySpeedRules.VANILLA_BASE_SPEED);
        player.setGameRule("spectator_fly_speed", 1500);

        player.tickFlySpeedLogic();

        assertEquals(0.075F, player.getFlyingSpeed(), EPSILON,
                "Spectator flying speed at 1500‰ must scale to 0.075F");
        assertEquals(1, player.getUpdateAbilitiesCalls(),
                "onUpdateAbilities() must be invoked once to sync modified speed");
    }

    @Test
    @DisplayName("Pillar 4: Epsilon guard (1e-6F) suppresses redundant ability sync updates")
    void testEpsilonGuardSuppressesRedundantUpdates() {
        SimulatedPlayerState player = new SimulatedPlayerState(GameType.CREATIVE, 0.125F);
        player.setGameRule("creative_fly_speed", 2500);

        // Initial tick when already at target speed
        player.tickFlySpeedLogic();
        assertEquals(0, player.getUpdateAbilitiesCalls(),
                "No packet sync should occur when player is already at target speed");

        // Microscopic difference below epsilon (e.g. 1e-7F)
        player.setFlyingSpeed(0.125F + 0.5e-7F);
        player.tickFlySpeedLogic();
        assertEquals(0, player.getUpdateAbilitiesCalls(),
                "Differences below epsilon threshold must be ignored to prevent packet spam");

        // Noticeable difference exceeding epsilon triggers sync
        player.setFlyingSpeed(0.125F + 1e-5F);
        player.tickFlySpeedLogic();
        assertEquals(1, player.getUpdateAbilitiesCalls(),
                "Differences exceeding epsilon must trigger ability update sync");
    }

    @Test
    @DisplayName("Pillar 4: Full multi-step gamemode transition lifecycle preserves invariant")
    void testFullGamemodeLifecycle() {
        SimulatedPlayerState player = new SimulatedPlayerState(GameType.SURVIVAL, CreativeFlySpeedRules.VANILLA_BASE_SPEED);
        player.setGameRule("creative_fly_speed", 2500);
        player.setGameRule("spectator_fly_speed", 2000);

        // 1. Initial Survival state - no change
        player.tickFlySpeedLogic();
        assertEquals(CreativeFlySpeedRules.VANILLA_BASE_SPEED, player.getFlyingSpeed(), EPSILON);
        assertEquals(0, player.getUpdateAbilitiesCalls());

        // 2. Switch to Creative -> speed scales to 0.125F
        player.setGameType(GameType.CREATIVE);
        player.tickFlySpeedLogic();
        assertEquals(0.125F, player.getFlyingSpeed(), EPSILON);
        assertEquals(1, player.getUpdateAbilitiesCalls());

        // 3. Repeated Creative tick -> no extra packet
        player.tickFlySpeedLogic();
        assertEquals(1, player.getUpdateAbilitiesCalls());

        // 4. Switch to Spectator -> speed scales to 0.10F (2000‰)
        player.setGameType(GameType.SPECTATOR);
        player.tickFlySpeedLogic();
        assertEquals(0.10F, player.getFlyingSpeed(), EPSILON);
        assertEquals(2, player.getUpdateAbilitiesCalls());

        // 5. Switch to Adventure -> speed resets to vanilla 0.05F
        player.setGameType(GameType.ADVENTURE);
        player.tickFlySpeedLogic();
        assertEquals(CreativeFlySpeedRules.VANILLA_BASE_SPEED, player.getFlyingSpeed(), EPSILON);
        assertEquals(3, player.getUpdateAbilitiesCalls());

        // 6. Switch back to Survival (already at 0.05F) -> no update needed
        player.setGameType(GameType.SURVIVAL);
        player.tickFlySpeedLogic();
        assertEquals(CreativeFlySpeedRules.VANILLA_BASE_SPEED, player.getFlyingSpeed(), EPSILON);
        assertEquals(3, player.getUpdateAbilitiesCalls(), "No redundant update when transitioning between non-fly modes");
    }
}
