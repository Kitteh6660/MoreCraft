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
        	event.entityLiving.func_145779_a(MoreCraftItems.squid_raw, 1);
        }
        
        if (event.entityLiving instanceof EntitySpider && MoreCraft.overrideMobDrops)
        {
        	event.setCanceled(true);
        	event.entityLiving.func_145779_a(Items.field_151007_F, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.func_145779_a(MoreCraftItems.spider_raw, 1);
        }
        
        if (event.entityLiving instanceof EntityGuardian)
        {
        	//event.entityLiving.dropItem(MoreCraftItems.guardian_scale, r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        	event.entityLiving.func_145779_a(MoreCraftItems.guardian_meat_raw, 1 + r.nextInt(3) + r.nextInt(event.lootingLevel + 1));
        }
        
        if (event.entityLiving instanceof EntityEnderman && MoreCraft.endermanBlockDrops) //This remains until mod is updated to 1.9.
        {
        	if (((EntityEnderman) event.entityLiving).func_175489_ck() != Blocks.field_150350_a.func_176223_P()) //Prevents crash if Enderman carries nothing.
        	{
        		event.entityLiving.func_70099_a(new ItemStack(Item.func_150898_a(((EntityEnderman) event.entityLiving).func_175489_ck().func_177230_c()), 1), 0.0F);;
        	}
        }
        
        if (event.entityLiving instanceof EntitySkeleton && MoreCraft.mobHeadDrops)
        {
        	if (((EntitySkeleton) event.entityLiving).func_82202_m() == 0)
        	{
        		if (event.source.func_76355_l().equals("player")) { //Checks for Damage Type.
        			rand = Math.random();
        			if (event.entityLiving instanceof EntitySkeleton) { //Checks the entity killed.
        				if (rand < 0.025D + (event.lootingLevel * 0.005)) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        					event.entityLiving.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 0), 0.0F);
        				}
        			}
        		}
       		}
        }
        
        if (event.entityLiving instanceof EntityZombie && MoreCraft.mobHeadDrops)
        {
        	if (event.source.func_76355_l().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.entityLiving instanceof EntityZombie) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				event.entityLiving.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 2), 0.0F);
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityCreeper && MoreCraft.mobHeadDrops)
        {
        	if (event.source.func_76355_l().equals("player")) { //Checks for Damage Type.
        		rand = Math.random();
        		if (event.entityLiving instanceof EntityCreeper) { //Checks the entity killed.
        			if (rand < 0.025D + event.lootingLevel * 0.005) { //Makes drop 2.5% drop chance plus 0.5% chance per Looting level.
        				if (r.nextInt(2) == 1) {
        					event.entityLiving.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 4), 0.0F);
        				}
        				else {
        					event.entityLiving.func_70099_a(new ItemStack(Blocks.field_150335_W, 1, 0), 0.0F);
        				}
        			}
        		}
        	}
        }
        
        if (event.entityLiving instanceof EntityDragon)
        {
	        event.entityLiving.func_145779_a(MoreCraftItems.enderdragon_helmet, 1);
	        event.entityLiving.func_145779_a(MoreCraftItems.enderdragon_chestplate, 1);
	        event.entityLiving.func_145779_a(MoreCraftItems.enderdragon_leggings, 1);
	        event.entityLiving.func_145779_a(MoreCraftItems.enderdragon_boots, 1);
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