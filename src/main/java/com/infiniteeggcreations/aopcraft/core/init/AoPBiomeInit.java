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
    public static final Biome DANUK = new BiomeDanuk();
    public static final Biome AURORA_WOODS = new BiomeAuroraWoods();

    public static void registerBiomes()
    {
        initBiome(DANUK, "Danuk", BiomeType.DESERT, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.END, BiomeDictionary.Type.SPOOKY);
        initBiome(AURORA_WOODS, "Aurora Woods", BiomeType.WARM, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.SPOOKY);
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, BiomeDictionary.Type... types)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}
