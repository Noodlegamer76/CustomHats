package com.noodlegamer76.customhats.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (!player.isInvulnerable()) {
                player.setInvulnerable(true);
                player.sendMessage(ChatColor.GREEN + "God Mode enabled");
            }
            else {
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.DARK_RED + "God Mode disabled");
            }
            player.sendMessage(command + " ||| " + Arrays.toString(args));
        }
        else return false;


        return true;
    }
}
