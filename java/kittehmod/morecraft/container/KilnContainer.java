package kittehmod.morecraft.container;

import kittehmod.morecraft.item.crafting.IModRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class KilnContainer extends AbstractFurnaceContainer
{
	public KilnContainer(int id, PlayerInventory playerInventoryIn) {
		super(ModContainerType.KILN.get(), IModRecipeType.KILN, RecipeBookCategory.FURNACE, id, playerInventoryIn);
	}

	public KilnContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50083_4_) {
		super(ModContainerType.KILN.get(), IModRecipeType.KILN, RecipeBookCategory.FURNACE, id, playerInventoryIn, furnaceInventoryIn, p_i50083_4_);
	}
}
