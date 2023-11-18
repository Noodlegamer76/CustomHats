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
            WanderingTrader trader = (WanderingTrader) event.getEntity();
            //trader.setRecipe(trader.getRecipeCount() - 1, new MerchantRecipe(CreateHat.createHat(), 1));
            List<MerchantRecipe> recipeList = trader.getRecipes();
            ArrayList<MerchantRecipe> recipes = new ArrayList<>(recipeList);
            MerchantRecipe recipe = new MerchantRecipe(CreateHat.createHat(), 1);
            recipe.addIngredient(new ItemStack(Material.DIAMOND_HELMET));
            switch ((int) (Math.random() * 10)) {
                case 1: recipe.addIngredient(new ItemStack(Material.DIAMOND, 6)); break;
                case 2: recipe.addIngredient(new ItemStack(Material.GOLD_INGOT, 12)); break;
                case 3: recipe.addIngredient(new ItemStack(Material.IRON_INGOT, 32)); break;
                case 4: recipe.addIngredient(new ItemStack(Material.NETHERITE_INGOT, 1)); break;
                case 5: recipe.addIngredient(new ItemStack(Material.DIAMOND, 16)); break;
                case 6: recipe.addIngredient(new ItemStack(Material.REDSTONE, 64)); break;
                case 7: recipe.addIngredient(new ItemStack(Material.ANVIL, 1)); break;
                case 8: recipe.addIngredient(new ItemStack(Material.DIAMOND, 12)); break;
                case 9: recipe.addIngredient(new ItemStack(Material.EMERALD, 16)); break;
                default: recipe.addIngredient(new ItemStack(Material.EMERALD, 12)); break;
            }
            recipes.add(recipe);
            trader.setRecipes(recipes);
        }
    }


}
