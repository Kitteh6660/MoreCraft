package kittehmod.morecraft.item;

import java.util.List;
import java.util.function.Predicate;

import kittehmod.morecraft.entity.NetherBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class NetherBoatItem extends Item 
{
	private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::canBeCollidedWith);
	private final NetherBoatEntity.Type type;

	public NetherBoatItem(Item.Properties properties, NetherBoatEntity.Type typeIn) {
		super(properties);
		this.type = typeIn;
	}
	
	/**
	* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	* {@link #onItemUse}.
	*/
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else {
			Vector3d vec3d = playerIn.getEyePosition(1.0F);
			double d0 = 5.0D;
			List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vec3d.scale(d0)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vector3d vec3d1 = playerIn.getEyePosition(1.0F);
				for(Entity entity : list) {
					AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return new ActionResult<>(ActionResultType.PASS, itemstack);
					}
				}
			}
			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
				NetherBoatEntity boatentity = new NetherBoatEntity(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				boatentity.setBoatType(this.type);
				boatentity.yRot = playerIn.yRot;
				if (!worldIn.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
					return new ActionResult<>(ActionResultType.FAIL, itemstack);
				} else {
					if (!worldIn.isClientSide) {
						worldIn.addFreshEntity(boatentity);
					}

					if (!playerIn.abilities.instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
				}
			} else {
				return new ActionResult<>(ActionResultType.PASS, itemstack);
			}
		}
	}
}
