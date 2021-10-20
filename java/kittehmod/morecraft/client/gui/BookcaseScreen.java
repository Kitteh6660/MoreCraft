package kittehmod.morecraft.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BookcaseScreen extends ContainerScreen<ModBookcaseContainer>
{
	private static final ResourceLocation CONTAINER_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private final int containerRows = 2;

	public BookcaseScreen(ModBookcaseContainer p_i51078_1_, PlayerInventory p_i51078_2_, ITextComponent p_i51078_3_) {
		super(p_i51078_1_, p_i51078_2_, p_i51078_3_);
		this.imageHeight = 114 + this.containerRows * 18;
		this.inventoryLabelY = this.imageHeight - 94;
		++this.imageHeight;
	}

	public void render(MatrixStack matrix, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(matrix);
		super.render(matrix, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(matrix, p_230430_2_, p_230430_3_);
	}

	@SuppressWarnings("deprecation")
	protected void renderBg(MatrixStack matrix, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(CONTAINER_TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(matrix, i, j, 0, 0, this.imageWidth, containerRows * 18 + 17);
		this.blit(matrix, i, j + containerRows * 18 + 17, 0, 126, this.imageWidth, 114);
	}
}
