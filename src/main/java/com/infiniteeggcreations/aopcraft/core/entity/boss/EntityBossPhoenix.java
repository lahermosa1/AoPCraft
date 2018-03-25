/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.entity.boss;

import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBossPhoenix extends EntityDragon
{
    public EntityBossPhoenix(World worldIn)
    {
        super(worldIn);
        this.isBurning();
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_BOSS_PHOENIX;
    }
}
