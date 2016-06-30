package kittehmod.bettercraft;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.ForgeModContainer;

public class ConfigurationEvents {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) 
	{
		System.out.println("Attempt to sync.");
	    if(eventArgs.modID.equals("bettercraft")) BetterCraft.syncConfig();
	}
}


