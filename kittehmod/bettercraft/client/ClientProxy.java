package kittehmod.bettercraft.client;

import java.util.HashMap;
import java.util.Map;

import kittehmod.bettercraft.CommonProxy;
import kittehmod.bettercraft.ModelEnderdragonArmor;
import kittehmod.bettercraft.ModelEnderdragonLegs;
import kittehmod.bettercraft.MoreCraftItems;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import kittehmod.bettercraft.TileEntityNetherwoodChestRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	@Override
	public void registerRenderers()
	{
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
		
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherwoodChest.class, new TileEntityNetherwoodChestRenderer());
		//ClientRegistry.registerItemRenderer(Item.getItemFromBlock(BetterCraftBlocks.NetherWoodChest), new ItemNetherwoodChestRenderer());
		
		ModelEnderdragonArmor enderdragon_armor = new ModelEnderdragonArmor(1F);
		ModelEnderdragonLegs enderdragon_legs = new ModelEnderdragonLegs(0.5F);
		
		armorModels.put(MoreCraftItems.enderdragon_helmet, enderdragon_armor);
		armorModels.put(MoreCraftItems.enderdragon_chestplate, enderdragon_armor);
		armorModels.put(MoreCraftItems.enderdragon_leggings, enderdragon_legs);
		armorModels.put(MoreCraftItems.enderdragon_boots, enderdragon_armor);
	}
	
	/*public int addArmor(String armor) 
	{
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }*/
}