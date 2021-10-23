package kittehmod.morecraft.events;

import kittehmod.morecraft.entity.NetherBoat;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterial;
import kittehmod.morecraft.item.ModItems;
import kittehmod.morecraft.network.ModBoatDismountPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{

	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event) {
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherBoat) {
			event.getEntityMounting().clearFire();
			if (event.getEntityMounting() instanceof Player && event.getEntityMounting().level.isClientSide) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); // Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}

	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event) {
		if (event.getEntityLiving() != null && event.getEntityLiving().getVehicle() != null && event.getEntityLiving().getVehicle() instanceof NetherBoat) {
			if (event.getSource() == DamageSource.LAVA && !event.getEntityLiving().isEyeInFluid(FluidTags.LAVA)) {
				event.setCanceled(true);
				event.getEntityLiving().clearFire();
			}
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
			if (event.getEntityLiving() instanceof Player) {
				((Player) event.getEntityLiving()).displayClientMessage(new TranslatableComponent("messages.morecraft.ruby_armour_block"), true);
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
			if (entity.getItemBySlot(EquipmentSlot.FEET) != null && entity.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SLIME_BOOTS.get()) {
				float mult = (float) (event.getDamageMultiplier() * 0.25);
				float dist = event.getDistance();
				if (!entity.isSuppressingBounce()) {
					Vec3 vec3 = entity.getDeltaMovement();
					if (vec3.y < 0.0D) {
						double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
						entity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
					}
				}
				else {
					mult = (float) (event.getDamageMultiplier() * 0.4);
				}
				event.setDamageMultiplier(mult);
				entity.getItemBySlot(EquipmentSlot.FEET).hurtAndBreak(dist < 50 ? (int)Math.ceil(dist / 5) : 10, entity, (ent) -> {
	               ent.broadcastBreakEvent(EquipmentSlot.FEET);
	            });
				event.setResult(Result.DEFAULT);
			}
		}
	}

	// Blaze armour set effects
	@SubscribeEvent
	public void onTickPlayerEvent(PlayerTickEvent event) {
		if (ModArmorItem.countPiecesOfMaterial(event.player, ModArmorMaterial.BLAZE) >= 4) {
			MobEffectInstance effect = event.player.getEffect(MobEffects.FIRE_RESISTANCE);
			if (effect == null || effect.getDuration() < 10) {
				event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
			}
		}
	}
}
