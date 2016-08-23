package kittehmod.bettercraft;

import java.util.Calendar;

import kittehmod.bettercraft.block.BlockNetherwoodChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)	
public class TileEntityNetherwoodChestRenderer extends TileEntitySpecialRenderer<TileEntityNetherwoodChest>
{
	private static final ResourceLocation textureDouble = new ResourceLocation("bettercraft:textures/entity/chest/netherwood_double.png");
	private static final ResourceLocation textureSingle = new ResourceLocation("bettercraft:textures/entity/chest/netherwood.png");
	private ModelChest simpleChest = new ModelChest();
	private ModelChest largeChest = new ModelLargeChest();

	public TileEntityNetherwoodChestRenderer()
	{

	}
	
    public void func_180535_a(TileEntityNetherwoodChest te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GlStateManager.func_179126_j();
        GlStateManager.func_179143_c(515);
        GlStateManager.func_179132_a(true);
        int i;

        if (!te.func_145830_o())
        {
            i = 0;
        }
        else
        {
            Block block = te.func_145838_q();
            i = te.func_145832_p();

            if (block instanceof BlockChest && i == 0)
            {
                ((BlockChest)block).func_176455_e(te.func_145831_w(), te.func_174877_v(), te.func_145831_w().func_180495_p(te.func_174877_v()));
                i = te.func_145832_p();
            }

            te.func_145979_i();
        }

        if (te.adjacentChestZNeg == null && te.adjacentChestXNeg == null)
        {
            ModelChest modelchest;

            if (te.adjacentChestXPos == null && te.adjacentChestZPos == null)
            {
                modelchest = this.simpleChest;

                if (destroyStage >= 0)
                {
                    this.func_147499_a(field_178460_a[destroyStage]);
                    GlStateManager.func_179128_n(5890);
                    GlStateManager.func_179094_E();
                    GlStateManager.func_179152_a(4.0F, 4.0F, 1.0F);
                    GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
                    GlStateManager.func_179128_n(5888);
                }
                this.func_147499_a(textureSingle);
            }
            else
            {
                modelchest = this.largeChest;

                if (destroyStage >= 0)
                {
                    this.func_147499_a(field_178460_a[destroyStage]);
                    GlStateManager.func_179128_n(5890);
                    GlStateManager.func_179094_E();
                    GlStateManager.func_179152_a(8.0F, 4.0F, 1.0F);
                    GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
                    GlStateManager.func_179128_n(5888);
                }
                this.func_147499_a(textureDouble);
            }

            GlStateManager.func_179094_E();
            GlStateManager.func_179091_B();

            if (destroyStage < 0)
            {
                GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
            }

            GlStateManager.func_179109_b((float)x, (float)y + 1.0F, (float)z + 1.0F);
            GlStateManager.func_179152_a(1.0F, -1.0F, -1.0F);
            GlStateManager.func_179109_b(0.5F, 0.5F, 0.5F);
            int j = 0;

            if (i == 2)
            {
                j = 180;
            }

            if (i == 3)
            {
                j = 0;
            }

            if (i == 4)
            {
                j = 90;
            }

            if (i == 5)
            {
                j = -90;
            }

            if (i == 2 && te.adjacentChestXPos != null)
            {
                GlStateManager.func_179109_b(1.0F, 0.0F, 0.0F);
            }

            if (i == 5 && te.adjacentChestZPos != null)
            {
                GlStateManager.func_179109_b(0.0F, 0.0F, -1.0F);
            }

            GlStateManager.func_179114_b((float)j, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179109_b(-0.5F, -0.5F, -0.5F);
            float f = te.field_145986_n + (te.field_145989_m - te.field_145986_n) * partialTicks;

            if (te.adjacentChestZNeg != null)
            {
                float f1 = te.adjacentChestZNeg.field_145986_n + (te.adjacentChestZNeg.field_145989_m - te.adjacentChestZNeg.field_145986_n) * partialTicks;

                if (f1 > f)
                {
                    f = f1;
                }
            }

            if (te.adjacentChestXNeg != null)
            {
                float f2 = te.adjacentChestXNeg.field_145986_n + (te.adjacentChestXNeg.field_145989_m - te.adjacentChestXNeg.field_145986_n) * partialTicks;

                if (f2 > f)
                {
                    f = f2;
                }
            }

            f = 1.0F - f;
            f = 1.0F - f * f * f;
            modelchest.field_78234_a.field_78795_f = -(f * (float)Math.PI / 2.0F);
            modelchest.func_78231_a();
            GlStateManager.func_179101_C();
            GlStateManager.func_179121_F();
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);

            if (destroyStage >= 0)
            {
                GlStateManager.func_179128_n(5890);
                GlStateManager.func_179121_F();
                GlStateManager.func_179128_n(5888);
            }
        }
    }

}