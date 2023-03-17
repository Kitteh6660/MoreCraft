package kittehmod.morecraft.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSliceProvider;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
import com.teamabnormals.blueprint.core.util.BiomeUtil.MultiNoiseModdedBiomeProvider;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.init.ModBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import net.minecraft.world.level.dimension.LevelStem;

public class MorecraftModdedBiomeSliceProvider extends ModdedBiomeSliceProvider
{

	public MorecraftModdedBiomeSliceProvider(DataGenerator dataGenerator) {
		super(dataGenerator, MoreCraft.MODID);
	}

	@Override
	protected void registerSlices() {
		List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> entries = new ArrayList<>();
		new NetherwoodBiomeBuilder().addBiomesToSlice(entries::add);
		this.registerSlice("netherwood", 1, new MultiNoiseModdedBiomeProvider(new Climate.ParameterList<>(entries)), LevelStem.NETHER.location());
	}

	@SuppressWarnings("unchecked")
	private static final class NetherwoodBiomeBuilder {
		private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
		private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER.getKey();
		private final ResourceKey<Biome>[][] NETHER_BIOMES = new ResourceKey[][]{{ModBiomes.NETHERWOOD_FOREST.getKey(), VANILLA, VANILLA, VANILLA, VANILLA}, {VANILLA, ModBiomes.NETHERWOOD_FOREST.getKey(), VANILLA, VANILLA}, {VANILLA, ModBiomes.NETHERWOOD_FOREST.getKey(), VANILLA, VANILLA, VANILLA}, {ModBiomes.NETHERWOOD_FOREST.getKey(), VANILLA, VANILLA, VANILLA, VANILLA}, {ModBiomes.NETHERWOOD_FOREST.getKey(), VANILLA, VANILLA, VANILLA, VANILLA}};
		private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(0.99F, 1.00F)};
		private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, 0.0F)};
		private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
	
		private void addBiomesToSlice(Consumer<Pair<ParameterPoint, ResourceKey<Biome>>> consumer) {
			this.addNetherBiomes(consumer);
		}

		private void addNetherBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
			this.addNetherSlice(consumer, Climate.Parameter.span(-1.0F, -0.93333334F));
		}
		
		private void addNetherSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
			for (int i = 0; i < this.temperatures.length; ++i) {
				Climate.Parameter temperature = this.temperatures[i];

				for (int j = 0; j < this.humidities.length; ++j) {
					Climate.Parameter humidity = this.humidities[j];
					ResourceKey<Biome> resourcekey = this.pickNetherBiome(i, j, weirdness);
					this.addNetherBiome(consumer, temperature, humidity, FULL_RANGE, this.erosions[0], weirdness, 0.0F, resourcekey);
					this.addNetherBiome(consumer, temperature, humidity, FULL_RANGE, this.erosions[0], weirdness, 0.0F, VANILLA);
				}
			}
		}
		
		private ResourceKey<Biome> pickNetherBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
			if (weirdness.max() < 0L) {
				return this.NETHER_BIOMES[temperatureIndex][humidityIndex];
			} else {
				ResourceKey<Biome> resourcekey = this.NETHER_BIOMES[temperatureIndex][humidityIndex];
				return resourcekey == null ? this.NETHER_BIOMES[temperatureIndex][humidityIndex] : resourcekey;
			}
		}

		private void addNetherBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187181_, Climate.Parameter p_187182_, Climate.Parameter p_187183_, Climate.Parameter p_187184_, Climate.Parameter p_187185_, Climate.Parameter p_187186_, float p_187187_, ResourceKey<Biome> p_187188_) {
			p_187181_.accept(Pair.of(Climate.parameters(p_187182_, p_187183_, p_187184_, p_187185_, Climate.Parameter.point(0.0F), p_187186_, p_187187_), p_187188_));
		}
	}
	
}
