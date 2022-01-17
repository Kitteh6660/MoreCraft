package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import kittehmod.morecraft.entity.CraftingTableMinecartEntity;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.RailShape;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CraftingTableMinecartItem extends Item
{
	@Nullable
	private final CraftingTableMinecartEntity.CraftingTableType craftingTableType;

	private static final IDispenseItemBehavior DISPENSE_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior() {
		private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

		/**
		 * Dispense the specified stack, play the dispense sound and spawn particles.
		 */
		@SuppressWarnings("deprecation")
		public ItemStack execute(IBlockSource source, ItemStack stack) {
			Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
			World world = source.getLevel();
			double d0 = source.x() + (double) direction.getStepX() * 1.125D;
			double d1 = Math.floor(source.y()) + (double) direction.getStepY();
			double d2 = source.z() + (double) direction.getStepZ() * 1.125D;
			BlockPos blockpos = source.getPos().relative(direction);
			BlockState blockstate = world.getBlockState(blockpos);
			RailShape railshape = blockstate.getBlock() instanceof AbstractRailBlock ? ((AbstractRailBlock) blockstate.getBlock()).getRailDirection(blockstate, world, blockpos, null) : RailShape.NORTH_SOUTH;
			double d3;
			if (blockstate.is(BlockTags.RAILS)) {
				if (railshape.isAscending()) {
					d3 = 0.6D;
				} else {
					d3 = 0.1D;
				}
			} else {
				if (!blockstate.isAir() || !world.getBlockState(blockpos.below()).is(BlockTags.RAILS)) {
					return this.defaultDispenseItemBehavior.dispense(source, stack);
				}

				BlockState blockstate1 = world.getBlockState(blockpos.below());
				RailShape railshape1 = blockstate1.getBlock() instanceof AbstractRailBlock ? blockstate1.getValue(((AbstractRailBlock) blockstate1.getBlock()).getShapeProperty()) : RailShape.NORTH_SOUTH;
				if (direction != Direction.DOWN && railshape1.isAscending()) {
					d3 = -0.4D;
				} else {
					d3 = -0.9D;
				}
			}

			CraftingTableMinecartEntity minecartentity;
			if (stack.getItem() instanceof CraftingTableMinecartItem) {
				CraftingTableMinecartItem item = (CraftingTableMinecartItem) stack.getItem();
				minecartentity = CraftingTableMinecartEntity.create(world, d0, d1 + d3, d2, item.craftingTableType);
			} else {
				minecartentity = CraftingTableMinecartEntity.create(world, d0, d1 + d3, d2, CraftingTableMinecartEntity.CraftingTableType.NETHERWOOD);
			}
			if (stack.hasCustomHoverName()) {
				minecartentity.setCustomName(stack.getHoverName());
			}

			world.addFreshEntity(minecartentity);
			stack.shrink(1);
			return stack;
		}

		/**
		 * Play the dispense sound from the specified block.
		 */
		protected void playSound(IBlockSource source) {
			source.getLevel().levelEvent(1000, source.getPos(), 0);
		}
	};

	public CraftingTableMinecartItem(Item.Properties builder) {
		super(builder);
		this.craftingTableType = null;
		DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
	}

	public CraftingTableMinecartItem(Item.Properties builder, CraftingTableMinecartEntity.CraftingTableType tableType) {
		super(builder);
		this.craftingTableType = tableType;
		DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
	}

	/**
	 * Called when this item is used when targetting a Block
	 */
	public ActionResultType useOn(ItemUseContext context) {
		World world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = world.getBlockState(blockpos);
		if (!blockstate.is(BlockTags.RAILS)) {
			return ActionResultType.FAIL;
		} else {
			ItemStack itemstack = context.getItemInHand();
			if (!world.isClientSide) {
				RailShape railshape = blockstate.getBlock() instanceof AbstractRailBlock ? ((AbstractRailBlock) blockstate.getBlock()).getRailDirection(blockstate, world, blockpos, null) : RailShape.NORTH_SOUTH;
				double d0 = 0.0D;
				if (railshape.isAscending()) {
					d0 = 0.5D;
				}

				CraftingTableMinecartEntity minecartentity = CraftingTableMinecartEntity.create(world, (double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.0625D + d0, (double) blockpos.getZ() + 0.5D, this.craftingTableType);
				if (itemstack.hasCustomHoverName()) {
					minecartentity.setCustomName(itemstack.getDisplayName());
				}

				world.addFreshEntity(minecartentity);
			}

			itemstack.shrink(1);
			return ActionResultType.sidedSuccess(world.isClientSide);
		}
	}
}
