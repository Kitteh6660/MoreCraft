package kittehmod.morecraft.client;

import com.mojang.blaze3d.platform.GlStateManager;

import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.item.ModSkullItem;
import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodChestTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
	
	public static final NetherwoodChestTileEntity NETHERWOOD_CHEST = new NetherwoodChestTileEntity();
	public static final NetherwoodTrappedChestTileEntity NETHERWOOD_CHEST_TRAPPED = new NetherwoodTrappedChestTileEntity();
	public static final NetherwoodSignTileEntity NETHERWOOD_SIGN = new NetherwoodSignTileEntity();
	public static final ModSkullTileEntity MOD_SKULL = new ModSkullTileEntity();
	
    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderByItem(ItemStack itemStack) {
        //Your custom block
        if (itemStack.getItem() == ModItems.NETHERWOOD_CHEST.get()) {
            TileEntityRendererDispatcher.instance.renderAsItem(NETHERWOOD_CHEST);
        } else if (itemStack.getItem() == ModItems.NETHERWOOD_TRAPPED_CHEST.get()) {
        	TileEntityRendererDispatcher.instance.renderAsItem(NETHERWOOD_CHEST_TRAPPED);
        } else if (itemStack.getItem() instanceof ModSkullItem) {
        	if (ModSkullTileEntityRenderer.instance != null) {
        		GlStateManager.pushMatrix();
        		GlStateManager.disableCull();
        		ModSkullTileEntityRenderer.instance.render(0.0F, 0.0F, 0.0F, (Direction)null, 180.0F, ((AbstractSkullBlock)((BlockItem)itemStack.getItem()).getBlock()).getSkullType(), null, -1, 0.0F);
        		GlStateManager.enableCull();
        		GlStateManager.popMatrix();
        	}
        } else {
        	super.renderByItem(itemStack); //for minecraft to render its own tile entities such as the chest
        }
    }
}
