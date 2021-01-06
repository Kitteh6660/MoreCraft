package kittehmod.morecraft.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class ModWorkbenchContainer extends WorkbenchContainer
{
	private final CraftingInventory inventory = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory result = new CraftResultInventory();
	private final IWorldPosCallable worldPosCallable;
	private final Block block;
	
	public ModWorkbenchContainer(int id, PlayerInventory playerInventoryIn, Block blockIn) {
		this(id, playerInventoryIn, IWorldPosCallable.DUMMY, blockIn);
	}

	public ModWorkbenchContainer(int id, PlayerInventory playerInventoryIn, IWorldPosCallable worldPosIn, Block blockIn) {
		super(id,  playerInventoryIn,  worldPosIn);
		this.worldPosCallable = worldPosIn;
		this.block = blockIn;
		this.addSlot(new CraftingResultSlot(playerInventoryIn.player, this.inventory, this.result, 0, 124, 35));

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.result, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for(int k = 0; k < 3; ++k) {
			for(int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(playerInventoryIn, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for(int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(playerInventoryIn, l, 8 + l * 18, 142));
		}
	}

   /**
    * Determines whether supplied player can use this container
    */
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(this.worldPosCallable, playerIn, block);
	}

}