package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.init.ModItems;
import kittehmod.morecraft.item.ModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModBrewingRecipes 
{	
	
	public static void registerRecipes() {
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.of(new ItemStack(ModItems.ENDERDRAGON_SCALES.get())), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get())), Ingredient.of(new ItemStack(Items.REDSTONE)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get())), Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_HEALTH_BOOST.get())));
		
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.of(new ItemStack(ModItems.GUARDIAN_SCALES.get())), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get())));
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get())), Ingredient.of(new ItemStack(Items.REDSTONE)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_RESISTANCE.get())));
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get())), Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_RESISTANCE.get())));

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.of(new ItemStack(Items.PRISMARINE_CRYSTALS)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GLOWING.get())));
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GLOWING.get())), Ingredient.of(new ItemStack(Items.REDSTONE)), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_GLOWING.get())));
	}

}
