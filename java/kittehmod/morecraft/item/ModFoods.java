package kittehmod.morecraft.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {
	public static final Food COOKED_FLESH = (new Food.Builder()).hunger(8).saturation(0.4F).meat().effect(() -> new EffectInstance(Effects.NAUSEA, 400, 0), 0.1F).build();
	public static final Food SPIDER_RAW = (new Food.Builder()).hunger(3).saturation(0.3F).meat().effect(() -> new EffectInstance(Effects.NAUSEA, 600, 0), 0.1F).build();
	public static final Food SPIDER_COOKED = (new Food.Builder()).hunger(7).saturation(0.7F).meat().build();
	public static final Food SQUID_RAW = (new Food.Builder()).hunger(3).saturation(0.3F).meat().build();
	public static final Food SQUID_COOKED = (new Food.Builder()).hunger(6).saturation(0.6F).meat().build();
	public static final Food GUARDIAN_MEAT_RAW = (new Food.Builder()).hunger(3).saturation(0.3F).meat().build();
	public static final Food GUARDIAN_MEAT_COOKED = (new Food.Builder()).hunger(7).saturation(0.7F).meat().build();
	
	public static final Food COOKED_EGG = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.8F).effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.3F).build();
	public static final Food NETHER_APPLE = (new Food.Builder()).hunger(4).saturation(0.2F).build();
	public static final Food NETHER_APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.8F).build();
	public static final Food CAKE_SLICE = (new Food.Builder()).hunger(2).saturation(0.3F).build();
}
