package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.PaneBlock;

public class ModPaneBlock extends PaneBlock {

	public ModPaneBlock(Block.Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)));
	}
}
