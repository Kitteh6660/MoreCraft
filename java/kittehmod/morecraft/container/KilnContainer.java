package kittehmod.morecraft.container;

import kittehmod.morecraft.item.crafting.ModRecipeType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class KilnContainer extends AbstractFurnaceMenu
{
	public KilnContainer(int id, Inventory playerInventoryIn) {
		super(ModContainerType.KILN.get(), ModRecipeType.KILN, RecipeBookType.FURNACE, id, playerInventoryIn);
	}

	public KilnContainer(int id, Inventory playerInventoryIn, Container furnaceInventoryIn, ContainerData contDataIn) {
		super(ModContainerType.KILN.get(), ModRecipeType.KILN, RecipeBookType.FURNACE, id, playerInventoryIn, furnaceInventoryIn, contDataIn);
	}
}
