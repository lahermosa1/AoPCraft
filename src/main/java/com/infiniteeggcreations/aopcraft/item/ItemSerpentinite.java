package com.infiniteeggcreations.aopcraft.item;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSerpentinite extends Item {

    public ItemSerpentinite(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AoPCraftTabs.tabMaterials);
        setMaxStackSize(64);
    }
}
