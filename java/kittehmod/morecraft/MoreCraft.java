package kittehmod.morecraft;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.blockentity.ModBlockEntityType;
import kittehmod.morecraft.client.ClientRenderSetup;
import kittehmod.morecraft.container.ModContainerType;
import kittehmod.morecraft.effects.ModMobEffects;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.entity.ai.CatsSitOnChestsHandler;
import kittehmod.morecraft.events.MobEvents;
import kittehmod.morecraft.events.PlayerEvents;
import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.item.ModPotions;
import kittehmod.morecraft.item.crafting.ModBrewingRecipes;
import kittehmod.morecraft.item.crafting.ModRecipeBookCategories;
import kittehmod.morecraft.item.crafting.ModRecipeType;
import kittehmod.morecraft.item.crafting.ModRecipes;
import kittehmod.morecraft.item.crafting.conditions.CharmModNotInstalledCondition;
import kittehmod.morecraft.item.crafting.conditions.CharmModuleRecipeCondition;
import kittehmod.morecraft.item.crafting.conditions.HardcoreRecipeCondition;
import kittehmod.morecraft.item.crafting.conditions.QuarkFlagRecipeCondition;
import kittehmod.morecraft.item.crafting.conditions.SalvageRecipeCondition;
import kittehmod.morecraft.item.crafting.conditions.SillyRecipeCondition;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import kittehmod.morecraft.worldgen.ModBiomeCodecs;
import kittehmod.morecraft.worldgen.ModBiomes;
import kittehmod.morecraft.worldgen.ModFeatures;
import kittehmod.morecraft.worldgen.ModPlacements;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.RecipeBookRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(MoreCraft.MODID)
public class MoreCraft 
{
    public static final String MODID = "morecraft";
    
    //public static final Logger LOGGER = LogManager.getLogger(MODID);
    
	public MoreCraft()
    {
    	ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModBlockEntityType.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModPotions.POTION_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModMobEffects.MOB_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ModContainerType.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
     	ModRecipeType.RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
     	ModRecipes.RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
     	ModBiomeCodecs.BIOME_MODIFIER_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	MoreCraftSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    	if (FMLEnvironment.dist == Dist.CLIENT) {
    		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    	}
    }
    
    private void setupCommon(final FMLCommonSetupEvent event)
    {
    	ModBrewingRecipes.registerRecipes();
    	ModFeatures.setupFeatureConfigs();
    	ModPlacements.setupPlacements();
    	
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreCraftConfig.COMMON_CONFIG);
        MoreCraftConfig.loadConfig(MoreCraftConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft.toml"));
    	
        MorecraftPacketHandler.register();
        
        CraftingHelper.register(new CharmModNotInstalledCondition.Serializer());
        CraftingHelper.register(new CharmModuleRecipeCondition.Serializer());
        CraftingHelper.register(new QuarkFlagRecipeCondition.Serializer());
        CraftingHelper.register(new HardcoreRecipeCondition.Serializer());
        CraftingHelper.register(new SalvageRecipeCondition.Serializer());
        CraftingHelper.register(new SillyRecipeCondition.Serializer());
        
    	MinecraftForge.EVENT_BUS.register(new MobEvents());
    	MinecraftForge.EVENT_BUS.register(new PlayerEvents());
    	MinecraftForge.EVENT_BUS.register(new CatsSitOnChestsHandler());
    	MinecraftForge.EVENT_BUS.register(new ModFeatures());
    	MinecraftForge.EVENT_BUS.register(new ModBiomes());
    	
    	ComposterBlock.COMPOSTABLES.put(Items.POISONOUS_POTATO, 0.65F); //Fixes the annoyance.
    	ComposterBlock.COMPOSTABLES.put(ModItems.SWEETBERRY_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.APPLE_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHER_APPLE.get(), 0.65F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHER_APPLE_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_LEAVES.get(), 0.3F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_SAPLING.get(), 0.3F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_LEAF_CARPET.get(), 0.3F);
    }
    
    @OnlyIn(Dist.CLIENT)
	private void setupClient(final FMLClientSetupEvent event)
    {
    	// Set up the kiln recipe categories.
    	RecipeBookRegistry.addCategoriesToType(ModRecipes.KILN_RECIPE_BOOK, ModRecipeBookCategories.KILN_CATEGORIES);
    	RecipeBookRegistry.addAggregateCategories(ModRecipeBookCategories.KILN_SEARCH, ModRecipeBookCategories.KILN_CATEGORIES);
    	RecipeBookRegistry.addCategoriesFinder(ModRecipeType.KILN.get(), rc -> ModRecipeBookCategories.KILN_BLOCKS );
    	RecipeBookRegistry.addCategoriesFinder(ModRecipeType.KILN.get(), rc -> ModRecipeBookCategories.KILN_MISC );
    	// Set up the client renderers.
		ClientRenderSetup.setup();
    }
    
}