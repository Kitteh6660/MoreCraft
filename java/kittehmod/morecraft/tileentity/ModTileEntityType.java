package kittehmod.morecraft.tileentity;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.tileentity.addons.ModBarrelTileEntity;
import kittehmod.morecraft.tileentity.addons.ModBookcaseTileEntity;
import kittehmod.morecraft.tileentity.addons.ModCrateTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityType {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MoreCraft.MODID);
	
    public static RegistryObject<TileEntityType<NetherwoodChestTileEntity>> NETHERWOOD_CHEST = TILE_ENTITIES.register("netherwood_chest", () -> TileEntityType.Builder.of(NetherwoodChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null));
    public static RegistryObject<TileEntityType<NetherwoodTrappedChestTileEntity>> NETHERWOOD_TRAPPED_CHEST = TILE_ENTITIES.register("netherwood_trapped_chest", () -> TileEntityType.Builder.of(NetherwoodTrappedChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null));
    public static RegistryObject<TileEntityType<ModSignTileEntity>> MOD_SIGN = TILE_ENTITIES.register("netherwood_sign", () -> TileEntityType.Builder.of(ModSignTileEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null));
    public static RegistryObject<TileEntityType<KilnTileEntity>> KILN = TILE_ENTITIES.register("kiln", () -> TileEntityType.Builder.of(KilnTileEntity::new, ModBlocks.KILN.get()).build(null));
    public static RegistryObject<TileEntityType<ModCrateTileEntity>> CRATE = TILE_ENTITIES.register("crate", () -> TileEntityType.Builder.of(ModCrateTileEntity::new, ModBlocks.NETHERWOOD_CRATE.get()).build(null));
    public static RegistryObject<TileEntityType<ModBookcaseTileEntity>> BOOKCASE = TILE_ENTITIES.register("bookcase", () -> TileEntityType.Builder.of(ModBookcaseTileEntity::new, ModBlocks.NETHERWOOD_BOOKCASE.get()).build(null));
    public static RegistryObject<TileEntityType<ModBarrelTileEntity>> MOD_BARREL = TILE_ENTITIES.register("mod_barrel", () -> TileEntityType.Builder.of(ModBarrelTileEntity::new, ModBlocks.NETHERWOOD_BARREL.get()).build(null));

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
