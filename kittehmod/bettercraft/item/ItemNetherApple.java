package kittehmod.bettercraft.item;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNetherApple extends ItemFood {

	private boolean alwaysEdible;
	
	public ItemNetherApple() {
		super(4, 0.2F, false);
		this.setCreativeTab(CreativeTabs.FOOD);
	}

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	if (worldIn.isRemote) return;
        int rand = (int)(Math.random() * 100);
        int durationOffset = (int)(Math.random() * 15) * 20;
        System.out.println("DEBUG: rolled " + rand + ", duration " + durationOffset);
        //THE BAD
        if (rand < 5) {
        	player.addPotionEffect(new PotionEffect(MobEffects.POISON, 200 + durationOffset));
        }
        else if (rand < 10) {
        	player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300 + durationOffset));
        }
        else if (rand < 15) {
        	player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200 + durationOffset));
        }
        else if (rand < 20) {
        	player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300 + durationOffset, 0));
        }
        else if (rand < 25) {
        	player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 300 + durationOffset, 0));
        }
        else if (rand < 30) {
        	player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 300 + durationOffset));
        }
        //THE GOOD
        else if (rand < 35) {
        	player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200 + durationOffset));
        }
        else if (rand < 40) {
        	player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 400 + durationOffset));
        }
        else if (rand < 45) {
        	player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200 + durationOffset));
        }
        else if (rand < 50) {
        	player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300 + durationOffset, 0));
        }
        else if (rand < 55) {
        	player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300 + durationOffset, 0));
        }
        else if (rand < 60) {
        	player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300 + durationOffset));
        }
    }
	
}
