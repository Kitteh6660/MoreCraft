package kittehmod.morecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class WitherSwordItem extends SwordItem {
	
	public IItemTier material;
	
	public WitherSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder)
	{
	    super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.WITHER, 100, 0));
		stack.damageItem(1, attacker, (p_220045_0_) -> {
			p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
}
