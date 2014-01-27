package kittehmod.bettercraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemNormalHoe extends ItemHoe
{
	public EnumToolMaterial material;
	public int repairMaterial;
	
	public ItemNormalHoe(int ItemID, EnumToolMaterial material, int par3RepairMaterial) 
	{
		super(ItemID, material);
		setCreativeTab(CreativeTabs.tabTools);
		repairMaterial = par3RepairMaterial;
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

}