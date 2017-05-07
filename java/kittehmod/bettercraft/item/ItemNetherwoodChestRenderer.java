package kittehmod.bettercraft.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import kittehmod.bettercraft.TileEntityNetherwoodChest;

public class ItemNetherwoodChestRenderer implements IItemRenderer 
{
	 TileEntitySpecialRenderer render;
	 private TileEntity tileentity;
	
	public ItemNetherwoodChestRenderer(TileEntitySpecialRenderer render, TileEntity tileentity) {
		 this.render = render;
		 this.tileentity = tileentity;
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
		if (type == IItemRenderer.ItemRenderType.ENTITY) {
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		}
		GL11.glScalef(1.4F, 1.4F, 1.4F);
		this.render.renderTileEntityAt(tileentity, 0.0D, 0.0D, 0.0D, 0.0F);
		//TileEntityRendererDispatcher.instance.renderTileEntityAt(tileentity, 0.0D, 0.0D, 0.0D, 0.0F);
	}
	
}