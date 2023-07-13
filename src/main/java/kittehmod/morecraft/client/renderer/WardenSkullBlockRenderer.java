package kittehmod.morecraft.client.renderer;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import kittehmod.morecraft.block.WallWardenHeadBlock;
import kittehmod.morecraft.block.WardenHeadBlock;
import kittehmod.morecraft.blockentity.WardenSkullBlockEntity;
import kittehmod.morecraft.client.ClientHelper;
import kittehmod.morecraft.client.model.WardenHeadModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WardenSkullBlockRenderer implements BlockEntityRenderer<WardenSkullBlockEntity>
{
	private final SkullModelBase WARDEN_HEAD_MODEL;
	private static final ResourceLocation WARDEN_TEXTURE = new ResourceLocation("textures/entity/warden/warden.png");
	private static final ResourceLocation BIOLUMINESCENT_LAYER_TEXTURE = new ResourceLocation("textures/entity/warden/warden_bioluminescent_layer.png");
	
	public static Map<SkullBlock.Type, SkullModelBase> createSkullRenderers(EntityModelSet p_173662_) {
		ImmutableMap.Builder<SkullBlock.Type, SkullModelBase> builder = ImmutableMap.builder();
		builder.put(WardenHeadBlock.Types.WARDEN, new WardenHeadModel(p_173662_.bakeLayer(ClientHelper.WARDEN_HEAD)));
		net.minecraftforge.fml.ModLoader.get().postEvent(new net.minecraftforge.client.event.EntityRenderersEvent.CreateSkullModels(builder, p_173662_));
		return builder.build();
	}

	public WardenSkullBlockRenderer(BlockEntityRendererProvider.Context context) {
		WARDEN_HEAD_MODEL = new WardenHeadModel(context.getModelSet().bakeLayer(ClientHelper.WARDEN_HEAD));
	}
	
	public void render(WardenSkullBlockEntity blockentity, float p_112535_, PoseStack poseStack, MultiBufferSource mbs, int p_112538_, int p_112539_) {
		float f = blockentity.getTendrilAnimation(p_112535_);
		BlockState blockstate = blockentity.getBlockState();
		boolean flag = blockstate.getBlock() instanceof WallWardenHeadBlock;
		Direction direction = flag ? blockstate.getValue(WallWardenHeadBlock.FACING) : null;
		float f1 = 22.5F * (float)(flag ? (2 + direction.get2DDataValue()) * 4 : blockstate.getValue(WardenHeadBlock.ROTATION));
		SkullModelBase skullmodelbase = WARDEN_HEAD_MODEL; 
		RenderType rendertype = RenderType.entityCutoutNoCullZOffset(WARDEN_TEXTURE);
		RenderType rendertype2 = RenderType.entityTranslucentEmissive(BIOLUMINESCENT_LAYER_TEXTURE);
		renderSkull(direction, f1, f, poseStack, mbs, p_112538_, skullmodelbase, rendertype);
		renderGlow(direction, f1, f, poseStack, mbs, p_112538_, skullmodelbase, rendertype2);
	}

   public static void renderSkull(@Nullable Direction direction, float rotation, float p_173666_, PoseStack poseStack, MultiBufferSource p_173668_, int p_173669_, SkullModelBase model, RenderType p_173671_) {
      poseStack.pushPose();
      if (direction == null) {
         poseStack.translate(0.5D, 0.0D, 0.5D);
      } else {
         poseStack.translate((double)(0.5F - (float)direction.getStepX() * 0.25F), 0.1D, (double)(0.5F - (float)direction.getStepZ() * 0.25F));
      }

      poseStack.scale(-1.0F, -1.0F, 1.0F);
      VertexConsumer vertexconsumer = p_173668_.getBuffer(p_173671_);
      model.setupAnim(p_173666_, rotation, 0.0F);
      model.renderToBuffer(poseStack, vertexconsumer, p_173669_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }
   
   public static void renderGlow(@Nullable Direction direction, float rotation, float p_173666_, PoseStack poseStack, MultiBufferSource p_173668_, int p_173669_, SkullModelBase model, RenderType p_173671_) {
      poseStack.pushPose();
      if (direction == null) {
         poseStack.translate(0.5D, 0.0D, 0.5D);
      } else {
         poseStack.translate((double)(0.5F - (float)direction.getStepX() * 0.25F), 0.1D, (double)(0.5F - (float)direction.getStepZ() * 0.25F));
      }

      poseStack.scale(-1.02F, -1.02F, 1.02F);
      VertexConsumer vertexconsumer = p_173668_.getBuffer(p_173671_);
      model.setupAnim(p_173666_, rotation, 0.0F);
      model.renderToBuffer(poseStack, vertexconsumer, p_173669_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }
}
