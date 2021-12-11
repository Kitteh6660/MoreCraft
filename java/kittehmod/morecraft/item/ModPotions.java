package kittehmod.morecraft.item;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions extends Potions 
{
	public static final DeferredRegister<Potion> POTION_TYPES = DeferredRegister.create(ForgeRegistries.POTIONS, MoreCraft.MODID);
	
	public static final RegistryObject<Potion> HEALTH_BOOST = POTION_TYPES.register("health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600)));
	public static final RegistryObject<Potion> LONG_HEALTH_BOOST = POTION_TYPES.register("long_health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 9600)));
	public static final RegistryObject<Potion> STRONG_HEALTH_BOOST = POTION_TYPES.register("strong_health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 1800, 1)));

	public static final RegistryObject<Potion> RESISTANCE = POTION_TYPES.register("resistance", () -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600)));
	public static final RegistryObject<Potion> LONG_RESISTANCE = POTION_TYPES.register("long_resistance", () -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600)));
	public static final RegistryObject<Potion> STRONG_RESISTANCE = POTION_TYPES.register("strong_resistance", () -> new Potion("resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 1)));

	public static final RegistryObject<Potion> GLOWING = POTION_TYPES.register("glowing", () -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 1200)));
	public static final RegistryObject<Potion> LONG_GLOWING = POTION_TYPES.register("long_glowing", () -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 3200)));
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
