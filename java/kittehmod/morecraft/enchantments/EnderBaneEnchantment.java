package kittehmod.morecraft.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.common.extensions.IForgeEnchantment;

public class EnderBaneEnchantment extends Enchantment implements IForgeEnchantment
{

	protected EnderBaneEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slot) {
		super(rarity, category, slot);
	}

	public int getMinCost(int lvl) {
		return 5 + (lvl - 1) * this.getLevelCost();
	}

	public int getMaxCost(int lvl) {
		return this.getMinCost(lvl) + this.getLevelCost();
	}

	public int getLevelCost() {
		return 8;
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

	public boolean checkCompatibility(Enchantment enchantment) {
		if (enchantment instanceof DamageEnchantment damageenchantment) {
			return false;
		} else {
			return super.checkCompatibility(enchantment);
		}
	}

	public boolean canEnchant(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canEnchant(stack);
	}

	// This will be handled in events due to lack of Ender category.
	@Override
	public float getDamageBonus(int lvl, MobType mobtype, ItemStack stack) {
		return 0; 
	}
	
}
