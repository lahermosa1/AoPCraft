/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.biomes;

import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.entity.mobs.hostile.EntityCleric;
import net.minecraft.world.biome.Biome;

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

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityCleric.class, 20, 1, 6));
    }
}
