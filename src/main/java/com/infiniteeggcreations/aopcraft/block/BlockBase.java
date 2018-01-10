package com.infiniteeggcreations.aopcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block {

    // My Block needs a constructor with arguments a String, for the name,
    // and a Material. Must call super(material) as well.
    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        setHardness(1.5F);
        // stone is 1.5F

        setHarvestLevel("pick_axe", 0);
        // wood or gold(0), stone(1), iron (2), diamond(3)

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
