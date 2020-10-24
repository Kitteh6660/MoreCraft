package kittehmod.morecraft.worldgen;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;

import kittehmod.morecraft.block.NetherwoodSaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;

public class NetherwoodTreeFeature extends Feature<BaseTreeFeatureConfig>
{
	//private boolean attemptNetherGen;

	public NetherwoodTreeFeature(Codec<BaseTreeFeatureConfig> codecIn, boolean netherGenAttempt) {
		super(codecIn);
		//this.attemptNetherGen = netherGenAttempt;
	}

	public static boolean func_236410_c_(IWorldGenerationBaseReader p_236410_0_, BlockPos p_236410_1_) {
		return canReplaceBlock(p_236410_0_, p_236410_1_) || p_236410_0_.hasBlockState(p_236410_1_, (p_236417_0_) -> { return p_236417_0_.func_235714_a_(BlockTags.LOGS); });
	}

	private static boolean func_236414_e_(IWorldGenerationBaseReader p_236414_0_, BlockPos p_236414_1_) {
		return p_236414_0_.hasBlockState(p_236414_1_, (p_236415_0_) -> { return p_236415_0_.isIn(Blocks.VINE); });
	}

	private static boolean isFluid(IWorldGenerationBaseReader p_236416_0_, BlockPos p_236416_1_) {
		return p_236416_0_.hasBlockState(p_236416_1_, (p_236413_0_) -> { return p_236413_0_.isIn(Blocks.WATER); });
	}

	@SuppressWarnings("deprecation")
	public static boolean isNonSolidBlock(IWorldGenerationBaseReader p_236412_0_, BlockPos p_236412_1_) {
		return p_236412_0_.hasBlockState(p_236412_1_, (p_236411_0_) -> { return p_236411_0_.isAir() || p_236411_0_.func_235714_a_(BlockTags.LEAVES); });
	}

	private static boolean func_236418_g_(IWorldGenerationBaseReader p_236418_0_, BlockPos p_236418_1_) {
		return p_236418_0_.hasBlockState(p_236418_1_, (p_236409_0_) -> {
			Block block = p_236409_0_.getBlock();
			return NetherwoodSaplingBlock.ALLOWED_BLOCKS.contains(block);
		});
	}

	private static boolean isTallPlant(IWorldGenerationBaseReader p_236419_0_, BlockPos p_236419_1_) {
		return p_236419_0_.hasBlockState(p_236419_1_, (p_236406_0_) -> {
			Material material = p_236406_0_.getMaterial();
			return material == Material.TALL_PLANTS;
		});
	}

	public static void setBlockStateAt(IWorldWriter worldIn, BlockPos posIn, BlockState stateIn) {
		worldIn.setBlockState(posIn, stateIn, 19);
	}

	public static boolean canReplaceBlock(IWorldGenerationBaseReader generationReader, BlockPos posIn) {
		return isNonSolidBlock(generationReader, posIn) || isTallPlant(generationReader, posIn) || isFluid(generationReader, posIn);
	}

