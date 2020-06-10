package kittehmod.morecraft.item;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WitherBonemealItem extends Item {
	
	private static final Set<Block> AFFECTED_BLOCKS = ImmutableSet.of(Blocks.GRASS_BLOCK, Blocks.PODZOL);
	
	public WitherBonemealItem(Item.Properties properties) {
		super(properties);
	}

	/**
	 * Called when this item is used when targetting a Block
	 */
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		//BlockPos blockpos1 = blockpos.offset(context.getFace());
		if (applyBonemeal(context.getItem(), world, blockpos, context.getPlayer())) {
			if (!world.isRemote) {
				world.playEvent(2005, blockpos, 0);
			}

			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.PASS;
		}
	}

	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
		BlockState blockstate = worldIn.getBlockState(pos);
		int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
		if (hook != 0) return hook > 0;
		//Kills saplings, turning them into dead bushes.
		if (blockstate.getBlock() instanceof IGrowable) {
			IGrowable igrowable = (IGrowable)blockstate.getBlock();
			if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote) && !AFFECTED_BLOCKS.contains(blockstate.getBlock())) {
				if (!worldIn.isRemote) {
					if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
						if (igrowable instanceof SaplingBlock || igrowable instanceof SweetBerryBushBlock) {
							worldIn.setBlockState(pos, Blocks.DEAD_BUSH.getDefaultState());
						}
						else {
							worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
						}
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
				if (!worldIn.isRemote) {
					worldIn.setBlockState(pos, Blocks.WITHER_ROSE.getDefaultState());
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
					worldIn.setBlockState(affectPos, Blocks.MYCELIUM.getDefaultState());
				}
				if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(affectPos.up()).getBlock())) {
					worldIn.setBlockState(affectPos.up(), Blocks.MYCELIUM.getDefaultState());
				}
				if (AFFECTED_BLOCKS.contains(worldIn.getBlockState(affectPos.down()).getBlock())) {
					worldIn.setBlockState(affectPos.down(), Blocks.MYCELIUM.getDefaultState());
				}
			}
			stack.shrink(1);
			return true;
		}
		return false;
	}
	
}
