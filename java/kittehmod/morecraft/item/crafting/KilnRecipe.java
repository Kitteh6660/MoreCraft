package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class KilnRecipe extends AbstractCookingRecipe
{
	public KilnRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookTime) {
		super(IModRecipeType.KILN, id, group, ingredient, result, experience, cookTime);
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlocks.KILN.get());
	}

	public IRecipeSerializer<?> getSerializer() {
		return ModRecipes.KILN.get();
	}

	public boolean canFit(int width, int height) {
		return this.getType() == IModRecipeType.KILN;
	}

}