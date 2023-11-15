package com.noodlegamer76.customhats;

import com.noodlegamer76.customhats.events.TestEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomHats extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TestEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
