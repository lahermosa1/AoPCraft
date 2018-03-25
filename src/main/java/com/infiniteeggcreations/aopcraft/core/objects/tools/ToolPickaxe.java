/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.tools;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.item.ItemPickaxe;

/**
 * Reference: https://www.youtube.com/watch?v=JXAU9VnJNC0&index=5&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
 */
public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
    public ToolPickaxe(String name, ToolMaterial material)
    {
        // ========== Constructor ==========
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);

        AoPItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
