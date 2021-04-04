package kittehmod.morecraft.item.crafting;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
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
		if (isInput(inputIn) && isIngredient(ingredientIn) && PotionUtils.getPotion(inputIn) == PotionUtils.getPotion(input)) {
			return output.copy();
		}
		return ItemStack.EMPTY;
	}

}
