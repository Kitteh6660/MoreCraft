package kittehmod.morecraft.crafting;

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
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD), new ItemStack(ModItems.ENDERDRAGON_SCALES.get()), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get()), new ItemStack(Items.REDSTONE), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModPotions.LONG_HEALTH_BOOST.get())));
		BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModPotions.HEALTH_BOOST.get()), new ItemStack(Items.GLOWSTONE_DUST), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModPotions.STRONG_HEALTH_BOOST.get())));
	}

}
