package kittehmod.morecraft.blockentity.addons;

import java.util.stream.IntStream;

import javax.annotation.Nullable;

import kittehmod.morecraft.blockentity.ModBlockEntityType;
import kittehmod.morecraft.container.addons.CrateSlot;
import kittehmod.morecraft.container.addons.ModCrateContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModCrateBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer
{
	private static final int[] SLOTS = IntStream.range(0, 9).toArray();
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(9, ItemStack.EMPTY);
	private ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
		protected void onOpen(Level p_155062_, BlockPos p_155063_, BlockState p_155064_) {
			ModCrateBlockEntity.this.playSound(p_155064_, SoundEvents.BARREL_OPEN);
		}

		protected void onClose(Level p_155072_, BlockPos p_155073_, BlockState p_155074_) {
			ModCrateBlockEntity.this.playSound(p_155074_, SoundEvents.BARREL_CLOSE);
		}

		protected void openerCountChanged(Level p_155066_, BlockPos p_155067_, BlockState p_155068_, int p_155069_, int p_155070_) {
		}

		protected boolean isOwnContainer(Player p_155060_) {
			if (p_155060_.containerMenu instanceof ChestMenu) {
				Container container = ((ChestMenu) p_155060_.containerMenu).getContainer();
				return container == ModCrateBlockEntity.this;
			} else {
				return false;
			}
		}
	};

	public ModCrateBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityType.CRATE.get(), pos, state);
	}

	public void load(CompoundTag p_230337_2_) {
		super.load(p_230337_2_);
		this.loadFromTag(p_230337_2_);
	}

	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		if (!this.trySaveLootTable(nbt)) {
			ContainerHelper.saveAllItems(nbt, this.itemStacks, false);
		}
	}

	public void loadFromTag(CompoundTag nbt) {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(nbt) && nbt.contains("Items", this.itemStacks.size())) {
			ContainerHelper.loadAllItems(nbt, this.itemStacks);
		}
	}

	public int getContainerSize() {
		return this.itemStacks.size();
	}

	protected NonNullList<ItemStack> getItems() {
		return this.itemStacks;
	}

	protected void setItems(NonNullList<ItemStack> stackList) {
		this.itemStacks = stackList;
	}

	protected Component getDefaultName() {
		return Component.translatable("container.charm.crate");
	}

	protected AbstractContainerMenu createMenu(int syncID, Inventory playerInv) {
		return new ModCrateContainer(syncID, playerInv, this);
	}

	public void startOpen(Player p_58616_) {
		if (!this.remove && !p_58616_.isSpectator()) {
			this.openersCounter.incrementOpeners(p_58616_, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}

	}

	public void stopOpen(Player p_58614_) {
		if (!this.remove && !p_58614_.isSpectator()) {
			this.openersCounter.decrementOpeners(p_58614_, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}

	}

	public void recheckOpen() {
		if (!this.remove) {
			this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
		}
	}

	private void playSound(BlockState p_213965_1_, SoundEvent p_213965_2_) {
		Vec3i vector3i = Direction.UP.getNormal();
		double d0 = (double) this.worldPosition.getX() + 0.5D + (double) vector3i.getX() / 2.0D;
		double d1 = (double) this.worldPosition.getY() + 0.5D + (double) vector3i.getY() / 2.0D;
		double d2 = (double) this.worldPosition.getZ() + 0.5D + (double) vector3i.getZ() / 2.0D;
		this.level.playSound((Player) null, d0, d1, d2, p_213965_2_, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
	}

	@Override
	public int[] getSlotsForFace(Direction p_180463_1_) {
		return SLOTS;
	}

	@Override
	public boolean canPlaceItemThroughFace(int p_180462_1_, ItemStack stack, @Nullable Direction dir) {
		return CrateSlot.isItemAllowed(stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int p_180461_1_, ItemStack stack, Direction dir) {
		return true;
	}
}
