package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockNetherBrickFenceGate extends BlockFenceGate
{
	public BlockNetherBrickFenceGate(int par1)
	{
	    super(par1);
	    this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	
    public Icon getIcon(int par1, int par2)
    {
        return Block.netherBrick.getBlockTextureFromSide(par1);
    }

}
