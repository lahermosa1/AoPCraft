/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.lib;

import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AoPCraftTabs extends CreativeTabs

// TODO:  Work on drawing GUI of Journal for the following purposes:
// For Hobbies (Art, Pets, Exploration), Jobs and Origin/Class stuff I will have a new UI opening from a book or
// something.  Maybe have the quest stuff there too.  Like the WarHammer Journal but interactive with tabs
// and stuff.

    // ========================================================================
    //                     - ONE TAB FOR ALL ITEMS FOR NOW -
    // ========================================================================
//TODO: Fix search bar!
    {
        public AoPCraftTabs(String label)
        {
            super("aopcrafttab");
        }

        public ItemStack getTabIconItem()
        {
            return new ItemStack(AoPItemInit.PHOENIX_EGG);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

}

