package com.infiniteeggcreations.aopcraft.core.entity.boss.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBossPhoenix - Lahermosa1 using CustomNPC texture by Noppes.
 * Created using Tabula 7.0.0
 */
public class ModelBossPhoenix extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer talonMedialLeft;
    public ModelRenderer thighRight;
    public ModelRenderer neck;
    public ModelRenderer body;
    public ModelRenderer wingLeft;
    public ModelRenderer thighLeft;
    public ModelRenderer wingRight;
    public ModelRenderer talonMiddleLeft;
    public ModelRenderer talonLateralLeft;
    public ModelRenderer talonLateralRight;
    public ModelRenderer talonMiddleRight;
    public ModelRenderer talonMedialRight;
    public ModelRenderer wingRightBack;
    public ModelRenderer wingLeftBack;
    public ModelRenderer maneRight;
    public ModelRenderer maneLeft;
    public ModelRenderer beakUpper;
    public ModelRenderer beakLower;
    public ModelRenderer legRight;
    public ModelRenderer footRight;
    public ModelRenderer legLeft;
    public ModelRenderer footLeft;

    public ModelBossPhoenix() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.wingLeftBack = new ModelRenderer(this, -56, 88);
        this.wingLeftBack.setRotationPoint(-5.0F, -51.4F, 41.9F);
        this.wingLeftBack.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(wingLeftBack, -1.4632840448720459F, 0.05811946409141117F, -0.3078760800517997F);
        this.maneRight = new ModelRenderer(this, -56, 88);
        this.maneRight.setRotationPoint(-0.4F, -54.3F, 34.0F);
        this.maneRight.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(maneRight, -2.1399481958702475F, -2.7317893452215247F, 0.9560913642424937F);
        this.wingRightBack = new ModelRenderer(this, -56, 88);
        this.wingRightBack.setRotationPoint(0.1F, -51.3F, 40.8F);
        this.wingRightBack.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(wingRightBack, -1.6943656378360952F, 3.141592653589793F, 0.3518583772020568F);
        this.beakLower = new ModelRenderer(this, 176, 65);
        this.beakLower.setRotationPoint(0.0F, -0.3F, -5.3F);
        this.beakLower.addBox(-6.0F, 0.0F, -16.0F, 8, 3, 16, 0.0F);
        this.setRotateAngle(beakLower, 0.20001473227855018F, 0.0F, 0.0F);
        this.wingLeft = new ModelRenderer(this, -56, 88);
        this.wingLeft.setRotationPoint(7.3F, -48.3F, 44.0F);
        this.wingLeft.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(wingLeft, -1.4570008595648662F, 0.045553093477052F, 0.0F);
        this.footRight = new ModelRenderer(this, 112, 0);
        this.footRight.setRotationPoint(-2.2F, 33.1F, 6.2F);
        this.footRight.addBox(-6.5F, -0.2F, -20.0F, 10, 4, 16, 0.0F);
        this.setRotateAngle(footRight, 0.7517133088339577F, 0.0F, 0.0F);
        this.talonMiddleLeft = new ModelRenderer(this, 0, 0);
        this.talonMiddleLeft.mirror = true;
        this.talonMiddleLeft.setRotationPoint(8.5F, 70.0F, 53.0F);
        this.talonMiddleLeft.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonMiddleLeft, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.talonLateralRight = new ModelRenderer(this, 48, 19);
        this.talonLateralRight.mirror = true;
        this.talonLateralRight.setRotationPoint(-11.2F, 70.0F, 53.0F);
        this.talonLateralRight.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonLateralRight, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.beakUpper = new ModelRenderer(this, 176, 44);
        this.beakUpper.setRotationPoint(2.2F, 0.4F, -3.2F);
        this.beakUpper.addBox(-6.0F, -1.0F, -24.0F, 8, 4, 16, 0.0F);
        this.thighRight = new ModelRenderer(this, 0, 0);
        this.thighRight.setRotationPoint(-10.0F, 4.0F, 36.6F);
        this.thighRight.addBox(-8.5F, -4.0F, -8.0F, 16, 24, 16, 0.0F);
        this.setRotateAngle(thighRight, 6.283185307179586F, 0.0F, 0.0F);
        this.footLeft = new ModelRenderer(this, 112, 0);
        this.footLeft.setRotationPoint(-2.5F, 33.1F, 6.2F);
        this.footLeft.addBox(-6.5F, -0.2F, -20.0F, 10, 4, 16, 0.0F);
        this.setRotateAngle(footLeft, 0.7517133088339577F, 0.0F, 0.0F);
        this.talonLateralLeft = new ModelRenderer(this, 48, 19);
        this.talonLateralLeft.mirror = true;
        this.talonLateralLeft.setRotationPoint(11.8F, 70.0F, 53.0F);
        this.talonLateralLeft.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonLateralLeft, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.thighLeft = new ModelRenderer(this, 0, 0);
        this.thighLeft.setRotationPoint(7.0F, 4.0F, 36.6F);
        this.thighLeft.addBox(-8.5F, -4.0F, -8.0F, 16, 24, 16, 0.0F);
        this.setRotateAngle(thighLeft, 6.283185307179586F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-2.0F, -34.0F, 47.0F);
        this.body.addBox(-12.0F, 0.0F, -16.0F, 24, 20, 64, 0.0F);
        this.setRotateAngle(body, -1.5707963267948966F, 0.0F, 0.0F);
        this.talonMedialRight = new ModelRenderer(this, 48, 19);
        this.talonMedialRight.mirror = true;
        this.talonMedialRight.setRotationPoint(-4.8F, 70.0F, 53.0F);
        this.talonMedialRight.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonMedialRight, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.legRight = new ModelRenderer(this, 196, 0);
        this.legRight.setRotationPoint(3.9F, 16.8F, -6.7F);
        this.legRight.addBox(-6.2F, -2.1F, 3.0F, 4, 38, 5, 0.0F);
        this.setRotateAngle(legRight, 0.5017821599483697F, 0.0F, 0.0F);
        this.maneLeft = new ModelRenderer(this, -56, 88);
        this.maneLeft.setRotationPoint(-4.7F, -53.7F, 37.1F);
        this.maneLeft.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(maneLeft, -1.1838568316277536F, -0.40980330836826856F, -0.9560913642424937F);
        this.wingRight = new ModelRenderer(this, -56, 88);
        this.wingRight.setRotationPoint(-11.2F, -48.5F, 44.1F);
        this.wingRight.addBox(0.0F, 0.0F, 0.0F, 56, 1, 56, 0.0F);
        this.setRotateAngle(wingRight, -1.6800539379697417F, 3.141592653589793F, 0.006283185307179587F);
        this.talonMiddleRight = new ModelRenderer(this, 48, 19);
        this.talonMiddleRight.mirror = true;
        this.talonMiddleRight.setRotationPoint(-8.1F, 70.0F, 53.0F);
        this.talonMiddleRight.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonMiddleRight, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.legLeft = new ModelRenderer(this, 196, 0);
        this.legLeft.setRotationPoint(3.9F, 16.8F, -6.7F);
        this.legLeft.addBox(-6.2F, -2.1F, 3.0F, 4, 38, 5, 0.0F);
        this.setRotateAngle(legLeft, 0.5017821599483697F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 112, 30);
        this.head.setRotationPoint(-2.0F, -60.7F, 38.5F);
        this.head.addBox(-8.0F, -8.0F, -10.0F, 16, 16, 16, 0.0F);
        this.setRotateAngle(head, 0.0F, 0.006283185307179587F, 0.0F);
        this.talonMedialLeft = new ModelRenderer(this, 0, 0);
        this.talonMedialLeft.mirror = true;
        this.talonMedialLeft.setRotationPoint(5.3F, 70.0F, 53.0F);
        this.talonMedialLeft.addBox(0.7F, -9.8F, -2.1F, 2, 3, 16, 0.0F);
        this.setRotateAngle(talonMedialLeft, -1.2906709818498066F, -3.141592653589793F, 0.0F);
        this.neck = new ModelRenderer(this, 192, 104);
        this.neck.setRotationPoint(0.0F, -49.3F, 34.9F);
        this.neck.addBox(-3.5F, -4.0F, -5.0F, 11, 11, 9, 0.0F);
        this.setRotateAngle(neck, -1.5707963267948966F, 3.141592653589793F, -0.0F);
        this.beakUpper.addChild(this.beakLower);
        this.legRight.addChild(this.footRight);
        this.head.addChild(this.beakUpper);
        this.legLeft.addChild(this.footLeft);
        this.thighRight.addChild(this.legRight);
        this.thighLeft.addChild(this.legLeft);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.wingLeftBack.render(f5);
        this.maneRight.render(f5);
        this.wingRightBack.render(f5);
        this.wingLeft.render(f5);
        this.talonMiddleLeft.render(f5);
        this.talonLateralRight.render(f5);
        this.thighRight.render(f5);
        this.talonLateralLeft.render(f5);
        this.thighLeft.render(f5);
        this.body.render(f5);
        this.talonMedialRight.render(f5);
        this.maneLeft.render(f5);
        this.wingRight.render(f5);
        this.talonMiddleRight.render(f5);
        this.head.render(f5);
        this.talonMedialLeft.render(f5);
        this.neck.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
