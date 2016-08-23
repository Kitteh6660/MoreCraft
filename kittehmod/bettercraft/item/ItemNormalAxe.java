package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import net.minecraft.item.Item.ToolMaterial;
public class ItemNormalAxe extends ItemAxe 
{
	public ToolMaterial material;
	public Item repairMaterial;
	
	public ItemNormalAxe(ToolMaterial material, Item par3RepairMaterial) 
	{
		super(material);
		//setCreativeTab(CreativeTabs.tabTools);
		repairMaterial = par3RepairMaterial;
	}
	
    public EnumRarity func_77613_e(ItemStack par1ItemStack)
    {
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.witherbone_axe)) {
    		return MoreCraft.LEGENDARY;
    	}
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.blaze_axe)) {
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
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.witherbone_axe)) { 
	        par1ItemStack.func_77972_a(2, par3EntityLivingBase);
	        ((EntityLivingBase)par2EntityLivingBase).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 200));
	        return true;
    	}
    	if (par1ItemStack.func_77973_b().equals(MoreCraftItems.blaze_axe)) { 
            par1ItemStack.func_77972_a(2, par3EntityLivingBase);
            ((EntityLivingBase)par2EntityLivingBase).func_70015_d(4);
            return true;
    	}
    	return true;
    }
}