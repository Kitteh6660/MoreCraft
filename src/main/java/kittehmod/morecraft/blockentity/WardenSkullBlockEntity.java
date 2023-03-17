package kittehmod.morecraft.blockentity;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;

import kittehmod.morecraft.block.WardenHead;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;

public class WardenSkullBlockEntity extends BlockEntity implements VibrationListener.VibrationListenerConfig
{
	private static final Logger LOGGER = LogUtils.getLogger();
	private VibrationListener listener;
	private int tendrilWiggleTickCount = 0;
	private boolean isRapidlyWiggling = false;

	public WardenSkullBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityType.WARDEN_HEAD.get(), pos, state);
		this.listener = new VibrationListener(new BlockPositionSource(this.worldPosition), 8, this, (VibrationListener.ReceivingEvent)null, 0.0F, 0);
	}

	@Override
	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		VibrationListener.codec(this).encodeStart(NbtOps.INSTANCE, this.listener).resultOrPartial(LOGGER::error).ifPresent((listener) -> { nbt.put("listener", listener); });
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		if (nbt.contains("listener", 10)) {
			VibrationListener.codec(this).parse(new Dynamic<>(NbtOps.INSTANCE, nbt.getCompound("listener"))).resultOrPartial(LOGGER::error).ifPresent((listener) -> { this.listener = listener; });
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
	
	public VibrationListener getListener() {
		return this.listener;
	}
	
	public boolean canTriggerAvoidVibration() {
		return false;
	}
	
	@Override
	public boolean shouldListen(ServerLevel level, GameEventListener listener, BlockPos pos, GameEvent event, Context context) {
		return (!this.isRemoved() && (!pos.equals(this.getBlockPos()) || event != GameEvent.BLOCK_DESTROY && event != GameEvent.BLOCK_PLACE) && ((WardenHead)this.getBlockState().getBlock()).canJumpscare(level, this.getBlockState(), this.getBlockPos()));
	}

	@Override
	public void onSignalReceive(ServerLevel level, GameEventListener listener, BlockPos pos, GameEvent event, Entity instigatingEntity, Entity p_223870_, float p_223871_) {
		BlockState blockstate = this.getBlockState();
		if (blockstate.getBlock() instanceof WardenHead) {
			WardenHead head = (WardenHead)blockstate.getBlock();
			if (head.canJumpscare(level, blockstate, pos) && instigatingEntity instanceof ServerPlayer) {
				head.jumpscarePlayer(level, blockstate, pos, (ServerPlayer)instigatingEntity);
				this.setRapidlyWiggling(true);
				head.setJumpscareCooldown(level, blockstate, this.getBlockPos());
				level.scheduleTick(this.worldPosition, blockstate.getBlock(), 300);
			}
		}
	}
	
	@Override
	public void onSignalSchedule() {
		this.setChanged();
	}

}
