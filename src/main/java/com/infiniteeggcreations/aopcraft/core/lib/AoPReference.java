/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.lib;

public class AoPReference
{
    public static final String MODID = "aopcraft";
    public static final String MODNAME = "Age of the Phoenixcraft";
    public static final String VERSION = "0.0.5.0";
    public static final String CLIENT = "com.infiniteeggcreations.aopcraft.core.proxy.ClientProxy";
    public static final String COMMON = "com.infiniteeggcreations.aopcraft.core.proxy.CommonProxy";

    // ================================================================== //
    //                            INSTRUCTIONS                            //       // ================================================================== //
    /**
     * TODO: DO NOT DELETE THESE INSTRUCTIONS...LIKE EVER!!!
     *
     * Reference: https://www.youtube.com/watch?v=p6FFl3yN18M&index=12&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
     *
     * TODO: Do not delete!    *** HOW TO ADD AN ENTITY ***
     *
     *  1. Add Entity to AoPReference.
     *
     *  2. Add Entity to the AoPEntityInit.
     *
     *  3. Create EntityNewName class.  If anything is different from the class you are extending, you need to do @Override and input all of the arguments (the ones you did not change and the ones you modified).
     *
     *  4. Create new RenderNewName class and extend RenderLiving.  Fill in EntityNewName in between the<> when prompted.  Follow the steps (1st - 9th) in order (See RenderSoldierBornan for instructions)!!!
     *
     *  5. Add Entity to RenderHandler class. Choose the SECOND option, not the FIRST no matter what it looks like (even if it is crossed out, YOU WANT THAT ONE)!
     *
     *  6.  Create a ModelNewName class (only if you have your texture done already and have the model parameters).  You can use Tabula - Minecraft Modeler (CurseForge) plus the IChunUtil (you should have this mod).
     *
     *  7. At the end of the ModelNewName class, enter "setRotationAngles" without quotation marks and then Enter as it automatically fills in.
     *  (Reference: https://www.youtube.com/watch?v=vXEUhs-K6Rw&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR&index=13).
     *  Delete the super and then enter the parameters from another Model as example:
     *      (humanoid example = ModelSoldierBornan; humanoid cloak = ModelSoldierEtarian).
     *      (Parameters: float limbSwing(par1), float limbSwingAmount(par2), float ageInTicks(par3), float netHeadYaw(par4), float headPitch(par5), float scaleFactor(par6), Entity entityIn(par7):)
     *
     *  8.  (My own instructions here): Add your entity to your SpawnInit class.
     *
     *
     * TODO: Do not delete!   ***TABULA - MINECRAFT MODELING INSTRUCTIONS ***
     *      1. You boot up Minecraft (outside your IDE) and then click the blue T icon on the start screen (remove CustomMainMenu from mods folder).
     *      2. There is a list of all the entities from Minecraft to import and you can get all the needed values.  Select each body part (cube name) then rename it so you know what it is.  (This will show up in your jar file later.)
     *      3. You can delete body parts too and add on other body parts (CTRL-C then past onto your model).
     *      4. When done, make textures invisible (you will add your own).
     *      5. Now, Save file.
     *      6. Next, Export as Java class and put into your package: (infiniteeggcreations.aopcraft.models.entity).
     *      7. Export as a texture map as well.
     *      8. Press ALT-TAB and then Open FileExplorer.
     *      9. Find your new file:  .minecraft -> mods -> tabula -> export folder.
     *      10. Here you will find .java files for your model folder and then a texture file for you to edit in CLIP STUDIO PAINT EX.
     *      11.  You can open it up in Tabula again in order to check that it is correct.  Have fun!
     *
     */

    // ================================================================== //
    //                            AoP MOB LIST                            //       // ================================================================== //

        // Humanoid Mobs:
        public static final int ENTITY_BANDIT = 120;

        public static final int ENTITY_CLERIC = 121;

        public static final int ENTITY_SOLDIER_ETARIAN = 122;
        public static final int ENTITY_SOLDIER_BORNAN = 123;

