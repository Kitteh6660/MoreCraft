package kittehmod.morecraft.item;

import net.minecraft.entity.Entity;
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
	
}