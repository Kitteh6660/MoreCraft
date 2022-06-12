package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class KilnRecipe extends AbstractCookingRecipe
{
	public KilnRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookTime) {
		super(ModRecipeType.KILN.get(), id, group, ingredient, result, experience, cookTime);
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlocks.KILN.get());
	}

	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.KILN.get();
	}

}