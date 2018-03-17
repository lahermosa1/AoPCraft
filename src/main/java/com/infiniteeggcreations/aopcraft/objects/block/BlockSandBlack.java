/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSandBlack extends BlockFalling {

    // My Block needs a constructor with arguments a String, for the name,
    // and a Material. Must call super(material) as well.
    public BlockSandBlack(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        setHardness(0.5F);
        // stone is 1.5F, leaves 0.2F

        setHarvestLevel("shovel", 0);
        // wood or gold(0), stone(1), iron (2), diamond(3)

        this.setSoundType(SoundType.SAND);
        setCreativeTab(AoPCraftTabs.tabAoPCraft);
    }
}
