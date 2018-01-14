package com.infiniteeggcreations.aopcraft.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AoPCraftRecipes {

    /**
     * A class to register all recipes.
     * Shaped and shapeless (crafting table) recipes need only a json in the assets.recipe folder.
     * Smelting recipes (furnace) go here in this class.
     * Cooking and armor recipes are all smelting(furnace) recipes.
     * This init method will register all of my mod recipes:
     *
     * REFERENCE: http://suppergerrie2.itsab.nl/minecraft-1-12-modding-with-forge-6-custom-recipes/
     */

    public static void init() {

        // Add smelting recipes with the following:
        // GameRegistry.addSmelting(ModItems.tutorialDust, new ItemStack(ModItems.tutorialIngot, 1), 1.5f);
        // The first # is the qty of Items needed (an int).
        // The second # is the amount of XP and is a float number.
        // For reference: diamond gives 1.0 XP.
        // The first Item is the material; the second Item is the result (output).


        GameRegistry.addSmelting(AoPCraftItems.bucket_latex, new ItemStack(AoPCraftItems.rubber, 3), 0.5F);
        GameRegistry.addSmelting(AoPCraftItems.serpentinite, new ItemStack(AoPCraftItems.serpentinite_ingot, 1),
                0.1F);
       }
}
