/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.client.gui;

import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class GuiButtonCoin extends GuiButton
{
    private final ResourceLocation COUNTER_COIN = new ResourceLocation(AoPReference.MODID, "textures/gui/gui_button_coin");

    int u = 175;
    int v = 1;

    public GuiButtonCoin(int buttonId, int x, int y)
    {
        super(buttonId, x, y, 20, 20, "");
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (visible)
        {
            mc.renderEngine.bindTexture(COUNTER_COIN);
            if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height)
            {
                hovered = true;
            }
            else
            {
                hovered = false;
            }
            if (hovered)
            {
                v = 18;
            }
            else
            {
                v = 1;
            }
            drawTexturedModalRect(x, y, u, v, width, height);
        }
    }
}
