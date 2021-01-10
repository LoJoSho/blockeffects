package me.lojosho.blockeffects;

import me.lojosho.blockeffects.untils.SetupTimer;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        RegisterTimers();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void RegisterTimers() {
        new SetupTimer(this);
    }
}
