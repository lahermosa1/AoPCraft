/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.entity.boss.render;

import com.infiniteeggcreations.aopcraft.core.entity.boss.EntityBossPhoenix;
import com.infiniteeggcreations.aopcraft.core.entity.boss.model.ModelBossPhoenix;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBossPhoenix extends RenderLiving<EntityBossPhoenix>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(AoPReference.MODID + ":textures/entity/boss_phoenix.png");

    public RenderBossPhoenix(RenderManager manager)
    {
        super(manager, new ModelBossPhoenix(), 1.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBossPhoenix entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBossPhoenix entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
