package com.infiniteeggcreations.aopcraft.block;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockAuroraLeaves extends Block {

    // My Block needs a constructor with arguments a String, for the name,
    // and a Material. Must call super(material) as well.
    public BlockAuroraLeaves(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(0.2F);
        // stone is 1.5F; leaves 0.2F

        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);
        setCreativeTab(AoPCraftTabs.tabBlocks);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.APPLE;
    }


    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
}
