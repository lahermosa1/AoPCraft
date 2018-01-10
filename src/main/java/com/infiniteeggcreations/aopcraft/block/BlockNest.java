package com.infiniteeggcreations.aopcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockNest extends Block {

    // My Block needs a constructor with arguments a String, for the name,
    // and a Material. Must call super(material) as well.
    public BlockNest(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(3.0F);
        // stone is 1.5F
        setHarvestLevel("axe", 2);
        // wood or gold(0), stone(1), iron (2), diamond(3)
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.STICK;
    }


    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }
}
