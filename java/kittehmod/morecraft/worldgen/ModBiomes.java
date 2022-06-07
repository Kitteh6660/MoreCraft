package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomes
{
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MoreCraft.MODID);

	public static RegistryObject<Biome> NETHERWOOD_FOREST = BIOMES.register("netherwood_forest", () -> netherwoodForest());
	
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
	    public static void registerBiome(final RegistryEvent.Register<Biome> event) { 
	    	event.getRegistry().registerAll();
	    	//BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeEntry(key(NETHERWOOD_FOREST.get()), 10));
	    	//BiomeDictionary.addTypes(key(NETHERWOOD_FOREST.get()), Type.HOT, Type.DRY, Type.NETHER, Type.FOREST);
	    }
	    
		/*private static ResourceKey<Biome> key(final Biome biome) {
			return ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
		}*/
	}
	
	@SubscribeEvent
    public void biomeLoadEvent(BiomeLoadingEvent event) {
    	BiomeGenerationSettingsBuilder bgsb = event.getGeneration();
    	bgsb.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacements.ORE_RUBY);
    	bgsb.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacements.ORE_RUBY_LARGE);
    	bgsb.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacements.ORE_RUBY_BURIED);
    	if (event.getCategory() == BiomeCategory.NETHER) {
    		if (MoreCraftConfig.generateNetherwoodTrees.get() > 0) {
			    if (event.getName().toString().equalsIgnoreCase("minecraft:crimson_forest") || event.getName().toString().equalsIgnoreCase("minecraft:warped_forest")) {
		    		bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_STRAIGHT_HIGH);
				    bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_FORKY_HIGH);
			    }
			    else {
		    		bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_STRAIGHT_LOW);
				    bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_FORKY_LOW);
			    }
    			// Netherwood Forest gets the highest concentration.
    			if (event.getName().toString().equalsIgnoreCase("morecraft:netherwood_forest")) {
		        	bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_STRAIGHT_CHECKED);
		        	bgsb.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacements.NETHERWOOD_FORKY_CHECKED);
    			}
    		}
    	}
    	
    }
	
	private static int calculateSkyColor(float temperature) {
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = Mth.clamp(lvt_1_1_, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	//Add additional biomes here.
	public static Biome netherwoodForest() {
		MobSpawnSettings mobspawnsettings = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2)).addMobCharge(EntityType.ENDERMAN, 1.0D, 0.12D).build();
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MiscOverworldPlacements.SPRING_LAVA);
		BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_SOUL_FIRE).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA).addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.CRIMSON_FOREST_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.WARPED_FOREST_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.NETHER_SPROUTS).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.TWISTING_VINES);
		BiomeDefaultFeatures.addNetherDefaultOres(biomegenerationsettings$builder);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(1705242).skyColor(calculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST)).build()).mobSpawnSettings(mobspawnsettings).generationSettings(biomegenerationsettings$builder.build()).build();
	}
}
