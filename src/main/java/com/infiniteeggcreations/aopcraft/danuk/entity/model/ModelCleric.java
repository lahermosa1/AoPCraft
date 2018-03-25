/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.danuk.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCleric extends ModelBase
{
    private ModelRenderer clericHead;
    private ModelRenderer clericHeadwear;
    private ModelRenderer clericBody;
    private ModelRenderer clericRightArm;
    private ModelRenderer clericLeftArm;
    private ModelRenderer clericRightLeg;
    private ModelRenderer clericLeftLeg;
    private ModelRenderer clericEars;
    private ModelRenderer clericCloak;

    /**
     * Records whether the model should be rendered holding an item in the left hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right hand, and if that item is a block.
     */
    public int heldItemRight;
    public boolean isSneak;

    /** Records whether the model should be rendered aiming a bow. */
    public boolean aimedBow;

    public ModelCleric()
    {
        this(0.0F);
    }

    public ModelCleric(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelCleric(float par1, float par2, int par3, int par4)
    {
        textureWidth = par3;
        textureHeight = par4;
        clericCloak = new ModelRenderer(this, 0, 0);
        clericCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, par1);
        clericEars = new ModelRenderer(this, 24, 0);
        clericEars.addBox(-3F, -6F, -1F, 6, 6, 1, par1);
        clericHead = new ModelRenderer(this, 0, 0);
        clericHead.addBox(-4F, -8F, -4F, 8, 8, 8, par1);
        clericHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        clericHeadwear = new ModelRenderer(this, 32, 0);
        clericHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, par1 + 0.5F);
        clericHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        clericBody = new ModelRenderer(this, 16, 16);
        clericBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, par1);
        clericBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        clericRightArm = new ModelRenderer(this, 40, 16);
        clericRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, par1);
        clericRightArm.setRotationPoint(-5F, 2.0F + par2, 0.0F);
        clericLeftArm = new ModelRenderer(this, 40, 16);
        clericLeftArm.mirror = true;
        clericLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, par1);
        clericLeftArm.setRotationPoint(5F, 2.0F + par2, 0.0F);
        clericRightLeg = new ModelRenderer(this, 0, 16);
        clericRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        clericRightLeg.setRotationPoint(-1.9F, 12F + par2, 0.0F);
        clericLeftLeg = new ModelRenderer(this, 0, 16);
        clericLeftLeg.mirror = true;
        clericLeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        clericLeftLeg.setRotationPoint(1.9F, 12F + par2, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        clericHead.render(par7);
        clericBody.render(par7);
        clericRightArm.render(par7);
        clericLeftArm.render(par7);
        clericRightLeg.render(par7);
        clericLeftLeg.render(par7);
        clericHeadwear.render(par7);
    }


    /**
     * Sets the model's various rotation angles. For clerics, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        clericHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        clericHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        clericHeadwear.rotateAngleY = clericHead.rotateAngleY;
        clericHeadwear.rotateAngleX = clericHead.rotateAngleX;

        clericRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        clericLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        clericLeftArm.rotateAngleZ = 0.0F;
        clericRightArm.rotateAngleZ = 0.0F;

        clericRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        clericLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        clericRightLeg.rotateAngleY = 0.0F;
        clericLeftLeg.rotateAngleY = 0.0F;

    }

    /**
     * Renders the cloak of the current cleric (in most cases, it's a player)
     */
    public void renderCloak(float par1)
    {
        clericCloak.render(par1);
    }

}
