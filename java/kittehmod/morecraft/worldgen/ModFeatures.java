package kittehmod.morecraft.worldgen;

import com.google.common.collect.ImmutableList;
import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreCraft.MODID);

	public static RegistryObject<Feature<BaseTreeFeatureConfig>> NETHERWOOD_TREE = FEATURES.register("netherwood_tree", () -> new NetherwoodTreeFeature(BaseTreeFeatureConfig.CODEC, true));
	
	protected static BaseTreeFeatureConfig NETHERWOOD_TREE_STRAIGHT_CONFIG;
	protected static BaseTreeFeatureConfig NETHERWOOD_TREE_FORKY_CONFIG;
	
	public static void setupFeatureConfigs() {
		NETHERWOOD_TREE_STRAIGHT_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LOG.get().defaultBlockState()), new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 3, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().decorators(ImmutableList.of()).build();
		NETHERWOOD_TREE_FORKY_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LOG.get().defaultBlockState()), new SimpleBlockStateProvider(ModBlocks.NETHERWOOD_LEAVES.get().defaultBlockState()), new AcaciaFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 1))).ignoreVines().decorators(ImmutableList.of()).build();
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
