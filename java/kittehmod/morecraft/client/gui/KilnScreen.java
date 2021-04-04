package kittehmod.morecraft.client.gui;

import kittehmod.morecraft.container.KilnContainer;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnContainer>
{
	private static final ResourceLocation KILN_GUI_TEXTURES = new ResourceLocation("morecraft", "textures/gui/container/kiln.png");
	
	public KilnScreen(KilnContainer container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, new KilnRecipeGui(), playerInventory, title, KILN_GUI_TEXTURES);
	}
}
