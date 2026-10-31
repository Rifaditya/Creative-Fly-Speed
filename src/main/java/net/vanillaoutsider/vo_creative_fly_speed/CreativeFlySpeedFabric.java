// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.vanillaoutsider.vo_creative_fly_speed.command.CreativeFlySpeedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main mod initializer for Creative Fly Speed (MC 1.21.11).
 * Bootstraps GameRule registration and Brigadier commands.
 */
public class CreativeFlySpeedFabric implements ModInitializer {
    public static final String MOD_ID = "vo_creative_fly_speed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[Creative Fly Speed] Registering GameRules: creativeFlySpeed, spectatorFlySpeed");
        var ignored = CreativeFlySpeedRules.CREATIVE_FLY_SPEED; // class-load trigger

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            CreativeFlySpeedCommand.register(dispatcher);
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            int purged = DynamicGameRuleManager.unregisterModRules(MOD_ID);
            LOGGER.info("[Creative Fly Speed] Unregistered {} dynamic GameRules on server shutdown", purged);
        });

        LOGGER.info("[Creative Fly Speed] Initialized. Mod ID: {}", MOD_ID);
    }
}
