/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * TODO: ***.
 */

public class BlockMudBlockOrnate extends Block
{
    public BlockMudBlockOrnate(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(2.0F);
        setSoundType(SoundType.STONE);
        // stone is 1.5F
        setHarvestLevel("pick_axe", 1);
        // wood or gold(0), stone(1), iron (2), diamond(3)
        this.setCreativeTab(AoPCraftTabs.tabAoPCraft);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }
}