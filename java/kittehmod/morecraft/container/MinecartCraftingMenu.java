package kittehmod.morecraft.container;

import net.minecraftforge.common.ForgeMod;
import kittehmod.morecraft.entity.MinecartCraftingTable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.inventory.Slot;

public class MinecartCraftingMenu extends CraftingMenu
{
	private final CraftingContainer craftSlots = new CraftingContainer(this, 3, 3);
	private final ResultContainer resultSlots = new ResultContainer();
	private final MinecartCraftingTable entity;

	public MinecartCraftingMenu(int id, Inventory playerInventoryIn, MinecartCraftingTable entityIn) {
		this(id, playerInventoryIn, ContainerLevelAccess.NULL, entityIn);
	}

	public MinecartCraftingMenu(int id, Inventory playerInventoryIn, ContainerLevelAccess worldPosIn, MinecartCraftingTable entityIn) {
		super(id, playerInventoryIn, worldPosIn);
		this.entity = entityIn;
		this.addSlot(new ResultSlot(playerInventoryIn.player, this.craftSlots, this.resultSlots, 0, 124, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(playerInventoryIn, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(playerInventoryIn, l, 8 + l * 18, 142));
		}
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player playerIn) {
		return playerIn.distanceTo(this.entity) <= (ForgeMod.REACH_DISTANCE.isPresent() ? playerIn.getAttributeValue(ForgeMod.REACH_DISTANCE.get()) : 5);
	}
}
