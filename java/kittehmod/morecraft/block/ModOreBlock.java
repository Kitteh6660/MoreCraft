package kittehmod.morecraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock {
	
	public ModOreBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	protected int func_220281_a(Random p_220281_1_) {
		if (this == ModBlocks.RUBY_ORE.get()) {
			return MathHelper.nextInt(p_220281_1_, 3, 6);
		} else {
			return 0;
		}
	}

}
