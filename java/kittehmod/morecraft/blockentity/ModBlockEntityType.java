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

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreCraft.MODID);
	
	//Core
    public static final RegistryObject<BlockEntityType<ModChestBlockEntity>> NETHERWOOD_CHEST = BLOCK_ENTITIES.register("netherwood_chest", () -> BlockEntityType.Builder.of(ModChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModTrappedChestBlockEntity>> NETHERWOOD_TRAPPED_CHEST = BLOCK_ENTITIES.register("netherwood_trapped_chest", () -> BlockEntityType.Builder.of(ModTrappedChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register("netherwood_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = BLOCK_ENTITIES.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));
    public static final RegistryObject<BlockEntityType<WardenSkullBlockEntity>> WARDEN_HEAD = BLOCK_ENTITIES.register("warden_head", () -> BlockEntityType.Builder.of(WardenSkullBlockEntity::new, ModBlocks.WARDEN_HEAD.get(), ModBlocks.WARDEN_WALL_HEAD.get()).build(null));
    
    //Addons
    public static final RegistryObject<BlockEntityType<ModCrateBlockEntity>> CRATE = BLOCK_ENTITIES.register("crate", () -> BlockEntityType.Builder.of(ModCrateBlockEntity::new, ModBlocks.NETHERWOOD_CRATE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModBookcaseBlockEntity>> BOOKCASE = BLOCK_ENTITIES.register("bookcase", () -> BlockEntityType.Builder.of(ModBookcaseBlockEntity::new, ModBlocks.NETHERWOOD_BOOKCASE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModBarrelBlockEntity>> MOD_BARREL = BLOCK_ENTITIES.register("mod_barrel", () -> BlockEntityType.Builder.of(ModBarrelBlockEntity::new, ModBlocks.NETHERWOOD_BARREL.get()).build(null));

    public static ModBlockEntityType instance = new ModBlockEntityType();
}
