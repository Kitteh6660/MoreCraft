package kittehmod.morecraft.client.gui;

import java.util.Arrays;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import kittehmod.morecraft.block.ModStandingSignBlock;
import kittehmod.morecraft.client.NetherwoodSignTileEntityRenderer;
import kittehmod.morecraft.network.ModUpdateSignPacket;
import kittehmod.morecraft.network.ModUpdateTileEntityPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.fonts.TextInputUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.Util;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModEditSignScreen extends Screen
{
	private final NetherwoodSignTileEntityRenderer.SignModel signModel = new NetherwoodSignTileEntityRenderer.SignModel();
	private final ModSignTileEntity tileSign;
	private int updateCounter;
	private int editLine;
	private TextInputUtil textInputUtil;
	private final String[] signLines = Util.make(new String[4], (p_238849_0_) -> { Arrays.fill(p_238849_0_, ""); });

	public ModEditSignScreen(ModSignTileEntity teSign) {
		super(new TranslationTextComponent("sign.edit"));
		this.tileSign = teSign;
	}

	@Override
	protected void init() {
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 120, 200, 20, DialogTexts.GUI_DONE, (p_238847_1_) -> { this.close(); }));
		this.tileSign.setEditable(false);
		this.textInputUtil = new TextInputUtil(() -> { return this.signLines[this.editLine]; }, (p_238850_1_) -> {
			this.signLines[this.editLine] = p_238850_1_;
			this.tileSign.setText(this.editLine, new StringTextComponent(p_238850_1_));
		}, TextInputUtil.createClipboardGetter(this.minecraft), TextInputUtil.createClipboardSetter(this.minecraft), (p_238848_1_) -> { return this.minecraft.font.width(p_238848_1_) <= 90; });
	}

	public void removed() { // Removed
		this.minecraft.keyboardHandler.setSendRepeatsToGui(false);
		ClientPlayNetHandler clientplaynethandler = this.minecraft.getConnection();
		if (clientplaynethandler != null) {
			ModUpdateSignPacket msg1 = new ModUpdateSignPacket(this.tileSign.getBlockPos(), this.tileSign.getText(0), this.tileSign.getText(1), this.tileSign.getText(2), this.tileSign.getText(3), this.tileSign.getTextColor().getId());
			MorecraftPacketHandler.sendToServer(msg1);
			ModUpdateTileEntityPacket msg2 = new ModUpdateTileEntityPacket(this.tileSign.getBlockPos(), this.tileSign.save(this.tileSign.getUpdateTag()));
			MorecraftPacketHandler.sendToServer(msg2);
		}
		this.tileSign.setEditable(true);
	}

	public void tick() { // Tick
		++this.updateCounter;
		if (!this.tileSign.getType().isValid(this.tileSign.getBlockState().getBlock())) {
			this.close();
		}
	}

	private void close() {
		this.tileSign.setChanged();
		this.minecraft.setScreen((Screen) null);
	}

	public boolean charTyped(char codePoint, int modifiers) {
		this.textInputUtil.charTyped(codePoint);
		return true;
	}

	public void closeScreen() {
		this.close();
	}

	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		if (keyCode == 265) {
			this.editLine = this.editLine - 1 & 3;
			this.textInputUtil.setCursorToEnd();
			return true;
		} else if (keyCode != 264 && keyCode != 257 && keyCode != 335) {
			return this.textInputUtil.keyPressed(keyCode) ? true : super.keyPressed(keyCode, scanCode, modifiers);
		} else {
			this.editLine = this.editLine + 1 & 3;
			this.textInputUtil.setCursorToEnd();
			return true;
		}
	}

	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) { // Render
		RenderHelper.setupForFlatItems();
		this.renderBackground(matrixStack);
		ModEditSignScreen.drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 40, 16777215);
		matrixStack.pushPose();
		matrixStack.translate((double) (this.width / 2), 0.0D, 50.0D);
		float f = 93.75F;
		matrixStack.scale(f, -f, f);
		matrixStack.translate(0.0D, -1.3125D, 0.0D);
		BlockState blockstate = this.tileSign.getBlockState();
		boolean flag = blockstate.getBlock() instanceof ModStandingSignBlock;
		if (!flag) {
			matrixStack.translate(0.0D, -0.3125D, 0.0D);
		}

		boolean flag1 = this.updateCounter / 6 % 2 == 0;
		float f1 = 0.6666667F;
		matrixStack.pushPose();
		matrixStack.scale(f1, -f1, -f1);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.renderBuffers().bufferSource();
		RenderMaterial rendermaterial = NetherwoodSignTileEntityRenderer.getMaterial(blockstate.getBlock());
		IVertexBuilder ivertexbuilder = rendermaterial.buffer(irendertypebuffer$impl, this.signModel::renderType);
		this.signModel.signBoard.render(matrixStack, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
		if (flag) {
			this.signModel.signStick.render(matrixStack, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
		}

		matrixStack.popPose();
		float f2 = 0.010416667F;
		matrixStack.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
		matrixStack.scale(f2, -f2, f2);
		int i = this.tileSign.getTextColor().getTextColor();
		int j = this.textInputUtil.getCursorPos();
		int k = this.textInputUtil.getSelectionPos();
		int l = this.editLine * 10 - this.signLines.length * 5;
		Matrix4f matrix4f = matrixStack.last().pose();

		for (int i1 = 0; i1 < this.signLines.length; ++i1) {
			String s = this.signLines[i1];
			if (s != null) {
				if (this.font.isBidirectional()) {
					s = this.font.bidirectionalShaping(s);
				}

				float f3 = (float) (-this.minecraft.font.width(s) / 2);
				this.minecraft.font.drawInBatch(s, f3, (float) (i1 * 10 - this.signLines.length * 5), i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
				if (i1 == this.editLine && j >= 0 && flag1) {
					int j1 = this.minecraft.font.width(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
					int k1 = j1 - this.minecraft.font.width(s) / 2;
					if (j >= s.length()) {
						this.minecraft.font.drawInBatch("_", (float) k1, (float) l, i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
					}
				}
			}
		}

		irendertypebuffer$impl.endBatch();

		for (int i3 = 0; i3 < this.signLines.length; ++i3) {
			String s1 = this.signLines[i3];
			if (s1 != null && i3 == this.editLine && j >= 0) {
				int j3 = this.minecraft.font.width(s1.substring(0, Math.max(Math.min(j, s1.length()), 0)));
				int k3 = j3 - this.minecraft.font.width(s1) / 2;
				if (flag1 && j < s1.length()) {
					fill(matrixStack, k3, l - 1, k3 + 1, l + 9, -16777216 | i);
				}

				if (k != j) {
					int l3 = Math.min(j, k);
					int l1 = Math.max(j, k);
					int i2 = this.minecraft.font.width(s1.substring(0, l3)) - this.minecraft.font.width(s1) / 2;
					int j2 = this.minecraft.font.width(s1.substring(0, l1)) - this.minecraft.font.width(s1) / 2;
					int k2 = Math.min(i2, j2);
					int l2 = Math.max(i2, j2);
					Tessellator tessellator = Tessellator.getInstance();
					BufferBuilder bufferbuilder = tessellator.getBuilder();
					RenderSystem.disableTexture();
					RenderSystem.enableColorLogicOp();
					RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
					bufferbuilder.vertex(matrix4f, (float) k2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) l2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) l2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) k2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.end();
					WorldVertexBufferUploader.end(bufferbuilder);
					RenderSystem.disableColorLogicOp();
					RenderSystem.enableTexture();
				}
			}
		}

		matrixStack.popPose();
		RenderHelper.setupFor3DItems();
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}