package kittehmod.morecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import kittehmod.morecraft.block.ModChestBlock;
import kittehmod.morecraft.blockentity.ModTrappedChestBlockEntity;
import kittehmod.morecraft.client.ClientHelper;
import kittehmod.morecraft.init.ModBlocks;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModChestRenderer<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T>
{
	private final ModelPart lid;
	private final ModelPart bottom;
	private final ModelPart lock;
	private final ModelPart doubleLeftLid;
	private final ModelPart doubleLeftBottom;
	private final ModelPart doubleLeftLock;
	private final ModelPart doubleRightLid;
	private final ModelPart doubleRightBottom;
	private final ModelPart doubleRightLock;
	
	private static final Material NETHERWOOD_CHEST = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST);
	private static final Material NETHERWOOD_CHEST_LEFT = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST_LEFT);
	private static final Material NETHERWOOD_CHEST_RIGHT = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST_RIGHT);

	private static final Material NETHERWOOD_TRAPPED_CHEST = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST_TRAPPED);
	private static final Material NETHERWOOD_TRAPPED_CHEST_LEFT = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST_TRAPPED_LEFT);
	private static final Material NETHERWOOD_TRAPPED_CHEST_RIGHT = new Material(Sheets.CHEST_SHEET, ClientHelper.NETHERWOOD_CHEST_TRAPPED_RIGHT);

	public ModChestRenderer(BlockEntityRendererProvider.Context context) {
		ModelPart modelpart = context.bakeLayer(ModelLayers.CHEST);
		this.bottom = modelpart.getChild("bottom");
		this.lid = modelpart.getChild("lid");
		this.lock = modelpart.getChild("lock");
		ModelPart modelpart1 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
		this.doubleLeftBottom = modelpart1.getChild("bottom");
		this.doubleLeftLid = modelpart1.getChild("lid");
		this.doubleLeftLock = modelpart1.getChild("lock");
		ModelPart modelpart2 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
		this.doubleRightBottom = modelpart2.getChild("bottom");
		this.doubleRightLid = modelpart2.getChild("lid");
		this.doubleRightLock = modelpart2.getChild("lock");
	}

	public static LayerDefinition createSingleBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
		partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createDoubleBodyRightLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
		partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createDoubleBodyLeftLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
		partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void render(T world, float p_112364_, PoseStack poseStack, MultiBufferSource mbsource, int p_112367_, int p_112368_) {
		Level level = world.getLevel();
		boolean flag = level != null;
		BlockState blockstate = flag ? world.getBlockState() : ModBlocks.NETHERWOOD_CHEST.get().defaultBlockState().setValue(ModChestBlock.FACING, Direction.SOUTH);
		ChestType chesttype = blockstate.hasProperty(ModChestBlock.TYPE) ? blockstate.getValue(ModChestBlock.TYPE) : ChestType.SINGLE;
		Block block = blockstate.getBlock();
		if (block instanceof ModChestBlock) {
			ModChestBlock abstractchestblock = (ModChestBlock) block;
			boolean flag1 = chesttype != ChestType.SINGLE;
			poseStack.pushPose();
			float f = blockstate.getValue(ModChestBlock.FACING).toYRot();
			poseStack.translate(0.5D, 0.5D, 0.5D);
			poseStack.mulPose(Vector3f.YP.rotationDegrees(-f));
			poseStack.translate(-0.5D, -0.5D, -0.5D);
			DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborcombineresult;
			if (flag) {
				neighborcombineresult = abstractchestblock.combine(blockstate, level, world.getBlockPos(), true);
			} else {
				neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
			}

			float f1 = neighborcombineresult.<Float2FloatFunction>apply(ModChestBlock.opennessCombiner(world)).get(p_112364_);
			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			int i = neighborcombineresult.<Int2IntFunction>apply(new BrightnessCombiner<>()).applyAsInt(p_112367_);
			Material material = this.getMaterial(world, chesttype);
			VertexConsumer vertexconsumer = material.buffer(mbsource, RenderType::entityCutout);
			if (flag1) {
				if (chesttype == ChestType.LEFT) {
					this.render(poseStack, vertexconsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, f1, i, p_112368_);
				} else {
					this.render(poseStack, vertexconsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, f1, i, p_112368_);
				}
			} else {
				this.render(poseStack, vertexconsumer, this.lid, this.lock, this.bottom, f1, i, p_112368_);
			}

			poseStack.popPose();
		}
	}

	private void render(PoseStack p_112370_, VertexConsumer p_112371_, ModelPart p_112372_, ModelPart p_112373_, ModelPart p_112374_, float p_112375_, int p_112376_, int p_112377_) {
		p_112372_.xRot = -(p_112375_ * ((float) Math.PI / 2F));
		p_112373_.xRot = p_112372_.xRot;
		p_112372_.render(p_112370_, p_112371_, p_112376_, p_112377_);
		p_112373_.render(p_112370_, p_112371_, p_112376_, p_112377_);
		p_112374_.render(p_112370_, p_112371_, p_112376_, p_112377_);
	}

	protected Material getMaterial(T blockEntity, ChestType chestType) {
		if (chestType == ChestType.SINGLE) {
			return blockEntity instanceof ModTrappedChestBlockEntity ? NETHERWOOD_TRAPPED_CHEST : NETHERWOOD_CHEST;
		} else if (chestType == ChestType.LEFT) {
			return blockEntity instanceof ModTrappedChestBlockEntity ? NETHERWOOD_TRAPPED_CHEST_LEFT : NETHERWOOD_CHEST_LEFT;
		} else if (chestType == ChestType.RIGHT) {
			return blockEntity instanceof ModTrappedChestBlockEntity ? NETHERWOOD_TRAPPED_CHEST_RIGHT : NETHERWOOD_CHEST_RIGHT;
		} else {
			return blockEntity instanceof ModTrappedChestBlockEntity ? NETHERWOOD_TRAPPED_CHEST : NETHERWOOD_CHEST;
		}
	}

}