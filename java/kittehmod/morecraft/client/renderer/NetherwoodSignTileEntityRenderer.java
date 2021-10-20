package kittehmod.morecraft.client.renderer;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import kittehmod.morecraft.block.ModStandingSignBlock;
import kittehmod.morecraft.block.ModWallSignBlock;
import kittehmod.morecraft.client.TileEntityTextureHelper;
import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NetherwoodSignTileEntityRenderer extends TileEntityRenderer<ModSignTileEntity> {
	   /** The ModelSign instance for use in this renderer */
	   private final NetherwoodSignTileEntityRenderer.SignModel model = new NetherwoodSignTileEntityRenderer.SignModel();

	   public NetherwoodSignTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
	      super(rendererDispatcherIn);
	   }

	   @Override
	   public void render(ModSignTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
	      BlockState blockstate = tileEntityIn.getBlockState();
	      matrixStackIn.pushPose();
	      float f = 0.6666667F;
	      if (blockstate.getBlock() instanceof ModStandingSignBlock) {
	         matrixStackIn.translate(0.5D, 0.5D, 0.5D);
	         float f1 = -((float)(blockstate.getValue(ModStandingSignBlock.ROTATION) * 360) / 16.0F);
	         matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f1));
	         this.model.signStick.visible = true;
	      } else {
	         matrixStackIn.translate(0.5D, 0.5D, 0.5D);
	         float f4 = -blockstate.getValue(ModWallSignBlock.FACING).toYRot();
	         matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f4));
	         matrixStackIn.translate(0.0D, -0.3125D, -0.4375D);
	         this.model.signStick.visible = false;
	      }

	      matrixStackIn.pushPose();
	      matrixStackIn.scale(f, -f, -f);
	      RenderMaterial rendermaterial = getMaterial(blockstate.getBlock());
	      IVertexBuilder ivertexbuilder = rendermaterial.buffer(bufferIn, this.model::renderType);
	      this.model.signBoard.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
	      this.model.signStick.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
	      matrixStackIn.popPose();
	      FontRenderer fontrenderer = this.renderer.getFont();
	      float f2 = 0.010416667F;
	      matrixStackIn.translate(0.0D, (double)0.33333334F, (double)0.046666667F);
	      matrixStackIn.scale(f2, -f2, f2);
	      int i = tileEntityIn.getTextColor().getTextColor();
	      double d0 = 0.4D;
	      int j = (int)((double)NativeImage.getR(i) * d0);
	      int k = (int)((double)NativeImage.getG(i) * d0);
	      int l = (int)((double)NativeImage.getB(i) * d0);
	      int i1 = NativeImage.combine(0, l, k, j);

      for(int k1 = 0; k1 < 4; ++k1) {
         IReorderingProcessor ireorderingprocessor = tileEntityIn.getRenderMessage(k1, (p_243502_1_) -> {
            List<IReorderingProcessor> list = fontrenderer.split(p_243502_1_, 90);
            return list.isEmpty() ? IReorderingProcessor.EMPTY : list.get(0);
         });
         if (ireorderingprocessor != null) {
            float f3 = (float)(-fontrenderer.width(ireorderingprocessor) / 2);
            fontrenderer.drawInBatch(ireorderingprocessor, f3, (float)(k1 * 10 - 20), i1, false, matrixStackIn.last().pose(), bufferIn, false, 0, combinedLightIn);
         }
      }

	      matrixStackIn.popPose();
	   }

	   public static RenderMaterial getMaterial(Block blockIn) {
		   return new RenderMaterial(Atlases.SIGN_SHEET, TileEntityTextureHelper.NETHERWOOD_SIGN_LOCATION);
	   }

	   @OnlyIn(Dist.CLIENT)
	   public static final class SignModel extends Model {
	      public final ModelRenderer signBoard = new ModelRenderer(64, 32, 0, 0);
	      public final ModelRenderer signStick;

	      public SignModel() {
	         super(RenderType::entityCutoutNoCull);
	         this.signBoard.addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F, 0.0F);
	         this.signStick = new ModelRenderer(64, 32, 0, 14);
	         this.signStick.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F);
	      }

	      public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
	         this.signBoard.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	         this.signStick.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	      }
	   }
	   
}
