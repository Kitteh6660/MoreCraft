package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.block.ModChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModChestBlockEntity extends ChestBlockEntity
{
	//private static final int EVENT_SET_OPEN_COUNT = 1;
	private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
	private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;
	private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
		protected void onOpen(Level p_155357_, BlockPos p_155358_, BlockState p_155359_) {
			ModChestBlockEntity.playSound(p_155357_, p_155358_, p_155359_, SoundEvents.CHEST_OPEN);
		}

		protected void onClose(Level p_155367_, BlockPos p_155368_, BlockState p_155369_) {
			ModChestBlockEntity.playSound(p_155367_, p_155368_, p_155369_, SoundEvents.CHEST_CLOSE);
		}

		protected void openerCountChanged(Level p_155361_, BlockPos p_155362_, BlockState p_155363_, int p_155364_, int p_155365_) {
			ModChestBlockEntity.this.signalOpenCount(p_155361_, p_155362_, p_155363_, p_155364_, p_155365_);
		}

		protected boolean isOwnContainer(Player p_155355_) {
			if (!(p_155355_.containerMenu instanceof ChestMenu)) {
				return false;
			} else {
				Container container = ((ChestMenu) p_155355_.containerMenu).getContainer();
				return container == ModChestBlockEntity.this || container instanceof CompoundContainer && ((CompoundContainer) container).contains(ModChestBlockEntity.this);
			}
		}
	};
	private final ChestLidController chestLidController = new ChestLidController();

	protected ModChestBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	public ModChestBlockEntity(BlockPos pos, BlockState state) {
		this(ModBlockEntityType.NETHERWOOD_CHEST.get(), pos, state);
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return 27;
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	protected Component getDefaultName() {
		return new TranslatableComponent("container.chest");
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(compound)) {
			ContainerHelper.loadAllItems(compound, this.items);
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.items);
		}
	}

	public static void lidAnimateTick(Level p_155344_, BlockPos p_155345_, BlockState p_155346_, ModChestBlockEntity p_155347_) {
		p_155347_.chestLidController.tickLid();
	}

	public static int getOpenCount(BlockGetter p_59087_, BlockPos p_59088_) {
		BlockState blockstate = p_59087_.getBlockState(p_59088_);
		if (blockstate.hasBlockEntity()) {
			BlockEntity blockentity = p_59087_.getBlockEntity(p_59088_);
			if (blockentity instanceof ModChestBlockEntity) {
				return ((ModChestBlockEntity) blockentity).openersCounter.getOpenerCount();
			}
		}

		return 0;
	}

	static void playSound(Level p_155339_, BlockPos p_155340_, BlockState p_155341_, SoundEvent p_155342_) {
		ChestType chesttype = p_155341_.getValue(ChestBlock.TYPE);
		if (chesttype != ChestType.LEFT) {
			double d0 = (double) p_155340_.getX() + 0.5D;
			double d1 = (double) p_155340_.getY() + 0.5D;
			double d2 = (double) p_155340_.getZ() + 0.5D;
			if (chesttype == ChestType.RIGHT) {
				Direction direction = ChestBlock.getConnectedDirection(p_155341_);
				d0 += (double) direction.getStepX() * 0.5D;
				d2 += (double) direction.getStepZ() * 0.5D;
			}

			p_155339_.playSound((Player) null, d0, d1, d2, p_155342_, SoundSource.BLOCKS, 0.5F, p_155339_.random.nextFloat() * 0.1F + 0.9F);
		}
	}

	/**
	 * See {@link Block#eventReceived} for more information. This must return true
	 * serverside before it is called clientside.
	 */
	public boolean triggerEvent(int p_59114_, int p_59115_) {
		if (p_59114_ == 1) {
			this.chestLidController.shouldBeOpen(p_59115_ > 0);
			return true;
		} else {
			return super.triggerEvent(p_59114_, p_59115_);
		}
	}

	public void startOpen(Player p_59120_) {
		if (!this.remove && !p_59120_.isSpectator()) {
			this.openersCounter.incrementOpeners(p_59120_, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}

	}

	public void stopOpen(Player p_59118_) {
		if (!this.remove && !p_59118_.isSpectator()) {
			this.openersCounter.decrementOpeners(p_59118_, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}

	}

	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.items = itemsIn;
	}

	@OnlyIn(Dist.CLIENT)
	public float getOpenNess(float partialTicks) {
		return this.chestLidController.getOpenness(partialTicks);
	}

	public static void swapContents(ModChestBlockEntity chest, ModChestBlockEntity otherChest) {
		NonNullList<ItemStack> nonnulllist = chest.getItems();
		chest.setItems(otherChest.getItems());
		otherChest.setItems(nonnulllist);
	}

	protected AbstractContainerMenu createMenu(int id, Inventory player) {
		return ChestMenu.threeRows(id, player, this);
	}

	@Override
	public void setBlockState(BlockState state) {
		super.setBlockState(state);
		if (this.chestHandler != null) {
			this.chestHandler.invalidate();
			this.chestHandler = null;
		}
	}

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
		if (!this.remove && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (this.chestHandler == null) {
				this.chestHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
			}
			return this.chestHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
		BlockState state = this.getBlockState();
		if (!(state.getBlock() instanceof ModChestBlock)) {
			return new net.minecraftforge.items.wrapper.InvWrapper(this);
		}
		Container inv = ModChestBlock.getContainer((ModChestBlock) state.getBlock(), state, getLevel(), getBlockPos(), true);
		return new net.minecraftforge.items.wrapper.InvWrapper(inv == null ? this : inv);
	}

	/**
	 * invalidates a tile entity
	 */
	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		if (chestHandler != null)
			chestHandler.invalidate();
	}
}