package kittehmod.morecraft.tileentity;

import java.util.function.Supplier;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class ModTileEntityType {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITITES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MoreCraft.MODID);
	
    @ObjectHolder("morecraft:netherwood_chest")
    public static TileEntityType<?> NETHERWOOD_CHEST;

    @ObjectHolder("morecraft:netherwood_trapped_chest")
    public static TileEntityType<?> NETHERWOOD_TRAPPED_CHEST;

    @ObjectHolder("morecraft:netherwood_sign")
    public static TileEntityType<?> NETHERWOOD_SIGN;

    @ObjectHolder("morecraft:mod_skull")
    public static TileEntityType<?> MOD_SKULL;
    
    public static ModTileEntityType instance = new ModTileEntityType();
    
    @Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll(
            	TileEntityType.Builder.create((Supplier<TileEntity>) NetherwoodChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST.get()).build(null).setRegistryName("morecraft:netherwood_chest"),
                TileEntityType.Builder.create((Supplier<TileEntity>) NetherwoodTrappedChestTileEntity::new, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get()).build(null).setRegistryName("morecraft:netherwood_trapped_chest"),
                TileEntityType.Builder.create((Supplier<TileEntity>) NetherwoodSignTileEntity::new, ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()).build(null).setRegistryName("morecraft:netherwood_sign"),
                TileEntityType.Builder.create((Supplier<TileEntity>) ModSkullTileEntity::new, ModBlocks.SPIDER_HEAD.get(), ModBlocks.WALL_SPIDER_HEAD.get(), ModBlocks.CAVE_SPIDER_HEAD.get(), ModBlocks.WALL_CAVE_SPIDER_HEAD.get(), ModBlocks.ZOMBIE_PIGMAN_HEAD.get(), ModBlocks.WALL_ZOMBIE_PIGMAN_HEAD.get(), ModBlocks.BLAZE_HEAD.get(), ModBlocks.WALL_BLAZE_HEAD.get(), ModBlocks.ENDERMAN_HEAD.get(), ModBlocks.WALL_ENDERMAN_HEAD.get()).build(null).setRegistryName("morecraft:mod_skull")
            );
        }
    }
	
}
