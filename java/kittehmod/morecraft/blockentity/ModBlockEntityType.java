package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.blockentity.addons.ModBarrelBlockEntity;
import kittehmod.morecraft.blockentity.addons.ModBookcaseBlockEntity;
import kittehmod.morecraft.blockentity.addons.ModCrateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlockEntityType {

	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoreCraft.MODID);
	
    public static RegistryObject<BlockEntityType<ModChestBlockEntity>> NETHERWOOD_CHEST = TILE_ENTITIES.register("netherwood_chest", () -> BlockEntityType.Builder.of(ModChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<ModTrappedChestBlockEntity>> NETHERWOOD_TRAPPED_CHEST = TILE_ENTITIES.register("netherwood_trapped_chest", () -> BlockEntityType.Builder.of(ModTrappedChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null));
    public static RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = TILE_ENTITIES.register("netherwood_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null));
    public static RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = TILE_ENTITIES.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));
    public static RegistryObject<BlockEntityType<ModCrateBlockEntity>> CRATE = TILE_ENTITIES.register("crate", () -> BlockEntityType.Builder.of(ModCrateBlockEntity::new, ModBlocks.NETHERWOOD_CRATE.get()).build(null));
    public static RegistryObject<BlockEntityType<ModBookcaseBlockEntity>> BOOKCASE = TILE_ENTITIES.register("bookcase", () -> BlockEntityType.Builder.of(ModBookcaseBlockEntity::new, ModBlocks.NETHERWOOD_BOOKCASE.get()).build(null));
    public static RegistryObject<BlockEntityType<ModBarrelBlockEntity>> MOD_BARREL = TILE_ENTITIES.register("mod_barrel", () -> BlockEntityType.Builder.of(ModBarrelBlockEntity::new, ModBlocks.NETHERWOOD_BARREL.get()).build(null));

    public static ModBlockEntityType instance = new ModBlockEntityType();
}
