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

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreCraft.MODID);
	
	public static final RegistryObject<EntityType<NetherBoatEntity>> CRIMSON_BOAT = ENTITIES.register("crimson_boat", () -> EntityType.Builder.<NetherBoatEntity>of(NetherBoatEntity::new, EntityClassification.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoatEntity(world, 0, 0, 0)).build("crimson_boat")); 
	public static final RegistryObject<EntityType<NetherBoatEntity>> WARPED_BOAT = ENTITIES.register("warped_boat", () -> EntityType.Builder.<NetherBoatEntity>of(NetherBoatEntity::new, EntityClassification.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoatEntity(world, 0, 0, 0)).build("warped_boat")); 
	public static final RegistryObject<EntityType<NetherBoatEntity>> NETHERWOOD_BOAT = ENTITIES.register("netherwood_boat", () -> EntityType.Builder.<NetherBoatEntity>of(NetherBoatEntity::new, EntityClassification.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoatEntity(world, 0, 0, 0)).build("netherwood_boat")); 

	public static final RegistryObject<EntityType<CraftingTableMinecartEntity>> NETHERWOOD_CRAFTING_TABLE_MINECART = ENTITIES.register("netherwood_crafting_table_minecart", () -> EntityType.Builder.<CraftingTableMinecartEntity>of(CraftingTableMinecartEntity::new, EntityClassification.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new CraftingTableMinecartEntity(world, 0, 0, 0, CraftingTableMinecartEntity.CraftingTableType.NETHERWOOD)).build("netherwood_crafting_table_minecart")); 

	
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
