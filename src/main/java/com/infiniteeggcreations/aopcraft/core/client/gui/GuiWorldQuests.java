/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.client.gui;

import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPButtonIdList;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;


public class GuiWorldQuests extends GuiScreen
{
    // The texture for this Gui element:
    private final ResourceLocation TOME_PLAYER = new ResourceLocation(AoPReference.MODID, "textures/gui/aop_tome.png");

    // Declaring any variables used in the methods in this class:
    private int guiHeight = 171;
    private int guiWidth = 237;
    // width = mc screen width; height = mc screen height
    private int centerX = (width / 2) - (guiWidth/2);
    private int centerY = (height / 2) - (guiHeight/2);
    // My default button dimensions:
    private int aopButtonHeight = 20;
    private int aopButtonWidth = 80;

    // Declaring my elements (buttons, textboxes...) as new GuiElements:
    private GuiButton button16;
    private GuiButton button17;

    // Button Id List: Moved to AoPButtonIdList reference class.

    private String guititle = "Quests";

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(TOME_PLAYER);
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(TOME_PLAYER);
            GlStateManager.scale(1.2, 1.2, 1.2);
            drawTexturedModalRect(centerX + 260, centerY + 132, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();

        // ============ Drawing AopGui title on the screen ============
        GlStateManager.pushMatrix();
        {
            // Working: GlStateManager.translate(centerX - (fontRenderer.getStringWidth(title) / 2), centerY, 0);
            GlStateManager.translate(centerX - (fontRenderer.getStringWidth(guititle) / 2), centerY, 0);
            GlStateManager.scale(2, 2, 2);
            // Working: fontRenderer.drawString(title, centerX - (fontRenderer.getStringWidth(title) / 2), centerY,
            //                    0xFFC800);
            fontRenderer.drawString(guititle, centerX + 274, centerY + 145,
                    0xFFC800);
        }
        GlStateManager.popMatrix();

        super.drawScreen(mouseX, mouseY, partialTicks);
        // ================ BUTTONS on the AoPGui ================== //
        button16.drawButton(mc, mouseX, mouseY, 1.0F);
        button17.drawButton(mc, mouseX, mouseY, 1.0F);

        // ================= The AoPGui icon =================== //
        ItemStack icon = new ItemStack(AoPItemInit.PHOENIX_EGG);
        GlStateManager.pushMatrix();
        {
            // The icon drawn on the AoPGui and its appearance:
            GlStateManager.translate(centerX, centerY, 0);
            GlStateManager.scale(3.5, 3.5, 3.5);
            mc.getRenderItem().renderItemAndEffectIntoGUI(icon, centerX + 233, centerY + 116);
        }
        GlStateManager.popMatrix();

    }

    // was used for the text box that I removed
    public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height)
    {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height)
        {
            drawHoveringText(lines, mouseX, mouseY);
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI
     * is displayed and when the window resizes, the buttonList is cleared beforehand.
     * TODO: Instructions -> *** Buttons should be put here so they are added one time. ***
     */
    @Override
    public void initGui()
    {
        buttonList.clear();

        // ============== Adding BUTTON10 ==============
        // working = centerX + 278; centerY + 252
        buttonList.add(button16 = new GuiButton(15, centerX + 606, centerY + 320, aopButtonWidth, aopButtonHeight, "Close"));

        // ============== Adding BUTTON11 ==============
        buttonList.add(button17 = new GuiButton(16, centerX + 606, centerY + 160, aopButtonWidth, aopButtonHeight, "Back"));

        updateButtons();
        super.initGui();
    }

    // ============== Button states & behaviors ==============
    public void updateButtons()
    {
        // title refers to the String title declared at the top before the AoPGui screen was drawn
        if (guititle.equals("Quests"))
        {
            button16.enabled = true;
        }
        else
        {
            button16.enabled = false;
        }
    }


    // ============== AoPGui Buttons' behavior when pressed ==============
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            // Pressing BUTTON16 ---> closes the AoPGui screen
            case AoPButtonIdList.BUTTON16:
                mc.displayGuiScreen(null);
                break;

            // Pressing BUTTON17 ---> opens the pet journal section
            case AoPButtonIdList.BUTTON17:
                mc.displayGuiScreen(new AoPGui());
                break;

        }

        updateButtons();
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
