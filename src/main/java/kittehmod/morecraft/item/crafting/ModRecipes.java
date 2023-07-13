package kittehmod.morecraft.item.crafting;

import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipes
{
	public static final RecipeSerializer<KilnRecipe> KILN = new SimpleCookingSerializer<>(KilnRecipe::new, 100);

	public static final RecipeBookType KILN_RECIPE_BOOK = RecipeBookType.create("morecraft:kiln");
	
    public static void registerRecipeTypes() {
    	ForgeRegistries.RECIPE_SERIALIZERS.register("morecraft:kiln", KILN);
	}
}
