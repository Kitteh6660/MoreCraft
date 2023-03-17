package kittehmod.morecraft.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.model.AgeableListModel;

public class EnderdragonArmorWingsModel<T extends LivingEntity> extends AgeableListModel<T>
{
	private ModelPart rightWing;
	private ModelPart rightWingP2;
	private ModelPart leftWing;
	private ModelPart leftWingP2;
	
	private int transitionTicks = 0;
	private float currentAngle = 0.0F;
	private float currentBend = 0.0F;

	public static final float LEFT_WING_ORIG_X = -1.0F;
	public static final float RIGHT_WING_ORIG_X = -27.0F;
	public static final int WING_SIZE = 28;
	public static final float INITIAL_ANGLE = 0.2617994F;
	public static final float INITIAL_BEND = 0.0F;
	public static final float INITIAL_X_OFFSET = 1.5F;
	public static final float INITIAL_Y_OFFSET = -4.6F;
	
	public EnderdragonArmorWingsModel(ModelPart model) {
		this.rightWing = model.getChild("body").getChild("right_wing");
		this.rightWingP2 = model.getChild("body").getChild("right_wing").getChild("right_wing_tip");
		this.leftWing = model.getChild("body").getChild("left_wing");
		this.leftWingP2 = model.getChild("body").getChild("left_wing").getChild("left_wing_tip");
	}

	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of();
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.leftWing, this.rightWing);
	}
	
	public static LayerDefinition createLayer() {
		// First let's declare...
		float scale = 1.0F;
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedeformation = new CubeDeformation(scale);
		CubeDeformation cubedeformation2 = new CubeDeformation(7.0F, 0, 7.0F);
		// Basic body
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation.extend(0.5F)), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(-5.0F, 2.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(5.0F, 2.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(-1.9F, 12.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(1.9F, 12.0F + scale, 0.0F));

		// Wings
		partdefinition.getChild("body").addOrReplaceChild("left_wing", CubeListBuilder.create().mirror().addBox("bone", LEFT_WING_ORIG_X, -2.0F, 1.0F, WING_SIZE, 2, 2, 0, 32).addBox("skin", LEFT_WING_ORIG_X + 7, -1.0F, 9.0F, 14, 0, 14, cubedeformation2, -14, 36), PartPose.offset(4.0F, 5.0F, 2.0F));
		partdefinition.getChild("body").getChild("left_wing").addOrReplaceChild("left_wing_tip", CubeListBuilder.create().mirror().addBox("bone", LEFT_WING_ORIG_X, -1.5F, 1.5F, WING_SIZE, 1, 1, 1, 33).addBox("skin", LEFT_WING_ORIG_X + 7, -1.0F, 9.0F, 14, 0, 14, cubedeformation2, -14, 50), PartPose.offset(16.0F, 0.0F, 0.0F));
		partdefinition.getChild("body").addOrReplaceChild("right_wing", CubeListBuilder.create().addBox("bone", RIGHT_WING_ORIG_X, -2.0F, 1.0F, WING_SIZE, 2, 2, 0, 32).addBox("skin", RIGHT_WING_ORIG_X + 7, -1.0F, 9.0F, 14, 0, 14, cubedeformation2, -14, 36), PartPose.offset(-4.0F, 5.0F, 2.0F));
		partdefinition.getChild("body").getChild("right_wing").addOrReplaceChild("right_wing_tip", CubeListBuilder.create().addBox("bone", RIGHT_WING_ORIG_X, -1.5F, 1.5F, WING_SIZE, 1, 1, 1, 33).addBox("skin", RIGHT_WING_ORIG_X + 7, -1.0F, 9.0F, 14, 0, 14, cubedeformation2, -14, 50), PartPose.offset(-16.0F, 0.0F, 0.0F));

		// Time to return!
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public void setupAnim(LivingEntity entity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		float f = INITIAL_ANGLE;
		float f1 = -INITIAL_ANGLE;
		float f3 = 0.0F;
		float bend = INITIAL_BEND;
		float sway = -0.05F;
		float xOffset = INITIAL_X_OFFSET;
		float yOffset = INITIAL_Y_OFFSET;
		float targetAngle = 0.0F;
		if (entity.isFallFlying()) { // If the entity is gliding.
			float f4 = 1.0F;
			Vec3 vec3 = entity.getDeltaMovement();
			if (vec3.y < 0.0D) {
				Vec3 vec31 = vec3.normalize();
				f4 = 1.0F - (float) Math.pow(-vec31.y, 1.5D);
			}
			f = f4 * 0.34906584F + (1.0F - f4) * f;
			f1 = -INITIAL_ANGLE + (float)((Mth.sin(pAgeInTicks * 0.2F) * 0.3F));
			targetAngle = f1;
			bend = (float)((Mth.sin(pAgeInTicks * 0.2F) * 0.3F));
			sway = -0.2F;
			xOffset = 0;
			yOffset *= 0.55F;
			if (transitionTicks < 20) {
				transitionTicks++;
			}
		} 
		else if (entity instanceof AbstractClientPlayer && ((AbstractClientPlayer)entity).getAbilities().flying) { // If the entity is flying.
			float f4 = 1.0F;
			Vec3 vec3 = entity.getDeltaMovement();
			if (vec3.y < 0.0D) {
				Vec3 vec31 = vec3.normalize();
				f4 = 1.0F - (float) Math.pow(-vec31.y, 1.5D);
			}
			f = f4 * 0.34906584F + (1.0F - f4) * f;
			f1 = -INITIAL_ANGLE + (float)((Mth.sin(pAgeInTicks * 0.4F) * 0.5F));
			targetAngle = f1;
			bend = (float)((Mth.sin(pAgeInTicks * 0.4F) * 0.8F));
			sway = 0.05F;
			xOffset = 0;
			yOffset *= 0.55F;
			if (transitionTicks < 20) {
				transitionTicks++;
			}
		} else if (entity.isCrouching()) { // If the entity is crouching.
			f = 0.6981317F;
			f1 = (-(float) Math.PI / 2.5F);
			f3 = 0.08726646F;
			bend = (float)(Math.PI * 0.95F);
			targetAngle = 0.0F;
			if (transitionTicks > -20) {
				transitionTicks--;
			}
			else {
				
			}
		}
		else { // If the entity is idle or walking.
			if (entity instanceof ArmorStand) {
				f1 = (-(float) Math.PI / 2.5F);
			}
			else {
				f1 = (-(float) Math.PI / 2.5F) + (float)(Mth.sin(pAgeInTicks * 0.05F) * 0.1F);
			}
			bend = (float)(Math.PI * 0.9F);
			targetAngle = f1;
			if (transitionTicks > 0) {
				transitionTicks--;
			}
			if (transitionTicks < 0) {
				transitionTicks++;
			}
		}

		// Make smooth transitions.
		currentAngle += (targetAngle - currentAngle) * 0.1F;
		currentBend += (bend - currentBend) * 0.1F;
		
		// Pose the wings.
		this.leftWing.y = 3.0F;
		this.leftWing.xRot = (float)Math.PI * sway; // Mth.sin(entity.getLevel().getGameTime()) * (idleSway * (float));
		this.leftWing.yRot = (float)Math.PI * -0.05F; // Mth.sin(entity.getLevel().getGameTime()) * (idleSway * (float));
		this.leftWing.zRot = currentAngle;
		this.leftWingP2.zRot = currentBend;
		this.leftWingP2.x = LEFT_WING_ORIG_X + WING_SIZE - xOffset;
		this.leftWingP2.y = this.leftWing.y + yOffset;
		this.rightWingP2.x = RIGHT_WING_ORIG_X + xOffset;
		this.rightWingP2.y = this.rightWing.y + yOffset;
		
		if (entity instanceof AbstractClientPlayer abstractclientplayer) {
			abstractclientplayer.elytraRotX += (f - abstractclientplayer.elytraRotX) * 0.1F;
			abstractclientplayer.elytraRotY += (f3 - abstractclientplayer.elytraRotY) * 0.1F;
			abstractclientplayer.elytraRotZ += (f1 - abstractclientplayer.elytraRotZ) * 0.1F;
			//this.leftWing.xRot = abstractclientplayer.elytraRotX;
			//this.leftWing.yRot = abstractclientplayer.elytraRotY;
			//this.leftWing.zRot = abstractclientplayer.elytraRotZ;
		} else {
			this.leftWing.xRot = f;
			this.leftWing.zRot = f1;
			this.leftWing.yRot = f3;
		}
		
		// Copy the wing and mirror.
		this.rightWing.yRot = -this.leftWing.yRot;
		this.rightWing.y = this.leftWing.y;
		this.rightWing.xRot = this.leftWing.xRot;
		this.rightWing.zRot = -this.leftWing.zRot;
		this.rightWingP2.yRot = -this.leftWingP2.yRot;
		//this.rightWingP2.y = this.leftWingP2.y;
		this.rightWingP2.xRot = this.leftWingP2.xRot;
		this.rightWingP2.zRot = -this.leftWingP2.zRot;
	}

}