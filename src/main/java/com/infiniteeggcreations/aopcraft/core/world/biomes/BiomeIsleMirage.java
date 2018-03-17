/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.biomes;

import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import net.minecraft.world.biome.Biome;

/**
 * https://www.youtube.com/watch?v=ejhdLJDo2DE
 */
public class BiomeIsleMirage extends Biome
{
    public BiomeIsleMirage()
    {

        super(new BiomeProperties("Isle Mirage").setBaseHeight(-1.0F).setHeightVariation(0.1F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled().setWaterColor(10506));

        topBlock = AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}
