package kittehmod.bettercraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockSoulGlass extends BlockGlass
{
	@SideOnly(Side.CLIENT)
	private Icon sideIcon[];
	
	// Registering the textures for the slab.
	// This has support for side and multiple sub-type textures!
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		sideIcon = new Icon[2];
		blockIcon = par1IconRegister.registerIcon("bettercraft:SoulGlass");
		sideIcon[0] = par1IconRegister.registerIcon("bettercraft:SoulGlass");
	}
    public BlockSoulGlass(int par1, Material par2Material, boolean par3)
    {
        super(par1, par2Material, par3);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		int k = meta & 7;

		if (k == 0) {
			if (side == 0 || side == 1)
				return blockIcon;
			return sideIcon[0];
		}
		return sideIcon[k];
	}

}
