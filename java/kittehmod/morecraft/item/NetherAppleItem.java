/*package kittehmod.morecraft.item;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class NetherAppleItem extends Food {
	
	public NetherAppleItem() {
		super(4, 0.2F, false, false, false, null);
	}

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, PlayerEntity player)
    {
    	if (worldIn.isRemote) return;
        int rand = (int)(Math.random() * 100);
        int durationOffset = (int)(Math.random() * 15) * 20;
        System.out.println("DEBUG: rolled " + rand + ", duration " + durationOffset);
        //THE BAD
        if (rand < 5) {
        	player.addPotionEffect(new EffectInstance(Effects.POISON, 200 + durationOffset));
        }
        else if (rand < 10) {
        	player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300 + durationOffset));
        }
        else if (rand < 15) {
        	player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200 + durationOffset));
        }
        else if (rand < 20) {
        	player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300 + durationOffset, 0));
        }
        else if (rand < 25) {
        	player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 300 + durationOffset, 0));
        }
        else if (rand < 30) {
        	player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 300 + durationOffset));
        }
        //THE GOOD
        else if (rand < 35) {
        	player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200 + durationOffset));
        }
        else if (rand < 40) {
        	player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 400 + durationOffset));
        }
        else if (rand < 45) {
        	player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200 + durationOffset));
        }
        else if (rand < 50) {
        	player.addPotionEffect(new EffectInstance(Effects.SPEED, 300 + durationOffset, 0));
        }
        else if (rand < 55) {
        	player.addPotionEffect(new EffectInstance(Effects.HASTE, 300 + durationOffset, 0));
        }
        else if (rand < 60) {
        	player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300 + durationOffset));
        }
    }
	
}*/
