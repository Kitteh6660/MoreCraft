package kittehmod.morecraft.client;

import kittehmod.morecraft.MoreCraftBlocks;
import kittehmod.morecraft.TileEntityNetherwoodChest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class ItemNetherwoodChestRenderer extends TileEntityItemStackRenderer {
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        //Your custom block
        if (block == MoreCraftBlocks.NETHERWOOD_CHEST || block == MoreCraftBlocks.NETHERWOOD_CHEST_TRAPPED) {
            TileEntityRendererDispatcher.instance.render(new TileEntityNetherwoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
        } else {
        //for minecraft to render its own tile entities such as the chest
        	super.renderByItem(itemStack);
        }
    }
}
