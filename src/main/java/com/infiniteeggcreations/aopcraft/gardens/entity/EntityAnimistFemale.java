/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.gardens.entity;

import com.infiniteeggcreations.aopcraft.core.entity.EntityMobHostile;
import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAnimistFemale extends EntityMobHostile
{
    public EntityAnimistFemale(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 2.0F);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_CAT_HURT;
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CAT_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_ANIMIST_FEMALE;
    }
}
