package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class ModCraftingTableItem extends BlockItem
{
	public ModCraftingTableItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
		if (!stack.is(ItemTags.NON_FLAMMABLE_WOOD)) {
			return 300;
		}
		else {
			return -1; //Not burnable.
		}
	}
}
