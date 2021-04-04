package kittehmod.morecraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock
{

	public ModOreBlock(Block.Properties properties) {
		super(properties);
	}

	protected int xpOnDrop(Random rand) {
		if (this == ModBlocks.RUBY_ORE.get()) {
			return MathHelper.nextInt(rand, 5, 7);
		} 
		else return 0;
	}

	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		if (this == ModBlocks.RUBY_ORE.get()) {
			return silktouch == 0 ? this.xpOnDrop(RANDOM) : 0;
		} else {
			return 0;
		}
	}

}
