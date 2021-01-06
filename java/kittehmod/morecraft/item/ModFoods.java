package kittehmod.morecraft.item;

import net.minecraft.item.Food;
import net.minecraft.item.Food.Builder;
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
	
	public static final Food BEEF_STEW = stew(10).build();
	public static final Food PORK_STEW = stew(10).build();
	public static final Food MUTTON_STEW = stew(10).build();
	public static final Food CHICKEN_STEW = stew(10).build();
	public static final Food SPIDER_STEW = stew(8).build();
	public static final Food FISH_STEW = stew(8).build();
	
	public static final Food COOKED_EGG = (new Food.Builder()).hunger(6).saturation(0.6F).build();
	public static final Food NETHER_APPLE = (new Food.Builder()).hunger(4).saturation(0.2F).build();
	public static final Food CAKE_SLICE = (new Food.Builder()).hunger(2).saturation(0.3F).build();
	
	public static final Food APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.8F).effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.3F).build();
	public static final Food NETHER_APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.8F).build();
	public static final Food SWEETBERRY_PIE = (new Food.Builder()).hunger(8).saturation(0.7F).build();
	
	private static Builder stew(int hunger) {
		return (new Food.Builder()).hunger(hunger).saturation(0.6F);
	}
}
