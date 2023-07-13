package kittehmod.morecraft;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import kittehmod.morecraft.client.ClientHelper;
import kittehmod.morecraft.client.ClientRenderSetup;
import kittehmod.morecraft.container.ModContainerType;
import kittehmod.morecraft.effects.ModMobEffects;
import kittehmod.morecraft.enchantments.ModEnchantments;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.entity.ai.CatsSitOnChestsHandler;
import kittehmod.morecraft.events.MobEvents;
import kittehmod.morecraft.events.PlayerEvents;
import kittehmod.morecraft.init.ModBlockEntityType;
import kittehmod.morecraft.init.ModBlocks;
import kittehmod.morecraft.init.ModItems;
import kittehmod.morecraft.init.addons.ModBlueprintRegistries;
import kittehmod.morecraft.init.addons.ModFDRegistries;
import kittehmod.morecraft.init.addons.ModTFRegistries;
import kittehmod.morecraft.item.ModPotions;
import kittehmod.morecraft.item.crafting.ModBrewingRecipes;
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
import kittehmod.morecraft.worldgen.ModFeatures;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
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
    
    public static final Logger LOGGER = LogUtils.getLogger();
    
	public MoreCraft()
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); // Please let this be a normal field trip.

    	ModBlocks.BLOCKS.register(bus);
    	ModItems.ITEMS.register(bus);
    	if (ModCompats.BLUEPRINT_INSTALLED) {
    		bus.register(new ModBlueprintRegistries());
    	}
    	if (ModCompats.FARMERS_DELIGHT_INSTALLED) {
    		bus.register(new ModFDRegistries());
    	}
    	if (ModCompats.TWILIGHT_FOREST_INSTALLED) {
    		bus.register(new ModTFRegistries());
    	}
    	ModEntities.ENTITIES.register(bus);
    	ModBlockEntityType.BLOCK_ENTITIES.register(bus);
    	ModEnchantments.ENCHANTMENTS.register(bus);
    	ModPotions.POTION_TYPES.register(bus);
    	ModMobEffects.MOB_EFFECTS.register(bus);
    	ModFeatures.FEATURES.register(bus);
    	ModContainerType.CONTAINERS.register(bus);
     	ModRecipeType.RECIPE_TYPES.register(bus);
     	ModBiomeCodecs.BIOME_MODIFIER_SERIALIZERS.register(bus);
    	bus.addListener(this::setupCommon);
    	if (FMLEnvironment.dist == Dist.CLIENT) {
    		bus.addListener(this::setupClient);
    	}
        ModRecipes.registerRecipeTypes();
    }
    
    private void setupCommon(final FMLCommonSetupEvent event)
    {
        MoreCraftConfig.loadConfig(MoreCraftConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("morecraft.toml")); // Load the config first.

        ModBrewingRecipes.registerRecipes();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreCraftConfig.COMMON_CONFIG);
    	
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
    	    	
    	ComposterBlock.COMPOSTABLES.put(Items.POISONOUS_POTATO, 0.65F); //Fixes MC-142373
    	ComposterBlock.COMPOSTABLES.put(ModItems.SWEETBERRY_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.APPLE_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHER_APPLE.get(), 0.65F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHER_APPLE_PIE.get(), 1.0F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_LEAVES.get(), 0.3F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_SAPLING.get(), 0.3F);
    	ComposterBlock.COMPOSTABLES.put(ModItems.NETHERWOOD_LEAF_CARPET.get(), 0.3F);
    	
    	CauldronInteraction.WATER.put(ModItems.WOOL_HELMET.get(), CauldronInteraction.DYED_ITEM);
    	CauldronInteraction.WATER.put(ModItems.WOOL_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
    	CauldronInteraction.WATER.put(ModItems.WOOL_LEGGINGS.get(), CauldronInteraction.DYED_ITEM);
    	CauldronInteraction.WATER.put(ModItems.WOOL_BOOTS.get(), CauldronInteraction.DYED_ITEM);
    }
    
    @OnlyIn(Dist.CLIENT)
	private void setupClient(final FMLClientSetupEvent event)
    {
    	// Set up the client renderers.
    	MinecraftForge.EVENT_BUS.register(ClientHelper.class);
		ClientRenderSetup.setup();
    }
    
}