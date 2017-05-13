package kittehmod.bettercraft;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationEvents {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) 
	{
		System.out.println("Attempt to sync.");
	    if(eventArgs.getModID().equals("bettercraft")) MoreCraft.syncConfig();
	}
}


