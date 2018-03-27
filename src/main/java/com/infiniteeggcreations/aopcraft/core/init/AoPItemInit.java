package com.infiniteeggcreations.aopcraft.core.init;


import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import com.infiniteeggcreations.aopcraft.core.objects.item.*;
import com.infiniteeggcreations.aopcraft.core.objects.item.food.ItemBaseFood;
import com.infiniteeggcreations.aopcraft.core.objects.tools.*;

import com.infiniteeggcreations.aopcraft.core.objects.tools.ToolHoe;
import com.infiniteeggcreations.aopcraft.core.objects.tools.ToolPickaxe;
import com.infiniteeggcreations.aopcraft.core.objects.tools.ToolShovel;
import com.infiniteeggcreations.aopcraft.core.objects.tools.ToolSword;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * A class to instantiate all mod item.
 * Reference: https://www.youtube.com/watch?v=rQLhheYcnrY&t=26s
 */
// Items are registered by my RegistryHandler class in the common -> util -> handlers folder
// Item models are rendered and registered by the RenderHandler class in the common -> util ->
// handlers folder

public class AoPItemInit
{
    public static final List<Item> ITEMS = new ArrayList<>();

// ============================= ARMOR MATERIALS =========================== //
    //  REFERENCE VALUES:
    //      LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
    //      CHAIN("chain", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
    //      IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
    //      GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
    //      DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F),
    //      First value = String name
    //      Second value = maxDamageFactor
    //      Third value = damageReductionAmountArray (HELMET, CHESTPLATE, LEGGINGS, BOOTS): 1 = 1/2 shield on gui
    //      Fourth value = enchantability
    //      Fifth value = SoundEvent soundEvent
    //      Sixth value = toughness

