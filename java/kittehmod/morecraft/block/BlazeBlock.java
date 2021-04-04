package kittehmod.morecraft.block;

import net.minecraft.block.Block;
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
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn)
    {
		entityIn.setSecondsOnFire(4);
    }

}
