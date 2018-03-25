/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.etar.entity;

import com.infiniteeggcreations.aopcraft.core.entity.EntityMobHostile;
import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySoldierEtarian extends EntityMobHostile
{
    public EntitySoldierEtarian(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8F, 2.8F);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_SOLDIER_ETARIAN;
    }
}
