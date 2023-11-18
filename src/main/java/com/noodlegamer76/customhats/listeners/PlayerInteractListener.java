package com.noodlegamer76.customhats.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.EventListener;

public class PlayerInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public static void PlayerInteractEvent(PlayerInteractEvent event) {

        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        if (item != null && item.hasItemMeta() && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (item.getType() == Material.DIAMOND_HELMET && item.getItemMeta().hasCustomModelData()) {
                item.setType(Material.KNOWLEDGE_BOOK);
            }
            if (item.getType().equals(Material.KNOWLEDGE_BOOK)) {

                if (player.getInventory().getHelmet() == null) {
                    player.getInventory().setHelmet(item);
                    item.setAmount(0);
                }

                event.setCancelled(true);
            }
        }
    }
}
