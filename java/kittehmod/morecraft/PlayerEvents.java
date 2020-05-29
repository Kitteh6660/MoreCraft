package kittehmod.morecraft;

import kittehmod.morecraft.entity.NetherwoodBoatEntity;
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
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreCraft.MODID)
public class PlayerEvents
{
	
	@SubscribeEvent
	public void LavaBoatAntiHurt(LivingAttackEvent event)
	{
		if (event.getEntityLiving().getRidingEntity() instanceof NetherwoodBoatEntity) {
			if (event.getSource().equals(DamageSource.ON_FIRE) || event.getSource().equals(DamageSource.IN_FIRE) || event.getSource().equals(DamageSource.LAVA)) {
				if (!event.getEntityLiving().getRidingEntity().areEyesInFluid(FluidTags.LAVA)) {
					event.setCanceled(true);
					event.getEntityLiving().extinguish();
				}
			}
		}
	}
	
	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event)
	{
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherwoodBoatEntity) {
			event.getEntityMounting().extinguish();
			if (event.getEntityMounting() instanceof PlayerEntity) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); //Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}
	
	@SubscribeEvent
	public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) 
	{
		if (event.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.BLAZE_HELMET.get() && event.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BLAZE_CHESTPLATE.get() &&
			event.player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.BLAZE_LEGGINGS.get() && event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.BLAZE_BOOTS.get()) {
			EffectInstance effect = event.player.getActivePotionEffect(Effects.FIRE_RESISTANCE);
        	if (effect == null || effect.getDuration() < 10) {
        		event.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, true, false));
        	}
		}
	}
	
}
