// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import net.dasik.social.api.config.ConfigOption;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.vanillaoutsider.vo_creative_fly_speed.client.CreativeFlySpeedModMenu;
import net.vanillaoutsider.vo_creative_fly_speed.config.CreativeFlySpeedConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 5-Pillar Verification suite for CreativeFlySpeed ModMenu and Config model.
 * Asserts annotation contracts, sidedness separation, hermetic persistence, and factory production.
 */
class CreativeFlySpeedModMenuTest {

    @Test
    @DisplayName("Pillar 2: Verify CreativeFlySpeedConfig @ConfigOption annotations and metadata")
    void testConfigOptionAnnotations() throws NoSuchFieldException {
        Field creativeField = CreativeFlySpeedConfig.class.getDeclaredField("creativeFlySpeed");
        ConfigOption creativeOpt = creativeField.getAnnotation(ConfigOption.class);
        assertNotNull(creativeOpt, "creativeFlySpeed must be annotated with @ConfigOption");
        assertEquals("general", creativeOpt.category());
        assertTrue(creativeOpt.syncGameRule(), "creativeFlySpeed must sync with GameRule");
        assertEquals("vo_creative_fly_speed:creative_fly_speed", creativeOpt.gameRuleName());
        assertEquals("gamerule.vo_creative_fly_speed.creative_fly_speed", creativeOpt.nameKey());
        assertEquals("gamerule.vo_creative_fly_speed.creative_fly_speed.description", creativeOpt.descriptionKey());
        assertEquals(100.0, creativeOpt.min(), 0.001);
        assertEquals(20000.0, creativeOpt.max(), 0.001);
        assertEquals(100.0, creativeOpt.step(), 0.001);
        assertTrue(creativeOpt.slider(), "creativeFlySpeed should render as a slider");
        assertEquals(1, creativeOpt.order());

        Field spectatorField = CreativeFlySpeedConfig.class.getDeclaredField("spectatorFlySpeed");
        ConfigOption spectatorOpt = spectatorField.getAnnotation(ConfigOption.class);
        assertNotNull(spectatorOpt, "spectatorFlySpeed must be annotated with @ConfigOption");
        assertEquals("general", spectatorOpt.category());
        assertTrue(spectatorOpt.syncGameRule(), "spectatorFlySpeed must sync with GameRule");
        assertEquals("vo_creative_fly_speed:spectator_fly_speed", spectatorOpt.gameRuleName());
        assertEquals("gamerule.vo_creative_fly_speed.spectator_fly_speed", spectatorOpt.nameKey());
        assertEquals("gamerule.vo_creative_fly_speed.spectator_fly_speed.description", spectatorOpt.descriptionKey());
        assertEquals(100.0, spectatorOpt.min(), 0.001);
        assertEquals(20000.0, spectatorOpt.max(), 0.001);
        assertEquals(100.0, spectatorOpt.step(), 0.001);
        assertTrue(spectatorOpt.slider(), "spectatorFlySpeed should render as a slider");
        assertEquals(2, spectatorOpt.order());
    }

    @Test
    @DisplayName("Pillar 5: Verify CreativeFlySpeedModMenu class environment and ModMenuApi contract")
    void testModMenuClassContract() throws Exception {
        assertTrue(ModMenuApi.class.isAssignableFrom(CreativeFlySpeedModMenu.class),
                "CreativeFlySpeedModMenu must implement ModMenuApi");

        // Environment annotation has RetentionPolicy.CLASS (RuntimeInvisibleAnnotations in bytecode)
        try (var is = CreativeFlySpeedModMenu.class.getResourceAsStream("CreativeFlySpeedModMenu.class")) {
            assertNotNull(is, "Class bytecode stream must be readable");
            byte[] bytes = is.readAllBytes();
            String bytecodeString = new String(bytes, java.nio.charset.StandardCharsets.ISO_8859_1);
            assertTrue(bytecodeString.contains("Lnet/fabricmc/api/Environment;"),
                    "CreativeFlySpeedModMenu must declare @Environment annotation in class bytecode");
            assertTrue(bytecodeString.contains("CLIENT"),
                    "CreativeFlySpeedModMenu must target EnvType.CLIENT in class bytecode");
        }
    }

