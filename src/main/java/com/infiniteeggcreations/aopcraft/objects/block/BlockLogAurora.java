/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;


public class BlockLogAurora extends BlockLog
{
    public BlockLogAurora(String name, Material material)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(1.0F);
        setHarvestLevel("axe", 0);
        setResistance(1.0F);
        setCreativeTab(AoPCraftTabs.tabAoPCraft);
    }
}