package kittehmod.morecraft;

import kittehmod.morecraft.entity.NetherBoatEntity;
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
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{
	@SubscribeEvent
	public void LavaBoatAntiHurt(LivingAttackEvent event)
	{	
		if (event.getEntityLiving() != null && event.getEntityLiving().getVehicle() != null && event.getEntityLiving().getVehicle() instanceof NetherBoatEntity) {
			if (event.getSource() == DamageSource.LAVA && !event.getEntityLiving().isEyeInFluid(FluidTags.LAVA)) {
				event.setCanceled(true);
				event.getEntityLiving().clearFire();
			}
		}
	}
	
	
	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event)
	{
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherBoatEntity) {
			event.getEntityMounting().clearFire();
			if (event.getEntityMounting() instanceof PlayerEntity) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); //Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}
	
	@SubscribeEvent
	public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) 
	{
		if (event.player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.BLAZE_HELMET.get() && event.player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.BLAZE_CHESTPLATE.get() &&
			event.player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.BLAZE_LEGGINGS.get() && event.player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.BLAZE_BOOTS.get()) {
			EffectInstance effect = event.player.getEffect(Effects.FIRE_RESISTANCE);
        	if (effect == null || effect.getDuration() < 10) {
        		event.player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, true, false));
        	}
		}
	}
	
}
