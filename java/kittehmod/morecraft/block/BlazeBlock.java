package kittehmod.morecraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeBlock extends Block
{
	public BlazeBlock(Block.Properties properties)
	{
		super(properties);
	}
    
	@Override
    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn)
    {
		entityIn.setSecondsOnFire(4);
    }

}
