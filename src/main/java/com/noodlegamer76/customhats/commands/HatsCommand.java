package com.noodlegamer76.customhats.commands;

import com.noodlegamer76.customhats.CreateHat;
import com.noodlegamer76.customhats.files.HatsListFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class HatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration hats = HatsListFile.getHats();

        if (sender instanceof Player player) {
            if (args.length >= 1) {
                String first = args[0];

                if(first.equals("reload")) {
                    HatsListFile.reload();
                    player.sendMessage("CustomHats Reloaded");
                }

                if(first.equals("create") && args.length >= 4) {


                    if (hats.get(args[1]) == null) {
                        String name = "";
                        for (int i = 3; i < args.length; i++) {
                                name += args[i] + " ";
                        }
                        hats.set(args[1], List.of(name, args[2]));
                        player.sendMessage(ChatColor.GREEN + "Hat created with id '" + args[1] + "' and name '" + name + "'");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "hat with id " + args[1] + " already exists");
                    }


                }
                else if (first.equals("create")){
                    player.sendMessage(ChatColor.RED + "/hats create <id> <rarity> <hat-name>");
                }
                else if (first.equals("rhat")){
                    player.sendMessage("heres a random hat");
                    player.getInventory().addItem(CreateHat.createHat());
                }
            }
            else {
                Inventory inventory = Bukkit.createInventory(player, 54, "Custom Hats");

                Map<String, Object> map = hats.getValues(false);
                int count = 0;
                for (Map.Entry<String, Object> entry:map.entrySet()) {
                    if (count >= 54) {
                        break;
                    }
                    ItemStack stack = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
                    ItemMeta meta = stack.getItemMeta();


                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addAttributeModifier(Attribute.GENERIC_ARMOR,
                            new AttributeModifier(UUID.randomUUID(), "armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    meta.setCustomModelData(Integer.parseInt(entry.getKey()));
                    List<String> values = HatsListFile.getHats().getStringList(entry.getKey());
                    meta.setDisplayName(values.get(0));
                    meta.setLore(List.of(ChatColor.BOLD + "" + ChatColor.WHITE + "Rarity: " + CreateHat.getRarityMessage(values.get(1))));

                    stack.setItemMeta(meta);
                    inventory.addItem(stack);
                    count++;
                }

                player.openInventory(inventory);
            }
        }


        HatsListFile.save();
        return true;
    }
}
