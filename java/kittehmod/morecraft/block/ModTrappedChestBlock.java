package kittehmod.morecraft.block;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.ChestType;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation")
public class ModTrappedChestBlock extends AbstractChestBlock<NetherwoodTrappedChestTileEntity> implements IWaterLoggable
{
	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape NORTH_AABB = Block.box(1.0D, 0.0D, 0.0D, 15.0D, 14.0D, 15.0D);
	protected static final VoxelShape SOUTH_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 16.0D);
	protected static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
	protected static final VoxelShape EAST_AABB = Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 15.0D);
	protected static final VoxelShape AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
	private static final TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Optional<IInventory>> CHEST_COMBINER = new TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Optional<IInventory>>() {

		public Optional<IInventory> acceptDouble(NetherwoodTrappedChestTileEntity p_225539_1_, NetherwoodTrappedChestTileEntity p_225539_2_) {
			return Optional.of(new DoubleSidedInventory(p_225539_1_, p_225539_2_));
		}

		public Optional<IInventory> acceptSingle(NetherwoodTrappedChestTileEntity p_225538_1_) {
			return Optional.of(p_225538_1_);
		}

		public Optional<IInventory> acceptNone() {
			return Optional.empty();
		}

	};
	private static final TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Optional<INamedContainerProvider>> MENU_PROVIDER_COMBINER = new TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Optional<INamedContainerProvider>>() {
		public Optional<INamedContainerProvider> acceptDouble(final NetherwoodTrappedChestTileEntity p_225539_1_, final NetherwoodTrappedChestTileEntity p_225539_2_) {
			final IInventory iinventory = new DoubleSidedInventory(p_225539_1_, p_225539_2_);
			return Optional.of(new INamedContainerProvider() {
				@Nullable
				public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
					if (p_225539_1_.canOpen(p_createMenu_3_) && p_225539_2_.canOpen(p_createMenu_3_)) {
						p_225539_1_.unpackLootTable(p_createMenu_2_.player);
						p_225539_2_.unpackLootTable(p_createMenu_2_.player);
						return ChestContainer.sixRows(p_createMenu_1_, p_createMenu_2_, iinventory);
					} else {
						return null;
					}
				}

				public ITextComponent getDisplayName() {
					if (p_225539_1_.hasCustomName()) {
						return p_225539_1_.getDisplayName();
					} else {
						return (ITextComponent) (p_225539_2_.hasCustomName() ? p_225539_2_.getDisplayName() : new TranslationTextComponent("container.chestDouble"));
					}
				}
			});
		}

		public Optional<INamedContainerProvider> acceptSingle(NetherwoodTrappedChestTileEntity p_225538_1_) {
			return Optional.of(p_225538_1_);
		}

		public Optional<INamedContainerProvider> acceptNone() {
			return Optional.empty();
		}
	};

	protected ModTrappedChestBlock(AbstractBlock.Properties builder, Supplier<TileEntityType<? extends NetherwoodTrappedChestTileEntity>> blockEntityTypeIn) {
		super(builder, blockEntityTypeIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, ChestType.SINGLE).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	public static TileEntityMerger.Type getBlockType(BlockState blockStateIn) {
		ChestType chesttype = blockStateIn.getValue(TYPE);
		if (chesttype == ChestType.SINGLE) {
			return TileEntityMerger.Type.SINGLE;
		} else {
			return chesttype == ChestType.RIGHT ? TileEntityMerger.Type.FIRST : TileEntityMerger.Type.SECOND;
		}
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model,
	 * MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to
	 * skip all rendering
	 * 
	 * @deprecated call via {@link IBlockState#getRenderType()} whenever possible.
	 *             Implementing/overriding is fine.
	 */
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	/**
	 * Update the provided state given the provided neighbor facing and neighbor
	 * state, returning a new state. For example, fences make their connections to
	 * the passed in state if possible, and wet concrete powder immediately returns
	 * its solidified counterpart. Note that this method should ideally consider
	 * only the specific face passed in.
	 */
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		if (facingState.getBlock() == this && facing.getAxis().isHorizontal()) {
			ChestType chesttype = facingState.getValue(TYPE);
			if (stateIn.getValue(TYPE) == ChestType.SINGLE && chesttype != ChestType.SINGLE && stateIn.getValue(FACING) == facingState.getValue(FACING) && getConnectedDirection(facingState) == facing.getOpposite()) {
				return stateIn.setValue(TYPE, chesttype.getOpposite());
			}
		} else if (getConnectedDirection(stateIn) == facing) {
			return stateIn.setValue(TYPE, ChestType.SINGLE);
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.getValue(TYPE) == ChestType.SINGLE) {
			return AABB;
		} else {
			switch (getConnectedDirection(state)) {
			case NORTH:
			default:
				return NORTH_AABB;
			case SOUTH:
				return SOUTH_AABB;
			case WEST:
				return WEST_AABB;
			case EAST:
				return EAST_AABB;
			}
		}
	}

	/**
	 * Returns a facing pointing from the given state to its attached double chest
	 */
	public static Direction getConnectedDirection(BlockState p_196311_0_) {
		Direction direction = p_196311_0_.getValue(FACING);
		return p_196311_0_.getValue(TYPE) == ChestType.LEFT ? direction.getClockWise() : direction.getCounterClockWise();
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		ChestType chesttype = ChestType.SINGLE;
		Direction direction = context.getHorizontalDirection().getOpposite();
		FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
		boolean flag = context.isSecondaryUseActive();
		Direction direction1 = context.getClickedFace();
		if (direction1.getAxis().isHorizontal() && flag) {
			Direction direction2 = this.candidatePartnerFacing(context, direction1.getOpposite());
			if (direction2 != null && direction2.getAxis() != direction1.getAxis()) {
				direction = direction2;
				chesttype = direction2.getCounterClockWise() == direction1.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
			}
		}

		if (chesttype == ChestType.SINGLE && !flag) {
			if (direction == this.candidatePartnerFacing(context, direction.getClockWise())) {
				chesttype = ChestType.LEFT;
			} else if (direction == this.candidatePartnerFacing(context, direction.getCounterClockWise())) {
				chesttype = ChestType.RIGHT;
			}
		}

		return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, chesttype).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	}

	/**
	 * Returns facing pointing to a chest to form a double chest with, null
	 * otherwise
	 */
	@Nullable
	private Direction candidatePartnerFacing(BlockItemUseContext p_196312_1_, Direction p_196312_2_) {
		BlockState blockstate = p_196312_1_.getLevel().getBlockState(p_196312_1_.getClickedPos().relative(p_196312_2_));
		return blockstate.is(this) && blockstate.getValue(TYPE) == ChestType.SINGLE ? blockstate.getValue(FACING) : null;
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place
	 * logic
	 */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (stack.hasCustomHoverName()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof NetherwoodTrappedChestTileEntity) {
				((NetherwoodTrappedChestTileEntity) tileentity).setCustomName(stack.getDisplayName());
			}
		}

	}

	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropContents(worldIn, pos, (IInventory) tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			INamedContainerProvider inamedcontainerprovider = this.getMenuProvider(state, worldIn, pos);
			if (inamedcontainerprovider != null) {
				player.openMenu(inamedcontainerprovider);
				player.awardStat(this.getOpenStat());
				PiglinTasks.angerNearbyPiglins(player, true);
			}

			return ActionResultType.SUCCESS;
		}
	}

	protected Stat<ResourceLocation> getOpenStat() {
		return Stats.CUSTOM.get(Stats.OPEN_CHEST);
	}

	@Nullable
	public static IInventory getChestInventory(ModTrappedChestBlock chest, BlockState state, World world, BlockPos pos, boolean override) {
		return chest.combine(state, world, pos, override).apply(CHEST_COMBINER).orElse((IInventory) null);
	}

	@Override
	public TileEntityMerger.ICallbackWrapper<? extends NetherwoodTrappedChestTileEntity> combine(BlockState state, World world, BlockPos pos, boolean override) {
		BiPredicate<IWorld, BlockPos> bipredicate;
		if (override) {
			bipredicate = (worldIn, posIn) -> { return false; };
		} else {
			bipredicate = ModChestBlock::isChestBlockedAt;
		}
		return TileEntityMerger.combineWithNeigbour(this.blockEntityType.get(), ModChestBlock::getBlockType, ModChestBlock::getConnectedDirection, FACING, state, world, pos, bipredicate);
	}

	@Nullable
	public INamedContainerProvider getMenuProvider(ModChestBlock chest, BlockState state, World worldIn, BlockPos pos, boolean combine) {
		return this.combine(state, worldIn, pos, false).apply(MENU_PROVIDER_COMBINER).orElse((INamedContainerProvider) null);
	}

	@OnlyIn(Dist.CLIENT)
	public static TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Float2FloatFunction> opennessCombiner(final IChestLid lid) {
		return new TileEntityMerger.ICallback<NetherwoodTrappedChestTileEntity, Float2FloatFunction>() {
			public Float2FloatFunction acceptDouble(NetherwoodTrappedChestTileEntity p_225539_1_, NetherwoodTrappedChestTileEntity p_225539_2_) {
				return (p_226921_2_) -> { return Math.max(p_225539_1_.getOpenNess(p_226921_2_), p_225539_2_.getOpenNess(p_226921_2_)); };
			}

			public Float2FloatFunction acceptSingle(NetherwoodTrappedChestTileEntity p_225538_1_) {
				return p_225538_1_::getOpenNess;
			}

			public Float2FloatFunction acceptNone() {
				return lid::getOpenNess;
			}
		};
	}

	public TileEntity newBlockEntity(IBlockReader worldIn) {
		return new NetherwoodTrappedChestTileEntity();
	}

	public static boolean isChestBlockedAt(IWorld p_220108_0_, BlockPos p_220108_1_) {
		return isBlockedChestByBlock(p_220108_0_, p_220108_1_) || isCatSittingOn(p_220108_0_, p_220108_1_);
	}

	private static boolean isBlockedChestByBlock(IBlockReader p_176456_0_, BlockPos worldIn) {
		BlockPos blockpos = worldIn.above();
		return p_176456_0_.getBlockState(blockpos).isRedstoneConductor(p_176456_0_, blockpos);
	}

	private static boolean isCatSittingOn(IWorld p_220107_0_, BlockPos p_220107_1_) {
		List<CatEntity> list = p_220107_0_.getEntitiesOfClass(CatEntity.class, new AxisAlignedBB((double) p_220107_1_.getX(), (double) (p_220107_1_.getY() + 1), (double) p_220107_1_
				.getZ(), (double) (p_220107_1_.getX() + 1), (double) (p_220107_1_.getY() + 2), (double) (p_220107_1_.getZ() + 1)));
		if (!list.isEmpty()) {
			for (CatEntity catentity : list) {
				if (catentity.isInSittingPose()) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @deprecated call via {@link IBlockState#hasComparatorInputOverride()}
	 *             whenever possible. Implementing/overriding is fine.
	 */
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	/**
	 * @deprecated call via
	 *             {@link IBlockState#getComparatorInputOverride(World,BlockPos)}
	 *             whenever possible. Implementing/overriding is fine.
	 */
	public int getAnalogOutputSignal(BlockState blockState, World worldIn, BlockPos pos) {
		return Container.getRedstoneSignalFromContainer(getChestInventory(this, blockState, worldIn, pos, false));
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever
	 *             possible. Implementing/overriding is fine.
	 */
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockState#withMirror(Mirror)} whenever
	 *             possible. Implementing/overriding is fine.
	 */
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, TYPE, WATERLOGGED);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	public TileEntityType<? extends NetherwoodTrappedChestTileEntity> getTileEntityType() {
		return ModTileEntityType.NETHERWOOD_TRAPPED_CHEST.get();
	}

	public boolean canProvidePower(BlockState state) {
		return true;
	}

	public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		return MathHelper.clamp(NetherwoodTrappedChestTileEntity.getOpenCount(blockAccess, pos), 0, 15);
	}

	public int getDirectSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		return side == Direction.UP ? blockState.getSignal(blockAccess, pos, side) : 0;
	}

}
