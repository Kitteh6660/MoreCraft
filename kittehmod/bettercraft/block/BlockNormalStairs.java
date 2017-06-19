package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.Loader;

public class BlockNormalStairs extends BlockStairs 
{
	public BlockNormalStairs(IBlockState modelState) {
		super(modelState);
	    this.useNeighborBrightness = true;
	    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	    if (this == MoreCraftBlocks.STONE_STAIRS && Loader.isModLoaded("quark")) {
	    	this.setCreativeTab(null);
	    }
	}
	
    /**
     * Sets the footstep sound for the block. Returns the object for convenience in constructing.
     */
	@Override
    public Block setSoundType(SoundType sound)
    {
        super.setSoundType(sound);
        return this;
    }
	
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != MoreCraftBlocks.ENDSTONE_BRICK_STAIRS;
	    }
	    return true;
	}
}
