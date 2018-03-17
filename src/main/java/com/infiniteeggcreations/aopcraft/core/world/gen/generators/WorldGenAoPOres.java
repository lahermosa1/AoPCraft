/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.world.gen.generators;

import com.google.common.base.Predicate;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.util.handlers.EnumHandler;
import com.infiniteeggcreations.aopcraft.objects.block.BlockOres;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Reference: https://www.suppergerrie2.com/minecraft-1-12-modding-with-forge-7-custom-ore-generation/
 *            Nether: -1 (Ores mostly replace Netherrack)
 *            Overworld: 0 (Ores mostly replace Stone)
 *            The End: 1 (No ores normally spawn but you should probably replace Endstone)
 *
 * Reference: https://github.com/HarryTechRevs/MinecraftModding/blob/HarryTechRevs-1.12.2-Tutorials/main/java/harry/mod/world/gen/WorldGenCustomOres.java
 */

public class WorldGenAoPOres implements IWorldGenerator
{
    private WorldGenerator citrine_ore_block, copper_ore_block, jasper_ore_block, silver_ore_block;

    public WorldGenAoPOres()
    {

        // ====================================================================
        //               AoPBlockInit replacing Vanilla blocks
        // ====================================================================
        citrine_ore_block = new WorldGenMinable(AoPBlockInit.CITRINE_ORE_BLOCK.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AURORA_WOODS), 9, BlockMatcher.forBlock(Blocks.LAPIS_BLOCK));
        copper_ore_block = new WorldGenMinable(AoPBlockInit.COPPER_ORE_BLOCK.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AURORA_WOODS), 9, BlockMatcher.forBlock(Blocks.IRON_ORE));
        jasper_ore_block = new WorldGenMinable(AoPBlockInit.JASPER_ORE_BLOCK.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AURORA_WOODS), 9, BlockMatcher.forBlock(Blocks.GRAVEL));
        silver_ore_block = new WorldGenMinable(AoPBlockInit.SILVER_ORE_BLOCK.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AURORA_WOODS), 9, BlockMatcher.forBlock(Blocks.IRON_ORE));


    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()) {
            // ========================= ModBlocks replacing stone =====================
            case 0:
                runGenerator(AoPBlockInit.ROUGH_BLUE_GRANITE_BLOCK.getDefaultState(), 10, 10, 12, 50, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.LIGHT_GRAY_GRANITE_BLOCK.getDefaultState(), 10, 15, 0, 72, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.JASPER_ORE_BLOCK.getDefaultState(), 4, 5, 0, 32, BlockMatcher.forBlock(Blocks.GRAVEL), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.LIMESTONE_BLOCK.getDefaultState(), 12, 18, 62, 72, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.ROUGH_MARBLE_BLOCK.getDefaultState(), 7, 10, 12, 50, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.MUD_BLOCK.getDefaultState(), 12, 16, 66, 72, BlockMatcher.forBlock(Blocks.CLAY), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.SERPENTINITE_ORE_BLOCK.getDefaultState(), 6, 6, 0, 22, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(AoPBlockInit.ROUGH_STONE_BLOCK.getDefaultState(), 20, 20, 0, 255, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                break;


            // ========================= ModBlocks replacing end stone =====================
            case 1:
                runGenerator(AoPBlockInit.BLACK_SAND_BLOCK.getDefaultState(), 20, 20, 0, 255, BlockMatcher.forBlock(Blocks.END_STONE), world, random, chunkX, chunkZ);
                break;
        }
    }


    // ===================== RUN GENERATOR METHOD =============================
    private void runGenerator(IBlockState blockToGen, int blockAmount, int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
        int heightdiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightdiff);
            int z = chunk_Z * 16 + rand.nextInt(16);

            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
    // ***Register this class in my Registry Handler***
}