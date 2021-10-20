package kittehmod.morecraft.tileentity.addons;

import java.util.stream.IntStream;

import javax.annotation.Nullable;

import kittehmod.morecraft.MoreCraftSounds;
import kittehmod.morecraft.block.addons.ModBookcaseBlock;
import kittehmod.morecraft.container.addons.BookcaseSlot;
import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModBookcaseTileEntity extends LockableLootTileEntity implements ISidedInventory
{
	public static int SIZE = 18;
	private static final int[] SLOTS = IntStream.range(0, SIZE).toArray();
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(SIZE, ItemStack.EMPTY);

	public ModBookcaseTileEntity() {
		super(ModTileEntityType.BOOKCASE.get());
	}

	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.loadFromTag(nbt);
	}

	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		return this.saveToTag(nbt);
	}

	public void loadFromTag(CompoundNBT nbt) {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.itemStacks);
		}
	}

	public CompoundNBT saveToTag(CompoundNBT nbt) {
		if (!this.trySaveLootTable(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.itemStacks, false);
		}
		return nbt;
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

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.charm.bookcase");
	}
	
	@Nullable
	@Override
	public ITextComponent getCustomName() {
		return new TranslationTextComponent("container.charm.bookcase");
	}

	@Override
	protected Container createMenu(int syncID, PlayerInventory playerInv) {
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
	public void startOpen(PlayerEntity player) {
		player.level.playSound(null, this.getBlockPos(), MoreCraftSounds.BOOKSHELF_OPEN.get(), SoundCategory.BLOCKS, 0.5f, player.level.random.nextFloat() * 0.1F + 0.9F);
	}

	@Override
	public void stopOpen(PlayerEntity player) {
		player.level.playSound(null, this.getBlockPos(), MoreCraftSounds.BOOKSHELF_CLOSE.get(), SoundCategory.BLOCKS, 0.5f, player.level.random.nextFloat() * 0.1F + 0.9F);
		
	}
	
	public AxisAlignedBB getBoundingBox(BlockState p_190584_1_) {
		return VoxelShapes.block().bounds();
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
