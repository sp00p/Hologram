package org.sean.hologram;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hologram enabled!");

        getCommand("hologram").setExecutor(new CreateNormalHologram());
        getCommand("mlhologram").setExecutor(new CreateMLHologram());
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Hologram disabled!");
    }

}
