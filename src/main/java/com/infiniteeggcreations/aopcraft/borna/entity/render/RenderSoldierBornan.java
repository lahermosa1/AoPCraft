/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.borna.entity.render;

import com.infiniteeggcreations.aopcraft.borna.entity.EntitySoldierBornan;
import com.infiniteeggcreations.aopcraft.borna.entity.model.ModelSoldierBornan;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

// 1st                                                     // 2nd
public class RenderSoldierBornan extends RenderLiving<EntitySoldierBornan>
{
    // 8th (2nd to last: add resource location to tell the game where the texture is)
    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/borna/soldier_bornan.png");

    // 3rd
    public RenderSoldierBornan(RenderManager manager)
    {
               // 4th             5th                    6th
        super(manager, new ModelSoldierBornan(), 0.5F);
    }

    // 7th
    @Override
    protected ResourceLocation getEntityTexture(EntitySoldierBornan entity)
    {
        return TEXTURES;
    }

    // 9th, Finally, apply rotations: Start typing "applyRotations" w/o quotation marks and then hit Enter when it automatically fills.  It will override as well.
    @Override
    protected void applyRotations(EntitySoldierBornan entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
