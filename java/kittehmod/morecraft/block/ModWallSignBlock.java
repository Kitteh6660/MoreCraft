package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

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
}
