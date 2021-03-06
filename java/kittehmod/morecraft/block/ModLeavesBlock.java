package kittehmod.morecraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModLeavesBlock extends LeavesBlock
{	
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

	public ModLeavesBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));
	}
	
	/**
	* Returns whether or not this block is of a type that needs random ticking. Called for ref-counting purposes by
	* ExtendedBlockStorage in order to broadly cull a chunk from the random chunk update list for efficiency's sake.
	*/
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!state.getValue(PERSISTENT) && state.getValue(DISTANCE) == 7) {
			dropResources(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		}

	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);
	}

	@Override
	public int getLightBlock(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}

	/**
	* Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	* For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	* returns its solidified counterpart.
	* Note that this method should ideally consider only the specific face passed in.
	*/
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		int i = getDistanceAt(facingState) + 1;
		if (i != 1 || stateIn.getValue(DISTANCE) != i) {
			worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
		}

		return stateIn;
	}

	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		int i = 7;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for(Direction direction : Direction.values()) {
			blockpos$mutable.setWithOffset(pos, direction);
			i = Math.min(i, getDistanceAt(worldIn.getBlockState(blockpos$mutable)) + 1);
			if (i == 1) {
				break;
			}
		}

		return state.setValue(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistanceAt(BlockState neighbor) {
		if (neighbor.getBlock() == ModBlocks.NETHERWOOD_LOG.get() || neighbor.getBlock() == ModBlocks.STRIPPED_NETHERWOOD_LOG.get() || neighbor.getBlock() == ModBlocks.NETHERWOOD_WOOD.get() || neighbor.getBlock() == ModBlocks.STRIPPED_NETHERWOOD_WOOD.get()) {
			return 0;
		} else {
			return neighbor.getBlock() instanceof LeavesBlock ? neighbor.getValue(DISTANCE) : 7;
		}
	}

	/**
* Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
* this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
* of whether the block can receive random update ticks
*/
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRainingAt(pos.above())) {
			if (rand.nextInt(15) == 1) {
				BlockPos blockpos = pos.below();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(worldIn, blockpos, Direction.UP)) {
					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DISTANCE, PERSISTENT);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true)), context.getLevel(), context.getClickedPos());
	}
}