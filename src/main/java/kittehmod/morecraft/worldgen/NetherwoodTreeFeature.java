package kittehmod.morecraft.worldgen;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;

import kittehmod.morecraft.block.ModBlockTags;
import kittehmod.morecraft.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

public class NetherwoodTreeFeature extends Feature<TreeConfiguration>
{

	public NetherwoodTreeFeature(Codec<TreeConfiguration> codecIn, boolean netherGenAttempt) {
		super(codecIn);
	}

	public static boolean isFree(LevelSimulatedReader reader, BlockPos pos) {
		return validTreePos(reader, pos) || reader.isStateAtPosition(pos, (state) -> { return state.is(BlockTags.LOGS); });
	}

	private static boolean isVine(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (state) -> { return state.is(Blocks.VINE); });
	}

	private static boolean isBlockWater(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (state) -> { return state.is(Blocks.WATER); });
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (state) -> { return state.isAir() || state.is(BlockTags.LEAVES); });
	}

	private static boolean isGrassOrDirtOrFarmland(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (blockstate) -> {
			Block block = blockstate.getBlock();
			return blockstate.is(BlockTags.DIRT) || block == Blocks.FARMLAND || blockstate.is(ModBlockTags.NETHERWOOD_SAPLING_PLANTABLES);
		});
	}

	private static boolean isReplaceablePlant(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (state) -> {
			return state.is(BlockTags.REPLACEABLE);
		});
	}

	public static void setBlockKnownShape(LevelWriter writer, BlockPos pos, BlockState state) {
		writer.setBlock(pos, state, 19);
	}

	public static boolean validTreePos(LevelSimulatedReader reader, BlockPos pos) {
		return isAirOrLeaves(reader, pos) || isReplaceablePlant(reader, pos) || isBlockWater(reader, pos);
	}

	/**
	 * Called when placing the tree feature.
	 */
	private boolean doPlace(WorldGenLevel generationReader, RandomSource rand, BlockPos positionIn, BiConsumer<BlockPos, BlockState> biconsumer1, BiConsumer<BlockPos, BlockState> biconsumer2, FoliagePlacer.FoliageSetter foliagesetter, TreeConfiguration configIn) {
		int i = configIn.trunkPlacer.getTreeHeight(rand);
		int j = configIn.foliagePlacer.foliageHeight(rand, i, configIn);
		int k = i - j;
		int l = configIn.foliagePlacer.foliageRadius(rand, k);
		BlockPos blockpos = positionIn;
		BlockState blockstate = generationReader.getBlockState(blockpos.below());
		BlockState origstate = generationReader.getBlockState(blockpos.below());
		// Shift down potential tree generation to increase chance.
		if (origstate == Blocks.AIR.defaultBlockState()) {
			for (int offsetDown = 0; offsetDown < 16; offsetDown++) {
				if (generationReader.getBlockState(blockpos.below(offsetDown)) != Blocks.AIR.defaultBlockState()) {
					blockpos = blockpos.below(offsetDown - 1);
					blockstate = generationReader.getBlockState(blockpos.below());
					origstate = generationReader.getBlockState(blockpos.below());
					break;
				}
			}
		}
		// Cancel if it's still air.
		if (generationReader.getBlockState(blockpos.below()) == Blocks.AIR.defaultBlockState()) {
			return false;
		}
		// Proceed with the generation.
		if (blockpos.getY() >= 1 && blockpos.getY() + i + 1 <= generationReader.getMaxBuildHeight()) {
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
					List<FoliagePlacer.FoliageAttachment> list = configIn.trunkPlacer.placeTrunk(generationReader, biconsumer1, rand, i1, blockpos, configIn);
					list.forEach((p_160539_) -> { configIn.foliagePlacer.createFoliage(generationReader, foliagesetter, rand, configIn, i1, p_160539_, j, l); });
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
	
	private int getMaxFreeTreeHeight(LevelSimulatedReader p_241521_1_, int p_241521_2_, BlockPos p_241521_3_, TreeConfiguration p_241521_4_) {
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

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
		RandomSource randomsource = placeContxt.random();
		BlockPos blockpos = placeContxt.origin();
		TreeConfiguration treeconfiguration = placeContxt.config();
		Set<BlockPos> set = Sets.newHashSet();
		Set<BlockPos> set1 = Sets.newHashSet();
		Set<BlockPos> set2 = Sets.newHashSet();
		Set<BlockPos> set3 = Sets.newHashSet();
		BiConsumer<BlockPos, BlockState> biconsumer = (p_160555_, p_160556_) -> {
			set.add(p_160555_.immutable());
			worldgenlevel.setBlock(p_160555_, p_160556_, 19);
		};
		BiConsumer<BlockPos, BlockState> biconsumer1 = (p_160548_, p_160549_) -> {
			set1.add(p_160548_.immutable());
			worldgenlevel.setBlock(p_160548_, p_160549_, 19);
		};
		FoliagePlacer.FoliageSetter foliageplacer$foliagesetter = new FoliagePlacer.FoliageSetter() {
			public void set(BlockPos p_272825_, BlockState p_273311_) {
				set2.add(p_272825_.immutable());
				worldgenlevel.setBlock(p_272825_, p_273311_, 19);
			}

			public boolean isSet(BlockPos p_272999_) {
				return set2.contains(p_272999_);
			}
		};
		BiConsumer<BlockPos, BlockState> biconsumer2 = (p_225290_, p_225291_) -> {
			set3.add(p_225290_.immutable());
			worldgenlevel.setBlock(p_225290_, p_225291_, 19);
		};
		boolean flag = this.doPlace(worldgenlevel, randomsource, blockpos, biconsumer, biconsumer1, foliageplacer$foliagesetter, treeconfiguration);
		if (flag && (!set1.isEmpty() || !set2.isEmpty())) {
			if (!treeconfiguration.decorators.isEmpty()) {
				TreeDecorator.Context treedecorator$context = new TreeDecorator.Context(worldgenlevel, biconsumer2, randomsource, set1, set2, set);
				treeconfiguration.decorators.forEach((p_160528_) -> { p_160528_.place(treedecorator$context); });
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

		MutableBlockPos blockpos$mutable = new MutableBlockPos();

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
