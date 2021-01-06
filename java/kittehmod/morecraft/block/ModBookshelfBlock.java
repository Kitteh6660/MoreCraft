package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ModBookshelfBlock extends Block
{
	public ModBookshelfBlock(Block.Properties builder) {
		super(builder);
	}
	
	@Override
	public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos)
    {
        return 1;
    }
}
