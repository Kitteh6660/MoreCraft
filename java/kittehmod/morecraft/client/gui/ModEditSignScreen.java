package kittehmod.morecraft.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.NetherwoodStandingSignBlock;
import kittehmod.morecraft.block.NetherwoodWallSignBlock;
import kittehmod.morecraft.network.ModUpdateSignPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.fonts.TextInputUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModEditSignScreen extends Screen {
   private final NetherwoodSignTileEntity tileSign;
   private int updateCounter;
   private int editLine;
   private TextInputUtil inputUtil;

   public ModEditSignScreen(NetherwoodSignTileEntity teSign) {
      super(new TranslationTextComponent("sign.edit"));
      this.tileSign = teSign;
   }

   protected void init() {
      this.minecraft.keyboardListener.enableRepeatEvents(true);
      this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 120, 200, 20, I18n.format("gui.done"), (p_214266_1_) -> {
         this.close();
      }));
      this.tileSign.setEditable(false);
      this.inputUtil = new TextInputUtil(this.minecraft, () -> {
         return this.tileSign.getText(this.editLine).getString();
      }, (input) -> {
    	  //MorecraftPacketHandler.sendToServerSync(msg);
    	  //ModUpdateSignPacket msg = new ModUpdateSignPacket(this.tileSign.getPos(), this.tileSign.getText(0), this.tileSign.getText(1), this.tileSign.getText(2), this.tileSign.getText(3));
    	  //MorecraftPacketHandler.sendTo(msg, minecraft.player.getServer());
    	  this.tileSign.setText(this.editLine, new StringTextComponent(input));
      }, 90);
   }

   public void removed() {
      this.minecraft.keyboardListener.enableRepeatEvents(false);
      ClientPlayNetHandler clientplaynethandler = this.minecraft.getConnection();
      MoreCraft.LOGGER.info("Getting connection and attempting to send.");
      if (clientplaynethandler != null) {
    	  MoreCraft.LOGGER.info("Sending packet with texts:\n" + this.tileSign.getText(0) + "\n" + this.tileSign.getText(1) + "\n" + this.tileSign.getText(2) + "\n" + this.tileSign.getText(3));
    	  ModUpdateSignPacket msg = new ModUpdateSignPacket(this.tileSign.getPos(), this.tileSign.getText(0), this.tileSign.getText(1), this.tileSign.getText(2), this.tileSign.getText(3));
    	  MorecraftPacketHandler.sendToServerSync(msg);
    	  //clientplaynethandler.sendPacket(new CUpdateSignPacket(this.tileSign.getPos(), this.tileSign.getText(0), this.tileSign.getText(1), this.tileSign.getText(2), this.tileSign.getText(3)));
      }
      this.tileSign.setEditable(true);
   }

   public void tick() {
      ++this.updateCounter;
      if (!this.tileSign.getType().isValidBlock(this.tileSign.getBlockState().getBlock())) {
         this.close();
      }

   }

   private void close() {
      this.tileSign.markDirty();
      this.minecraft.displayGuiScreen((Screen)null);
   }

   public boolean charTyped(char p_charTyped_1_, int p_charTyped_2_) {
      this.inputUtil.func_216894_a(p_charTyped_1_);
      return true;
   }

   public void onClose() {
      this.close();
   }

   @OnlyIn(Dist.CLIENT)
   public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
      if (p_keyPressed_1_ == 265) {
         this.editLine = this.editLine - 1 & 3;
         this.inputUtil.func_216899_b();
         return true;
      } else if (p_keyPressed_1_ != 264 && p_keyPressed_1_ != 257 && p_keyPressed_1_ != 335) {
         return this.inputUtil.func_216897_a(p_keyPressed_1_) ? true : super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
      } else {
         this.editLine = this.editLine + 1 & 3;
         this.inputUtil.func_216899_b();
         return true;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
      this.renderBackground();
      this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, 40, 16777215);
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.pushMatrix();
      GlStateManager.translatef((float)(this.width / 2), 0.0F, 50.0F);
      float f = 93.75F;
      GlStateManager.scalef(-f, -f, -f);
      GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
      BlockState blockstate = this.tileSign.getBlockState();
      float f1;
      if (blockstate.getBlock() instanceof NetherwoodStandingSignBlock) {
         f1 = (float)(blockstate.get(NetherwoodStandingSignBlock.ROTATION) * 360) / 16.0F;
      } else {
         f1 = blockstate.get(NetherwoodWallSignBlock.FACING).getHorizontalAngle();
      }

      GlStateManager.rotatef(f1, 0.0F, 1.0F, 0.0F);
      GlStateManager.translatef(0.0F, -1.0625F, 0.0F);
      this.tileSign.func_214062_a(this.editLine, this.inputUtil.func_216896_c(), this.inputUtil.func_216898_d(), this.updateCounter / 6 % 2 == 0);
      TileEntityRendererDispatcher.instance.render(this.tileSign, -0.5D, -0.75D, -0.5D, 0.0F);
      this.tileSign.func_214063_g();
      GlStateManager.popMatrix();
      super.render(p_render_1_, p_render_2_, p_render_3_);
   }
   
	public static void open(NetherwoodSignTileEntity tileEntity) {
	   Minecraft.getInstance().displayGuiScreen(new ModEditSignScreen(tileEntity));
	}
}