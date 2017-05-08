package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
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

public class ItemSlimeArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;
	public int tickUntilSelfRepair = 200;
	public int tickUntilRegen = 200;

	public ItemSlimeArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, Item par6)
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
		return MoreCraft.SLIME_A;
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{

		this.tickUntilRegen--;
		this.tickUntilSelfRepair--;
		
		if (this.tickUntilRegen <= 0)
		{
			player.heal(1.0F);
			this.tickUntilRegen = 1200;
		}
		
		if (this.tickUntilSelfRepair <= 0)
		{
			itemStack.damageItem(-1, player);
			this.tickUntilSelfRepair = 200;
		}
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) 
	{
		return repairMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {

		if (slot == 2)
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_2.png";
		}
		else
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_1.png";
		}
	}
}