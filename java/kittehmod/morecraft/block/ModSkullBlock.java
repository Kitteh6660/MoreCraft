package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSkullTileEntity;
import net.minecraft.block.SkullBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModSkullBlock extends SkullBlock {

	protected ModSkullBlock(ModSkullBlock.ISkullType type, Properties properties) {
		super(type, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(ROTATION, Integer.valueOf(0)));
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new ModSkullTileEntity();
	}
	   
	public static enum Types implements ModSkullBlock.ISkullType {
		SPIDER,
		CAVE_SPIDER,
		BLAZE,
		ZOMBIE_PIGMAN,
		ENDERMAN;
	}
	
}
