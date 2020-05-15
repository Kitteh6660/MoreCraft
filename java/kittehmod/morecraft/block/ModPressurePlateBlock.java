package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;

public class ModPressurePlateBlock extends PressurePlateBlock {
	
	public ModPressurePlateBlock(PressurePlateBlock.Sensitivity p_i48348_1_, Block.Properties p_i48348_2_) {
		super(p_i48348_1_, p_i48348_2_);
		this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, Boolean.valueOf(false)));
	}
	
}
