package com.infiniteeggcreations.aopcraft.init;

import com.infiniteeggcreations.aopcraft.AoPCraft;
import com.infiniteeggcreations.aopcraft.item.ItemMarble;
import com.infiniteeggcreations.aopcraft.item.ItemPhoenixEgg;
import com.infiniteeggcreations.aopcraft.item.ItemPhoenixFeather;
import com.infiniteeggcreations.aopcraft.item.ItemPhoenixSword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * A class to instantiate and register all mod items.
 * Reference: http://suppergerrie2.itsab.nl/minecraft-1-12-modding-with-forge-3-custom-item/
 */
@Mod.EventBusSubscriber(modid = AoPCraft.MODID)
public class AoPCraftItems {

    // List of all mod items:
    public static Item marble;
    public static Item phoenix_egg;
    public static Item phoenix_feather;
    public static Item phoenix_sword;

    // This init method will be called during the preInit fxn of my Main class (AoPCraft.java)
    // and functions to initialize all mod items. It will return nothing and does not need any arguments.
    // Here you change the Tab and Stack Size of each mod item.  Maybe other stuff to???
    public static void init() {

        // Initializing the my mod item variables (declared above) & passing it the name aopcraftItem.
        marble = new ItemMarble("marble").setCreativeTab(CreativeTabs.MATERIALS).setMaxStackSize(64);
        phoenix_egg = new ItemPhoenixEgg("phoenix_egg").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(1);
        phoenix_feather = new ItemPhoenixFeather("phoenix_feather").setCreativeTab(CreativeTabs.MISC)
                .setMaxStackSize(10);
        phoenix_sword = new ItemPhoenixSword("phoenix_sword").setCreativeTab(CreativeTabs.COMBAT).setMaxStackSize(1);
    }

    // Tell Forge that we have a new item to register using the RegistryEvent.
    // Add a new public static method registerItems with the argument of type RegistryEvent.Register<item>.
    // Add @SubscribeEvent above the method.
    // Go back to the top and add @Mod.EventBusSubscriber with a MODID attribute before the class declaration.
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Add more mod items separated by commas:
        event.getRegistry().registerAll(marble, phoenix_egg, phoenix_feather, phoenix_sword);
    }

    // Register the model location of the item using the ModelRegistryEvent.
    // Add public static method called registerRenders with as an argument: ModelRegistryEvent.
    // Add @SubscribeEvent notation above this new method.
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        // Add more mod items to the list separated by a semicolon and on a new line:
        registerRender(marble);
        registerRender(phoenix_egg);
        registerRender(phoenix_feather);
        registerRender(phoenix_sword);
    }

    // Add another static method called registerRender(w/o the s) with Item as argument.
    // This will set

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),
                "inventory"));
    }
}
