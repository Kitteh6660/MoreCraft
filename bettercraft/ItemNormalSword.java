package kittehmod.bettercraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemNormalSword extends ItemSword
{
	public EnumToolMaterial material;
	public int repairMaterial;
	
	public ItemNormalSword(int ItemID, EnumToolMaterial material, int par3RepairMaterial) 
	{
		super(ItemID, material);
		setCreativeTab(CreativeTabs.tabCombat);
		repairMaterial = par3RepairMaterial;
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

}