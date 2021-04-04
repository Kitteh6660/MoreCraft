package kittehmod.morecraft.worldgen;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

public class NetherwoodTree extends Tree {
	@Nullable
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean p_225546_2_) {
		if (randomIn.nextInt(100) < 30) { // 30% chance of forky.
			return ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_FORKY_CONFIG);
		} else {
			return ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_STRAIGHT_CONFIG);
		}
	}

	@Override
	public boolean growTree(ServerWorld worldIn, ChunkGenerator generatorIn, BlockPos blockPosIn, BlockState blockStateIn, Random randomIn) {
		ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getConfiguredFeature(randomIn, this.hasFlowers(worldIn, blockPosIn));
		if (configuredfeature == null) {
			return false;
		} else {
			worldIn.setBlock(blockPosIn, Blocks.AIR.defaultBlockState(), 4);
			configuredfeature.config.setFromSapling();
			if (configuredfeature.place(worldIn, generatorIn, randomIn, blockPosIn)) {
				return true;
			} else {
				worldIn.setBlock(blockPosIn, blockStateIn, 4);
				return false;
			}
		}
	}
	
	private boolean hasFlowers(IWorld worldIn, BlockPos blockPosIn) {
		for(BlockPos blockpos : BlockPos.Mutable.betweenClosed(blockPosIn.below().north(2).west(2), blockPosIn.above().south(2).east(2))) {
			if (worldIn.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
				return true;
			}
		}
		return false;
	}
}
