package kittehmod.morecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModHoeItem extends HoeItem {

	public ModHoeItem(IItemTier tier, int damageIn, float attackSpeedIn, Properties builder) {
		super(tier, damageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.getTier() == ModItemTier.BLAZE) {
			target.setSecondsOnFire(4);
		}
		else if (this.getTier() == ModItemTier.WITHERBONE) {
			target.addEffect(new EffectInstance(Effects.WITHER, 100, 0));
		}
		stack.hurtAndBreak(2, attacker, (p_220045_0_) -> {
			p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
}
