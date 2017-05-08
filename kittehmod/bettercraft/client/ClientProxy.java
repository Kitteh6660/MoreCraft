package kittehmod.bettercraft.client;

import java.util.HashMap;
import java.util.Map;

import kittehmod.bettercraft.CommonProxy;
import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.MoreCraftItems;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
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
		TileEntityItemStackRenderer.instance = new ItemNetherwoodChestRenderer();
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(MoreCraftBlocks.netherwood_chest), 0, new ModelResourceLocation("bettercraft:netherwood_chest", "inventory"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherwoodChest.class, new TileEntityNetherwoodChestRenderer());

		ModelEnderdragonArmor enderdragon_armor = new ModelEnderdragonArmor(1F);
		ModelEnderdragonLegs enderdragon_legs = new ModelEnderdragonLegs(0.5F);
		
		armorModels.put(MoreCraftItems.enderdragon_helmet, enderdragon_armor);
		armorModels.put(MoreCraftItems.enderdragon_chestplate, enderdragon_armor);
		armorModels.put(MoreCraftItems.enderdragon_leggings, enderdragon_legs);
		armorModels.put(MoreCraftItems.enderdragon_boots, enderdragon_armor);
	}

}