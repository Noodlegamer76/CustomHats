package com.noodlegamer76.customhats.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class HatEnchanting implements Listener {
    @EventHandler
    public static void prepareEnchantingTableListener(PrepareItemEnchantEvent event) {
        ItemStack item = event.getItem();


        if (item.hasItemMeta()) {
            event.getEnchanter().sendMessage( (item.getItemMeta().hasCustomModelData() + "BOOK INSETED"));
            if (item.getType() == Material.KNOWLEDGE_BOOK && item.getItemMeta().hasCustomModelData()) {
                item.setType(Material.DIAMOND_HELMET);
            }
        }
        else event.getEnchanter().sendMessage("no meta en");
    }

    @EventHandler
    public static void inventoryInteract(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();


        if(item.hasItemMeta()) {
            event.getWhoClicked().sendMessage((item.getItemMeta().hasCustomModelData() + "INV CLICK"));
            if (item.getType() == Material.DIAMOND_HELMET && item.getItemMeta().hasCustomModelData()) {
                item.setType(Material.KNOWLEDGE_BOOK);
            }
        }
        else event.getWhoClicked().sendMessage("no meta cl");
    }

    @EventHandler
    public static void prepareAnvilListener(PrepareAnvilEvent event) {
        ItemStack item = event.getInventory().getItem(0);


        if (item.hasItemMeta()) {
            event.getViewers().get(0).sendMessage( (item.getItemMeta().hasCustomModelData() + "BOOK INSETED ANVIL"));
            if (item.getType() == Material.KNOWLEDGE_BOOK && item.getItemMeta().hasCustomModelData()) {
                item.setType(Material.DIAMOND_HELMET);
            }
        }
        else event.getViewers().get(0).sendMessage("no meta AN");
    }
}
