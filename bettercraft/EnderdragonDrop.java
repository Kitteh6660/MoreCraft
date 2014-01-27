package kittehmod.bettercraft;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

/**
 * Name and cast of this class are irrelevant
 */
public class EnderdragonDrop {

	@ForgeSubscribe
    public void Drops(LivingDropsEvent event)
    {
        if(event.entityLiving instanceof EntityDragon)
        {
         event.entityLiving.dropItem(BetterCraft.DragonscaleHelmet.itemID, 1);
         event.entityLiving.dropItem(BetterCraft.DragonscaleBody.itemID, 1);
         event.entityLiving.dropItem(BetterCraft.DragonscaleLegs.itemID, 1);
         event.entityLiving.dropItem(BetterCraft.DragonscaleBoots.itemID, 1);
        }
    }
}