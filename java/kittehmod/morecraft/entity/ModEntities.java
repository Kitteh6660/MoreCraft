package kittehmod.morecraft.entity;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreCraft.MODID);
	
	public static final RegistryObject<EntityType<NetherBoat>> NETHER_BOAT = ENTITIES.register("nether_boat", () -> EntityType.Builder.<NetherBoat>of(NetherBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherBoat(world, 0, 0, 0)).build("nether_boat")); 

	public static final RegistryObject<EntityType<NetherChestBoat>> NETHER_CHEST_BOAT = ENTITIES.register("nether_chest_boat", () -> EntityType.Builder.<NetherChestBoat>of(NetherChestBoat::new, MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new NetherChestBoat(world, 0, 0, 0)).build("nether_chest_boat")); 
}
