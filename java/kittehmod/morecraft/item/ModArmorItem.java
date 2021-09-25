package kittehmod.morecraft.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModArmorItem extends ArmorItem 
{
	private ArmorMaterial material;
	
	public ModArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder) {
		super(materialIn, slot, builder);
		this.material = materialIn;
	}
	
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
    	return "morecraft:textures/models/armor/" + material.getName() + "_layer_" + (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
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
    
    public static int countPiecesOfMaterial(LivingEntity entity, ArmorMaterial material) {
    	int amt = 0;
    	if (entity.getItemBySlot(EquipmentSlot.HEAD) != null && entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ArmorItem) {
    		if (((ArmorItem)entity.getItemBySlot(EquipmentSlot.HEAD).getItem()).getMaterial() == material) {
    			amt++;
    		}
    	}
    	if (entity.getItemBySlot(EquipmentSlot.CHEST) != null && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ArmorItem) {
    		if (((ArmorItem)entity.getItemBySlot(EquipmentSlot.CHEST).getItem()).getMaterial() == material) {
    			amt++;
    		}
    	}
    	if (entity.getItemBySlot(EquipmentSlot.LEGS) != null && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ArmorItem) {
    		if (((ArmorItem)entity.getItemBySlot(EquipmentSlot.LEGS).getItem()).getMaterial() == material) {
    			amt++;
    		}
    	}
    	if (entity.getItemBySlot(EquipmentSlot.FEET) != null && entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmorItem) {
    		if (((ArmorItem)entity.getItemBySlot(EquipmentSlot.FEET).getItem()).getMaterial() == material) {
    			amt++;
    		}
    	}
    	return amt;
    }
	
}