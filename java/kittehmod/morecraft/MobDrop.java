package kittehmod.morecraft;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
        
        if (event.getEntityLiving() instanceof EntitySquid && MoreCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.getEntityLiving().dropItem(event.getEntityLiving().isBurning() ? MoreCraftItems.SQUID_COOKED : MoreCraftItems.SQUID_RAW, 1);
        }
        
        if (event.getEntityLiving() instanceof EntitySpider && MoreCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.getEntityLiving().dropItem(Items.STRING, r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
        	event.getEntityLiving().dropItem(event.getEntityLiving().isBurning() ? MoreCraftItems.SPIDER_COOKED : MoreCraftItems.SPIDER_RAW, 1);
        }
        
        if (event.getEntityLiving() instanceof EntityGuardian)
        {
        	event.getEntityLiving().dropItem(MoreCraftItems.GUARDIAN_MEAT_RAW, 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
        }
        
        if (event.getEntityLiving() instanceof EntityEnderman)
        {
        	if (event.getSource().getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.getEntityLiving() instanceof EntityEnderman) { //Checks the entity killed.
        			if (rand < 0.025D + event.getLootingLevel() * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				if (event.getEntityLiving().dimension != 1 || Math.random() < 0.2D) event.getEntityLiving().entityDropItem(new ItemStack(Items.DIAMOND, 1), 0.0F);
        			}
        		}
        	}
        }
        
        if (event.getEntityLiving() instanceof EntitySkeleton && MoreCraft.mobHeadDrops)
        {
        	if (event.getEntityLiving() instanceof EntitySkeleton || event.getEntityLiving() instanceof EntityStray)
        	{
        		if (event.getSource().getDamageType().equals("player")) { //Checks for Damage Type.
        			rand = Math.random();
        			if (event.getEntityLiving() instanceof EntitySkeleton) { //Checks the entity killed.
        				if (rand < 0.025D + (event.getLootingLevel() * 0.005)) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        					event.getEntityLiving().entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0F);
        				}
        			}
        		}
       		}
        }
        
        if (event.getEntityLiving() instanceof EntityZombie && MoreCraft.mobHeadDrops)
        {
        	if (event.getSource().getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.getEntityLiving() instanceof EntityZombie) { //Checks the entity killed.
        			if (rand < 0.025D + event.getLootingLevel() * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				event.getEntityLiving().entityDropItem(new ItemStack(Items.SKULL, 1, 2), 0.0F);
        			}
        		}
        	}
        }
        
        if (event.getEntityLiving() instanceof EntityCreeper && MoreCraft.mobHeadDrops)
        {
        	if (event.getSource().getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.getEntityLiving() instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D + event.getLootingLevel() * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				if (r.nextInt(2) == 1) {
        					event.getEntityLiving().entityDropItem(new ItemStack(Items.SKULL, 1, 4), 0.0F);
        				}
        				else {
        					event.getEntityLiving().entityDropItem(new ItemStack(Blocks.TNT, 1, 0), 0.0F);
        				}
        			}
        		}
        	}
        }
        
        if (event.getEntityLiving() instanceof EntityDragon)
        {
        	EntityDragon boss = (EntityDragon)event.getEntityLiving();
        	if (!boss.getFightManager().hasPreviouslyKilledDragon()) {
        		event.getEntityLiving().dropItem(MoreCraftItems.ENDERDRAGON_SCALES, 8 + (int)(Math.random() * 6) + (int)(Math.random() * event.getLootingLevel() * 4));
        	}
        	else {
        		event.getEntityLiving().dropItem(MoreCraftItems.ENDERDRAGON_SCALES, 4 + (int)(Math.random() * 3) + (int)(Math.random() * event.getLootingLevel() * 2));
        	}
        	if (rand < 0.2D + event.getLootingLevel() * 0.05 && MoreCraft.mobHeadDrops) {
        		event.getEntityLiving().entityDropItem(new ItemStack(Items.SKULL, 1, 5), 0.0F);
        	}
        }
    }
	
}