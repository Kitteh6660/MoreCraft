package kittehmod.morecraft.container.addons;

import kittehmod.morecraft.container.ModContainerType;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModBookcaseContainer extends AbstractContainerMenu
{
	private final Container container;

	public ModBookcaseContainer(int p_i50065_1_, Inventory p_i50065_2_) {
		this(p_i50065_1_, p_i50065_2_, new SimpleContainer(18));
	}

	public ModBookcaseContainer(int p_i50066_1_, Inventory p_i50066_2_, Container p_i50066_3_) {
		super(ModContainerType.BOOKCASE.get(), p_i50066_1_);
		checkContainerSize(p_i50066_3_, 18);
		this.container = p_i50066_3_;
		p_i50066_3_.startOpen(p_i50066_2_.player);
		int rows = 2;
		int cols = 9;

		for (int k = 0; k < rows; ++k) {
			for (int l = 0; l < cols; ++l) {
				this.addSlot(new BookcaseSlot(p_i50066_3_, l + k * 9, 8 + l * 18, 18 + k * 18));
			}
		}

		for (int i1 = 0; i1 < 3; ++i1) {
			for (int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(p_i50066_2_, k1 + i1 * 9 + 9, 8 + k1 * 18, 67 + i1 * 18));
			}
		}

		for (int j1 = 0; j1 < cols; ++j1) {
			this.addSlot(new Slot(p_i50066_2_, j1, 8 + j1 * 18, 125));
		}

	}

	public boolean stillValid(Player p_75145_1_) {
		return this.container.stillValid(p_75145_1_);
	}

	public ItemStack quickMoveStack(Player p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(p_82846_2_);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (p_82846_2_ < this.container.getContainerSize()) {
				if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}

		return itemstack;
	}

	public void removed(Player p_75134_1_) {
		super.removed(p_75134_1_);
		this.container.stopOpen(p_75134_1_);
	}
}
