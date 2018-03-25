/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.aurorawoods.block;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.block.BlockSapling;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

//TODO: Add texture.
public class BlockAuroraSaplings extends BlockSapling implements IHasModel
{
    public BlockAuroraSaplings(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);

        AoPBlockInit.BLOCKS.add(this);
        AoPItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
