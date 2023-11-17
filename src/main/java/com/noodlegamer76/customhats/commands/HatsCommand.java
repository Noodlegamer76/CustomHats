package com.noodlegamer76.customhats.commands;

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

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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

                if(first.equals("create") && args.length >= 3) {


                    if (hats.get(args[1]) == null) {
                        String name = "";
                        for (int i = 2; i < args.length; i++) {
                            if (i > 2) {
                                name += " " + args[i];
                            }
                            else {
                                name += args[i];
                            }
                        }
                        hats.set(args[1], name);
                        player.sendMessage(ChatColor.GREEN + "Hat created with id '" + args[1] + "' and name '" + name + "'");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "hat with id " + args[1] + " already exists");
                    }


                }
                else if (first.equals("create")){
                    player.sendMessage(ChatColor.RED + "/hats create <id> <hat-name>");
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
                    meta.setDisplayName(entry.getValue().toString());

                    stack.setItemMeta(meta);
                    player.sendMessage(stack.getItemMeta().hasCustomModelData() + "k");
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
