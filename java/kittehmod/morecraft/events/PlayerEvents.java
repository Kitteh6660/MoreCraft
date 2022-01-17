package kittehmod.morecraft.events;

import kittehmod.morecraft.entity.NetherBoatEntity;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterial;
import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.network.ModBoatDismountPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{
	@SubscribeEvent
	public void LavaBoatAntiHurt(LivingAttackEvent event) {
		if (event.getEntityLiving() != null && event.getEntityLiving().getVehicle() != null && event.getEntityLiving().getVehicle() instanceof NetherBoatEntity) {
			if (event.getSource() == DamageSource.LAVA && !event.getEntityLiving().isEyeInFluid(FluidTags.LAVA)) {
				event.setCanceled(true);
				event.getEntityLiving().clearFire();
			}
		}
	}

	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event) {
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherBoatEntity) {
			event.getEntityMounting().clearFire();
			if (event.getEntityMounting() instanceof PlayerEntity && event.getEntityMounting().level.isClientSide) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); // Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}

	// Armour set effects that alter hurting
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		// Ruby armour
		int blockChance = 0;
		blockChance += ModArmorItem.countPiecesOfMaterial(event.getEntityLiving(), ModArmorMaterial.RUBY);
		int rand = (int) (Math.random() * 40); // Each piece is 2.5% chance to completely nullify damage.
		if (blockChance > rand) {
			if (event.getEntityLiving() instanceof PlayerEntity) {
				((PlayerEntity) event.getEntityLiving()).displayClientMessage(new TranslationTextComponent("messages.morecraft.ruby_armour_block"), true);
			}
			event.setCanceled(true);
		}
		// Alter fire damage taken based on Obsidian or Spider Silk. Obsidian decreases
		// fire damage, Spider Silk increases fire damage.
		if (event.getSource().isFire()) {
			float damage = event.getAmount();
			event.setAmount(damage * ModArmorItem.getFireDmgMultiplier(event.getEntityLiving()));
		}
	}

	@SubscribeEvent
	public void onFallEvent(LivingFallEvent event) {
		if (event.getEntityLiving() instanceof LivingEntity) {
			LivingEntity entity = event.getEntityLiving();
			if (entity.getItemBySlot(EquipmentSlotType.FEET) != null && entity.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.SLIME_BOOTS.get()) {
				float mult = (float) (event.getDamageMultiplier() * 0.25);
				float dist = event.getDistance();
				if (!entity.isSuppressingBounce()) {
					Vector3d vec3 = entity.getDeltaMovement();
					if (vec3.y < 0.0D) {
						double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
						entity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
					}
				}
				else {
					mult = (float) (event.getDamageMultiplier() * 0.4);
				}
				event.setDamageMultiplier(mult);
				entity.getItemBySlot(EquipmentSlotType.FEET).hurtAndBreak(dist < 50 ? (int)Math.ceil(dist / 5) : 10, entity, (ent) -> {
	               ent.broadcastBreakEvent(EquipmentSlotType.FEET);
	            });
				event.setResult(Result.DEFAULT);
			}
		}
	}
	
	@SubscribeEvent
	public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) {
		if (event.player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.BLAZE_HELMET.get() && event.player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.BLAZE_CHESTPLATE.get() && event.player
				.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.BLAZE_LEGGINGS.get() && event.player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.BLAZE_BOOTS.get()) {
			EffectInstance effect = event.player.getEffect(Effects.FIRE_RESISTANCE);
			if (effect == null || effect.getDuration() < 10) {
				event.player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, true, false));
			}
		}
	}

}
