/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core;

import com.infiniteeggcreations.aopcraft.core.proxy.ClientProxy;
import com.infiniteeggcreations.aopcraft.core.proxy.CommonProxy;
import com.infiniteeggcreations.aopcraft.core.init.AoPEntityInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPRecipeInit;
import com.infiniteeggcreations.aopcraft.core.util.handlers.RenderHandler;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;

@Mod(   modid = AoPCraft.MODID,
        name = AoPCraft.MODNAME,
        version = AoPCraft.VERSION)

public class AoPCraft
{
    public static final String MODID = "aopcraft";
    public static final String MODNAME = "Age of the Phoenixcraft";
    public static final String VERSION = "0.0.5.0";

    @Instance(MODID)
    public static AoPCraft instance;

    @SidedProxy(clientSide = "com.infiniteeggcreations.aopcraft.core.proxy.ClientProxy", serverSide = "com.infiniteeggcreations.aopcraft.core.proxy.CommonProxy")

    public static CommonProxy proxy;
    public static ClientProxy clientProxy;
    public static Logger logger = (Logger) LogManager.getLogger(MODID);
    public static File configDirectory;

    @EventHandler
    public void construction(FMLConstructionEvent event)
    {
        // Use forge universal bucket
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        configDirectory = new File(event.getModConfigurationDirectory(), "aopcraft");
        AoPEntityInit.init();
        RenderHandler.registerEntityRenders();
        System.out.println(MODID + ":preInit COMPLETED");
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Still have recipes registered here:
        AoPRecipeInit.init();

        System.out.println(MODID + ":init COMPLETED");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println(MODID + ":postInit COMPLETED");
    }

   // @EventHandler
    //public void serverStarting(FMLServerStartingEvent event)
   // {
     //   event.registerServerCommand(new AoPCraftCommand());
  //  }

    public File getConfigDirectory()
    {
        return configDirectory;
    }

}
