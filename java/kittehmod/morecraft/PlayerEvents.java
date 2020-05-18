package kittehmod.morecraft;

import kittehmod.morecraft.entity.NetherwoodBoatEntity;
import kittehmod.morecraft.network.ModBoatDismountPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{
	
	@SubscribeEvent
	public void LavaBoatAntiHurt(LivingAttackEvent event)
	{
		if (event.getEntityLiving().getRidingEntity() instanceof NetherwoodBoatEntity) {
			if (event.getSource().equals(DamageSource.ON_FIRE) || event.getSource().equals(DamageSource.IN_FIRE) || event.getSource().equals(DamageSource.LAVA)) {
				event.setCanceled(true);
				event.getEntityLiving().extinguish();
			}
		}
	}
	
	//Doesn't work for some reason... it does fire but fire won't extinguish.
	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event)
	{
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherwoodBoatEntity) {
			event.getEntityMounting().extinguish();
			if (event.getEntityMounting() instanceof PlayerEntity) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket());
			}
			event.setResult(Result.ALLOW);
		}
	}
	
}
