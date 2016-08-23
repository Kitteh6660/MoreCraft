package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraft.item.ItemArmor.ArmorMaterial;
public class ItemBlazeArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;

	public ItemBlazeArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, Item par6)
	{
	    super(par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.func_78044_b(par4);
	    this.func_77656_e(par2EnumArmorMaterial.func_78046_a(par4));
	    this.field_77777_bU = 1;
	    armorNamePrefix = armornamePrefix;
	    repairMaterial = par6;
	}
	
    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return MoreCraft.BLAZE_A;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.func_82169_q(0) != null && player.func_82169_q(0).func_77973_b().equals(MoreCraftItems.blaze_boots) && player.func_82169_q(1) != null && player.func_82169_q(1).func_77973_b().equals(MoreCraftItems.blaze_leggings) && player.func_82169_q(2) != null && player.func_82169_q(2).func_77973_b().equals(MoreCraftItems.blaze_chestplate) && player.func_82169_q(3) != null && player.func_82169_q(3).func_77973_b().equals(MoreCraftItems.blaze_helmet)) {
			 player.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 40));
		}
	}
    
    public EnumRarity func_77613_e(ItemStack par1ItemStack)
    {
        return EnumRarity.UNCOMMON;
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