package kittehmod.morecraft.entity;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreCraft.MODID);
	
	public static final RegistryObject<EntityType<NetherBoat>> CRIMSON_BOAT = ENTITIES.register("crimson_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("crimson_boat")); 
	public static final RegistryObject<EntityType<NetherBoat>> WARPED_BOAT = ENTITIES.register("warped_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("warped_boat")); 
	public static final RegistryObject<EntityType<NetherBoat>> NETHERWOOD_BOAT = ENTITIES.register("netherwood_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("netherwood_boat")); 

	public static final RegistryObject<EntityType<MinecartCraftingTable>> NETHERWOOD_CRAFTING_TABLE_MINECART = ENTITIES.register("netherwood_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.NETHERWOOD)).build("netherwood_crafting_table_minecart")); 

	
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
