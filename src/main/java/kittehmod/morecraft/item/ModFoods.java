package kittehmod.morecraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;

public class ModFoods {
	public static final FoodProperties COOKED_FLESH = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).meat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 0.1F).build();
	public static final FoodProperties CHEVON_RAW = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties CHEVON_COOKED = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).meat().build();
	public static final FoodProperties FROG_LEGS_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
	public static final FoodProperties FROG_LEGS_COOKED = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).meat().build();
	public static final FoodProperties SPIDER_RAW = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.1F).build();
	public static final FoodProperties SPIDER_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).meat().build();
	public static final FoodProperties SQUID_RAW = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties SQUID_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).meat().build();
	public static final FoodProperties GUARDIAN_MEAT_RAW = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties GUARDIAN_MEAT_COOKED = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).meat().build();
	public static final FoodProperties DRAGON_MEAT_RAW = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().build();
	public static final FoodProperties DRAGON_MEAT_COOKED = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F).meat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F).build();
	
	public static final FoodProperties BEEF_STEW = stew(10).build();
	public static final FoodProperties PORK_STEW = stew(10).build();
	public static final FoodProperties MUTTON_STEW = stew(10).build();
	public static final FoodProperties CHICKEN_STEW = stew(10).build();
	public static final FoodProperties CHEVON_STEW = stew(10).build();
	public static final FoodProperties SPIDER_STEW = stew(8).build();
	public static final FoodProperties FISH_STEW = stew(8).build();
	public static final FoodProperties GUARDIAN_STEW = stew(8).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 1.0F).build();
	public static final FoodProperties DRAGON_STEW = stew(12).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F).build();
	public static final FoodProperties NETHERSHROOM_STEW = stew(6).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.1F).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 0), 0.1F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 0.1F).build();
	
	public static final FoodProperties COOKED_EGG = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties NETHER_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).build();
	public static final FoodProperties CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	
	public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 0.3F).build();
	public static final FoodProperties NETHER_APPLE_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
	public static final FoodProperties SWEETBERRY_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	
	
	protected static Builder stew(int hunger) {
		return (new FoodProperties.Builder()).nutrition(hunger).saturationMod(0.6F);
	}
}
