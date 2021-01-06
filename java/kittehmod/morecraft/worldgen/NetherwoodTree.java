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
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		if (randomIn.nextInt(100) < 30) { // 30% chance of forky.
			return ModFeatures.NETHERWOOD_TREE.get().withConfiguration(ModFeatures.NETHERWOOD_TREE_FORKY_CONFIG);
		} else {
			return ModFeatures.NETHERWOOD_TREE.get().withConfiguration(ModFeatures.NETHERWOOD_TREE_STRAIGHT_CONFIG);
		}
	}

	@Override
	public boolean attemptGrowTree(ServerWorld worldIn, ChunkGenerator generatorIn, BlockPos blockPosIn, BlockState blockStateIn, Random randomIn) {
		ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature(randomIn, this.hasNearbyFlora(worldIn, blockPosIn));
		if (configuredfeature == null) {
			return false;
		} else {
			worldIn.setBlockState(blockPosIn, Blocks.AIR.getDefaultState(), 4);
			configuredfeature.config.forcePlacement();
			if (configuredfeature.generate(worldIn, generatorIn, randomIn, blockPosIn)) {
				return true;
			} else {
				worldIn.setBlockState(blockPosIn, blockStateIn, 4);
				return false;
			}
		}
	}

	private boolean hasNearbyFlora(IWorld worldIn, BlockPos blockPosIn) {
		for (BlockPos blockpos : BlockPos.Mutable.getAllInBoxMutable(blockPosIn.down().north(2).west(2), blockPosIn.up().south(2).east(2))) {
			if (worldIn.getBlockState(blockpos).isIn(BlockTags.FLOWERS)) {
				return true;
			}
		}
		return false;
	}
}
