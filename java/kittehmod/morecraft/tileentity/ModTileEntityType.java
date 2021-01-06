package kittehmod.morecraft.tileentity;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityType {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MoreCraft.MODID);
	
    public static RegistryObject<TileEntityType<NetherwoodChestTileEntity>> NETHERWOOD_CHEST = TILE_ENTITIES.register("netherwood_chest", () -> TileEntityType.Builder.create(NetherwoodChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null));
    public static RegistryObject<TileEntityType<NetherwoodTrappedChestTileEntity>> NETHERWOOD_TRAPPED_CHEST = TILE_ENTITIES.register("netherwood_trapped_chest", () -> TileEntityType.Builder.create(NetherwoodTrappedChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null));
    public static RegistryObject<TileEntityType<ModSignTileEntity>> NETHERWOOD_SIGN = TILE_ENTITIES.register("netherwood_sign", () -> TileEntityType.Builder.create(ModSignTileEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null));
    public static RegistryObject<TileEntityType<ModSkullTileEntity>> MOD_SKULL = TILE_ENTITIES.register("morecraft_skulls", () -> TileEntityType.Builder.create(ModSkullTileEntity::new).build(null));

    public static ModTileEntityType instance = new ModTileEntityType();
    
    @Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }
	
}
