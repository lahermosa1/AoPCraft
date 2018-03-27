/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.objects.item;

import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.client.gui.GuiPets;
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
 * This item is used to display a written page on the player screen (HUD).
 */
public class ItemPageOne extends Item implements IHasModel
{
    // ========== Constructor ==========
    public ItemPageOne(String name)
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
            playerIn.sendMessage(new TextComponentString("Hmm, interesting story."));
            playerIn.sendMessage(new TextComponentString("I wonder if there are more pages?"));
        }
        else
            {
                // Right clicking the note, the message will appear on the HUD:
                Minecraft.getMinecraft().displayGuiScreen(new GuiPets());
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

}
