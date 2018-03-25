/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.danuk.entity.render;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityFamiliar;
import com.infiniteeggcreations.aopcraft.danuk.entity.model.ModelFamiliar;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFamiliar extends RenderLiving<EntityFamiliar>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/danuk/familiar.png");

    public RenderFamiliar(RenderManager manager)
    {
        super(manager, new ModelFamiliar(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFamiliar entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityFamiliar entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
