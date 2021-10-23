package kittehmod.morecraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import kittehmod.morecraft.container.addons.ModBookcaseContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.renderer.GameRenderer;

public class BookcaseScreen extends AbstractContainerScreen<ModBookcaseContainer>
{
	private static final ResourceLocation CONTAINER_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private final int containerRows = 2;

	public BookcaseScreen(ModBookcaseContainer p_i51078_1_, Inventory p_i51078_2_, Component p_i51078_3_) {
		super(p_i51078_1_, p_i51078_2_, p_i51078_3_);
		this.imageHeight = 114 + this.containerRows * 18;
		this.inventoryLabelY = this.imageHeight - 94;
		++this.imageHeight;
	}

	public void render(PoseStack matrix, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(matrix);
		super.render(matrix, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(matrix, p_230430_2_, p_230430_3_);
	}

	protected void renderBg(PoseStack matrix, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, CONTAINER_TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(matrix, i, j, 0, 0, this.imageWidth, containerRows * 18 + 17);
		this.blit(matrix, i, j + containerRows * 18 + 17, 0, 126, this.imageWidth, 114);
	}
}
