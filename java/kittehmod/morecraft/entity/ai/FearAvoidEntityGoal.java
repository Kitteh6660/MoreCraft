package kittehmod.morecraft.entity.ai;

import java.util.EnumSet;
import java.util.function.Predicate;

import kittehmod.morecraft.effects.ModMobEffects;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.vector.Vector3d;

public class FearAvoidEntityGoal<T extends LivingEntity> extends Goal
{
	protected final CreatureEntity mob;
	private final double walkSpeedModifier;
	private final double sprintSpeedModifier;
	protected LivingEntity toAvoid;
	protected final float maxDist;
	protected Path path;
	protected final PathNavigator pathNav;
	protected final LivingEntity avoidEntity;
	protected final Predicate<LivingEntity> avoidPredicate;
	protected final Predicate<LivingEntity> predicateOnAvoidEntity;
	//private final TargetingConditions avoidEntityTargeting;

	public FearAvoidEntityGoal(CreatureEntity entity, LivingEntity entityToAvoid, float maxDistIn, double speedIn, double runSpeedIn) {
		this(entity, entityToAvoid, (p_25052_) -> { return true; }, maxDistIn, speedIn, runSpeedIn, EntityPredicates.NO_CREATIVE_OR_SPECTATOR::test);
	}

	public FearAvoidEntityGoal(CreatureEntity entity, LivingEntity entityToAvoid, Predicate<LivingEntity> p_25042_, float maxDistIn, double speedIn, double runSpeedIn, Predicate<LivingEntity> p_25046_) {
		this.mob = entity;
		this.avoidEntity = entityToAvoid;
		this.avoidPredicate = p_25042_;
		this.maxDist = maxDistIn;
		this.walkSpeedModifier = speedIn;
		this.sprintSpeedModifier = runSpeedIn;
		this.predicateOnAvoidEntity = p_25046_;
		this.pathNav = entity.getNavigation();
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		//this.avoidEntityTargeting = TargetingConditions.forCombat().range((double) maxDistIn).selector(p_25046_.and(p_25042_));
	}

	@Override
	public boolean canUse() {
		this.toAvoid = this.mob.distanceTo(this.avoidEntity) < this.maxDist ? this.avoidEntity : null;  // this.mob.level.getNearestEntity(this.mob.level.getEntitiesOfClass(this.avoidEntity, this.mob.getBoundingBox().inflate((double) this.maxDist, 3.0D, (double) this.maxDist), (p_148078_) -> { return true; }), this.avoidEntityTargeting, this.mob, this.mob.getX(), this.mob.getY(), this.mob.getZ());
		if (this.toAvoid == null) {
			return false;
		} else {
			Vector3d vec3 = RandomPositionGenerator.getPosAvoid(this.mob, 16, 7, this.toAvoid.position());
			if (vec3 == null) {
				return false;
			} else if (this.toAvoid.distanceToSqr(vec3.x, vec3.y, vec3.z) < this.toAvoid.distanceToSqr(this.mob)) {
				return false;
			} else {
				this.path = this.pathNav.createPath(vec3.x, vec3.y, vec3.z, 0);
				return this.path != null;
			}
		}
	}

	public boolean canContinueToUse() {
		boolean tocontinue = true;
		if (this.mob.getLastHurtByMob() == this.avoidEntity) {
			tocontinue = false;
		}
		if (this.pathNav.isDone()) {
			tocontinue = false;
		}
		if (this.mob.getEffect(ModMobEffects.SCARED.get()) == null) {
			tocontinue = false;
		}
		if (this.mob.getEffect(ModMobEffects.UNAFRAID.get()) != null) {
			tocontinue = false;
		}
		return tocontinue;
	}

	public void start() {
		this.pathNav.moveTo(this.path, this.walkSpeedModifier);
	}

	public void stop() {
		this.toAvoid = null;
	}

	public void tick() {
		if (this.mob.distanceToSqr(this.toAvoid) < 49.0D) {
			this.mob.getNavigation().setSpeedModifier(this.sprintSpeedModifier);
		} else {
			this.mob.getNavigation().setSpeedModifier(this.walkSpeedModifier);
		}
		if (this.mob.getEffect(ModMobEffects.SCARED.get()) == null || this.mob.getEffect(ModMobEffects.SCARED.get()).getDuration() <= 0) {
			if (this.mob.hasEffect(ModMobEffects.SCARED.get())) {
				this.mob.removeEffect(ModMobEffects.SCARED.get());
			}
			if (!this.mob.hasEffect(ModMobEffects.UNAFRAID.get())) {
				this.mob.addEffect(new EffectInstance(ModMobEffects.UNAFRAID.get(), 2400, 0, false, false));
			}
			this.mob.goalSelector.removeGoal(this);
		}
	}
}