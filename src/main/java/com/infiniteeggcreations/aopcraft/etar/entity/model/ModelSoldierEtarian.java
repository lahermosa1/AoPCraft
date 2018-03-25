/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.etar.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSoldierEtarian extends ModelBase
{

    public ModelRenderer soldierEtarianHead;
    public ModelRenderer soldierEtarianHeadwear;
    public ModelRenderer soldierEtarianBody;
    public ModelRenderer soldierEtarianRightArm;
    public ModelRenderer soldierEtarianLeftArm;
    public ModelRenderer soldierEtarianRightLeg;
    public ModelRenderer soldierEtarianLeftLeg;
    public ModelRenderer soldierEtarianEars;
    public ModelRenderer soldierEtarianCloak;

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

    public ModelSoldierEtarian()
    {
        this(0.0F);
    }

    public ModelSoldierEtarian(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelSoldierEtarian(float par1, float par2, int par3, int par4)
    {
        textureWidth = par3;
        textureHeight = par4;
        soldierEtarianCloak = new ModelRenderer(this, 0, 0);
        soldierEtarianCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, par1);
        soldierEtarianEars = new ModelRenderer(this, 24, 0);
        soldierEtarianEars.addBox(-3F, -6F, -1F, 6, 6, 1, par1);
        soldierEtarianHead = new ModelRenderer(this, 0, 0);
        soldierEtarianHead.addBox(-4F, -8F, -4F, 8, 8, 8, par1);
        soldierEtarianHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        soldierEtarianHeadwear = new ModelRenderer(this, 32, 0);
        soldierEtarianHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, par1 + 0.5F);
        soldierEtarianHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        soldierEtarianBody = new ModelRenderer(this, 16, 16);
        soldierEtarianBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, par1);
        soldierEtarianBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        soldierEtarianRightArm = new ModelRenderer(this, 40, 16);
        soldierEtarianRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, par1);
        soldierEtarianRightArm.setRotationPoint(-5F, 2.0F + par2, 0.0F);
        soldierEtarianLeftArm = new ModelRenderer(this, 40, 16);
        soldierEtarianLeftArm.mirror = true;
        soldierEtarianLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, par1);
        soldierEtarianLeftArm.setRotationPoint(5F, 2.0F + par2, 0.0F);
        soldierEtarianRightLeg = new ModelRenderer(this, 0, 16);
        soldierEtarianRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        soldierEtarianRightLeg.setRotationPoint(-1.9F, 12F + par2, 0.0F);
        soldierEtarianLeftLeg = new ModelRenderer(this, 0, 16);
        soldierEtarianLeftLeg.mirror = true;
        soldierEtarianLeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        soldierEtarianLeftLeg.setRotationPoint(1.9F, 12F + par2, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        soldierEtarianHead.render(par7);
        soldierEtarianBody.render(par7);
        soldierEtarianRightArm.render(par7);
        soldierEtarianLeftArm.render(par7);
        soldierEtarianRightLeg.render(par7);
        soldierEtarianLeftLeg.render(par7);
        soldierEtarianHeadwear.render(par7);
    }


    /**
     * Sets the model's various rotation angles. For soldierEtarians, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        soldierEtarianHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        soldierEtarianHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        soldierEtarianHeadwear.rotateAngleY = soldierEtarianHead.rotateAngleY;
        soldierEtarianHeadwear.rotateAngleX = soldierEtarianHead.rotateAngleX;

        soldierEtarianRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        soldierEtarianLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        soldierEtarianLeftArm.rotateAngleZ = 0.0F;
        soldierEtarianRightArm.rotateAngleZ = 0.0F;

        soldierEtarianRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        soldierEtarianLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        soldierEtarianRightLeg.rotateAngleY = 0.0F;
        soldierEtarianLeftLeg.rotateAngleY = 0.0F;

    }

    /**
     * Renders the cloak of the current soldierEtarian (in most cases, it's a player)
     */
    public void renderCloak(float par1)
    {
        soldierEtarianCloak.render(par1);
    }

}
