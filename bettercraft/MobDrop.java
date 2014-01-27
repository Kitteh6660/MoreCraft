package kittehmod.bettercraft;

import java.util.Random;
import java.lang.System;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

/**
 * Name and cast of this class are irrelevant
 */
public class MobDrop {

    public static double rand;
    public Random r = new Random();
    
	@ForgeSubscribe
    public void Drops(LivingDropsEvent event)
    {
		
        if(event.entityLiving instanceof EntitySheep)
        {
        	event.entityLiving.dropItem(BetterCraft.lambchopRaw.itemID, r.nextInt(2) + 1);
        }
        
        if(event.entityLiving instanceof EntitySquid)
        {
        	event.entityLiving.dropItem(BetterCraft.squid.itemID, 1);
        }
        
        if(event.entityLiving instanceof EntitySpider)
        {
        	event.entityLiving.dropItem(BetterCraft.spiderMeatRaw.itemID, 1);
        }
        
        if(event.entityLiving instanceof EntityEnderman)
        {
        	System.out.println("Enderman drops");
        	if (((EntityEnderman) event.entityLiving).getCarried() != 0)
        	{
        		event.entityLiving.entityDropItem(new ItemStack(((EntityEnderman) event.entityLiving).getCarried(), 1, ((EntityEnderman) event.entityLiving).getCarryingData()), 0.0F);;
        	}
        }
        
        if(event.entityLiving instanceof EntitySkeleton)
        {
        	if (((EntitySkeleton) event.entityLiving).getSkeletonType() == 0)
        	{
        		if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        			rand = Math.random(); //Initializes double "rand"
        			if (event.entityLiving instanceof EntitySkeleton) { //Checks the entity killed.
        				if (rand < 0.025D) { //Makes drop 2.5% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        					event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 0), 0.0F); //Use "itemID" not "shiftedIndex"
        					//itemID is used for MCP, shiftedIndex is only used when already converted to .class.
        				}
        			}
        		}
       		}
        }
        
        if(event.entityLiving instanceof EntityZombie)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random(); //Initializes double "rand"
        		if (event.entityLiving instanceof EntityZombie) { //Checks the entity killed.
        			if (rand < 0.025D) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 2), 0.0F); //Use "itemID" not "shiftedIndex"
        				//itemID is used for MCP, shiftedIndex is only used when already converted to .class.
        			}
        		}
        	}
        }
        
        if(event.entityLiving instanceof EntityCreeper)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random(); //Initializes double "rand"
        		if (event.entityLiving instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 4), 0.0F); //Use "itemID" not "shiftedIndex"
        				//itemID is used for MCP, shiftedIndex is only used when already converted to .class.
        			}
        		}
        	}
        }
    }
	
	public void OnDeath(LivingDeathEvent event)
	{
	}
	
}