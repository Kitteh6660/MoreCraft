package kittehmod.morecraft.client;

import com.mojang.blaze3d.matrix.MatrixStack;

import kittehmod.morecraft.block.ModChestBlock;
import kittehmod.morecraft.block.ModTrappedChestBlock;
import kittehmod.morecraft.tileentity.NetherwoodChestTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemStackTileEntityRenderer<T extends TileEntity> extends ItemStackTileEntityRenderer {
	
	private ChestTileEntity chestTileEntity = null;
	  
    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderByItem(ItemStack itemStackIn, ItemCameraTransforms.TransformType transformTypeIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
    	final Item item = itemStackIn.getItem();
    	if (item instanceof BlockItem) {
    		final Block block = ((BlockItem) item).getBlock();
    		if (block instanceof ModChestBlock) {
    			if (this.chestTileEntity == null) {
    				this.chestTileEntity = (NetherwoodChestTileEntity) ((ModChestBlock) block).getTileEntityType().create();
    			}
    		}
    		if (block instanceof ModTrappedChestBlock) {
    			if (this.chestTileEntity == null) {
    				this.chestTileEntity = (NetherwoodTrappedChestTileEntity) ((ModTrappedChestBlock) block).getTileEntityType().create();
    			}
    		}
    	}
    	assert chestTileEntity != null;
    	TileEntityRendererDispatcher.instance.renderItem(this.chestTileEntity, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
    }
}
