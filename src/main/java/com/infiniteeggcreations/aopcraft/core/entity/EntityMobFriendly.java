/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class EntityMobFriendly extends EntityMob
{
    public EntityMobFriendly(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
        this.experienceValue = 4;
    }

    public float getEyeHeight()
    {
        return 1.74F;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityMobHostile.class, false));
        this.tasks.addTask(2, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }


    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    protected boolean canEquipItem(ItemStack stack)
    {
        return true;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    @Nullable
    protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering())
            {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Nullable
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
        }
    }

    @Override
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.AMBIENT;
    }


    @Override
    protected SoundEvent getSwimSound()
    {
        return SoundEvents.ENTITY_GENERIC_SWIM;
    }

    @Override
    protected SoundEvent getSplashSound()
    {
        return SoundEvents.ENTITY_GENERIC_SPLASH;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Nullable
    public boolean getCanSpawnHere()
    {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    @Override
    public boolean isPreventingPlayerRest(EntityPlayer playerIn)
    {
        return false;
    }

}
