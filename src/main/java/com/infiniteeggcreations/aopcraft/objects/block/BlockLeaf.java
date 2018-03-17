/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.objects.block;

import com.google.common.base.Predicate;
import com.infiniteeggcreations.aopcraft.core.AoPCraft;
import com.infiniteeggcreations.aopcraft.core.init.AoPBlockInit;
import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPCraftTabs;
import com.infiniteeggcreations.aopcraft.core.util.handlers.EnumHandler;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IHasModel;
import com.infiniteeggcreations.aopcraft.core.util.interfaces.IMetaName;
import com.infiniteeggcreations.aopcraft.objects.block.item.ItemBlockVariants;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockLeaf extends BlockLeaves implements IMetaName, IHasModel
{
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class, new Predicate<EnumHandler.EnumType>()
    {
        public boolean apply(@Nullable EnumHandler.EnumType apply)
        {
            return apply.getMeta() < 2;
        }
    });

    private String name;

    public BlockLeaf(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.AURORA_WOODS).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
        setCreativeTab(AoPCraftTabs.tabAoPCraft);

        this.name = name;

        AoPBlockInit.BLOCKS.add(this);
        AoPItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta % 2));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();

        if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 2;
        }

        if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 4;
        }

        return i;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for(EnumHandler.EnumType customblockplanks$enumtype : EnumHandler.EnumType.values())
        {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}

    @Override
    protected int getSaplingDropChance(IBlockState state) {return 30;}

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {return null;}

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void registerModels()
    {
        for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
        {
            AoPCraft.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "leaves_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
        }
    }
}