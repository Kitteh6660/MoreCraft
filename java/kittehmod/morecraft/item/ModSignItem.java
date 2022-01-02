package kittehmod.morecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;

public class ModSignItem extends SignItem {
	
	public ModSignItem(Item.Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		if (stack.getItem() == ModItems.NETHERWOOD_SIGN.get()) {
			return -1; // Netherwood Sign is not burnable.
		}
		else {
			return 200; 
		}
	}
}
