package kittehmod.morecraft.block;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ModButtonBlock extends AbstractButtonBlock {

	protected ModButtonBlock(Boolean isWood, Block.Properties properties) {
		   super(isWood, properties);
	}
	   
	protected SoundEvent getSoundEvent(boolean p_196369_1_) {
		return p_196369_1_ ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
	}
}
