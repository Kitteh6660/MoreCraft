package kittehmod.bettercraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import net.minecraft.item.ItemArmor.ArmorMaterial;
public class ItemNormalArmor extends ItemArmor 
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;

	public ItemNormalArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, Item par6)
	{
	    super(par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    //this.setCreativeTab(CreativeTabs.tabCombat); 
	    par2EnumArmorMaterial.func_78044_b(par4);
	    this.func_77656_e(par2EnumArmorMaterial.func_78046_a(par4));
	    this.field_77777_bU = 1;
	    armorNamePrefix = armornamePrefix;
	    repairMaterial = par6;
	}

	public boolean func_82789_a(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.func_77973_b() ? true : super.func_82789_a(par1ItemStack, par2ItemStack);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {

		if (slot == 2)//(stack.toString().contains("legs") || stack.toString().contains("leggings") || stack.toString().contains("pants")) 
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_2.png";
		}
		else
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_1.png";
		}
	}
}