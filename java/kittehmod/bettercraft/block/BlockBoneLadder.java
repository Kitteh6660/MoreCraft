package kittehmod.bettercraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBoneLadder extends BlockLadder 
{
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	
	public BlockBoneLadder() {
		super();
	}
	
    @Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("bettercraft:BoneLadder");
	}
    
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }
}
