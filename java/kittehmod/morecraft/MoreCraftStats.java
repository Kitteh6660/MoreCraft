package kittehmod.morecraft;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class MoreCraftStats
{
	public static final ResourceLocation INTERACT_WITH_KILN = makeCustomStat("morecraft:interact_with_kiln", StatFormatter.DEFAULT);

	private static ResourceLocation makeCustomStat(String p_13008_, StatFormatter p_13009_) {
		ResourceLocation resourcelocation = new ResourceLocation(p_13008_);
		Registry.register(Registry.CUSTOM_STAT, p_13008_, resourcelocation);
		Stats.CUSTOM.get(resourcelocation, p_13009_);
		return resourcelocation;
	}
}
