package kittehmod.morecraft.client;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import kittehmod.morecraft.block.ModSkullBlock;
import kittehmod.morecraft.block.ModWallSkullBlock;
import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModSkullTileEntityRenderer extends TileEntityRenderer<ModSkullTileEntity> {
	   public static ModSkullTileEntityRenderer instance;
	   private static final Map<SkullBlock.ISkullType, GenericHeadModel> MODELS = Util.make(Maps.newHashMap(), (p_209262_0_) -> {
	      GenericHeadModel genericheadmodel = new GenericHeadModel(0, 0, 64, 32);
	      //GenericHeadModel genericheadmodel1 = new HumanoidHeadModel();
	      p_209262_0_.put(ModSkullBlock.Types.SPIDER, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.CAVE_SPIDER, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.ZOMBIE_PIGMAN, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.BLAZE, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.ENDERMAN, genericheadmodel);
	   });
	   private static final Map<SkullBlock.ISkullType, ResourceLocation> SKINS = Util.make(Maps.newHashMap(), (p_209263_0_) -> {
	      p_209263_0_.put(ModSkullBlock.Types.SPIDER, new ResourceLocation("textures/entity/spider/spider.png"));
	      p_209263_0_.put(ModSkullBlock.Types.CAVE_SPIDER, new ResourceLocation("textures/entity/spider/cave_spider.png"));
	      p_209263_0_.put(ModSkullBlock.Types.ZOMBIE_PIGMAN, new ResourceLocation("textures/entity/zombie_pigman.png"));
	      p_209263_0_.put(ModSkullBlock.Types.BLAZE, new ResourceLocation("textures/entity/blaze.png"));
	      p_209263_0_.put(ModSkullBlock.Types.ENDERMAN, new ResourceLocation("textures/entity/enderman/enderman.png"));
	   });
	   
	public ModSkullTileEntityRenderer(TileEntityRendererDispatcher p_i226015_1_) {
		super(p_i226015_1_);
	}

		
	public void render(ModSkullTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		BlockState blockstate = tileEntityIn.getBlockState();
		boolean flag = blockstate.getBlock() instanceof ModWallSkullBlock;
		Direction direction = flag ? blockstate.get(ModWallSkullBlock.FACING) : null;
		float f1 = 22.5F * (float)(flag ? (2 + direction.getHorizontalIndex()) * 4 : blockstate.get(ModSkullBlock.ROTATION));
		render(direction, f1, ((AbstractSkullBlock)blockstate.getBlock()).getSkullType(), null, 0, matrixStackIn, bufferIn, combinedLightIn);
	}

	public static void render(@Nullable Direction directionIn, float p_228879_1_, SkullBlock.ISkullType skullType, @Nullable GameProfile gameProfileIn, float animationProgress, MatrixStack matrixStackIn, IRenderTypeBuffer buffer, int combinedLight) {
		GenericHeadModel genericheadmodel = MODELS.get(skullType);
		matrixStackIn.push();
		if (directionIn == null) {
			matrixStackIn.translate(0.5D, 0.0D, 0.5D);
		} else {
			switch(directionIn) {
			case NORTH:
				matrixStackIn.translate(0.5D, 0.25D, (double)0.74F);
				break;
			case SOUTH:
	            matrixStackIn.translate(0.5D, 0.25D, (double)0.26F);
	            break;
			case WEST:
	            matrixStackIn.translate((double)0.74F, 0.25D, 0.5D);
	            break;
			case EAST:
			default:
	            matrixStackIn.translate((double)0.26F, 0.25D, 0.5D);
			}
		}

		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		IVertexBuilder ivertexbuilder = buffer.getBuffer(getRenderType(skullType, gameProfileIn));
		genericheadmodel.func_225603_a_(animationProgress, p_228879_1_, 0.0F);
		genericheadmodel.render(matrixStackIn, ivertexbuilder, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();
	}

	private static RenderType getRenderType(SkullBlock.ISkullType skullType, @Nullable GameProfile gameProfileIn) {
		ResourceLocation resourcelocation = SKINS.get(skullType);
		return RenderType.getEntityCutoutNoCull(resourcelocation);
	}
}
