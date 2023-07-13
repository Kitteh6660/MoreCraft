package kittehmod.morecraft.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class NetherwoodTreeGrower extends AbstractTreeGrower {

	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomIn, boolean p_225546_2_) {
		if (randomIn.nextInt(100) < 30) { // 30% chance of forky.
			return ModFeatures.NETHERWOOD_TREE_FORKY;
		} else {
			return ModFeatures.NETHERWOOD_TREE_STRAIGHT;
		}
	}

	@Override
	public boolean growTree(ServerLevel worldIn, ChunkGenerator generatorIn, BlockPos blockPosIn, BlockState blockStateIn, RandomSource randomIn) {
		ResourceKey<ConfiguredFeature<?, ?>> resourcekey = this.getConfiguredFeature(randomIn, this.hasFlowers(worldIn, blockPosIn));
		if (resourcekey == null) {
			return false;
		} else {
			Holder<ConfiguredFeature<?, ?>> holder = worldIn.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(resourcekey).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
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
		for(BlockPos blockpos : BlockPos.betweenClosed(blockPosIn.below().north(2).west(2), blockPosIn.above().south(2).east(2))) {
			if (worldIn.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
				return true;
			}
		}
		return false;
	}
}
