package kittehmod.bettercraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNetherLog extends Block
{

    private IIcon[] icons;
	
    public BlockNetherLog()
    {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    /**
     *Determines if the block can be destroyed by fire.
     */
    public boolean canBurn()
    {
    	return false;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[2];
		this.icons[0] = par1IconRegister.registerIcon("bettercraft:Netherwood_top");
		this.icons[1] = par1IconRegister.registerIcon("bettercraft:Netherwood_side");
	}
    
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        int var3 = meta & 12;
        int var4 = meta & 3;
        return var3 == 0 && (side == 1 || side == 0) ? this.icons[0] : (var3 == 4 && (side == 5 || side == 4) ? this.icons[0] : (var3 == 8 && (side == 2 || side == 3) ? this.icons[0] : this.icons[1]));
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        Block var12 = par1World.getBlock(par2 + var9, par3 + var10, par4 + var11);

                        if (var12 == BetterCraft.NetherLeaves)
                        {
                            int var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11);

                            if ((var13 & 8) == 0)
                            {
                                par1World.setBlockMetadataWithNotify(par2 + var9, par3 + var10, par4 + var11, var13 | 8, 4);
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 31;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Block idDropped(int par1, Random par2Random, int par3)
    {
        return BetterCraft.NetherLog;
    }

    
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9 & 3;
        byte var11 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                var11 = 0;
                break;

            case 2:
            case 3:
                var11 = 8;
                break;

            case 4:
            case 5:
                var11 = 4;
        }

        return var10 | var11;
    }
}
