package kittehmod.morecraft.container.addons;

import kittehmod.morecraft.block.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;

public class CrateSlot extends Slot
{
	public CrateSlot(IInventory p_i47265_1_, int p_i47265_2_, int p_i47265_3_, int p_i47265_4_) {
		super(p_i47265_1_, p_i47265_2_, p_i47265_3_, p_i47265_4_);
	}

	public boolean mayPlace(ItemStack stack) {
		return !(Block.byItem(stack.getItem()).is(ModBlockTags.CRATES) || Block.byItem(stack.getItem()).is(BlockTags.SHULKER_BOXES));
	}
}
