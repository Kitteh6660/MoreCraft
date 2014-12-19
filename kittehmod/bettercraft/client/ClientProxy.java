package kittehmod.bettercraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import kittehmod.bettercraft.BetterCraft;
import kittehmod.bettercraft.CommonProxy;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import kittehmod.bettercraft.TileEntityNetherwoodChestRenderer;
import kittehmod.bettercraft.item.ItemNetherwoodChestRenderer;

public class ClientProxy extends CommonProxy
{

	@Override
	public void registerRenderers()
	{
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherwoodChest.class, new TileEntityNetherwoodChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BetterCraft.NetherwoodChest), new ItemNetherwoodChestRenderer());
		
	}
	public int addArmor(String armor) 
	{
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}