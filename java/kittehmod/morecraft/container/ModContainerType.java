package kittehmod.morecraft.container;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import kittehmod.morecraft.container.addons.ModCrateContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType
{
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MoreCraft.MODID);

	public static RegistryObject<MenuType<KilnContainer>> KILN = CONTAINERS.register("kiln", () -> new MenuType<KilnContainer>(KilnContainer::new));
	public static RegistryObject<MenuType<ModCrateContainer>> CRATE = CONTAINERS.register("crate", () -> new MenuType<ModCrateContainer>(ModCrateContainer::new));
	public static RegistryObject<MenuType<ModBookcaseContainer>> BOOKCASE = CONTAINERS.register("bookcase", () -> new MenuType<ModBookcaseContainer>(ModBookcaseContainer::new));
	
	@Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<MenuType<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }
}
