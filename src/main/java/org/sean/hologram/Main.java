package org.sean.hologram;

import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    BossBar bossBar;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("First plugin enabled!");

        getCommand("hologram").setExecutor(new HologramListener());

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("First plugin disabled!");
    }

}
