package kittehmod.morecraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModArmorItem extends ArmorItem
{
	private IArmorMaterial material;

	public ModArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder) {
		super(materialIn, slot, builder);
		this.material = materialIn;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return "morecraft:textures/models/armor/" + material.getName() + "_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
	}

	public static float getFireDmgMultiplier(LivingEntity entity) {
		float amt = 1.0F;
		// Obsidian reduces fire damage, silk increases fire damage taken.
		amt -= countPiecesOfMaterial(entity, ModArmorMaterial.OBSIDIAN) * 0.1;
		amt += countPiecesOfMaterial(entity, ModArmorMaterial.SILK) * 0.1;
		return amt;
	}

	public static int getTotalFear(LivingEntity entity) {
		// Declares a variable for this function.
		int fear = 0;
		// Checks for each slot.
		fear += countPiecesOfMaterial(entity, ModArmorMaterial.BONE);
		fear += countPiecesOfMaterial(entity, ModArmorMaterial.BONELORD) * 2;
		fear += countPiecesOfMaterial(entity, ModArmorMaterial.WITHERBONE) * 2;
		// Clamps the value.
		if (fear < 0) {
			fear = 0;
		}
		if (fear > 10) {
			fear = 10;
		}
		// Returns the value.
		return fear;
	}

	public static int countPiecesOfMaterial(LivingEntity entity, IArmorMaterial material) {
		int amt = 0;
		if (entity.getItemBySlot(EquipmentSlotType.HEAD) != null && entity.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof ArmorItem) {
			if (((ArmorItem) entity.getItemBySlot(EquipmentSlotType.HEAD).getItem()).getMaterial() == material) {
				amt++;
			}
		}
		if (entity.getItemBySlot(EquipmentSlotType.CHEST) != null && entity.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem) {
			if (((ArmorItem) entity.getItemBySlot(EquipmentSlotType.CHEST).getItem()).getMaterial() == material) {
				amt++;
			}
		}
		if (entity.getItemBySlot(EquipmentSlotType.LEGS) != null && entity.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem) {
			if (((ArmorItem) entity.getItemBySlot(EquipmentSlotType.LEGS).getItem()).getMaterial() == material) {
				amt++;
			}
		}
		if (entity.getItemBySlot(EquipmentSlotType.FEET) != null && entity.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof ArmorItem) {
			if (((ArmorItem) entity.getItemBySlot(EquipmentSlotType.FEET).getItem()).getMaterial() == material) {
				amt++;
			}
		}
		return amt;
	}

}