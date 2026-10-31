// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;
import net.vanillaoutsider.vo_creative_fly_speed.util.CreativeFlySpeedSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Headless unit tests for FlySpeedLogic calculations and CreativeFlySpeedSupport links.
 */
class FlySpeedLogicTest {

    private static final float EPSILON = 1e-6f;

    @Test
    @DisplayName("calculateSpeed(1000) should yield vanilla base speed 0.05f")
    void testCalculateSpeedDefault() {
        assertEquals(0.05f, FlySpeedLogic.calculateSpeed(1000), EPSILON);
    }

    @Test
    @DisplayName("calculateSpeed(2500) should yield 2.5x speed 0.125f")
    void testCalculateSpeedMultiplier() {
        assertEquals(0.125f, FlySpeedLogic.calculateSpeed(2500), EPSILON);
    }

    @Test
    @DisplayName("calculateSpeed boundary values: 0, 1, and 100000")
    void testPermilleBoundaryValues() {
        // Zero permille
        assertEquals(0.0f, FlySpeedLogic.calculateSpeed(0), EPSILON);

        // Minimum non-zero permille (1 permille = 0.001 * 0.05 = 0.00005f)
        assertEquals(0.00005f, FlySpeedLogic.calculateSpeed(1), EPSILON);

        // Maximum permille (100,000 permille = 100.0 * 0.05 = 5.0f)
        assertEquals(5.0f, FlySpeedLogic.calculateSpeed(100000), EPSILON);
    }

    @Test
    @DisplayName("Creator support and community URLs match official records")
    void testSupportUrlsMatchOfficialRecords() {
        assertEquals(SocialLinks.DISCORD_INVITE_URL, CreativeFlySpeedSupport.getDiscordUrl());
        assertEquals(DasikSupportHelper.KOFI_URL, CreativeFlySpeedSupport.getKofiUrl());
        assertEquals(SocialLinks.GITHUB_URL, CreativeFlySpeedSupport.getGithubUrl());

        assertNotNull(CreativeFlySpeedSupport.getDiscordUri());
        assertNotNull(CreativeFlySpeedSupport.getKofiUri());
        assertNotNull(CreativeFlySpeedSupport.getGithubUri());
    }
}
