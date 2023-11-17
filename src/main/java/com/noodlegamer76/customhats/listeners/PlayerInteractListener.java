package com.noodlegamer76.customhats.listeners;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.EventListener;

public class PlayerInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public static void PlayerInteractEvent(PlayerInteractEvent event) {

        ItemStack item = event.getItem();

        if (item != null) {
            if (item.getType().equals(Material.KNOWLEDGE_BOOK)) {

                event.setUseItemInHand(Event.Result.DENY);
                event.setCancelled(true);
            }
        }
    }
}
