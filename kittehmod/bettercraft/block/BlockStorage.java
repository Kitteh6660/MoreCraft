package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStorage extends Block 
{

	public BlockStorage(Material material) 
	{
		super(material);
		if (this == MoreCraftBlocks.blaze_block || this == MoreCraftBlocks.ender_block) this.setHarvestLevel("pickaxe", 1);
		if (this == MoreCraftBlocks.ruby_block) this.setHarvestLevel("pickaxe", 2);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon)
	    {
		    return this != MoreCraftBlocks.ender_block;
	    }
	    return true;
	}
	
}