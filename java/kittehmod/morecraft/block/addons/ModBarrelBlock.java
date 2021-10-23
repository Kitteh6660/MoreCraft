package kittehmod.morecraft.block.addons;

import java.util.Random;

import javax.annotation.Nullable;

import kittehmod.morecraft.blockentity.addons.ModBarrelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ModBarrelBlock extends BaseEntityBlock
{
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

	public ModBarrelBlock(Block.Properties p_i49996_1_) {
		super(p_i49996_1_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)));
	}

	public InteractionResult use(BlockState p_225533_1_, Level p_225533_2_, BlockPos p_225533_3_, Player p_225533_4_, InteractionHand p_225533_5_, BlockHitResult p_225533_6_) {
		if (p_225533_2_.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			BlockEntity blockentity = p_225533_2_.getBlockEntity(p_225533_3_);
			if (blockentity instanceof ModBarrelBlockEntity) {
				p_225533_4_.openMenu((ModBarrelBlockEntity) blockentity);
				p_225533_4_.awardStat(Stats.OPEN_BARREL);
				PiglinAi.angerNearbyPiglins(p_225533_4_, true);
			}

			return InteractionResult.CONSUME;
		}
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState p_196243_1_, Level p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
		if (!p_196243_1_.is(p_196243_4_.getBlock())) {
			BlockEntity blockentity = p_196243_2_.getBlockEntity(p_196243_3_);
			if (blockentity instanceof Container) {
				Containers.dropContents(p_196243_2_, p_196243_3_, (Container) blockentity);
				p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, this);
			}
			super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
		}
	}

	public void tick(BlockState p_225534_1_, ServerLevel p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
		BlockEntity blockentity = p_225534_2_.getBlockEntity(p_225534_3_);
		if (blockentity instanceof ModBarrelBlockEntity) {
			((ModBarrelBlockEntity) blockentity).recheckOpen();
		}

	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModBarrelBlockEntity(pos, state);
	}

	public RenderShape getRenderShape(BlockState p_149645_1_) {
		return RenderShape.MODEL;
	}

	public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		if (p_180633_5_.hasCustomHoverName()) {
			BlockEntity blockentity = p_180633_1_.getBlockEntity(p_180633_2_);
			if (blockentity instanceof ModBarrelBlockEntity) {
				((ModBarrelBlockEntity) blockentity).setCustomName(p_180633_5_.getHoverName());
			}
		}
	}

	public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
		return true;
	}

	public int getAnalogOutputSignal(BlockState p_180641_1_, Level p_180641_2_, BlockPos p_180641_3_) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(p_180641_2_.getBlockEntity(p_180641_3_));
	}

	public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
		return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
		return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, OPEN);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
		return this.defaultBlockState().setValue(FACING, p_196258_1_.getNearestLookingDirection().getOpposite());
	}
}
