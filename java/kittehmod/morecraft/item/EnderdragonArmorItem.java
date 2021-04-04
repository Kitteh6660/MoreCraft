package kittehmod.morecraft.item;

import kittehmod.morecraft.client.EnderdragonArmorModel;
import kittehmod.morecraft.client.EnderdragonLegsModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EnderdragonArmorItem extends ArmorItem
{
	public IArmorMaterial material;

	public EnderdragonArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder)
	{
	    super(materialIn, slot, builder);
	}

    public ModArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return ModArmorMaterial.ENDERDRAGON;
    }
	
    @Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
    {
		return "morecraft:textures/models/armor/enderdragon_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BipedModel<LivingEntity> getArmorModel(LivingEntity entityLiving, ItemStack itemstack, EquipmentSlotType armorSlot, BipedModel _default)
	{
		BipedModel<LivingEntity> armorModel = armorSlot == EquipmentSlotType.LEGS ? new EnderdragonLegsModel(0.5F) : new EnderdragonArmorModel(1.0F);

		if (armorModel != null) {
			armorModel.head.visible = armorSlot == EquipmentSlotType.HEAD;
			armorModel.hat.visible = false;
			armorModel.body.visible = armorSlot == EquipmentSlotType.CHEST || armorSlot == EquipmentSlotType.LEGS;
			armorModel.rightArm.visible = armorSlot == EquipmentSlotType.CHEST;
			armorModel.leftArm.visible = armorSlot == EquipmentSlotType.CHEST;
			armorModel.rightLeg.visible = armorSlot == EquipmentSlotType.LEGS || armorSlot == EquipmentSlotType.FEET;
			armorModel.leftLeg.visible = armorSlot == EquipmentSlotType.LEGS || armorSlot == EquipmentSlotType.FEET;
			
			armorModel.crouching = entityLiving.isCrouching();
			armorModel.young = entityLiving.isBaby();
			
			armorModel.rightArmPose = BipedModel.ArmPose.EMPTY;
			//armorModel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;

			ItemStack held_item = entityLiving.getMainHandItem();
			
			if (held_item != null)
			{
				armorModel.rightArmPose = BipedModel.ArmPose.ITEM;

				if (entityLiving.getUseItemRemainingTicks() > 0)
				{
					UseAction enumaction = held_item.getUseAnimation();

					if (enumaction == UseAction.BOW) {
						armorModel.rightArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
					} else if (enumaction == UseAction.BLOCK) {
						armorModel.rightArmPose = BipedModel.ArmPose.BLOCK;
					}
				}
			}
		}

		return armorModel;
	}
	
}