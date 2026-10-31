// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import net.dasik.social.api.config.ConfigOption;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common configuration model and persistence manager for Creative Fly Speed.
 * Exposes fields annotated with @ConfigOption for UniversalConfigScreen (YACL / ModMenu).
 * Strictly side-safe with zero client package imports.
 */
public final class CreativeFlySpeedConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreativeFlySpeedConfig.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static Path customConfigPath = null;

    @ConfigOption(
        category = "general",
        syncGameRule = true,
        gameRuleName = "vo_creative_fly_speed:creative_fly_speed",
        nameKey = "gamerule.vo_creative_fly_speed.creative_fly_speed",
        descriptionKey = "gamerule.vo_creative_fly_speed.creative_fly_speed.description",
        min = 100,
        max = 20000,
        step = 100,
        slider = true,
        order = 1
    )
    public static int creativeFlySpeed = 1000;

    @ConfigOption(
        category = "general",
        syncGameRule = true,
        gameRuleName = "vo_creative_fly_speed:spectator_fly_speed",
        nameKey = "gamerule.vo_creative_fly_speed.spectator_fly_speed",
        descriptionKey = "gamerule.vo_creative_fly_speed.spectator_fly_speed.description",
        min = 100,
        max = 20000,
        step = 100,
        slider = true,
        order = 2
    )
    public static int spectatorFlySpeed = 1000;

    private CreativeFlySpeedConfig() {
    }

    public static void resetDefaults() {
        creativeFlySpeed = 1000;
        spectatorFlySpeed = 1000;
    }

    public static Path getConfigPath() {
        if (customConfigPath != null) {
            return customConfigPath;
        }
        try {
            if (FabricLoader.getInstance() != null && FabricLoader.getInstance().getConfigDir() != null) {
                return FabricLoader.getInstance().getConfigDir().resolve("creative_fly_speed.json");
            }
        } catch (Throwable ignored) {
        }
        return Path.of("config", "creative_fly_speed.json");
    }

    public static void setCustomConfigPath(Path path) {
        customConfigPath = path;
    }

    public static void load() {
        loadFromPath(getConfigPath());
    }

    public static void save() {
        saveToPath(getConfigPath());
    }

    public static void loadFromPath(Path path) {
        if (path == null || !Files.exists(path)) {
            resetDefaults();
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            if (json.has("creativeFlySpeed")) {
                creativeFlySpeed = json.get("creativeFlySpeed").getAsInt();
            } else {
                creativeFlySpeed = 1000;
            }
            if (json.has("spectatorFlySpeed")) {
                spectatorFlySpeed = json.get("spectatorFlySpeed").getAsInt();
            } else {
                spectatorFlySpeed = 1000;
            }
        } catch (Exception e) {
            LOGGER.warn("Failed to parse Creative Fly Speed configuration at {}, resetting to defaults: {}", path.getFileName(), e.getMessage());
            resetDefaults();
        }
    }

    public static void saveToPath(Path path) {
        if (path == null) {
            return;
        }

        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            JsonObject json = new JsonObject();
            json.addProperty("creativeFlySpeed", creativeFlySpeed);
            json.addProperty("spectatorFlySpeed", spectatorFlySpeed);

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                GSON.toJson(json, writer);
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save Creative Fly Speed configuration to {}", path.getFileName(), e);
        }
    }
}
