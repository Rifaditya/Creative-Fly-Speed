// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.gamerules.GameRules;

/**
 * Stateless helper class encapsulating all fly-speed mutation logic.
 * Mixin purity: Mixins call into this class. No business logic in Mixin.
 */
public final class FlySpeedLogic {

    private FlySpeedLogic() {}

    /**
     * Calculate the desired fly speed from a permille GameRule value.
     * O(1) — pure arithmetic, no allocation.
     *
     * @param permille The permille value from the GameRule (e.g. 1000 = 1.0x, 2500 = 2.5x).
     * @return The desired flyingSpeed float (e.g. 0.05f * 2.5f = 0.125f).
     */
    public static float calculateSpeed(final int permille) {
        return CreativeFlySpeedRules.VANILLA_BASE_SPEED * (permille / 1000.0F);
    }

    /**
     * Applies the correct fly speed to a ServerPlayer based on their current GameMode
     * and the world's GameRules. Only modifies the player if the speed is stale.
     * Calls onUpdateAbilities() to sync to the client if changed.
     * O(1).
     *
     * @param player The server-side player to update.
     */
    public static void applyFlySpeedToPlayer(final ServerPlayer player) {
        final Abilities abilities = player.getAbilities();
        final GameType gameType = player.gameMode.getGameModeForPlayer();
        final boolean isCreativeOrSpectator = (gameType == GameType.CREATIVE || gameType == GameType.SPECTATOR);

        if (!isCreativeOrSpectator) {
            if (Math.abs(abilities.getFlyingSpeed() - CreativeFlySpeedRules.VANILLA_BASE_SPEED) > 1e-6F) {
                abilities.setFlyingSpeed(CreativeFlySpeedRules.VANILLA_BASE_SPEED);
                player.onUpdateAbilities();
            }
            return;
        }

        final GameRules rules = player.level().getGameRules();
        final float targetSpeed = (gameType == GameType.CREATIVE)
                ? calculateSpeed(rules.get(CreativeFlySpeedRules.CREATIVE_FLY_SPEED))
                : calculateSpeed(rules.get(CreativeFlySpeedRules.SPECTATOR_FLY_SPEED));

        if (Math.abs(abilities.getFlyingSpeed() - targetSpeed) > 1e-6F) {
            abilities.setFlyingSpeed(targetSpeed);
            player.onUpdateAbilities();
        }
    }
}
