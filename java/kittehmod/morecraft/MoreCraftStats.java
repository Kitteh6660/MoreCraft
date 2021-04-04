package kittehmod.morecraft;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class MoreCraftStats
{
	public static final ResourceLocation INTERACT_WITH_KILN = makeCustomStat("interact_with_kiln", IStatFormatter.DEFAULT);

	private static ResourceLocation makeCustomStat(String p_199084_0_, IStatFormatter p_199084_1_) {
		ResourceLocation resourcelocation = new ResourceLocation(p_199084_0_);
		Registry.register(Registry.CUSTOM_STAT, p_199084_0_, resourcelocation);
		Stats.CUSTOM.get(resourcelocation, p_199084_1_);
		return resourcelocation;
	}
}
