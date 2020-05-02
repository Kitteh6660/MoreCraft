package kittehmod.morecraft;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
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
    
    @SubscribeEvent
    public void Drops(LivingDropsEvent event)
    {
    	ItemStack stack;
    	EntityItem drop;
    	rand = Math.random();
        
    	//SQUIDS
        if (event.getEntityLiving() instanceof EntitySquid && MoreCraft.overrideMobDrops)
        {
        	event.getDrops().clear();
        	stack = event.getEntityLiving().isBurning() ? new ItemStack(MoreCraftItems.SQUID_COOKED, 1) : new ItemStack(MoreCraftItems.SQUID_RAW, 1);
        	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
        	event.getDrops().add(drop);
        }
        
        //SPIDERS
        if (event.getEntityLiving() instanceof EntitySpider && MoreCraft.overrideMobDrops)
        {
        	for (int i = 0; i < event.getDrops().size(); i++) {
        		if (event.getDrops().get(i).getItem().getItem() != Items.STRING) {
        			event.getDrops().remove(i);
        		}
        	}
        	stack = event.getEntityLiving().isBurning() ? new ItemStack(MoreCraftItems.SPIDER_COOKED, 1) : new ItemStack(MoreCraftItems.SPIDER_RAW, 1);
        	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
        	event.getDrops().add(drop);
        }
        
        //GUARDIANS
        if (event.getEntityLiving() instanceof EntityGuardian || event.getEntityLiving() instanceof EntityElderGuardian)
        {
        	stack = event.getEntityLiving().isBurning() ? new ItemStack(MoreCraftItems.GUARDIAN_MEAT_COOKED, 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1)) : new ItemStack(MoreCraftItems.GUARDIAN_MEAT_RAW, 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
        	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
        	event.getDrops().add(drop);
        }
        
        //ENDERMEN
        if (event.getEntityLiving() instanceof EntityEnderman)
        {
        	if (event.getSource().getDamageType().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005) && (event.getEntityLiving().dimension != 1 || Math.random() < 0.2D)) { //Checks for Damage Type.
            	stack = new ItemStack(Items.DIAMOND, 1);
            	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
				if (event.getEntityLiving().dimension != 1 || Math.random() < 0.2D) { //Chance is reduced by 80% in the End due to the abundance of Endermen.
					event.getDrops().add(drop);
				}
        	}
        }
        
        //SKELETONS
        if ((event.getEntityLiving() instanceof EntitySkeleton || event.getEntityLiving() instanceof EntityStray) && MoreCraft.mobHeadDrops)
        {
    		if (event.getSource().getDamageType().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) { 
            	stack = new ItemStack(Items.SKULL, 1, 0);
            	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
				event.getDrops().add(drop);
    		}
        }
        
        //ZOMBIES
        if ((event.getEntityLiving() instanceof EntityZombie || event.getEntityLiving() instanceof EntityHusk) && MoreCraft.mobHeadDrops)
        {
        	if (event.getSource().getDamageType().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
            	stack = new ItemStack(Items.SKULL, 1, 2);
            	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
				event.getDrops().add(drop);
        	}
        }
        
        //CREEPERS
        if (event.getEntityLiving() instanceof EntityCreeper)
        {
        	if (event.getSource().getDamageType().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
				stack = r.nextInt(2) == 1 && MoreCraft.mobHeadDrops ? new ItemStack(Items.SKULL, 1, 4) : new ItemStack(Blocks.TNT, 1, 0); //Equally 50/50 chance. If head drops are off and rare drop is rolled, only TNT will be dropped.
				drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
				event.getDrops().add(drop);
        	}
        }
        
        //ENDERDRAGONS
        if (event.getEntityLiving() instanceof EntityDragon)
        {
        	EntityDragon boss = (EntityDragon)event.getEntityLiving();
        	
        	//Drop #1: Enderdragon Scales
        	int amount = 8 + (int)(Math.random() * 6) + (int)(Math.random() * event.getLootingLevel() * 4);
        	if (boss.getFightManager().hasPreviouslyKilledDragon()) amount /= 2; //Amount is halved with repeat kills.
        	stack = new ItemStack(MoreCraftItems.ENDERDRAGON_SCALES, amount);
        	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
        	event.getDrops().add(drop);
        	
        	//Drop #2: Enderdragon Head
        	double chance = 0.2D + event.getLootingLevel() * 0.05;
        	if (!boss.getFightManager().hasPreviouslyKilledDragon()) amount = 1; //1st kill is guaranteed.
        	if (rand < chance && MoreCraft.mobHeadDrops) {
	        	stack = new ItemStack(Items.SKULL, 1, 5);
	        	drop = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, stack);
        		event.getDrops().add(drop);
        	}
        }
    }
	
}