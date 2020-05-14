package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class NetherwoodLogBlock extends LogBlock
{
	
	private final MaterialColor verticalColor;
	
	public NetherwoodLogBlock(MaterialColor p_i48367_1_, Block.Properties p_i48367_2_) {
		super(p_i48367_1_, p_i48367_2_);
		this.verticalColor = p_i48367_1_;
		//BLOCK_STRIPPING_MAP
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (player.getHeldItemMainhand().getItem() instanceof AxeItem) {
			//LOGGER.info(handIn);
			Block block = state.getBlock() == ModBlocks.NETHERWOOD_LOG.get() ? ModBlocks.STRIPPED_NETHERWOOD_LOG.get() : ModBlocks.STRIPPED_NETHERWOOD_WOOD.get();
			worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, block.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
				if (player != null) {
					player.getHeldItemMainhand().damageItem(1, player, (consumer) -> {
						consumer.sendBreakAnimation(handIn);
					});
	            }
	        }
			return true;
		}
		return false;
	}
	
	/**
	* Get the MapColor for this Block and the given BlockState
	* @deprecated call via {@link IBlockState#getMapColor(IBlockAccess,BlockPos)} whenever possible.
	* Implementing/overriding is fine.
	*/
	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
	   return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;
	}
    
}
