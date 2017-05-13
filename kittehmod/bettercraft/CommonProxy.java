package kittehmod.bettercraft;

import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;
import net.minecraftforge.fml.client.config.GuiConfigEntries.NumberSliderEntry;


public class CommonProxy 
{

	// Client stuff
	public void registerRenderers() 
	{

	}
	
	/*public void registerNetwork(){
		NetworkRegistry.INSTANCE.registerGuiHandler(BetterCraft, new GuiHandler());
	}*/
	
	public int addArmor(String armor)
    {
        return 0; 
    }
	
	public Class<? extends IConfigEntry> getSliderClass()
	{
		return NumberSliderEntry.class;
	}
}