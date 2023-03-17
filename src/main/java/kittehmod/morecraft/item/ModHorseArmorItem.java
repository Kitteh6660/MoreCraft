package kittehmod.morecraft.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModHorseArmorItem extends HorseArmorItem 
{
	private final ResourceLocation texture;

	public ModHorseArmorItem(int p_i50042_1_, String p_i50042_2_, Item.Properties p_i50042_3_) {
		this(p_i50042_1_, new ResourceLocation("morecraft:textures/entity/horse/armor/horse_armor_" + p_i50042_2_ + ".png"), p_i50042_3_);
	}
	
	public ModHorseArmorItem(int p_i50042_1_, ResourceLocation texture, Item.Properties p_i50042_3_) {
		super(p_i50042_1_, texture, p_i50042_3_);
		this.texture = texture;
	}
	
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getTexture() {
		return texture;
	}
	
}
