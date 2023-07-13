package kittehmod.morecraft.item;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BlazeArmorItem extends ModArmorItem
{
	public ArmorMaterial material;

	public BlazeArmorItem(ArmorMaterial materialIn, Type slot, Item.Properties builder)
	{
	    super(materialIn, slot, builder);
	}

    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return ModArmorMaterials.BLAZE;
    }
    
}