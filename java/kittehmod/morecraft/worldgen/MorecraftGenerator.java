package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class MorecraftGenerator {

	public static ResourceLocation[] MOD_NETHER_BIOME_KEYS = {new ResourceLocation("biomesoplenty:undergarden"), new ResourceLocation("biomesoplenty:ashen_inferno"), new ResourceLocation("netherex:ruthless_sands")};
	
    public static void setupGeneration() {
		SetupOverworldGeneration();
		SetupNetherGeneration();
    }
	
	public static void SetupOverworldGeneration() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 1, 4, 64)));
		}
	}
	
	public static void SetupNetherGeneration() {
		Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(ModFeatures.NETHERWOOD_TREE.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(MoreCraftConfig.generateNetherwoodTrees.get(), 0, 6, 224)));
		for (ResourceLocation loc : MOD_NETHER_BIOME_KEYS) {
			if (ForgeRegistries.BIOMES.containsKey(loc)) {
				Biome biome = ForgeRegistries.BIOMES.getValue(loc);
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(ModFeatures.NETHERWOOD_TREE.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(MoreCraftConfig.generateNetherwoodTrees.get(), 0, 6, 224)));
				//MOD_NETHER_BIOMES[MOD_NETHER_BIOMES.length] = ForgeRegistries.BIOMES.getValue(loc);
			}
		}
	}
	
}
