package com.infiniteeggcreations.aopcraft.init;

import com.infiniteeggcreations.aopcraft.AoPCraft;
import com.infiniteeggcreations.aopcraft.block.BlockBase;
import com.infiniteeggcreations.aopcraft.block.BlockMarbleRough;
import com.infiniteeggcreations.aopcraft.block.BlockNest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
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
    static Block base_block;
    static Block marble_rough;
    static Block nest;

    // Need to add 5 public static void methods:

    // #1 - The init function initializes my mod block variables (needs no arguments):
    public static void init() {

        // Add my mod block variables and pass them Material.ROCK (or DIRT, STONE, etc)
        base_block = new BlockBase("base_block", Material.ROCK); // Creative tab already set in class declaration.
        marble_rough = new BlockMarbleRough("marble_rough", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        nest = new BlockNest("nest", Material.LEAVES).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    // #2 - Register my mod Blocks with RegistryEvent.Register<Block>:
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        //  Get the Registry by:
        //  - calling getRegistry on the event, and
        //  - calling registerAll on the registry.
        // Add more mod blocks in the parentheses separated by a comma:
        event.getRegistry().registerAll(base_block, marble_rough, nest);
    }

    // #3 - Register ItemBlocks with RegistryEvent.Register<Item>:
    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {

        // Similar to the registerBlocks function, but, instead of passing
        // it my mod block, instantiate a new ItemBlock and pass it my mod block.
        // Must call setRegistryName on the ItemBlock.
        event.getRegistry().registerAll(new ItemBlock(base_block).setRegistryName(base_block.getRegistryName()));
        event.getRegistry().registerAll( new ItemBlock(marble_rough).setRegistryName(marble_rough.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(nest).setRegistryName(nest.getRegistryName()));
        }

    // #4 - Register ItemBlock models using method registerRenders with an
    //      argument of type ModelRegistryEvent and @SubscribeEvent beforehand:
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        // Call registerRender and pass it ItemBlock. Get the ItemBlock by calling the
        // static method Item.getItemFromBlock and passing it my mod bock.
        registerRender(Item.getItemFromBlock(base_block));
        registerRender(Item.getItemFromBlock(marble_rough));
        registerRender(Item.getItemFromBlock(nest));
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
