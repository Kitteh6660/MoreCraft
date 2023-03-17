package kittehmod.morecraft.client.gui;

import kittehmod.morecraft.container.KilnContainer;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnContainer>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("morecraft", "textures/gui/container/kiln.png");
	
	public KilnScreen(KilnContainer container, Inventory playerInventory, Component title) {
		super(container, new KilnRecipeBookComponent(), playerInventory, title, TEXTURE);
	}
}
