/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.etar.entity.render;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.etar.entity.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.etar.entity.model.ModelSoldierEtarian;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSoldierEtarian extends RenderLiving<EntitySoldierEtarian>
{

    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/soldier_etarian.png");

    public RenderSoldierEtarian(RenderManager manager)
    {
        super(manager, new ModelSoldierEtarian(), 0.5F);
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
