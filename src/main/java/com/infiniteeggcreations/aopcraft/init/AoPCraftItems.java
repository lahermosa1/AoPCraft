package com.infiniteeggcreations.aopcraft.init;

import com.infiniteeggcreations.aopcraft.AoPCraft;
import com.infiniteeggcreations.aopcraft.AoPCraftTabs;
import com.infiniteeggcreations.aopcraft.item.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.infiniteeggcreations.aopcraft.item.ItemBucketLatex;
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

    public static Item boiled_egg;
    public static Item bucket_latex;
    public static Item deviled_egg;
    public static Item jasper;
    public static Item marble;
    public static Item phoenix_egg;
    public static Item phoenix_feather;
    public static Item phoenix_sword;
    public static Item rubber;
    public static Item serpentinite;
    public static Item serpentinite_battle_axe;
    public static Item serpentinite_ingot;
    public static Item silver;

    // This init method will be called during the preInit fxn of my Main class (AoPCraft.java)
    // and functions to initialize all mod items. It will return nothing and does not need any arguments.
    // Here you change the Tab and Stack Size of each mod item.  Maybe other stuff to???
    public static void init() {

        // Initializing the my mod item variables (declared above) & passing it the name aopcraftItem.
        boiled_egg = new ItemBoiledEgg("boiled_egg", 2).setCreativeTab(AoPCraftTabs.tabConsumables);
        bucket_latex = new ItemBucketLatex("bucket_latex");
        deviled_egg = new ItemBoiledEgg("deviled_egg", 4).setCreativeTab(AoPCraftTabs.tabConsumables);
        jasper = new ItemJasper("jasper");
        marble = new ItemMarble("marble").setCreativeTab(AoPCraftTabs.tabMaterials).setMaxStackSize(64);
        phoenix_egg = new ItemPhoenixEgg("phoenix_egg").setCreativeTab(AoPCraftTabs.tabItems).setMaxStackSize(1);
        phoenix_feather = new ItemPhoenixFeather("phoenix_feather").setCreativeTab(AoPCraftTabs.tabMaterials)
                .setMaxStackSize(10);
        phoenix_sword = new ItemPhoenixSword("phoenix_sword").setCreativeTab(AoPCraftTabs.tabCombat).setMaxStackSize(1);
        rubber = new ItemRubber("rubber").setCreativeTab(AoPCraftTabs.tabMaterials).setMaxStackSize(64);
        serpentinite = new ItemSerpentinite("serpentinite");
        serpentinite_battle_axe = new ItemSerpentiniteBattleAxe("serpentinite_battle_axe");
        serpentinite_ingot = new ItemSerpentiniteIngot("serpentinite_ingot");
        silver = new ItemSilver("silver");
    }

    // Tell Forge that we have a new item to register using the RegistryEvent.
    // Add a new public static method registerItems with the argument of type RegistryEvent.Register<item>.
    // Add @SubscribeEvent above the method.
    // Go back to the top and add @Mod.EventBusSubscriber with a MODID attribute before the class declaration.
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Add more mod items separated by commas:
        event.getRegistry().registerAll(boiled_egg, bucket_latex, deviled_egg, jasper, marble, phoenix_egg,
                phoenix_feather,
                phoenix_sword, rubber, serpentinite, serpentinite_battle_axe, serpentinite_ingot, silver);
    }

    // Register the model location of the item using the ModelRegistryEvent.
    // Add public static method called registerRenders with as an argument: ModelRegistryEvent.
    // Add @SubscribeEvent notation above this new method.
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        // Add more mod items to the list separated by a semicolon and on a new line:
        registerRender(boiled_egg);
        registerRender(bucket_latex);
        registerRender(deviled_egg);
        registerRender(jasper);
        registerRender(marble);
        registerRender(phoenix_egg);
        registerRender(phoenix_feather);
        registerRender(phoenix_sword);
        registerRender(rubber);
        registerRender(serpentinite);
        registerRender(serpentinite_battle_axe);
        registerRender(serpentinite_ingot);
        registerRender(silver);
    }

    // Add another static method called registerRender(w/o the s) with Item as argument.
    // This will set

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),
                "inventory"));
    }
}
