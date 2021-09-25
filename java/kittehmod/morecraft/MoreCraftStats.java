package kittehmod.morecraft;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class MoreCraftStats
{
	public static final ResourceLocation INTERACT_WITH_KILN = makeCustomStat("morecraft:interact_with_kiln", StatFormatter.DEFAULT);

	private static ResourceLocation makeCustomStat(String p_199084_0_, StatFormatter p_199084_1_) {
		ResourceLocation resourcelocation = new ResourceLocation(p_199084_0_);
		Registry.register(Registry.CUSTOM_STAT, p_199084_0_, resourcelocation);
		Stats.CUSTOM.get(resourcelocation, p_199084_1_);
		return resourcelocation;
	}
}
