package kittehmod.morecraft.block;

import kittehmod.morecraft.worldgen.NetherwoodTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NetherSaplingBlock extends SaplingBlock implements BonemealableBlock
{
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final NetherwoodTreeGrower treeGrower;

	public NetherSaplingBlock(NetherwoodTreeGrower treeIn, Block.Properties properties) {
		super(treeIn, properties);
		this.treeGrower = treeIn;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	@Override
	public boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return super.mayPlaceOn(state, worldIn, pos) || state.is(ModBlockTags.NETHERWOOD_SAPLING_PLANTABLES);
	}

	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		if (p_51028_.getBlock() == this) // Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
			return p_51029_.getBlockState(blockpos).canSustainPlant(p_51029_, blockpos, Direction.UP, this);
		return this.mayPlaceOn(p_51029_.getBlockState(blockpos), p_51029_, blockpos);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 0 && random.nextInt(7) == 0) {
			if (!worldIn.isAreaLoaded(pos, 1))
				return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(worldIn, pos, state, random);
		}
	}

	@Override
	public void advanceTree(ServerLevel worldIn, BlockPos pos, BlockState state, RandomSource rand) {
		if (state.getValue(STAGE) == 0) {
			worldIn.setBlock(pos, state.cycle(STAGE), 4);
		} else {
			this.treeGrower.growTree(worldIn, worldIn.getChunkSource().getGenerator(), pos, state, rand);
		}
	}
}