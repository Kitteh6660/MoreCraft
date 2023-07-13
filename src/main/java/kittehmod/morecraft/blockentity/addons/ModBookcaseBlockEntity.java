package kittehmod.morecraft.blockentity.addons;

import java.util.stream.IntStream;

import javax.annotation.Nullable;

import kittehmod.morecraft.block.addons.ModBookcaseBlock;
import kittehmod.morecraft.container.addons.BookcaseSlot;
import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModBookcaseBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer
{
	public static int SIZE = 18;
	private static final int[] SLOTS = IntStream.range(0, SIZE).toArray();
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(SIZE, ItemStack.EMPTY);

	public ModBookcaseBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityType.BOOKCASE.get(), pos, state);
	}

	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.loadFromTag(nbt);
	}

	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		if (!this.trySaveLootTable(nbt)) {
			ContainerHelper.saveAllItems(nbt, this.itemStacks, false);
		}
	}

	public void loadFromTag(CompoundTag nbt) {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(nbt)) {
			ContainerHelper.loadAllItems(nbt, this.itemStacks);
		}
	}

	public int getContainerSize() {
		return SIZE;
	}
	
	protected NonNullList<ItemStack> getItems() {
		return this.itemStacks;
	}

	protected void setItems(NonNullList<ItemStack> list) {
		this.itemStacks = list;
	}

	protected Component getDefaultName() {
		return Component.translatable("container.charm.bookcase");
	}
	
	@Nullable
	@Override
	public Component getCustomName() {
		return Component.translatable("container.charm.bookcase");
	}

	@Override
	protected AbstractContainerMenu createMenu(int syncID, Inventory playerInv) {
		return new ModBookcaseContainer(syncID, playerInv, this);
	}

	@Override
	public void setItem(int slot, ItemStack stack) {
		super.setItem(slot, stack);
		updateBlockState();
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return SLOTS;
	}

	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction dir) {
		return BookcaseSlot.ALLOWED_ITEMS.contains(stack.getItem());
	}

	@Override
	public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
		return true;
	}

	@Override
	public void startOpen(Player player) {
		player.level().playSound(null, this.getBlockPos(), SoundEvents.CHISELED_BOOKSHELF_PICKUP, SoundSource.BLOCKS, 0.5f, player.level().getRandom().nextFloat() * 0.1F + 0.9F);
	}

	@Override
	public void stopOpen(Player player) {
		player.level().playSound(null, this.getBlockPos(), SoundEvents.CHISELED_BOOKSHELF_INSERT, SoundSource.BLOCKS, 0.5f, player.level().getRandom().nextFloat() * 0.1F + 0.9F);
		
	}
	
	@Override
	public void setChanged() {
		updateBlockState();
		super.setChanged();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : this.itemStacks) {
			if (!stack.isEmpty())
				return false;
		}
		return true;
	}

	protected void updateBlockState() {
		int filled = 0;
		for (int i = 0; i < SIZE; i++) {
			if (level == null) continue;
			ItemStack stack = getItem(i);
			if (!stack.isEmpty()) {
				filled++;
			}
		}
		if (level != null && level.getBlockState(this.getBlockPos()).getBlock() instanceof ModBookcaseBlock) {
			level.setBlock(this.getBlockPos(), level.getBlockState(this.getBlockPos()).setValue(ModBookcaseBlock.SLOTS, filled), 2);
		}
	}

}
