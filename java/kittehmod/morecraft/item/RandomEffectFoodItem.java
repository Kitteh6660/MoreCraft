package kittehmod.morecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class RandomEffectFoodItem extends Item {
	
	public RandomEffectFoodItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public boolean isEdible() {
		return true;
	}
	
    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving)
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
            	entityLiving.addEffect(new EffectInstance(Effects.POISON, 200 + durationOffset, magnitude));
            }
            else if (rand < 10) {
            	entityLiving.addEffect(new EffectInstance(Effects.CONFUSION, 300 + durationOffset, 0));
            }
            else if (rand < 15) {
            	entityLiving.addEffect(new EffectInstance(Effects.BLINDNESS, 200 + durationOffset, 0));
            }
            else if (rand < 20) {
            	entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 300 + durationOffset, magnitude));
            }
            else if (rand < 25) {
            	entityLiving.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 300 + durationOffset, magnitude));
            }
            else if (rand < 30) {
            	entityLiving.addEffect(new EffectInstance(Effects.WEAKNESS, 300 + durationOffset, magnitude));
            }
            //THE GOOD
            else if (rand < 35) {
            	entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 200 + durationOffset, magnitude));
            }
            else if (rand < 40) {
            	entityLiving.addEffect(new EffectInstance(Effects.WATER_BREATHING, 400 + durationOffset, magnitude));
            }
            else if (rand < 45) {
            	entityLiving.addEffect(new EffectInstance(Effects.JUMP, 200 + durationOffset, magnitude));
            }
            else if (rand < 50) {
            	entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 300 + durationOffset, magnitude));
            }
            else if (rand < 55) {
            	entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 300 + durationOffset, magnitude));
            }
            else if (rand < 60) {
            	entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 300 + durationOffset, magnitude));
            }
            else if (rand < 65) {
            	entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 300 + durationOffset, magnitude));
            }
            else if (rand < 70) {
            	entityLiving.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200 + durationOffset, 0));
            }
            //THE NEUTRAL
            else if (rand < 75) {
            	entityLiving.addEffect(new EffectInstance(Effects.GLOWING, 300 + durationOffset, 0));
            }
        }
        return this.isEdible() ? entityLiving.eat(worldIn, stack) : stack;
    }
	
}
