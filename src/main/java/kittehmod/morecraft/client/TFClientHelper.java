package kittehmod.morecraft.client;

import kittehmod.morecraft.ModCompats;
import kittehmod.morecraft.MoreCraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.block.HollowLogClimbable;
import twilightforest.enums.HollowLogVariants;

public class TFClientHelper
{
	@SubscribeEvent
	public void registerBlockColours(final RegisterColorHandlersEvent.Block event) {
		if (ModCompats.TWILIGHT_FOREST_INSTALLED) {
			event.register((state, getter, pos, index) -> {
				if (state.getValue(HollowLogClimbable.VARIANT) != HollowLogVariants.Climbable.VINE || (index & 1) == 0) { 
					return 0xFFFFFF; 
				} else { 
					if (getter != null && pos != null) {
						return BiomeColors.getAverageFoliageColor(getter, pos);
					} else {
						return FoliageColor.getDefaultColor();
					}
				}
			}, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreCraft.MODID, "hollow_netherwood_log_climbable")));
		}
	}
}
