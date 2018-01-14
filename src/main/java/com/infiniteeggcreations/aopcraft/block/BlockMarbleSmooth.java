package com.infiniteeggcreations.aopcraft.block;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMarbleSmooth extends Block {

    // Constructors:
    public BlockMarbleSmooth(String name, Material material)
    {
        super(material);
        setHardness(5.0F);
        setResistance(7.0F);
        setHarvestLevel("pick_axe", 3);
        setCreativeTab(AoPCraftTabs.tabBlocks);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
