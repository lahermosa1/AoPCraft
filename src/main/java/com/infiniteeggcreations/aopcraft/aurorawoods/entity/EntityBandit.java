/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.aurorawoods.entity;

import com.infiniteeggcreations.aopcraft.core.entity.EntityMobHostile;
import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBandit extends EntityMobHostile
{
    public EntityBandit(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8F, 2.0F);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_BANDIT;
    }
}
