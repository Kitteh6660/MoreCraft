package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockGunpowder extends BlockFalling
{
	public BlockGunpowder()
	{
		super(Material.sand);
	}

	public boolean canBurn()
	{
		return true;
	}
	
}
