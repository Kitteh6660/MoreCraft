package kittehmod.morecraft.container.addons;

import kittehmod.morecraft.block.ModBlockTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class CrateSlot extends Slot
{
	public CrateSlot(Container p_i47265_1_, int p_i47265_2_, int p_i47265_3_, int p_i47265_4_) {
		super(p_i47265_1_, p_i47265_2_, p_i47265_3_, p_i47265_4_);
	}

	public boolean mayPlace(ItemStack stack) {
		return CrateSlot.isItemAllowed(stack);
	}
	
	public static boolean isItemAllowed(ItemStack stack) {
		boolean allowed = true;
		if (Block.byItem(stack.getItem()).defaultBlockState().is(ModBlockTags.CRATES)) {
			allowed = false;
		}
		if (Block.byItem(stack.getItem()).defaultBlockState().is(BlockTags.SHULKER_BOXES)) {
			allowed = false;
		}
		return allowed;
	}
}
