package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDrop 
{

    public static double rand;
    public Random r = new Random();
    private int lootMod = 0;
    
    @SubscribeEvent
    public void Drops(LivingDropsEvent event)
    {
		
    	//Lambchop removed from mod as muttons are now in vanilla Minecraft.
        
        if (event.entityLiving instanceof EntitySquid && MoreCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(MoreCraftItems.squid_raw, 1);
        }
        
        if (event.entityLiving instanceof EntitySpider && MoreCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(Items.string, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.dropItem(MoreCraftItems.spider_raw, 1);
        }
        
        if (event.entityLiving instanceof EntityGuardian)
        {
        	//event.entityLiving.dropItem(MoreCraftItems.guardian_scale, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.dropItem(MoreCraftItems.guardian_meat_raw, 1 + r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        }
        
        if (event.entityLiving instanceof EntityEnderman && MoreCraft.endermanBlockDrops) //This remains until mod is updated to 1.9.
        {
        	if (((EntityEnderman) event.entityLiving).getHeldBlockState() != Blocks.air.getDefaultState()) //Prevents crash if Enderman carries nothing.
        	{
        		event.entityLiving.entityDropItem(new ItemStack(Item.getItemFromBlock(((EntityEnderman) event.entityLiving).getHeldBlockState().getBlock()), 1), 0.0F);;
        	}
        }
        
        if (event.entityLiving instanceof EntitySkeleton && MoreCraft.mobHeadDrops)
        {
        	if (((EntitySkeleton) event.entityLiving).getSkeletonType() == 0)
        	{
        		if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        			rand = Math.random();
        			if (event.entityLiving instanceof EntitySkeleton) { //Checks the entity killed.
        				if (rand < 0.025D + (event.lootingLevel * 0.005)) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        					event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 0), 0.0F);
        				}
        			}
        		}
       		}
        }
        
        if (event.entityLiving instanceof EntityZombie && MoreCraft.mobHeadDrops)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.entityLiving instanceof EntityZombie) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 2), 0.0F);
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityCreeper && MoreCraft.mobHeadDrops)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.entityLiving instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				if (r.nextInt(2) == 1) {
        					event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 4), 0.0F);
        				}
        				else {
        					event.entityLiving.entityDropItem(new ItemStack(Blocks.tnt, 1, 0), 0.0F);
        				}
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityDragon)
        {
	        event.entityLiving.dropItem(MoreCraftItems.enderdragon_helmet, 1);
	        event.entityLiving.dropItem(MoreCraftItems.enderdragon_chestplate, 1);
	        event.entityLiving.dropItem(MoreCraftItems.enderdragon_leggings, 1);
	        event.entityLiving.dropItem(MoreCraftItems.enderdragon_boots, 1);
        }
    }
	
	public void OnDeath(LivingDeathEvent event)
	{
	}
	
	/*public void EnderDragonHitBlock(event)
	{
		event.setCanceled(true);
	}*/
	
}