package kittehmod.bettercraft.item;
import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.block.BlockNormalSlabDouble;
import kittehmod.bettercraft.block.BlockNormalSlabHalf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemEnderbrickSlab extends ItemSlab
{
    public ItemEnderbrickSlab(final Block block, final BlockNormalSlabHalf slab, final BlockNormalSlabDouble doubleSlab, final Boolean stacked) {
        super(block, slab, doubleSlab);
    }
}