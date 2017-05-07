package kittehmod.bettercraft;

import kittehmod.bettercraft.block.BlockNetherSapling;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealUsage
{
	@SubscribeEvent
	public void UseBonemeal(BonemealEvent event) 
	{
		if (event.block == BetterCraft.NetherSapling) 
		{
			if (!event.world.isRemote) 
			{
				((BlockNetherSapling) BetterCraft.NetherSapling).growTree(event.world, event.x, event.y, event.z,event.world.rand);
			}
			event.setResult(Result.ALLOW);// allow the bonemeal consumption and
											// prevent other possible effects
		}
	}
}
