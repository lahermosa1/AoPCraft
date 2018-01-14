package com.infiniteeggcreations.aopcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRubber extends Item {

    public ItemRubber(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
