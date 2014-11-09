package kittehmod.bettercraft.item;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import kittehmod.bettercraft.TileEntityNetherwoodChest;

public class ItemNetherwoodChestRenderer implements IItemRenderer 
{
	private ModelChest chestModel;
	
	public ItemNetherwoodChestRenderer() {
		chestModel = new ModelChest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityNetherwoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	
}