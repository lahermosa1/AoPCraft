/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.util.handlers;

import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntityBandit;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntityCleric;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.entity.render.RenderBandit;
import com.infiniteeggcreations.aopcraft.entity.render.RenderCleric;
import com.infiniteeggcreations.aopcraft.entity.render.RenderSoldierEtarian;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders()
    {
        // ================== BANDIT ==================
        RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new IRenderFactory<EntityBandit>()
        {
            @Override
            public Render<? super EntityBandit> createRenderFor(RenderManager manager)
            {
                return new RenderBandit(manager);
            }
        });

        // ====================== CLERIC =====================
        RenderingRegistry.registerEntityRenderingHandler(EntityCleric.class, new IRenderFactory<EntityCleric>() {
            @Override
            public Render<? super EntityCleric> createRenderFor(RenderManager manager)
            {
                return new RenderCleric(manager);
            }
        });

        // ===================== SOLDIER ETARIAN ====================
        RenderingRegistry.registerEntityRenderingHandler(EntitySoldierEtarian.class, new IRenderFactory<EntitySoldierEtarian>() {
            @Override
            public Render<? super EntitySoldierEtarian> createRenderFor(RenderManager manager)
            {
                return new RenderSoldierEtarian(manager);
            }
        });


    }

}
