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
	private static final ITextComponent FILTER_NAME = new TranslationTextComponent("gui.recipebook.toggleRecipes.smokable");

	protected ITextComponent getRecipeFilterName() {
		return FILTER_NAME;
	}

	@SuppressWarnings("deprecation")
	protected Set<Item> getFuelItems() {
		return AbstractFurnaceTileEntity.getFuel().keySet();
	}
}
