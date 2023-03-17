package kittehmod.morecraft.enchantments;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ReinforcementEnchantment extends Enchantment
{

	protected ReinforcementEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
		super(rarity, category, slots);
	}

	public int getMinCost(int lvl) {
		return 8 + (lvl - 1) * this.getLevelCost();
	}

	public int getMaxCost(int lvl) {
		return this.getMinCost(lvl) + this.getLevelCost();
	}
	
	public int getLevelCost() {
		return 6;
	}

	public int getMaxLevel() {
		return 5;
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
		return 0;
	}
   
	public boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment);
	}
}
