package kittehmod.morecraft.client;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class EnderdragonLegsModel extends BipedModel<LivingEntity>
{
	//fields
	ModelRenderer leftlegplate1;
	ModelRenderer leftlegplate2;
	ModelRenderer leftlegplate3;
	ModelRenderer rightlegplate1;
	ModelRenderer rightlegplate2;
	ModelRenderer rightlegplate3;
	ModelRenderer loincloth;
	ModelRenderer tailbase;
	ModelRenderer tailspike1;
	ModelRenderer tailspike2;
	ModelRenderer tailspike3;

	private static int textureWidth = 64;
	private static int textureHeight = 32;
	
	public EnderdragonLegsModel(float expand)
	{
		super(expand, 0.0F, textureWidth, textureHeight);

		//-- LEGS --\\
		leftlegplate1 = new ModelRenderer(this, 32, 0);
		leftlegplate1.addBox(2.0F, -1.5F, -1.5F, 1, 3, 3);
		leftlegplate1.setPos(0F, 0F, 0F);
		leftlegplate1.setTexSize(textureWidth, textureHeight);
		leftlegplate1.mirror = true;
		setRotation(leftlegplate1, 0.7853982F, 0F, -0.0872665F);

		leftlegplate2 = new ModelRenderer(this, 32, 0);
		leftlegplate2.addBox(1.8F, -0.5F, -2.5F, 1, 3, 3);
		leftlegplate2.setPos(0F, 0F, 0F);
		leftlegplate2.setTexSize(textureWidth, textureHeight);
		leftlegplate2.mirror = true;
		setRotation(leftlegplate2, 0.7853982F, 0F, -0.0872665F);

		leftlegplate3 = new ModelRenderer(this, 32, 0);
		leftlegplate3.addBox(1.6F, 0.5F, -3.5F, 1, 3, 3);
		leftlegplate3.setPos(0F, 0F, 0F);
		leftlegplate3.setTexSize(textureWidth, textureHeight);
		leftlegplate3.mirror = true;
		setRotation(leftlegplate3, 0.7853982F, 0F, -0.0872665F);

		rightlegplate1 = new ModelRenderer(this, 32, 0);
		rightlegplate1.addBox(-3.0F, -1.5F, -1.5F, 1, 3, 3);
		rightlegplate1.setPos(0F, 0F, 0F);
		rightlegplate1.setTexSize(textureWidth, textureHeight);
		rightlegplate1.mirror = true;
		setRotation(rightlegplate1, 0.7853982F, 0F, 0.0872665F);

		rightlegplate2 = new ModelRenderer(this, 32, 0);
		rightlegplate2.addBox(-2.8F, -0.5F, -2.5F, 1, 3, 3);
		rightlegplate2.setPos(0F, 0F, 0F);
		rightlegplate2.setTexSize(textureWidth, textureHeight);
		rightlegplate2.mirror = true;
		setRotation(rightlegplate2, 0.7853982F, 0F, 0.0872665F);

		rightlegplate3 = new ModelRenderer(this, 32, 0);
		rightlegplate3.addBox(-2.6F, 0.5F, -3.5F, 1, 3, 3);
		rightlegplate3.setPos(0F, 0F, 0F);
		rightlegplate3.setTexSize(textureWidth, textureHeight);
		rightlegplate3.mirror = true;
		setRotation(rightlegplate3, 0.7853982F, 0F, 0.0872665F);

		loincloth = new ModelRenderer(this, 32, 6);
		loincloth.addBox(-2F, 11.5F, -1.9F, 4, 5, 1);
		loincloth.setPos(0F, 0F, 0F);
		loincloth.setTexSize(textureWidth, textureHeight);
		loincloth.mirror = true;
		setRotation(loincloth, -0.0523599F, 0F, 0F);

		tailbase = new ModelRenderer(this, 42, 0);
		tailbase.addBox(-1F, 5.5F, 9.966666F, 2, 2, 9);
		tailbase.setPos(0F, 0F, 0F);
		tailbase.setTexSize(textureWidth, textureHeight);
		tailbase.mirror = true;
		setRotation(tailbase, -0.8726646F, 0F, 0F);
		
		tailspike1 = new ModelRenderer(this, 42, 12);
		tailspike1.addBox(-0.5F, 4.5F, 11F, 1, 2, 2);
		tailspike1.setPos(0F, 0F, 0F);
		tailspike1.setTexSize(textureWidth, textureHeight);
		tailspike1.mirror = true;
		setRotation(tailspike1, 0F, 0F, 0F);
		
		tailspike2 = new ModelRenderer(this, 42, 12);
		tailspike2.addBox(-0.5F, 4.5F, 13.5F, 1, 2, 2);
		tailspike2.setPos(0F, 0F, 0F);
		tailspike2.setTexSize(textureWidth, textureHeight);
		tailspike2.mirror = true;
		setRotation(tailspike2, 0F, 0F, 0F);
		
		tailspike3 = new ModelRenderer(this, 42, 12);
		tailspike3.addBox(-0.5F, 4.5F, 16F, 1, 2, 2);
		tailspike3.setPos(0F, 0F, 0F);
		tailspike3.setTexSize(textureWidth, textureHeight);
		tailspike3.mirror = true;
		setRotation(tailspike3, 0F, 0F, 0F);

		this.leftLeg.addChild(leftlegplate1);
		this.leftLeg.addChild(leftlegplate2);
		this.leftLeg.addChild(leftlegplate3);
		this.rightLeg.addChild(rightlegplate1);
		this.rightLeg.addChild(rightlegplate2);
		this.rightLeg.addChild(rightlegplate3);
		this.body.addChild(loincloth);
		tailbase.addChild(tailspike1);
		tailbase.addChild(tailspike2);
		tailbase.addChild(tailspike3);
		this.body.addChild(tailbase);
	}

	/*public void render(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		super.render(entityIn, f, f1, f2, f3, f4, f5);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		//Move part depending on sneak
		setRotation(loincloth, this.isSneak ? -0.5F : -0.0523599F, 0F, 0F);
		loincloth.offsetY = this.isSneak ? -0.06F : 0F;
		loincloth.offsetZ = this.isSneak ? 0.06F : 0F;
		loincloth.rotationPointZ = this.isSneak ? (float) Math.PI : 0F;
	}*/

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

}
