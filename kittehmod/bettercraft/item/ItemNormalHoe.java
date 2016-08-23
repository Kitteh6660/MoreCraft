package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import net.minecraft.item.Item.ToolMaterial;
public class ItemNormalHoe extends ItemHoe
{
	public ToolMaterial material;
	public Item repairMaterial;
	
	public ItemNormalHoe(ToolMaterial material, Item par3RepairMaterial) 
	{
		super(material);
		//setCreativeTab(CreativeTabs.tabTools);
		repairMaterial = par3RepairMaterial;
	}
	
    public EnumRarity func_77613_e(ItemStack par1ItemStack)
    {
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.witherbone_hoe)) {
    		return MoreCraft.LEGENDARY;
    	}
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.blaze_hoe)) {
    		return EnumRarity.UNCOMMON;
    	}
        return EnumRarity.COMMON;
    }
	
	public boolean func_82789_a(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.func_77973_b() ? true : super.func_82789_a(par1ItemStack, par2ItemStack);
	}
	
    public boolean func_77644_a(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.witherbone_hoe)) { 
	        par1ItemStack.func_77972_a(0, par3EntityLivingBase);
	        ((EntityLivingBase)par2EntityLivingBase).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 200));
	        return true;
    	}
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.blaze_hoe)) { 
            par1ItemStack.func_77972_a(0, par3EntityLivingBase);
            ((EntityLivingBase)par2EntityLivingBase).func_70015_d(4);
            return true;
    	}
    	return true;
    }
}