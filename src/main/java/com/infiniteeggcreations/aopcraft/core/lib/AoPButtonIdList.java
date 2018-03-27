/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.lib;

public class AoPButtonIdList
{
    // Id list for my AoPGui buttons:
    public static final int BUTTON1 = 0;  // Closes AoPGui TODO: *** AoP GUI description found in ItemTomePlayer***
    public static final int BUTTON2 = 1;  // Opens PLAYER INVENTORY w/in AoPGui
    public static final int BUTTON3 = 2;  // Opens CURRENCY INVENTORY (coins & precious gems)
                                          // Tabs inventory container that only holds currency.
    public static final int BUTTON4 = 3;  // Opens WORLD QUEST GUI: (to default questing journal page)
                                          // (Journal w/ pages for each homeland:
                                          // Buttons on the side hop to journal page for that homeland.
                                          // Each homeland page has: a map, quest list with check boxes,
                                          // a quest inventory tab
    public static final int BUTTON5 = 4;  // Opens HOBBIES GUI (to default hobby journal page)
                                          // (Journal w/ pages for: each hobby quests, inventory, tabs, maps, notes;
                                          // Buttons on the side quick hop to journal page for that hobby.
                                          // Default page has a list of the hobbies: TREASURE HUNTING, PETS, BOUNTY
                                          // HUNTING.


    // =========================== GuiHobbies ========================== //
    public static final int BUTTON6 = 5;  // Closes the HOBBIES GUI
    public static final int BUTTON7 = 6;  // Opens PET GUI:
                                          // (Journal w/ pages for: pet quests; Tabs for pet inventory
                                          //  & pet cares = food, water, toys, etc.)
    public static final int BUTTON8 = 7;  // Opens TREASURE HUNTING GUI: journal sections for each homeland.
                                          // Default journal page has map of the world with homelands labeled.
                                          // Side buttons for each homeland = quick hop to the journal section
                                          // for that homeland which has: a map of that land, list of some treasures to
                                          // find.  More added as player obtains quests from NPCs, easter eggs, or discovers
                                          // them on their own.
    public static final int BUTTON9 = 8;  // Opens BOUNTY HUNTING GUI:
    public static final int BUTTON18 = 17;  // Back button from HOBBIES GUI to AoP GUI

    // ======================= GuiPets =====================//
    public static final int BUTTON10 = 9;  // Closes PET GUI
    public static final int BUTTON11 = 10; // Back button from PET GUI to HOBBIES GUI

    // ======================= GuiTreasure =====================//
    public static final int BUTTON12 = 11;  // Closes TREASURE GUI
    public static final int BUTTON13 = 12;  // Back button from TREASURE GUI to HOBBIES GUI

    // ======================= GuiBounties =====================//
    public static final int BUTTON14 = 13;  // Closes BOUNTY GUI
    public static final int BUTTON15 = 14;  // Back button from BOUNTY GUI to HOBBIES GUI

    // ======================= GuiWorldQuests=====================//
    public static final int BUTTON16 = 15;  // Closes World Quest GUI
    public static final int BUTTON17 = 16;  // Back button from World Quest GUI to AoP GUI



}
