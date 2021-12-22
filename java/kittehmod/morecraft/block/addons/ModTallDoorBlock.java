package kittehmod.morecraft.block.addons;

import javax.annotation.Nullable;

import kittehmod.morecraft.state.properties.ModBlockStateProperties;
import kittehmod.morecraft.state.properties.TripleBlockThird;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

public class ModTallDoorBlock extends Block
{
	public static final boolean DOUBLE_DOORS_INSTALLED = ModList.get().isLoaded("doubledoors");
		
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
	public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final EnumProperty<TripleBlockThird> THIRD = ModBlockStateProperties.TRIPLE_BLOCK_THIRD;
	protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);

	public ModTallDoorBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.valueOf(false)).setValue(THIRD, TripleBlockThird.LOWER));
	}

	public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
		Direction direction = p_220053_1_.getValue(FACING);
		boolean flag = !p_220053_1_.getValue(OPEN);
		boolean flag1 = p_220053_1_.getValue(HINGE) == DoorHingeSide.RIGHT;
		switch (direction) {
		case EAST:
		default:
			return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
		case SOUTH:
			return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
		case WEST:
			return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
		case NORTH:
			return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction dir, BlockState facingState, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
        TripleBlockThird tripleblockpart = stateIn.getValue(THIRD);
        if (dir.getAxis() == Direction.Axis.Y && ((tripleblockpart == TripleBlockThird.LOWER == (dir == Direction.UP)) || tripleblockpart == TripleBlockThird.MIDDLE)) {
            if (facingState.getBlock() == this && facingState.getValue(THIRD) != tripleblockpart) {
                return stateIn.setValue(FACING, facingState.getValue(FACING)).setValue(OPEN, facingState.getValue(OPEN)).setValue(HINGE, facingState.getValue(HINGE)).setValue(POWERED, facingState.getValue(POWERED));
            } else {
                return Blocks.AIR.defaultBlockState();
            }
        } else {
            if (tripleblockpart == TripleBlockThird.LOWER && dir == Direction.DOWN && !stateIn.canSurvive(level, pos1)) {
                return Blocks.AIR.defaultBlockState();
            } else {
                return super.updateShape(stateIn, dir, facingState, level, pos1, pos2);
            }
        }
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide && player.isCreative()) {
			ModTallDoorBlock.preventCreativeDropFromBottomPart(level, pos, state, player);
		}
		if (state.is(this)) {
			if (state.getValue(THIRD) == TripleBlockThird.UPPER) {
				level.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), 35);
				level.levelEvent(player, 2001, pos.below(), Block.getId(state));
			}
		}
		super.playerWillDestroy(level, pos, state, player);
	}

	public boolean isPathfindable(BlockState state, BlockGetter p_196266_2_, BlockPos pos, BlockPathTypes path) {
		switch (path) {
		case WALKABLE:
			return state.getValue(OPEN);
		case WATER:
			return false;
		case OPEN:
			return state.getValue(OPEN);
		default:
			return false;
		}
	}

	private int getCloseSound() {
		return this.material == Material.METAL ? 1011 : 1012;
	}

	private int getOpenSound() {
		return this.material == Material.METAL ? 1005 : 1006;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
		BlockPos blockpos = p_196258_1_.getClickedPos();
		if (blockpos.getY() < 255 && p_196258_1_.getLevel().getBlockState(blockpos.above(1)).canBeReplaced(p_196258_1_) && p_196258_1_.getLevel().getBlockState(blockpos.above(2)).canBeReplaced(p_196258_1_)) {
			Level level = p_196258_1_.getLevel();
			boolean flag = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above()) || level.hasNeighborSignal(blockpos.above(2));
			return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection()).setValue(HINGE, this.getHinge(p_196258_1_)).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(THIRD, TripleBlockThird.LOWER);
		} else {
			return null;
		}
	}

	public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		p_180633_1_.setBlock(p_180633_2_.above(1), p_180633_3_.setValue(THIRD, TripleBlockThird.MIDDLE), 3);
		p_180633_1_.setBlock(p_180633_2_.above(2), p_180633_3_.setValue(THIRD, TripleBlockThird.UPPER), 3);
	}

	private DoorHingeSide getHinge(BlockPlaceContext p_208073_1_) {
		BlockGetter iblockreader = p_208073_1_.getLevel();
		BlockPos blockpos = p_208073_1_.getClickedPos();
		Direction direction = p_208073_1_.getHorizontalDirection();
		BlockPos blockpos1 = blockpos.above();
		Direction direction1 = direction.getCounterClockWise();
		BlockPos blockpos2 = blockpos.relative(direction1);
		BlockState blockstate = iblockreader.getBlockState(blockpos2);
		BlockPos blockpos3 = blockpos1.relative(direction1);
		BlockState blockstate1 = iblockreader.getBlockState(blockpos3);
		Direction direction2 = direction.getClockWise();
		BlockPos blockpos4 = blockpos.relative(direction2);
		BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
		BlockPos blockpos5 = blockpos1.relative(direction2);
		BlockState blockstate3 = iblockreader.getBlockState(blockpos5);
		int i = (blockstate.isCollisionShapeFullBlock(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isCollisionShapeFullBlock(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isCollisionShapeFullBlock(iblockreader, blockpos4) ? 1 : 0)
				+ (blockstate3.isCollisionShapeFullBlock(iblockreader, blockpos5) ? 1 : 0);
		boolean flag = blockstate.is(this) && blockstate.getValue(THIRD) == TripleBlockThird.LOWER;
		boolean flag1 = blockstate2.is(this) && blockstate2.getValue(THIRD) == TripleBlockThird.LOWER;
		if ((!flag || flag1) && i <= 0) {
			if ((!flag1 || flag) && i >= 0) {
				int j = direction.getStepX();
				int k = direction.getStepZ();
				Vec3 vector3d = p_208073_1_.getClickLocation();
				double d0 = vector3d.x - (double) blockpos.getX();
				double d1 = vector3d.z - (double) blockpos.getZ();
				return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
			} else {
				return DoorHingeSide.LEFT;
			}
		} else {
			return DoorHingeSide.RIGHT;
		}
	}

	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (this.material == Material.METAL) {
			return InteractionResult.PASS;
		} else {
			tryOpenDoubleDoor(level, state, pos);
			state = state.cycle(OPEN);
			level.setBlock(pos, state, 10);
			level.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
			if (state.getValue(THIRD) == TripleBlockThird.UPPER) {
				if (level.getBlockState(pos.below(1)).is(this)) {
					level.setBlock(pos.below(1), level.getBlockState(pos.below(1)).setValue(OPEN, state.getValue(OPEN)), 10);
				}
				if (level.getBlockState(pos.below(2)).is(this)) {
					level.setBlock(pos.below(2), level.getBlockState(pos.below(2)).setValue(OPEN, state.getValue(OPEN)), 10);
				}
			}
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
	}

	public boolean isOpen(BlockState p_242664_1_) {
		return p_242664_1_.getValue(OPEN);
	}

	public void setOpen(Level level, BlockState state, BlockPos pos, boolean isOpen) {
		if (state.is(this) && state.getValue(OPEN) != isOpen) {
			level.setBlock(pos, state.setValue(OPEN, Boolean.valueOf(isOpen)), 10);
			if (state.getValue(THIRD) == TripleBlockThird.UPPER) {
				if (level.getBlockState(pos.below(1)).is(this)) {
					level.setBlock(pos.below(1), state.setValue(OPEN, Boolean.valueOf(isOpen)), 10);
				}
				if (level.getBlockState(pos.below(2)).is(this)) {
					level.setBlock(pos.below(2), state.setValue(OPEN, Boolean.valueOf(isOpen)), 10);
				}
			}
			this.playSound(level, pos, isOpen);
		}
	}

	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos2, boolean p_220069_6_) {
		boolean flag = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.relative(state.getValue(THIRD) == TripleBlockThird.LOWER ? Direction.UP : Direction.DOWN)) || level.hasNeighborSignal(pos.relative(state.getValue(THIRD) == TripleBlockThird.UPPER ? Direction.DOWN : Direction.UP));
		if (block != this && flag != state.getValue(POWERED)) {
			if (flag != state.getValue(OPEN)) {
				this.playSound(level, pos, flag);
			}
			tryOpenDoubleDoor(level, state, pos);
			level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
			if (state.getValue(THIRD) == TripleBlockThird.UPPER) {
				if (level.getBlockState(pos.below(1)).is(this)) {
					level.setBlock(pos.below(1), level.getBlockState(pos.below(1)).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
				}
				if (level.getBlockState(pos.below(2)).is(this)) {
					level.setBlock(pos.below(2), level.getBlockState(pos.below(2)).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
				}
			}
		}

	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
		boolean result = true;
		BlockPos blockpos = pos.below();
		BlockState blockstate = levelReader.getBlockState(blockpos);
		BlockPos blockpos2 = pos.above();
		BlockState blockstate2 = levelReader.getBlockState(blockpos2);
		if (state.getValue(THIRD) == TripleBlockThird.LOWER) {
			if (!blockstate.isFaceSturdy(levelReader, blockpos, Direction.UP)) {
				result = false;
			}
		}
		if (state.getValue(THIRD) == TripleBlockThird.MIDDLE) {
			if (!blockstate2.is(this)) {
				result = false;
			}
		}
		return result;
	}

	private void playSound(Level p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
		p_196426_1_.levelEvent((Player) null, p_196426_3_ ? this.getOpenSound() : this.getCloseSound(), p_196426_2_, 0);
	}

	public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
		return PushReaction.DESTROY;
	}

	public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
		return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
		return p_185471_2_ == Mirror.NONE ? p_185471_1_ : p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING))).cycle(HINGE);
	}

	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState p_209900_1_, BlockPos p_209900_2_) {
		return Mth.getSeed(p_209900_2_.getX(), p_209900_2_.below(p_209900_1_.getValue(THIRD) == TripleBlockThird.LOWER ? 0 : 1).getY(), p_209900_2_.getZ());
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> states) {
		states.add(THIRD, FACING, OPEN, HINGE, POWERED);
	}

	public static boolean isWoodenDoor(Level p_235491_0_, BlockPos p_235491_1_) {
		return isWoodenDoor(p_235491_0_.getBlockState(p_235491_1_));
	}

	public static boolean isWoodenDoor(BlockState p_235492_0_) {
		return p_235492_0_.getBlock() instanceof ModTallDoorBlock && (p_235492_0_.getMaterial() == Material.WOOD || p_235492_0_.getMaterial() == Material.NETHER_WOOD);
	}
	
	protected static void preventCreativeDropFromBottomPart(Level p_241471_0_, BlockPos p_241471_1_, BlockState p_241471_2_, Player p_241471_3_) {
		TripleBlockThird blockpart = p_241471_2_.getValue(THIRD);
		if (blockpart == TripleBlockThird.UPPER || blockpart == TripleBlockThird.MIDDLE) {
			BlockPos blockpos = p_241471_1_.below(blockpart == TripleBlockThird.UPPER ? 2 : 1);
			BlockState blockstate = p_241471_0_.getBlockState(blockpos);
			if (blockstate.getBlock() == p_241471_2_.getBlock() && blockstate.getValue(THIRD) == TripleBlockThird.LOWER) {
				p_241471_0_.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				p_241471_0_.levelEvent(p_241471_3_, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}
	
	//Double Doors Compatibility
	public static void tryOpenDoubleDoor(Level level, BlockState state, BlockPos pos) {
        if (DOUBLE_DOORS_INSTALLED) {
            Direction direction = state.getValue(ModTallDoorBlock.FACING);
            boolean isOpen = state.getValue(ModTallDoorBlock.OPEN);
            DoorHingeSide isMirrored = state.getValue(ModTallDoorBlock.HINGE);
            BlockPos mirrorPos = pos.relative(isMirrored == DoorHingeSide.RIGHT ? direction.getCounterClockWise() : direction.getClockWise());
            BlockPos doorPos = state.getValue(ModTallDoorBlock.THIRD) == TripleBlockThird.LOWER ? mirrorPos : mirrorPos.below();
            BlockState other = level.getBlockState(doorPos);
            if (other.getBlock() == state.getBlock() && other.getValue(ModTallDoorBlock.FACING) == direction && !other.getValue(ModTallDoorBlock.POWERED) &&  other.getValue(ModTallDoorBlock.OPEN) == isOpen && other.getValue(ModTallDoorBlock.HINGE) != isMirrored) {
                BlockState newState = other.cycle(ModTallDoorBlock.OPEN);
                level.setBlock(doorPos, newState, 10);
            }
        }
    }
}
