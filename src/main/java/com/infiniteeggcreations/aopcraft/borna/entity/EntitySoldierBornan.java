/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.borna.entity;

import com.infiniteeggcreations.aopcraft.core.entity.EntityMobFriendly;
import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySoldierBornan extends EntityMobFriendly
{
    public EntitySoldierBornan(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 2.0F);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_SOLDIER_BORNAN;
    }
}
