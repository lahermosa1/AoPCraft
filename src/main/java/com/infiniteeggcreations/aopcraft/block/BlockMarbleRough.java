package com.infiniteeggcreations.aopcraft.block;

import com.infiniteeggcreations.aopcraft.init.AoPCraftItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Reference:
 * Making a custom ore block (drops items when harvested):
 */
public class BlockMarbleRough extends BlockBase {

    // Constructors:
    public BlockMarbleRough(String name, Material material)
    {
        super(name, material);
        setHardness(4.0F);
        setResistance(6.0F);
        setHarvestLevel("pick_axe", 2);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return AoPCraftItems.marble;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(6);
    }
}
