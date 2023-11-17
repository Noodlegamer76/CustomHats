package com.noodlegamer76.customhats;

import com.noodlegamer76.customhats.commands.GodCommand;
import com.noodlegamer76.customhats.commands.HatsCommand;
import com.noodlegamer76.customhats.files.HatsListFile;
import com.noodlegamer76.customhats.listeners.EntitySpawnListener;
import com.noodlegamer76.customhats.listeners.HatEnchanting;
import com.noodlegamer76.customhats.listeners.PlayerInteractListener;
import com.noodlegamer76.customhats.listeners.TestEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class CustomHats extends JavaPlugin {
    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {

        //setup config
        saveDefaultConfig();

        HatsListFile.setup();
        HatsListFile.getHats().options().copyDefaults(true);
        HatsListFile.save();


        //event listeners
        getServer().getPluginManager().registerEvents(new TestEvent(), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        getServer().getPluginManager().registerEvents(new HatEnchanting(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        //commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("hats").setExecutor(new HatsCommand());
    }

    @Override
    public void onDisable() {
    }
}
