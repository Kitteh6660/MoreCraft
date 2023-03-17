package kittehmod.morecraft.container;

import kittehmod.morecraft.item.crafting.ModRecipeType;
import kittehmod.morecraft.item.crafting.ModRecipes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;

public class KilnContainer extends AbstractFurnaceMenu
{
	public KilnContainer(int id, Inventory playerInventoryIn) {
		super(ModContainerType.KILN.get(), ModRecipeType.KILN.get(), ModRecipes.KILN_RECIPE_BOOK, id, playerInventoryIn);
	}

	public KilnContainer(int id, Inventory playerInventoryIn, Container furnaceInventoryIn, ContainerData contDataIn) {
		super(ModContainerType.KILN.get(), ModRecipeType.KILN.get(), ModRecipes.KILN_RECIPE_BOOK, id, playerInventoryIn, furnaceInventoryIn, contDataIn);
	}
}
