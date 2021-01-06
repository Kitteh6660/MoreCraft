package kittehmod.morecraft.client.gui;

import java.util.Set;

import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.item.Item;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnRecipeGui extends AbstractRecipeBookGui
{
	private static final ITextComponent field_243415_i = new TranslationTextComponent("gui.recipebook.toggleRecipes.smokable");

	protected ITextComponent func_230479_g_() {
		return field_243415_i;
	}

	@SuppressWarnings("deprecation")
	protected Set<Item> func_212958_h() {
		return AbstractFurnaceTileEntity.getBurnTimes().keySet();
	}
}
