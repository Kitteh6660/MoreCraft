package kittehmod.morecraft.item;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions extends Potions {

	public static final DeferredRegister<Potion> POTION_TYPES = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, MoreCraft.MODID);
	
	public static final RegistryObject<Potion> HEALTH_BOOST = POTION_TYPES.register("health_boost", () -> new Potion("health_boost", new EffectInstance(Effects.HEALTH_BOOST, 3600)));
	public static final RegistryObject<Potion> LONG_HEALTH_BOOST = POTION_TYPES.register("long_health_boost", () -> new Potion("health_boost", new EffectInstance(Effects.HEALTH_BOOST, 9600)));
	public static final RegistryObject<Potion> STRONG_HEALTH_BOOST = POTION_TYPES.register("strong_health_boost", () -> new Potion("health_boost", new EffectInstance(Effects.HEALTH_BOOST, 1800, 1)));
	
	public static final RegistryObject<Potion> RESISTANCE = POTION_TYPES.register("resistance", () -> new Potion("resistance", new EffectInstance(Effects.RESISTANCE, 3600)));
	public static final RegistryObject<Potion> LONG_RESISTANCE = POTION_TYPES.register("long_resistance", () -> new Potion("resistance", new EffectInstance(Effects.RESISTANCE, 9600)));
	public static final RegistryObject<Potion> STRONG_RESISTANCE = POTION_TYPES.register("strong_resistance", () -> new Potion("resistance", new EffectInstance(Effects.RESISTANCE, 1800, 1)));

	public static final RegistryObject<Potion> GLOWING = POTION_TYPES.register("glowing", () -> new Potion("glowing", new EffectInstance(Effects.GLOWING, 1200)));
	public static final RegistryObject<Potion> LONG_GLOWING = POTION_TYPES.register("long_glowing", () -> new Potion("glowing", new EffectInstance(Effects.GLOWING, 3200)));
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
