package kittehmod.morecraft.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class WardenHeadModel extends SkullModelBase
{
	private final ModelPart head;
	private final ModelPart rightTendril;
	private final ModelPart leftTendril;

	public WardenHeadModel(ModelPart part) {
		this.head = part.getChild("head");
		this.rightTendril = this.head.getChild("right_tendril");
		this.leftTendril = this.head.getChild("left_tendril");
	}
	
	public static LayerDefinition createHeadLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition headpart = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -16.0F, -5.0F, 16.0F, 16.0F, 10.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		headpart.addOrReplaceChild("right_tendril", CubeListBuilder.create().texOffs(52, 32).addBox(-16.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), PartPose.offset(-8.0F, -12.0F, 0.0F));
		headpart.addOrReplaceChild("left_tendril", CubeListBuilder.create().texOffs(58, 0).addBox(0.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), PartPose.offset(8.0F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	public static LayerDefinition createGlowLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	@Override
	public void setupAnim(float p_104188_, float p_104189_, float p_104190_) {
		this.rightTendril.xRot = (float)(Math.sin((double)(p_104188_ * (float)Math.PI * 0.02F)) + 1.0D) * 0.2F;
		this.leftTendril.xRot = (float)(Math.sin((double)(p_104188_ * (float)Math.PI * 0.02F)) + 1.0D) * 0.2F;
		this.head.yRot = p_104189_ * ((float)Math.PI / 180F);
		this.head.xRot = p_104190_ * ((float)Math.PI / 180F);
	}

	public void renderToBuffer(PoseStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, float p_104196_, float p_104197_, float p_104198_, float p_104199_) {
		p_104192_.pushPose();
		p_104192_.translate(0.0D, (double)-0.374375F, 0.0D);
		p_104192_.scale(0.75F, 0.75F, 0.75F);
		this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_104196_, p_104197_, p_104198_, p_104199_);
		p_104192_.popPose();
	}

}
