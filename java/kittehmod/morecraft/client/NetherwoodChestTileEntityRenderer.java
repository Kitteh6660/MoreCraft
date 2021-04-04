package kittehmod.morecraft.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.ModChestBlock;
import kittehmod.morecraft.block.ModTrappedChestBlock;
import kittehmod.morecraft.tileentity.NetherwoodChestTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.DualBrightnessCallback;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;

public class NetherwoodChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T>
{

	private final ModelRenderer lid;
	private final ModelRenderer bottom;
	private final ModelRenderer lock;
	private final ModelRenderer doubleLeftLid;
	private final ModelRenderer doubleLeftBottom;
	private final ModelRenderer doubleLeftLock;
	private final ModelRenderer doubleRightLid;
	private final ModelRenderer doubleRightBottom;
	private final ModelRenderer doubleRightLock;

	public NetherwoodChestTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);

		this.bottom = new ModelRenderer(64, 64, 0, 19);
		this.bottom.addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F, 0.0F);
		this.lid = new ModelRenderer(64, 64, 0, 0);
		this.lid.addBox(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, 0.0F);
		this.lid.y = 9.0F;
		this.lid.z = 1.0F;
		this.lock = new ModelRenderer(64, 64, 0, 0);
		this.lock.addBox(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F, 0.0F);
		this.lock.y = 8.0F;
		this.doubleLeftBottom = new ModelRenderer(64, 64, 0, 19);
		this.doubleLeftBottom.addBox(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F, 0.0F);
		this.doubleLeftLid = new ModelRenderer(64, 64, 0, 0);
		this.doubleLeftLid.addBox(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F, 0.0F);
		this.doubleLeftLid.y = 9.0F;
		this.doubleLeftLid.z = 1.0F;
		this.doubleLeftLock = new ModelRenderer(64, 64, 0, 0);
		this.doubleLeftLock.addBox(15.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F, 0.0F);
		this.doubleLeftLock.y = 8.0F;
		this.doubleRightBottom = new ModelRenderer(64, 64, 0, 19);
		this.doubleRightBottom.addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F, 0.0F);
		this.doubleRightLid = new ModelRenderer(64, 64, 0, 0);
		this.doubleRightLid.addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F, 0.0F);
		this.doubleRightLid.y = 9.0F;
		this.doubleRightLid.z = 1.0F;
		this.doubleRightLock = new ModelRenderer(64, 64, 0, 0);
		this.doubleRightLock.addBox(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F, 0.0F);
		this.doubleRightLock.y = 8.0F;
	}

	@Override
	public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		World world = tileEntityIn.getLevel();
		boolean flag = world != null;
		BlockState blockstate = flag ? tileEntityIn.getBlockState() : ModBlocks.NETHERWOOD_CHEST.get().defaultBlockState().setValue(ModChestBlock.FACING, Direction.SOUTH);
		ChestType chesttype = blockstate.hasProperty(ModChestBlock.TYPE) ? blockstate.getValue(ModChestBlock.TYPE) : ChestType.SINGLE;
		Block block = blockstate.getBlock();
		if (block instanceof ModChestBlock) {
			ModChestBlock chestblock = (ModChestBlock) block;
			boolean flag1 = chesttype != ChestType.SINGLE;
			matrixStackIn.pushPose();
			float f = blockstate.getValue(ModChestBlock.FACING).toYRot();
			matrixStackIn.translate(0.5D, 0.5D, 0.5D);
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-f));
			matrixStackIn.translate(-0.5D, -0.5D, -0.5D);
			TileEntityMerger.ICallbackWrapper<? extends NetherwoodChestTileEntity> icallbackwrapper;
			if (flag) {
				icallbackwrapper = chestblock.combine(blockstate, world, tileEntityIn.getBlockPos(), false);
			} else {
				icallbackwrapper = TileEntityMerger.ICallback::acceptNone;
			}

			float f1 = icallbackwrapper.<Float2FloatFunction>apply(ModChestBlock.opennessCombiner(tileEntityIn)).get(partialTicks);
			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			int i = icallbackwrapper.<Int2IntFunction>apply(new DualBrightnessCallback<>()).applyAsInt(combinedLightIn);
			RenderMaterial rendermaterial = this.getMaterial(tileEntityIn, chesttype, false);
			IVertexBuilder ivertexbuilder = rendermaterial.buffer(bufferIn, RenderType::entityCutout);
			if (flag1) {
				if (chesttype == ChestType.LEFT) {
					this.render(matrixStackIn, ivertexbuilder, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, f1, i, combinedOverlayIn);
				} else {
					this.render(matrixStackIn, ivertexbuilder, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, f1, i, combinedOverlayIn);
				}
			} else {
				this.render(matrixStackIn, ivertexbuilder, this.lid, this.lock, this.bottom, f1, i, combinedOverlayIn);
			}

			matrixStackIn.popPose();
		}
		if (block instanceof ModTrappedChestBlock) {
			ModTrappedChestBlock chestblock = (ModTrappedChestBlock) block;
			boolean flag1 = chesttype != ChestType.SINGLE;
			matrixStackIn.pushPose();
			float f = blockstate.getValue(ModTrappedChestBlock.FACING).toYRot();
			matrixStackIn.translate(0.5D, 0.5D, 0.5D);
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-f));
			matrixStackIn.translate(-0.5D, -0.5D, -0.5D);
			TileEntityMerger.ICallbackWrapper<? extends NetherwoodTrappedChestTileEntity> icallbackwrapper;
			if (flag) {
				icallbackwrapper = chestblock.combine(blockstate, world, tileEntityIn.getBlockPos(), true);
			} else {
				icallbackwrapper = TileEntityMerger.ICallback::acceptNone;
			}

			float f1 = icallbackwrapper.<Float2FloatFunction>apply(ModTrappedChestBlock.opennessCombiner(tileEntityIn)).get(partialTicks);
			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			int i = icallbackwrapper.<Int2IntFunction>apply(new DualBrightnessCallback<>()).applyAsInt(combinedLightIn);
			RenderMaterial rendermaterial = this.getMaterial(tileEntityIn, chesttype, true);
			IVertexBuilder ivertexbuilder = rendermaterial.buffer(bufferIn, RenderType::entityCutout);
			if (flag1) {
				if (chesttype == ChestType.LEFT) {
					this.render(matrixStackIn, ivertexbuilder, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, f1, i, combinedOverlayIn);
				} else {
					this.render(matrixStackIn, ivertexbuilder, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, f1, i, combinedOverlayIn);
				}
			} else {
				this.render(matrixStackIn, ivertexbuilder, this.lid, this.lock, this.bottom, f1, i, combinedOverlayIn);
			}

			matrixStackIn.popPose();
		}
	}

	private void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, ModelRenderer chestLid, ModelRenderer chestLatch, ModelRenderer chestBottom, float lidAngle, int combinedLightIn, int combinedOverlayIn) {
		chestLid.xRot = -(lidAngle * ((float) Math.PI / 2F));
		chestLatch.xRot = chestLid.xRot;
		chestLid.render(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
		chestLatch.render(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
		chestBottom.render(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
	}

	protected RenderMaterial getMaterial(T tileEntity, ChestType chestType, Boolean trapped) {
		return new RenderMaterial(Atlases.CHEST_SHEET, TileEntityTextureHelper.chooseChestTexture(chestType, trapped));
	}

}