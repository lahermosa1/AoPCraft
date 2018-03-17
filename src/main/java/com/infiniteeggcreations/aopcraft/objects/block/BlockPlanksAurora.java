/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPlanksAurora extends Block
{

        // Constructors:
        public BlockPlanksAurora(String name, Material material)
        {
            super(material);
            setUnlocalizedName(name);
            setRegistryName(name);
            setHardness(3.0F);
            setResistance(4.0F);
            setHarvestLevel("axe", 2);
            setCreativeTab(AoPCraftTabs.tabAoPCraft);

        }
}