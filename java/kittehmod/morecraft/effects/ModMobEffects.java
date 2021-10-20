package kittehmod.morecraft.effects;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMobEffects
{
	public static final DeferredRegister<Effect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, MoreCraft.MODID);
	
	public static final RegistryObject<Effect> UNAFRAID = MOB_EFFECTS.register("unafraid", () -> (new ModMobEffect(EffectType.BENEFICIAL, 0 + (255 * 256) + 0)));
	public static final RegistryObject<Effect> SCARED = MOB_EFFECTS.register("fear", () -> (new ModMobEffect(EffectType.HARMFUL, (255 * 256 * 256) + 0 + 0)));
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerEffects(final RegistryEvent.Register<Effect> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
