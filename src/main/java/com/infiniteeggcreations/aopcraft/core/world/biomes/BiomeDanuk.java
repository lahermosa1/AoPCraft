/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.biomes;

import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.danuk.entity.EntityCleric;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenSand;

/**
 * https://www.youtube.com/watch?v=ejhdLJDo2DE
 */
public class BiomeDanuk extends Biome
{
    public BiomeDanuk()
    {

        super(new BiomeProperties("Danuk").setBaseHeight(0.225F).setHeightVariation(0.25F).setTemperature(0.2F).setRainDisabled().setWaterColor(112427));

        topBlock = AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState();

        // TODO: Trying to add more types of blocks underneath top.
        // Vanilla:
        fillerBlock = Blocks.DIRT.getDefaultState();
        fillerBlock = Blocks.DIAMOND_ORE.getDefaultState();
        fillerBlock = Blocks.EMERALD_ORE.getDefaultState();
        fillerBlock = Blocks.REDSTONE_ORE.getDefaultState();
        // AoP:
        fillerBlock = AoPBlockInit.AMETHYST_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.SILVER_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.SERPENTINITE_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.ROUGH_STONE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.ROUGH_MARBLE_BLOCK.getDefaultState();


        // EXAMPLE CODE: this.decorator.lapisGen = new WorldGenMinable(AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState(), 5);
        //(Not sure I need this --->) decorator.sandGen = new WorldGenSand((Block) AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState(), 0);

        this.decorator.deadBushPerChunk = 5;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityCleric.class, 50, 1, 3));
    }
}
