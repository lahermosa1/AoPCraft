/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.util.handlers;


import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import com.infiniteeggcreations.aopcraft.core.init.AoPBiomeInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;

import com.infiniteeggcreations.aopcraft.core.world.gen.WorldGenAoPTrees;
import com.infiniteeggcreations.aopcraft.core.world.gen.generators.WorldGenAoPOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * A class to register all mod items.
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY&t=26s
 */

@Mod.EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(AoPItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(AoPBlockInit.BLOCKS.toArray(new Block[0]));
    }


    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for (Item item : AoPItemInit.ITEMS)
        {
            if (item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }

        for (Block block : AoPBlockInit.BLOCKS)
        {
            if (block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void otherRegistries()
    {
        GameRegistry.registerWorldGenerator(new WorldGenAoPOres(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenAoPTrees(), 0);
        AoPBiomeInit.registerBiomes();

    }

}
