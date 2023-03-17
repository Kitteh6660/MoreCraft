package kittehmod.morecraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class ModHoeItem extends HoeItem {

	public ModHoeItem(Tier tier, int damageIn, float attackSpeedIn, Properties builder) {
		super(tier, damageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.getTier() == ModTier.BLAZE) {
			target.setSecondsOnFire(4);
		}
		else if (this.getTier() == ModTier.WITHERBONE) {
			target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
		}
		stack.hurtAndBreak(2, attacker, (entity) -> {
			entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		return true;
	}
}
