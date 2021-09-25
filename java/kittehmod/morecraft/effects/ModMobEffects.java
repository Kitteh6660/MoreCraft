package kittehmod.morecraft.effects;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMobEffects
{
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MoreCraft.MODID);
	
	public static final RegistryObject<MobEffect> UNAFRAID = MOB_EFFECTS.register("unafraid", () -> (new ModMobEffect(MobEffectCategory.BENEFICIAL, 0 + (255 * 256) + 0)));
	public static final RegistryObject<MobEffect> SCARED = MOB_EFFECTS.register("fear", () -> (new ModMobEffect(MobEffectCategory.HARMFUL, (255 * 256 * 256) + 0 + 0)));
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerEffects(final RegistryEvent.Register<MobEffect> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
