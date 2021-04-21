package kittehmod.morecraft.block;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import kittehmod.morecraft.worldgen.NetherwoodTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class NetherSaplingBlock extends SaplingBlock implements IGrowable
{
	public static final Set<Block> EXTRA_ALLOWED_BLOCKS = ImmutableSet.of(Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM); 
	
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final NetherwoodTree treeGrower;

	public NetherSaplingBlock(NetherwoodTree treeIn, Block.Properties properties) {
		super(treeIn, properties);
		this.treeGrower = treeIn;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	@Override
	public boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return super.mayPlaceOn(state, worldIn, pos) || EXTRA_ALLOWED_BLOCKS.contains(block);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 0 && random.nextInt(7) == 0) {
			if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(worldIn, pos, state, random);
		}
	}

	@Override
	public void advanceTree(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand) {
		if (state.getValue(STAGE) == 0) {
			worldIn.setBlock(pos, state.cycle(STAGE), 4);
		} else {
			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
			this.treeGrower.growTree(worldIn, worldIn.getChunkSource().getGenerator(), pos, state, rand);
		}
	}
	

    /** Whether this IGrowable can grow */
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return (double)worldIn.random.nextFloat() < 0.45D;
	}
	
	public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.advanceTree(worldIn, pos, state, rand);
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
}