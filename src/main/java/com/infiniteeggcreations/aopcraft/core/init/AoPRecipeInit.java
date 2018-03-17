/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AoPRecipeInit {

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


        GameRegistry.addSmelting(AoPItemInit.BUCKET_LATEX, new ItemStack(AoPItemInit.RUBBER, 3), 0.5F);
        GameRegistry.addSmelting(Blocks.IRON_BLOCK, new ItemStack(AoPBlockInit.ORNATE_IRON_BLOCK, 1), 0.7F);
        GameRegistry.addSmelting(AoPBlockInit.MUD_BLOCK, new ItemStack(AoPBlockInit.MUD_BRICK_BLOCK, 1), 0.1F);
        GameRegistry.addSmelting(AoPBlockInit.SERPENTINITE_ORE_BLOCK, new ItemStack(AoPItemInit.SERPENTINITE_INGOT, 2),
                0.2F);
        GameRegistry.addSmelting(AoPBlockInit.AMETHYST_ORE_BLOCK, new ItemStack(AoPItemInit.AMETHYST, 2),
                0.2F);
        GameRegistry.addSmelting(AoPBlockInit.CITRINE_ORE_BLOCK, new ItemStack(AoPItemInit.CITRINE, 2),
                0.2F);
        GameRegistry.addSmelting(AoPBlockInit.COPPER_ORE_BLOCK, new ItemStack(AoPItemInit.COPPER_INGOT, 2),
                0.2F);
        GameRegistry.addSmelting(AoPBlockInit.JASPER_ORE_BLOCK, new ItemStack(AoPItemInit.JASPER, 4),
                0.2F);
        GameRegistry.addSmelting(AoPBlockInit.SILVER_ORE_BLOCK, new ItemStack(AoPItemInit.SILVER_INGOT, 1),
                0.2F);
       }
}
