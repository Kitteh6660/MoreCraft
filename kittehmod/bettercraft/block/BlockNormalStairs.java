package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNormalStairs extends BlockStairs 
{
	public BlockNormalStairs(IBlockState modelState) {
		super(modelState);
	    this.useNeighborBrightness = true;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != MoreCraftBlocks.enderbrick_stairs;
	    }
	    return true;
	}
}
