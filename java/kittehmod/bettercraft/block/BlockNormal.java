package kittehmod.bettercraft.block;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class BlockNormal extends Block 
{

	public BlockNormal(Material material) 
	{
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
	    if (entity instanceof EntityDragon)
	    {
		    return this != BetterCraft.EndBrickBlock && this != BetterCraft.BedrockBrick;
	    }
	    return true;
	}
	
}