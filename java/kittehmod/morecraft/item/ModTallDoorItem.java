package kittehmod.morecraft.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ModTallDoorItem extends BlockItem
{
	public ModTallDoorItem(Block block, Properties properties) {
		super(block, properties);
	}

	protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
		context.getLevel().setBlock(context.getClickedPos().above(1), Blocks.AIR.defaultBlockState(), 27);
		context.getLevel().setBlock(context.getClickedPos().above(2), Blocks.AIR.defaultBlockState(), 27);
		return super.placeBlock(context, state);
	}
}
