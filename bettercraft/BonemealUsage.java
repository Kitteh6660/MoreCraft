package kittehmod.bettercraft;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealUsage
{
	@ForgeSubscribe
	public void UseBonemeal(BonemealEvent event) 
	{
		if (event.ID == BetterCraft.NetherSapling.blockID) 
		{
			if (!event.world.isRemote) 
			{
				((BlockNetherSapling) BetterCraft.NetherSapling).growTree(event.world, event.X, event.Y, event.Z,event.world.rand);
			}
			event.setResult(Result.ALLOW);// allow the bonemeal consumption and
											// prevent other possible effects
		}
	}
}
