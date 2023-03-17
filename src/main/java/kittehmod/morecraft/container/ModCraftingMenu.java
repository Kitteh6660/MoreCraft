package kittehmod.morecraft.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

public class ModCraftingMenu extends CraftingMenu
{
	private final ContainerLevelAccess access;
	private final Block block;

	public ModCraftingMenu(int id, Inventory playerInventoryIn, Block blockIn) {
		this(id, playerInventoryIn, ContainerLevelAccess.NULL, blockIn);
	}

	public ModCraftingMenu(int p_39356_, Inventory p_39357_, ContainerLevelAccess p_39358_, Block blockIn) {
		super(p_39356_, p_39357_, p_39358_);
		this.access = p_39358_;
		this.block = blockIn;
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player playerIn) {
		return stillValid(this.access, playerIn, block);
	}

}