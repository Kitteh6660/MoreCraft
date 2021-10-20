package kittehmod.morecraft.block.addons;

import javax.annotation.Nullable;

import kittehmod.morecraft.tileentity.addons.ModBookcaseTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModBookcaseBlock extends ContainerBlock
{
	public static final IntegerProperty SLOTS = IntegerProperty.create("slots", 0, ModBookcaseTileEntity.SIZE);

	public ModBookcaseBlock(Properties properties, WoodType woodtype) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(SLOTS, 0));
	}

	public BlockRenderType getRenderShape(BlockState p_149645_1_) {
		return BlockRenderType.MODEL;
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(SLOTS);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
		return new ModBookcaseTileEntity();
	}

	public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		if (p_180633_5_.hasCustomHoverName()) {
			TileEntity tileentity = p_180633_1_.getBlockEntity(p_180633_2_);
			if (tileentity instanceof ModBookcaseTileEntity) {
				((ModBookcaseTileEntity) tileentity).setCustomName(p_180633_5_.getHoverName());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropContents(worldIn, pos, (IInventory) tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
		if (p_225533_2_.isClientSide) {
			return ActionResultType.SUCCESS;
		} else if (p_225533_4_.isSpectator()) {
			return ActionResultType.CONSUME;
		} else {
			TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
			if (tileentity instanceof ModBookcaseTileEntity) {
				p_225533_4_.openMenu((ModBookcaseTileEntity) tileentity);
				p_225533_4_.awardStat(Stats.OPEN_BARREL);
				PiglinTasks.angerNearbyPiglins(p_225533_4_, true);
				return ActionResultType.CONSUME;
			} else {
				return ActionResultType.PASS;
			}
		}
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return VoxelShapes.block();
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.NORMAL;
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState p_180641_1_, World p_180641_2_, BlockPos p_180641_3_) {
		return Container.getRedstoneSignalFromContainer((IInventory) p_180641_2_.getBlockEntity(p_180641_3_));
	}
}
