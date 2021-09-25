package kittehmod.morecraft.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BlazeArmorItem extends ModArmorItem
{
	public ArmorMaterial material;

	public BlazeArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder)
	{
	    super(materialIn, slot, builder);
	}

    public ModArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return ModArmorMaterial.BLAZE;
    }
    
}