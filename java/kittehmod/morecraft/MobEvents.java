package kittehmod.morecraft;

import java.util.Random;

import kittehmod.morecraft.item.ModItems;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MobEvents 
{

    public static double rand;
    public Random r = new Random();
    
    @SubscribeEvent
    public void Drops(LivingDropsEvent event)
    {
        
    	ItemStack stack;
    	ItemEntity drop;
    	rand = Math.random();
        
    	//SQUIDS
        if (event.getEntityLiving() instanceof SquidEntity && MoreCraftConfig.overrideMobDrops.get())
        {
        	event.getDrops().removeIf(e -> e.getItem().getItem() == Items.INK_SAC);
        	stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_SQUID.get(), 1) : new ItemStack(ModItems.RAW_SQUID.get(), 1);
        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
        	event.getDrops().add(drop);
        }
        
        //SPIDERS
        if (event.getEntityLiving() instanceof SpiderEntity && MoreCraftConfig.overrideMobDrops.get())
        {
        	event.getDrops().removeIf(e -> e.getItem().getItem() == Items.SPIDER_EYE);
        	stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_SPIDER.get(), 1) : new ItemStack(ModItems.RAW_SPIDER.get(), 1);
        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
        	event.getDrops().add(drop);
        }
        
        //GUARDIANS
        if (event.getEntityLiving() instanceof GuardianEntity || event.getEntityLiving() instanceof ElderGuardianEntity)
        {
        	stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_GUARDIAN_MEAT.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1)) : new ItemStack(ModItems.RAW_GUARDIAN_MEAT.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
        	event.getDrops().add(drop);
        	if (rand < 0.4D + (event.getLootingLevel() * 0.2) || event.getEntityLiving() instanceof ElderGuardianEntity) {
	        	stack = new ItemStack(ModItems.GUARDIAN_SCALES.get(), 1);
	        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
	        	event.getDrops().add(drop);
        	}
        }
        
        //ENDERMEN
        if (event.getEntityLiving() instanceof EndermanEntity)
        {
        	if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)/* && (event.getEntityLiving().world.dimensionType() != DimensionType.END_LOCATION || Math.random() < 0.2D)*/) { //Checks for Damage Type.
            	stack = new ItemStack(Items.DIAMOND, 1);
            	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
        	}
        }
        
        //SKELETONS
        if ((event.getEntityLiving() instanceof SkeletonEntity || event.getEntityLiving() instanceof StrayEntity) && MoreCraftConfig.mobHeadDrops.get())
        {
    		if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) { 
            	stack = new ItemStack(Items.SKELETON_SKULL, 1);
            	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
    		}
        }
        
        //ZOMBIES
        if ((event.getEntityLiving() instanceof ZombieEntity || event.getEntityLiving() instanceof HuskEntity) && MoreCraftConfig.mobHeadDrops.get())
        {
        	if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
            	stack = new ItemStack(Items.ZOMBIE_HEAD, 1);
            	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
        	}
        }
        
        //CREEPERS
        if (event.getEntityLiving() instanceof CreeperEntity)
        {
        	if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
				stack = r.nextInt(2) == 1 && MoreCraftConfig.mobHeadDrops.get() ? new ItemStack(Items.CREEPER_HEAD, 1) : new ItemStack(Items.TNT, 1); //Equally 50/50 chance. If head drops are off and rare drop is rolled, only TNT will be dropped.
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
        	}
        }
        
        //ENDERDRAGONS
        if (event.getEntityLiving() instanceof EnderDragonEntity)
        {
        	EnderDragonEntity boss = (EnderDragonEntity)event.getEntityLiving();
        	
        	//Drop #1: Enderdragon Scales
        	int amount = 8 + (int)(Math.random() * 6) + (int)(Math.random() * event.getLootingLevel() * 4);
        	if (boss.getDragonFight().hasPreviouslyKilledDragon()) amount /= 2; //Amount is halved with repeat kills.
        	stack = new ItemStack(ModItems.ENDERDRAGON_SCALES.get(), amount);
        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
        	event.getDrops().add(drop);
        	
        	//Drop #2: Enderdragon Meat
        	/*amount = 2 + (int)(Math.random() * 4) + (int)(Math.random() * event.getLootingLevel() * 2);
        	stack = new ItemStack(ModItems.RAW_DRAGON_MEAT.get(), amount);
        	drop = new ItemEntity(event.getEntityLiving().world, event.getEntityLiving().getPosX(), event.getEntityLiving().getPosY(), event.getEntityLiving().getPosZ(), stack);
        	event.getDrops().add(drop);*/
        	
        	//Drop #3: Enderdragon Head
        	double chance = 0.2D + event.getLootingLevel() * 0.05;
        	if (!boss.getDragonFight().hasPreviouslyKilledDragon()) amount = 1; //1st kill is guaranteed.
        	if (rand < chance && MoreCraftConfig.mobHeadDrops.get()) {
	        	stack = new ItemStack(Items.DRAGON_HEAD, 1);
	        	drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
        		event.getDrops().add(drop);
        	}
        }
        
    }
	
}