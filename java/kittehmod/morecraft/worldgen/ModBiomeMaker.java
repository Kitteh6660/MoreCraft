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
		return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}

	public static Biome makeNetherwoodForestBiome() {
		
		MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder()).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4))
				.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HOGLIN, 2, 1, 1)).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 2, 1, 2))
				.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 30, 1, 2)).isValidSpawnBiomeForPlayer().copy();
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244187_s).withStructure(StructureFeatures.RUINED_PORTAL_NETHER)
				.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f).withStructure(StructureFeatures.FORTRESS).withStructure(StructureFeatures.BASTION_REMNANT)
				.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
		DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
		biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
				.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
				.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)
				.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION).withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION)
				.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS).withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_CRIMSON_ROOTS)
				.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION).withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION);
		DefaultBiomeFeatures.withCommonNetherBlocks(biomegenerationsettings$builder);
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(3343107).withSkyColor(getSkyColorWithTemperatureModifier(2.0F)).setAmbientSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY)).build()).withMobSpawnSettings(mobspawninfo).withGenerationSettings(biomegenerationsettings$builder.build()).build();
	}

}
