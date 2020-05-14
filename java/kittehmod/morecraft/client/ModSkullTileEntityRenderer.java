package kittehmod.morecraft.client;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.GlStateManager;

import kittehmod.morecraft.block.ModSkullBlock;
import kittehmod.morecraft.block.ModWallSkullBlock;
import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
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
	   private static final Map<ModSkullBlock.ISkullType, GenericHeadModel> MODELS = Util.make(Maps.newHashMap(), (p_209262_0_) -> {
	      GenericHeadModel genericheadmodel = new GenericHeadModel(0, 0, 64, 32);
	      //GenericHeadModel genericheadmodel1 = new HumanoidHeadModel();
	      p_209262_0_.put(ModSkullBlock.Types.SPIDER, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.CAVE_SPIDER, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.ZOMBIE_PIGMAN, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.BLAZE, genericheadmodel);
	      p_209262_0_.put(ModSkullBlock.Types.ENDERMAN, genericheadmodel);
	   });
	   private static final Map<ModSkullBlock.ISkullType, ResourceLocation> SKINS = Util.make(Maps.newHashMap(), (p_209263_0_) -> {
	      p_209263_0_.put(ModSkullBlock.Types.SPIDER, new ResourceLocation("textures/entity/spider/spider.png"));
	      p_209263_0_.put(ModSkullBlock.Types.CAVE_SPIDER, new ResourceLocation("textures/entity/spider/cave_spider.png"));
	      p_209263_0_.put(ModSkullBlock.Types.ZOMBIE_PIGMAN, new ResourceLocation("textures/entity/zombie_pigman.png"));
	      p_209263_0_.put(ModSkullBlock.Types.BLAZE, new ResourceLocation("textures/entity/blaze.png"));
	      p_209263_0_.put(ModSkullBlock.Types.ENDERMAN, new ResourceLocation("textures/entity/enderman/enderman.png"));
	   });

	   public void render(ModSkullTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
	      BlockState blockstate = tileEntityIn.getBlockState();
	      boolean flag = blockstate.getBlock() instanceof ModWallSkullBlock;
	      Direction direction = flag ? blockstate.get(ModWallSkullBlock.FACING) : null;
	      float f1 = 22.5F * (float)(flag ? (2 + direction.getHorizontalIndex()) * 4 : blockstate.get(ModSkullBlock.ROTATION));
	      this.render((float)x, (float)y, (float)z, direction, f1, ((AbstractSkullBlock)blockstate.getBlock()).getSkullType(), null, destroyStage, 0.0F);
	   }

	   public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
	      super.setRendererDispatcher(rendererDispatcherIn);
	      instance = this;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public void render(float x, float y, float z, @Nullable Direction facing, float rotationIn, ModSkullBlock.ISkullType type, @Nullable GameProfile playerProfile, int destroyStage, float animationProgress) {
	      GenericHeadModel genericheadmodel = MODELS.get(type);
	      if (destroyStage >= 0) {
	         this.bindTexture(DESTROY_STAGES[destroyStage]);
	         GlStateManager.matrixMode(5890);
	         GlStateManager.pushMatrix();
	         GlStateManager.scalef(4.0F, 2.0F, 1.0F);
	         GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
	         GlStateManager.matrixMode(5888);
	      } else {
	         this.bindTexture(this.func_199356_a(type, playerProfile));
	      }

	      GlStateManager.pushMatrix();
	      GlStateManager.disableCull();
	      if (facing == null) {
	         GlStateManager.translatef(x + 0.5F, y, z + 0.5F);
	      } else {
	         switch(facing) {
	         case NORTH:
	            GlStateManager.translatef(x + 0.5F, y + 0.25F, z + 0.74F);
	            break;
	         case SOUTH:
	            GlStateManager.translatef(x + 0.5F, y + 0.25F, z + 0.26F);
	            break;
	         case WEST:
	            GlStateManager.translatef(x + 0.74F, y + 0.25F, z + 0.5F);
	            break;
	         case EAST:
	         default:
	            GlStateManager.translatef(x + 0.26F, y + 0.25F, z + 0.5F);
	         }
	      }

	      GlStateManager.enableRescaleNormal();
	      GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
	      GlStateManager.enableAlphaTest();

	      genericheadmodel.func_217104_a(animationProgress, 0.0F, 0.0F, rotationIn, 0.0F, 0.0625F);
	      GlStateManager.popMatrix();
	      if (destroyStage >= 0) {
	         GlStateManager.matrixMode(5890);
	         GlStateManager.popMatrix();
	         GlStateManager.matrixMode(5888);
	      }

	   }

	   private ResourceLocation func_199356_a(ModSkullBlock.ISkullType p_199356_1_, @Nullable GameProfile p_199356_2_) {
	      ResourceLocation resourcelocation = SKINS.get(p_199356_1_);
	      return resourcelocation;
	   }
}
