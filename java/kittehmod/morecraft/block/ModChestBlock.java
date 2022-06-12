package kittehmod.morecraft.block;

import java.util.function.Supplier;

import kittehmod.morecraft.blockentity.ModChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModChestBlock extends ChestBlock
{
	public ModChestBlock(Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> blockentity) {
		super(properties, blockentity);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModChestBlockEntity(pos, state);
	}

}