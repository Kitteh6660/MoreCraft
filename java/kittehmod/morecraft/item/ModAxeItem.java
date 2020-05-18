package kittehmod.morecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModAxeItem extends AxeItem {

	public ModAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.getTier() == ModItemTier.BLAZE) {
			target.setFire(4);
		}
		else if (this.getTier() == ModItemTier.WITHERBONE) {
			target.addPotionEffect(new EffectInstance(Effects.WITHER, 100, 0));
		}
		stack.damageItem(2, attacker, (p_220045_0_) -> {
			p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
}
