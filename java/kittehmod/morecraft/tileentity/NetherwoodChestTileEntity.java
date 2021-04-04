package kittehmod.morecraft.tileentity;

import kittehmod.morecraft.block.ModChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NetherwoodChestTileEntity extends ChestTileEntity
{
	private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
	protected float openness;
	protected float oOpenness;
	protected int openCount;
	private int ticksSinceSync;
	private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;

	protected NetherwoodChestTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public NetherwoodChestTileEntity() {
		this(ModTileEntityType.NETHERWOOD_CHEST.get());
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

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.chest");
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) {
		super.load(state, compound);
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(compound)) {
			ItemStackHelper.loadAllItems(compound, this.items);
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		if (!this.trySaveLootTable(compound)) {
			ItemStackHelper.saveAllItems(compound, this.items);
		}

		return compound;
	}

	public void tick() {
		int i = this.worldPosition.getX();
		int j = this.worldPosition.getY();
		int k = this.worldPosition.getZ();
		++this.ticksSinceSync;
		this.openCount = getOpenCount(this.level, this, this.ticksSinceSync, i, j, k, this.openCount);
		this.oOpenness = this.openness;
		float f = 0.1F;
		if (this.openCount > 0 && this.openness == 0.0F) {
			this.playSound(SoundEvents.CHEST_OPEN);
		}

		if (this.openCount == 0 && this.openness > 0.0F || this.openCount > 0 && this.openness < 1.0F) {
			float f1 = this.openness;
			if (this.openCount > 0) {
				this.openness += f;
			} else {
				this.openness -= f;
			}

			if (this.openness > 1.0F) {
				this.openness = 1.0F;
			}

			float f2 = 0.5F;
			if (this.openness < 0.5F && f1 >= f2) {
				this.playSound(SoundEvents.CHEST_CLOSE);
			}

			if (this.openness < 0.0F) {
				this.openness = 0.0F;
			}
		}

	}

	public static int getOpenCount(World p_213977_0_, LockableTileEntity p_213977_1_, int p_213977_2_, int p_213977_3_, int p_213977_4_, int p_213977_5_, int p_213977_6_) {
		if (!p_213977_0_.isClientSide && p_213977_6_ != 0 && (p_213977_2_ + p_213977_3_ + p_213977_4_ + p_213977_5_) % 200 == 0) {
			p_213977_6_ = getOpenCount(p_213977_0_, p_213977_1_, p_213977_3_, p_213977_4_, p_213977_5_);
		}

		return p_213977_6_;
	}

	public static int getOpenCount(World p_213976_0_, LockableTileEntity p_213976_1_, int p_213976_2_, int p_213976_3_, int p_213976_4_) {
		int i = 0;
		float f = 5.0F;

		for (PlayerEntity playerentity : p_213976_0_.getEntitiesOfClass(PlayerEntity.class, new AxisAlignedBB((double) ((float) p_213976_2_ - f), (double) ((float) p_213976_3_ - f), (double) ((float) p_213976_4_ - f), (double) ((float) (p_213976_2_ + 1)
				+ f), (double) ((float) (p_213976_3_ + 1) + f), (double) ((float) (p_213976_4_ + 1) + f)))) {
			if (playerentity.containerMenu instanceof ChestContainer) {
				IInventory iinventory = ((ChestContainer) playerentity.containerMenu).getContainer();
				if (iinventory == p_213976_1_ || iinventory instanceof DoubleSidedInventory && ((DoubleSidedInventory) iinventory).contains(p_213976_1_)) {
					++i;
				}
			}
		}

		return i;
	}

	private void playSound(SoundEvent soundIn) {
		ChestType chesttype = this.getBlockState().getValue(ModChestBlock.TYPE);
		if (chesttype != ChestType.LEFT) {
			double d0 = (double) this.worldPosition.getX() + 0.5D;
			double d1 = (double) this.worldPosition.getY() + 0.5D;
			double d2 = (double) this.worldPosition.getZ() + 0.5D;
			if (chesttype == ChestType.RIGHT) {
				Direction direction = ModChestBlock.getConnectedDirection(this.getBlockState());
				d0 += (double) direction.getStepX() * 0.5D;
				d2 += (double) direction.getStepZ() * 0.5D;
			}

			this.level.playSound((PlayerEntity) null, d0, d1, d2, soundIn, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
		}
	}

	/**
	 * See {@link Block#eventReceived} for more information. This must return true
	 * serverside before it is called clientside.
	 */
	public boolean triggerEvent(int id, int type) {
		if (id == 1) {
			this.openCount = type;
			return true;
		} else {
			return super.triggerEvent(id, type);
		}
	}

	public void startOpen(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.openCount < 0) {
				this.openCount = 0;
			}

			++this.openCount;
			this.signalOpenCount();
		}

	}

	public void stopOpen(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.openCount;
			this.signalOpenCount();
		}

	}

	protected void signalOpenCount() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof ModChestBlock) {
			this.level.blockEvent(this.worldPosition, block, 1, this.openCount);
			this.level.updateNeighborsAt(this.worldPosition, block);
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
		return MathHelper.lerp(partialTicks, this.oOpenness, this.openness);
	}

	public static int getOpenCount(IBlockReader reader, BlockPos posIn) {
		BlockState blockstate = reader.getBlockState(posIn);
		if (blockstate.hasTileEntity()) {
			TileEntity tileentity = reader.getBlockEntity(posIn);
			if (tileentity instanceof NetherwoodChestTileEntity) {
				return ((NetherwoodChestTileEntity) tileentity).openCount;
			}
		}

		return 0;
	}

	public static void swapContents(NetherwoodChestTileEntity chest, NetherwoodChestTileEntity otherChest) {
		NonNullList<ItemStack> nonnulllist = chest.getItems();
		chest.setItems(otherChest.getItems());
		otherChest.setItems(nonnulllist);
	}

	protected Container createMenu(int id, PlayerInventory player) {
		return ChestContainer.threeRows(id, player, this);
	}

	@Override
	public void clearCache() {
		super.clearCache();
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
		IInventory inv = ModChestBlock.getChestInventory((ModChestBlock) state.getBlock(), state, getLevel(), getBlockPos(), true);
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