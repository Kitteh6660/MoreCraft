package kittehmod.morecraft;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class NetherWorkbenchContainer extends WorkbenchContainer
{
	private final CraftingInventory field_75162_e = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory field_75160_f = new CraftResultInventory();
	private final IWorldPosCallable field_217070_e;
	
	public NetherWorkbenchContainer(int p_i50089_1_, PlayerInventory p_i50089_2_) {
		this(p_i50089_1_, p_i50089_2_, IWorldPosCallable.DUMMY);
	}

	public NetherWorkbenchContainer(int p_i50090_1_, PlayerInventory p_i50090_2_, IWorldPosCallable p_i50090_3_) {
		super(p_i50090_1_,  p_i50090_2_,  p_i50090_3_);
		this.field_217070_e = p_i50090_3_;
		this.addSlot(new CraftingResultSlot(p_i50090_2_.player, this.field_75162_e, this.field_75160_f, 0, 124, 35));

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.field_75162_e, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for(int k = 0; k < 3; ++k) {
			for(int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(p_i50090_2_, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for(int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(p_i50090_2_, l, 8 + l * 18, 142));
		}
	}

   /**
    * Determines whether supplied player can use this container
    */
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(this.field_217070_e, playerIn, ModBlocks.NETHERWOOD_CRAFTING_TABLE.get());
	}

}