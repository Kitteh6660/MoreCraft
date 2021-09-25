package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModBiomes
{
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MoreCraft.MODID);

	public static RegistryObject<Biome> NETHERWOOD_FOREST = BIOMES.register("netherwood_forest", () -> makeNetherwoodForestBiome());

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
    	bgsb.getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> Feature.ORE.configured(new OreConfiguration(ModFeatures.ORE_RUBY_TARGET_LIST, MoreCraftConfig.rubyOreGenSize.get() + 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(MoreCraftConfig.rubyOreGenMaxHeight.get())).squared().count(MoreCraftConfig.rubyOreGenFreq.get()));
    	if (event.getCategory() == BiomeCategory.NETHER) {
    		if (MoreCraftConfig.generateNetherwoodTrees.get() <= 0) {
    			return; //Don't generate trees if set to 0.
    		}
    		final float genMultiplier;
    		switch(event.getName().toString()) {
	    		case "minecraft:nether_wastes":
	    			genMultiplier = 0.5F;
	    			break;
	    		case "minecraft:soul_sand_valley":
	    			genMultiplier = 0.1F;
	    			break;
	    		case "minecraft:crimson_forest":
	    		case "minecraft:warped_forest":
	    			genMultiplier = 0.5F;
	    			break;
	    		case "morecraft:netherwood_forest":
	    			genMultiplier = 1.0F;
	    			break;
	    		default:
	    			genMultiplier = 0.1F;
    		}
    		//Regular, straight Netherwood trees make up 70% of the trees.
    		bgsb.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_STRAIGHT_CONFIG).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration((int)Math.floor(MoreCraftConfig.generateNetherwoodTrees.get() * 0.7 * genMultiplier)))));
    		//Acacia-like, forked Netherwood trees make up 30% of the trees.
    		bgsb.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.NETHERWOOD_TREE.get().configured(ModFeatures.NETHERWOOD_TREE_FORKY_CONFIG).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration((int)Math.ceil(MoreCraftConfig.generateNetherwoodTrees.get() * 0.3 * genMultiplier)))));
    	}
    }
	
	private static int getSkyColorWithTemperatureModifier(float temperature) {
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = Mth.clamp(lvt_1_1_, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}

	public static Biome makeNetherwoodForestBiome() {
		MobSpawnSettings MobSpawnSettings = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4))
				.addSpawn(MobCategory.MONSTER, new SpawnerData(EntityType.HOGLIN, 2, 1, 1)).addSpawn(MobCategory.MONSTER, new SpawnerData(EntityType.PIGLIN, 2, 1, 2))
				.addSpawn(MobCategory.CREATURE, new SpawnerData(EntityType.STRIDER, 30, 1, 2)).setPlayerCanSpawn().build();
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.SOUL_SAND_VALLEY).addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER)
				.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE).addStructureStart(StructureFeatures.NETHER_BRIDGE).addStructureStart(StructureFeatures.BASTION_REMNANT)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
		BiomeDefaultFeatures.addMushroomFieldVegetation(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
				.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
				.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION);
		BiomeDefaultFeatures.addNetherDefaultOres(biomegenerationsettings$builder);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(BiomeCategory.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3343107).skyColor(getSkyColorWithTemperatureModifier(2.0F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(MobSpawnSettings).generationSettings(biomegenerationsettings$builder.build()).build();
	}
}
