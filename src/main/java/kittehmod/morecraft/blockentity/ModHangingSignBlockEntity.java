package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends HangingSignBlockEntity
{
	public ModHangingSignBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return ModBlockEntityType.MOD_HANGING_SIGN.get();
	}

}
