package dev.ryanccn.damage_control.config.modmenu;

import dev.ryanccn.damage_control.config.DamageControlConfigScreen;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuAPIImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return DamageControlConfigScreen::new;
    }
}
