package com.infiniteeggcreations.aopcraft.init;

import com.infiniteeggcreations.aopcraft.AoPCraft;
import com.infiniteeggcreations.aopcraft.item.ItemPhoenixFeather;
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
    static Item phoenix_feather;

    // This init method will be called during the preInit fxn of my Main class (AoPCraft.java)
    // and functions to initialize all mod items. It will return nothing and does not need any arguments.
    // Here you change the Tab and Stack Size of each mod item.  Maybe other stuff to???
    public static void init() {

        // Initializing the aopcraftItem variable & passing it the name aopcraftItem.
        phoenix_feather = new ItemPhoenixFeather("phoenix_feather").setCreativeTab(CreativeTabs.MISC)
                .setMaxStackSize(10);
    }

    // Tell Forge that we have a new item to register using the RegistryEvent.
    // Add a new public static method registerItems with the argument of type RegistryEvent.Register<item>.
    // Add @SubscribeEvent above the method.
    // Go back to the top and add @Mod.EventBusSubscriber with a MODID attribute before the class declaration.
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Add more mod items separated by commas:
        event.getRegistry().registerAll(phoenix_feather);
    }

    // Register the model location of the item using the ModelRegistryEvent.
    // Add public static method called registerRenders with as an argument: ModelRegistryEvent.
    // Add @SubscribeEvent notation above this new method.
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        // Add more mod items to the list separated by a semicolon and on a new line:
        registerRender(phoenix_feather);
    }

    // Add another static method called registerRender(w/o the s) with Item as argument.
    // This will set

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),
                "inventory"));
    }

}
