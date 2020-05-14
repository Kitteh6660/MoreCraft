package kittehmod.morecraft.worldgen;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class NetherwoodTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
	private static final BlockState LOG = ModBlocks.NETHERWOOD_LOG.get().getDefaultState();
	private static final BlockState LEAF = ModBlocks.NETHERWOOD_LEAVES.get().getDefaultState();
	private final boolean attemptNetherGen;
	   
	public NetherwoodTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, boolean netherGenAttempt) {
		super(configIn, doBlockNotifyIn);
		this.attemptNetherGen = netherGenAttempt;
		this.setSapling((net.minecraftforge.common.IPlantable)ModBlocks.NETHERWOOD_SAPLING.get());
	}

	public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
		int i = rand.nextInt(3) + 5;
		int p;

		boolean flag = true;
		if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight()) {
			for(int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;
				if (j == position.getY()) {
					k = 0;
				}

				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}

				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

				for(int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for(int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getMaxHeight()) {
							if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			
			if (attemptNetherGen && flag) {
				for (p = 0; p < 10; p++) {
					if (worldIn.hasBlockState(position.down(p), (block) -> block.getBlock() == Blocks.NETHERRACK || block.getBlock() == Blocks.SOUL_SAND)) { //Attemot to pull the block down.
						worldIn.setBlockState(position.down(p), Blocks.SOUL_SAND.getDefaultState(), 11);
						break;
					}
				}
				position = position.down(p-1);
				for (p = 0; p < i; p++) {
					if (worldIn.hasBlockState(position.up(p), (block) -> block.getBlock() != Blocks.AIR)) {
						flag = false;
						break;
					}
				}
			}
			
			if (!flag) {
				return false;
			} else if ((isSoil(worldIn, position.down(), getSapling())) && position.getY() < worldIn.getMaxHeight() - i - 1) {
				if (!isSoulSand(worldIn, position.down())) this.setDirtAt(worldIn, position.down(), position);

				for(int l1 = position.getY() - 3 + i; l1 <= position.getY() + i; ++l1) {
					int j2 = l1 - (position.getY() + i);
					int k2 = 1 - j2 / 2;

					for(int l2 = position.getX() - k2; l2 <= position.getX() + k2; ++l2) {
						int i3 = l2 - position.getX();

						for(int j1 = position.getZ() - k2; j1 <= position.getZ() + k2; ++j1) {
							int k1 = j1 - position.getZ();
							if (Math.abs(i3) != k2 || Math.abs(k1) != k2 || rand.nextInt(2) != 0 && j2 != 0) {
								BlockPos blockpos = new BlockPos(l2, l1, j1);
								if (isAirOrLeaves(worldIn, blockpos)) {
									this.setLogState(changedBlocks, worldIn, blockpos, LEAF, p_208519_5_);
								}
							}
						}
					}
				}

				for(int i2 = 0; i2 < i; ++i2) {
					if (isAirOrLeaves(worldIn, position.up(i2))) {
						this.setLogState(changedBlocks, worldIn, position.up(i2), LOG, p_208519_5_);
					}
				}

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	protected static boolean isDirtOrGrassBlock(IWorldGenerationBaseReader worldIn, BlockPos pos) {
		return worldIn.hasBlockState(pos, (p_214582_0_) -> {
			Block block = p_214582_0_.getBlock();
			return Block.isDirt(block) || block == Blocks.GRASS_BLOCK;
		});
	}
	
	protected static boolean isSoulSand(IWorldGenerationBaseReader worldIn, BlockPos pos) {
		return worldIn.hasBlockState(pos, (p_214582_0_) -> {
			Block block = p_214582_0_.getBlock();
			return block == Blocks.SOUL_SAND;
		});
	}

	protected static boolean isSoil(IWorldGenerationBaseReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
		if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
			return isDirtOrGrassBlock(reader, pos) || isSoulSand(reader, pos);
		return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader)reader, pos, Direction.UP, sapling));
	}
	
	protected static boolean isAirOrLeaves(IWorldGenerationBaseReader worldIn, BlockPos pos) {
		if (!(worldIn instanceof net.minecraft.world.IWorldReader)) // FORGE: Redirect to state method when possible
			return worldIn.hasBlockState(pos, (p_214581_0_) -> {
				return p_214581_0_.getBlock() == Blocks.AIR || p_214581_0_.isIn(BlockTags.LEAVES);
			});
		else return worldIn.hasBlockState(pos, state -> state.canBeReplacedByLeaves((net.minecraft.world.IWorldReader)worldIn, pos));
	}
}
