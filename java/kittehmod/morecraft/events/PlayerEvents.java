package kittehmod.morecraft.events;

import kittehmod.morecraft.entity.NetherBoat;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterial;
import kittehmod.morecraft.network.ModBoatDismountPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{
	
	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event)
	{
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherBoat) {
			event.getEntityMounting().clearFire();
			if (event.getEntityMounting() instanceof Player) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); //Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}
	
	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event)
	{	
		if (event.getEntityLiving() != null && event.getEntityLiving().getVehicle() != null && event.getEntityLiving().getVehicle() instanceof NetherBoat) {
			if (event.getSource() == DamageSource.LAVA && !event.getEntityLiving().isEyeInFluid(FluidTags.LAVA)) {
				event.setCanceled(true);
				event.getEntityLiving().clearFire();
			}
		}
	}
	
	// Armour set effects that alter hurting
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) 
	{
		// Ruby armour
		int blockChance = 0;
		blockChance += ModArmorItem.countPiecesOfMaterial(event.getEntityLiving(), ModArmorMaterial.RUBY);
		int rand = (int)(Math.random() * 40); //Each piece is 2.5% chance to completely nullify damage.
		if (blockChance > rand) {
			if (event.getEntityLiving() instanceof Player) {
				((Player)event.getEntityLiving()).displayClientMessage(new TranslatableComponent("messages.morecraft.ruby_armour_block"), true);
			}
			event.setCanceled(true);
		}
		// Alter fire damage taken based on Obsidian or Spider Silk. Obsidian decreases fire damage, Spider Silk increases fire damage.
		if (event.getSource().isFire()) {
			float damage = event.getAmount();
			event.setAmount(damage * ModArmorItem.getFireDmgMultiplier(event.getEntityLiving()));
		}
	}
	
	// Blaze armour set effects
	@SubscribeEvent
	public void onTickPlayerEvent(PlayerTickEvent event)
	{
		if (ModArmorItem.countPiecesOfMaterial(event.player, ModArmorMaterial.BLAZE) >= 4) {
			MobEffectInstance effect = event.player.getEffect(MobEffects.FIRE_RESISTANCE);
        	if (effect == null || effect.getDuration() < 10) {
        		event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
        	}
		}
	}
}
