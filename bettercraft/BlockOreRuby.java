package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockOreRuby extends Block 
{

	public BlockOreRuby(int id, Material material) 
	{
		super(id, material);
	}
	
	public int idDropped(int par1, Random random, int zero) 
	{
        return BetterCraft.Ruby.itemID;
	}

}