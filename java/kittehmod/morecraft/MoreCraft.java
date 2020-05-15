package kittehmod.morecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.client.ModSkullTileEntityRenderer;
import kittehmod.morecraft.client.NetherwoodBoatRenderFactory;
import kittehmod.morecraft.client.NetherwoodChestTileEntityRenderer;
import kittehmod.morecraft.client.NetherwoodSignTileEntityRenderer;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.entity.NetherwoodBoatEntity;
import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodChestTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import kittehmod.morecraft.worldgen.ModFeatures;
import kittehmod.morecraft.worldgen.ModGenerator;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(MoreCraft.MODID)
public class MoreCraft 
{
    public static final String MODID = "morecraft";
    public static final String VERSION = "4.0a2";
	
    //public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    
    public static Logger LOGGER = LogManager.getLogger(MODID);
    
    public MoreCraft()
    {
    	ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    	DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
    		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    	});
    	
    	MinecraftForge.EVENT_BUS.register(new MobDropEvents());
    	MinecraftForge.EVENT_BUS.register(new PlayerEvents());
    	
    	ComposterBlock.CHANCES.put(Items.POISONOUS_POTATO, 0.65F); //Fixes the annoyance.
    	ComposterBlock.CHANCES.put(ModItems.NETHER_APPLE.get(), 0.65F);
    	ComposterBlock.CHANCES.put(ModItems.NETHER_APPLE_PIE.get(), 1.0F);
    	ComposterBlock.CHANCES.put(ModItems.NETHERWOOD_LEAVES.get(), 0.3F);
    }
    
    private void setupCommon(final FMLCommonSetupEvent event)
    {
    	LOGGER.info("Common setup...");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreCraftConfig.COMMON_CONFIG);
        MoreCraftConfig.loadConfig(MoreCraftConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft-common.toml"));
    	
        ModGenerator.setupGeneration();
        MorecraftPacketHandler.register();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @OnlyIn(Dist.CLIENT)
	private void setupClient(final FMLClientSetupEvent event)
    {
    	LOGGER.info("Client setup...");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MoreCraftConfig.CLIENT_CONFIG);
        MoreCraftConfig.loadConfig(MoreCraftConfig.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft-client.toml"));
        RenderingRegistry.registerEntityRenderingHandler(NetherwoodBoatEntity.class, NetherwoodBoatRenderFactory.INSTANCE);
		
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntitySpecialRenderer(NetherwoodChestTileEntity.class, new NetherwoodChestTileEntityRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(NetherwoodTrappedChestTileEntity.class, new NetherwoodChestTileEntityRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(NetherwoodSignTileEntity.class, new NetherwoodSignTileEntityRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ModSkullTileEntity.class, new ModSkullTileEntityRenderer());
    }
	
  //public static Rarity LEGENDARY = EnumHelper.addRarity("Legendary", TextFormatting.GOLD, "Legendary");
    
}