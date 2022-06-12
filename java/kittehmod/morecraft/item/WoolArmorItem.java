package kittehmod.morecraft.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class WoolArmorItem extends ModArmorItem implements DyeableLeatherItem
{

	public WoolArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public int getColor(ItemStack p_41122_) {
		CompoundTag compoundtag = p_41122_.getTagElement("display");
		return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 16777215;
	}

}
