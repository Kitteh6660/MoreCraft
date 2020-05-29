package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class ModBlock extends Block {

	public ModBlock(Properties properties) {
		super(properties);
	}

	//Y U NO work?
	@Override
	public int getHarvestLevel(BlockState state) {
		if (this == ModBlocks.ENDER_BLOCK.get()) {
			return 1;
		} else if (this == ModBlocks.RUBY_BLOCK.get()) {
			return 2;
		} else {
			return 0;
		}
	}
	
}
