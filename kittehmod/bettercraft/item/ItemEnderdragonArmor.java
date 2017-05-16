package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.client.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnderdragonArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;

	public ItemEnderdragonArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
	    super(materialIn, renderIndexIn, equipmentSlotIn);
	}

    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return MoreCraft.ENDERDRAGON_A;
    }
	
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
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
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		ModelBiped armorModel = ClientProxy.armorModels.get(this);

		if (armorModel != null) {
			armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
			armorModel.bipedHeadwear.showModel = false;
			armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
			armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
			armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
			armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
			armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
			
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			
			armorModel.rightArmPose = ModelBiped.ArmPose.EMPTY;
			//armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;

			EntityPlayer player = null;
			ItemStack held_item = entityLiving.getHeldItemMainhand();
			if (entityLiving.equals(EntityPlayer.class)) {
				player = (EntityPlayer)entityLiving;
			}
			
			if (held_item != null)
			{
				armorModel.rightArmPose = ModelBiped.ArmPose.ITEM;

				if (player.getItemInUseCount() > 0)
				{
					EnumAction enumaction = held_item.getItemUseAction();

					if (enumaction == EnumAction.BOW) {
						armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
					} else if (enumaction == EnumAction.BLOCK) {
						armorModel.rightArmPose = ModelBiped.ArmPose.BLOCK;
					}
				}
			}
		}

		return armorModel;
	}
	
}