    public static final ItemArmor.ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("armor_copper", AoPReference.MODID + ":copper", 13, new int[]{2, 5, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

    // ============================= ARMOR =========================== //
    //public static final Item HELMET_COPPER = new ArmorBase("helmet_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.HEAD);
    //public static final Item CHESTPLATE_COPPER = new ArmorBase("chestplate_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.CHEST);
    //public static final Item LEGGINGS_COPPER = new ArmorBase("leggings_copper", ARMOR_COPPER, 2, EntityEquipmentSlot.LEGS);
    //public static final Item BOOTS_COPPER = new ArmorBase("boots_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.FEET);


    // ============================== GUI SCREENS ============================ //
    // Player Tome opens the Main AoPGui:
    public static final Item TOME_PLAYER = new ItemTomePlayer("tome_player");
    public static final Item NOTE_ONE = new ItemNoteOne("note_one");
    public static final Item PAGE_ONE = new ItemPageOne("page_one");
    public static final Item BOOK_MAROON = new ItemBookMaroon("book_maroon");

    // ================= BUTTON ICONS ================= //
    public static final Item COIN = new ItemBase("coin");
    public static final Item COUNTER_COIN = new ItemCounterCoin("counter_coin");

    // ============================= MISC ITEMS =========================== //
    public static final Item BUCKET_LATEX = new ItemBase("bucket_latex").setMaxStackSize(1);
    public static final Item PHOENIX_EGG = new ItemBase("phoenix_egg").setMaxStackSize(1);
    public static final Item PHOENIX_FEATHER = new ItemBase("phoenix_feather").setMaxStackSize(16);
    public static final Item RUBBER = new ItemBase("rubber");
    public static final Item SCEPTER = new ItemBase("scepter");

    // ============================= FOOD =========================== //
    public static final Item BOILED_EGG = new ItemBaseFood("boiled_egg", 1, false);
    public static final Item DEVILED_EGG = new ItemBaseFood("deviled_egg", 2, false);

    // ============================= GEMS =========================== //
    public static final Item AMETHYST = new ItemBase("amethyst");
    public static final Item CITRINE = new ItemBase("citrine");

// ============================= TOOL MATERIALS =========================== //
    //  REFERENCE VALUES:
    //      WOOD(0, 59, 2.0F, 0.0F, 15),
    //      STONE(1, 131, 4.0F, 1.0F, 5),
    //      IRON(2, 250, 6.0F, 2.0F, 14),
    //      DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    //      GOLD(0, 32, 12.0F, 0.0F, 22);
    //      First value = harvestLevel
    //      Second value = maxUses
    //      Third value = efficiencyOnProperMaterial
    //      Fourth value = damageVsEntity
    //      Fifth value = enchantability

    public static final Item.ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 190, 5.0F, 1.5F, 20);

    public static final Item.ToolMaterial TOOL_GEMSTONE = EnumHelper.addToolMaterial("tool_gemstone", 4, 2000, 10.0F, 6.0F, 30);

    public static final Item.ToolMaterial TOOL_JASPER = EnumHelper.addToolMaterial("tool_jasper", 0, 100, 4.5F, 4.0F, 0);

    public static final Item.ToolMaterial TOOL_HARDENED_SILVER = EnumHelper.addToolMaterial("tool_hardened_silver", 2, 900, 7.2F, 2.7F, 15);

    public static final Item.ToolMaterial TOOL_PHOENIX_SCALE = EnumHelper.addToolMaterial("tool_phoenix_scale", 0, 2500, 0.0F, 10.0F, 0);

    public static final Item.ToolMaterial TOOL_SERPENTINITE = EnumHelper.addToolMaterial("tool_serpentinite", 0, 1600, 6.0F, 9.0F, 0);

    public static final Item.ToolMaterial TOOL_SILVER = EnumHelper.addToolMaterial("tool_silver", 2, 750, 7.0F, 2.5F, 16);

    // ============================= TOOLS =========================== //
    public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
    public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
    public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
    public static final Item SHOVEL_COPPER = new ToolShovel("shovel_copper", TOOL_COPPER);

    public static final Item AXE_SILVER = new ToolAxe("axe_silver", TOOL_SILVER);
    public static final Item HOE_SILVER = new ToolHoe("hoe_silver", TOOL_SILVER);
    public static final Item PICKAXE_SILVER = new ToolPickaxe("pickaxe_silver", TOOL_SILVER);
    public static final Item SHOVEL_SILVER = new ToolShovel("shovel_silver", TOOL_SILVER);

    // ============================= WEAPONS =========================== //
    public static final Item BAKARI_WARAXE = new ToolSword("bakari_waraxe", Item.ToolMaterial.DIAMOND).setMaxStackSize(1);
    public static final Item BLOOD_SWORD = new ToolSword("blood_sword", Item.ToolMaterial.IRON).setMaxStackSize(1);
    public static final Item CITRINE_SWORD = new ToolSword("citrine_sword", TOOL_GEMSTONE).setMaxStackSize(1);
    public static final Item CURVED_DAGGER = new ToolSword("curved_dagger", Item.ToolMaterial.STONE).setMaxStackSize(1);
    public static final Item DARK_JASPER_SWORD = new ToolSword("dark_jasper_sword", TOOL_JASPER).setMaxStackSize(1);
    public static final Item JEWELED_SWORD = new ToolSword("jeweled_sword", TOOL_GEMSTONE).setMaxStackSize(1);
    public static final Item PHOENIX_SWORD = new ToolSword("phoenix_sword", TOOL_PHOENIX_SCALE).setMaxStackSize(1).setNoRepair();
    public static final Item SERPENTINITE_BATTLEAXE = new ToolSword("serpentinite_battleaxe", TOOL_SERPENTINITE).setMaxStackSize(1);
    public static final Item SILVER_SPEAR = new ToolSword("silver_spear", TOOL_HARDENED_SILVER).setMaxStackSize(1);
    public static final Item WINGED_BLOOD_SWORD = new ToolSword("winged_blood_sword", Item.ToolMaterial.DIAMOND).setMaxStackSize(1);

    // ============================= ORE ITEMS =========================== //
    public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
    public static final Item COPPER_NUGGET = new ItemBase("copper_nugget");
    public static final Item JASPER = new ItemBase("jasper");
    public static final Item MARBLE = new ItemBase("marble");
    public static final Item SERPENTINITE_INGOT = new ItemBase("serpentinite_ingot");
    public static final Item SERPENTINITE_NUGGET = new ItemBase("serpentinite_nugget");
    public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
    public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");

    // ============================== SPELLS ============================= //
    //public static final Item PROJECTILE_SPELL = new Item();
    //public static final Item SPELL_FLAME = new Item();

}