package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.WallSkullBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

public class ModWallSkullBlock extends WallSkullBlock {

	protected ModWallSkullBlock(SkullBlock.ISkullType type, Properties properties) {
		super(type, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new ModSkullTileEntity();
	}
}
