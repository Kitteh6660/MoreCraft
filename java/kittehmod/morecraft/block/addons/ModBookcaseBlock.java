package kittehmod.morecraft.block.addons;

import javax.annotation.Nullable;

import kittehmod.morecraft.blockentity.addons.ModBookcaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModBookcaseBlock extends BaseEntityBlock
{
	public static final IntegerProperty SLOTS = IntegerProperty.create("slots", 0, ModBookcaseBlockEntity.SIZE);

	public ModBookcaseBlock(Properties properties, WoodType woodtype) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(SLOTS, 0));
	}

	public RenderShape getRenderShape(BlockState p_149645_1_) {
		return RenderShape.MODEL;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(SLOTS);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModBookcaseBlockEntity(pos, state);
	}

	public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		if (p_180633_5_.hasCustomHoverName()) {
			BlockEntity blockentity = p_180633_1_.getBlockEntity(p_180633_2_);
			if (blockentity instanceof ModBookcaseBlockEntity) {
				((ModBookcaseBlockEntity) blockentity).setCustomName(p_180633_5_.getHoverName());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockentity = worldIn.getBlockEntity(pos);
			if (blockentity instanceof Container) {
				Containers.dropContents(worldIn, pos, (Container) blockentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public InteractionResult use(BlockState p_225533_1_, Level p_225533_2_, BlockPos p_225533_3_, Player p_225533_4_, InteractionHand p_225533_5_, BlockHitResult p_225533_6_) {
		if (p_225533_2_.isClientSide) {
			return InteractionResult.SUCCESS;
		} else if (p_225533_4_.isSpectator()) {
			return InteractionResult.CONSUME;
		} else {
			BlockEntity blockentity = p_225533_2_.getBlockEntity(p_225533_3_);
			if (blockentity instanceof ModBookcaseBlockEntity) {
				p_225533_4_.openMenu((ModBookcaseBlockEntity) blockentity);
				p_225533_4_.awardStat(Stats.OPEN_BARREL);
				PiglinAi.angerNearbyPiglins(p_225533_4_, true);
				return InteractionResult.CONSUME;
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
		return Shapes.block();
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
	public int getAnalogOutputSignal(BlockState p_180641_1_, Level p_180641_2_, BlockPos p_180641_3_) {
		return AbstractContainerMenu.getRedstoneSignalFromContainer((Container) p_180641_2_.getBlockEntity(p_180641_3_));
	}
}
