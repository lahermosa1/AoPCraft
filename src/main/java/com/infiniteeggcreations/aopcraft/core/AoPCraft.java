/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core;

import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.core.proxy.CommonProxy;
import com.infiniteeggcreations.aopcraft.core.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;


@Mod(   modid = AoPReference.MODID,
        name = AoPReference.MODNAME,
        version = AoPReference.VERSION)

public class AoPCraft
{
    @Instance
    public static AoPCraft instance;

    @SidedProxy(clientSide = AoPReference.CLIENT, serverSide = AoPReference.COMMON)
    public static CommonProxy proxy;

    public static final CreativeTabs AOPCRAFTTAB = new AoPCraftTabs("aopcrafttab");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries();
        System.out.println(AoPReference.MODID + ":preInit COMPLETED");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegistries();
        System.out.println(AoPReference.MODID + ":init COMPLETED");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        RegistryHandler.postInitRegistries();
        System.out.println(AoPReference.MODID + ":postInit COMPLETED");
    }

}
