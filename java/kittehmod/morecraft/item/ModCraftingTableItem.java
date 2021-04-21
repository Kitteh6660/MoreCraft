package kittehmod.morecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class ModCraftingTableItem extends BlockItem
{
	public ModCraftingTableItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		if (stack.getItem() != ModItems.CRIMSON_CRAFTING_TABLE.get() && stack.getItem() != ModItems.WARPED_CRAFTING_TABLE.get() && stack.getItem() != ModItems.NETHERWOOD_CRAFTING_TABLE.get()) {
			return 300;
		}
		else {
			return -1; //Not burnable.
		}
	}
}
