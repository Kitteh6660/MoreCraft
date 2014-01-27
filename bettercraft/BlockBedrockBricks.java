package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBedrockBricks extends Block
{
	public BlockBedrockBricks(int par1, Material par2)
	{
		super(par1, Material.rock);
		this.setBlockUnbreakable();
	}


}
