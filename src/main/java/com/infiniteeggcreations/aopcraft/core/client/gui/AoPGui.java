/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.core.client.gui;

import com.infiniteeggcreations.aopcraft.core.init.AoPItemInit;
import com.infiniteeggcreations.aopcraft.core.lib.AoPButtonIdList;
import com.infiniteeggcreations.aopcraft.core.lib.AoPReference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;

/**
 * Reference: https://www.youtube.com/watch?v=MHgS0GTNqq0&t=241s
 *
 * TODO: *** Short Cut! *** -> Press CTRL-O to select methods to override/implement!
 * TODO: *** Short Cut! *** -> Within the parentheses of a method, Press CTRL-P in order to see what parameters you need!!!
 */

public class AoPGui extends GuiScreen
{
    // The texture for this Gui element:
    private final ResourceLocation TOME_PLAYER = new ResourceLocation(AoPReference.MODID, "textures/gui/aop_tome.png");
    private final ResourceLocation BG_TOME_PORTRAIT = new ResourceLocation(AoPReference.MODID, "textures/gui/bg_tome_portrait.png");

    // Declaring any variables used in the methods in this class:
    private int guiHeight = 171;
    private int guiWidth = 237;
    // width = mc screen width; height = mc screen height
    private int centerX = (width / 2) - (guiWidth/2);
    private int centerY = (height / 2) - (guiHeight/2);
    // My default button dimensions:
    private int aopButtonHeight = 20;
    private int aopButtonWidth = 80;
    private int bgtomeportraitHeight = 86;
    private int bgtomeportraitWidth = 86;

    // Declaring my elements (buttons, textboxes...) as new GuiElements:
    private GuiButton button1;
    private GuiButton button2;
    private GuiButton button3;
    private GuiButton button4;
    private GuiButton button5;

    // Button Id List: Moved to AoPButtonIdList reference class.

    private String guititle = "Tome";
    //private String playerName = ;
    private String portraitSubText = "This is the story of the adventures of (playerName here).";

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // 1st & 2nd coordinates are where it will draw on the screen in-game.
        // 3rd & 4th coordinates are where to start drawing FROM in your 256 x 256 texture.
        // 5th & 6th values are the width and height respectively of your Gui element (measured in CLIP STUDIO PAINT EX).
        //drawTexturedModalRect(centerX + 128, centerY + 128, 0, 0, guiWidth, guiHeight);
        //drawString(fontRenderer, "Close", centerX, centerY, 0x000000);
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(TOME_PLAYER);
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(TOME_PLAYER);
            GlStateManager.scale(1.2, 1.2, 1.2); // <--- Did not work to have this after the drawTexture method
            drawTexturedModalRect(centerX + 260, centerY + 132, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();


        // ================= Drawing Player Portrait Background ===================//
        GlStateManager.pushMatrix();
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(BG_TOME_PORTRAIT);
            GlStateManager.scale(1.2, 1.2, 1.2);
            drawTexturedModalRect(centerX + 280, centerY + 152, 21, 18, bgtomeportraitWidth, bgtomeportraitHeight);
            GlStateManager.popMatrix();
        }

        // ================= Drawing Player on Screen ===================//
        GlStateManager.pushMatrix();
        {
            drawEntityOnScreen(centerX + 365, centerY + 260, 46, mouseX - 244.0F, mouseY - 80.0F, mc.player);
        GlStateManager.popMatrix();
        }


        // ================= Drawing AoPGui icon =================== //
        ItemStack icon = new ItemStack(AoPItemInit.PHOENIX_EGG);
        GlStateManager.pushMatrix();
        {
            // The icon drawn on the AoPGui and its appearance:
            GlStateManager.translate(centerX, centerY, 0);
            GlStateManager.scale(3.5, 3.5, 3.5);
            mc.getRenderItem().renderItemAndEffectIntoGUI(icon, centerX + 233, centerY + 116);
        }
        GlStateManager.popMatrix();


        // ============ Drawing AopGui title on the screen ============
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX - (fontRenderer.getStringWidth(guititle) / 2), centerY, 0);
            GlStateManager.scale(2, 2, 2);
            fontRenderer.drawString(guititle, centerX + 274, centerY + 145,0xFFC800);
        }
        GlStateManager.popMatrix();


        // ============ Drawing Text beneath portrait ============
        //TODO: Get position correct & find a way to include playerName.
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX - (fontRenderer.getStringWidth(portraitSubText) / 2), centerY, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(TOME_PLAYER);
            GlStateManager.scale(1, 1, 1);
            fontRenderer.drawString(portraitSubText, centerX + 360, centerY + 360,0x694100);
        }
        GlStateManager.popMatrix();

        super.drawScreen(mouseX, mouseY, partialTicks);


        // ================ BUTTONS on the AoPGui ================== //
        button1.drawButton(mc, mouseX, mouseY, 1.0F);
        button2.drawButton(mc, mouseX, mouseY, 1.0F);
        button3.drawButton(mc, mouseX, mouseY, 1.0F);
        button4.drawButton(mc, mouseX, mouseY, 1.0F);
        button5.drawButton(mc, mouseX, mouseY, 1.0F);

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

        // ============== Adding BUTTON1 ==============
            // working = centerX + 278; centerY + 252
        buttonList.add(button1 = new GuiButton(0, centerX + 606, centerY + 320, aopButtonWidth, aopButtonHeight, "Close"));

        // ============== Adding BUTTON2 ==============
        buttonList.add(button2 = new GuiButton(1, centerX + 606, centerY + 160, aopButtonWidth, aopButtonHeight, "Inventory"));

        // ============== Adding BUTTON3 ==============
        buttonList.add(button3 = new GuiButton(2, centerX + 606, centerY + 200, aopButtonWidth, aopButtonHeight, "Wealth"));

        // ============== Adding BUTTON4 ==============
        buttonList.add(button4 = new GuiButton(3, centerX + 606, centerY + 240, aopButtonWidth, aopButtonHeight, "Quests"));

        // ============== Adding BUTTON5 ==============
        buttonList.add(button5 = new GuiButton(4, centerX + 606, centerY + 280, aopButtonWidth, aopButtonHeight, "Hobbies"));

        updateButtons();
        super.initGui();
    }

    // ============== Button states & behaviors ==============
    public void updateButtons()
    {
        // title refers to the String title declared at the top before the AoPGui screen was drawn
        if (guititle.equals("Tome"))
        {
            button1.enabled = true;
        }
        else
        {
            button1.enabled = false;
        }
    }


    // ============== AoPGui Buttons' behavior when pressed ==============
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            // Pressing BUTTON1 ---> closes the AoPGui screen
            case AoPButtonIdList.BUTTON1:
                mc.displayGuiScreen(null);
                break;

            // Pressing BUTTON2 ---> opens the players inventory (for now)
            case AoPButtonIdList.BUTTON2:
                mc.displayGuiScreen(new GuiInventory(mc.player));
                break;

            // Pressing BUTTON3 ---> opens GuiNoteOne (for now)
            case AoPButtonIdList.BUTTON3:
                mc.displayGuiScreen(new GuiNoteOne());
                break;

            // Pressing BUTTON4 ---> opens GuiPets (for now)
            case AoPButtonIdList.BUTTON4:
                mc.displayGuiScreen(new GuiWorldQuests());
                break;

            // Pressing BUTTON5 ---> opens GuiBookMaroon (for now)
            case AoPButtonIdList.BUTTON5:
                mc.displayGuiScreen(new GuiHobbies());
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


    //  From GuiInventory class, trying to draw player.
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

}
