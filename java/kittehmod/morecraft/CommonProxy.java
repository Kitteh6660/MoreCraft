package kittehmod.morecraft;

import javax.annotation.Nullable;

import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;

public class CommonProxy 
{
	// Client stuff
	public void registerRenderersPreInit() {}
	public void registerRenderers() {}
	
	@Nullable
	public Class<? extends IConfigEntry> getSliderClass()
	{
		return null;
	}
}