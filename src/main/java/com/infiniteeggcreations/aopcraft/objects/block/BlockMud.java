/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * TODO: ***.
 */

public class BlockMud extends Block
{
    public BlockMud(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(1.0F);
        setSoundType(SoundType.SLIME);
        // stone is 1.5F
        setHarvestLevel("shovel", 0);
        // wood or gold(0), stone(1), iron (2), diamond(3)
        this.setCreativeTab(AoPCraftTabs.tabAoPCraft);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }


    /**
     * Called When an Entity Collided with the Block (from SoulSand)
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {

        // SoulSand has 0.4D
        entityIn.motionX *= 0.8D;
        entityIn.motionZ *= 0.8D;
    }
}