package kittehmod.morecraft.container;

import kittehmod.morecraft.entity.CraftingTableMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class MinecartWorkbenchContainer extends WorkbenchContainer
{
	private final CraftingInventory craftMatrix = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory craftResult = new CraftResultInventory();
	private final CraftingTableMinecartEntity entity;

	public MinecartWorkbenchContainer(int id, PlayerInventory playerInventoryIn, CraftingTableMinecartEntity entityIn) {
		this(id, playerInventoryIn, IWorldPosCallable.DUMMY, entityIn);
	}

	public MinecartWorkbenchContainer(int id, PlayerInventory playerInventoryIn, IWorldPosCallable worldPosIn, CraftingTableMinecartEntity entityIn) {
		super(id, playerInventoryIn, worldPosIn);
		this.entity = entityIn;
		this.addSlot(new CraftingResultSlot(playerInventoryIn.player, this.craftMatrix, this.craftResult, 0, 124, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.craftResult, j + i * 3, 30 + j * 18, 17 + i * 18));
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
	public boolean canInteractWith(PlayerEntity playerIn) {
		return playerIn.getDistance(this.entity) <= (net.minecraftforge.common.ForgeMod.REACH_DISTANCE.isPresent() ? playerIn.getAttributeValue(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()) : 5);
	}
}
