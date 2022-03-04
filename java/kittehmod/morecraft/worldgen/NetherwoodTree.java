package kittehmod.morecraft.worldgen;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class NetherwoodTree extends AbstractTreeGrower {
	@Nullable
	protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(Random randomIn, boolean p_225546_2_) {
		if (randomIn.nextInt(100) < 30) { // 30% chance of forky.
			return ModFeatures.NETHERWOOD_TREE_FORKY;
		} else {
			return ModFeatures.NETHERWOOD_TREE_STRAIGHT;
		}
	}

	@Override
	public boolean growTree(ServerLevel worldIn, ChunkGenerator generatorIn, BlockPos blockPosIn, BlockState blockStateIn, Random randomIn) {
		Holder<? extends ConfiguredFeature<TreeConfiguration, ?>> holder = this.getConfiguredFeature(randomIn, this.hasFlowers(worldIn, blockPosIn));
		if (holder == null) {
			return false;
		} else {
			ConfiguredFeature<?, ?> configuredfeature = holder.value();
			if (configuredfeature.place(worldIn, generatorIn, randomIn, blockPosIn)) {
				return true;
			} else {
				worldIn.setBlock(blockPosIn, blockStateIn, 4);
				return false;
			}
		}
	}
	
	private boolean hasFlowers(LevelReader worldIn, BlockPos blockPosIn) {
		for(BlockPos blockpos : BlockPos.MutableBlockPos.betweenClosed(blockPosIn.below().north(2).west(2), blockPosIn.above().south(2).east(2))) {
			if (worldIn.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
				return true;
			}
		}
		return false;
	}
}
