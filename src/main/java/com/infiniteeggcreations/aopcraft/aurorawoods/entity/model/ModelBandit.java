/*
 * Copyright (c) 2018. Age of the Phoenix and B. H. Gorden.  All rights reserved.
 */

package com.infiniteeggcreations.aopcraft.aurorawoods.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBandit extends ModelBase
{
     
    public ModelRenderer banditHead;
    public ModelRenderer banditHeadwear;
    public ModelRenderer banditBody;
    public ModelRenderer banditRightArm;
    public ModelRenderer banditLeftArm;
    public ModelRenderer banditRightLeg;
    public ModelRenderer banditLeftLeg;
    public ModelRenderer banditEars;
    public ModelRenderer banditCloak;

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

    public ModelBandit()
    {
        this(0.0F);
    }

    public ModelBandit(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelBandit(float par1, float par2, int par3, int par4)
    {
        textureWidth = par3;
        textureHeight = par4;

        banditCloak = new ModelRenderer(this, 0, 0);
        banditCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, par1);

        banditEars = new ModelRenderer(this, 24, 0);
        banditEars.addBox(-3F, -6F, -1F, 6, 6, 1, par1);

        banditHead = new ModelRenderer(this, 0, 0);
        banditHead.addBox(-4F, -8F, -4F, 8, 8, 8, par1);
        banditHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);

        banditHeadwear = new ModelRenderer(this, 32, 0);
        banditHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, par1 + 0.5F);
        banditHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);

        banditBody = new ModelRenderer(this, 16, 16);
        banditBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, par1);
        banditBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);

        banditRightArm = new ModelRenderer(this, 40, 16);
        banditRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, par1);
        banditRightArm.setRotationPoint(-5F, 2.0F + par2, 0.0F);

        banditLeftArm = new ModelRenderer(this, 40, 16);
        banditLeftArm.mirror = true;
        banditLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, par1);
        banditLeftArm.setRotationPoint(5F, 2.0F + par2, 0.0F);

        banditRightLeg = new ModelRenderer(this, 0, 16);
        banditRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        banditRightLeg.setRotationPoint(-1.9F, 12F + par2, 0.0F);

        banditLeftLeg = new ModelRenderer(this, 0, 16);
        banditLeftLeg.mirror = true;
        banditLeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, par1);
        banditLeftLeg.setRotationPoint(1.9F, 12F + par2, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

            banditHead.render(par7);
            banditBody.render(par7);
            banditRightArm.render(par7);
            banditLeftArm.render(par7);
            banditRightLeg.render(par7);
            banditLeftLeg.render(par7);
            banditHeadwear.render(par7);
        }


    /**
     * Sets the model's various rotation angles. For bandits, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        banditHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        banditHead.rotateAngleX = par5 / (180F / (float)Math.PI);

        banditHeadwear.rotateAngleY = banditHead.rotateAngleY;
        banditHeadwear.rotateAngleX = banditHead.rotateAngleX;

            banditRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
            banditLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
            banditLeftArm.rotateAngleZ = 0.0F;
            banditRightArm.rotateAngleZ = 0.0F;

        banditRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        banditLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        banditRightLeg.rotateAngleY = 0.0F;
        banditLeftLeg.rotateAngleY = 0.0F;

        }

    /**
     * Renders the cloak of the current bandit (in most cases, it's a player)
     */
    public void renderCloak(float par1)
    {
        banditCloak.render(par1);
    }

}
