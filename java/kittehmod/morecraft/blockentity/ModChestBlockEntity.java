package kittehmod.morecraft.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModChestBlockEntity extends ChestBlockEntity
{
	protected ModChestBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	public ModChestBlockEntity(BlockPos pos, BlockState state) {
		this(ModBlockEntityType.NETHERWOOD_CHEST.get(), pos, state);
	}

	@Override
	public BlockEntityType<?> getType() {
		return ModBlockEntityType.NETHERWOOD_CHEST.get();
	}
}