package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockNetherBrickFenceGate extends BlockFenceGate
{
	public BlockNetherBrickFenceGate()
	{
	    super();
	    this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	
    public IIcon getIcon(int par1, int par2)
    {
        return Blocks.nether_brick.getBlockTextureFromSide(par1);
    }

}
