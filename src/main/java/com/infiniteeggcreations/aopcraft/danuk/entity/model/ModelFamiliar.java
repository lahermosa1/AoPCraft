package com.infiniteeggcreations.aopcraft.danuk.entity.model;

import com.infiniteeggcreations.aopcraft.danuk.entity.EntityFamiliar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

/**
 * ModelFamiliar - Lahermosa1
 * Created using Tabula 7.0.0 on 3/23/2018
 */
public class ModelFamiliar extends ModelBase
{
    private ModelRenderer wingLeft;
    private ModelRenderer armRight;
    public ModelRenderer head;
    private ModelRenderer torso;
    private ModelRenderer armLeft;
    private ModelRenderer wingRight;
    private ModelRenderer tentacleFrontLeft;
    private ModelRenderer tentacleFrontMid;
    private ModelRenderer tentacleFrontRight;
    private ModelRenderer tentacleSideRight;
    private ModelRenderer tentacleBackRight;
    private ModelRenderer tentacleBackMid;
    private ModelRenderer tentacleBackLeft;
    private ModelRenderer tentacleSideLeft;

    public ModelFamiliar()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tentacleBackLeft = new ModelRenderer(this, 48, 0);
        this.tentacleBackLeft.setRotationPoint(3.54F, 12.0F, 1.94F);
        this.tentacleBackLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleBackLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.wingLeft = new ModelRenderer(this, 0, 32);
        this.wingLeft.mirror = true;
        this.wingLeft.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.wingLeft.addBox(0.0F, 0.0F, 0.0F, 20, 12, 1, 0.0F);
        this.setRotateAngle(wingLeft, 0.47123889803846897F, -0.6283185307179586F, -0.47123889803846897F);
        this.tentacleFrontLeft = new ModelRenderer(this, 48, 0);
        this.tentacleFrontLeft.setRotationPoint(3.54F, 12.0F, -2.04F);
        this.tentacleFrontLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleFrontLeft, 0.0F, -3.9269908169872414F, 0.0F);
        this.tentacleSideRight = new ModelRenderer(this, 48, 0);
        this.tentacleSideRight.setRotationPoint(-4.0F, 12.0F, -0.1F);
        this.tentacleSideRight.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleSideRight, 0.0F, -1.5707963267948966F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.armLeft = new ModelRenderer(this, 40, 16);
        this.armLeft.mirror = true;
        this.armLeft.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.armLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.wingRight = new ModelRenderer(this, 0, 32);
        this.wingRight.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.wingRight.addBox(-20.0F, 0.0F, 0.0F, 20, 12, 1, 0.0F);
        this.setRotateAngle(wingRight, 0.47123889803846897F, 0.6283185307179586F, 0.47123889803846897F);
        this.tentacleBackRight = new ModelRenderer(this, 48, 0);
        this.tentacleBackRight.setRotationPoint(-3.54F, 12.0F, 1.94F);
        this.tentacleBackRight.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleBackRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.torso = new ModelRenderer(this, 16, 16);
        this.torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.tentacleFrontMid = new ModelRenderer(this, 48, 0);
        this.tentacleFrontMid.setRotationPoint(-0.0F, 12.0F, -2.1F);
        this.tentacleFrontMid.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleFrontMid, 0.0F, -3.141592653589793F, 0.0F);
        this.tentacleFrontRight = new ModelRenderer(this, 48, 0);
        this.tentacleFrontRight.setRotationPoint(-3.64F, 12.0F, -1.94F);
        this.tentacleFrontRight.addBox(-1.0F, 0.1F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleFrontRight, 0.0F, -2.356194490192345F, 0.0F);
        this.armRight = new ModelRenderer(this, 40, 16);
        this.armRight.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.armRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.tentacleSideLeft = new ModelRenderer(this, 48, 0);
        this.tentacleSideLeft.setRotationPoint(4.0F, 12.0F, 0.0F);
        this.tentacleSideLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
        this.setRotateAngle(tentacleSideLeft, 0.0F, 1.5707963267948966F, 0.0F);
        this.tentacleBackMid = new ModelRenderer(this, 48, 0);
        this.tentacleBackMid.setRotationPoint(0.0F, 12.0F, 1.9F);
        this.tentacleBackMid.addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleBackLeft.offsetX, this.tentacleBackLeft.offsetY, this.tentacleBackLeft.offsetZ);
        GlStateManager.translate(this.tentacleBackLeft.rotationPointX * f5, this.tentacleBackLeft.rotationPointY * f5, this.tentacleBackLeft.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleBackLeft.offsetX, -this.tentacleBackLeft.offsetY, -this.tentacleBackLeft.offsetZ);
        GlStateManager.translate(-this.tentacleBackLeft.rotationPointX * f5, -this.tentacleBackLeft.rotationPointY * f5, -this.tentacleBackLeft.rotationPointZ * f5);
        this.tentacleBackLeft.render(f5);
        GlStateManager.popMatrix();
        this.wingLeft.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleFrontLeft.offsetX, this.tentacleFrontLeft.offsetY, this.tentacleFrontLeft.offsetZ);
        GlStateManager.translate(this.tentacleFrontLeft.rotationPointX * f5, this.tentacleFrontLeft.rotationPointY * f5, this.tentacleFrontLeft.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleFrontLeft.offsetX, -this.tentacleFrontLeft.offsetY, -this.tentacleFrontLeft.offsetZ);
        GlStateManager.translate(-this.tentacleFrontLeft.rotationPointX * f5, -this.tentacleFrontLeft.rotationPointY * f5, -this.tentacleFrontLeft.rotationPointZ * f5);
        this.tentacleFrontLeft.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleSideRight.offsetX, this.tentacleSideRight.offsetY, this.tentacleSideRight.offsetZ);
        GlStateManager.translate(this.tentacleSideRight.rotationPointX * f5, this.tentacleSideRight.rotationPointY * f5, this.tentacleSideRight.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleSideRight.offsetX, -this.tentacleSideRight.offsetY, -this.tentacleSideRight.offsetZ);
        GlStateManager.translate(-this.tentacleSideRight.rotationPointX * f5, -this.tentacleSideRight.rotationPointY * f5, -this.tentacleSideRight.rotationPointZ * f5);
        this.tentacleSideRight.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
        GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 0.6D);
        GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
        GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
        this.head.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.armLeft.offsetX, this.armLeft.offsetY, this.armLeft.offsetZ);
        GlStateManager.translate(this.armLeft.rotationPointX * f5, this.armLeft.rotationPointY * f5, this.armLeft.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 1.2D, 0.5D);
        GlStateManager.translate(-this.armLeft.offsetX, -this.armLeft.offsetY, -this.armLeft.offsetZ);
        GlStateManager.translate(-this.armLeft.rotationPointX * f5, -this.armLeft.rotationPointY * f5, -this.armLeft.rotationPointZ * f5);
        this.armLeft.render(f5);
        GlStateManager.popMatrix();
        this.wingRight.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleBackRight.offsetX, this.tentacleBackRight.offsetY, this.tentacleBackRight.offsetZ);
        GlStateManager.translate(this.tentacleBackRight.rotationPointX * f5, this.tentacleBackRight.rotationPointY * f5, this.tentacleBackRight.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleBackRight.offsetX, -this.tentacleBackRight.offsetY, -this.tentacleBackRight.offsetZ);
        GlStateManager.translate(-this.tentacleBackRight.rotationPointX * f5, -this.tentacleBackRight.rotationPointY * f5, -this.tentacleBackRight.rotationPointZ * f5);
        this.tentacleBackRight.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.torso.offsetX, this.torso.offsetY, this.torso.offsetZ);
        GlStateManager.translate(this.torso.rotationPointX * f5, this.torso.rotationPointY * f5, this.torso.rotationPointZ * f5);
        GlStateManager.scale(1.2D, 1.0D, 1.4D);
        GlStateManager.translate(-this.torso.offsetX, -this.torso.offsetY, -this.torso.offsetZ);
        GlStateManager.translate(-this.torso.rotationPointX * f5, -this.torso.rotationPointY * f5, -this.torso.rotationPointZ * f5);
        this.torso.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleFrontMid.offsetX, this.tentacleFrontMid.offsetY, this.tentacleFrontMid.offsetZ);
        GlStateManager.translate(this.tentacleFrontMid.rotationPointX * f5, this.tentacleFrontMid.rotationPointY * f5, this.tentacleFrontMid.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.8D);
        GlStateManager.translate(-this.tentacleFrontMid.offsetX, -this.tentacleFrontMid.offsetY, -this.tentacleFrontMid.offsetZ);
        GlStateManager.translate(-this.tentacleFrontMid.rotationPointX * f5, -this.tentacleFrontMid.rotationPointY * f5, -this.tentacleFrontMid.rotationPointZ * f5);
        this.tentacleFrontMid.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleFrontRight.offsetX, this.tentacleFrontRight.offsetY, this.tentacleFrontRight.offsetZ);
        GlStateManager.translate(this.tentacleFrontRight.rotationPointX * f5, this.tentacleFrontRight.rotationPointY * f5, this.tentacleFrontRight.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleFrontRight.offsetX, -this.tentacleFrontRight.offsetY, -this.tentacleFrontRight.offsetZ);
        GlStateManager.translate(-this.tentacleFrontRight.rotationPointX * f5, -this.tentacleFrontRight.rotationPointY * f5, -this.tentacleFrontRight.rotationPointZ * f5);
        this.tentacleFrontRight.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.armRight.offsetX, this.armRight.offsetY, this.armRight.offsetZ);
        GlStateManager.translate(this.armRight.rotationPointX * f5, this.armRight.rotationPointY * f5, this.armRight.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 1.2D, 0.5D);
        GlStateManager.translate(-this.armRight.offsetX, -this.armRight.offsetY, -this.armRight.offsetZ);
        GlStateManager.translate(-this.armRight.rotationPointX * f5, -this.armRight.rotationPointY * f5, -this.armRight.rotationPointZ * f5);
        this.armRight.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleSideLeft.offsetX, this.tentacleSideLeft.offsetY, this.tentacleSideLeft.offsetZ);
        GlStateManager.translate(this.tentacleSideLeft.rotationPointX * f5, this.tentacleSideLeft.rotationPointY * f5, this.tentacleSideLeft.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleSideLeft.offsetX, -this.tentacleSideLeft.offsetY, -this.tentacleSideLeft.offsetZ);
        GlStateManager.translate(-this.tentacleSideLeft.rotationPointX * f5, -this.tentacleSideLeft.rotationPointY * f5, -this.tentacleSideLeft.rotationPointZ * f5);
        this.tentacleSideLeft.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.tentacleBackMid.offsetX, this.tentacleBackMid.offsetY, this.tentacleBackMid.offsetZ);
        GlStateManager.translate(this.tentacleBackMid.rotationPointX * f5, this.tentacleBackMid.rotationPointY * f5, this.tentacleBackMid.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 1.0D, 0.7D);
        GlStateManager.translate(-this.tentacleBackMid.offsetX, -this.tentacleBackMid.offsetY, -this.tentacleBackMid.offsetZ);
        GlStateManager.translate(-this.tentacleBackMid.rotationPointX * f5, -this.tentacleBackMid.rotationPointY * f5, -this.tentacleBackMid.rotationPointZ * f5);
        this.tentacleBackMid.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    
    @Override
    // float limbSwing(par1), float limbSwingAmount(par2), float ageInTicks(par3), float netHeadYaw(par4), float headPitch(par5), float scaleFactor(par6), Entity entityIn(par7):
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        // Charging arm movement (from Vex):
        EntityFamiliar entityFamiliar = (EntityFamiliar)entityIn;

        if (entityFamiliar.isCharging())
        {
            if (entityFamiliar.getPrimaryHand() == EnumHandSide.RIGHT)
            {
                this.armRight.rotateAngleX = 3.7699115F;
            }
            else
            {
                this.armLeft.rotateAngleX = 3.7699115F;
            }
        }
        
        // RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        this.armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        // LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        this.armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        
        // RightArm.rotateAngleZ = 0.0F;
        this.armRight.rotateAngleZ = 0.0F;
        
        // LeftArm.rotateAngleZ = 0.0F;
        this.armLeft.rotateAngleZ = 0.0F;
        
        // Wings (from EntityVex):
        this.wingRight.rotationPointZ = 2.0F;
        this.wingLeft.rotationPointZ = 2.0F;
        this.wingRight.rotationPointY = 1.0F;
        this.wingLeft.rotationPointY = 1.0F;
        this.wingRight.rotateAngleY = 0.47123894F + MathHelper.cos(ageInTicks * 0.8F) * (float)Math.PI * 0.05F;
        this.wingLeft.rotateAngleY = -this.wingRight.rotateAngleY;
        this.wingLeft.rotateAngleZ = -0.47123894F;
        this.wingLeft.rotateAngleX = 0.47123894F;
        this.wingRight.rotateAngleX = 0.47123894F;
        this.wingRight.rotateAngleZ = 0.47123894F;

        // Head.rotateAngleY = par5 (headPitch) / (180F / (float)Math.PI);
        this.head.rotateAngleX = headPitch / (180F / (float)Math.PI);

        // Head.rotateAngleY = par4 (netHeadYaw) / (180F / (float)Math.PI);
        this.head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);

        // Tentacles (using spider model):
        //float f = ((float)Math.PI / 4F);
        this.tentacleFrontLeft.rotateAngleZ = -((float)Math.PI / 4F);
        this.tentacleFrontRight.rotateAngleZ = ((float)Math.PI / 4F);
        this.tentacleFrontMid.rotateAngleZ = -0.58119464F;
        this.tentacleBackMid.rotateAngleZ = 0.58119464F;
        this.tentacleBackLeft.rotateAngleZ = -((float)Math.PI / 4F);
        this.tentacleBackRight.rotateAngleZ = ((float)Math.PI / 4F);
        //float f1 = -0.0F;
        //float f2 = 0.3926991F;
        this.tentacleFrontLeft.rotateAngleY = ((float)Math.PI / 4F);
        this.tentacleFrontRight.rotateAngleY = -((float)Math.PI / 4F);
        this.tentacleFrontMid.rotateAngleY = 0.3926991F;
        this.tentacleBackMid.rotateAngleY = -0.3926991F;
        this.tentacleBackLeft.rotateAngleY = -((float)Math.PI / 4F);
        this.tentacleBackRight.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.tentacleFrontLeft.rotateAngleY += f3;
        this.tentacleFrontRight.rotateAngleY += -f3;
        this.tentacleFrontMid.rotateAngleY += f4;
        this.tentacleBackMid.rotateAngleY += -f4;
        this.tentacleBackLeft.rotateAngleY += f5;
        this.tentacleBackRight.rotateAngleY += -f5;
        this.tentacleFrontLeft.rotateAngleZ += f6;
        this.tentacleFrontRight.rotateAngleZ += -f6;
        this.tentacleFrontMid.rotateAngleZ += f7;
        this.tentacleBackMid.rotateAngleZ += -f7;
        this.tentacleBackLeft.rotateAngleZ += f8;
        this.tentacleBackRight.rotateAngleZ += -f8;
    }
    
}
