package kittehmod.morecraft.worldgen;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.NetherSaplingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

public class NetherwoodTreeFeature extends Feature<TreeConfiguration>
{
	public static final int CHANCE_BARRENS = 2;
	public static final int CHANCE_MODERATE = 5;
	public static final int CHANCE_LUSH = 10;

	public NetherwoodTreeFeature(Codec<TreeConfiguration> codecIn, boolean netherGenAttempt) {
		super(codecIn);
		// this.attemptNetherGen = netherGenAttempt;
	}

	public static boolean isFree(LevelSimulatedReader p_236410_0_, BlockPos p_236410_1_) {
		return validTreePos(p_236410_0_, p_236410_1_) || p_236410_0_.isStateAtPosition(p_236410_1_, (p_236417_0_) -> { return p_236417_0_.is(BlockTags.LOGS); });
	}

	private static boolean isVine(LevelSimulatedReader p_236414_0_, BlockPos p_236414_1_) {
		return p_236414_0_.isStateAtPosition(p_236414_1_, (p_236415_0_) -> { return p_236415_0_.is(Blocks.VINE); });
	}

	private static boolean isBlockWater(LevelSimulatedReader p_236416_0_, BlockPos p_236416_1_) {
		return p_236416_0_.isStateAtPosition(p_236416_1_, (p_236413_0_) -> { return p_236413_0_.is(Blocks.WATER); });
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader p_236412_0_, BlockPos p_236412_1_) {
		return p_236412_0_.isStateAtPosition(p_236412_1_, (p_236411_0_) -> { return p_236411_0_.isAir() || p_236411_0_.is(BlockTags.LEAVES); });
	}

	private static boolean isGrassOrDirtOrFarmland(LevelSimulatedReader p_236418_0_, BlockPos pos) {
		return p_236418_0_.isStateAtPosition(pos, (blockstate) -> {
			Block block = blockstate.getBlock();
			return blockstate.is(BlockTags.DIRT) || block == Blocks.FARMLAND || NetherSaplingBlock.EXTRA_ALLOWED_BLOCKS.contains(block);
		});
	}

	private static boolean isReplaceablePlant(LevelSimulatedReader p_236419_0_, BlockPos p_236419_1_) {
		return p_236419_0_.isStateAtPosition(p_236419_1_, (p_236406_0_) -> {
			Material material = p_236406_0_.getMaterial();
			return material == Material.REPLACEABLE_PLANT;
		});
	}

	public static void setBlockKnownShape(LevelWriter p_236408_0_, BlockPos p_236408_1_, BlockState p_236408_2_) {
		p_236408_0_.setBlock(p_236408_1_, p_236408_2_, 19);
	}

	public static boolean validTreePos(LevelSimulatedReader p_236404_0_, BlockPos p_236404_1_) {
		return isAirOrLeaves(p_236404_0_, p_236404_1_) || isReplaceablePlant(p_236404_0_, p_236404_1_) || isBlockWater(p_236404_0_, p_236404_1_);
	}

