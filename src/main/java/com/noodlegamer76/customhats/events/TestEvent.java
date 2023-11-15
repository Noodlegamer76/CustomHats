package com.noodlegamer76.customhats.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TestEvent implements Listener {
    @EventHandler
    public void test(PlayerInteractEvent event) {
        if(event.getItem().getType() == Material.STICK) {
            event.getClickedBlock().getWorld().createExplosion(event.getClickedBlock().getLocation(), 4);
        }
    }
}
