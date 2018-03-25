/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.proxy;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.model.ModelLoader;

import java.util.Objects;


public class ClientProxy extends CommonProxy
{
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), id));
    }

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(AoPReference.MODID, filename), id));
    }

    //@Override
    //public void registerTileEntities() {}
    }

