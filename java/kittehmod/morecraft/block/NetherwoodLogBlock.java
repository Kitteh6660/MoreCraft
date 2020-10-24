package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class NetherwoodLogBlock extends RotatedPillarBlock
{
	public NetherwoodLogBlock(Block.Properties p_i48367_2_) {
		super(p_i48367_2_);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
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
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}
    
}
