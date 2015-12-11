package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGunpowder extends BlockFalling
{
	public BlockGunpowder()
	{
		super(Material.sand);
	}

	@Override
	public boolean isFlammable(IBlockAccess blockAccess, int coordX, int coordY, int coordZ, ForgeDirection direction)
	{
		return true;
	}
	
}
