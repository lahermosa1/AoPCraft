/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.tools;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.item.ItemHoe;

/**
 * Reference: https://www.youtube.com/watch?v=JXAU9VnJNC0&index=5&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
 */
public class ToolHoe extends ItemHoe implements IHasModel
{
    public ToolHoe(String name, ToolMaterial material)
    {
        // ========== Constructor ==========
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraftTabs.tabAoPCraft);

        AoPItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
