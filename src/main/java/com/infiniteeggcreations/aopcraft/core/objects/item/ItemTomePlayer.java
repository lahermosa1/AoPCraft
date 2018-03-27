/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.item;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.client.gui.AoPGui;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY
 *
 * This item is used to open the screen that the AoPGui will eventually open.
 */
public class ItemTomePlayer extends Item implements IHasModel
{
    // ========== Constructor ==========
    public ItemTomePlayer(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(AoPCraft.AOPCRAFTTAB);
        AoPItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if(!worldIn.isRemote)
        {
            playerIn.sendMessage(new TextComponentString("Right clicking the Player Tome opens the AoPGui."));
        }
        else
            {
                // Right clicking the bag of shinies will make the button appear (for now, need to switch from right clicking this to clicking a button on the HUD):
                Minecraft.getMinecraft().displayGuiScreen(new AoPGui());
            }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return false;
    }

    @Override
    public void registerModels()
    {
        AoPCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }


    //TODO: *** AoPGui Description ***


}
