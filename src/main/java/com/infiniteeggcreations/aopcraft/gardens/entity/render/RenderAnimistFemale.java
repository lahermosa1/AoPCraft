/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.gardens.entity.render;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.gardens.entity.EntityAnimistFemale;
import com.infiniteeggcreations.aopcraft.gardens.entity.model.ModelAnimistFemale;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;


public class RenderAnimistFemale extends RenderLiving<EntityAnimistFemale>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/gardens/animist_female.png");

    public RenderAnimistFemale(RenderManager manager)
    {
        super(manager, new ModelAnimistFemale(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAnimistFemale entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityAnimistFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
