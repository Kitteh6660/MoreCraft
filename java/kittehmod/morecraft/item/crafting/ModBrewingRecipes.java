package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.item.ModPotions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModBrewingRecipes 
{	
	
	public static void registerRecipes() {
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD), new ItemStack(ModItems.ENDERDRAGON_SCALES.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get()), new ItemStack(Items.REDSTONE), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get()), new ItemStack(Items.GLOWSTONE_DUST), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_HEALTH_BOOST.get())));
		
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD), new ItemStack(ModItems.GUARDIAN_SCALES.get()), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get()), new ItemStack(Items.REDSTONE), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_RESISTANCE.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.RESISTANCE.get()), new ItemStack(Items.GLOWSTONE_DUST), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_RESISTANCE.get())));

		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD), new ItemStack(Items.PRISMARINE_CRYSTALS), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GLOWING.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GLOWING.get()), new ItemStack(Items.REDSTONE), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_GLOWING.get())));

	}

}
