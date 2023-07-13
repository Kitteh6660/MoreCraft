package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModChestBlockEntity extends ChestBlockEntity
{
	public ModChestBlockEntity(BlockPos p_155331_, BlockState p_155332_) {
		this(ModBlockEntityType.NETHERWOOD_CHEST.get(), p_155331_, p_155332_);
	}
	
	protected ModChestBlockEntity(BlockEntityType<?> betype, BlockPos pos, BlockState state) {
		super(betype, pos, state);
	}

	@Override
	public BlockEntityType<?> getType() {
		return ModBlockEntityType.NETHERWOOD_CHEST.get();
	}
}