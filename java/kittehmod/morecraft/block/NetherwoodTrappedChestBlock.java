package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.NetherwoodTrappedChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;

public class NetherwoodTrappedChestBlock extends TrappedChestBlock {
	
	public NetherwoodTrappedChestBlock(Block.Properties properties) {
		super(properties);
	}

	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new NetherwoodTrappedChestTileEntity();
	}

	protected Stat<ResourceLocation> getOpenStat() {
		return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
	}
	
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		return MathHelper.clamp(NetherwoodTrappedChestTileEntity.getPlayersUsing(blockAccess, pos), 0, 15);
	}
	
	interface InventoryFactory<T> {
		T forDouble(NetherwoodTrappedChestTileEntity p_212855_1_, NetherwoodTrappedChestTileEntity p_212855_2_);

		T forSingle(NetherwoodTrappedChestTileEntity p_212856_1_);
	}
}
