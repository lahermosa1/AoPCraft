/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.aurorawoods.entity.render;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.aurorawoods.entity.EntityBandit;

import com.infiniteeggcreations.aopcraft.aurorawoods.entity.model.ModelBandit;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBandit extends RenderLiving<EntityBandit>
{

    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/bandit.png");

    public RenderBandit(RenderManager manager)
    {
        super(manager, new ModelBandit(), 0.5F);
    }

        @Override
        protected ResourceLocation getEntityTexture(EntityBandit entity)
        {
            return TEXTURES;
        }


        @Override
        protected void applyRotations(EntityBandit entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
        {
            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        }

}
