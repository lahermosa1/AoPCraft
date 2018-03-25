/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.item.food;

import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;

import net.minecraft.item.ItemFood;

public class ItemBaseFood extends ItemFood implements IHasModel
{
    // ========== Constructor ==========
    public ItemBaseFood(String name, int amount, boolean isWolfFood)
        {
            super(amount, isWolfFood);
            setUnlocalizedName(name);
            setRegistryName(name);
            setMaxStackSize(16);
            setCreativeTab(AoPCraft.AOPCRAFTTAB);

            AoPItemInit.ITEMS.add(this);
        }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
