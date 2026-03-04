package net.vanillaoutsider.vo_creative_fly_speed;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main mod initializer. Bootstraps GameRule registration.
 *
 * Zenith Module: Modular — game rule registration is in CreativeFlySpeedRules,
 * logic in FlySpeedLogic, mixin hook in mixin/ServerPlayerMixin.
 */
public class CreativeFlySpeedFabric implements ModInitializer {
    public static final String MOD_ID = "vo_creative_fly_speed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Trigger static initializer on CreativeFlySpeedRules by referencing a field.
        // This registers the GameRules with Minecraft's registry at startup.
        LOGGER.info("[Creative Fly Speed] Registering GameRules: creativeFlySpeed, spectatorFlySpeed");
        final var _ = CreativeFlySpeedRules.CREATIVE_FLY_SPEED; // class-load trigger (Java 25 unnamed var)
        LOGGER.info("[Creative Fly Speed] Initialized. Mod ID: {}", MOD_ID);
    }
}
