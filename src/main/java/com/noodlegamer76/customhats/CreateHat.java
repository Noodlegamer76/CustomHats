package com.noodlegamer76.customhats;

import com.noodlegamer76.customhats.files.HatsListFile;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class CreateHat {
    private static final String COMMON = ChatColor.BOLD + "" + ChatColor.WHITE + "Common";
    private static final String UNCOMMON = ChatColor.BOLD + "" + ChatColor.GREEN + "Uncommon";
    private static final String RARE = ChatColor.BOLD + "" + ChatColor.BLUE + "Rare";
    private static final String UBER = ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Uber";
    private static final String LEGENDARY = ChatColor.BOLD + "" + ChatColor.YELLOW + "Legendary";
    private static final String RCOMMON = "common";
    private static final String RUNCOMMON = "uncommon";
    private static final String RRARE = "rare";
    private static final String RUBER = "uber";
    private static final String RLEGENDARY = "legendary";
    private static FileConfiguration hats = HatsListFile.getHats();
    private static Map<String, Object> map = hats.getValues(false);

    public static ItemStack createHat() {
        HatsListFile.reload();


        ArrayList<ItemStack> hats = new ArrayList<>(1);
        ArrayList<ItemStack> hatscommon = new ArrayList<>(1);
        String rarity = randomRarity();
        System.out.println("CHOSEN: " + rarity);

        for (Map.Entry<String, Object> entry:map.entrySet()) {
            ItemStack stack = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
            ItemMeta meta = stack.getItemMeta();


            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR,
                    new AttributeModifier(UUID.randomUUID(), "armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
            meta.setCustomModelData(Integer.parseInt(entry.getKey()));
            List<String> values = HatsListFile.getHats().getStringList(entry.getKey());
            meta.setDisplayName(values.get(0));
            meta.setLore(List.of(ChatColor.BOLD + "" + ChatColor.WHITE + "Rarity: " + getRarityMessage(values.get(1))));

            stack.setItemMeta(meta);

            if (rarity.equals(values.get(1))) {
                hats.add(stack);
            }
            else if (RCOMMON.equals(values.get(1))) {
                hatscommon.add(stack);
            }
        }

        if (hats.isEmpty()) {
            if (hatscommon.size() >= 2) {
                return hatscommon.get(new Random().nextInt(0, hatscommon.size()));
            }
            else {
                return hatscommon.get(0);
            }
        }
        else {
            if (hats.size() >= 2) {
                return hats.get(new Random().nextInt(0, hats.size()));
            }
            else {
                return hats.get(0);
            }
        }
    }

    private static String randomRarity() {
        int rarity = 1;
        boolean again = true;
        for(;again && !(rarity >= 6);rarity++) {
            if (Math.random() > 0.5) again = false;
        }
        switch (rarity) {
            case 3: return RUNCOMMON;
            case 4: return RRARE;
            case 5: return RUBER;
            case 6: return RLEGENDARY;
            default: return RCOMMON;
        }
    }

    public static String getRarityMessage(String rarity) {
        if (rarity.equals("common")) return COMMON;
        if (rarity.equals("uncommon")) return UNCOMMON;
        if (rarity.equals("rare")) return RARE;
        if (rarity.equals("uber")) return UBER;
        if (rarity.equals("legendary")) return LEGENDARY;
        else return "UNKNOWN RARITY: PLEASE CONTACT NOODLEGAMER76 ";
    }
}
