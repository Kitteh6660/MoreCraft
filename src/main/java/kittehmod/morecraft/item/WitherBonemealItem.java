package kittehmod.morecraft.item;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WitherBonemealItem extends Item {
	
	private static final Set<Block> AFFECTED_BLOCKS = ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL);
	
	public WitherBonemealItem(Item.Properties properties) {
		super(properties);
	}

	/**
	 * Called when this item is used when targetting a Block
	 */
	public InteractionResult onItemUse(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		//BlockPos blockpos1 = blockpos.offset(context.getFace());
		if (applyBonemeal(context.getItemInHand(), world, blockpos, context.getPlayer())) {
			if (!world.isClientSide) {
				world.levelEvent(2005, blockpos, 0);
			}

			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}

	public static boolean applyBonemeal(ItemStack stack, Level worldIn, BlockPos pos, Player player) {
		BlockState blockstate = worldIn.getBlockState(pos);
		int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
		if (hook != 0) return hook > 0;
		//Kills saplings, turning them into dead bushes.
		if (blockstate.getBlock() instanceof BonemealableBlock) {
			BonemealableBlock BonemealableBlock = (BonemealableBlock)blockstate.getBlock();
			if (BonemealableBlock.isValidBonemealTarget(worldIn, pos, blockstate, worldIn.isClientSide) && !AFFECTED_BLOCKS.contains(blockstate.getBlock())) {
				if (!worldIn.isClientSide) {
					if (BonemealableBlock instanceof SaplingBlock || BonemealableBlock instanceof SweetBerryBushBlock) {
						worldIn.setBlock(pos, Blocks.DEAD_BUSH.defaultBlockState(), 11);
					}
					stack.shrink(1);
				}
				return true;
			}
		}
		//Turns flowers into wither roses.
		if (blockstate.getBlock() instanceof FlowerBlock) {
			FlowerBlock flower = (FlowerBlock)blockstate.getBlock();
			if (flower != Blocks.WITHER_ROSE) {
				if (!worldIn.isClientSide) {
					worldIn.setBlock(pos, Blocks.WITHER_ROSE.defaultBlockState(), 11);
					stack.shrink(1);
				}
				return true;
			}
		}
		//Kills grass, mycelium, and podzol, turning them into dirt.
		if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(pos).getBlock())) {
			for (int i = 0; i < 9; i++) {
				BlockPos affectPos = pos;
				switch(i % 3) {
					case 0:
						affectPos = pos.north();
						break;
					case 1:
						//Doesn't shift position.
						break;
					case 2:
						affectPos = pos.south();
						break;
				}
				switch(i) {
					case 0:
					case 1:
					case 2:
						affectPos = affectPos.west();
						break;
					case 3:
					case 4:
					case 5:
						//Doesn't shift position.
						break;
					case 6:
					case 7:
					case 8:
						affectPos = affectPos.east();
						break;
				}
				if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(affectPos).getBlock())) {
					worldIn.setBlockAndUpdate(affectPos, Blocks.MYCELIUM.defaultBlockState());
				}
				if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(affectPos.above()).getBlock())) {
					worldIn.setBlockAndUpdate(affectPos.above(), Blocks.MYCELIUM.defaultBlockState());
				}
				if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(affectPos.below()).getBlock())) {
					worldIn.setBlockAndUpdate(affectPos.below(), Blocks.MYCELIUM.defaultBlockState());
				}
			}
			stack.shrink(1);
			return true;
		}
		return false;
	}
	
}
