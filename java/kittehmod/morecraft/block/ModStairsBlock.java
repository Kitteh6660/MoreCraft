package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;

public class ModStairsBlock extends StairsBlock 
{
	@SuppressWarnings("deprecation")
	public ModStairsBlock(BlockState blockState, Block.Properties properties) {
		super(blockState, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(HALF, Half.BOTTOM).with(SHAPE, StairsShape.STRAIGHT).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
}
