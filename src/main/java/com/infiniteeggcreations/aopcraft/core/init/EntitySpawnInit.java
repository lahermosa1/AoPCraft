/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.init;

import com.infiniteeggcreations.aopcraft.aurorawoods.entity.EntityBandit;
import com.infiniteeggcreations.aopcraft.borna.entity.EntitySoldierBornan;
import com.infiniteeggcreations.aopcraft.core.entity.boss.EntityBossPhoenix;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityCleric;
import com.infiniteeggcreations.aopcraft.etar.entity.EntitySoldierEtarian;

import com.infiniteeggcreations.aopcraft.gardens.entity.EntityAnimistFemale;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.entity.EnumCreatureType.AMBIENT;
import static net.minecraft.entity.EnumCreatureType.CREATURE;
import static net.minecraft.entity.EnumCreatureType.MONSTER;
import static net.minecraftforge.common.BiomeDictionary.getBiomes;

@Mod.EventBusSubscriber
public class EntitySpawnInit
{
        @Mod.EventHandler
        public static void spawnInit()
        {
            //TODO: Trying to remove Vanilla Spawns.
        // ======================= Trying to remove Vanilla Spawns ======================== //
            //EntityRegistry.removeSpawn(EntitySkeleton.class, MONSTER);
            //EntityRegistry.removeSpawn(EntityZombie.class, MONSTER);
            //EntityRegistry.removeSpawn(EntityCreeper.class, MONSTER);
            //EntityRegistry.removeSpawn(EntityEnderman.class, MONSTER);

        // =========================== AoP BIOME CHARACTERISTICS =========================== //
            // Aurora Woods:
            Set<Biome> aurorawoods = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.MAGICAL));
            aurorawoods.retainAll(getBiomes(BiomeDictionary.Type.FOREST));
            aurorawoods.retainAll(getBiomes(BiomeDictionary.Type.DENSE));

            // The Gardens:
            Set<Biome> gardens = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.JUNGLE));
            gardens.retainAll(getBiomes(BiomeDictionary.Type.WET));
            gardens.retainAll(getBiomes(BiomeDictionary.Type.HOT));
            gardens.retainAll(getBiomes(BiomeDictionary.Type.DENSE));
            gardens.retainAll(getBiomes(BiomeDictionary.Type.LUSH));

            // The Absence Mire:
            Set<Biome> absencemire = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.SWAMP));
            absencemire.retainAll(getBiomes(BiomeDictionary.Type.HOT));
            absencemire.retainAll(getBiomes(BiomeDictionary.Type.WET));

            // Etar:
            Set<Biome> etar = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.CONIFEROUS));
            etar.retainAll(getBiomes(BiomeDictionary.Type.HILLS));
            etar.retainAll(getBiomes(BiomeDictionary.Type.SPARSE));

            // The Northern Peaks:
            Set<Biome> northernpeaks = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.MOUNTAIN));
            northernpeaks.retainAll(getBiomes(BiomeDictionary.Type.SPARSE));
            northernpeaks.retainAll(getBiomes(BiomeDictionary.Type.COLD));
            northernpeaks.retainAll(getBiomes(BiomeDictionary.Type.SNOWY));

            // The Northern Plains:
            Set<Biome> northernplains = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.SPARSE));
            northernplains.retainAll(getBiomes(BiomeDictionary.Type.HILLS));

            // Borna:
            Set<Biome> borna = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.PLAINS));
            borna.retainAll(getBiomes(BiomeDictionary.Type.FOREST));

            // The Plains:
            Set<Biome> plains = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.SAVANNA));
            plains.retainAll(getBiomes(BiomeDictionary.Type.SPARSE));
            plains.retainAll(getBiomes(BiomeDictionary.Type.DRY));

            // Danuk:
            Set<Biome> danuk = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.WASTELAND));
            danuk.retainAll(getBiomes(BiomeDictionary.Type.DRY));
            danuk.retainAll(getBiomes(BiomeDictionary.Type.DEAD));
            danuk.retainAll(getBiomes(BiomeDictionary.Type.END));
            danuk.retainAll(getBiomes(BiomeDictionary.Type.SANDY));

            // The Grasslands:
            Set<Biome> grasslands = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.PLAINS));
            grasslands.retainAll(getBiomes(BiomeDictionary.Type.DENSE));

            // The Bone Forest:
            Set<Biome> boneforest = new HashSet<Biome>(getBiomes(BiomeDictionary.Type.SPOOKY));
            boneforest.retainAll(getBiomes(BiomeDictionary.Type.DEAD));


        // ================================ AoP SPAWNS =============================== //
            // Bandit:
            EntityRegistry.addSpawn(EntityBandit.class, 10, 1, 4, AMBIENT, getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[0]));

            // Cleric:
            EntityRegistry.addSpawn(EntityCleric.class, 7, 1, 3, AMBIENT, getBiomes(BiomeDictionary.Type.WASTELAND).toArray(new Biome[0]));
            EntityRegistry.addSpawn(EntityCleric.class, 3, 1, 1, AMBIENT, getBiomes(BiomeDictionary.Type.END).toArray(new Biome[0]));

            // Etarian Soldier:
            EntityRegistry.addSpawn(EntitySoldierEtarian.class, 7, 4, 4, AMBIENT, getBiomes(BiomeDictionary.Type.CONIFEROUS).toArray(new Biome[0]));
            EntityRegistry.addSpawn(EntitySoldierEtarian.class, 3, 4, 4, AMBIENT, getBiomes(BiomeDictionary.Type.HILLS).toArray(new Biome[0]));

            // Bornan Soldier:
            EntityRegistry.addSpawn(EntitySoldierBornan.class, 8, 4, 4, AMBIENT, getBiomes(BiomeDictionary.Type.PLAINS).toArray(new Biome[0]));
            EntityRegistry.addSpawn(EntitySoldierBornan.class, 1, 4, 4, AMBIENT, getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[0]));

            // Animist Female:
            EntityRegistry.addSpawn(EntityAnimistFemale.class, 20, 1, 2, AMBIENT, getBiomes(BiomeDictionary.Type.JUNGLE).toArray(new Biome[0]));
            EntityRegistry.addSpawn(EntityAnimistFemale.class, 10, 1, 3, AMBIENT, getBiomes(BiomeDictionary.Type.HOT).toArray(new Biome[0]));


            // ================================= BOSSES =======================================
            // The Phoenix:
            //EntityRegistry.addSpawn(EntityBossPhoenix.class, 1, 1, 1, MONSTER, getBiomes(BiomeDictionary.Type.WASTELAND).toArray(new Biome[0]));
            //EntityRegistry.addSpawn(EntityBossPhoenix.class, 1, 1, 1, MONSTER, getBiomes(BiomeDictionary.Type.NETHER).toArray(new Biome[0]));
            //EntityRegistry.addSpawn(EntityBossPhoenix.class, 1, 1, 1, MONSTER, getBiomes(BiomeDictionary.Type.END).toArray(new Biome[0]));

        }
}
