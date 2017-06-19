package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStorage extends Block 
{

	public BlockStorage(Material material) 
	{
		super(material);
		if (this == MoreCraftBlocks.BLAZE_BLOCK || this == MoreCraftBlocks.ENDER_BLOCK) this.setHarvestLevel("pickaxe", 1);
		if (this == MoreCraftBlocks.RUBY_BLOCK) this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
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
	    if (entity instanceof EntityDragon)
	    {
		    return this != MoreCraftBlocks.ENDER_BLOCK;
	    }
	    return true;
	}
	
}