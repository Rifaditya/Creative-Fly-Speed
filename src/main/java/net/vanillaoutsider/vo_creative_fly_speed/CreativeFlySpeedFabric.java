// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.vanillaoutsider.vo_creative_fly_speed.command.CreativeFlySpeedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main mod initializer for Creative Fly Speed (MC 1.20.1).
 * Bootstraps GameRule registration and Brigadier commands.
 */
public class CreativeFlySpeedFabric implements ModInitializer {
    public static final String MOD_ID = "vo_creative_fly_speed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[Creative Fly Speed] Registering GameRules: creativeFlySpeed, spectatorFlySpeed");
        CreativeFlySpeedRules.register();

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            CreativeFlySpeedCommand.register(dispatcher);
        });

        LOGGER.info("[Creative Fly Speed] Initialized. Mod ID: {}", MOD_ID);
    }
}
