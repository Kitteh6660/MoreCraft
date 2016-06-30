package kittehmod.bettercraft.block;

import kittehmod.bettercraft.BetterCraft;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNetherwoodCraftingTable extends BlockWorkbench
{
    @SideOnly(Side.CLIENT)
    public IIcon textureTop;
    @SideOnly(Side.CLIENT)
    public IIcon textureFront;
    @SideOnly(Side.CLIENT)
    public IIcon textureSide;
    private static final String __OBFID = "CL_00000221";
    
	public BlockNetherwoodCraftingTable() 
	{
		super();
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.textureTop = par1IconRegister.registerIcon(this.getTextureName() + "_top");
        this.textureFront = par1IconRegister.registerIcon(this.getTextureName() + "_front");
        this.textureSide = par1IconRegister.registerIcon(this.getTextureName() + "_side");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int blockSide, int p_149691_2_)
    {
    	IIcon thisTexture;
    	switch(blockSide) {
	    	case 0:
	    		return BetterCraft.NetherPlanks.getBlockTextureFromSide(blockSide);
	    	case 1:
	    		return this.textureTop;
	    	case 2:
	    	case 3:
	    	case 4:
	    		return this.textureSide;
	    	case 5:
	    		return this.textureFront;
	    	default:
	    		return BetterCraft.NetherPlanks.getBlockTextureFromSide(blockSide);	    		
    	}
    }
    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
        	player.openGui(BetterCraft.instance, 0, world, x, y, z);
        	//player.displayGUIWorkbench(x, y, z);
            return true;
        }
    }
    
    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return false;
    }
}
