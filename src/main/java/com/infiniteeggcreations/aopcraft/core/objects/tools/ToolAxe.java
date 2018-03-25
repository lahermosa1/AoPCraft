/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.tools;

import com.google.common.collect.Sets;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

/**
 * Reference: https://www.youtube.com/watch?v=JXAU9VnJNC0&index=5&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
 */
public class ToolAxe extends ItemTool implements IHasModel
{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, AoPBlockInit.AURORA_LEAVES_BLOCK, AoPBlockInit.AURORA_PLANKS_BLOCK, AoPBlockInit.AURORA_LOG_BLOCK);

    public ToolAxe(String name, Item.ToolMaterial material)
    {
        super(material, EFFECTIVE_ON);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);

        AoPItemInit.ITEMS.add(this);
    }

    //public float getStrVsBlock(ItemStack stack, IBlockState state)
    //{
    //    Material material = state.getMaterial();
    //    return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
   // }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}