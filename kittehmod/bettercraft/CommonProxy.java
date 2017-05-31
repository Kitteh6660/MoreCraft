package kittehmod.bettercraft;

import javax.annotation.Nullable;

import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;

public class CommonProxy 
{

	// Client stuff
	public void registerRenderers() {}
	public void registerRenderersPreInit() {}
		
	@Nullable
	public Class<? extends IConfigEntry> getSliderClass()
	{
		return null;
	}
}