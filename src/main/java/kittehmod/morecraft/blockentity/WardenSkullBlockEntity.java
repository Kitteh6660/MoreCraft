package kittehmod.morecraft.blockentity;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;

import kittehmod.morecraft.block.WardenHead;
import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SculkSensorPhase;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;

public class WardenSkullBlockEntity extends BlockEntity implements GameEventListener.Holder<VibrationSystem.Listener>, VibrationSystem
{
	private static final Logger LOGGER = LogUtils.getLogger();
	private VibrationSystem.Data vibrationData;
	private final VibrationSystem.Listener vibrationListener;
	private final VibrationSystem.User vibrationUser = this.createVibrationUser();
	private int lastVibrationFrequency;
	
	private boolean isRapidlyWiggling;
	private int tendrilWiggleTickCount;

	public WardenSkullBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityType.WARDEN_HEAD.get(), pos, state);
		this.vibrationData = new VibrationSystem.Data();
		this.vibrationListener = new VibrationSystem.Listener(this);
		this.tendrilWiggleTickCount = 0;
		this.isRapidlyWiggling = false;
	}

	public VibrationSystem.User createVibrationUser() {
		return new WardenSkullBlockEntity.VibrationUser(this.getBlockPos());
	}
	
	@Override
	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.putInt("last_vibration_frequency", this.lastVibrationFrequency);
		VibrationSystem.Data.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationData).resultOrPartial(LOGGER::error).ifPresent((datatosave) -> { nbt.put("listener", datatosave); });
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.lastVibrationFrequency = nbt.getInt("last_vibration_frequency");
		if (nbt.contains("listener", 10)) {
			VibrationSystem.Data.CODEC.parse(new Dynamic<>(NbtOps.INSTANCE, nbt.getCompound("listener"))).resultOrPartial(LOGGER::error).ifPresent((datatoload) -> { this.vibrationData = datatoload; });
		}
	}
	
	public static void movingTendrils(Level level, BlockPos pos, BlockState state, WardenSkullBlockEntity blockentity) {
		if (blockentity.isRapidlyWiggling) {
			blockentity.tendrilWiggleTickCount+=5;
		}
		else {
			blockentity.tendrilWiggleTickCount++;
		}
	}
	
	public float getTendrilAnimation(float flt) {
		return (float)this.tendrilWiggleTickCount + flt;
		//return Mth.lerp(flt, (float)this.tendrilWiggleTickCount, (float)this.tendrilWiggleTickCount) / 10.0F;
	}

	public void setRapidlyWiggling(boolean newValue) {
		this.isRapidlyWiggling = newValue;
	}
	
	@Override
	public Data getVibrationData() {
		return this.vibrationData;
	}

	@Override
	public User getVibrationUser() {
		return this.vibrationUser;
	}
	
	@Override
	public Listener getListener() {
		return this.vibrationListener;
	}

	protected class VibrationUser implements VibrationSystem.User
	{
		public static final int LISTENER_RANGE = 8;
		protected final BlockPos blockPos;
		private final PositionSource positionSource;

		public VibrationUser(BlockPos p_283482_) {
			this.blockPos = p_283482_;
			this.positionSource = new BlockPositionSource(p_283482_);
		}

		public int getListenerRadius() {
			return 8;
		}

		public PositionSource getPositionSource() {
			return this.positionSource;
		}

		public boolean canTriggerAvoidVibration() {
			if (WardenSkullBlockEntity.this.getBlockState().hasProperty(BlockStateProperties.SCULK_SENSOR_PHASE)) {
				return WardenSkullBlockEntity.this.getBlockState().getValue(BlockStateProperties.SCULK_SENSOR_PHASE) == SculkSensorPhase.ACTIVE;
			}
			return false;
		}

		public boolean canReceiveVibration(ServerLevel p_282127_, BlockPos p_283268_, GameEvent p_282187_, @Nullable GameEvent.Context p_282856_) {
			return !p_283268_.equals(this.blockPos) || p_282187_ != GameEvent.BLOCK_DESTROY && p_282187_ != GameEvent.BLOCK_PLACE ? WardenHead.canActivate(WardenSkullBlockEntity.this.getBlockState()) : false;
		}

		public void onReceiveVibration(ServerLevel level, BlockPos pos, GameEvent event, @Nullable Entity instigatingEntity, @Nullable Entity p_283090_, float p_283130_) {
			BlockState blockstate = WardenSkullBlockEntity.this.getBlockState();
			if (blockstate.getBlock() instanceof WardenHead) {
				WardenHead head = (WardenHead)blockstate.getBlock();
				if (head.canJumpscare(level, blockstate, pos) && instigatingEntity instanceof ServerPlayer) {
					head.jumpscarePlayer(level, blockstate, pos, (ServerPlayer)instigatingEntity);
					WardenSkullBlockEntity.this.setRapidlyWiggling(true);
					head.setJumpscareCooldown(level, blockstate, WardenSkullBlockEntity.this.getBlockPos());
					level.scheduleTick(WardenSkullBlockEntity.this.worldPosition, blockstate.getBlock(), 300);
				}
			}
		}

		public void onDataChanged() {
			WardenSkullBlockEntity.this.setChanged();
		}

		public boolean requiresAdjacentChunksToBeTicking() {
			return true;
		}
	}
	
}
