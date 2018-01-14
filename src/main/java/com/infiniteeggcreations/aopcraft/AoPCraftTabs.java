package com.infiniteeggcreations.aopcraft;

import com.infiniteeggcreations.aopcraft.init.AoPCraftBlocks;
import com.infiniteeggcreations.aopcraft.init.AoPCraftItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AoPCraftTabs {

// TODO:  Work on drawing GUI of Journal for the following purposes:
// For Hobbies (Art, Pets, Exploration), Jobs and Origin/Class stuff I will have a new UI opening from a book or
// something.  Maybe have the quest stuff there too.  Like the WarHammer Journal but interactive with tabs
// and stuff.

    // ========================================================================
    //                              - BLOCKS -
    // ========================================================================
    public static final CreativeTabs tabBlocks = new CreativeTabs("tabBlocks")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPCraftBlocks.aurora_leaves);
        }
    };

    // ========================================================================
    //                             - ITEMS -
    // ========================================================================
    public static final CreativeTabs tabItems = new CreativeTabs("tabItems")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPCraftItems.phoenix_feather);
        }
    };
    // ========================================================================
    //                          -  COMBAT -
    //                        (Armor, Weapons)
    // ========================================================================
    public static final CreativeTabs tabCombat = new CreativeTabs("tabCombat")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPCraftItems.phoenix_sword);
        }
    };

    // ========================================================================
    //                          -  CONSUMABLES -
    //                       (Food, Drinks, Potions)
    // ========================================================================
    public static final CreativeTabs tabConsumables = new CreativeTabs("tabConsumables")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPCraftItems.deviled_egg);
        }
    };

    // ========================================================================
    //                          -  MATERIALS -
    //      (Crafting Mats/Reagents/Ingredients/Ore/Wood, Tools, Equipment)
    // ========================================================================
    public static final CreativeTabs tabMaterials = new CreativeTabs("tabMaterials")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPCraftItems.silver);
        }
    };
}
