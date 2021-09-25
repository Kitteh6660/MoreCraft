package kittehmod.morecraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RandomEffectFoodItem extends Item {
	
	public RandomEffectFoodItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public boolean isEdible() {
		return true;
	}
	
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
    {
        if (!worldIn.isClientSide) {
            int rand = (int)(Math.random() * (stack.getItem() == ModItems.NETHER_APPLE_PIE.get() ? 80 : 100));
            int durationOffset = (int)(Math.random() * 15) * 20;
            int magnitude = 0;
            if (stack.getItem() == ModItems.NETHER_APPLE_PIE.get()) {
            	durationOffset *= 1.5;
            	if ((int)(Math.random() * 100) < 30) magnitude++;
            }
            //THE BAD
            if (rand < 5) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.POISON, 200 + durationOffset, magnitude));
            }
            else if (rand < 10) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300 + durationOffset, 0));
            }
            else if (rand < 15) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200 + durationOffset, 0));
            }
            else if (rand < 20) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300 + durationOffset, magnitude));
            }
            else if (rand < 25) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300 + durationOffset, magnitude));
            }
            else if (rand < 30) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300 + durationOffset, magnitude));
            }
            //THE GOOD
            else if (rand < 35) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200 + durationOffset, magnitude));
            }
            else if (rand < 40) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400 + durationOffset, magnitude));
            }
            else if (rand < 45) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.JUMP, 200 + durationOffset, magnitude));
            }
            else if (rand < 50) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300 + durationOffset, magnitude));
            }
            else if (rand < 55) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300 + durationOffset, magnitude));
            }
            else if (rand < 60) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 + durationOffset, magnitude));
            }
            else if (rand < 65) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300 + durationOffset, magnitude));
            }
            else if (rand < 70) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200 + durationOffset, 0));
            }
            //THE NEUTRAL
            else if (rand < 75) {
            	entityLiving.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300 + durationOffset, 0));
            }
        }
        return this.isEdible() ? entityLiving.eat(worldIn, stack) : stack;
    }
	
}
