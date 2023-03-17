package kittehmod.morecraft.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomeCodecs
{
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MoreCraft.MODID);
	 
	public static final RegistryObject<Codec<ModBiomeModifier>> MORECRAFT_CODEC = BIOME_MODIFIER_SERIALIZERS.register("morecraft_codec", () -> RecordCodecBuilder.create(builder -> builder.group(Biome.LIST_CODEC.fieldOf("biomes").forGetter(ModBiomeModifier::biomes), PlacedFeature.CODEC.fieldOf("feature").forGetter(ModBiomeModifier::feature)).apply(builder, ModBiomeModifier::new)));

}
