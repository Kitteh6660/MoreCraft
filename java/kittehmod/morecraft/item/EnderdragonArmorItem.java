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

public class EnderdragonArmorItem extends ArmorItem implements IItemRenderProperties
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
			@SuppressWarnings("unchecked")
			@Override
			public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemstack, EquipmentSlot armorSlot, A _default) {
				return armorSlot == EquipmentSlot.LEGS ? (A) new EnderdragonLegsModel<HumanoidModel<LivingEntity>>() : (A) new EnderdragonArmorModel<HumanoidModel<LivingEntity>>();
			}
		});
	}

}