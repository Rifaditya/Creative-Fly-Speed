// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.dasik.social.api.client.gui.UniversalConfigScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.vanillaoutsider.vo_creative_fly_speed.config.CreativeFlySpeedConfig;

@Environment(EnvType.CLIENT)
public class CreativeFlySpeedModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return UniversalConfigScreen.createFactory("vo_creative_fly_speed", CreativeFlySpeedConfig.class, CreativeFlySpeedConfig::save);
    }
}
