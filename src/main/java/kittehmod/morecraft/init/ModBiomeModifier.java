package kittehmod.morecraft.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;

public record ModBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature)  implements BiomeModifier
{

	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD && biomes.contains(biome)) {
			builder.getGenerationSettings().addFeature(Decoration.UNDERGROUND_ORES, feature);
		}
	}

	public Codec<? extends BiomeModifier> codec() {
		return ModBiomeCodecs.MORECRAFT_CODEC.get();
	}

}