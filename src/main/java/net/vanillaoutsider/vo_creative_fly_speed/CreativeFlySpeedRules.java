// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.resources.Identifier;

/**
 * Registers the GameRules for Creative Fly Speed via DasikLibrary.
 * Default: 1000 = 1.0x speed (vanilla 0.05f).
 * Example: 2500 = 2.5x speed.
 */
public final class CreativeFlySpeedRules {

    public static final GameRuleCategory CATEGORY;

    /**
     * Flying speed multiplier for Creative mode (permille).
     * Default: 1000 (1.0x = 0.05f vanilla)
     */
    public static final GameRule<Integer> CREATIVE_FLY_SPEED;

    /**
     * Flying speed multiplier for Spectator mode (permille).
     * Default: 1000 (1.0x = 0.05f vanilla)
     */
    public static final GameRule<Integer> SPECTATOR_FLY_SPEED;

    /** Vanilla base flying speed in blocks/tick. */
    public static final float VANILLA_BASE_SPEED = 0.05F;

    static {
        CATEGORY = DynamicGameRuleManager.registerCategory(
                Identifier.fromNamespaceAndPath("vo_creative_fly_speed", "fly_speed")
        );
        CREATIVE_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_creative_fly_speed:creative_fly_speed", CATEGORY, 1000)
                .range(1, 100000)
                .name("Creative Fly Speed")
                .description("Multiplier for flying speed in Creative mode in permille (1000 = 1.0x).")
                .register();
        SPECTATOR_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_creative_fly_speed:spectator_fly_speed", CATEGORY, 1000)
                .range(1, 100000)
                .name("Spectator Fly Speed")
                .description("Multiplier for flying speed in Spectator mode in permille (1000 = 1.0x).")
                .register();
    }

    private CreativeFlySpeedRules() {}
}
