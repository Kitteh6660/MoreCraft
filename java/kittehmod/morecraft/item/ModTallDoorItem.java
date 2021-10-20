package kittehmod.morecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;

public class ModTallDoorItem extends BlockItem
{
	public ModTallDoorItem(Block block, Properties properties) {
		super(block, properties);
	}

	protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
		context.getLevel().setBlock(context.getClickedPos().above(1), Blocks.AIR.defaultBlockState(), 27);
		context.getLevel().setBlock(context.getClickedPos().above(2), Blocks.AIR.defaultBlockState(), 27);
		return super.placeBlock(context, state);
	}
}
