/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.init;

import com.infiniteeggcreations.aopcraft.aurorawoods.block.BlockAuroraLeaves;
import com.infiniteeggcreations.aopcraft.aurorawoods.block.BlockAuroraLog;
import com.infiniteeggcreations.aopcraft.aurorawoods.block.BlockAuroraSaplings;
import com.infiniteeggcreations.aopcraft.core.objects.block.BlockBase;

import com.infiniteeggcreations.aopcraft.danuk.block.BlockBlackSand;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to instantiate all mod block.
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY&t=26s
 */
// Items are registered by my RegistryHandler class in the common -> util -> handlers folder
// Item models are rendered and registered by the RenderHandler class in the common -> util ->
// handlers folder

public class AoPBlockInit
{
    // List of all mod block:
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block AMETHYST_ORE_BLOCK = new BlockBase("amethyst_ore_block", Material.IRON);
    public static final Block AURORA_LEAVES_BLOCK = new BlockAuroraLeaves("aurora_leaves_block");
    public static final Block AURORA_LOG_BLOCK = new BlockAuroraLog("aurora_log_block");
    public static final Block AURORA_PLANKS_BLOCK = new BlockBase("aurora_planks_block", Material.WOOD);
    public static final Block AURORA_SAPLINGS_BLOCK = new BlockAuroraSaplings("aurora_saplings_block");

    public static final Block BLACK_SAND_BLOCK = new BlockBlackSand("black_sand_block");

    public static final Block CASTLESTONE_BRICK_BLOCK = new BlockBase("castlestone_brick_block",
            Material.IRON);
    public static final Block CITRINE_ORE_BLOCK = new BlockBase("citrine_ore_block", Material.IRON);
    public static final Block COLORFULSTONE_BLOCK = new BlockBase("colorfulstone_block",
            Material.IRON);
    public static final Block COPPER_ORE_BLOCK = new BlockBase("copper_ore_block", Material.IRON);

    public static final Block JASPER_BLOCK = new BlockBase("jasper_block", Material.IRON);
    public static final Block JASPER_ORE_BLOCK = new BlockBase("jasper_ore_block", Material.IRON);


    public static final Block LIMESTONE_BLOCK = new BlockBase("limestone_block",
            Material.ROCK);
    public static final Block LIMESTONE_BRICK_BLOCK = new BlockBase("limestone_brick_block",
            Material.IRON);
    public static final Block LIGHT_GRAY_GRANITE_BLOCK = new BlockBase("light_gray_granite_block",
            Material.ROCK);

    public static final Block MUD_BLOCK = new BlockBase("mud_block", Material.CLAY);
    public static final Block MUD_BRICK_BLOCK = new BlockBase("mud_brick_block", Material.ROCK);

    public static final Block NEST_BLOCK = new BlockBase("nest_block", Material.WEB);

    public static final Block ORNATE_COPPER_BLOCK = new BlockBase("ornate_copper_block",
            Material.IRON);
    public static final Block ORNATE_IRON_BLOCK = new BlockBase("ornate_iron_block",
            Material.IRON);
    public static final Block ORNATE_LAPIS_LAZULI_BLOCK = new BlockBase("ornate_lapis_lazuli_block",
            Material.IRON);

    public static final Block POLISHED_BLUE_GRANITE_BLOCK = new BlockBase("polished_blue_granite_block", Material.IRON);
    public static final Block POLISHED_MARBLE_BLOCK = new BlockBase("polished_marble_block", Material.IRON);

    public static final Block REFINED_COBBLESTONE_BLOCK = new BlockBase("refined_cobblestone_block", Material.IRON);
    public static final Block ROUGH_BLUE_GRANITE_BLOCK = new BlockBase("rough_blue_granite_block", Material.ROCK);
    public static final Block ROUGH_MARBLE_BLOCK = new BlockBase("rough_marble_block", Material.ROCK);
    public static final Block ROUGH_STONE_BLOCK = new BlockBase("rough_stone_block", Material.ROCK);
    public static final Block RUBBER_BLOCK = new BlockBase("rubber_block", Material.CLAY);


    public static final Block SERPENTINITE_BLOCK = new BlockBase("serpentinite_block", Material.IRON);
    public static final Block SERPENTINITE_ORE_BLOCK = new BlockBase("serpentinite_ore_block", Material.IRON);
    public static final Block SILVER_ORE_BLOCK = new BlockBase("silver_ore_block", Material.IRON);

    public static final Block STONE_PATH_BLOCK = new BlockBase("stone_path_block", Material.ROCK);

// =========================================================================== //
//                          TREE & ORE GEN BLOCKS
// =========================================================================== //
    //public static final Block PLANKS = new BlockPlank("planks");
    //public static final Block LOGS = new BlockAuroraLog("aurora_log_block");
    //public static final Block LEAVES = new BlockAuroraLeaves("aurora_leaves_block");
    //public static final Block SAPLINGS = new BlockSaplings("sapling");
    //public static final Block DIRT = new BlockDirts("dirt");

}