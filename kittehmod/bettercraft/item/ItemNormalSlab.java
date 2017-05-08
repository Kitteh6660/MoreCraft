package kittehmod.bettercraft.item;

import kittehmod.bettercraft.block.BlockNormalSlabDouble;
import kittehmod.bettercraft.block.BlockNormalSlabHalf;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
* Wrapper around ItemSlab to allow init from GameRegistry.
*
*/
public class ItemNormalSlab extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockStainedBrickSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemNormalSlab(Block block, BlockNormalSlabHalf slab, BlockNormalSlabDouble doubleSlab, Boolean stacked) {
        super(block, slab, doubleSlab);
        //System.out.println(block.getUnlocalizedName() + " " + slab.getUnlocalizedName() + " " + doubleSlab.getUnlocalizedName());
    }
}