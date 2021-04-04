package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModWallSignBlock extends WallSignBlock
{
	public static final DirectionProperty FACING = HorizontalBlock.FACING;

	public ModWallSignBlock(Block.Properties properties, WoodType woodtype) {
		super(properties, woodtype);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader worldIn) {
		return new ModSignTileEntity();
	}

	/**
	 * Returns the unlocalized name of the block with "tile." appended to the front.
	 */
	public String getDescriptionId() {
		return this.asItem().getDescriptionId();
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getItemInHand(handIn);
		boolean flag = itemstack.getItem() instanceof DyeItem && player.abilities.mayBuild;
		if (worldIn.isClientSide) {
			return flag ? ActionResultType.SUCCESS : ActionResultType.CONSUME;
		} else {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof ModSignTileEntity) {
				ModSignTileEntity signtileentity = (ModSignTileEntity) tileentity;
				if (flag) {
					boolean flag1 = signtileentity.setTextColor(((DyeItem) itemstack.getItem()).getDyeColor());
					if (flag1 && !player.isCreative()) {
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
