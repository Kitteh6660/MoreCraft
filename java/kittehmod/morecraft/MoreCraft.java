package kittehmod.morecraft;

import kittehmod.morecraft.ai.CatsSitOnChestsHandler;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.client.ClientRenderSetup;
import kittehmod.morecraft.crafting.ModBrewingRecipes;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.item.ModPotions;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import kittehmod.morecraft.worldgen.ModFeatures;
import kittehmod.morecraft.worldgen.ModGenerator;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
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
    public static final String VERSION = "4.1b1";
	
    //public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    
    //public static Logger LOGGER = LogManager.getLogger(MODID);
    
    public MoreCraft()
    {
    	ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModTileEntityType.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModPotions.POTION_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    	DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
    		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    	});
    }
    
    private void setupCommon(final FMLCommonSetupEvent event)
    {
    	ModBrewingRecipes.registerRecipes();
    	ModFeatures.setupFeatureConfigs();
    	
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreCraftConfig.COMMON_CONFIG);
        MoreCraftConfig.loadConfig(MoreCraftConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft-common.toml"));
    	
        ModGenerator.setupGeneration();
        MorecraftPacketHandler.register();
        
    	MinecraftForge.EVENT_BUS.register(new MobDropEvents());
    	MinecraftForge.EVENT_BUS.register(new PlayerEvents());
    	MinecraftForge.EVENT_BUS.register(new CatsSitOnChestsHandler());
    	
    	ComposterBlock.CHANCES.put(Items.POISONOUS_POTATO, 0.65F); //Fixes the annoyance.
    	ComposterBlock.CHANCES.put(ModItems.APPLE_PIE.get(), 1.0F);
    	ComposterBlock.CHANCES.put(ModItems.NETHER_APPLE.get(), 0.65F);
    	ComposterBlock.CHANCES.put(ModItems.NETHER_APPLE_PIE.get(), 1.0F);
    	ComposterBlock.CHANCES.put(ModItems.NETHERWOOD_LEAVES.get(), 0.3F);
    }
    
    @OnlyIn(Dist.CLIENT)
	private void setupClient(final FMLClientSetupEvent event)
    {
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MoreCraftConfig.CLIENT_CONFIG);
        MoreCraftConfig.loadConfig(MoreCraftConfig.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft-client.toml"));
        
		ClientRenderSetup.setup();
    }
}