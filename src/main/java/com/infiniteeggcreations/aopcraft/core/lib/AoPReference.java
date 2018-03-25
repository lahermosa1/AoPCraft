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
    //                          How to add an ENTITY                      //
    // ================================================================== //
    /**
     * TODO: DO NOT DELETE THESE INSTRUCTIONS...LIKE EVER!!!
     *
     * Reference: https://www.youtube.com/watch?v=p6FFl3yN18M&index=12&list=PLiDUvCGH5WEUEV9nc0Ll2pzUFmSFc21uR
     *
     *
     * TODO: Do not delete!    *** HOW TO ADD AN ENTITY ***
     *
     *  1. Add Entity to AoPMobList (formerly kept in AoPReference class).
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

    //public static final int GUI_OVEN = 0;
    //public static final int GUI_CURRENCY = 1;
}
