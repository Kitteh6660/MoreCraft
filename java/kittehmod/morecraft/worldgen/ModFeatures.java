package kittehmod.morecraft.worldgen;

import com.google.common.collect.ImmutableList;
import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreCraft.MODID);

	protected static ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST;

	//public static RegistryObject<Feature<?>> ORE_RUBY = FEATURES.register("ore_ruby", () -> Feature.ORE.configured(new OreConfiguration(ORE_RUBY_TARGET_LIST, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(63)).squared().count(20));
	public static RegistryObject<Feature<TreeConfiguration>> NETHERWOOD_TREE = FEATURES.register("netherwood_tree", () -> new NetherwoodTreeFeature(TreeConfiguration.CODEC, true));
	
	protected static TreeConfiguration NETHERWOOD_TREE_STRAIGHT_CONFIG;
	protected static TreeConfiguration NETHERWOOD_TREE_FORKY_CONFIG;
	
	public static void setupFeatureConfigs() {
		ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
		NETHERWOOD_TREE_STRAIGHT_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(ModBlocks.NETHERWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 3, 0), new SimpleStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().defaultBlockState()), new SimpleStateProvider(ModBlocks.NETHERWOOD_SAPLING.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().decorators(ImmutableList.of()).build();
		NETHERWOOD_TREE_FORKY_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(ModBlocks.NETHERWOOD_LOG.get().defaultBlockState()), new ForkingTrunkPlacer(5, 2, 2), new SimpleStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().defaultBlockState()), new SimpleStateProvider(ModBlocks.NETHERWOOD_SAPLING.get().defaultBlockState()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().decorators(ImmutableList.of()).build();
	}
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(MoreCraft.MODID, name));
		}

		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
		
	    @SubscribeEvent
	    public static void registerFeature(final RegistryEvent.Register<Feature<?>> event) { 
	    	event.getRegistry().registerAll();
	    }
	}
	
}