        public static final int ENTITY_WARRIOR_ISLAND_MALE = 124;
        public static final int ENTITY_WARRIOR_ISLAND_FEMALE = 125;
        public static final int ENTITY_WARRIOR_PLAINS_MALE = 126;
        public static final int ENTITY_WARRIOR_PLAINS_FEMALE = 127;
        public static final int ENTITY_WARRIOR_GARDENS_MALE = 128;
        public static final int ENTITY_WARRIOR_GARDENS_FEMALE = 129;

        public static final int ENTITY_HERBWORKER_MALE = 130;
        public static final int ENTITY_HERBWORKER_FEMALE = 131;

        public static final int ENTITY_TOTEMIC_MALE = 132;
        public static final int ENTITY_TOTEMIC_FEMALE = 133;

        public static final int ENTITY_ANIMIST_MALE = 134;
        public static final int ENTITY_ANIMIST_FEMALE = 135;

        public static final int ENTITY_MAGE_ISLAND_MALE = 136;
        public static final int ENTITY_MAGE_ISLAND_FEMALE = 137;
        public static final int ENTITY_MAGE_NIFLAND_MALE = 138;
        public static final int ENTITY_MAGE_NIFLAND_FEMALE = 139;

        public static final int ENTITY_MONK_MALE = 140;
        public static final int ENTITY_MONK_FEMALE = 141;

        public static final int ENTITY_FARMER_PLAINS_MALE = 142;
        public static final int ENTITY_FARMER_PLAINS_FEMALE = 143;
        public static final int ENTITY_FARMER_BORNAN_MALE = 144;
        public static final int ENTITY_FARMER_BORNAN_FEMALE = 145;
        public static final int ENTITY_FARMER_AURORAVIL_MALE = 146;
        public static final int ENTITY_FARMER_AURORAVIL_FEMALE = 147;

        public static final int ENTITY_MINER_ETARIAN_MALE = 148;
        public static final int ENTITY_MINER_ETARIAN_FEMALE = 149;

        public static final int ENTITY_FISHCATCHER_PLAINS_MALE = 150;
        public static final int ENTITY_FISHCATCHER_PLAINS_FEMALE = 151;
        public static final int ENTITY_FISHCATCHER_BORNAN_MALE = 152;
        public static final int ENTITY_FISHCATCHER_BORNAN_FEMALE = 153;
        public static final int ENTITY_FISHCATCHER_ETARIAN_MALE = 154;
        public static final int ENTITY_FISHCATCHER_ETARIAN_FEMALE = 155;
        public static final int ENTITY_FISHCATCHER_AURORAVIL_MALE = 156;
        public static final int ENTITY_FISHCATCHER_AURORAVIL_FEMALE = 157;
        public static final int ENTITY_FISHCATCHER_PTMANEJAD_MALE = 158;
        public static final int ENTITY_FISHCATCHER_PTMANEJAD_FEMALE = 159;

        public static final int ENTITY_MERCHANT_PLAINS_MALE = 160;
        public static final int ENTITY_MERCHANT_PLAINS_FEMALE = 161;
        public static final int ENTITY_MERCHANT_BORNAN_MALE = 162;
        public static final int ENTITY_MERCHANT_BORNAN_FEMALE = 163;
        public static final int ENTITY_MERCHANT_ETARIAN_MALE = 164;
        public static final int ENTITY_MERCHANT_ETARIAN_FEMALE = 165;
        public static final int ENTITY_MERCHANT_AURORAVIL_MALE = 166;
        public static final int ENTITY_MERCHANT_AURORAVIL_FEMALE = 167;
        public static final int ENTITY_MERCHANT_PTMANEJAD_MALE = 168;
        public static final int ENTITY_MERCHANT_PTMANEJAD_FEMALE = 169;

        public static final int ENTITY_SAILOR_BORNAN_MALE = 170;
        public static final int ENTITY_SAILOR_BORNAN_FEMALE = 171;
        public static final int ENTITY_SAILOR_AURORAVIL_MALE = 172;
        public static final int ENTITY_SAILOR_AURORAVIL_FEMALE = 173;
        public static final int ENTITY_SAILOR_PTMANEJAD_MALE = 174;
        public static final int ENTITY_SAILOR_PTMANEJAD_FEMALE = 175;

        public static final int ENTITY_PIRATE_ETARIAN_MALE = 176;
        public static final int ENTITY_PIRATE_ETARIAN_FEMALE = 177;
        public static final int ENTITY_PIRATE_PTMANEJAD_MALE = 178;
        public static final int ENTITY_PIRATE_PTMANEJAD_FEMALE = 179;

