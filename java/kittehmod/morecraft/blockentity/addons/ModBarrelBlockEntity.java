package kittehmod.morecraft.blockentity.addons;

import kittehmod.morecraft.block.addons.ModBarrelBlock;
import kittehmod.morecraft.blockentity.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class ModBarrelBlockEntity extends RandomizableContainerBlockEntity
{
	private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
	private ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
		protected void onOpen(Level p_155062_, BlockPos p_155063_, BlockState p_155064_) {
			ModBarrelBlockEntity.this.playSound(p_155064_, SoundEvents.BARREL_OPEN);
			ModBarrelBlockEntity.this.updateBlockState(p_155064_, true);
		}

		protected void onClose(Level p_155072_, BlockPos p_155073_, BlockState p_155074_) {
			ModBarrelBlockEntity.this.playSound(p_155074_, SoundEvents.BARREL_CLOSE);
			ModBarrelBlockEntity.this.updateBlockState(p_155074_, false);
		}

		protected void openerCountChanged(Level p_155066_, BlockPos p_155067_, BlockState p_155068_, int p_155069_, int p_155070_) {
		}

		protected boolean isOwnContainer(Player p_155060_) {
			if (p_155060_.containerMenu instanceof ChestMenu) {
				Container container = ((ChestMenu) p_155060_.containerMenu).getContainer();
				return container == ModBarrelBlockEntity.this;
			} else {
				return false;
			}
		}
	};

	public ModBarrelBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityType.MOD_BARREL.get(), pos, state);
	}

	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		if (!this.trySaveLootTable(nbt)) {
			ContainerHelper.saveAllItems(nbt, this.items);
		}
	}

	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(nbt)) {
			ContainerHelper.loadAllItems(nbt, this.items);
		}

	}

	public int getContainerSize() {
		return 27;
	}

	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	protected void setItems(NonNullList<ItemStack> p_199721_1_) {
		this.items = p_199721_1_;
	}

	protected Component getDefaultName() {
		return new TranslatableComponent("container.barrel");
	}

	protected AbstractContainerMenu createMenu(int p_213906_1_, Inventory p_213906_2_) {
		return ChestMenu.threeRows(p_213906_1_, p_213906_2_, this);
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

	private void updateBlockState(BlockState p_213963_1_, boolean p_213963_2_) {
		this.level.setBlock(this.getBlockPos(), p_213963_1_.setValue(ModBarrelBlock.OPEN, Boolean.valueOf(p_213963_2_)), 3);
	}

	private void playSound(BlockState p_213965_1_, SoundEvent p_213965_2_) {
		Vec3i vector3i = p_213965_1_.getValue(ModBarrelBlock.FACING).getNormal();
		double d0 = (double) this.worldPosition.getX() + 0.5D + (double) vector3i.getX() / 2.0D;
		double d1 = (double) this.worldPosition.getY() + 0.5D + (double) vector3i.getY() / 2.0D;
		double d2 = (double) this.worldPosition.getZ() + 0.5D + (double) vector3i.getZ() / 2.0D;
		this.level.playSound((Player) null, d0, d1, d2, p_213965_2_, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
	}
}
