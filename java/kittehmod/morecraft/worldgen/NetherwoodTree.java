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
	public boolean func_230339_a_(ServerWorld worldIn, ChunkGenerator generatorIn, BlockPos blockPosIn, BlockState blockStateIn, Random randomIn) {
		ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredfeature = this.getTreeFeature(randomIn, this.func_230140_a_(worldIn, blockPosIn));
		if (configuredfeature == null) {
			return false;
		} else {
			worldIn.setBlockState(blockPosIn, Blocks.AIR.getDefaultState(), 4);
			//configuredfeature.config.
			configuredfeature.config.forcePlacement();
			if (configuredfeature.func_242765_a(worldIn, generatorIn, randomIn, blockPosIn)) {
				return true;
			} else {
				worldIn.setBlockState(blockPosIn, blockStateIn, 4);
				return false;
			}
		}
	}

	private boolean func_230140_a_(IWorld p_230140_1_, BlockPos p_230140_2_) {
		for (BlockPos blockpos : BlockPos.Mutable.getAllInBoxMutable(p_230140_2_.down().north(2).west(2), p_230140_2_.up().south(2).east(2))) {
			if (p_230140_1_.getBlockState(blockpos).func_235714_a_(BlockTags.FLOWERS)) {
				return true;
			}
		}
		return false;
	}
}
