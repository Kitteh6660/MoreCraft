package kittehmod.morecraft;

import net.minecraftforge.fml.ModList;

public class ModCompats
{
	public static final boolean QUARK_INSTALLED = ModList.get().isLoaded("quark");
	public static final boolean BLUEPRINT_INSTALLED = ModList.get().isLoaded("blueprint");
	public static final boolean WOODWORKS_INSTALLED = ModList.get().isLoaded("woodworks");
	public static final boolean CLAYWORKS_INSTALLED = ModList.get().isLoaded("clayworks");
	public static final boolean BOATLOAD_INSTALLED = ModList.get().isLoaded("boatload");
	public static final boolean FARMERS_DELIGHT_INSTALLED = ModList.get().isLoaded("farmersdelight");
	public static final boolean TWILIGHT_FOREST_INSTALLED = ModList.get().isLoaded("twilightforest");
}
