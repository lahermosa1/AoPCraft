/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.tools;

import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

/**
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY
 */
public class ToolSword extends ItemSword implements IHasModel
{
    protected final Item.ToolMaterial toolMaterial;

    // ========== Constructor ==========
    public ToolSword(String name, Item.ToolMaterial toolMaterial)
    {
        super(toolMaterial);
        this.toolMaterial = toolMaterial;
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(AoPCraftTabs.tabAoPCraft);

        AoPItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
