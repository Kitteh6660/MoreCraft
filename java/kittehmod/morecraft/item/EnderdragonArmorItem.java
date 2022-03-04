package kittehmod.morecraft.item;

import java.util.function.Consumer;

import kittehmod.morecraft.client.EnderdragonArmorModel;
import kittehmod.morecraft.client.EnderdragonLegsModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

public class EnderdragonArmorItem extends ArmorItem
{
	public ArmorMaterial material;
	
	public EnderdragonArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder) {
		super(materialIn, slot, builder);
	}

	public ModArmorMaterial getArmorMaterial(ItemStack par1ItemStack) {
		return ModArmorMaterial.ENDERDRAGON;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return "morecraft:textures/models/armor/enderdragon_layer_" + (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemstack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				return armorSlot == EquipmentSlot.LEGS ? new EnderdragonLegsModel<HumanoidModel<LivingEntity>>() : new EnderdragonArmorModel<HumanoidModel<LivingEntity>>();
			}
		});
	}

}