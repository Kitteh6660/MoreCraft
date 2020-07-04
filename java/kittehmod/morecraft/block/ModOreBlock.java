package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;

public class ModOreBlock extends OreBlock {
	
	public ModOreBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		if (this == ModBlocks.RUBY_ORE.get()) {
			return silktouch == 0 ? this.getExperience(RANDOM) : 0;
		} else {
			return 0;
		}
	}

}
