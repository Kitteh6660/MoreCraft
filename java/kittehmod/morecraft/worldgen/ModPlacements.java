package kittehmod.morecraft.worldgen;

import java.util.List;

import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

@SuppressWarnings("deprecation")
public class ModPlacements {
	public static final Holder<PlacedFeature> ORE_RUBY = PlacementUtils.register("morecraft:ore_ruby", ModFeatures.ORE_RUBY_SMALL, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(8), VerticalAnchor.aboveBottom(96))));
	public static final Holder<PlacedFeature> ORE_RUBY_LARGE = PlacementUtils.register("morecraft:ore_ruby_large", ModFeatures.ORE_RUBY_LARGE, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(8), VerticalAnchor.aboveBottom(96))));
	public static final Holder<PlacedFeature> ORE_RUBY_BURIED = PlacementUtils.register("morecraft:ore_ruby_buried", ModFeatures.ORE_RUBY_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(80))));
	
	protected static Holder<PlacedFeature> NETHERWOOD_STRAIGHT_CHECKED;
	protected static Holder<PlacedFeature> NETHERWOOD_FORKY_CHECKED;
	protected static Holder<PlacedFeature> NETHERWOOD_FOREST;

	public static void setupPlacements() {
		NETHERWOOD_STRAIGHT_CHECKED = PlacementUtils.register("morecraft:netherwood_straight_checked", ModFeatures.NETHERWOOD_TREE_STRAIGHT, CountOnEveryLayerPlacement.of((int)Math.floor(MoreCraftConfig.generateNetherwoodTrees.get() * 0.7)));
		NETHERWOOD_FORKY_CHECKED = PlacementUtils.register("morecraft:netherwood_forky_checked", ModFeatures.NETHERWOOD_TREE_FORKY, CountOnEveryLayerPlacement.of((int)Math.ceil(MoreCraftConfig.generateNetherwoodTrees.get() * 0.3)));
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}
	
	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	}
}
