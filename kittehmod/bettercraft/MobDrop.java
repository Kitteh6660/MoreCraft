package kittehmod.bettercraft;

import java.util.Random;
import java.lang.System;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDrop 
{

    public static double rand;
    public Random r = new Random();
    private int lootMod = 0;
    
    @SubscribeEvent
    public void Drops(LivingDropsEvent event)
    {
		
        if (event.entityLiving instanceof EntitySheep && BetterCraft.overrideMobDrops)
        {
        	if (((EntitySheep) event.entityLiving).isBurning())
        	{
        		event.entityLiving.dropItem(BetterCraft.lambchopCooked, (r.nextInt(3) + 1 + r.nextInt(event.lootingLevel + 1)));
        	}
        	else
        	{
        		event.entityLiving.dropItem(BetterCraft.lambchopRaw, (r.nextInt(3) + 1 + r.nextInt(event.lootingLevel + 1)));
        	}
        }
        
        if (event.entityLiving instanceof EntitySquid && BetterCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(BetterCraft.squid, 1);
        }
        
        if (event.entityLiving instanceof EntitySpider && BetterCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.entityLiving.dropItem(Items.string, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.dropItem(BetterCraft.spiderMeatRaw, 1);
        }
        
        if (event.entityLiving instanceof EntityEnderman && BetterCraft.endermanBlockDrops)
        {
        	if (((EntityEnderman) event.entityLiving).getCarriedBlock() != Blocks.air) //Prevents crash if Enderman carries nothing.
        	{
        		event.entityLiving.entityDropItem(new ItemStack(((EntityEnderman) event.entityLiving).getCarriedBlock(), 1, ((EntityEnderman) event.entityLiving).getCarryingData()), 0.0F);;
        	}
        }
        
        if (event.entityLiving instanceof EntitySkeleton && BetterCraft.mobHeadDrops)
        {
        	if (((EntitySkeleton) event.entityLiving).getSkeletonType() == 0)
        	{
        		if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        			rand = Math.random(); //Initializes double "rand"
        			if (event.entityLiving instanceof EntitySkeleton) { //Checks the entity killed.
        				if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        					event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 0), 0.0F); //Use "itemID" not "shiftedIndex"
        				}
        			}
        		}
       		}
        }
        
        if (event.entityLiving instanceof EntityZombie && BetterCraft.mobHeadDrops)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random(); //Initializes double "rand"
        		if (event.entityLiving instanceof EntityZombie) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 2), 0.0F); //Use "itemID" not "shiftedIndex"
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityCreeper && BetterCraft.mobHeadDrops)
        {
        	if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
        		rand = Math.random(); //Initializes double "rand"
        		if (event.entityLiving instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
        				if (r.nextInt(2) == 1)
        				{
        					event.entityLiving.entityDropItem(new ItemStack(Items.skull, 1, 4), 0.0F); //Use "itemID" not "shiftedIndex"
        				}
        				else
        				{
        					event.entityLiving.entityDropItem(new ItemStack(Blocks.tnt, 1, 0), 0.0F); //Use "itemID" not "shiftedIndex"
        				}
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityDragon)
        {
	        event.entityLiving.dropItem(BetterCraft.helmetEnderdragon, 1);
	        event.entityLiving.dropItem(BetterCraft.chestplateEnderdragon, 1);
	        event.entityLiving.dropItem(BetterCraft.leggingsEnderdragon, 1);
	        event.entityLiving.dropItem(BetterCraft.bootsEnderdragon, 1);
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