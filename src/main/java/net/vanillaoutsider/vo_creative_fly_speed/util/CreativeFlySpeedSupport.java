// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed.util;

import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;

import java.net.URI;

/**
 * Utility helper providing centralized access to creator support and community URIs,
 * backed by DasikLibrary's SocialLinks and DasikSupportHelper.
 */
public final class CreativeFlySpeedSupport {

    private CreativeFlySpeedSupport() {}

    /**
     * @return Official Discord invite URL.
     */
    public static String getDiscordUrl() {
        return SocialLinks.DISCORD_INVITE_URL;
    }

    /**
     * @return Official Discord invite URI.
     */
    public static URI getDiscordUri() {
        return SocialLinks.getDiscordUri();
    }

    /**
     * @return Official Ko-fi creator support URL.
     */
    public static String getKofiUrl() {
        return DasikSupportHelper.KOFI_URL;
    }

    /**
     * @return Official Ko-fi creator support URI.
     */
    public static URI getKofiUri() {
        return SocialLinks.getKofiUri();
    }

    /**
     * @return Official GitHub repository URL.
     */
    public static String getGithubUrl() {
        return SocialLinks.GITHUB_URL;
    }

    /**
     * @return Official GitHub repository URI.
     */
    public static URI getGithubUri() {
        return SocialLinks.getGithubUri();
    }
}
