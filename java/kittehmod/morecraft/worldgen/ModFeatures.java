package kittehmod.morecraft.worldgen;

import com.google.common.collect.ImmutableList;
import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreCraft.MODID);

	public static RegistryObject<Feature<BaseTreeFeatureConfig>> NETHERWOOD_TREE = FEATURES.register("netherwood_tree", () -> new NetherwoodTreeFeature(BaseTreeFeatureConfig.field_236676_a_, true));;
	
	protected static BaseTreeFeatureConfig NETHERWOOD_TREE_STRAIGHT_CONFIG;
	protected static BaseTreeFeatureConfig NETHERWOOD_TREE_FORKY_CONFIG;
	
	public static void setupFeatureConfigs() {
		NETHERWOOD_TREE_STRAIGHT_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 3, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().func_236703_a_(ImmutableList.of()).build();
		NETHERWOOD_TREE_FORKY_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 1))).func_236700_a_().func_236703_a_(ImmutableList.of()).build();
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
	
	@SubscribeEvent
    public void biomeLoadEvent(BiomeLoadingEvent event) {
    	BiomeGenerationSettingsBuilder bgsb = event.getGeneration();
    	bgsb.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.RUBY_ORE.get().getDefaultState(), 8)).func_242733_d(32).func_242728_a().func_242731_b(2));
    	if (event.getCategory() == Biome.Category.NETHER) {
	    	bgsb.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().withConfiguration(ModFeatures.NETHERWOOD_TREE_STRAIGHT_CONFIG).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig((int)Math.ceil(MoreCraftConfig.generateNetherwoodTrees.get() * 0.7)))));
	    	bgsb.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().withConfiguration(ModFeatures.NETHERWOOD_TREE_FORKY_CONFIG).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig((int)Math.floor(MoreCraftConfig.generateNetherwoodTrees.get() * 0.3)))));
    	}
    }
}
