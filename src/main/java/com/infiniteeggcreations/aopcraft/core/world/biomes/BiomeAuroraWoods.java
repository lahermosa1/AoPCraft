/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.biomes;

import com.infiniteeggcreations.aopcraft.aurorawoods.entity.EntityBandit;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBirchTree;

import java.util.Random;

/**
 * https://www.youtube.com/watch?v=ejhdLJDo2DE
 */
public class BiomeAuroraWoods extends Biome
{

    private static final WorldGenAbstractTree AURORA_TREE = new WorldGenBirchTree(false, true);

    public BiomeAuroraWoods()
    {
        super(new BiomeProperties("Aurora Woods").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.6F).setRainfall(0.6F).setWaterColor(52991));

        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();

        // TODO: Trying to add more types of blocks underneath top.
        // Vanilla:
        fillerBlock = Blocks.DIAMOND_ORE.getDefaultState();
        fillerBlock = Blocks.LAPIS_ORE.getDefaultState();
        fillerBlock = Blocks.GOLD_ORE.getDefaultState();
        fillerBlock = Blocks.IRON_ORE.getDefaultState();
        fillerBlock = Blocks.GRAVEL.getDefaultState();

        // AoP:
        fillerBlock = AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.SILVER_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.JASPER_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.SERPENTINITE_ORE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.ROUGH_STONE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.ROUGH_MARBLE_BLOCK.getDefaultState();
        fillerBlock = AoPBlockInit.ROUGH_BLUE_GRANITE_BLOCK.getDefaultState();


        // EXAMPLE CODE: this.decorator.lapisGen = new WorldGenMinable(AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState(), 5);

        this.decorator.treesPerChunk = 2;
        this.decorator.flowersPerChunk = 100;
        this.decorator.grassPerChunk = 2;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityBandit.class, 10, 2, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 5, 3, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityMooshroom.class, 8, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 2, 1, 4));

    }

    public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos)
    {
            return super.pickRandomFlower(rand, pos);
    }

    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
            this.addMushrooms(worldIn, rand, pos);
    }

    private void addMushrooms(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_)
    {

        for (int i = 0; i < 4; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                int k = i * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                int l = j * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                BlockPos blockpos = p_185379_1_.getHeight(p_185379_3_.add(k, 0, l));

                if (p_185379_2_.nextInt(20) == 0 && net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM))
                {
                    WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
                    worldgenbigmushroom.generate(p_185379_1_, p_185379_2_, blockpos);
                }
                else if (net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
                {
                    WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(p_185379_2_);
                    worldgenabstracttree.setDecorationDefaults();

                    if (worldgenabstracttree.generate(p_185379_1_, p_185379_2_, blockpos))
                    {
                        worldgenabstracttree.generateSaplings(p_185379_1_, p_185379_2_, blockpos);
                    }
                }
            }
        }
    }

    public void addDoublePlants(World p_185378_1_, Random p_185378_2_, BlockPos p_185378_3_, int p_185378_4_)
    {
        for (int i = 0; i < p_185378_4_; ++i)
        {
            int j = p_185378_2_.nextInt(3);

            if (j == 0)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
            }
            else if (j == 1)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
            }
            else if (j == 2)
            {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
            }

            for (int k = 0; k < 5; ++k)
            {
                int l = p_185378_2_.nextInt(16) + 8;
                int i1 = p_185378_2_.nextInt(16) + 8;
                int j1 = p_185378_2_.nextInt(p_185378_1_.getHeight(p_185378_3_.add(l, 0, i1)).getY() + 32);

                if (DOUBLE_PLANT_GENERATOR.generate(p_185378_1_, p_185378_2_, new BlockPos(p_185378_3_.getX() + l, j1, p_185378_3_.getZ() + i1)))
                {
                    break;
                }
            }
        }
    }


    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return AURORA_TREE;
    }

}
