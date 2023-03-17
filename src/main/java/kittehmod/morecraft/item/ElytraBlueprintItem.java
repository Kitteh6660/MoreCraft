package kittehmod.morecraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ElytraBlueprintItem extends Item
{

	public ElytraBlueprintItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack stack) {
		return new ItemStack(this);
	}
	
	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}
}
