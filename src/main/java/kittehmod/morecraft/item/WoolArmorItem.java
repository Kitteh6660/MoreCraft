package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class WoolArmorItem extends ModArmorItem implements DyeableLeatherItem
{

	public WoolArmorItem(ArmorMaterial material, Type slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public int getColor(ItemStack stack) {
		CompoundTag compoundtag = stack.getTagElement("display");
		return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0xFFFFFF;
	}

	@Override
	public void setColor(ItemStack stack, int newValue) {
		stack.getOrCreateTagElement("display").putInt("color", newValue);
	}
	
	@Override
	public boolean hasCustomColor(ItemStack stack) {
		CompoundTag compoundtag = stack.getTagElement("display");
		return compoundtag != null && compoundtag.contains("color", 99);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, @Nullable String type) {
		if (slot == EquipmentSlot.LEGS) {
			return "morecraft:textures/models/armor/wool_layer_2" + (type == null ? "" : "_overlay") + ".png";
		}
		else {
			return "morecraft:textures/models/armor/wool_layer_1" + (type == null ? "" : "_overlay") + ".png";
		}
	}
	
}
