package kittehmod.bettercraft.client;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import kittehmod.bettercraft.BetterCraft;
import kittehmod.bettercraft.CommonProxy;
import kittehmod.bettercraft.ModelEnderdragonArmor;
import kittehmod.bettercraft.ModelEnderdragonLegs;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import kittehmod.bettercraft.TileEntityNetherwoodChestRenderer;
import kittehmod.bettercraft.item.ItemNetherwoodChestRenderer;

public class ClientProxy extends CommonProxy
{
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	@Override
	public void registerRenderers()
	{
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherwoodChest.class, new TileEntityNetherwoodChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BetterCraft.NetherWoodChest), new ItemNetherwoodChestRenderer());
		
		ModelEnderdragonArmor enderdragon_armor = new ModelEnderdragonArmor(1F);
		ModelEnderdragonLegs enderdragon_legs = new ModelEnderdragonLegs(0.5F);
		
		armorModels.put(BetterCraft.helmetEnderdragon, enderdragon_armor);
		armorModels.put(BetterCraft.chestplateEnderdragon, enderdragon_armor);
		armorModels.put(BetterCraft.leggingsEnderdragon, enderdragon_legs);
		armorModels.put(BetterCraft.bootsEnderdragon, enderdragon_armor);
	}
	
	public int addArmor(String armor) 
	{
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}