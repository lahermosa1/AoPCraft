package com.infiniteeggcreations.aopcraft.item;

import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBucketLatex extends Item
{
    public ItemBucketLatex(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(64);
        setCreativeTab(AoPCraftTabs.tabMaterials);
    }
}