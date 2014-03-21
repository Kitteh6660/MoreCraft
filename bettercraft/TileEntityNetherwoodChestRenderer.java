package kittehmod.bettercraft;

import java.util.Calendar;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityNetherwoodChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation RES_NETHER_DOUBLE = new ResourceLocation("bettercraft:textures/entity/chest/netherwood_double.png");
    private static final ResourceLocation RES_NETHER_SINGLE = new ResourceLocation("bettercraft:textures/entity/chest/netherwood.png");
	
	/** The normal small chest model. */
    private ModelChest chestModel = new ModelChest();

    /** The large double chest model. */
    private ModelChest largeChestModel = new ModelLargeChest();

    /** If true, chests will be rendered with the Christmas present textures. */
    private boolean isChristmas;

    public TileEntityNetherwoodChestRenderer()
    {
        Calendar calendar = Calendar.getInstance();

        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
        {
            this.isChristmas = true;
        }
    }

    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityNetherwoodChestAt(TileEntityNetherwoodChest par1TileEntityNetherwoodChest, double par2, double par4, double par6, float par8)
    {
        int i;

        if (!par1TileEntityNetherwoodChest.hasWorldObj())
        {
            i = 0;
        }
        else
        {
            Block block = par1TileEntityNetherwoodChest.getBlockType();
            i = par1TileEntityNetherwoodChest.getBlockMetadata();

            if (block instanceof BlockChest && i == 0)
            {
                try
                {
                    ((BlockChest)block).unifyAdjacentChests(par1TileEntityNetherwoodChest.getWorldObj(), par1TileEntityNetherwoodChest.xCoord, par1TileEntityNetherwoodChest.yCoord, par1TileEntityNetherwoodChest.zCoord);
                }
                catch (ClassCastException e)
                {
                    FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest",
                            par1TileEntityNetherwoodChest.xCoord, par1TileEntityNetherwoodChest.yCoord, par1TileEntityNetherwoodChest.zCoord);
                }
                i = par1TileEntityNetherwoodChest.getBlockMetadata();
            }

            par1TileEntityNetherwoodChest.checkForAdjacentChests();
        }

        if (par1TileEntityNetherwoodChest.adjacentChestZNeg == null && par1TileEntityNetherwoodChest.adjacentChestXNeg == null)
        {
            ModelChest modelchest;

            if (par1TileEntityNetherwoodChest.adjacentChestXPos == null && par1TileEntityNetherwoodChest.adjacentChestZPosition == null)
            {
                modelchest = this.chestModel;

                if (par1TileEntityNetherwoodChest.getChestType() == 1)
                {
                    this.bindTexture(RES_NETHER_SINGLE);
                }
                else
                {
                    this.bindTexture(RES_NETHER_SINGLE);
                }
            }
            else
            {
                modelchest = this.largeChestModel;

                if (par1TileEntityNetherwoodChest.getChestType() == 1)
                {
                    this.bindTexture(RES_NETHER_DOUBLE);
                }
                else
                {
                    this.bindTexture(RES_NETHER_DOUBLE);
                }
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            if (i == 2 && par1TileEntityNetherwoodChest.adjacentChestXPos != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (i == 5 && par1TileEntityNetherwoodChest.adjacentChestZPosition != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = par1TileEntityNetherwoodChest.prevLidAngle + (par1TileEntityNetherwoodChest.lidAngle - par1TileEntityNetherwoodChest.prevLidAngle) * par8;
            float f2;

            if (par1TileEntityNetherwoodChest.adjacentChestZNeg != null)
            {
                f2 = par1TileEntityNetherwoodChest.adjacentChestZNeg.prevLidAngle + (par1TileEntityNetherwoodChest.adjacentChestZNeg.lidAngle - par1TileEntityNetherwoodChest.adjacentChestZNeg.prevLidAngle) * par8;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (par1TileEntityNetherwoodChest.adjacentChestXNeg != null)
            {
                f2 = par1TileEntityNetherwoodChest.adjacentChestXNeg.prevLidAngle + (par1TileEntityNetherwoodChest.adjacentChestXNeg.lidAngle - par1TileEntityNetherwoodChest.adjacentChestXNeg.prevLidAngle) * par8;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            modelchest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }


    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityNetherwoodChestAt((TileEntityNetherwoodChest)par1TileEntity, par2, par4, par6, par8);
    }
}