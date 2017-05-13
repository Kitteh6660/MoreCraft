package kittehmod.bettercraft.item;

import kittehmod.bettercraft.block.BlockNormalSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
* Wrapper around ItemSlab to allow init from GameRegistry.
*
*/
public class ItemNormalSlab extends ItemSlab {

    public ItemNormalSlab(Block block, BlockNormalSlab.Half slab, BlockNormalSlab.Double doubleSlab, Boolean stacked) {
        super(block, slab, doubleSlab);
    }
}