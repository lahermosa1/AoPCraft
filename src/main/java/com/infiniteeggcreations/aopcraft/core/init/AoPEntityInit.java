/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.init;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.entity.boss.EntityBossPhoenix;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;

import com.infiniteeggcreations.aopcraft.aurorawoods.entity.EntityBandit;
import com.infiniteeggcreations.aopcraft.borna.entity.EntitySoldierBornan;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityCleric;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityFamiliar;
import com.infiniteeggcreations.aopcraft.etar.entity.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.gardens.entity.EntityAnimistFemale;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 *  Reference: https://www.youtube.com/watch?v=p6FFl3yN18M&index=12&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
 *  RGB Decimal Colors -> Reference: https://en.wikipedia.org/wiki/Web_colors
 *              &  http://www.mathsisfun.com/hexadecimal-decimal-colors.html
 */
public class AoPEntityInit
{
    // ================== This calls the REGISTER ENTITY FUNCTION below ===================
        public static void registerEntities()
        {

            registerEntity("animist_female", EntityAnimistFemale.class, AoPReference.ENTITY_ANIMIST_FEMALE, 30, 65298, 12615424);

            registerEntity("bandit", EntityBandit.class, AoPReference.ENTITY_BANDIT, 20, 16753152, 7913983);

            registerEntity("boss_phoenix", EntityBossPhoenix.class, AoPReference.ENTITY_BOSS_PHOENIX, 60, 5439488, 12976128);

            registerEntity("cleric", EntityCleric.class, AoPReference.ENTITY_CLERIC, 30, 10485948, 16711875);

            registerEntity("familiar", EntityFamiliar.class, AoPReference.ENTITY_FAMILIAR, 40, 16776960, 16748032);

            registerEntity("soldier_bornan", EntitySoldierBornan.class, AoPReference.ENTITY_SOLDIER_BORNAN, 20, 162, 16773632);

            registerEntity("soldier_etarian", EntitySoldierEtarian.class, AoPReference.ENTITY_SOLDIER_ETARIAN, 20, 8420218, 0);


        }

     // ============================= REGISTER ENTITY FUNCTION ================================
        private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)

        {
            EntityRegistry.registerModEntity(new ResourceLocation(AoPReference.MODID + ":" + name), entity, name, id, AoPCraft.instance, range, 1, true, color1, color2);
        }

    }