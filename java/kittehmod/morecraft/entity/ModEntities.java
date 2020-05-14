package kittehmod.morecraft.entity;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MoreCraft.MODID);
	
	public static final RegistryObject<EntityType<NetherwoodBoatEntity>> NETHERWOOD_BOAT = ENTITIES.register("netherwood_boat", () -> EntityType.Builder.<NetherwoodBoatEntity>create(NetherwoodBoatEntity::new, EntityClassification.MISC).immuneToFire().size(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherwoodBoatEntity(world, 0, 0, 0)).build("netherwood_boat")); 
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(MoreCraft.MODID, name));
		}

		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
		
	    @SubscribeEvent
	    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) { 
	    	event.getRegistry().registerAll();
	    }
	    
	}
}
