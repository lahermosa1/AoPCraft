/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.item;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.item.Item;

/**
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY
 */
public class ItemCounterCoin extends Item implements IHasModel
{

    // ========== Constructor ==========
    public ItemCounterCoin(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);

        AoPItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
