package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockOreRuby extends Block 
{

	public BlockOreRuby(Material material) 
	{
		super(material);
	}
	
	public Item idDropped(int par1, Random random, int zero) 
	{
        return BetterCraft.ruby;
	}
	
}