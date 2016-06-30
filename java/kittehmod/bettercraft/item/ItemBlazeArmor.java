package kittehmod.bettercraft.item;

import kittehmod.bettercraft.BetterCraft;
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

public class ItemBlazeArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;

	public ItemBlazeArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, Item par6)
	{
	    super(par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.getDamageReductionAmount(par4);
	    this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
	    this.maxStackSize = 1;
	    armorNamePrefix = armornamePrefix;
	    repairMaterial = par6;
	}
	
    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return BetterCraft.BLAZE_A;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(BetterCraft.bootsBlaze) && player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(BetterCraft.leggingsBlaze) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(BetterCraft.chestplateBlaze) && player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(BetterCraft.helmetBlaze)) {
			 player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 40));
		}
	}
    
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.uncommon;
    }
    
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
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