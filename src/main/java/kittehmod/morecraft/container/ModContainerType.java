package kittehmod.morecraft.container;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import kittehmod.morecraft.container.addons.ModCrateContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainerType
{
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MoreCraft.MODID);

	public static RegistryObject<MenuType<KilnContainer>> KILN = CONTAINERS.register("kiln", () -> new MenuType<KilnContainer>(KilnContainer::new, null));
	public static RegistryObject<MenuType<ModCrateContainer>> CRATE = CONTAINERS.register("crate", () -> new MenuType<ModCrateContainer>(ModCrateContainer::new, null));
	public static RegistryObject<MenuType<ModBookcaseContainer>> BOOKCASE = CONTAINERS.register("bookcase", () -> new MenuType<ModBookcaseContainer>(ModBookcaseContainer::new, null));
}
