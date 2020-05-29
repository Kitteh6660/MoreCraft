package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlazeBlock extends Block
{
	public BlazeBlock(Block.Properties properties)
	{
		super(properties);
	}
    
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		entityIn.setFire(4);
    }

	@Override
	public int getHarvestLevel(BlockState state) {
		return 1;
	}
	
}
