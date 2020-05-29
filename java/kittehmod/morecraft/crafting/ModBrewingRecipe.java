package kittehmod.morecraft.crafting;

import javax.annotation.Nonnull;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class ModBrewingRecipe implements IBrewingRecipe {

    private final ItemStack input;
    private final ItemStack ingredient;
    private final ItemStack output;
	
	public ModBrewingRecipe(ItemStack input, ItemStack ingredient, ItemStack output) {
		this.input = input;
		this.ingredient = ingredient;
		this.output = output;
	}
	
	@Override
	public boolean isInput(@Nonnull ItemStack inputIn) {
		return inputIn.getItem() == input.getItem();
	}

	@Override
	public boolean isIngredient(@Nonnull ItemStack ingredientIn) {
		return ingredientIn.getItem() == ingredient.getItem();
	}

	@Override
	public ItemStack getOutput(@Nonnull ItemStack inputIn, @Nonnull ItemStack ingredientIn) {
		if (isInput(inputIn) && isIngredient(ingredientIn)) {
			return output.copy();
		}
		return ItemStack.EMPTY;
	}

}
