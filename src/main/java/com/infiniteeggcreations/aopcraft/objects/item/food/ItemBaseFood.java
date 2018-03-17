/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.item.food;

import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;

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
            setCreativeTab(AoPCraftTabs.tabAoPCraft);

            AoPItemInit.ITEMS.add(this);
        }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
