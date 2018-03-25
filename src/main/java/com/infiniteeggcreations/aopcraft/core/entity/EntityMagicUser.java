/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.entity;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public abstract class EntityMagicUser extends AbstractIllager
{
    private static final DataParameter<Byte> SPELL = EntityDataManager.<Byte>createKey(EntityMagicUser.class, DataSerializers.BYTE);
    protected int spellTicks;
    private EntityMagicUser.SpellType activeSpell = EntityMagicUser.SpellType.NONE;

    public EntityMagicUser(World p_i47506_1_)
    {
        super(p_i47506_1_);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(SPELL, (byte) 0);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.spellTicks = compound.getInteger("SpellTicks");
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("SpellTicks", this.spellTicks);
    }

    @SideOnly(Side.CLIENT)
    public AbstractIllager.IllagerArmPose getArmPose()
    {
        return this.isSpellcasting() ? AbstractIllager.IllagerArmPose.SPELLCASTING : AbstractIllager.IllagerArmPose.CROSSED;
    }

    public boolean isSpellcasting()
    {
        if (this.world.isRemote)
        {
            return (Byte) this.dataManager.get(SPELL) > 0;
        }
        else
        {
            return this.spellTicks > 0;
        }
    }

    public void setSpellType(EntityMagicUser.SpellType spellType)
    {
        this.activeSpell = spellType;
        this.dataManager.set(SPELL, (byte) spellType.id);
    }

    protected EntityMagicUser.SpellType getSpellType()
    {
        return !this.world.isRemote ? this.activeSpell : EntityMagicUser.SpellType.getFromId((Byte) this.dataManager.get(SPELL));
    }

    protected void updateAITasks()
    {
        super.updateAITasks();

        if (this.spellTicks > 0)
        {
            --this.spellTicks;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote && this.isSpellcasting())
        {
            EntityMagicUser.SpellType entitymagicuser$spelltype = this.getSpellType();
            double d0 = entitymagicuser$spelltype.particleSpeed[0];
            double d1 = entitymagicuser$spelltype.particleSpeed[1];
            double d2 = entitymagicuser$spelltype.particleSpeed[2];
            float f = this.renderYawOffset * 0.017453292F + MathHelper.cos((float)this.ticksExisted * 0.6662F) * 0.25F;
            float f1 = MathHelper.cos(f);
            float f2 = MathHelper.sin(f);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (double)f1 * 0.6D, this.posY + 1.8D, this.posZ + (double)f2 * 0.6D, d0, d1, d2);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX - (double)f1 * 0.6D, this.posY + 1.8D, this.posZ - (double)f2 * 0.6D, d0, d1, d2);
        }
    }

    protected int getSpellTicks()
    {
        return this.spellTicks;
    }

    protected abstract SoundEvent getSpellSound();

    public class AICastingApell extends EntityAIBase
    {
        public AICastingApell()
        {
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityMagicUser.this.getSpellTicks() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            EntityMagicUser.this.navigator.clearPath();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            super.resetTask();
            EntityMagicUser.this.setSpellType(EntityMagicUser.SpellType.NONE);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityMagicUser.this.getAttackTarget() != null)
            {
                EntityMagicUser.this.getLookHelper().setLookPositionWithEntity(EntityMagicUser.this.getAttackTarget(), (float)EntityMagicUser.this.getHorizontalFaceSpeed(), (float)EntityMagicUser.this.getVerticalFaceSpeed());
            }
        }
    }

    public abstract class AIUseSpell extends EntityAIBase
    {
        protected int spellWarmup;
        protected int spellCooldown;

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (EntityMagicUser.this.getAttackTarget() == null)
            {
                return false;
            }
            else if (EntityMagicUser.this.isSpellcasting())
            {
                return false;
            }
            else
            {
                return EntityMagicUser.this.ticksExisted >= this.spellCooldown;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityMagicUser.this.getAttackTarget() != null && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.spellWarmup = this.getCastWarmupTime();
            EntityMagicUser.this.spellTicks = this.getCastingTime();
            this.spellCooldown = EntityMagicUser.this.ticksExisted + this.getCastingInterval();
            SoundEvent soundevent = this.getSpellPrepareSound();

            if (soundevent != null)
            {
                EntityMagicUser.this.playSound(soundevent, 1.0F, 1.0F);
            }

            EntityMagicUser.this.setSpellType(this.getSpellType());
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            --this.spellWarmup;

            if (this.spellWarmup == 0)
            {
                this.castSpell();
                EntityMagicUser.this.playSound(EntityMagicUser.this.getSpellSound(), 1.0F, 1.0F);
            }
        }

        protected abstract void castSpell();

        protected int getCastWarmupTime()
        {
            return 20;
        }

        protected abstract int getCastingTime();

        protected abstract int getCastingInterval();

        @Nullable
        protected abstract SoundEvent getSpellPrepareSound();

        protected abstract EntityMagicUser.SpellType getSpellType();
    }

    public static enum SpellType
    {
        NONE(0, 0.0D, 0.0D, 0.0D),
        // replace summon vex:
        SUMMON_FAMILIAR(1, 0.7D, 0.7D, 0.8D),
        // replace fangs:
        SPELL_SMALL_FIREBALL(2, 0.4D, 0.3D, 0.35D),
        WOLOLO(3, 0.7D, 0.5D, 0.2D),
        DISAPPEAR(4, 0.3D, 0.3D, 0.8D),
        BLINDNESS(5, 0.1D, 0.1D, 0.2D);

        private final int id;
        /** Particle motion speed. An array with 3 values: x, y, and z. */
        private final double[] particleSpeed;

        private SpellType(int idIn, double xParticleSpeed, double yParticleSpeed, double zParticleSpeed)
        {
            this.id = idIn;
            this.particleSpeed = new double[] {xParticleSpeed, yParticleSpeed, zParticleSpeed};
        }

        public static EntityMagicUser.SpellType getFromId(int idIn)
        {
            for (EntityMagicUser.SpellType entitymagicuser$spelltype : values())
            {
                if (idIn == entitymagicuser$spelltype.id)
                {
                    return entitymagicuser$spelltype;
                }
            }

            return NONE;
        }
    }
}