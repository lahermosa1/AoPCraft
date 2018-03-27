/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.client.gui;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

/**
 * Reference: https://www.youtube.com/watch?v=MHgS0GTNqq0&t=241s
 *
 * TODO: *** Short Cut! *** -> Press CTRL-O to select methods to override/implement!
 * TODO: *** Short Cut! *** -> Within the parentheses of a method, Press CTRL-P in order to see what parameters you need!!!
 * TODO: *** Short Cut! *** -> Press CTRL-F9 to refresh while in debug mode if you make dimension changes.
 */

public class GuiBookMaroon extends GuiScreen
{
    // The texture for this Gui element:
    private final ResourceLocation GUI_TEXTURE = new ResourceLocation(AoPReference.MODID, "textures/gui/book_maroon.png");

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(GUI_TEXTURE);
        // 1st & 2nd coordinates are where it will draw on the screen in-game.
        // 3rd & 4th coordinates are where to start drawing FROM in your 256 x 256 texture.
        // 5th & 6th values are the width and height respectively of your Gui element (measured in CLIP STUDIO PAINT EX).
        int guiWidth = 166;
        int centerX = (width/2) - (guiWidth /2);
        int guiHeight = 208;
        int centerY = (height/2) - (guiHeight /2);
        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        fontRenderer.drawString("Hello.  This is a maroon book.", centerX + 8, centerY + 16, 0x000000);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

}
