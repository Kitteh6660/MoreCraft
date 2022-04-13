package kittehmod.morecraft.item.crafting;

import java.util.Optional;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public interface ModRecipeType<T extends Recipe<?>>
{
	RecipeType<KilnRecipe> KILN = register("morecraft:kiln");

	static <T extends Recipe<?>> RecipeType<T> register(final String key) {
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new RecipeType<T>() {
			public String toString() {
				return key;
			}
		});
	}

	@SuppressWarnings("unchecked")
	default <C extends Inventory> Optional<T> matches(Recipe<C> recipe, Level worldIn, C inv) {
		return recipe.matches(inv, worldIn) ? Optional.of((T) recipe) : Optional.empty();
	}
}
