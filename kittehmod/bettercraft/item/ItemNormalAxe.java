package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ItemNormalAxe extends ItemAxe 
{
	private String toolClass;
	// A holder object for the tool material
	private ToolMaterial material = null;
	// This is a list of 
	private static Set<Block> blocks = null;
	
	/**
	 * This initializes the ItemAxeCustom object.
	 * @param ToolMaterial material
	 */
	public ItemNormalAxe(ToolMaterial material, float damage, float speed) {
		super(material, damage - 1, speed - 4);
	}
	
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
    	if (this.material == MoreCraft.WITHERBONE_T) {
    		return MoreCraft.LEGENDARY;
    	}
    	if (this.material == MoreCraft.BLAZE_T) {
    		return par1ItemStack.isItemEnchanted() ? EnumRarity.RARE : EnumRarity.UNCOMMON;
    	}
        return par1ItemStack.isItemEnchanted() ? EnumRarity.RARE : EnumRarity.COMMON;
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(2, par3EntityLivingBase);
    	if (par1ItemStack.getItem().equals(MoreCraftItems.WITHERBONE_AXE)) { 
	        ((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(MobEffects.WITHER, 200));
	        return true;
    	}
    	if (par1ItemStack.getItem().equals(MoreCraftItems.BLAZE_AXE)) { 
            ((EntityLivingBase)par2EntityLivingBase).setFire(4);
            return true;
    	}
    	return true;
    }

}
