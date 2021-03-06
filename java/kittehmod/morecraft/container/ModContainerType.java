package kittehmod.morecraft.container;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType
{
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MoreCraft.MODID);

	public static RegistryObject<ContainerType<KilnContainer>> KILN = CONTAINERS.register("kiln", () -> new ContainerType<KilnContainer>(KilnContainer::new));
	
	@Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }
}
