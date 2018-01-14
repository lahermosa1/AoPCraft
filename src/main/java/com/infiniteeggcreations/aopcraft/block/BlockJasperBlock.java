package com.infiniteeggcreations.aopcraft.block;


import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Reference:
 * Making a custom ore block (drops items when harvested):
 */
public class BlockJasperBlock extends Block {

    // Constructors:
    public BlockJasperBlock(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(4.0F);
        setResistance(5.0F);
        setHarvestLevel("pick_axe", 2);
        setCreativeTab(AoPCraftTabs.tabBlocks);

    }
}
