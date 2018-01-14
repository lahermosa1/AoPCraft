package com.infiniteeggcreations.aopcraft.block;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockStoneRough extends Block {

    // My Block needs a constructor with arguments a String, for the name,
    // and a Material. Must call super(material) as well.
    public BlockStoneRough(String name, Material material)
    {
        super(material);

        // Returns the unlocalized name of the block with "tile." appended to the front.
        setUnlocalizedName(name);

        setRegistryName(name);

       //  Sets how many hits it takes to break a block.  For reference: Stone block has 1.5F Hardness.
        setHardness(1.0F);

        //  Reference: Wood or gold(0), stone(1), iron (2), diamond(3)
        setHarvestLevel("pick_axe", 0);

        //  Sets the the blocks resistance to explosions. TODO: Get reference value!
        //  Returns the object for convenience in constructing: setResistance(float).
        setResistance(1.0F);

        setCreativeTab(AoPCraftTabs.tabBlocks);
    }
}
