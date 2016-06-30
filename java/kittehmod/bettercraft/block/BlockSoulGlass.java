package kittehmod.bettercraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockSoulGlass extends BlockGlass
{
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	
    public BlockSoulGlass(Material par2Material, boolean par3)
    {
        super(par2Material, par3);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    @Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("bettercraft:SoulGlass");
	}
    
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }
}
