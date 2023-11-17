package com.noodlegamer76.customhats.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class HatsListFile {

    private static File file;
    private static FileConfiguration customhats;

    public static void setup() {
        file = new File(Bukkit.getPluginManager().getPlugin("CustomHats").getDataFolder(), "customhats.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }

        customhats = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getHats() {
        return customhats;
    }

    public static void save() {
        try {
            customhats.save(file);
        } catch (IOException e) {
            System.out.println("could not save file");
        }
    }

    public static void reload() {
        customhats = YamlConfiguration.loadConfiguration(file);
    }
}
