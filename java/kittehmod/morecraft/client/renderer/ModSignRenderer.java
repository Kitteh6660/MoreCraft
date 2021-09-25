package kittehmod.morecraft.client.renderer;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import com.mojang.math.Vector3f;

import kittehmod.morecraft.block.ModStandingSignBlock;
import kittehmod.morecraft.block.ModWallSignBlock;
import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.blockentity.ModSignBlockEntity;
import kittehmod.morecraft.client.ClientHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModSignRenderer implements BlockEntityRenderer<ModSignBlockEntity>
{
	public static final int MAX_LINE_WIDTH = 90;
	private static final int LINE_HEIGHT = 10;
	private static final int BLACK_TEXT_OUTLINE_COLOR = -988212;
	private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
	private final Map<WoodType, ModSignRenderer.SignModel> signModels;
	private final Font font;
	private static final Material SIGN_MATERIAL_NETHERWOOD = new Material(Sheets.SIGN_SHEET, ClientHelper.NETHERWOOD_SIGN_LOCATION);

	public ModSignRenderer(BlockEntityRendererProvider.Context p_173636_) {
		this.signModels = WoodType.values().collect(ImmutableMap.toImmutableMap((p_173645_) -> { return p_173645_; }, (p_173651_) -> { return new ModSignRenderer.SignModel(p_173636_.bakeLayer(ModelLayers.createSignModelName(p_173651_))); }));
		this.font = p_173636_.getFont();
	}
	
	public void render(ModSignBlockEntity signBlockEntity, float p_112498_, PoseStack pose, MultiBufferSource mbs, int p_112501_, int p_112502_) {
		BlockState blockstate = signBlockEntity.getBlockState();
		pose.pushPose();
		float f = 0.6666667F;
		WoodType woodtype = getWoodType(blockstate.getBlock());
		ModSignRenderer.SignModel signrenderer$signmodel = this.signModels.get(woodtype);
		if (blockstate.getBlock() instanceof ModStandingSignBlock) {
			pose.translate(0.5D, 0.5D, 0.5D);
			float f1 = -((float) (blockstate.getValue(ModStandingSignBlock.ROTATION) * 360) / 16.0F);
			pose.mulPose(Vector3f.YP.rotationDegrees(f1));
			signrenderer$signmodel.stick.visible = true;
		} else {
			pose.translate(0.5D, 0.5D, 0.5D);
			float f4 = -blockstate.getValue(ModWallSignBlock.FACING).toYRot();
			pose.mulPose(Vector3f.YP.rotationDegrees(f4));
			pose.translate(0.0D, -0.3125D, -0.4375D);
			signrenderer$signmodel.stick.visible = false;
		}

		pose.pushPose();
		pose.scale(f, -f, -f);
		Material material = getSignMaterial(woodtype); // Sheets.getSignMaterial(woodtype);
		VertexConsumer vertexconsumer = material.buffer(mbs, signrenderer$signmodel::renderType);
		signrenderer$signmodel.root.render(pose, vertexconsumer, p_112501_, p_112502_);
		pose.popPose();
		float f2 = 0.010416667F;
		pose.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
		pose.scale(f2, -f2, f2);
		int i = getDarkColor(signBlockEntity);
		int j = 20;
		FormattedCharSequence[] aformattedcharsequence = signBlockEntity.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (p_173653_) -> {
			List<FormattedCharSequence> list = this.font.split(p_173653_, 90);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});
		int k;
		boolean flag;
		int l;
		if (signBlockEntity.hasGlowingText()) {
			k = signBlockEntity.getColor().getTextColor();
			flag = isOutlineVisible(signBlockEntity, k);
			l = 15728880;
		} else {
			k = i;
			flag = false;
			l = p_112501_;
		}

		for (int i1 = 0; i1 < 4; ++i1) {
			FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
			float f3 = (float) (-this.font.width(formattedcharsequence) / 2);
			if (flag) {
				this.font.drawInBatch8xOutline(formattedcharsequence, f3, (float) (i1 * LINE_HEIGHT - j), k, i, pose.last().pose(), mbs, l);
			} else {
				this.font.drawInBatch(formattedcharsequence, f3, (float) (i1 * LINE_HEIGHT - j), k, false, pose.last().pose(), mbs, false, 0, l);
			}
		}

		pose.popPose();
	}
	
	private static boolean isOutlineVisible(ModSignBlockEntity p_173642_, int p_173643_) {
		if (p_173643_ == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer localplayer = minecraft.player;
			if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
				return true;
			} else {
				Entity entity = minecraft.getCameraEntity();
				return entity != null && entity.distanceToSqr(Vec3.atCenterOf(p_173642_.getBlockPos())) < (double) OUTLINE_RENDER_DISTANCE;
			}
		}
	}

	private static int getDarkColor(ModSignBlockEntity p_173640_) {
		int i = p_173640_.getColor().getTextColor();
		double d0 = 0.4D;
		int j = (int) ((double) NativeImage.getR(i) * d0);
		int k = (int) ((double) NativeImage.getG(i) * d0);
		int l = (int) ((double) NativeImage.getB(i) * d0);
		return i == DyeColor.BLACK.getTextColor() && p_173640_.hasGlowingText() ? BLACK_TEXT_OUTLINE_COLOR : NativeImage.combine(0, l, k, j);
	}

	public static WoodType getWoodType(Block p_173638_) {
		WoodType woodtype;
		if (p_173638_ instanceof SignBlock) {
			woodtype = ((SignBlock) p_173638_).type();
		} else {
			woodtype = ModWoodType.NETHERWOOD;
		}

		return woodtype;
	}
	
	public static Material getSignMaterial(WoodType wtype) {
		if (wtype == ModWoodType.NETHERWOOD) {
			return SIGN_MATERIAL_NETHERWOOD;
		}
		else {
			return SIGN_MATERIAL_NETHERWOOD; //There currently is only one custom sign.
		}
	}
	
	public static ModSignRenderer.SignModel createSignModel(EntityModelSet p_173647_, WoodType p_173648_) {
		return new ModSignRenderer.SignModel(p_173647_.bakeLayer(ModelLayers.createSignModelName(p_173648_)));
	}

	public static LayerDefinition createSignLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("sign", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@OnlyIn(Dist.CLIENT)
	public static final class SignModel extends Model
	{
		public final ModelPart root;
		public final ModelPart stick;

		public SignModel(ModelPart p_173657_) {
			super(RenderType::entityCutoutNoCull);
			this.root = p_173657_;
			this.stick = p_173657_.getChild("stick");
		}

		public void renderToBuffer(PoseStack p_112510_, VertexConsumer p_112511_, int p_112512_, int p_112513_, float p_112514_, float p_112515_, float p_112516_, float p_112517_) {
			this.root.render(p_112510_, p_112511_, p_112512_, p_112513_, p_112514_, p_112515_, p_112516_, p_112517_);
		}
	}
}
