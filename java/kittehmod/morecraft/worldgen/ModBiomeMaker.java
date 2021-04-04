package kittehmod.morecraft.worldgen;

import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class ModBiomeMaker
{

	private static int getSkyColorWithTemperatureModifier(float temperature) {
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}

	public static Biome makeNetherwoodForestBiome() {
		MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder()).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4))
				.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HOGLIN, 2, 1, 1)).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 2, 1, 2))
				.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 30, 1, 2)).setPlayerCanSpawn().build();
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.SOUL_SAND_VALLEY).addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER)
				.addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE).addStructureStart(StructureFeatures.NETHER_BRIDGE).addStructureStart(StructureFeatures.BASTION_REMNANT)
				.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
		DefaultBiomeFeatures.addMushroomFieldVegetation(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
				.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
				.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)
				.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION)
				.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS)
				.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION);
		DefaultBiomeFeatures.addNetherDefaultOres(biomegenerationsettings$builder);
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3343107).skyColor(getSkyColorWithTemperatureModifier(2.0F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(mobspawninfo).generationSettings(biomegenerationsettings$builder.build()).build();
	}

}
