package kittehmod.morecraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFDFoods
{
	public static final FoodProperties CHEVON_STEW_FD = ModFoods.stew(10).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties SPIDER_STEW_FD = ModFoods.stew(8).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0), 1.0F).build();
	public static final FoodProperties GUARDIAN_STEW_FD = ModFoods.stew(8).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0), 1.0F).build();
	public static final FoodProperties DRAGON_STEW_FD = ModFoods.stew(12).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0F).build();
	
	// Farmers Delight compat
	public static final FoodProperties RAW_CHEVON_CHOPS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().meat().build();
	public static final FoodProperties COOKED_CHEVON_CHOPS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().meat().build();
	public static final FoodProperties RAW_MINCED_SPIDER = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().meat().build();
	public static final FoodProperties COOKED_MINCED_SPIDER = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().meat().build();
	public static final FoodProperties RAW_GUARDIAN_CUTS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().meat().build();
	public static final FoodProperties COOKED_GUARDIAN_CUTS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().meat().build();
	public static final FoodProperties RAW_DRAGON_CHOPS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().meat().build();
	public static final FoodProperties COOKED_DRAGON_CHOPS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).fast().meat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
	public static final FoodProperties DRAGON_CASSEROLE = (new FoodProperties.Builder()).nutrition(16).saturationMod(1.0F).meat().effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
}
