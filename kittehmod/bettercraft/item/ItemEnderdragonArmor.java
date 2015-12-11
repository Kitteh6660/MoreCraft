package kittehmod.bettercraft.item;

import org.apache.http.impl.client.ProxyClient;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kittehmod.bettercraft.BetterCraft;
import kittehmod.bettercraft.client.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemEnderdragonArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;

	public ItemEnderdragonArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix)
	{
	    super(par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.getDamageReductionAmount(par4);
	    this.setMaxDurability(par2EnumArmorMaterial.getDurability(par4));
	    this.maxStackSize = 1;
	    armorNamePrefix = armornamePrefix;
	}

    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return BetterCraft.ENDERDRAGON_A;
    }
	
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot){

		ModelBiped armorModel = ClientProxy.armorModels.get(this);

		if (armorModel != null) {
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = false;
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
			
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			
			armorModel.heldItemRight = 0;
			armorModel.aimedBow = false;

			EntityPlayer player = (EntityPlayer)entityLiving;

			ItemStack held_item = player.getEquipmentInSlot(0);

			if (held_item != null)
			{
				armorModel.heldItemRight = 1;

				if (player.getItemInUseCount() > 0)
				{
					EnumAction enumaction = held_item.getItemUseAction();

					if (enumaction == EnumAction.bow) {
						armorModel.aimedBow = true;
					} else if (enumaction == EnumAction.block) {
						armorModel.heldItemRight = 3;
					}
				}
			}
		}

		return armorModel;
	}
	
}