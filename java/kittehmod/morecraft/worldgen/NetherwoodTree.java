package kittehmod.morecraft.worldgen;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;


public class NetherwoodTree extends Tree {
	@Nullable
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
		return new NetherwoodTreeFeature(NoFeatureConfig::deserialize, true, false);
	}
}
