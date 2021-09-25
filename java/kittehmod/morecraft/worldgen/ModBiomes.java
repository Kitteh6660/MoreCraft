package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModBiomes
{
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MoreCraft.MODID);

	public static RegistryObject<Biome> NETHERWOOD_FOREST = BIOMES.register("netherwood_forest", () -> ModBiomeMaker.makeNetherwoodForestBiome());

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
	    public static void registerFeature(final RegistryEvent.Register<Biome> event) { 
	    	event.getRegistry().registerAll();
	    }
	}
	
	@SubscribeEvent
    public void biomeLoadEvent(BiomeLoadingEvent event) {
    	BiomeGenerationSettingsBuilder bgsb = event.getGeneration();
    	bgsb.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().defaultBlockState(), MoreCraftConfig.rubyOreGenSize.get())).range(MoreCraftConfig.rubyOreGenMaxHeight.get()).squared().count(MoreCraftConfig.rubyOreGenFreq.get()));
    	if (event.getCategory() == Biome.Category.NETHER) {
    		if (MoreCraftConfig.generateNetherwoodTrees.get() <= 0) {
    			return; //Don't generate trees if set to 0.
    		}
    		final float genMultiplier;
    		switch(event.getName().toString()) {
	    		case "minecraft:nether_wastes":
	    		case "minecraft:soul_sand_valley":
	    			genMultiplier = 0.5F;
	    			break;
	    		case "minecraft:crimson_forest":
	    		case "minecraft:warped_forest":
	    			genMultiplier = 1.0F;
	    			break;
	    		case "morecraft:netherwood_forest":
	    			genMultiplier = 4.0F;
	    			break;
	    		default:
	    			genMultiplier = 0.25F;
    		}
    		//Regular, straight Netherwood trees make up 70% of the trees.
    		bgsb.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_STRAIGHT_CONFIG).decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig((int)Math.floor(MoreCraftConfig.generateNetherwoodTrees.get() * 0.7 * genMultiplier)))));
    		//Acacia-like, forked Netherwood trees make up 30% of the trees.
    		bgsb.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_FORKY_CONFIG).decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig((int)Math.ceil(MoreCraftConfig.generateNetherwoodTrees.get() * 0.3 * genMultiplier)))));
    	}
    }
}