        public static final int ENTITY_GUARD_AURORAVIL_MALE = 180;
        public static final int ENTITY_GUARD_AURORAVIL_FEMALE = 181;

        public static final int ENTITY_RACKETEER_PTMANEJAD_MALE = 182;
        public static final int ENTITY_RACKETEER_PTMANEJAD_FEMALE = 183;

        public static final int ENTITY_PICKPOCKET_ETARIAN_MALE = 184;
        public static final int ENTITY_PICKPOCKET_ETARIAN_FEMALE = 185;
        public static final int ENTITY_PICKPOCKET_PTMANEJAD_MALE = 186;
        public static final int ENTITY_PICKPOCKET_PTMANEJAD_FEMALE = 187;

        public static final int ENTITY_ESCORT_ETARIAN_MALE = 188;
        public static final int ENTITY_ESCORT_ETARIAN_FEMALE = 189;
        public static final int ENTITY_ESCORT_BORAN_MALE = 190;
        public static final int ENTITY_ESCORT_BORNAN_FEMALE = 191;
        public static final int ENTITY_ESCORT_AURORAVIL_MALE = 192;
        public static final int ENTITY_ESCORT_AURORAVIL_FEMALE = 193;
        public static final int ENTITY_ESCORT_PTMANEJAD_MALE = 194;
        public static final int ENTITY_ESCORT_PTMANEJAD_FEMALE = 194;

        public static final int ENTITY_MERCENARY_ORC_MALE = 195;
        public static final int ENTITY_MERCENARY_ORC_FEMALE = 196;


        // Additional Humanoid Mobs (200s):


        // Monster/Creature Mobs:
        public static final int ENTITY_DEMON_ARCHER= 300;
        public static final int ENTITY_GIANT_HILL = 301;
        public static final int ENTITY_GIANT_STONE = 302;
        public static final int ENTITY_GIANT_MOUNTAIN = 303;
        public static final int ENTITY_LYCANITES_GEKKEN = 304;
        public static final int ENTITY_LYCANITES_QUILL = 305;
        public static final int ENTITY_LYCANITES_SWAMPFROG = 306;
        public static final int ENTITY_LYCANITES_CONGA = 307;
        public static final int ENTITY_LYCANITES_TREANT = 308;
        public static final int ENTITY_LYCANITES_A = 309;
        public static final int ENTITY_LYCANITES_B = 310;
        public static final int ENTITY_ANCESTOR_GHOST_MALE = 311;
        public static final int ENTITY_ANCESTOR_GHOST_FEMALE = 312;
        public static final int ENTITY_FAMILIAR = 313;


        // Animal Mobs:
        public static final int ENTITY_GREAT_SABER_BLACK = 400;
        public static final int ENTITY_GREAT_SABER_SANDY = 401;
        public static final int ENTITY_GREAT_SABER_ORANGE = 402;
        public static final int ENTITY_ELEPHANT_HORNED = 403;
        public static final int ENTITY_ELEPHANT_TUSKED = 404;
        public static final int ENTITY_ORCA = 405;
        public static final int ENTITY_DOLPHIN = 406;
        public static final int ENTITY_GREAT_WHITE_SHARK = 407;
        public static final int ENTITY_STINGRAY = 408;
        public static final int ENTITY_CROCODILE = 409;
        public static final int ENTITY_JACKAL = 410;
        public static final int ENTITY_HYENA = 411;
        public static final int ENTITY_VULTURE = 412;
        public static final int ENTITY_BLACK_CROW = 413;
        public static final int ENTITY_ANACONDA = 414;
        public static final int ENTITY_ANTELOPE = 415;


        // Boss Mobs:
        public static final int ENTITY_BOSS_WHITE_WHALE = 500;
        public static final int ENTITY_BOSS_VELOCICROCIGATOR = 501;
        public static final int ENTITY_BOSS_GIANT_SQUID = 502;
        public static final int ENTITY_BOSS_GREAT_OWL = 503;
        public static final int ENTITY_BOSS_PHOENIX = 504;



    //public static final int GUI_OVEN = 0;
    //public static final int GUI_CURRENCY = 1;
}