	/**
	 * Called when placing the tree feature.
	 */
	private boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, BaseTreeFeatureConfig configIn) {
		int i = configIn.field_236678_g_.func_236917_a_(rand);
		int j = configIn.field_236677_f_.func_230374_a_(rand, i, configIn);
		int k = i - j;
		int l = configIn.field_236677_f_.func_230376_a_(rand, k);
		BlockPos blockpos = positionIn;
		BlockState blockstate = null;
		BlockState origstate = null;
		if (!configIn.forcePlacement) {
			//Reduce the frequency of Netherwood trees.
			//15% frequency for Crimson & Warped Forests. Made complicated by the presence of corresponding fungus.
			if (generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.field_235372_ml_ || block.getBlock() == Blocks.field_235381_mu_)) {
				if (rand.nextInt(100) > 30) {
					return false;
				}
				else {
					origstate = generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.field_235372_ml_) ? Blocks.field_235372_ml_.getDefaultState() : Blocks.field_235381_mu_.getDefaultState();
					generationReader.setBlockState(blockpos.down(), Blocks.field_235336_cN_.getDefaultState(), 19);
				}
				
			}
			//10% frequency for Soul Valley.
			if (generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.SOUL_SAND || block.getBlock() == Blocks.field_235336_cN_)) {
				if (rand.nextInt(100) > 10) {
					return false;
				}
				else {
					origstate = generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.SOUL_SAND) ? Blocks.SOUL_SAND.getDefaultState() : Blocks.field_235336_cN_.getDefaultState();
				}
			}
			//10% frequency for generic Netherrack biomes.
			if (generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.NETHERRACK)) {
				if (rand.nextInt(100) > 10) {
					return false;
				}
				else {
					origstate = Blocks.NETHERRACK.getDefaultState();
					generationReader.setBlockState(blockpos.down(), Blocks.SOUL_SAND.getDefaultState(), 19);
				}
			}
			//Leftover code from regular trees.
			/*int i1 = generationReader.getHeight(Heightmap.Type.OCEAN_FLOOR, positionIn).getY();
			int j1 = generationReader.getHeight(Heightmap.Type.WORLD_SURFACE, positionIn).getY();
			if (j1 - i1 > configIn.field_236680_i_) {
				return false;
			}

			int k1;
			if (configIn.field_236682_l_ == Heightmap.Type.OCEAN_FLOOR) {
				k1 = i1;
			} else if (configIn.field_236682_l_ == Heightmap.Type.WORLD_SURFACE) {
				k1 = j1;
			} else {
				k1 = generationReader.getHeight(configIn.field_236682_l_, positionIn).getY();
			}

			blockpos = new BlockPos(positionIn.getX(), k1, positionIn.getZ());*/
		} else {
			blockpos = positionIn;
		}
		//Hacky workaround to stop the blocks from being changed to dirt.
		if (generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.SOUL_SAND)) {
			blockstate = Blocks.SOUL_SAND.getDefaultState();
		}
		if (generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.field_235336_cN_ || block.getBlock() == Blocks.field_235372_ml_ || block.getBlock() == Blocks.field_235381_mu_)) {
			blockstate = Blocks.field_235336_cN_.getDefaultState();
		}
		if (blockpos.getY() >= 1 && blockpos.getY() + i + 1 <= 256) {
			if (!func_236418_g_(generationReader, blockpos.down())) {
				return false;
			} else {
				OptionalInt optionalint = configIn.field_236679_h_.func_236710_c_();
				int l1 = this.func_241521_a_(generationReader, i, blockpos, configIn);
				if (l1 >= i || optionalint.isPresent() && l1 >= optionalint.getAsInt()) {
					List<FoliagePlacer.Foliage> list = configIn.field_236678_g_.func_230382_a_(generationReader, rand, l1, blockpos, p_225557_4_, boundingBoxIn, configIn);
					list.forEach((p_236407_8_) -> { configIn.field_236677_f_.func_236752_a_(generationReader, rand, configIn, l1, p_236407_8_, j, l, p_225557_5_, boundingBoxIn); });
					if (blockstate != null) {
						generationReader.setBlockState(blockpos.down(), blockstate, 19);
					}
					return true;
				} else {
					generationReader.setBlockState(blockpos.down(), origstate, 19); //Revert the block.
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private int func_241521_a_(IWorldGenerationBaseReader p_241521_1_, int p_241521_2_, BlockPos p_241521_3_, BaseTreeFeatureConfig p_241521_4_) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int i = 0; i <= p_241521_2_ + 1; ++i) {
			int j = p_241521_4_.field_236679_h_.func_230369_a_(p_241521_2_, i);

			for (int k = -j; k <= j; ++k) {
				for (int l = -j; l <= j; ++l) {
					blockpos$mutable.func_239621_a_(p_241521_3_, k, i, l);
					if (!func_236410_c_(p_241521_1_, blockpos$mutable) || !p_241521_4_.field_236681_j_ && func_236414_e_(p_241521_1_, blockpos$mutable)) {
						return i - 2;
					}
				}
			}
		}

		return p_241521_2_;
	}

	public final boolean func_241855_a(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos p_241855_4_, BaseTreeFeatureConfig p_241855_5_) {
		Set<BlockPos> set = Sets.newHashSet();
		Set<BlockPos> set1 = Sets.newHashSet();
		Set<BlockPos> set2 = Sets.newHashSet();
		MutableBoundingBox mutableboundingbox = MutableBoundingBox.getNewBoundingBox();
		boolean flag = this.place(p_241855_1_, p_241855_3_, p_241855_4_, set, set1, mutableboundingbox, p_241855_5_);
		if (mutableboundingbox.minX <= mutableboundingbox.maxX && flag && !set.isEmpty()) {
			if (!p_241855_5_.decorators.isEmpty()) {
				List<BlockPos> list = Lists.newArrayList(set);
				List<BlockPos> list1 = Lists.newArrayList(set1);
				list.sort(Comparator.comparingInt(Vector3i::getY));
				list1.sort(Comparator.comparingInt(Vector3i::getY));
				p_241855_5_.decorators.forEach((p_236405_6_) -> { p_236405_6_.func_225576_a_(p_241855_1_, p_241855_3_, list, list1, set2, mutableboundingbox); });
			}

			VoxelShapePart voxelshapepart = this.func_236403_a_(p_241855_1_, mutableboundingbox, set, set2);
			Template.func_222857_a(p_241855_1_, 3, voxelshapepart, mutableboundingbox.minX, mutableboundingbox.minY, mutableboundingbox.minZ);
			return true;
		} else {
			return false;
		}
	}

	private VoxelShapePart func_236403_a_(IWorld worldIn, MutableBoundingBox bbIn, Set<BlockPos> p_236403_3_, Set<BlockPos> p_236403_4_) {
		List<Set<BlockPos>> list = Lists.newArrayList();
		VoxelShapePart voxelshapepart = new BitSetVoxelShapePart(bbIn.getXSize(), bbIn.getYSize(), bbIn.getZSize());
		int amt = 6;

		for (int j = 0; j < amt; ++j) {
			list.add(Sets.newHashSet());
		}

		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (BlockPos blockpos : Lists.newArrayList(p_236403_4_)) {
			if (bbIn.isVecInside(blockpos)) {
				voxelshapepart.setFilled(blockpos.getX() - bbIn.minX, blockpos.getY() - bbIn.minY, blockpos.getZ() - bbIn.minZ, true, true);
			}
		}

		for (BlockPos blockpos1 : Lists.newArrayList(p_236403_3_)) {
			if (bbIn.isVecInside(blockpos1)) {
				voxelshapepart.setFilled(blockpos1.getX() - bbIn.minX, blockpos1.getY() - bbIn.minY, blockpos1.getZ() - bbIn.minZ, true, true);
			}

			for (Direction direction : Direction.values()) {
				blockpos$mutable.func_239622_a_(blockpos1, direction);
				if (!p_236403_3_.contains(blockpos$mutable)) {
					BlockState blockstate = worldIn.getBlockState(blockpos$mutable);
					if (blockstate.func_235901_b_(BlockStateProperties.DISTANCE_1_7)) {
						list.get(0).add(blockpos$mutable.toImmutable());
						setBlockStateAt(worldIn, blockpos$mutable, blockstate.with(BlockStateProperties.DISTANCE_1_7, Integer.valueOf(1)));
						if (bbIn.isVecInside(blockpos$mutable)) {
							voxelshapepart.setFilled(blockpos$mutable.getX() - bbIn.minX, blockpos$mutable.getY() - bbIn.minY, blockpos$mutable.getZ() - bbIn.minZ, true, true);
						}
					}
				}
			}
		}

		for (int l = 1; l < amt; ++l) {
			Set<BlockPos> set = list.get(l - 1);
			Set<BlockPos> set1 = list.get(l);

			for (BlockPos blockpos2 : set) {
				if (bbIn.isVecInside(blockpos2)) {
					voxelshapepart.setFilled(blockpos2.getX() - bbIn.minX, blockpos2.getY() - bbIn.minY, blockpos2.getZ() - bbIn.minZ, true, true);
				}

				for (Direction direction1 : Direction.values()) {
					blockpos$mutable.func_239622_a_(blockpos2, direction1);
					if (!set.contains(blockpos$mutable) && !set1.contains(blockpos$mutable)) {
						BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
						if (blockstate1.func_235901_b_(BlockStateProperties.DISTANCE_1_7)) {
							int k = blockstate1.get(BlockStateProperties.DISTANCE_1_7);
							if (k > l + 1) {
								BlockState blockstate2 = blockstate1.with(BlockStateProperties.DISTANCE_1_7, Integer.valueOf(l + 1));
								setBlockStateAt(worldIn, blockpos$mutable, blockstate2);
								if (bbIn.isVecInside(blockpos$mutable)) {
									voxelshapepart.setFilled(blockpos$mutable.getX() - bbIn.minX, blockpos$mutable.getY() - bbIn.minY, blockpos$mutable.getZ() - bbIn.minZ, true, true);
								}

								set1.add(blockpos$mutable.toImmutable());
							}
						}
					}
				}
			}
		}

		return voxelshapepart;
	}
}
