package kittehmod.morecraft.block.addons;

import java.util.function.Supplier;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class ModPostBlock extends Block implements SimpleWaterloggedBlock
{
	private static final VoxelShape SHAPE_X = box(0.0F, 6.0F, 6.0F, 16.0F, 10.0F, 10.0F);
	private static final VoxelShape SHAPE_Y = box(6.0F, 0.0F, 6.0F, 10.0F, 16.0F, 10.0F);
	private static final VoxelShape SHAPE_Z = box(6.0F, 6.0F, 0.0F, 10.0F, 10.0F, 16.0F);
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final EnumProperty<Axis> AXIS = BlockStateProperties.AXIS;
	private static final BooleanProperty[] CHAINED = new BooleanProperty[] { BooleanProperty.create("chain_down"), BooleanProperty.create("chain_up"), BooleanProperty.create("chain_north"), BooleanProperty.create("chain_south"), BooleanProperty.create("chain_west"), BooleanProperty.create("chain_east") };

	//private final Supplier<Block> block;

	public ModPostBlock(Properties properties) {
		this(null, properties);
	}

	public ModPostBlock(Supplier<Block> block, Properties properties) {
		super(properties);
		//this.block = block;
		BlockState defaultState = this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(AXIS, Axis.Y);
		for (BooleanProperty prop : CHAINED)
			defaultState = defaultState.setValue(prop, false);
		this.registerDefaultState(defaultState.setValue(AXIS, Axis.Y).setValue(WATERLOGGED, false));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(AXIS)) {
		case X:
			return SHAPE_X;
		case Y:
			return SHAPE_Y;
		default:
			return SHAPE_Z;
		}
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.getRelevantState(context.getLevel(), context.getClickedPos(), context.getClickedFace().getAxis());
	}

	@Override
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		BlockState newState = this.getRelevantState(worldIn, pos, state.getValue(AXIS));
		if (!newState.equals(state))
			worldIn.setBlockAndUpdate(pos, newState);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, AXIS);
		for (BooleanProperty prop : CHAINED)
			builder.add(prop);
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolType) {
		if (toolType == ToolActions.AXE_STRIP) {
			Block block = state.getBlock() == ModBlocks.NETHERWOOD_POST.get() ? ModBlocks.STRIPPED_NETHERWOOD_POST.get() : ModBlocks.STRIPPED_NETHERWOOD_POST.get();
			return block != null ? block.defaultBlockState().setValue(AXIS, state.getValue(AXIS)).setValue(CHAINED[0], state.getValue(CHAINED[0])).setValue(CHAINED[1], state.getValue(CHAINED[1])).setValue(CHAINED[2], state.getValue(CHAINED[2])).setValue(CHAINED[3], state.getValue(CHAINED[3])).setValue(CHAINED[4], state.getValue(CHAINED[4])).setValue(CHAINED[5], state.getValue(CHAINED[5])).setValue(WATERLOGGED, state.getValue(WATERLOGGED)) : null;
		}
		return super.getToolModifiedState(state, world, pos, player, stack, toolType);
	}
	
	private BlockState getRelevantState(Level world, BlockPos pos, Axis axis) {
		BlockState state = this.defaultBlockState().setValue(WATERLOGGED, world.getFluidState(pos).getType() == Fluids.WATER).setValue(AXIS, axis);

		for (Direction direction : Direction.values()) {
			if (direction.getAxis() == axis)
				continue;

			BlockState sideState = world.getBlockState(pos.relative(direction));
			if ((sideState.getBlock() instanceof ChainBlock && sideState.getValue(BlockStateProperties.AXIS) == direction.getAxis()) || (direction == Direction.DOWN && sideState.getBlock() instanceof LanternBlock && sideState.getValue(LanternBlock.HANGING)))
				state = state.setValue(CHAINED[direction.ordinal()], true);
		}

		return state;
	}
}