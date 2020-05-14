/*package kittehmod.morecraft.item;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSlimeArmor extends ArmorItem
{
	public String armorNamePrefix;
	public ArmorMaterial material;
	public Item repairMaterial;
	public int tickUntilSelfRepair = 200;
	public int tickUntilRegen = 200;

	public ItemSlimeArmor(ArmorItem.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
	    super(materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
	{
		return MoreCraft.SLIME_A;
	}
	
	/*@Override
	@OnlyIn(Dist.CLIENT)
	public void onArmorTick(World world, PlayerEntity player, ItemStack itemStack) 
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
	}* /
	
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
}*/