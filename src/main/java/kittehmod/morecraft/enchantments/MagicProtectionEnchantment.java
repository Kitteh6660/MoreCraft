package kittehmod.morecraft.enchantments;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class MagicProtectionEnchantment extends Enchantment
{

	protected MagicProtectionEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
		super(rarity, category, slots);
	}

	public int getMinCost(int lvl) {
		return 10 + (lvl - 1) * this.getLevelCost();
	}

	public int getMaxCost(int lvl) {
		return this.getMinCost(lvl) + this.getLevelCost();
	}
	
	public int getLevelCost() {
		return 8;
	}

	public int getMaxLevel() {
		return 4;
	}
	
	public boolean isTreasureOnly() {
		return false;
	}
   
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.canApplyAtEnchantingTable(this);
	}
	
	public boolean isAllowedOnBooks() {
		return true;
	}
	
	public boolean isTradeable() {
		return true;
	}

	public boolean isDiscoverable() {
		return true;
	}
	
	public int getDamageProtection(int amt, DamageSource source) {
		if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC) || source.is(DamageTypes.DRAGON_BREATH)) {
			return amt * 2;
		}
		else {
			return 0;
		}
	}
   
	public boolean checkCompatibility(Enchantment enchantment) {
		if (enchantment instanceof ProtectionEnchantment protectionenchantment) {
			return protectionenchantment.type == ProtectionEnchantment.Type.FALL;
		} else {
			return super.checkCompatibility(enchantment);
		}
	}
}
