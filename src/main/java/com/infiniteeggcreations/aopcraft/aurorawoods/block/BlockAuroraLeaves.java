/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.aurorawoods.block;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

import java.util.List;

//TODO: Fix this so it generates in the world.
public class BlockAuroraLeaves extends BlockLeaves implements IHasModel
{
    public BlockAuroraLeaves(String name)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);

        AoPBlockInit.BLOCKS.add(this);
        AoPItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta)
    {
        return null;
    }


    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return null;
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
