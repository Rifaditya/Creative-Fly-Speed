// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import net.fabricmc.api.ClientModInitializer;
import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;

public class CreativeFlySpeedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CreativeFlySpeedFabric.LOGGER.info("Creative Fly Speed client initialized! Community: {}, Support: {}", SocialLinks.DISCORD_INVITE_URL, DasikSupportHelper.KOFI_URL);
    }
}
