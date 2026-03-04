package net.vanillaoutsider.vo_creative_fly_speed;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.resources.Identifier;

/**
 * Registers the GameRules for Creative Fly Speed via DasikLibrary.
 *
 * Note: The vanilla GameRules.registerInteger() is private in MC 26.1.
 * DynamicGameRuleManager provides the correct public registration API.
 *
 * // Verified against: GameRules.java (26.1 Snapshot 10) — private registerInteger()
 * // Verified against: OreAmplifierFabric.java — DynamicGameRuleManager usage pattern
 *
 * Default: 1000 = 1.0x speed (vanilla 0.05f)
 * Example: 2500 = 2.5x speed
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

    /** Vanilla base flying speed in blocks/tick. Verified: Abilities.java (26.1 Snapshot 10) */
    public static final float VANILLA_BASE_SPEED = 0.05F;

    static {
        CATEGORY = DynamicGameRuleManager.registerCategory(
                Identifier.fromNamespaceAndPath("vo_creative_fly_speed", "fly_speed")
        );
        CREATIVE_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_creative_fly_speed", CATEGORY, 1000)
                .range(1, 100000)
                .name("Creative Fly Speed")
                .description("Multiplier for flying speed in Creative mode. Default is 1000 (1.0x).")
                .register();
        SPECTATOR_FLY_SPEED = DynamicGameRuleManager.integerRule("vo_spectator_fly_speed", CATEGORY, 1000)
                .range(1, 100000)
                .name("Spectator Fly Speed")
                .description("Multiplier for flying speed in Spectator mode. Default is 1000 (1.0x).")
                .register();
    }

    private CreativeFlySpeedRules() {}
}

