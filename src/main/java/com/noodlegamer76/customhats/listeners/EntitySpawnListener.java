package com.noodlegamer76.customhats.listeners;

import com.noodlegamer76.customhats.CreateHat;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public static void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.WANDERING_TRADER) {
            System.out.println("trader spawn");
            WanderingTrader trader = (WanderingTrader) event.getEntity();
            //trader.setRecipe(trader.getRecipeCount() - 1, new MerchantRecipe(CreateHat.createHat(), 1));
            List<MerchantRecipe> recipeList = trader.getRecipes();
            ArrayList<MerchantRecipe> recipes = new ArrayList<>(recipeList);
            MerchantRecipe recipe = new MerchantRecipe(CreateHat.createHat(), 1);
            recipe.addIngredient(new ItemStack(Material.DIAMOND_HELMET));
            switch ((int) (Math.random() * 10)) {
                case 1: recipe.addIngredient(new ItemStack(Material.DIAMOND, 6));
                case 2: recipe.addIngredient(new ItemStack(Material.GOLD_INGOT, 12));
                case 3: recipe.addIngredient(new ItemStack(Material.IRON_INGOT, 32));
                case 4: recipe.addIngredient(new ItemStack(Material.NETHERITE_INGOT, 1));
                case 5: recipe.addIngredient(new ItemStack(Material.DIAMOND, 16));
                case 6: recipe.addIngredient(new ItemStack(Material.REDSTONE, 64));
                case 7: recipe.addIngredient(new ItemStack(Material.ANVIL, 1));
                case 8: recipe.addIngredient(new ItemStack(Material.DIAMOND, 12));
                case 9: recipe.addIngredient(new ItemStack(Material.EMERALD, 16));
                default: recipe.addIngredient(new ItemStack(Material.EMERALD, 12));
            }
            recipes.add(recipe);
            trader.setRecipes(recipes);
        }
    }


}
