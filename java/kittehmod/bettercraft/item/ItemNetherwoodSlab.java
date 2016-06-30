package kittehmod.bettercraft.item;
import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemNetherwoodSlab extends ItemSlab
{
    public ItemNetherwoodSlab(Block block)
    {
	    super(block, (BlockSlab)BetterCraft.NetherWoodSlab, (BlockSlab)BetterCraft.NetherWoodSlabFull, false);
	    this.setHasSubtypes(true);
    }
}