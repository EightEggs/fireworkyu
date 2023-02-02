package io.github.eighteggs.fireworkyu;

import org.bukkit.plugin.java.JavaPlugin;

public final class FireworkyuMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("starting...");
        getCommand("firework").setExecutor(new FireworkyuExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("shutting down...");
        saveConfig();
    }
}
