// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameRules;

/**
 * Registers the GameRules for Creative Fly Speed via DasikLibrary in MC 1.20.1.
 * Default: 1000 = 1.0x speed (vanilla 0.05f).
 * Example: 2500 = 2.5x speed.
 */
public final class CreativeFlySpeedRules {

    public static CustomGameRuleCategory CATEGORY;

    /**
     * Flying speed multiplier for Creative mode (permille).
     * Default: 1000 (1.0x = 0.05f vanilla)
     */
    public static GameRules.Key<GameRules.IntegerValue> CREATIVE_FLY_SPEED;

    /**
     * Flying speed multiplier for Spectator mode (permille).
     * Default: 1000 (1.0x = 0.05f vanilla)
     */
    public static GameRules.Key<GameRules.IntegerValue> SPECTATOR_FLY_SPEED;

    /** Vanilla base flying speed in blocks/tick. */
    public static final float VANILLA_BASE_SPEED = 0.05F;

    private static volatile boolean initialized = false;

    static {
        register();
    }

    public static synchronized void register() {
        if (initialized) {
            return;
        }
        try {
            if (CATEGORY == null) {
                CATEGORY = DynamicGameRuleManager.registerCategory(
                        new ResourceLocation("vo_creative_fly_speed", "fly_speed"),
                        Component.translatable("category.vo_creative_fly_speed")
                );
            }
            if (CREATIVE_FLY_SPEED == null) {
                CREATIVE_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_creative_fly_speed:creative_fly_speed", CATEGORY, 1000)
                        .range(1, 100000)
                        .name("Creative Fly Speed")
                        .description("Multiplier for flying speed in Creative mode in permille (1000 = 1.0x).")
                        .register();
            }
            if (SPECTATOR_FLY_SPEED == null) {
                SPECTATOR_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_creative_fly_speed:spectator_fly_speed", CATEGORY, 1000)
                        .range(1, 100000)
                        .name("Spectator Fly Speed")
                        .description("Multiplier for flying speed in Spectator mode in permille (1000 = 1.0x).")
                        .register();
            }
            initialized = true;
        } catch (Throwable t) {
            // Guard ERR-20261030-001: Headless test harness safety
        }
    }

    private CreativeFlySpeedRules() {}
}