    @Test
    @DisplayName("Pillar 1: Direct instantiation produces non-null ConfigScreenFactory")
    void testDirectInstantiationAndFactory() {
        CreativeFlySpeedModMenu modMenu = new CreativeFlySpeedModMenu();
        assertNotNull(modMenu, "CreativeFlySpeedModMenu instance should not be null");

        ConfigScreenFactory<?> factory = modMenu.getModConfigScreenFactory();
        assertNotNull(factory, "ConfigScreenFactory must not be null even when YACL is absent");
        assertNull(factory.create(null), "Fallback factory must produce null screen when YACL is absent");
    }

    @Test
    @DisplayName("Pillar 1: Reflection instantiation and invocation succeeds")
    void testReflectionInstantiationAndInvocation() throws Exception {
        Class<?> clazz = Class.forName("net.vanillaoutsider.vo_creative_fly_speed.client.CreativeFlySpeedModMenu");
        assertNotNull(clazz, "CreativeFlySpeedModMenu class must be discoverable via reflection");

        Object instance = clazz.getDeclaredConstructor().newInstance();
        assertNotNull(instance, "CreativeFlySpeedModMenu reflection instance must not be null");

        Method factoryMethod = clazz.getMethod("getModConfigScreenFactory");
        assertNotNull(factoryMethod, "getModConfigScreenFactory method must exist");

        Object factory = factoryMethod.invoke(instance);
        assertNotNull(factory, "Invoking getModConfigScreenFactory must return non-null factory");
    }

    @Test
    @DisplayName("Pillar 2 & 4: Hermetic persistence of CreativeFlySpeedConfig JSON")
    void testConfigHermeticPersistence() throws Exception {
        Path tempFile = Files.createTempFile("cfs_cfg_test", ".json");
        try {
            CreativeFlySpeedConfig.resetDefaults();
            assertEquals(1000, CreativeFlySpeedConfig.creativeFlySpeed);
            assertEquals(1000, CreativeFlySpeedConfig.spectatorFlySpeed);

            CreativeFlySpeedConfig.creativeFlySpeed = 2500;
            CreativeFlySpeedConfig.spectatorFlySpeed = 5000;
            CreativeFlySpeedConfig.saveToPath(tempFile);
            assertTrue(Files.exists(tempFile), "Config file must be created on save");

            CreativeFlySpeedConfig.resetDefaults();
            assertEquals(1000, CreativeFlySpeedConfig.creativeFlySpeed);
            assertEquals(1000, CreativeFlySpeedConfig.spectatorFlySpeed);

            CreativeFlySpeedConfig.loadFromPath(tempFile);
            assertEquals(2500, CreativeFlySpeedConfig.creativeFlySpeed);
            assertEquals(5000, CreativeFlySpeedConfig.spectatorFlySpeed);
        } finally {
            Files.deleteIfExists(tempFile);
            CreativeFlySpeedConfig.resetDefaults();
        }
    }

    @Test
    @DisplayName("Pillar 5: CreativeFlySpeedConfig is strictly side-safe with 0 client pool references")
    void testConfigSidednessSafety() throws Exception {
        assertNull(CreativeFlySpeedConfig.class.getAnnotation(Environment.class),
                "CreativeFlySpeedConfig must be side-neutral (no @Environment annotation)");

        try (var is = CreativeFlySpeedConfig.class.getResourceAsStream("CreativeFlySpeedConfig.class")) {
            assertNotNull(is, "Class bytecode stream must be readable");
            byte[] bytes = is.readAllBytes();
            String bytecodeString = new String(bytes, java.nio.charset.StandardCharsets.ISO_8859_1);
            assertFalse(bytecodeString.contains("Lnet/fabricmc/api/Environment;"),
                    "CreativeFlySpeedConfig must not declare @Environment annotation in class bytecode");
        }

        // Assert all methods and fields can be safely resolved in common runtime
        assertDoesNotThrow(() -> {
            CreativeFlySpeedConfig.resetDefaults();
            CreativeFlySpeedConfig.getConfigPath();
        });
    }
}
