package kittehmod.morecraft.block;

import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModStandingSignBlock extends StandingSignBlock 
{	
	public ModStandingSignBlock(Block.Properties properties, WoodType woodtype) {
		super(properties, woodtype);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader worldIn) {
		return new ModSignTileEntity();
	}
}
