package com.infiniteeggcreations.aopcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDeviledEgg extends Item {

    int itemUseDuration;
    int healAmount;
    private PotionEffect potionId;

    public ItemDeviledEgg(String name, int amount) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(16);
        this.itemUseDuration = 5;
        this.healAmount = amount;
        this.setCreativeTab(CreativeTabs.FOOD);
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            player.addPotionEffect(new PotionEffect(this.potionId));
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack) {
        return 5;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }
}