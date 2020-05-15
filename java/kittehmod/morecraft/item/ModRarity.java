package kittehmod.morecraft.item;

import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;

public enum ModRarity implements net.minecraftforge.common.IExtensibleEnum {
	LEGENDARY(TextFormatting.GOLD);
	
	public final TextFormatting color;

	private ModRarity(TextFormatting p_i48837_3_) {
		this.color = p_i48837_3_;
	}

	public static Rarity create(String name, TextFormatting p_i48837_3_) {
		throw new IllegalStateException("Enum not extended");
	}
}
