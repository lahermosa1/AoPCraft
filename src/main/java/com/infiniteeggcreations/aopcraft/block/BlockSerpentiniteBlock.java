package com.infiniteeggcreations.aopcraft.block;


import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Reference:
 * Making a custom ore block (drops items when harvested):
 */
public class BlockSerpentiniteBlock extends Block {

    // Constructors:
    public BlockSerpentiniteBlock(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(5.0F);
        setResistance(6.0F);
        setHarvestLevel("pick_axe", 3);
        setCreativeTab(AoPCraftTabs.tabBlocks);

    }
}
