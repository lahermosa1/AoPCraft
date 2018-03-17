/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.biomes;

import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.util.handlers.EnumHandler;
import com.infiniteeggcreations.aopcraft.core.world.gen.generators.WorldGenAuroraTree;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntityBandit;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntitySoldierEtarian;
import com.infiniteeggcreations.aopcraft.objects.block.BlockOres;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * https://www.youtube.com/watch?v=ejhdLJDo2DE
 */
public class BiomeAuroraWoods extends Biome
{
    protected static final WorldGenAbstractTree TREE = new WorldGenAuroraTree();

    public BiomeAuroraWoods()
    {

        super(new BiomeProperties("Aurora Woods").setTemperature(0.6F).setRainfall(0.6F));

        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = AoPBlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AURORA_WOODS);
        fillerBlock = AoPBlockInit.ROUGH_STONE_BLOCK.getDefaultState();

        this.decorator.lapisGen = new WorldGenMinable(AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState(), 5);
        this.decorator.gravelGen = new WorldGenMinable(AoPBlockInit.JASPER_ORE_BLOCK.getDefaultState(), 5);
        this.decorator.graniteGen = new WorldGenMinable(AoPBlockInit.ROUGH_BLUE_GRANITE_BLOCK.getDefaultState(), 5);
        this.decorator.andesiteGen = new WorldGenMinable(AoPBlockInit.ROUGH_MARBLE_BLOCK.getDefaultState(), 5);
        this.decorator.dioriteGen = new WorldGenMinable(AoPBlockInit.SERPENTINITE_ORE_BLOCK.getDefaultState(), 10);
        this.decorator.clayGen = new WorldGenMinable(AoPBlockInit.MUD_BLOCK.getDefaultState(), 20);
        this.decorator.ironGen = new WorldGenMinable(AoPBlockInit.COPPER_ORE_BLOCK.getDefaultState(), 10);

        this.decorator.treesPerChunk = 2;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityBandit.class, 10, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySoldierEtarian.class, 5, 1, 2));

    }
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return TREE;
    }
}
