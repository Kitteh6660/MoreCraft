package kittehmod.morecraft.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class EnderdragonLegsModel<A extends HumanoidModel<?>> extends HumanoidModel<LivingEntity>
{
	
	public EnderdragonLegsModel() {
		super(createLayer().bakeRoot());
	}

	public static LayerDefinition createLayer() {
		// First let's declare...
		float scale = 0.5F;
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

		// Leg Plates
		partdefinition.getChild("left_leg").addOrReplaceChild("left_legplate1", CubeListBuilder.create().texOffs(32, 0).addBox(2.0F, -1.5F, -1.5F, 1, 3, 3), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, -0.0872665F));
		partdefinition.getChild("left_leg").addOrReplaceChild("left_legplate2", CubeListBuilder.create().texOffs(32, 0).addBox(1.8F, -0.5F, -2.5F, 1, 3, 3), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, -0.0872665F));
		partdefinition.getChild("left_leg").addOrReplaceChild("left_legplate3", CubeListBuilder.create().texOffs(32, 0).addBox(1.6F, 0.5F, -3.5F, 1, 3, 3), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, -0.0872665F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_legplate1", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -1.5F, -1.5F, 1, 3, 3).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, 0.0872665F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_legplate2", CubeListBuilder.create().texOffs(32, 0).addBox(-2.8F, -0.5F, -2.5F, 1, 3, 3).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, 0.0872665F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_legplate3", CubeListBuilder.create().texOffs(32, 0).addBox(-2.6F, 0.5F, -3.5F, 1, 3, 3).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, 0.7853982F, 0F, 0.0872665F));
		// Loincloth
		partdefinition.getChild("left_leg").addOrReplaceChild("left_loincloth", CubeListBuilder.create().texOffs(32, 6).addBox(-2.6F, -0.5F, -2.6F, 3, 5, 1), PartPose.offsetAndRotation(0F, 0F, 0F, -0.03F, 0F, 0F));
		partdefinition.getChild("right_leg").addOrReplaceChild("right_loincloth", CubeListBuilder.create().texOffs(35, 6).addBox(-0.4F, -0.5F, -2.6F, 3, 5, 1).mirror(), PartPose.offsetAndRotation(0F, 0F, 0F, -0.03F, 0F, 0F));
		// Tail
		partdefinition.getChild("body").addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(42, 0).addBox(-1F, 5.5F, 9.97F, 2, 2, 9), PartPose.offsetAndRotation(0F, 0F, 0F, -0.8726646F, 0F, 0F));
		partdefinition.getChild("body").getChild("tail_base").addOrReplaceChild("tail_spike1", CubeListBuilder.create().texOffs(42, 12).addBox(-0.5F, 4.5F, 11F, 1, 2, 2), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("body").getChild("tail_base").addOrReplaceChild("tail_spike2", CubeListBuilder.create().texOffs(42, 12).addBox(-0.5F, 4.5F, 13.5F, 1, 2, 2), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));
		partdefinition.getChild("body").getChild("tail_base").addOrReplaceChild("tail_spike3", CubeListBuilder.create().texOffs(42, 12).addBox(-0.5F, 4.5F, 16F, 1, 2, 2), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0F, 0F));

		// Time to return!
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

}
