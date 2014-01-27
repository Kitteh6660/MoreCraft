package kittehmod.bettercraft;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemEnderArmor extends ItemArmor
{
	public String armorNamePrefix;
	public EnumArmorMaterial material;

	public ItemEnderArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix)
	{
	    super(par1, par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.getDamageReductionAmount(par4);
	    this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
	    this.maxStackSize = 1;
	    armorNamePrefix = armornamePrefix;
	}

    public EnumArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return BetterCraft.ENDERDRAGON_A;
    }
	
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
		if (stack.toString().contains("leggings")) 
		{
			return "BetterCraft:" + armorNamePrefix + "_layer_2.png";
		}
		
		if (stack.toString().contains("Leggings")) 
		{
			return "BetterCraft:" + armorNamePrefix + "_layer_2.png";
		}
		return "BetterCraft:" + armorNamePrefix + "_layer_1.png";
	}
}