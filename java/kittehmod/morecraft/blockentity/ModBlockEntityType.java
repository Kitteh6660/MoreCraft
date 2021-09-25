package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntityType {

	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoreCraft.MODID);
	
    public static RegistryObject<BlockEntityType<ModChestBlockEntity>> NETHERWOOD_CHEST = TILE_ENTITIES.register("netherwood_chest", () -> BlockEntityType.Builder.of(ModChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<ModTrappedChestBlockEntity>> NETHERWOOD_TRAPPED_CHEST = TILE_ENTITIES.register("netherwood_trapped_chest", () -> BlockEntityType.Builder.of(ModTrappedChestBlockEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null));
    public static RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = TILE_ENTITIES.register("netherwood_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null));
    public static RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = TILE_ENTITIES.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));

    public static ModBlockEntityType instance = new ModBlockEntityType();
    
    @Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<BlockEntityType<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }
	
}