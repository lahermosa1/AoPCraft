/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.entity.render;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntityCleric;
import com.infiniteeggcreations.aopcraft.entity.model.ModelCleric;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCleric extends RenderLiving<EntityCleric>
{

    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPCraft.MODID + ":textures/entity/cleric.png");

    public RenderCleric(RenderManager manager) {
        super(manager, new ModelCleric(), 1.0F);
    }

        @Override
        protected ResourceLocation getEntityTexture(EntityCleric entity)
        {
            return TEXTURES;
        }


        @Override
        protected void applyRotations(EntityCleric entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
        {
            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        }

}
