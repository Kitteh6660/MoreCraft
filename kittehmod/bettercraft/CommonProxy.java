package kittehmod.bettercraft;

import javax.annotation.Nullable;

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
	@Nullable
	public Class<? extends IConfigEntry> getSliderClass()
	{
		return null;
	}
}