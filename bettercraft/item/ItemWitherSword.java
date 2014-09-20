package kittehmod.bettercraft.item;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemWitherSword extends ItemNormalSword
{
	public ItemWitherSword(ToolMaterial material, Item par3RepairMaterial) 
	{
		super(material, par3RepairMaterial);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
    public ToolMaterial getToolMaterial(ItemStack par1ItemStack)
    {
    	return BetterCraft.WITHERBONE_T;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        ((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
        return true;
    }
}


