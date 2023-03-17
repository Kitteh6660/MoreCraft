package kittehmod.morecraft.init;

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
	protected static Holder<PlacedFeature> NETHERWOOD_STRAIGHT_LOW;
	protected static Holder<PlacedFeature> NETHERWOOD_FORKY_LOW;
	protected static Holder<PlacedFeature> NETHERWOOD_STRAIGHT_HIGH;
	protected static Holder<PlacedFeature> NETHERWOOD_FORKY_HIGH;

	public static void setupPlacements() {
		NETHERWOOD_STRAIGHT_LOW = PlacementUtils.register("morecraft:netherwood_straight_low", ModFeatures.NETHERWOOD_TREE_STRAIGHT, PlacementUtils.countExtra(1, 0.2F, 1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
		NETHERWOOD_FORKY_LOW = PlacementUtils.register("morecraft:netherwood_forky_low", ModFeatures.NETHERWOOD_TREE_FORKY, PlacementUtils.countExtra(0, 0.2F, 1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

		NETHERWOOD_STRAIGHT_HIGH = PlacementUtils.register("morecraft:netherwood_straight_high", ModFeatures.NETHERWOOD_TREE_STRAIGHT, PlacementUtils.countExtra(4, 0.5F, 1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
		NETHERWOOD_FORKY_HIGH = PlacementUtils.register("morecraft:netherwood_forky_high", ModFeatures.NETHERWOOD_TREE_FORKY, PlacementUtils.countExtra(4, 0.5F, 1), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
		
		NETHERWOOD_STRAIGHT_CHECKED = PlacementUtils.register("morecraft:netherwood_straight_checked", ModFeatures.NETHERWOOD_TREE_STRAIGHT, CountOnEveryLayerPlacement.of((int)Math.floor(MoreCraftConfig.generateNetherwoodTrees.get() * 0.7)));
		NETHERWOOD_FORKY_CHECKED = PlacementUtils.register("morecraft:netherwood_forky_checked", ModFeatures.NETHERWOOD_TREE_FORKY, CountOnEveryLayerPlacement.of((int)Math.ceil(MoreCraftConfig.generateNetherwoodTrees.get() * 0.3)));
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier plMod, PlacementModifier plMod2) {
		return List.of(plMod, InSquarePlacement.spread(), plMod2, BiomeFilter.biome());
	}
	
	private static List<PlacementModifier> commonOrePlacement(int amt, PlacementModifier plMod) {
		return orePlacement(CountPlacement.of(amt), plMod);
	}

	private static List<PlacementModifier> rareOrePlacement(int amt, PlacementModifier plMod) {
		return orePlacement(RarityFilter.onAverageOnceEvery(amt), plMod);
	}
}
