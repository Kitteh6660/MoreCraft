package kittehmod.morecraft.block;

import kittehmod.morecraft.init.ModBlocks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class ModLogBlock extends RotatedPillarBlock
{
	
	public ModLogBlock(Block.Properties p_i48367_2_) {
		super(p_i48367_2_);
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		if (toolAction == ToolActions.AXE_STRIP) {
			Block block = state.getBlock() == ModBlocks.NETHERWOOD_LOG.get() ? ModBlocks.STRIPPED_NETHERWOOD_LOG.get() : ModBlocks.STRIPPED_NETHERWOOD_WOOD.get();
			return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)) : null;
		}
		return super.getToolModifiedState(state, context, toolAction, simulate);
	}
    
}
