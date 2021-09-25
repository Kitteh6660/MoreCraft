package kittehmod.morecraft.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class EnderdragonArmorModel<A extends HumanoidModel<?>> extends HumanoidModel<LivingEntity>
{

	public EnderdragonArmorModel() {
		super(createLayer().bakeRoot());
	}

	public static LayerDefinition createLayer() {
		// First let's declare...
		float scale = 1.0F;
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedeformation = new CubeDeformation(scale);
		// Basic body
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation.extend(0.5F)), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(-5.0F, 2.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(5.0F, 2.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(-1.9F, 12.0F + scale, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubedeformation), PartPose.offset(1.9F, 12.0F + scale, 0.0F));

		// Head
		partdefinition.getChild("head").addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(32, 40).addBox(2.0F, -11F, -1F, 1, 2, 3), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("head").addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(32, 40).addBox(-3.0F, -11F, -1F, 1, 2, 3).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("head").addOrReplaceChild("snout", CubeListBuilder.create().texOffs(32, 32).addBox(-3F, -5.4F, -10F, 6, 2, 6), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("head").getChild("snout").addOrReplaceChild("nostril1", CubeListBuilder.create().texOffs(56, 32).addBox(-2F, -6F, -9F, 1, 1, 2), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("head").getChild("snout").addOrReplaceChild("nostril2", CubeListBuilder.create().texOffs(56, 32).addBox(1F, -6F, -9F, 1, 1, 2).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		// Torso
		partdefinition.getChild("body").addOrReplaceChild("backspike1", CubeListBuilder.create().texOffs(40, 40).addBox(-0.5F, 2F, 3F, 1, 3, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("body").addOrReplaceChild("backspike2", CubeListBuilder.create().texOffs(40, 40).addBox(-0.5F, 6F, 3F, 1, 3, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		// Arms
		partdefinition.getChild("left_arm").addOrReplaceChild("left_shoulderspike1", CubeListBuilder.create().texOffs(44, 40).addBox(0F, -5F, 0F, 1, 3, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0.35F));
		partdefinition.getChild("left_arm").addOrReplaceChild("left_shoulderspike2", CubeListBuilder.create().texOffs(44, 40).addBox(0F, -5F, -2F, 1, 3, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0.35F));
		partdefinition.getChild("right_arm").addOrReplaceChild("right_shoulderspike1", CubeListBuilder.create().texOffs(44, 40).addBox(-1F, -5F, 0F, 1, 3, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, -0.35F));
		partdefinition.getChild("right_arm").addOrReplaceChild("right_shoulderspike2", CubeListBuilder.create().texOffs(44, 40).addBox(-1F, -5F, -2F, 1, 3, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, -0.35F));
		// Legs
		partdefinition.getChild("left_leg").addOrReplaceChild("left_claw1", CubeListBuilder.create().texOffs(48, 40).addBox(1.5F, 11.5F, -4F, 1, 1, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("left_leg").addOrReplaceChild("left_claw2", CubeListBuilder.create().texOffs(48, 40).addBox(-0.5F, 11.5F, -4F, 1, 1, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("left_leg").addOrReplaceChild("left_claw3", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5F, 11.5F, -4F, 1, 1, 1), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_claw1", CubeListBuilder.create().texOffs(48, 40).addBox(1.5F, 11.5F, -4F, 1, 1, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_claw2", CubeListBuilder.create().texOffs(48, 40).addBox(-0.5F, 11.5F, -4F, 1, 1, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_claw3", CubeListBuilder.create().texOffs(48, 40).addBox(-2.5F, 11.5F, -4F, 1, 1, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));

		// Time to return!
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

}