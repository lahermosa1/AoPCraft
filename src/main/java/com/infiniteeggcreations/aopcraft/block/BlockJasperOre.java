package com.infiniteeggcreations.aopcraft.block;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import com.infiniteeggcreations.aopcraft.init.AoPCraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Reference:
 * Making a custom ore block (drops items when harvested):
 */
public class BlockJasperOre extends Block {

    // Constructors:
    public BlockJasperOre(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(4.0F);
        setResistance(5.0F);
        setHarvestLevel("pick_axe", 2);
        setCreativeTab(AoPCraftTabs.tabBlocks);

    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return AoPCraftItems.jasper;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }
}
