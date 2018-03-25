/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.danuk.entity;

import com.infiniteeggcreations.aopcraft.core.entity.EntityMagicUser;
import com.infiniteeggcreations.aopcraft.core.entity.EntityMobFriendly;
import com.infiniteeggcreations.aopcraft.core.lib.AoPLootTables;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;

import net.minecraft.init.SoundEvents;

import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import net.minecraft.world.World;


public class EntityCleric extends EntityMagicUser
{
    public EntityCleric(World worldIn)
    {
        super(worldIn);
        this.isImmuneToFire = true;
        this.setSize(0.6F, 2.0F);
        this.experienceValue = 10;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityCleric.AICastingSpell());
        this.tasks.addTask(2, new EntityCleric.AISummonSpell());
        this.tasks.addTask(3, new EntityCleric.AIAttackSpell());
        this.targetTasks.addTask(4, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(300));
        this.targetTasks.addTask(5, (new EntityAINearestAttackableTarget(this, EntityVillager.class, false)).setUnseenMemoryTicks(300));
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityMobFriendly.class, false));
        this.tasks.addTask(7, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 0.6D, 1.0D));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    public static void registerFixesCleric(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityCleric.class);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    protected ResourceLocation getLootTable()
    {
        return AoPLootTables.ENTITIES_CLERIC;
    }

    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
    }

    /**
     * Returns whether this Entity is on the same team as the given Entity.
     */
    public boolean isOnSameTeam(Entity entityIn)
    {
        if (entityIn == null)
        {
            return false;
        }
        else if (entityIn == this)
        {
            return true;
        }
        else if (super.isOnSameTeam(entityIn))
        {
            return true;
        }
        else if (entityIn instanceof EntityFamiliar)
        {
            return this.isOnSameTeam(((EntityFamiliar)entityIn).getOwner());
        }
        else if (entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getCreatureAttribute() == EnumCreatureAttribute.ILLAGER)
        {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        else
        {
            return false;
        }
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ENDERMEN_AMBIENT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_ENDERMEN_SCREAM;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_ENDERMEN_HURT;
    }


    protected SoundEvent getSpellSound()
    {
        return SoundEvents.ENTITY_BLAZE_SHOOT;
    }

    class AIAttackSpell extends EntityMagicUser.AIUseSpell
    {
        private AIAttackSpell()
        {
            super();
        }

        protected int getCastingTime()
        {
            return 40;
        }

        protected int getCastingInterval()
        {
            return 100;
        }

        protected void castSpell()
        {
            EntityLivingBase entitylivingbase = EntityCleric.this.getAttackTarget();
            double d0 = Math.min(entitylivingbase.posY, EntityCleric.this.posY);
            double d1 = Math.max(entitylivingbase.posY, EntityCleric.this.posY) + 1.0D;
            float f = (float) MathHelper.atan2(entitylivingbase.posZ - EntityCleric.this.posZ, entitylivingbase.posX - EntityCleric.this.posX);

            if (EntityCleric.this.getDistanceSq(entitylivingbase) < 9.0D)
            {
                for (int i = 0; i < 5; ++i)
                {
                    float f1 = f + (float)i * (float)Math.PI * 0.4F;
                    this.spawnSmallFireball(EntityCleric.this.posX + (double)MathHelper.cos(f1) * 1.5D, EntityCleric.this.posZ + (double)MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
                }

                for (int k = 0; k < 8; ++k)
                {
                    float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + ((float)Math.PI * 2F / 5F);
                    this.spawnSmallFireball(EntityCleric.this.posX + (double)MathHelper.cos(f2) * 2.5D, EntityCleric.this.posZ + (double)MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
                }
            }
            else
            {
                for (int l = 0; l < 16; ++l)
                {
                    double d2 = 1.25D * (double)(l + 1);
                    int j = l;
                    this.spawnSmallFireball(EntityCleric.this.posX + (double)MathHelper.cos(f) * d2, EntityCleric.this.posZ + (double)MathHelper.sin(f) * d2, d0, d1, f, j);
                }
            }
        }


        // ============================= SPELL_SMALL_FIREBALL SPELL =============================== //
        private void spawnSmallFireball(double p_190876_1_, double p_190876_3_, double p_190876_5_, double p_190876_7_, float p_190876_9_, int p_190876_10_)
        {
            BlockPos blockpos = new BlockPos(p_190876_1_, p_190876_7_, p_190876_3_);
            boolean flag = false;
            double d0 = 0.0D;

            while (true)
            {
                if (!EntityCleric.this.world.isBlockNormalCube(blockpos, true) && EntityCleric.this.world.isBlockNormalCube(blockpos.down(), true))
                {
                    if (!EntityCleric.this.world.isAirBlock(blockpos))
                    {
                        IBlockState iblockstate = EntityCleric.this.world.getBlockState(blockpos);
                        AxisAlignedBB axisalignedbb = iblockstate.getCollisionBoundingBox(EntityCleric.this.world, blockpos);

                        if (axisalignedbb != null)
                        {
                            d0 = axisalignedbb.maxY;
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.down();

                if (blockpos.getY() < MathHelper.floor(p_190876_5_) - 1)
                {
                    break;
                }
            }

            if (flag)
            {
                EntitySmallFireball entitysmallfireball = new EntitySmallFireball(EntityCleric.this.world, p_190876_1_, (double)blockpos.getY() + d0, p_190876_3_, p_190876_9_, p_190876_10_, p_190876_10_);
                EntityCleric.this.world.spawnEntity(entitysmallfireball);
            }
        }
        
        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.BLOCK_FIRE_AMBIENT;
        }

        protected EntityMagicUser.SpellType getSpellType()
        {
            return EntityMagicUser.SpellType.SPELL_SMALL_FIREBALL;
        }
    }

    // ============================= CASTING SPELL =============================== //
    class AICastingSpell extends EntityMagicUser.AICastingApell
    {
        private AICastingSpell()
        {
            super();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityCleric.this.getAttackTarget() != null)
            {
                EntityCleric.this.getLookHelper().setLookPositionWithEntity(EntityCleric.this.getAttackTarget(), (float)EntityCleric.this.getHorizontalFaceSpeed(), (float)EntityCleric.this.getVerticalFaceSpeed());
            }
        }
    }


    // ============================= SUMMON SPELL =============================== //
    class AISummonSpell extends EntityMagicUser.AIUseSpell
    {
        private AISummonSpell()
        {
            super();
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (!super.shouldExecute())
            {
                return false;
            }
            else
            {
                int i = EntityCleric.this.world.getEntitiesWithinAABB(EntityFamiliar.class, EntityCleric.this.getEntityBoundingBox().grow(16.0D)).size();
                return EntityCleric.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime()
        {
            return 100;
        }

        protected int getCastingInterval()
        {
            return 340;
        }

        protected void castSpell()
        {
            for (int i = 0; i < 3; ++i)
            {
                BlockPos blockpos = (new BlockPos(EntityCleric.this)).add(-2 + EntityCleric.this.rand.nextInt(5), 1, -2 + EntityCleric.this.rand.nextInt(5));
                EntityFamiliar entityfamiliar = new EntityFamiliar(EntityCleric.this.world);
                entityfamiliar.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                entityfamiliar.onInitialSpawn(EntityCleric.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData)null);
                entityfamiliar.setOwner(EntityCleric.this);
                entityfamiliar.setBoundOrigin(blockpos);
                entityfamiliar.setLimitedLife(20 * (30 + EntityCleric.this.rand.nextInt(90)));
                EntityCleric.this.world.spawnEntity(entityfamiliar);
            }
        }

        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.EVOCATION_ILLAGER_PREPARE_SUMMON;
        }

        protected EntityMagicUser.SpellType getSpellType()
        {
            return SpellType.SUMMON_FAMILIAR;
        }
    }
    
}