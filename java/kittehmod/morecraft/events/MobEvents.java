package kittehmod.morecraft.events;

import java.util.Random;

import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.effects.ModMobEffects;
import kittehmod.morecraft.entity.ai.FearAvoidEntityGoal;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModItemTags;
import kittehmod.morecraft.item.ModItems;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event.Result;

public class MobEvents
{

	public static double rand;
	public Random r = new Random();

	@SubscribeEvent
	public void Drops(LivingDropsEvent event) {

		ItemStack stack;
		ItemEntity drop;
		rand = Math.random();

		// SQUIDS
		if (event.getEntityLiving() instanceof Squid && MoreCraftConfig.overrideMobDrops.get()) {
			event.getDrops().removeIf(e -> e.getItem().getItem() == Items.INK_SAC);
			stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_SQUID.get(), 1) : new ItemStack(ModItems.RAW_SQUID.get(), 1);
			drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
			event.getDrops().add(drop);
		}

		// SPIDERS
		if (event.getEntityLiving() instanceof Spider && MoreCraftConfig.overrideMobDrops.get()) {
			event.getDrops().removeIf(e -> e.getItem().getItem() == Items.SPIDER_EYE);
			stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_SPIDER.get(), 1) : new ItemStack(ModItems.RAW_SPIDER.get(), 1);
			drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
			event.getDrops().add(drop);
		}
		
		// GOATS
		if (event.getEntityLiving() instanceof Goat && MoreCraftConfig.chevonDrops.get()) {
			if (!((Goat) event.getEntityLiving()).isBaby()) {
				stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_CHEVON.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1)) : new ItemStack(ModItems.RAW_CHEVON.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// GUARDIANS
		if (event.getEntityLiving() instanceof Guardian || event.getEntityLiving() instanceof ElderGuardian) {
			stack = event.getEntityLiving().isOnFire() ? new ItemStack(ModItems.COOKED_GUARDIAN_MEAT.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1))
					: new ItemStack(ModItems.RAW_GUARDIAN_MEAT.get(), 1 + r.nextInt(3) + r.nextInt(event.getLootingLevel() + 1));
			drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
			event.getDrops().add(drop);
			if (rand < 0.4D + (event.getLootingLevel() * 0.2) || event.getEntityLiving() instanceof ElderGuardian) {
				stack = new ItemStack(ModItems.GUARDIAN_SCALES.get(), 1);
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// ENDERMEN
		if (event.getEntityLiving() instanceof EnderMan) {
			if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)/*
																													 * && (event.getEntityLiving().world.dimensionType() !=
																													 * DimensionType.END_LOCATION || Math.random() < 0.2D)
																													 */) { // Checks for Damage Type.
				stack = new ItemStack(Items.DIAMOND, 1);
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// SKELETONS
		if ((event.getEntityLiving() instanceof Skeleton || event.getEntityLiving() instanceof Stray) && MoreCraftConfig.mobHeadDrops.get()) {
			if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
				stack = new ItemStack(Items.SKELETON_SKULL, 1);
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// ZOMBIES
		if ((event.getEntityLiving() instanceof Zombie || event.getEntityLiving() instanceof Husk) && MoreCraftConfig.mobHeadDrops.get()) {
			if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
				stack = new ItemStack(Items.ZOMBIE_HEAD, 1);
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// CREEPERS
		if (event.getEntityLiving() instanceof Creeper) {
			if (event.getSource().getMsgId().equals("player") && rand < 0.025D + (event.getLootingLevel() * 0.005)) {
				stack = r.nextInt(2) == 1 && MoreCraftConfig.mobHeadDrops.get() ? new ItemStack(Items.CREEPER_HEAD, 1) : new ItemStack(Items.TNT, 1); // Equally 50/50 chance. If head drops are off and rare drop is rolled, only TNT
																																						// will be dropped.
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

		// ENDERDRAGONS
		if (event.getEntityLiving() instanceof EnderDragon) {
			EnderDragon boss = (EnderDragon) event.getEntityLiving();

			// Drop #1: Enderdragon Scales
			int amount = 8 + (int) (Math.random() * 6) + (int) (Math.random() * event.getLootingLevel() * 4);
			if (boss.getDragonFight().hasPreviouslyKilledDragon())
				amount /= 2; // Amount is halved with repeat kills.
			stack = new ItemStack(ModItems.ENDERDRAGON_SCALES.get(), amount);
			drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
			event.getDrops().add(drop);

			// Drop #2: Enderdragon Meat
			/*
			 * amount = 2 + (int)(Math.random() * 4) + (int)(Math.random() *
			 * event.getLootingLevel() * 2); stack = new
			 * ItemStack(ModItems.RAW_DRAGON_MEAT.get(), amount); drop = new
			 * ItemEntity(event.getEntityLiving().world, event.getEntityLiving().getPosX(),
			 * event.getEntityLiving().getPosY(), event.getEntityLiving().getPosZ(), stack);
			 * event.getDrops().add(drop);
			 */

			// Drop #3: Enderdragon Head
			double chance = 0.2D + event.getLootingLevel() * 0.05;
			if (!boss.getDragonFight().hasPreviouslyKilledDragon())
				amount = 1; // 1st kill is guaranteed.
			if (rand < chance && MoreCraftConfig.mobHeadDrops.get()) {
				stack = new ItemStack(Items.DRAGON_HEAD, 1);
				drop = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), stack);
				event.getDrops().add(drop);
			}
		}

	}
	
	@SubscribeEvent
	public void onDamageEvent(LivingDeathEvent event) {
		if (event.getEntity() instanceof ItemEntity) {
			ItemEntity ie = (ItemEntity) event.getEntity();
			if (ie.getItem().is(ModItemTags.CACTUS_IMMUNE) && event.getSource() == DamageSource.CACTUS) {
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void creeperExplodeEvent(final ExplosionEvent event) {
		if (event.getExplosion().getSourceMob() instanceof Creeper) {
			Creeper creeper = (Creeper)event.getExplosion().getSourceMob();
			if (creeper.hasEffect(ModMobEffects.UNAFRAID.get())) {
				creeper.removeEffect(ModMobEffects.UNAFRAID.get());
			}
			if (creeper.hasEffect(ModMobEffects.SCARED.get())) {
				creeper.removeEffect(ModMobEffects.SCARED.get());
			}
			event.setResult(Result.DEFAULT);
		}
	}
	
	@SubscribeEvent
	public void updateMonsterEvent(final LivingEvent.LivingUpdateEvent event) {
		if (event.getEntity() instanceof Witch) {
			Witch witch = (Witch)event.getEntity();
			if (!((GroundPathNavigation)witch.getNavigation()).canOpenDoors()) {
				((GroundPathNavigation)witch.getNavigation()).setCanOpenDoors(true);
				if (witch.goalSelector.getRunningGoals().count() > 0) {
					witch.goalSelector.addGoal(1, new OpenDoorGoal(witch, true));
				}
			}
		}
		if (event.getEntityLiving() instanceof Monster) {
			Monster mob = (Monster) event.getEntityLiving();
			MobEffectInstance unafraid = mob.getEffect(ModMobEffects.UNAFRAID.get());
			MobEffectInstance scared = mob.getEffect(ModMobEffects.SCARED.get());
			if (mob.getTarget() != null) {
				int fearFactor = ModArmorItem.getTotalFear(mob.getTarget());
				int rand = (int)(Math.random() * 20);
				//Decrease chance for tougher mobs.
				if (mob.getMaxHealth() > 20) {
					fearFactor -= Math.floor((mob.getMaxHealth() - 20) / 5);
				}
				if (!isMobImmuneToFear(mob)) { //The bosses and minibosses do not fear the player.
					if (fearFactor > rand && unafraid == null && scared == null) {
						if (mob.goalSelector.getRunningGoals().count() > 0) {
							mob.addEffect(new MobEffectInstance(ModMobEffects.SCARED.get(), 400, 0, false, false));
							if (mob.goalSelector.getRunningGoals().count() > 0) {
								mob.goalSelector.addGoal(1, new FearAvoidEntityGoal<>(mob, mob.getTarget(), 24.0F, 0.8D, 1.0D));
							}
						}
					}
					else if (fearFactor > 0 && unafraid == null) { 
						mob.addEffect(new MobEffectInstance(ModMobEffects.UNAFRAID.get(), 1200, 0, false, false));
					}
				}
			}
		}
	}
	
	private static boolean isMobImmuneToFear(LivingEntity entity) {
		if (entity instanceof EnderDragon || entity instanceof WitherBoss || entity instanceof ElderGuardian || entity instanceof PiglinBrute || entity instanceof Ravager) {
			return true;
		}
		if (entity.getMaxHealth() >= 100) { //Accounts for any possible minibosses or bosses added with the mods.
			return true;
		}
		return false;
	}

}