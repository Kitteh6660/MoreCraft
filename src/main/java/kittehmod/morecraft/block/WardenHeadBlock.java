package kittehmod.morecraft.block;

import javax.annotation.Nullable;

import kittehmod.morecraft.blockentity.WardenSkullBlockEntity;
import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.SculkSensorPhase;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WardenHeadBlock extends BaseEntityBlock implements WardenHead
{
	public static final int MAX = 15;
	private static final int ROTATIONS = 16;
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
	public static final EnumProperty<SculkSensorPhase> PHASE = BlockStateProperties.SCULK_SENSOR_PHASE;

	public WardenHeadBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(ROTATION, Integer.valueOf(0)).setValue(PHASE, SculkSensorPhase.INACTIVE));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new WardenSkullBlockEntity(pos, state);
	}
	
	public VoxelShape getShape(BlockState p_56331_, BlockGetter p_56332_, BlockPos p_56333_, CollisionContext p_56334_) {
		return SHAPE;
	}

	public VoxelShape getOcclusionShape(BlockState p_56336_, BlockGetter p_56337_, BlockPos p_56338_) {
		return Shapes.empty();
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_56321_) {
		return this.defaultBlockState().setValue(ROTATION, Integer.valueOf(Mth.floor((double) (p_56321_.getRotation() * 16.0F / 360.0F) + 0.5D) & MAX)).setValue(PHASE, SculkSensorPhase.INACTIVE);
	}

	public BlockState rotate(BlockState p_56326_, Rotation p_56327_) {
		return p_56326_.setValue(ROTATION, Integer.valueOf(p_56327_.rotate(p_56326_.getValue(ROTATION), ROTATIONS)));
	}

	public BlockState mirror(BlockState p_56323_, Mirror p_56324_) {
		return p_56323_.setValue(ROTATION, Integer.valueOf(p_56324_.mirror(p_56323_.getValue(ROTATION), ROTATIONS)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ROTATION).add(PHASE);
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (!level.isClientSide) {
			this.resetJumpscareCooldown(level, state, pos);
			level.playSound(null, pos, SoundEvents.WARDEN_AMBIENT, SoundSource.BLOCKS, 1.0F, 2.0F);
		}
	}
	
	@Override
	public void jumpscarePlayer(Level level, BlockState state, BlockPos pos, Player player) {
		if (state.getBlock() instanceof WardenHead) {
			state = state.setValue(PHASE, SculkSensorPhase.COOLDOWN);
		}
		level.playSound(null, pos, SoundEvents.WARDEN_ROAR, SoundSource.BLOCKS, 10.0F, 2.0F);
		player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, true, false));
	}
	
	public static SculkSensorPhase getPhase(BlockState state) {
		return state.getValue(PHASE);
	}
	
	public static boolean canActivate(BlockState state) {
		return getPhase(state) == SculkSensorPhase.ACTIVE;
	}
	
	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos2, boolean flag) {
		level.setBlock(pos, state.setValue(PHASE, level.hasNeighborSignal(pos) ? SculkSensorPhase.ACTIVE : SculkSensorPhase.INACTIVE), Block.UPDATE_ALL_IMMEDIATE);
	}
	
	@Override
	public boolean canJumpscare(Level level, BlockState state, BlockPos pos) {
		return state.getValue(PHASE) == SculkSensorPhase.ACTIVE;
	}
	
	@Override
	public void setJumpscareCooldown(Level level, BlockState state, BlockPos pos) {
		state = state.setValue(PHASE, SculkSensorPhase.COOLDOWN);
		level.setBlock(pos, state, 10);
	}
	
	@Override
	public void resetJumpscareCooldown(Level level, BlockState state, BlockPos pos) {
		if (state.getValue(PHASE) == SculkSensorPhase.ACTIVE) {
			return;
		}
		if (level.getBlockEntity(pos) instanceof WardenSkullBlockEntity) {
			((WardenSkullBlockEntity)level.getBlockEntity(pos)).setRapidlyWiggling(false);
		}
		level.playSound(null, pos, SoundEvents.WARDEN_AMBIENT, SoundSource.BLOCKS, 1.0F, 2.0F);
		state = state.setValue(PHASE, level.hasNeighborSignal(pos) ? SculkSensorPhase.ACTIVE : SculkSensorPhase.INACTIVE);
		level.setBlock(pos, state, 10);
	}
	
	@Nullable
	public <T extends BlockEntity> GameEventListener getListener(ServerLevel level, T blockEntity) {
		return blockEntity instanceof WardenSkullBlockEntity ? ((WardenSkullBlockEntity)blockEntity).getListener() : null;
	}
	
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> typeIn) {
		return !level.isClientSide ? createTickerHelper(typeIn, ModBlockEntityType.WARDEN_HEAD.get(), (world, blockpos, blockstate, blockentity) -> { VibrationSystem.Ticker.tick(world, blockentity.getVibrationData(), blockentity.getVibrationUser()); }) : createTickerHelper(typeIn, ModBlockEntityType.WARDEN_HEAD.get(), WardenSkullBlockEntity::movingTendrils);
	}
	
	@Override
	public int getListenerRange() {
		return 8;
	}
	
	public static enum Types implements SkullBlock.Type {
		WARDEN
	}

}
