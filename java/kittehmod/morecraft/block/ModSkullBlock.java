package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ModSkullBlock extends AbstractSkullBlock {
	public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_0_15;
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

	protected ModSkullBlock(SkullBlock.ISkullType type, Properties properties) {
		super(type, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(ROTATION, Integer.valueOf(0)));
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new ModSkullTileEntity();
	}
	
	public static enum Types implements SkullBlock.ISkullType {
		SPIDER,
		CAVE_SPIDER,
		BLAZE,
		ZOMBIE_PIGMAN,
		ENDERMAN;
	}
	
}
