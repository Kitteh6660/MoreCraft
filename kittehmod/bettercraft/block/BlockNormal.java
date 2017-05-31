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

public class BlockNormal extends Block 
{

	public BlockNormal(Material material) 
	{
		super(material);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
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
		    return this != MoreCraftBlocks.BEDROCK_BRICK;
	    }
	    return true;
	}
	
}