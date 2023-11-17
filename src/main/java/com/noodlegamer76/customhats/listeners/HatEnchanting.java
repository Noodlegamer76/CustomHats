package com.noodlegamer76.customhats.listeners;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class HatEnchanting implements Listener {
    @EventHandler
    public static void prepareEnchantingTableListener(PrepareItemEnchantEvent event) {
        ItemStack item = event.getItem();


        if (item.hasItemMeta()) {
            if (item.getType() == Material.KNOWLEDGE_BOOK && item.getItemMeta().hasCustomModelData()) {
                item.setType(Material.DIAMOND_HELMET);
            }
        }
    }

    @EventHandler
    public static void inventoryInteract(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        HumanEntity player = event.getWhoClicked();
        ItemStack cursor = event.getCursor();


        if (item != null) {
            if(item.hasItemMeta()) {
                if (item.getType() == Material.DIAMOND_HELMET && item.getItemMeta().hasCustomModelData()) {
                    item.setType(Material.KNOWLEDGE_BOOK);
                }
            }
        }
        if (cursor != null) {
            if(cursor.hasItemMeta()) {
                if (cursor.getType() == Material.KNOWLEDGE_BOOK && cursor.getItemMeta().hasCustomModelData()) {
                    if (event.getSlot() == 39 && player.getInventory().getHelmet() == null) {
                        player.getInventory().setHelmet(cursor);
                        cursor.setAmount(0);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public static void prepareAnvilListener(PrepareAnvilEvent event) {
        ItemStack item = event.getInventory().getItem(0);


        if (item != null) {
            if (item.hasItemMeta()) {
                if (item.getType() == Material.KNOWLEDGE_BOOK && item.getItemMeta().hasCustomModelData()) {
                    item.setType(Material.DIAMOND_HELMET);
                }
            }
        }
    }


}
