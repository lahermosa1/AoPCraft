/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.init;

import com.infiniteeggcreations.aopcraft.core.world.biomes.BiomeAuroraWoods;
import com.infiniteeggcreations.aopcraft.core.world.biomes.BiomeDanuk;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AoPBiomeInit
{
    private static final Biome DANUK = new BiomeDanuk();
    private static final Biome AURORA_WOODS = new BiomeAuroraWoods();

    public static void registerBiomes()
    {
        initBiome(DANUK, "Danuk", BiomeType.DESERT, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.END, BiomeDictionary.Type.DRY);
        initBiome(AURORA_WOODS, "Aurora Woods", BiomeType.WARM, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL);
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, BiomeDictionary.Type... types)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        //TODO: Figure out how to have my AoP biomes spawn in a particular place and only once.
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}
