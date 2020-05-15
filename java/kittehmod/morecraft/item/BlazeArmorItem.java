package kittehmod.morecraft.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlazeArmorItem extends ModArmorItem
{
	public IArmorMaterial material;

	public BlazeArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder)
	{
	    super(materialIn, slot, builder);
	}

    public ModArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return ModArmorMaterial.BLAZE;
    }
    
}