	/**
	 * Called when placing the tree feature.
	 */
	private boolean doPlace(WorldGenLevel generationReader, Random rand, BlockPos positionIn, BiConsumer<BlockPos, BlockState> biconsumer1, BiConsumer<BlockPos, BlockState> biconsumer2, TreeConfiguration configIn) {
		int i = configIn.trunkPlacer.getTreeHeight(rand);
		int j = configIn.foliagePlacer.foliageHeight(rand, i, configIn);
		int k = i - j;
		int l = configIn.foliagePlacer.foliageRadius(rand, k);
		BlockPos blockpos = positionIn;
		BlockState blockstate = generationReader.getBlockState(blockpos.below());
		BlockState origstate = generationReader.getBlockState(blockpos.below());
		if (!randomChancePassed(generationReader, positionIn, rand)) {
			return false;
		}
		if (blockpos.getY() >= 1 && blockpos.getY() + i + 1 <= 256) {
			if (generationReader.isStateAtPosition(blockpos.below(), (block) -> block.getBlock() == Blocks.NETHERRACK)) {
				blockstate = Blocks.SOUL_SOIL.defaultBlockState(); //Set the blockstate for Netherrack to Soul Soil.
				generationReader.setBlock(blockpos.below(), blockstate, 19);
			}
			if (!isGrassOrDirtOrFarmland(generationReader, blockpos.below())) {
				if (origstate != null) {
					generationReader.setBlock(blockpos.below(), origstate, 19); // Revert the block.
				}
				return false;
			} else {
				OptionalInt optionalint = configIn.minimumSize.minClippedHeight();
				if (generationReader.isStateAtPosition(blockpos, (block) -> block.getBlock() == ModBlocks.NETHERWOOD_SAPLING.get())) {
					generationReader.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 4);
				}

				int i1 = this.getMaxFreeTreeHeight(generationReader, i, blockpos, configIn);
				if (i1 >= i || optionalint.isPresent() && i1 >= optionalint.getAsInt()) {
					List<FoliagePlacer.FoliageAttachment> list = configIn.trunkPlacer.placeTrunk(generationReader, biconsumer1, rand, i1, positionIn, configIn);
					list.forEach((p_160539_) -> { configIn.foliagePlacer.createFoliage(generationReader, biconsumer2, rand, configIn, i1, p_160539_, j, l); });
					if (blockstate != null) {
						generationReader.setBlock(blockpos.below(), blockstate, 19);
					}
					return true;
				} else {
					if (origstate != null) {
						generationReader.setBlock(blockpos.below(), origstate, 19); // Revert the block.
					}
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private boolean randomChancePassed(WorldGenLevel generationReader, BlockPos blockpos, Random rand) {
		int chance = 1;
		// Skip RNG if there's Netherwood Sapling planted.
		if (generationReader.isStateAtPosition(blockpos, (block) -> block.getBlock() == ModBlocks.NETHERWOOD_SAPLING.get())) {
			return true;
		}
		// 100% chance if in Netherwood Forest biome
		if (generationReader.getBiome(blockpos).value() == ModBiomes.NETHERWOOD_FOREST.get()) {
			return true;
		}
		// Reduce the frequency of Netherwood trees.
		if (generationReader.isStateAtPosition(blockpos.below(), (block) -> block.getBlock() == Blocks.CRIMSON_NYLIUM || block.getBlock() == Blocks.WARPED_NYLIUM)) {
			chance = CHANCE_LUSH;
		} 
		else if (generationReader.isStateAtPosition(blockpos.below(), (block) -> block.getBlock() == Blocks.SOUL_SAND || block.getBlock() == Blocks.SOUL_SOIL)) {
			chance = CHANCE_MODERATE;
		}
		else if (generationReader.isStateAtPosition(blockpos.below(), (block) -> block.getBlock() == Blocks.NETHERRACK)) {
			chance = CHANCE_BARRENS;
		}
		if (rand.nextInt(100) >= chance) {
			return false;
		}
		return true;
	}
	
	private int getMaxFreeTreeHeight(LevelSimulatedReader p_241521_1_, int p_241521_2_, BlockPos p_241521_3_, TreeConfiguration p_241521_4_) {
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int i = 0; i <= p_241521_2_ + 1; ++i) {
			int j = p_241521_4_.minimumSize.getSizeAtHeight(p_241521_2_, i);

			for (int k = -j; k <= j; ++k) {
				for (int l = -j; l <= j; ++l) {
					blockpos$mutable.setWithOffset(p_241521_3_, k, i, l);
					if (!isFree(p_241521_1_, blockpos$mutable) || !p_241521_4_.ignoreVines && isVine(p_241521_1_, blockpos$mutable)) {
						return i - 2;
					}
				}
			}
		}

		return p_241521_2_;
	}

	@Override
	public final boolean place(FeaturePlaceContext<TreeConfiguration> placeContxt) {
		WorldGenLevel worldgenlevel = placeContxt.level();
		Random random = placeContxt.random();
		BlockPos blockpos = placeContxt.origin();
		TreeConfiguration treeconfiguration = placeContxt.config();
		Set<BlockPos> set = Sets.newHashSet();
		Set<BlockPos> set1 = Sets.newHashSet();
		Set<BlockPos> set2 = Sets.newHashSet();
		BiConsumer<BlockPos, BlockState> biconsumer = (p_160555_, p_160556_) -> {
			set.add(p_160555_.immutable());
			worldgenlevel.setBlock(p_160555_, p_160556_, 19);
		};
		BiConsumer<BlockPos, BlockState> biconsumer1 = (p_160548_, p_160549_) -> {
			set1.add(p_160548_.immutable());
			worldgenlevel.setBlock(p_160548_, p_160549_, 19);
		};
		BiConsumer<BlockPos, BlockState> biconsumer2 = (p_160543_, p_160544_) -> {
			set2.add(p_160543_.immutable());
			worldgenlevel.setBlock(p_160543_, p_160544_, 19);
		};
		boolean flag = this.doPlace(worldgenlevel, random, blockpos, biconsumer, biconsumer1, treeconfiguration);
		if (flag && (!set.isEmpty() || !set1.isEmpty())) {
			if (!treeconfiguration.decorators.isEmpty()) {
				List<BlockPos> list = Lists.newArrayList(set);
				List<BlockPos> list1 = Lists.newArrayList(set1);
				list.sort(Comparator.comparingInt(Vec3i::getY));
				list1.sort(Comparator.comparingInt(Vec3i::getY));
				treeconfiguration.decorators.forEach((p_160528_) -> { p_160528_.place(worldgenlevel, biconsumer2, random, list, list1); });
			}

			return BoundingBox.encapsulatingPositions(Iterables.concat(set, set1, set2)).map((p_160521_) -> {
				DiscreteVoxelShape discretevoxelshape = updateLeaves(worldgenlevel, p_160521_, set, set2);
				StructureTemplate.updateShapeAtEdge(worldgenlevel, 3, discretevoxelshape, p_160521_.minX(), p_160521_.minY(), p_160521_.minZ());
				return true;
			}).orElse(false);
		} else {
			return false;
		}
	}

	private static DiscreteVoxelShape updateLeaves(LevelAccessor worldIn, BoundingBox bbIn, Set<BlockPos> p_236403_3_, Set<BlockPos> p_236403_4_) {
		List<Set<BlockPos>> list = Lists.newArrayList();
		DiscreteVoxelShape discretevoxelshape = new BitSetDiscreteVoxelShape(bbIn.getXSpan(), bbIn.getYSpan(), bbIn.getZSpan());
		int amt = 6;

		for (int j = 0; j < amt; ++j) {
			list.add(Sets.newHashSet());
		}

		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (BlockPos blockpos : Lists.newArrayList(p_236403_4_)) {
			if (bbIn.isInside(blockpos)) {
				discretevoxelshape.fill(blockpos.getX() - bbIn.minX(), blockpos.getY() - bbIn.minY(), blockpos.getZ() - bbIn.minZ());
			}
		}

		for (BlockPos blockpos1 : Lists.newArrayList(p_236403_3_)) {
			if (bbIn.isInside(blockpos1)) {
				discretevoxelshape.fill(blockpos1.getX() - bbIn.minX(), blockpos1.getY() - bbIn.minY(), blockpos1.getZ() - bbIn.minZ());
			}

			for (Direction direction : Direction.values()) {
				blockpos$mutable.setWithOffset(blockpos1, direction);
				if (!p_236403_3_.contains(blockpos$mutable)) {
					BlockState blockstate = worldIn.getBlockState(blockpos$mutable);
					if (blockstate.hasProperty(BlockStateProperties.DISTANCE)) {
						list.get(0).add(blockpos$mutable.immutable());
						setBlockKnownShape(worldIn, blockpos$mutable, blockstate.setValue(BlockStateProperties.DISTANCE, Integer.valueOf(1)));
						if (bbIn.isInside(blockpos$mutable)) {
							discretevoxelshape.fill(blockpos$mutable.getX() - bbIn.minX(), blockpos$mutable.getY() - bbIn.minY(), blockpos$mutable.getZ() - bbIn.minZ());
						}
					}
				}
			}
		}

		for (int l = 1; l < amt; ++l) {
			Set<BlockPos> set = list.get(l - 1);
			Set<BlockPos> set1 = list.get(l);

			for (BlockPos blockpos2 : set) {
				if (bbIn.isInside(blockpos2)) {
					discretevoxelshape.fill(blockpos2.getX() - bbIn.minX(), blockpos2.getY() - bbIn.minY(), blockpos2.getZ() - bbIn.minZ());
				}

				for (Direction direction1 : Direction.values()) {
					blockpos$mutable.setWithOffset(blockpos2, direction1);
					if (!set.contains(blockpos$mutable) && !set1.contains(blockpos$mutable)) {
						BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
						if (blockstate1.hasProperty(BlockStateProperties.DISTANCE)) {
							int k = blockstate1.getValue(BlockStateProperties.DISTANCE);
							if (k > l + 1) {
								BlockState blockstate2 = blockstate1.setValue(BlockStateProperties.DISTANCE, Integer.valueOf(l + 1));
								setBlockKnownShape(worldIn, blockpos$mutable, blockstate2);
								if (bbIn.isInside(blockpos$mutable)) {
									discretevoxelshape.fill(blockpos$mutable.getX() - bbIn.minX(), blockpos$mutable.getY() - bbIn.minY(), blockpos$mutable.getZ() - bbIn.minZ());
								}

								set1.add(blockpos$mutable.immutable());
							}
						}
					}
				}
			}
		}

		return discretevoxelshape;
	}

}
