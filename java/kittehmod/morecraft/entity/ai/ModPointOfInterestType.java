package kittehmod.morecraft.entity.ai;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class ModPointOfInterestType
{
	public static final DeferredRegister<PoiType> POINTS_OF_INTERESTS = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreCraft.MODID);
	
	//public static final RegistryObject<PointOfInterestType> MOD_BEEHIVES = POINTS_OF_INTERESTS.register("mod_beehive", () -> new PointOfInterestType("morecraft_beehive", PointOfInterestType.getBlockStates(ModBlocks.NETHERWOOD_BEEHIVE.get()), 0, 1));
	public static final RegistryObject<PoiType> KILN = POINTS_OF_INTERESTS.register("kiln", () -> new PoiType("kiln", PoiType.getBlockStates(ModBlocks.KILN.get()), 0, 1));
	
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(MoreCraft.MODID, name));
		}

		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
		
	    @SubscribeEvent
	    public static void registerPOIs(final RegistryEvent.Register<PoiType> event) { 
	    	event.getRegistry().registerAll();
	    }
	    
	}
}
