/*package kittehmod.morecraft.item;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemWitherArmor extends ArmorItem
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;
	
	public ItemWitherArmor(ArmorItem.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
	    super(materialIn, renderIndexIn, equipmentSlotIn);
	}

    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return MoreCraft.WITHERBONE_A;
    }
	
    public Rarity getRarity(ItemStack par1ItemStack)
    {
        return MoreCraft.LEGENDARY;
    }
    
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
    
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {

		if (slot == 2)//(stack.toString().contains("legs") || stack.toString().contains("leggings") || stack.toString().contains("pants")) 
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_2.png";
		}
		else
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_1.png";
		}
	}
}*/