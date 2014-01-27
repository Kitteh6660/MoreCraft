package kittehmod.bettercraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSlimeArmor extends ItemArmor
{
	public String armorNamePrefix;
	public EnumArmorMaterial material;
	public int repairMaterial;

	public ItemSlimeArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, int par6)
	{
	    super(par1, par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.getDamageReductionAmount(par4);
	    this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
	    this.maxStackSize = 1;
	    armorNamePrefix = armornamePrefix;
	    repairMaterial = par6;
	}
	
	public EnumArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
	{
		return BetterCraft.SLIME_A;
	}
	
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack) 
	{

		ItemStack helmet = player.getCurrentItemOrArmor(4);
		ItemStack plate = player.getCurrentItemOrArmor(3);
		ItemStack legs = player.getCurrentItemOrArmor(2);
		ItemStack boots = player.getCurrentItemOrArmor(1); 
		
		if (SlimeArmorProgress.ticksUntilRegen > 0)
		{
			SlimeArmorProgress.ticksUntilRegen = SlimeArmorProgress.ticksUntilRegen - 1;
		}
		
		if ((SlimeArmorProgress.ticksUntilRegen & 100) == 0)
		{
			System.out.println(SlimeArmorProgress.ticksUntilRegen);
		}
		
		if (SlimeArmorProgress.ticksUntilRegen == 0)
		{
			player.heal(1.0F);
			SlimeArmorProgress.ticksUntilRegen = 1200;
		}
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {

		if (stack.toString().contains("Legs") || stack.toString().contains("Leggings") || stack.toString().contains("Pants")) 
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_2.png";
		}
		return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_1.png";
	}
}