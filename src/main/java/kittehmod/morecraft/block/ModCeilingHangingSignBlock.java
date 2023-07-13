package kittehmod.morecraft.block;

import kittehmod.morecraft.blockentity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModCeilingHangingSignBlock extends CeilingHangingSignBlock
{

	public ModCeilingHangingSignBlock(Properties properties, WoodType woodtype) {
		super(properties, woodtype);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModHangingSignBlockEntity(pos, state);
	}

}
