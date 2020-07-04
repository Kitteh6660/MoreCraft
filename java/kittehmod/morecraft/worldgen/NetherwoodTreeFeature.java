package kittehmod.morecraft.worldgen;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import kittehmod.morecraft.block.NetherwoodSaplingBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class NetherwoodTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	private boolean attemptNetherGen;
	
	public NetherwoodTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225820_1_, boolean netherGenAttempt) {
		super(p_i225820_1_);
		this.attemptNetherGen = netherGenAttempt;
	}

   /**
    * Called when placing the tree feature.
    */
	public boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
		BlockPos blockpos = positionIn;
		if (attemptNetherGen) {
			boolean flag = false;
			int p;
			for (p = 0; p < 10; p++) { //Move down one block at a time to find eligible Netherrack.
				if (generationReader.hasBlockState(positionIn.down(p), (block) -> block.getBlock() == Blocks.NETHERRACK || block.getBlock() == Blocks.SOUL_SAND) && generationReader.hasBlockState(positionIn.down(p-1), (block) -> block.getBlock() == Blocks.AIR)) {
					generationReader.setBlockState(positionIn.down(p), Blocks.SOUL_SAND.getDefaultState(), 11);
					blockpos = positionIn.down(p-1);
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (p = 0; p < 10; p++) { //Move up one block at a time to find eligible Netherrack, checks for air.
					if (generationReader.hasBlockState(positionIn.up(p), (block) -> block.getBlock() == Blocks.NETHERRACK || block.getBlock() == Blocks.SOUL_SAND) && generationReader.hasBlockState(positionIn.up(p+1), (block) -> block.getBlock() == Blocks.AIR)) {
						generationReader.setBlockState(positionIn.up(p), Blocks.SOUL_SAND.getDefaultState(), 11);
						blockpos = positionIn.up(p+1);
						flag = true;
						break;
					}
				}
			}
		}
		int i = configIn.baseHeight + rand.nextInt(configIn.heightRandA + 1) + rand.nextInt(configIn.heightRandB + 1);
		int j = configIn.trunkHeight >= 0 ? configIn.trunkHeight + rand.nextInt(configIn.trunkHeightRandom + 1) : i - (configIn.foliageHeight + rand.nextInt(configIn.foliageHeightRandom + 1));
		int k = configIn.foliagePlacer.func_225573_a_(rand, j, i, configIn);
		Optional<BlockPos> optional = this.func_227212_a_(generationReader, i, j, k, blockpos, configIn);
		if (optional.isPresent() || attemptNetherGen) {
			blockpos = optional.isPresent() ? optional.get() : blockpos;
			if (!generationReader.hasBlockState(blockpos.down(), (block) -> block.getBlock() == Blocks.NETHERRACK || block.getBlock() == Blocks.SOUL_SAND)) {
				this.setDirtAt(generationReader, blockpos.down(), blockpos);
			}
			if (!generationReader.hasBlockState(blockpos.down(), (block) -> NetherwoodSaplingBlock.ALLOWED_BLOCKS.contains(block.getBlock()))) {
				return false; //Not the right block, cancel.
			}
			for (int m = 0; m < i + 1; m++) {
				if (generationReader.hasBlockState(blockpos.up(m), (block) -> block.getBlock() != Blocks.AIR)) {
					return false;
				}
				
			}
			configIn.foliagePlacer.func_225571_a_(generationReader, rand, configIn, i, j, k, blockpos, p_225557_5_);
			this.func_227213_a_(generationReader, rand, i, blockpos, configIn.trunkTopOffset + rand.nextInt(configIn.trunkTopOffsetRandom + 1), p_225557_4_, boundingBoxIn, configIn);
			return true;
		} else {
			return false;
		}
	}
}
