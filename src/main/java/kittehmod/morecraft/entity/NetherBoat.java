package kittehmod.morecraft.entity;

import java.util.List;

import javax.annotation.Nullable;

import kittehmod.morecraft.init.ModBlocks;
import kittehmod.morecraft.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;

public class NetherBoat extends Boat
{
	private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(NetherBoat.class, EntityDataSerializers.INT);
	private final float[] paddlePositions = new float[2];
	private float invFriction;
	private float outOfControlTicks;
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private boolean inputLeft;
	private boolean inputRight;
	private boolean inputUp;
	private boolean inputDown;
	private double waterLevel;
	private float landFriction;
	private NetherBoat.Status status;
	private NetherBoat.Status oldStatus;
	private double lastYd;
	private boolean isAboveBubbleColumn;
	private boolean bubbleColumnDirectionIsDown;
	private float bubbleMultiplier;
	private float bubbleAngle;
	private float bubbleAngleO;

	public NetherBoat(EntityType<? extends NetherBoat> p_i50129_1_, Level p_i50129_2_) {
		super(p_i50129_1_, p_i50129_2_);
		this.blocksBuilding = true;
	}

	public NetherBoat(Level worldIn, double x, double y, double z) {
		this(ModEntities.NETHER_BOAT.get(), worldIn);
		this.setPos(x, y, z);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	protected boolean isMovementNoisy() {
		return false;
	}

	protected void defineSynchedData() {
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
		this.entityData.define(DATA_ID_TYPE, NetherBoat.Type.NETHERWOOD.ordinal());
		this.entityData.define(DATA_ID_PADDLE_LEFT, false);
		this.entityData.define(DATA_ID_PADDLE_RIGHT, false);
		this.entityData.define(DATA_ID_BUBBLE_TIME, 0);
	}

	public boolean canCollideWith(Entity p_241849_1_) {
		return canVehicleCollide(this, p_241849_1_);
	}

	public static boolean canVehicleCollide(Entity p_242378_0_, Entity p_242378_1_) {
		return (p_242378_1_.canBeCollidedWith() || p_242378_1_.isPushable()) && !p_242378_0_.isPassengerOfSameVehicle(p_242378_1_);
	}

	public boolean canBeCollidedWith() {
		return true;
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when
	 * colliding.
	 */
	public boolean isPushable() {
		return true;
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this
	 * one.
	 */
	public double getPassengersRidingOffset() {
		return -0.1D;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (!this.level().isClientSide && !this.isRemoved()) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + amount * 10.0F);
			this.markHurt();
			boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(this.getDropItem());
				}

				this.discard();
			}

			return true;
		} else {
			return true;
		}
	}

	public void onAboveBubbleCol(boolean downwards) {
		if (!this.level().isClientSide()) {
			this.isAboveBubbleColumn = true;
			this.bubbleColumnDirectionIsDown = downwards;
			if (this.getBubbleTime() == 0) {
				this.setBubbleTime(60);
			}
		}

		this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double) this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + (double) this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
		if (this.random.nextInt(20) == 0) {
			this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
		}

	}

	/**
	 * Applies a velocity to the entities, to push them away from eachother.
	 */
	public void push(Entity entityIn) {
		if (entityIn instanceof NetherBoat || entityIn instanceof Boat) {
			if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entityIn);
			}
		} else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entityIn);
		}

	}

	@Override
	public Item getDropItem() {
		switch (this.getNetherBoatType()) {
		case NETHERWOOD:
			return ModItems.NETHERWOOD_BOAT.get();
		case WARPED:
			return ModItems.WARPED_BOAT.get();
		case CRIMSON:
			return ModItems.CRIMSON_BOAT.get();
		default:
			return Items.OAK_BOAT;
		}
	}

	/**
	 * Setups the entity to do the hurt animation. Only used by packets in
	 * multiplayer.
	 */
	@OnlyIn(Dist.CLIENT)
	public void animateHurt() {
		this.setHurtDir(-this.getHurtDir());
		this.setHurtTime(10);
		this.setDamage(this.getDamage() * 11.0F);
	}

	public boolean isPickable() {
		return !this.isRemoved();
	}

	/**
	 * Sets a target for the client to interpolate towards over the next few ticks
	 */
	@OnlyIn(Dist.CLIENT)
	public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYRot = (double) yaw;
		this.lerpXRot = (double) pitch;
		this.lerpSteps = 10;
	}

	/**
	 * Gets the horizontal facing direction of this Entity, adjusted to take
	 * specially-treated entity types into account.
	 */
	public Direction getAdjustedHorizontalFacing() {
		return this.getDirection().getClockWise();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		this.oldStatus = this.status;
		this.status = this.getStatus();
		if (this.status != NetherBoat.Status.UNDER_WATER && this.status != NetherBoat.Status.UNDER_FLOWING_WATER) {
			this.outOfControlTicks = 0.0F;
		} else {
			++this.outOfControlTicks;
		}

		if (!this.level().isClientSide() && this.outOfControlTicks >= 60.0F) {
			this.ejectPassengers();
		}

		if (this.getHurtTime() > 0) {
			this.setHurtTime(this.getHurtTime() - 1);
		}

		if (this.getDamage() > 0.0F) {
			this.setDamage(this.getDamage() - 1.0F);
		}

		// super.tick();
		this.baseTick();
		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			if (this.getPassengers().isEmpty() || !(this.getPassengers().get(0) instanceof Player)) {
				this.setPaddleState(false, false);
			}

			this.floatBoat();
			if (this.level().isClientSide()) {
				this.controlBoat();
				this.level().sendPacketToServer(new ServerboundPaddleBoatPacket(this.getPaddleState(0), this.getPaddleState(1)));
			}

			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}

		this.tickBubbleColumn();

		for (int i = 0; i <= 1; ++i) {
			if (this.getPaddleState(i)) {
				if (!this.isSilent() && (double) (this.paddlePositions[i] % ((float) Math.PI * 2F)) <= (double) ((float) Math.PI / 4F) && ((double) this.paddlePositions[i] + (double) ((float) Math.PI / 8F))
						% (double) ((float) Math.PI * 2F) >= (double) ((float) Math.PI / 4F)) {
					SoundEvent soundevent = this.getPaddleSound();
					if (soundevent != null) {
						Vec3 vec3d = this.getViewVector(1.0F);
						double d0 = i == 1 ? -vec3d.z : vec3d.z;
						double d1 = i == 1 ? vec3d.x : -vec3d.x;
						this.level().playSound((Player) null, this.getX() + d0, this.getY(), this.getZ() + d1, soundevent, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
					}
				}

				this.paddlePositions[i] = (float) ((double) this.paddlePositions[i] + (double) ((float) Math.PI / 8F));
			} else {
				this.paddlePositions[i] = 0.0F;
			}
		}

		this.checkInsideBlocks();
		List<Entity> list = this.level().getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), EntitySelector.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level().isClientSide() && !(this.getControllingPassenger() instanceof Player);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}

	}

	private void tickBubbleColumn() {
		if (this.level().isClientSide()) {
			int i = this.getBubbleTime();
			if (i > 0) {
				this.bubbleMultiplier += 0.05F;
			} else {
				this.bubbleMultiplier -= 0.1F;
			}

			this.bubbleMultiplier = Mth.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
			this.bubbleAngleO = this.bubbleAngle;
			this.bubbleAngle = 10.0F * (float) Math.sin((double) (0.5F * (float) this.level().getGameTime())) * this.bubbleMultiplier;
		} else {
			if (!this.isAboveBubbleColumn) {
				this.setBubbleTime(0);
			}

			int k = this.getBubbleTime();
			if (k > 0) {
				--k;
				this.setBubbleTime(k);
				int j = 60 - k - 1;
				if (j > 0 && k == 0) {
					this.setBubbleTime(0);
					Vec3 vec3d = this.getDeltaMovement();
					if (this.bubbleColumnDirectionIsDown) {
						this.setDeltaMovement(vec3d.add(0.0D, -0.7D, 0.0D));
						this.ejectPassengers();
					} else {
						this.setDeltaMovement(vec3d.x, this.hasPassenger((entity) -> { return entity instanceof Player; }) ? 2.7D : 0.6D, vec3d.z);
					}
				}

				this.isAboveBubbleColumn = false;
			}
		}

	}

	@Nullable
	protected SoundEvent getPaddleSound() {
		switch (this.getStatus()) {
		case IN_WATER:
		case UNDER_WATER:
		case UNDER_FLOWING_WATER:
			return SoundEvents.BOAT_PADDLE_WATER;
		case ON_LAND:
			return SoundEvents.BOAT_PADDLE_LAND;
		case IN_AIR:
		default:
			return null;
		}
	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getX() + (this.lerpX - this.getX()) / (double) this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
			double d3 = Mth.wrapDegrees(this.lerpYRot - (double) this.getYRot());
			this.setYRot((float) ((double) this.getYRot() + d3 / (double) this.lerpSteps));
			this.setXRot((float) ((double) this.getXRot() + (this.lerpXRot - (double) this.getXRot()) / (double) this.lerpSteps));
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.getYRot(), this.getXRot());
		}
	}

	public void setPaddleState(boolean left, boolean right) {
		this.entityData.set(DATA_ID_PADDLE_LEFT, left);
		this.entityData.set(DATA_ID_PADDLE_RIGHT, right);
	}

	@OnlyIn(Dist.CLIENT)
	public float getRowingTime(int side, float limbSwing) {
		return this.getPaddleState(side) ? (float) Mth.clampedLerp((double) this.paddlePositions[side] - (double) ((float) Math.PI / 8F), (double) this.paddlePositions[side], (double) limbSwing) : 0.0F;
	}

	/**
	 * Determines whether the boat is in water, gliding on land, or in air
	 */
	private NetherBoat.Status getStatus() {
		NetherBoat.Status boatentity$status = this.isUnderwater();
		if (boatentity$status != null) {
			this.waterLevel = this.getBoundingBox().maxY;
			return boatentity$status;
		} else if (this.checkInWater()) {
			return NetherBoat.Status.IN_WATER;
		} else {
			float f = this.getGroundFriction();
			if (f > 0.0F) {
				this.landFriction = f;
				return NetherBoat.Status.ON_LAND;
			} else {
				return NetherBoat.Status.IN_AIR;
			}
		}
	}

	public float getWaterLevelAbove() {
		AABB axisalignedbb = this.getBoundingBox();
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.maxY);
		int l = Mth.ceil(axisalignedbb.maxY - this.lastYd);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		label39: for (int k1 = k; k1 < l; ++k1) {
			float f = 0.0F;

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(l1, k1, i2);
					FluidState fluidstate = this.level().getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) {
						f = Math.max(f, fluidstate.getHeight(this.level(), blockpos$mutable));
					}

					if (f >= 1.0F) {
						continue label39;
					}
				}
			}

			if (f < 1.0F) {
				return (float) blockpos$mutable.getY() + f;
			}
		}

		return (float) (l + 1);
	}

	/**
	 * Decides how much the boat should be gliding on the land (based on any
	 * slippery blocks)
	 */
	public float getGroundFriction() {
		AABB axisalignedbb = this.getBoundingBox();
		AABB axisalignedbb1 = new AABB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
		int i = Mth.floor(axisalignedbb1.minX) - 1;
		int j = Mth.ceil(axisalignedbb1.maxX) + 1;
		int k = Mth.floor(axisalignedbb1.minY) - 1;
		int l = Mth.ceil(axisalignedbb1.maxY) + 1;
		int i1 = Mth.floor(axisalignedbb1.minZ) - 1;
		int j1 = Mth.ceil(axisalignedbb1.maxZ) + 1;
		VoxelShape voxelshape = Shapes.create(axisalignedbb1);
		float f = 0.0F;
		int k1 = 0;
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		for (int l1 = i; l1 < j; ++l1) {
			for (int i2 = i1; i2 < j1; ++i2) {
				int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
				if (j2 != 2) {
					for (int k2 = k; k2 < l; ++k2) {
						if (j2 <= 0 || k2 != k && k2 != l - 1) {
							blockpos$mutable.set(l1, k2, i2);
							BlockState blockstate = this.level().getBlockState(blockpos$mutable);
							if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level(), blockpos$mutable).move((double) l1, (double) k2, (double) i2), voxelshape, BooleanOp.AND)) {
								f += blockstate.getFriction(this.level(), blockpos$mutable, this);
								++k1;
							}
						}
					}
				}
			}
		}

		return f / (float) k1;
	}

	private boolean checkInWater() {
		AABB axisalignedbb = this.getBoundingBox();
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.minY);
		int l = Mth.ceil(axisalignedbb.minY + 0.001D);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		boolean flag = false;
		this.waterLevel = -Double.MAX_VALUE;
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		for (int k1 = i; k1 < j; ++k1) {
			for (int l1 = k; l1 < l; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(k1, l1, i2);
					FluidState fluidstate = this.level().getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) {
						float f = (float) l1 + fluidstate.getHeight(this.level(), blockpos$mutable);
						this.waterLevel = Math.max((double) f, this.waterLevel);
						flag |= axisalignedbb.minY < (double) f;
					}
				}
			}
		}

		return flag;
	}

	/**
	 * Decides whether the boat is currently underwater.
	 */
	@Nullable
	private NetherBoat.Status isUnderwater() {
		AABB axisalignedbb = this.getBoundingBox();
		double d0 = axisalignedbb.maxY + 0.001D;
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.maxY);
		int l = Mth.ceil(d0);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		boolean flag = false;
		MutableBlockPos blockpos$mutable = new MutableBlockPos();

		for (int k1 = i; k1 < j; ++k1) {
			for (int l1 = k; l1 < l; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(k1, l1, i2);
					FluidState fluidstate = this.level().getFluidState(blockpos$mutable);
					if ((fluidstate.is(FluidTags.WATER) || fluidstate.is(FluidTags.LAVA)) && d0 < (double) ((float) blockpos$mutable.getY() + fluidstate.getHeight(this.level(), blockpos$mutable))) {
						if (!fluidstate.isSource()) {
							return NetherBoat.Status.UNDER_FLOWING_WATER;
						}

						flag = true;
					}
				}
			}
		}

		return flag ? NetherBoat.Status.UNDER_WATER : null;
	}

	/**
	 * Update the boat's speed, based on invFriction.
	 */
	private void floatBoat() {
		double d0 = (double) -0.04F;
		double d1 = this.isNoGravity() ? 0.0D : d0;
		double d2 = 0.0D;
		this.invFriction = 0.05F;
		if (this.oldStatus == NetherBoat.Status.IN_AIR && this.status != NetherBoat.Status.IN_AIR && this.status != NetherBoat.Status.ON_LAND) {
			this.waterLevel = this.getY(1.0D);
			this.setPos(this.getX(), (double) (this.getWaterLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
			this.lastYd = 0.0D;
			this.status = NetherBoat.Status.IN_WATER;
		} else {
			if (this.status == NetherBoat.Status.IN_WATER) {
				d2 = (this.waterLevel - this.getY()) / (double) this.getBbHeight();
				this.invFriction = 0.9F;
				if (this.isInLava()) {
					this.invFriction *= 0.6; // Decrease speed in lava.
					d2 += 0.35;
				}
			} else if (this.status == NetherBoat.Status.UNDER_FLOWING_WATER) {
				d1 = -7.0E-4D;
				this.invFriction = 0.9F;
				if (this.isInLava()) {
					this.invFriction *= 0.6; // Decrease speed in lava.
				}
			} else if (this.status == NetherBoat.Status.UNDER_WATER) {
				d2 = (double) 0.01F;
				this.invFriction = 0.45F;
			} else if (this.status == NetherBoat.Status.IN_AIR) {
				this.invFriction = 0.9F;
			} else if (this.status == NetherBoat.Status.ON_LAND) {
				this.invFriction = this.landFriction;
				if (this.getControllingPassenger() instanceof Player) {
					this.landFriction /= 2.0F;
				}
			}

			Vec3 vec3d = this.getDeltaMovement();
			this.setDeltaMovement(vec3d.x * (double) this.invFriction, vec3d.y + d1, vec3d.z * (double) this.invFriction);
			if (this.isInLava()) {
				this.deltaRotation *= (this.invFriction / 0.6);
			} else {
				this.deltaRotation *= this.invFriction;
			}
			if (d2 > 0.0D) {
				Vec3 vec3d1 = this.getDeltaMovement();
				this.setDeltaMovement(vec3d1.x, (vec3d1.y + d2 * 0.06153846016296973D) * 0.75D, vec3d1.z);
			}
		}
	}

	private void controlBoat() {
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.inputLeft) {
				--this.deltaRotation;
			}

			if (this.inputRight) {
				++this.deltaRotation;
			}

			if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
				f += 0.005F;
			}

			this.setYRot(this.getYRot() + this.deltaRotation);
			if (this.inputUp) {
				f += 0.04F;
			}

			if (this.inputDown) {
				f -= 0.005F;
			}

			this.setDeltaMovement(this.getDeltaMovement().add((double) (Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), 0.0D, (double) (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f)));
			this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
		}
	}

	@Override
	public void positionRider(Entity entity, Entity.MoveFunction func) {
		if (this.hasPassenger(entity)) {
			float f = 0.0F;
			float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + entity.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(entity);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (entity instanceof Animal) {
					f = (float) ((double) f + 0.2D);
				}
			}

			Vec3 vec3 = (new Vec3((double) f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			func.accept(entity, this.getX() + vec3.x, this.getY() + (double) f1, this.getZ() + vec3.z);
			entity.setYRot(entity.getYRot() + this.deltaRotation);
			entity.setYHeadRot(entity.getYHeadRot() + this.deltaRotation);
			this.clampRotation(entity);
			if (entity instanceof Animal && this.getPassengers().size() == this.getMaxPassengers()) {
				int j = entity.getId() % 2 == 0 ? 90 : 270;
				entity.setYBodyRot(((Animal) entity).yBodyRot + (float) j);
				entity.setYHeadRot(entity.getYHeadRot() + (float) j);
			}
		}
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity entityIn) {
		// Handle any cases where the boat would be on 1 block deep lava when trying to dismount.
		Vec3 vec3 = getCollisionHorizontalEscapeVector((double) (this.getBbWidth() * Mth.SQRT_OF_TWO), (double) entityIn.getBbWidth(), entityIn.getYRot());
		double d0 = this.getX() + vec3.x;
		double d1 = this.getZ() + vec3.z;
		BlockPos blockpos = BlockPos.containing(d0, this.getBoundingBox().maxY, d1);
		BlockPos blockpos1 = blockpos.below();
		if (this.level().getFluidState(blockpos1).is(FluidTags.LAVA)) {
			return (new Vec3(this.getX(), this.getY() + (entityIn.getBbHeight() / 2), this.getZ()));
		}
		// Otherwise, delegate to vanilla boat dismount functionality.
		return super.getDismountLocationForPassenger(entityIn);
	}

	/**
	 * Applies this boat's yaw to the given entity. Used to update the orientation
	 * of its passenger.
	 */
	protected void clampRotation(Entity entityToUpdate) {
		entityToUpdate.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		entityToUpdate.yRotO += f1 - f;
		entityToUpdate.setYRot(entityToUpdate.getYRot() + f1 - f);
		entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
	}

	/**
	 * Applies this entity's orientation (pitch/yaw) to another entity. Used to
	 * update passenger orientation.
	 */
	@OnlyIn(Dist.CLIENT)
	public void onPassengerTurned(Entity entityToUpdate) {
		this.clampRotation(entityToUpdate);
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getNetherBoatType().getName());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type", 8)) {
			this.setBoatType(NetherBoat.Type.byName(compound.getString("Type")));
		}

	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		if (player.isSecondaryUseActive()) {
			return InteractionResult.PASS;
		} else if (this.outOfControlTicks < 60.0F) {
			if (!this.level().isClientSide) {
				return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
			} else {
				return InteractionResult.SUCCESS;
			}
		} else {
			return InteractionResult.PASS;
		}
	}

	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
			if (onGroundIn) {
				if (this.fallDistance > 3.0F) {
					if (this.status != NetherBoat.Status.ON_LAND) {
						this.fallDistance = 0.0F;
						return;
					}

					this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());
					if (!this.level().isClientSide() && !this.isRemoved()) {
						this.discard();
						if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							for (int i = 0; i < 3; ++i) {
								this.spawnAtLocation(this.getNetherBoatType().getPlanks());
							}

							for (int j = 0; j < 2; ++j) {
								this.spawnAtLocation(Items.STICK);
							}
						}
					}
				}

				this.fallDistance = 0.0F;
			} else if (!(this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) || this.level().getFluidState(this.blockPosition().below()).is(FluidTags.LAVA)) && y < 0.0D) {
				this.fallDistance = (float) ((double) this.fallDistance - y);
			}

		}
	}

	public boolean getPaddleState(int side) {
		return this.entityData.<Boolean>get(side == 0 ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT) && this.getControllingPassenger() != null;
	}

	/**
	 * Sets the damage taken from the last hit.
	 */
	public void setDamage(float damageTaken) {
		this.entityData.set(DATA_ID_DAMAGE, damageTaken);
	}

	/**
	 * Gets the damage taken from the last hit.
	 */
	public float getDamage() {
		return this.entityData.get(DATA_ID_DAMAGE);
	}

	/**
	 * Sets the time to count down from since the last time entity was hit.
	 */
	public void setHurtTime(int timeSinceHit) {
		this.entityData.set(DATA_ID_HURT, timeSinceHit);
	}

	/**
	 * Gets the time since the last hit.
	 */
	public int getHurtTime() {
		return this.entityData.get(DATA_ID_HURT);
	}

	private void setBubbleTime(int p_203055_1_) {
		this.entityData.set(DATA_ID_BUBBLE_TIME, p_203055_1_);
	}

	private int getBubbleTime() {
		return this.entityData.get(DATA_ID_BUBBLE_TIME);
	}

	@OnlyIn(Dist.CLIENT)
	public float getBubbleAngle(float partialTicks) {
		return Mth.lerp(partialTicks, this.bubbleAngleO, this.bubbleAngle);
	}

	/**
	 * Sets the forward direction of the entity.
	 */
	public void setHurtDir(int forwardDirection) {
		this.entityData.set(DATA_ID_HURTDIR, forwardDirection);
	}

	/**
	 * Gets the forward direction of the entity.
	 */
	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	public void setBoatType(NetherBoat.Type boatType) {
		this.entityData.set(DATA_ID_TYPE, boatType.ordinal());
	}

	public NetherBoat.Type getNetherBoatType() {
		return NetherBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
	}

	protected boolean canFitPassenger(Entity passenger) {
		return this.getPassengers().size() < 2 && !this.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) && !this.isEyeInFluidType(ForgeMod.LAVA_TYPE.get());
	}

	/**
	 * For vehicles, the first passenger is generally considered the controller and
	 * "drives" the vehicle. For example, Pigs, Horses, and Boats are generally
	 * "steered" by the controlling passenger.
	 */
	@Nullable
	public LivingEntity getControllingPassenger() {
		return super.getControllingPassenger();
	}

	@OnlyIn(Dist.CLIENT)
	public void setInput(boolean p_184442_1_, boolean p_184442_2_, boolean p_184442_3_, boolean p_184442_4_) {
		this.inputLeft = p_184442_1_;
		this.inputRight = p_184442_2_;
		this.inputUp = p_184442_3_;
		this.inputDown = p_184442_4_;
	}

	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	// Forge: Fix MC-119811 by instantly completing lerp on board
	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpYRot, (float) this.lerpXRot);
		}
	}

	public static enum Status
	{
		IN_WATER, UNDER_WATER, UNDER_FLOWING_WATER, ON_LAND, IN_AIR;
	}

	public static enum Type
	{
		NETHERWOOD(ModBlocks.NETHERWOOD_PLANKS.get(), "netherwood"), CRIMSON(Blocks.CRIMSON_PLANKS, "crimson"), WARPED(Blocks.WARPED_PLANKS, "warped");

		private final String name;
		private final Block block;

		private Type(Block p_i48146_3_, String p_i48146_4_) {
			this.name = p_i48146_4_;
			this.block = p_i48146_3_;
		}

		public String getName() {
			return this.name;
		}

		public Block getPlanks() {
			return this.block;
		}

		public String toString() {
			return this.name;
		}

		/**
		 * Get a boat type by it's enum ordinal
		 */
		public static NetherBoat.Type byId(int id) {
			NetherBoat.Type[] aboatentity$type = values();
			if (id < 0 || id >= aboatentity$type.length) {
				id = 0;
			}

			return aboatentity$type[id];
		}

		public static NetherBoat.Type byName(String nameIn) {
			NetherBoat.Type[] aboatentity$type = values();

			for (int i = 0; i < aboatentity$type.length; ++i) {
				if (aboatentity$type[i].getName().equals(nameIn)) {
					return aboatentity$type[i];
				}
			}

			return aboatentity$type[0];
		}
	}

	@Override
	public void lavaHurt() {
		// This boat is immune to lava.
		this.clearFire();
	}
}
