/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.entity.render;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.entity.model.ModelSoldierEtarian;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSoldierEtarian extends RenderLiving<EntitySoldierEtarian>
{

    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPCraft.MODID + ":textures/entity/soldier_etarian.png");

    public RenderSoldierEtarian(RenderManager manager) {
        super(manager, new ModelSoldierEtarian(), 1.0F);
    }

        @Override
        protected ResourceLocation getEntityTexture(EntitySoldierEtarian entity)
        {
            return TEXTURES;
        }


        @Override
        protected void applyRotations(EntitySoldierEtarian entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
        {
            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        }

}
