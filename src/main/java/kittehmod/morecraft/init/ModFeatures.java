package kittehmod.morecraft.init;

import com.google.common.collect.ImmutableList;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.worldgen.NetherwoodTreeFeature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreCraft.MODID);

	protected static ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST;

	protected static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_SMALL;
	protected static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_LARGE;
	protected static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_BURIED;
	
	protected static RegistryObject<Feature<TreeConfiguration>> NETHERWOOD_TREE = FEATURES.register("netherwood_tree", () -> new NetherwoodTreeFeature(TreeConfiguration.CODEC, true));
	
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> NETHERWOOD_TREE_STRAIGHT;
	public static Holder<ConfiguredFeature<TreeConfiguration, ?>> NETHERWOOD_TREE_FORKY;
	public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_NETHERWOOD;
	
	public static void setupFeatureConfigs() {
		ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
		ORE_RUBY_SMALL = FeatureUtils.register("morecraft:ore_ruby_small", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 4, 0.3F));
		ORE_RUBY_LARGE = FeatureUtils.register("morecraft:ore_ruby_large", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 12, 0.5F));
		ORE_RUBY_BURIED = FeatureUtils.register("morecraft:ore_ruby_buried", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 8, 1.0F));

		NETHERWOOD_TREE_STRAIGHT = FeatureUtils.register("morecraft:netherwood_straight", ModFeatures.NETHERWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.NETHERWOOD_LOG.get()), new StraightTrunkPlacer(4, 2, 2), BlockStateProvider.simple(ModBlocks.NETHERWOOD_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
		NETHERWOOD_TREE_FORKY = FeatureUtils.register("morecraft:netherwood_forky", ModFeatures.NETHERWOOD_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.NETHERWOOD_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.NETHERWOOD_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
	}

}
