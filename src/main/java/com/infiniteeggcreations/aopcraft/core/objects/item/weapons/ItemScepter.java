/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.item.weapons;


import com.infiniteeggcreations.aopcraft.core.objects.item.ItemBase;


import net.minecraft.item.Item;


public class ItemScepter extends ItemBase
{

    public String name = "scepter";
    public final float attackDamage;

    public ItemScepter()
    {
        super("scepter");
        this.maxStackSize = 1;
        this.attackDamage = (0.2F);
    }

    //TODO: Figure out haw to conjure a small fireball that moves outwards!


    public Item setNoRepair()
    {
        canRepair = false;
        return this;
    }
}