/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.entity.mobs.hostile;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftLootTableList;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;


public class EntityCleric extends EntitySpellcasterIllager
{
    private int ghostTime;
    private final Vec3d[][] renderLocations;

    public EntityCleric(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3F, 2.5F);
        this.experienceValue = 5;
        this.renderLocations = new Vec3d[2][4];

        for (int i = 0; i < 4; ++i)
        {
            this.renderLocations[0][i] = new Vec3d(0.0D, 0.0D, 0.0D);
            this.renderLocations[1][i] = new Vec3d(0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AICastingApell());
        
        this.tasks.addTask(4, new EntityCleric.AIFlameSpell());
        this.tasks.addTask(5, new EntityCleric.AIMirriorSpell());
        this.tasks.addTask(6, new EntityCleric.AIBlindnessSpell());
        
        
        this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityCleric.class}));
        this.targetTasks.addTask(2, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(300));
        this.targetTasks.addTask(3, (new EntityAINearestAttackableTarget(this, EntityVillager.class, false)).setUnseenMemoryTicks(300));
        this.applyEntityAI();
    }



    protected void applyEntityAI()
    {

        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));

        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, true));

        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityZombie.class, true));

        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityBandit.class, true));

    }


    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory.
     *
     * The livingdata parameter is used to pass data between all instances during a pack spawn. It will be null on the
     * first call. Subclasses may check if it's null, and then create a new one and return it if so, initializing all
     * entities in the pack with the contained data.
     *
     * @return The IEntityLivingData to pass to this method for other instances of this entity class within the same
     * pack
     *
     * @param difficulty The current local difficulty
     * @param livingdata Shared spawn data. Will usually be null. (See return value for more information)
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(AoPItemInit.SCEPTER));
        return super.onInitialSpawn(difficulty, livingdata);
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return AoPCraftLootTableList.ENTITIES_CLERIC;
    }

    /**
     * Gets the bounding box of this Entity, adjusted to take auxiliary entities into account (e.g. the tile contained
     * by a minecart, such as a command block).
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return this.getEntityBoundingBox().grow(3.0D, 0.0D, 3.0D);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.world.isRemote && this.isInvisible())
        {
            --this.ghostTime;

            if (this.ghostTime < 0)
            {
                this.ghostTime = 0;
            }

            if (this.hurtTime != 1 && this.ticksExisted % 1200 != 0)
            {
                if (this.hurtTime == this.maxHurtTime - 1)
                {
                    this.ghostTime = 3;

                    for (int k = 0; k < 4; ++k)
                    {
                        this.renderLocations[0][k] = this.renderLocations[1][k];
                        this.renderLocations[1][k] = new Vec3d(0.0D, 0.0D, 0.0D);
                    }
                }
            }
            else
            {
                this.ghostTime = 3;
                float f = -6.0F;
                int i = 13;

                for (int j = 0; j < 4; ++j)
                {
                    this.renderLocations[0][j] = this.renderLocations[1][j];
                    this.renderLocations[1][j] = new Vec3d((double)(-6.0F + (float)this.rand.nextInt(13)) * 0.5D, (double)Math.max(0, this.rand.nextInt(6) - 4), (double)(-6.0F + (float)this.rand.nextInt(13)) * 0.5D);
                }

                for (int l = 0; l < 16; ++l)
                {
                    this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
                }

                this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ILLAGER_MIRROR_MOVE, this.getSoundCategory(), 1.0F, 1.0F, false);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Vec3d[] getRenderLocations(float p_193098_1_)
    {
        if (this.ghostTime <= 0)
        {
            return this.renderLocations[1];
        }
        else
        {
            double d0 = (double)(((float)this.ghostTime - p_193098_1_) / 3.0F);
            d0 = Math.pow(d0, 0.25D);
            Vec3d[] avec3d = new Vec3d[4];

            for (int i = 0; i < 4; ++i)
            {
                avec3d[i] = this.renderLocations[1][i].scale(1.0D - d0).add(this.renderLocations[0][i].scale(d0));
            }

            return avec3d;
        }
    }

    /**
     * Returns whether this Entity is on the same team as the given Entity.
     */
    public boolean isOnSameTeam(Entity entityIn)
    {
        if (super.isOnSameTeam(entityIn))
        {
            return true;
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

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ILLUSION_ILLAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_ILLAGER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_ILLUSION_ILLAGER_HURT;
    }

    protected SoundEvent getSpellSound()
    {
        return SoundEvents.ENTITY_ILLAGER_CAST_SPELL;
    }

    @SideOnly(Side.CLIENT)
    public boolean isAggressive()
    {
        return this.isAggressive(1);
    }

    public void setSwingingArms(boolean swingingArms)
    {
        this.setAggressive(1, swingingArms);
    }

    @SideOnly(Side.CLIENT)
    public IllagerArmPose getArmPose()
    {
        if (this.isSpellcasting())
        {
            return IllagerArmPose.SPELLCASTING;
        }
        else
        {
            return this.isAggressive() ? IllagerArmPose.BOW_AND_ARROW : IllagerArmPose.CROSSED;
        }
    }


    // ========================================================================
    //                           AIFlameSpell
    // ========================================================================
    class AIFlameSpell extends AIUseSpell
    {
        private int lastTargetId;

        public AIFlameSpell() 
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
            else if (EntityCleric.this.getAttackTarget() == null)
            {
                return false;
            }
            else if (EntityCleric.this.getAttackTarget().getEntityId() == this.lastTargetId)
            {
                return false;
            }
            else
            {
                return EntityCleric.this.world.getDifficultyForLocation(new BlockPos(EntityCleric.this)).isHarderThan((float)EnumDifficulty.PEACEFUL.ordinal());
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            this.lastTargetId = EntityCleric.this.getAttackTarget().getEntityId();
        }

        protected int getCastingTime()
        {
            return 3;
        }

        protected int getCastingInterval()
        {
            return 3;
        }

        protected void castSpell()
        {
            EntityCleric.this.getAttackTarget().setFire(5);
        }

        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE;
        }

        protected SpellType getSpellType()
        {
            return SpellType.NONE;
        }

    }


    
    // ========================================================================
    //                           AIBlindnessSpell
    // ========================================================================
    class AIBlindnessSpell extends AIUseSpell
    {
        private int lastTargetId;

        private AIBlindnessSpell()
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
            else if (EntityCleric.this.getAttackTarget() == null)
            {
                return false;
            }
            else if (EntityCleric.this.getAttackTarget().getEntityId() == this.lastTargetId)
            {
                return false;
            }
            else
            {
                return EntityCleric.this.world.getDifficultyForLocation(new BlockPos(EntityCleric.this)).isHarderThan((float)EnumDifficulty.NORMAL.ordinal());
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            this.lastTargetId = EntityCleric.this.getAttackTarget().getEntityId();
        }

        protected int getCastingTime()
        {
            return 1;
        }

        protected int getCastingInterval()
        {
            return 10;
        }

        protected void castSpell()
        {
            EntityCleric.this.getAttackTarget().addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 3));
        }

        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.ENTITY_ILLAGER_PREPARE_BLINDNESS;
        }

        protected SpellType getSpellType()
        {
            return SpellType.BLINDNESS;
        }
    }


    // ========================================================================
    //                           AIMirriorSpell (Mirror?)
    // ========================================================================
    class AIMirriorSpell extends AIUseSpell
    {
        private AIMirriorSpell()
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
                return !EntityCleric.this.isPotionActive(MobEffects.INVISIBILITY);
            }
        }

        protected int getCastingTime()
        {
            return 5;
        }

        protected int getCastingInterval()
        {
            return 20;
        }

        protected void castSpell()
        {
            EntityCleric.this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 5));
        }

        @Nullable
        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.BLOCK_PORTAL_AMBIENT;
        }

        protected SpellType getSpellType()
        {
            return SpellType.DISAPPEAR;
        }
    }
}