package kittehmod.bettercraft;

import java.util.Random;
import java.lang.System;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
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
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDrop 
{

    public static double rand;
    public Random r = new Random();
    private int lootMod = 0;
    
	@ForgeSubscribe
    public void Drops(LivingDropsEvent event)
    {
		
        if(event.entityLiving instanceof EntitySheep)
        {
        	if (((EntitySheep) event.entityLiving).isBurning())
        	{
        		event.entityLiving.dropItem(BetterCraft.lambchopCooked.itemID, (r.nextInt(3) + 1 + r.nextInt(event.lootingLevel + 1)));
        	}
        	else
        	{
        		event.entityLiving.dropItem(BetterCraft.lambchopRaw.itemID, (r.nextInt(3) + 1 + r.nextInt(event.lootingLevel + 1)));
        	}
        }
        
        if(event.entityLiving instanceof EntitySquid)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(BetterCraft.squid.itemID, 1);
        }
        
        if(event.entityLiving instanceof EntitySpider)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(Item.silk.itemID, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.dropItem(BetterCraft.spiderMeatRaw.itemID, 1);
        }
        
        if(event.entityLiving instanceof EntityEnderman)
        {
        	if (((EntityEnderman) event.entityLiving).getCarried() != 0) //Prevents crash if Enderman carries nothing.
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
        				if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        					event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 0), 0.0F); //Use "itemID" not "shiftedIndex"
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
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 2), 0.0F); //Use "itemID" not "shiftedIndex"
        			}
        		}
        	}
        }
        
        if(event.entityLiving instanceof EntityCreeper)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random(); //Initializes double "rand"
        		if (event.entityLiving instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				if (r.nextInt(2) == 1)
        				{
        					event.entityLiving.entityDropItem(new ItemStack(Item.skull.itemID, 1, 4), 0.0F); //Use "itemID" not "shiftedIndex"
        				}
        				else
        				{
        					event.entityLiving.entityDropItem(new ItemStack(Block.tnt.blockID, 1, 0), 0.0F); //Use "itemID" not "shiftedIndex"
        				}
        			}
        		}
        	}
        }
        
        if(event.entityLiving instanceof EntityDragon)
        {
	        event.entityLiving.dropItem(BetterCraft.DragonscaleHelmet.itemID, 1);
	        event.entityLiving.dropItem(BetterCraft.DragonscaleBody.itemID, 1);
	        event.entityLiving.dropItem(BetterCraft.DragonscaleLegs.itemID, 1);
	        event.entityLiving.dropItem(BetterCraft.DragonscaleBoots.itemID, 1);
        }
    }
	
	public void OnDeath(LivingDeathEvent event)
	{
	}
	
}