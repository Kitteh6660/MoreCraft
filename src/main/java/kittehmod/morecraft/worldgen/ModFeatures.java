package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreCraft.MODID);
	
	protected static RegistryObject<Feature<TreeConfiguration>> NETHERWOOD_TREE = FEATURES.register("netherwood_tree", () -> new NetherwoodTreeFeature(TreeConfiguration.CODEC, true));
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> NETHERWOOD_TREE_STRAIGHT = FeatureUtils.createKey("morecraft:netherwood_straight");
	public static final ResourceKey<ConfiguredFeature<?, ?>> NETHERWOOD_TREE_FORKY = FeatureUtils.createKey("morecraft:netherwood_forky");
}
