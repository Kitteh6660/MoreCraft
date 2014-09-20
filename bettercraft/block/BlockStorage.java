package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStorage extends Block 
{

	public BlockStorage(Material material) 
	{
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
	}

}