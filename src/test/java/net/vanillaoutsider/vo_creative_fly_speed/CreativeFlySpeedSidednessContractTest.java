// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pillar 5: Sidedness & Mixin Contract Verification Suite for Creative Fly Speed (MC 1.21.11).
 * Asserts 100% separation between Common and Client logic, constant pool bytecode safety,
 * absence of unremapped client references in common code, and GPLv3 license header compliance.
 */
class CreativeFlySpeedSidednessContractTest {

    // Dynamic byte arrays to prevent constant pool self-matching (ERR-SELF-MATCH)
    private static final String CLIENT_SRC_FORBIDDEN = new String(new byte[]{
            110, 101, 116, 46, 109, 105, 110, 101, 99, 114, 97, 102, 116, 46, 99, 108, 105, 101, 110, 116, 46
    }); // "net.minecraft.client."

    private static final String BLAZE3D_SRC_FORBIDDEN = new String(new byte[]{
            99, 111, 109, 46, 109, 111, 106, 97, 110, 103, 46, 98, 108, 97, 122, 101, 51, 100, 46
    }); // "com.mojang.blaze3d."

    private static final String CLIENT_BYTECODE_FORBIDDEN = new String(new byte[]{
            110, 101, 116, 47, 109, 105, 110, 101, 99, 114, 97, 102, 116, 47, 99, 108, 105, 101, 110, 116, 47
    }); // "net/minecraft/client/"

    private static final String BLAZE3D_BYTECODE_FORBIDDEN = new String(new byte[]{
            99, 111, 109, 47, 109, 111, 106, 97, 110, 103, 47, 98, 108, 97, 122, 101, 51, 100, 47
    }); // "com/mojang/blaze3d/"

    private static final String LICENSE_HEADER = "// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3";

    private static Path resolveRoot() {
        Path current = Paths.get(".").toAbsolutePath().normalize();
        if (Files.exists(current.resolve("src/main/java"))) {
            return current;
        }
        Path fallback = Paths.get("e:/Minecraft Project/Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v1.21.11");
        if (Files.exists(fallback.resolve("src/main/java"))) {
            return fallback;
        }
        return current;
    }

    @Test
    @DisplayName("Pillar 5: All Java sources in src/main/java and src/test/java start with GPLv3 license header")
    void testLicenseHeadersInAllSources() throws IOException {
        Path root = resolveRoot();
        List<Path> scanRoots = List.of(root.resolve("src/main/java"), root.resolve("src/test/java"));

        for (Path scanRoot : scanRoots) {
            if (!Files.exists(scanRoot)) {
                continue;
            }
            try (Stream<Path> stream = Files.walk(scanRoot)) {
                List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
                assertFalse(javaFiles.isEmpty(), "Java source files must be found in " + scanRoot);

                for (Path file : javaFiles) {
                    String normalized = file.toString().replace('\\', '/');
                    List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                    assertFalse(lines.isEmpty(), "File must not be empty: " + normalized);

                    String firstLine = lines.get(0).trim();
                    assertEquals(LICENSE_HEADER, firstLine,
                            "Missing or invalid GPLv3 license header on line 1 in: " + normalized);
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Common sources outside client package contain zero client imports")
    void testCommonSourcesContainZeroClientImports() throws IOException {
        Path root = resolveRoot();
        Path srcMainJava = root.resolve("src/main/java");
        assertTrue(Files.exists(srcMainJava), "src/main/java must exist at: " + srcMainJava);

        try (Stream<Path> stream = Files.walk(srcMainJava)) {
            List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
            assertFalse(javaFiles.isEmpty(), "Java source files must exist in src/main/java");

            for (Path file : javaFiles) {
                String normalized = file.toString().replace('\\', '/');

                // Client package or client entrypoint classes are exempt from client import bans
                if (normalized.contains("/client/") || normalized.endsWith("Client.java")) {
                    continue;
                }

                List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                for (String line : lines) {
                    String trimmed = line.trim();
                    if (trimmed.startsWith("import ")) {
                        assertFalse(trimmed.contains(CLIENT_SRC_FORBIDDEN),
                                "Forbidden client package import in common file (" + normalized + "): " + trimmed);
                        assertFalse(trimmed.contains(BLAZE3D_SRC_FORBIDDEN),
                                "Forbidden Blaze3D import in common file (" + normalized + "): " + trimmed);
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Common bytecode classes contain zero client constant pool references")
    void testCommonBytecodeContainZeroClientReferences() throws IOException {
        Path root = resolveRoot();
        Path classesRoot = root.resolve("build/classes/java/main");
        if (!Files.exists(classesRoot)) {
            // Bytecode check runs if build has compiled classes
            return;
        }

        try (Stream<Path> stream = Files.walk(classesRoot)) {
            List<Path> classFiles = stream.filter(p -> p.toString().endsWith(".class")).toList();
            for (Path classFile : classFiles) {
                String normalized = classFile.toString().replace('\\', '/');
                if (normalized.contains("/client/") || normalized.endsWith("Client.class")) {
                    continue;
                }
                String rawBytes = new String(Files.readAllBytes(classFile), StandardCharsets.ISO_8859_1);
                assertFalse(rawBytes.contains(CLIENT_BYTECODE_FORBIDDEN),
                        "Forbidden client constant pool reference in common bytecode: " + normalized);
                assertFalse(rawBytes.contains(BLAZE3D_BYTECODE_FORBIDDEN),
                        "Forbidden Blaze3D constant pool reference in common bytecode: " + normalized);
            }
        }
    }
}
