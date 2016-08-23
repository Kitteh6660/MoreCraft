package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNormal extends Block 
{

	public BlockNormal(Material material) 
	{
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon)
	    {
		    return this != MoreCraftBlocks.enderbrick_block && this != MoreCraftBlocks.bedrock_brick;
	    }
	    return true;
	}
	
}