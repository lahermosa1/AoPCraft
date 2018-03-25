package com.infiniteeggcreations.aopcraft.borna.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSoldierBornan - Lahermosa1, 3-22-2018
 * Created using Tabula 7.0.0
 */
public class ModelSoldierBornan extends ModelBase
{
    public ModelRenderer humanoidArmLeft;
    public ModelRenderer humanoidLegRight;
    public ModelRenderer humanoidHeadSmall;
    public ModelRenderer humanoidLegLeft;
    public ModelRenderer humanoidArmRight;
    public ModelRenderer humanoidChest;

    public ModelSoldierBornan()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.humanoidChest = new ModelRenderer(this, 16, 32);
        this.humanoidChest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.humanoidChest.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);

        this.humanoidLegRight = new ModelRenderer(this, 0, 32);
        this.humanoidLegRight.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.humanoidLegRight.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);

        this.humanoidArmLeft = new ModelRenderer(this, 48, 48);
        this.humanoidArmLeft.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.humanoidArmLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);

        this.humanoidHeadSmall = new ModelRenderer(this, 0, 0);
        this.humanoidHeadSmall.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.humanoidHeadSmall.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);


        this.humanoidLegLeft = new ModelRenderer(this, 0, 48);
        this.humanoidLegLeft.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.humanoidLegLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.humanoidLegLeft.mirror = true;

        this.humanoidArmRight = new ModelRenderer(this, 40, 16);
        this.humanoidArmRight.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.humanoidArmRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.humanoidChest.render(f5);
        this.humanoidLegRight.render(f5);
        this.humanoidArmLeft.render(f5);
        this.humanoidHeadSmall.render(f5);
        this.humanoidLegLeft.render(f5);
        this.humanoidArmRight.render(f5);

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    // float limbSwing(par1), float limbSwingAmount(par2), float ageInTicks(par3), float netHeadYaw(par4), float headPitch(par5), float scaleFactor(par6), Entity entityIn(par7):
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        // LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.humanoidLegLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        // RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.humanoidLegRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.humanoidLegLeft.rotateAngleY = 0.0F;
        this.humanoidLegRight.rotateAngleY = 0.0F;

        // Head.rotateAngleY = par5 (headPitch) / (180F / (float)Math.PI);
        this.humanoidHeadSmall.rotateAngleX = headPitch / (180F / (float)Math.PI);

        // Head.rotateAngleY = par4 (netHeadYaw) / (180F / (float)Math.PI);
        this.humanoidHeadSmall.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);

        // RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        this.humanoidArmRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        // LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        this.humanoidArmLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

        // RightArm.rotateAngleZ = 0.0F;
        this.humanoidArmRight.rotateAngleZ = 0.0F;

        // LeftArm.rotateAngleZ = 0.0F;
        this.humanoidArmLeft.rotateAngleZ = 0.0F;

    }
}
