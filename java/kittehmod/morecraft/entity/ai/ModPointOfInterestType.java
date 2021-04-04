package kittehmod.morecraft.entity.ai;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModPointOfInterestType
{
	public static final DeferredRegister<PointOfInterestType> POINTS_OF_INTERESTS = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreCraft.MODID);
	
	//public static final RegistryObject<PointOfInterestType> MOD_BEEHIVES = POINTS_OF_INTERESTS.register("mod_beehive", () -> new PointOfInterestType("morecraft_beehive", PointOfInterestType.getBlockStates(ModBlocks.NETHERWOOD_BEEHIVE.get()), 0, 1));
	public static final RegistryObject<PointOfInterestType> KILN = POINTS_OF_INTERESTS.register("kiln", () -> new PointOfInterestType("kiln", PointOfInterestType.getBlockStates(ModBlocks.KILN.get()), 0, 1));
	
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
	    public static void registerPOIs(final RegistryEvent.Register<PointOfInterestType> event) { 
	    	event.getRegistry().registerAll();
	    }
	    
	}
}
