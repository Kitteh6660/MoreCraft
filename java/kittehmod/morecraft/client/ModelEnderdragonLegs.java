package kittehmod.morecraft.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderdragonLegs extends ModelBiped
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

	public ModelEnderdragonLegs(float expand)
	{
		super(expand, 0, textureWidth, textureHeight);

		//-- LEGS --\\
		leftlegplate1 = new ModelRenderer(this, 32, 0);
		leftlegplate1.addBox(2.0F, -1.5F, -1.5F, 1, 3, 3);
		leftlegplate1.setRotationPoint(0F, 0F, 0F);
		leftlegplate1.setTextureSize(textureWidth, textureHeight);
		leftlegplate1.mirror = true;
		setRotation(leftlegplate1, 0.7853982F, 0F, -0.0872665F);

		leftlegplate2 = new ModelRenderer(this, 32, 0);
		leftlegplate2.addBox(1.8F, -0.5F, -2.5F, 1, 3, 3);
		leftlegplate2.setRotationPoint(0F, 0F, 0F);
		leftlegplate2.setTextureSize(textureWidth, textureHeight);
		leftlegplate2.mirror = true;
		setRotation(leftlegplate2, 0.7853982F, 0F, -0.0872665F);

		leftlegplate3 = new ModelRenderer(this, 32, 0);
		leftlegplate3.addBox(1.6F, 0.5F, -3.5F, 1, 3, 3);
		leftlegplate3.setRotationPoint(0F, 0F, 0F);
		leftlegplate3.setTextureSize(textureWidth, textureHeight);
		leftlegplate3.mirror = true;
		setRotation(leftlegplate3, 0.7853982F, 0F, -0.0872665F);

		rightlegplate1 = new ModelRenderer(this, 32, 0);
		rightlegplate1.addBox(-3.0F, -1.5F, -1.5F, 1, 3, 3);
		rightlegplate1.setRotationPoint(0F, 0F, 0F);
		rightlegplate1.setTextureSize(textureWidth, textureHeight);
		rightlegplate1.mirror = true;
		setRotation(rightlegplate1, 0.7853982F, 0F, 0.0872665F);

		rightlegplate2 = new ModelRenderer(this, 32, 0);
		rightlegplate2.addBox(-2.8F, -0.5F, -2.5F, 1, 3, 3);
		rightlegplate2.setRotationPoint(0F, 0F, 0F);
		rightlegplate2.setTextureSize(textureWidth, textureHeight);
		rightlegplate2.mirror = true;
		setRotation(rightlegplate2, 0.7853982F, 0F, 0.0872665F);

		rightlegplate3 = new ModelRenderer(this, 32, 0);
		rightlegplate3.addBox(-2.6F, 0.5F, -3.5F, 1, 3, 3);
		rightlegplate3.setRotationPoint(0F, 0F, 0F);
		rightlegplate3.setTextureSize(textureWidth, textureHeight);
		rightlegplate3.mirror = true;
		setRotation(rightlegplate3, 0.7853982F, 0F, 0.0872665F);

		loincloth = new ModelRenderer(this, 32, 6);
		loincloth.addBox(-2F, 11.5F, -1.9F, 4, 5, 1);
		loincloth.setRotationPoint(0F, 0F, 0F);
		loincloth.setTextureSize(textureWidth, textureHeight);
		loincloth.mirror = true;
		setRotation(loincloth, -0.0523599F, 0F, 0F);

		tailbase = new ModelRenderer(this, 42, 0);
		tailbase.addBox(-1F, 5.5F, 9.966666F, 2, 2, 9);
		tailbase.setRotationPoint(0F, 0F, 0F);
		tailbase.setTextureSize(textureWidth, textureHeight);
		tailbase.mirror = true;
		setRotation(tailbase, -0.8726646F, 0F, 0F);
		
		tailspike1 = new ModelRenderer(this, 42, 12);
		tailspike1.addBox(-0.5F, 4.5F, 11F, 1, 2, 2);
		tailspike1.setRotationPoint(0F, 0F, 0F);
		tailspike1.setTextureSize(textureWidth, textureHeight);
		tailspike1.mirror = true;
		setRotation(tailspike1, 0F, 0F, 0F);
		
		tailspike2 = new ModelRenderer(this, 42, 12);
		tailspike2.addBox(-0.5F, 4.5F, 13.5F, 1, 2, 2);
		tailspike2.setRotationPoint(0F, 0F, 0F);
		tailspike2.setTextureSize(textureWidth, textureHeight);
		tailspike2.mirror = true;
		setRotation(tailspike2, 0F, 0F, 0F);
		
		tailspike3 = new ModelRenderer(this, 42, 12);
		tailspike3.addBox(-0.5F, 4.5F, 16F, 1, 2, 2);
		tailspike3.setRotationPoint(0F, 0F, 0F);
		tailspike3.setTextureSize(textureWidth, textureHeight);
		tailspike3.mirror = true;
		setRotation(tailspike3, 0F, 0F, 0F);

		this.bipedLeftLeg.addChild(leftlegplate1);
		this.bipedLeftLeg.addChild(leftlegplate2);
		this.bipedLeftLeg.addChild(leftlegplate3);
		this.bipedRightLeg.addChild(rightlegplate1);
		this.bipedRightLeg.addChild(rightlegplate2);
		this.bipedRightLeg.addChild(rightlegplate3);
		this.bipedBody.addChild(loincloth);
		tailbase.addChild(tailspike1);
		tailbase.addChild(tailspike2);
		tailbase.addChild(tailspike3);
		this.bipedBody.addChild(tailbase);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		//Move part depending on sneak
		setRotation(loincloth, this.isSneak ? -0.5F : -0.0523599F, 0F, 0F);
		loincloth.offsetY = this.isSneak ? -0.06F : 0F;
		loincloth.offsetZ = this.isSneak ? 0.06F : 0F;
		loincloth.rotationPointZ = this.isSneak ? (float) Math.PI : 0F;

	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
