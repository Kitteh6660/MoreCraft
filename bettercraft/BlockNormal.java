package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNormal extends Block 
{

	public BlockNormal(int id, Material material) 
	{
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
	}

}