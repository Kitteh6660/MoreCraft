package kittehmod.morecraft.entity;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreCraft.MODID);
	
	public static final RegistryObject<EntityType<NetherBoat>> CRIMSON_BOAT = ENTITIES.register("crimson_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("crimson_boat")); 
	public static final RegistryObject<EntityType<NetherBoat>> WARPED_BOAT = ENTITIES.register("warped_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("warped_boat")); 
	public static final RegistryObject<EntityType<NetherBoat>> NETHERWOOD_BOAT = ENTITIES.register("netherwood_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("netherwood_boat")); 

	public static final RegistryObject<EntityType<MinecartCraftingTable>> OAK_CRAFTING_TABLE_MINECART = ENTITIES.register("oak_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.OAK)).build("oak_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> SPRUCE_CRAFTING_TABLE_MINECART = ENTITIES.register("spruce_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.SPRUCE)).build("spruce_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> BIRCH_CRAFTING_TABLE_MINECART = ENTITIES.register("birch_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.BIRCH)).build("birch_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> JUNGLE_CRAFTING_TABLE_MINECART = ENTITIES.register("jungle_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.JUNGLE)).build("jungle_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> ACACIA_CRAFTING_TABLE_MINECART = ENTITIES.register("acacia_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.ACACIA)).build("acacia_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> DARK_OAK_CRAFTING_TABLE_MINECART = ENTITIES.register("dark_oak_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.DARK_OAK)).build("dark_oak_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> CRIMSON_CRAFTING_TABLE_MINECART = ENTITIES.register("crimson_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.CRIMSON)).build("crimson_crafting_table_minecart")); 
	public static final RegistryObject<EntityType<MinecartCraftingTable>> WARPED_CRAFTING_TABLE_MINECART = ENTITIES.register("warped_crafting_table_minecart", () -> EntityType.Builder.<MinecartCraftingTable>of(MinecartCraftingTable::new, MobCategory.MISC).sized(0.98F, 0.7F).setTrackingRange(8).setCustomClientFactory((spawnEntity, world) -> new MinecartCraftingTable(world, 0, 0, 0, MinecartCraftingTable.CraftingTableType.WARPED)).build("warped_crafting_table_minecart")); 
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
