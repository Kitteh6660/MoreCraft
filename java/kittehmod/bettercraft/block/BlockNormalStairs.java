package kittehmod.bettercraft.block;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.IBlockAccess;

public class BlockNormalStairs extends BlockStairs 
{
	public BlockNormalStairs(Block block, int par3) {
		super(block, par3);
		this.setLightOpacity(0);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != BetterCraft.EndBrickStair;
	    }
	    return true;
	}
}
