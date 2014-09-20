package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNormalStairs extends BlockStairs 
{

	public BlockNormalStairs(Block block, int par3) 
	{
		super(block, par3);
		this.setLightOpacity(0);
	}
}
