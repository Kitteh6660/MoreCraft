package kittehmod.bettercraft.item;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemBlazeSword extends ItemNormalSword
{
	public ItemBlazeSword(ToolMaterial material, Item par3RepairMaterial) 
	{
		super(material, par3RepairMaterial);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
    public ToolMaterial getToolMaterial(ItemStack par1ItemStack)
    {
    	return BetterCraft.BLAZE_T;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        ((EntityLivingBase)par2EntityLivingBase).setFire(4);
        return true;
    }
}

