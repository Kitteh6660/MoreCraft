package kittehmod.bettercraft.client;

import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class ItemNetherwoodChestRenderer extends TileEntityItemStackRenderer {
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        //Your custom block
        if (block == MoreCraftBlocks.NETHERWOOD_CHEST) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityNetherwoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
        } else {
        //for minecraft to render its own tile entities such as the chest
        	super.renderByItem(itemStack);
        }
    }
}
