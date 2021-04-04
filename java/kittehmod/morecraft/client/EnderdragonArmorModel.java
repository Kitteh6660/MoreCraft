package kittehmod.morecraft.client;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class EnderdragonArmorModel extends BipedModel<LivingEntity>
{
	//fields
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer snout;
	ModelRenderer nostril1;
	ModelRenderer nostril2;
	ModelRenderer backspike1;
	ModelRenderer backspike2;
	ModelRenderer leftshoulderspike1;
	ModelRenderer leftshoulderspike2;
	ModelRenderer rightshoulderspike1;
	ModelRenderer rightshoulderspike2;
	ModelRenderer leftclaw1;
	ModelRenderer leftclaw2;
	ModelRenderer leftclaw3;
	ModelRenderer rightclaw1;
	ModelRenderer rightclaw2;
	ModelRenderer rightclaw3;

	private static int textureWidth = 64;
	private static int textureHeight = 64;

	public EnderdragonArmorModel(float expand)
	{
		super(expand, 0, textureWidth, textureHeight);
		
		//-- HEAD --\\
		//Horns
		horn1 = new ModelRenderer(this, 32, 40);
		horn1.addBox(2.0F, -11F, -1F, 1, 2, 3);
		horn1.setPos(0F, 0F, 0F);
		horn1.setTexSize(textureWidth, textureHeight);
		horn1.mirror = true;
		setRotation(horn1, 0F, 0F, 0F);
		
		horn2 = new ModelRenderer(this, 32, 40);
		horn2.addBox(-3.0F, -11F, -1F, 1, 2, 3);
		horn2.setPos(0F, 0F, 0F);
		horn2.setTexSize(textureWidth, textureHeight);
		horn2.mirror = true;
		setRotation(horn2, 0F, 0F, 0F);
		//Muzzle and Nostrils
		snout = new ModelRenderer(this, 32, 32);
		snout.addBox(-3F, -5.4F, -10F, 6, 2, 6);
		snout.setPos(0F, 0F, 0F);
		snout.setTexSize(textureWidth, textureHeight);
		snout.mirror = true;
		setRotation(snout, 0F, 0F, 0F);
		
		nostril1 = new ModelRenderer(this, 56, 32);
		nostril1.addBox(-2F, -6F, -9F, 1, 1, 2);
		nostril1.setPos(0F, 0F, 0F);
		nostril1.setTexSize(textureWidth, textureHeight);
		nostril1.mirror = true;
		setRotation(nostril1, 0F, 0F, 0F);
		
		nostril2 = new ModelRenderer(this, 56, 32);
		nostril2.addBox(1F, -6F, -9F, 1, 1, 2);
		nostril2.setPos(0F, 0F, 0F);
		nostril2.setTexSize(textureWidth, textureHeight);
		nostril2.mirror = true;
		setRotation(nostril2, 0F, 0F, 0F);
		
		//-- TORSO --\\
		//Back Spikes
		backspike1 = new ModelRenderer(this, 40, 40);
		backspike1.addBox(-0.5F, 2F, 3F, 1, 3, 1);
		backspike1.setPos(0F, 0F, 0F);
		backspike1.setTexSize(textureWidth, textureHeight);
		backspike1.mirror = true;
		setRotation(backspike1, 0F, 0F, 0F);
		
		backspike2 = new ModelRenderer(this, 40, 40);
		backspike2.addBox(-0.5F, 6F, 3F, 1, 3, 1);
		backspike2.setPos(0F, 0F, 0F);
		backspike2.setTexSize(textureWidth, textureHeight);
		backspike2.mirror = true;
		setRotation(backspike2, 0F, 0F, 0F);
		
		//-- ARMS --\\
		//Shoulder Spikes
		leftshoulderspike1 = new ModelRenderer(this, 44, 40);
		leftshoulderspike1.addBox(0F, -5F, 0F, 1, 3, 1);
		leftshoulderspike1.setPos(0F, 0F, 0F); //(5F, 2F, 0F);
		leftshoulderspike1.setTexSize(textureWidth, textureHeight);
		leftshoulderspike1.mirror = true;
		setRotation(leftshoulderspike1, 0F, 0F, 0.3490659F);
		
		leftshoulderspike2 = new ModelRenderer(this, 44, 40);
		leftshoulderspike2.addBox(0F, -5F, -2F, 1, 3, 1);
		leftshoulderspike2.setPos(0F, 0F, 0F); //(5F, 2F, 0F);
		leftshoulderspike2.setTexSize(textureWidth, textureHeight);
		leftshoulderspike2.mirror = true;
		setRotation(leftshoulderspike2, 0F, 0F, 0.3490659F);
		
		rightshoulderspike1 = new ModelRenderer(this, 44, 40);
		rightshoulderspike1.addBox(-1F, -5F, 0F, 1, 3, 1);
		rightshoulderspike1.setPos(0F, 0F, 0F); //(-5F, 2F, 0F);
		rightshoulderspike1.setTexSize(textureWidth, textureHeight);
		rightshoulderspike1.mirror = true;
		setRotation(rightshoulderspike1, 0F, 0F, -0.3490659F);
		
		rightshoulderspike2 = new ModelRenderer(this, 44, 40);
		rightshoulderspike2.addBox(-1F, -5F, -2F, 1, 3, 1);
		rightshoulderspike2.setPos(0F, 0F, 0F); //(-5F, 2F, 0F);
		rightshoulderspike2.setTexSize(textureWidth, textureHeight);
		rightshoulderspike2.mirror = true;
		setRotation(rightshoulderspike2, 0F, 0F, -0.3490659F);
		
		//-- LEGS --\\
		//Toe Claws
		leftclaw1 = new ModelRenderer(this, 48, 40);
		leftclaw1.addBox(1.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw1.setPos(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw1.setTexSize(textureWidth, textureHeight);
		leftclaw1.mirror = true;
		setRotation(leftclaw1, 0F, 0F, 0F);

		leftclaw2 = new ModelRenderer(this, 48, 40);
		leftclaw2.addBox(-0.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw2.setPos(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw2.setTexSize(textureWidth, textureHeight);
		leftclaw2.mirror = true;
		setRotation(leftclaw2, 0F, 0F, 0F);
		
		leftclaw3 = new ModelRenderer(this, 48, 40);
		leftclaw3.addBox(-2.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw3.setPos(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw3.setTexSize(textureWidth, textureHeight);
		leftclaw3.mirror = true;
		setRotation(leftclaw3, 0F, 0F, 0F);

		rightclaw1 = new ModelRenderer(this, 48, 40);
		rightclaw1.addBox(1.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw1.setPos(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw1.setTexSize(textureWidth, textureHeight);
		rightclaw1.mirror = true;
		setRotation(rightclaw1, 0F, 0F, 0F);
		
		rightclaw2 = new ModelRenderer(this, 48, 40);
		rightclaw2.addBox(-0.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw2.setPos(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw2.setTexSize(textureWidth, textureHeight);
		rightclaw2.mirror = true;
		setRotation(rightclaw2, 0F, 0F, 0F);
		
		rightclaw3 = new ModelRenderer(this, 48, 40);
		rightclaw3.addBox(-2.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw3.setPos(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw3.setTexSize(textureWidth, textureHeight);
		rightclaw3.mirror = true;
		setRotation(rightclaw3, 0F, 0F, 0F);
		
		//-- ASSIGNING CHILD --\\
		//Head
		this.head.addChild(horn1);
		this.head.addChild(horn2);
		snout.addChild(nostril1);
		snout.addChild(nostril2);
		this.head.addChild(snout);
		//Torso
		this.body.addChild(backspike1);
		this.body.addChild(backspike2);
		//Arms
		this.leftArm.addChild(leftshoulderspike1);
		this.leftArm.addChild(leftshoulderspike2);
		this.rightArm.addChild(rightshoulderspike1);
		this.rightArm.addChild(rightshoulderspike2);
		//Legs
		this.leftLeg.addChild(leftclaw1);
		this.leftLeg.addChild(leftclaw2);
		this.leftLeg.addChild(leftclaw3);
		this.rightLeg.addChild(rightclaw1);
		this.rightLeg.addChild(rightclaw2);
		this.rightLeg.addChild(rightclaw3);

	}

	/*public void render(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		if (entityIn instanceof ArmorStandEntity) {
			netHeadYaw = 0; //Fixes the head facing south.
			ageInTicks = 1; //Stop arms animating.
			this.setRotation(this.leftArm, ((ArmorStandEntity) entityIn).getLeftArmRotation().getX(), ((ArmorStandEntity) entityIn).getLeftArmRotation().getY(), ((ArmorStandEntity) entityIn).getLeftArmRotation().getZ());
			this.setRotation(this.rightArm, ((ArmorStandEntity) entityIn).getRightArmRotation().getX(), ((ArmorStandEntity) entityIn).getRightArmRotation().getY(), ((ArmorStandEntity) entityIn).getRightArmRotation().getZ());
		}
		else {
			super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);			
		}
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}*/

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.xRot = x;
		model.yRot = y;
		model.zRot = z;
	}

}