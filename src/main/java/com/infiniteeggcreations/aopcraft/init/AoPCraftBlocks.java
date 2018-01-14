package com.infiniteeggcreations.aopcraft.init;

import com.infiniteeggcreations.aopcraft.AoPCraft;
import com.infiniteeggcreations.aopcraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * A class to instantiate and register all mod blocks and itemblocks.
 */

@Mod.EventBusSubscriber(modid= AoPCraft.MODID)
public class AoPCraftBlocks {

    // List of all mod blocks:
    public static Block aurora_leaves;

    public static Block base_block;
    public static Block brick_colorfulstone;
    public static Block brick_limestone;
    public static Block granite_light_gray;
    public static Block jasper_block;
    public static Block jasper_ore;
    public static Block marble_rough;
    public static Block marble_smooth;
    public static Block nest;
    public static Block rubber_block;
    public static Block serpentinite_block;
    public static Block serpentinite_ore;
    public static Block stone_path;
    public static Block stone_rough;

    // Need to add 5 public static void methods:

    // #1 - The init function initializes my mod block variables (needs no arguments):
    public static void init() {

        // Add my mod block variables and pass them Material.ROCK (or DIRT, STONE, etc)
        aurora_leaves = new BlockAuroraLeaves("aurora_leaves", Material.LEAVES);

        base_block = new BlockBase("base_block", Material.ROCK);
        brick_colorfulstone = new BlockBrickColorfulstone("brick_colorfulstone", Material.ROCK);
        brick_limestone = new BlockBrickLimestone("brick_limestone", Material.ROCK);
        granite_light_gray = new BlockGraniteLightGray("granite_light_gray", Material.ROCK);
        jasper_block = new BlockJasper("jasper_block", Material.ROCK);
        jasper_ore = new BlockJasperOre("jasper_ore", Material.ROCK);
        marble_rough = new BlockMarbleRough("marble_rough", Material.ROCK);
        marble_smooth = new BlockMarbleSmooth("marble_smooth", Material.ROCK);
        nest = new BlockNest("nest", Material.WEB);
        rubber_block = new BlockRubberBlock("rubber_block");
        serpentinite_block = new BlockSerpentiniteBlock("serpentinite_block", Material.ROCK);
        serpentinite_ore = new BlockSerpentiniteOre("serpentinite_ore", Material.ROCK);
        stone_path = new BlockStonePath("stone_path", Material.ROCK);
        stone_rough = new BlockStoneRough("stone_rough", Material.ROCK);

    }

    // #2 - Register my mod Blocks with RegistryEvent.Register<Block>:
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //  Get the Registry by:
        //  - calling getRegistry on the event, and
        //  - calling registerAll on the registry.
        // Add more mod blocks in the parentheses separated by a comma:
        event.getRegistry().registerAll(aurora_leaves);

        event.getRegistry().registerAll(base_block);
        event.getRegistry().registerAll(brick_colorfulstone);
        event.getRegistry().registerAll(brick_limestone);
        event.getRegistry().registerAll(granite_light_gray);
        event.getRegistry().registerAll(jasper_block);
        event.getRegistry().registerAll(jasper_ore);
        event.getRegistry().registerAll(marble_rough);
        event.getRegistry().registerAll(marble_smooth);
        event.getRegistry().registerAll(nest);
        event.getRegistry().registerAll(rubber_block);
        event.getRegistry().registerAll(serpentinite_block);
        event.getRegistry().registerAll(serpentinite_ore);
        event.getRegistry().registerAll(stone_path);
        event.getRegistry().registerAll(stone_rough);
    }

    // #3 - Register ItemBlocks with RegistryEvent.Register<Item>:
    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {

        // Similar to the registerBlocks function, but, instead of passing
        // it my mod block, instantiate a new ItemBlock and pass it my mod block.
        // Must call setRegistryName on the ItemBlock.
        event.getRegistry().registerAll(new ItemBlock(aurora_leaves).setRegistryName(aurora_leaves.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(base_block).setRegistryName(base_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(brick_colorfulstone).setRegistryName(brick_colorfulstone
                .getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(brick_limestone).setRegistryName(brick_limestone
                .getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(granite_light_gray).setRegistryName(granite_light_gray.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(jasper_block).setRegistryName(jasper_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(jasper_ore).setRegistryName(jasper_ore.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(marble_smooth).setRegistryName(marble_smooth.getRegistryName()));
        event.getRegistry().registerAll( new ItemBlock(marble_rough).setRegistryName(marble_rough.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(nest).setRegistryName(nest.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubber_block).setRegistryName(rubber_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(serpentinite_block).setRegistryName(serpentinite_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(serpentinite_ore).setRegistryName(serpentinite_ore
                .getRegistryName()));
        event.getRegistry().registerAll( new ItemBlock(stone_rough).setRegistryName(stone_rough.getRegistryName()));

        }

    // #4 - Register ItemBlock models using method registerRenders with an
    //      argument of type ModelRegistryEvent and @SubscribeEvent beforehand:
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        // Call registerRender and pass it ItemBlock. Get the ItemBlock by calling the
        // static method Item.getItemFromBlock and passing it my mod bock.
        registerRender(Item.getItemFromBlock(aurora_leaves));

        registerRender(Item.getItemFromBlock(base_block));
        registerRender(Item.getItemFromBlock(brick_colorfulstone));
        registerRender(Item.getItemFromBlock(brick_limestone));
        registerRender(Item.getItemFromBlock(granite_light_gray));
        registerRender(Item.getItemFromBlock(jasper_block));
        registerRender(Item.getItemFromBlock(jasper_ore));
        registerRender(Item.getItemFromBlock(marble_smooth));
        registerRender(Item.getItemFromBlock(marble_rough));
        registerRender(Item.getItemFromBlock(nest));
        registerRender(Item.getItemFromBlock(rubber_block));
        registerRender(Item.getItemFromBlock(serpentinite_block));
        registerRender(Item.getItemFromBlock(serpentinite_ore));
        registerRender(Item.getItemFromBlock(stone_path));
        registerRender(Item.getItemFromBlock(stone_rough));

    }

    // #5 - Add registerRender (no s) method with argument Item.
    //      Do not need @SubscribeEvent annotation beforehand:
    public static void registerRender(Item item) {

        // Same as in the AoPCraftItems class:
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),
                "inventory"));
    }

    // Go back to the top and add @Mod.EventBusSubscriber(modid=AoPCraft.MODID)
    // above the class declaration.
}
