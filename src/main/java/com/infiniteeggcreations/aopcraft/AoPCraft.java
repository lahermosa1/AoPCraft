package com.infiniteeggcreations.aopcraft;

import com.infiniteeggcreations.aopcraft.init.AoPCraftItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(   modid = AoPCraft.MODID,
        name = AoPCraft.MODNAME,
        version = AoPCraft.VERSION)

@Mod.EventBusSubscriber
public class AoPCraft {

    public static final String MODID = "aopcraft";
    public static final String MODNAME = "Age of the Phoenixcraft";
    public static final String VERSION = "0.0.5.0";

    @Mod.Instance(MODID)
    public static AoPCraft INSTANCE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(AoPCraft.MODID + ":preInit");
        AoPCraftItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(AoPCraft.MODID + ":init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(AoPCraft.MODID + ":postInit");
    }
}
