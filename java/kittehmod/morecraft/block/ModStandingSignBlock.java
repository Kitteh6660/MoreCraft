package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModStandingSignBlock extends StandingSignBlock 
{	
	public ModStandingSignBlock(Block.Properties properties, WoodType woodtype) {
		super(properties, woodtype);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader worldIn) {
		return new ModSignTileEntity();
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		TileEntity tileentity = worldIn.getBlockEntity(pos);
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			if (tileentity instanceof ModSignTileEntity) {
				ModSignTileEntity signtileentity = (ModSignTileEntity)tileentity;
				ItemStack itemstack = player.getItemInHand(handIn);
				if (itemstack.getItem() instanceof DyeItem && player.abilities.mayBuild) {
					boolean flag = signtileentity.setTextColor(((DyeItem)itemstack.getItem()).getDyeColor());
					if (flag && !player.isCreative()) {
						itemstack.shrink(1);
					}
				}
				return signtileentity.executeCommand(player) ? ActionResultType.SUCCESS : ActionResultType.PASS;
			} else {
				return ActionResultType.PASS;
			}
		}
	}
}
