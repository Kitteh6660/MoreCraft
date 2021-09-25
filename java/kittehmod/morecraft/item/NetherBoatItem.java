package kittehmod.morecraft.item;

import java.util.List;
import java.util.function.Predicate;

import kittehmod.morecraft.entity.NetherBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class NetherBoatItem extends Item 
{
	private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::canBeCollidedWith);
	private final NetherBoat.Type type;

	public NetherBoatItem(Item.Properties properties, NetherBoat.Type typeIn) {
		super(properties);
		this.type = typeIn;
	}
	
	/**
	* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	* {@link #onItemUse}.
	*/
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.ANY);
		if (raytraceresult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			Vec3 vec3d = playerIn.getEyePosition(1.0F);
			double d0 = 5.0D;
			List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vec3d.scale(d0)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vec3 vec3d1 = playerIn.getEyePosition(1.0F);
				for(Entity entity : list) {
					AABB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return InteractionResultHolder.pass(itemstack);
					}
				}
			}
			if (raytraceresult.getType() == HitResult.Type.BLOCK) {
				NetherBoat boatentity = new NetherBoat(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				boatentity.setBoatType(this.type);
				boatentity.setYRot(playerIn.getYRot());
				if (!worldIn.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
					return InteractionResultHolder.fail(itemstack);
				} else {
					if (!worldIn.isClientSide) {
						worldIn.addFreshEntity(boatentity);
					}
					if (!playerIn.getAbilities().instabuild) {
						itemstack.shrink(1);
					}
					playerIn.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResultHolder.success(itemstack);
				}
			} else {
				return InteractionResultHolder.pass(itemstack);
			}
		}
	}
}
