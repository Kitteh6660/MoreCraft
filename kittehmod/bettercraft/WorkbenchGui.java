package kittehmod.bettercraft;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class WorkbenchGui extends GuiContainer
{
    public WorkbenchGui(InventoryPlayer inventoryplayer, World world)
    {
        super(new WorkbenchContainer(inventoryplayer, world));
    }

    /*@Override
    protected void drawGuiContainerForegroundLayer (int par1, int par2)
    {
        fontRenderer.drawString("Crafting", 28, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer (float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/gui/crafting.png");
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
    }*/

    private static final ResourceLocation field_110422_t = new ResourceLocation("textures/gui/container/crafting_table.png");

    @Override
    protected void func_146979_b (int par1, int par2)
    {
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.crafting"), 28, 6, 4210752);
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory"), 8, this.field_147000_g - 96 + 2, 4210752);
    }

    @Override
    protected void func_146976_a (float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_146297_k.func_110434_K().func_110577_a(field_110422_t);
        int k = (this.field_146294_l - this.field_146999_f) / 2;
        int l = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
    }
}
