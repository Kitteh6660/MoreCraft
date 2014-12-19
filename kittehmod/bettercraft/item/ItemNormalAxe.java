package kittehmod.bettercraft.item;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

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
	
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
    	if (par1ItemStack.getItem().equals(BetterCraft.axeWitherbone)) {
    		return BetterCraft.legendary;
    	}
    	if (par1ItemStack.getItem().equals(BetterCraft.axeBlaze)) {
    		return EnumRarity.uncommon;
    	}
        return EnumRarity.common;
    }
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if (par1ItemStack.getItem().equals(BetterCraft.axeWitherbone)) { 
	        par1ItemStack.damageItem(2, par3EntityLivingBase);
	        ((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
	        return true;
    	}
    	if (par1ItemStack.getItem().equals(BetterCraft.axeBlaze)) { 
            par1ItemStack.damageItem(2, par3EntityLivingBase);
            ((EntityLivingBase)par2EntityLivingBase).setFire(4);
            return true;
    	}
    	return true;
    }
}