package kittehmod.bettercraft.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import kittehmod.bettercraft.CommonProxy;

public class ClientProxy extends CommonProxy 
{

	@Override
	public void registerRenderers() 
	{
		// This is for rendering entities and so forth later on
	}

	public int addArmor(String armor) 
	{
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}