package kittehmod.morecraft.tileentity.addons;

import java.util.stream.IntStream;

import javax.annotation.Nullable;

import kittehmod.morecraft.block.ModBlockTags;
import kittehmod.morecraft.block.addons.ModCrateBlock;
import kittehmod.morecraft.container.addons.ModCrateContainer;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModCrateTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity
{
	private static final int[] SLOTS = IntStream.range(0, 9).toArray();
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(9, ItemStack.EMPTY);
	private int openCount;

	public ModCrateTileEntity() {
		super(ModTileEntityType.CRATE.get());
	}

	public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
		super.load(p_230337_1_, p_230337_2_);
		this.loadFromTag(p_230337_2_);
	}

	public CompoundNBT save(CompoundNBT p_189515_1_) {
		super.save(p_189515_1_);
		return this.saveToTag(p_189515_1_);
	}

	public void loadFromTag(CompoundNBT p_190586_1_) {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(p_190586_1_) && p_190586_1_.contains("Items", this.itemStacks.size())) {
			ItemStackHelper.loadAllItems(p_190586_1_, this.itemStacks);
		}
	}

	public CompoundNBT saveToTag(CompoundNBT p_190580_1_) {
		if (!this.trySaveLootTable(p_190580_1_)) {
			ItemStackHelper.saveAllItems(p_190580_1_, this.itemStacks, false);
		}
		return p_190580_1_;
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

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.charm.crate");
	}

	protected Container createMenu(int syncID, PlayerInventory playerInv) {
		return new ModCrateContainer(syncID, playerInv, this);
	}

	@Override
	public void tick() {
		// Nothing to tick here...
	}
	
	public void startOpen(PlayerEntity p_174889_1_) {
		if (!p_174889_1_.isSpectator()) {
			if (this.openCount < 0) {
				this.openCount = 0;
			}

			++this.openCount;
			BlockState blockstate = this.getBlockState();
			this.playSound(blockstate, SoundEvents.BARREL_OPEN);
			this.scheduleRecheck();
		}

	}

	private void scheduleRecheck() {
		this.level.getBlockTicks().scheduleTick(this.getBlockPos(), this.getBlockState().getBlock(), 5);
	}

	public void recheckOpen() {
		int i = this.worldPosition.getX();
		int j = this.worldPosition.getY();
		int k = this.worldPosition.getZ();
		this.openCount = ChestTileEntity.getOpenCount(this.level, this, i, j, k);
		if (this.openCount > 0) {
			this.scheduleRecheck();
		} else {
			BlockState blockstate = this.getBlockState();
			if (!(blockstate.getBlock() instanceof ModCrateBlock)) {
				this.setRemoved();
				return;
			}
			this.playSound(blockstate, SoundEvents.BARREL_CLOSE);
		}

	}

	public void stopOpen(PlayerEntity p_174886_1_) {
		if (!p_174886_1_.isSpectator()) {
			--this.openCount;
		}

	}

	private void playSound(BlockState p_213965_1_, SoundEvent p_213965_2_) {
		Vector3i vector3i = Direction.UP.getNormal();
		double d0 = (double) this.worldPosition.getX() + 0.5D + (double) vector3i.getX() / 2.0D;
		double d1 = (double) this.worldPosition.getY() + 0.5D + (double) vector3i.getY() / 2.0D;
		double d2 = (double) this.worldPosition.getZ() + 0.5D + (double) vector3i.getZ() / 2.0D;
		this.level.playSound((PlayerEntity) null, d0, d1, d2, p_213965_2_, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
	}

	public AxisAlignedBB getBoundingBox(BlockState p_190584_1_) {
		return VoxelShapes.block().bounds();
	}

	@Override
	public int[] getSlotsForFace(Direction p_180463_1_) {
		return SLOTS;
	}

	@Override
	public boolean canPlaceItemThroughFace(int p_180462_1_, ItemStack stack, @Nullable Direction dir) {
		return !(Block.byItem(stack.getItem()).is(ModBlockTags.CRATES) || Block.byItem(stack.getItem()).is(BlockTags.SHULKER_BOXES));
	}

	@Override
	public boolean canTakeItemThroughFace(int p_180461_1_, ItemStack stack, Direction dir) {
		return true;
	}
}
