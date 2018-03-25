/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.util.handlers;

import com.infiniteeggcreations.aopcraft.aurorawoods.entity.EntityBandit;
import com.infiniteeggcreations.aopcraft.aurorawoods.entity.render.RenderBandit;

import com.infiniteeggcreations.aopcraft.borna.entity.EntitySoldierBornan;
import com.infiniteeggcreations.aopcraft.borna.entity.render.RenderSoldierBornan;
import com.infiniteeggcreations.aopcraft.core.entity.boss.EntityBossPhoenix;
import com.infiniteeggcreations.aopcraft.core.entity.boss.render.RenderBossPhoenix;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityCleric;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityFamiliar;
import com.infiniteeggcreations.aopcraft.danuk.entity.render.RenderCleric;

import com.infiniteeggcreations.aopcraft.danuk.entity.render.RenderFamiliar;
import com.infiniteeggcreations.aopcraft.etar.entity.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.etar.entity.render.RenderSoldierEtarian;

import com.infiniteeggcreations.aopcraft.gardens.entity.EntityAnimistFemale;
import com.infiniteeggcreations.aopcraft.gardens.entity.render.RenderAnimistFemale;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;

import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * TODO: DO NOT DELETE THESE INSTRUCTIONS!!!
 * Reference: https://www.youtube.com/watch?v=p6FFl3yN18M&index=12&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
 * This one function class handles all Entity renders.  This registers the render and links it to our entity.  Type this out from scratch for each entity.  See instructions in the AoPReference class.
 */
public class RenderHandler
{
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
        RenderingRegistry.registerEntityRenderingHandler(EntityCleric.class, new IRenderFactory<EntityCleric>()
        {
            @Override
            public Render<? super EntityCleric> createRenderFor(RenderManager manager)
            {
                return new RenderCleric(manager);
            }
        });

        // ===================== SOLDIER ETARIAN ====================
        RenderingRegistry.registerEntityRenderingHandler(EntitySoldierEtarian.class, new IRenderFactory<EntitySoldierEtarian>()
        {
            @Override
            public Render<? super EntitySoldierEtarian> createRenderFor(RenderManager manager)
            {
                return new RenderSoldierEtarian(manager);
            }
        });

        // ===================== SOLDIER BORNAN ====================
        RenderingRegistry.registerEntityRenderingHandler(EntitySoldierBornan.class, new IRenderFactory<EntitySoldierBornan>()
        {
            @Override
            public Render<? super EntitySoldierBornan> createRenderFor(RenderManager manager)
            {
                return new RenderSoldierBornan(manager);
            }
        });

        // ===================== ANIMIST FEMALE ====================
        RenderingRegistry.registerEntityRenderingHandler(EntityAnimistFemale.class, new IRenderFactory<EntityAnimistFemale>()
        {
            @Override
            public Render<? super EntityAnimistFemale> createRenderFor(RenderManager manager)
            {
                return new RenderAnimistFemale(manager);
            }
        });

        // ===================== FAMILIAR =====================
        RenderingRegistry.registerEntityRenderingHandler(EntityFamiliar.class, new IRenderFactory<EntityFamiliar>()
        {
            @Override
            public Render<? super EntityFamiliar> createRenderFor(RenderManager manager)
            {
                return new RenderFamiliar(manager);
            }
        });


        // =======================================================================
        //                                  BOSSES
        // =======================================================================
            // The Phoenix:
            RenderingRegistry.registerEntityRenderingHandler(EntityBossPhoenix.class, new IRenderFactory<EntityBossPhoenix>()
            {
                @Override
                public Render<? super EntityBossPhoenix> createRenderFor(RenderManager manager)
                {
                    return new RenderBossPhoenix(manager);
                }
            });


    }
}
