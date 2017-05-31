package kittehmod.bettercraft.client;

import java.util.HashMap;
import java.util.Map;

import kittehmod.bettercraft.CommonProxy;
import kittehmod.bettercraft.MoreCraftItems;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import kittehmod.bettercraft.entity.EntityNetherwoodBoat;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.config.GuiConfigEntries.IConfigEntry;
import net.minecraftforge.fml.client.config.GuiConfigEntries.NumberSliderEntry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	@Override
	public void registerRenderersPreInit()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherwoodBoat.class, new IRenderFactory() {
			@Override public Render<? super EntityNetherwoodBoat> createRenderFor(RenderManager manager) { return new RenderNetherwoodBoat(manager); }	
		});
	}
	
	@Override
	public void registerRenderers()
	{
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
		
		// This is for rendering entities and so forth later on
		TileEntityItemStackRenderer.instance = new ItemNetherwoodChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherwoodChest.class, new RenderNetherwoodChest());
		
		ModelEnderdragonArmor enderdragon_armor = new ModelEnderdragonArmor(1F);
		ModelEnderdragonLegs enderdragon_legs = new ModelEnderdragonLegs(0.5F);
		
		armorModels.put(MoreCraftItems.ENDERDRAGON_HELMET, enderdragon_armor);
		armorModels.put(MoreCraftItems.ENDERDRAGON_CHESTPLATE, enderdragon_armor);
		armorModels.put(MoreCraftItems.ENDERDRAGON_LEGGINGS, enderdragon_legs);
		armorModels.put(MoreCraftItems.ENDERDRAGON_BOOTS, enderdragon_armor);
	}
	
	public Class<? extends IConfigEntry> getSliderClass()
	{
		return NumberSliderEntry.class;
	}
}