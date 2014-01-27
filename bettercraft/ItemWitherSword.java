package kittehmod.bettercraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemWitherSword extends ItemNormalSword
{
	public ItemWitherSword(int ItemID, EnumToolMaterial material, int par3RepairMaterial) 
	{
		super(ItemID, material, par3RepairMaterial);
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
    public EnumToolMaterial getToolMaterial(ItemStack par1ItemStack)
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


