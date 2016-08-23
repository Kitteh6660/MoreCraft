package kittehmod.bettercraft.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockGunpowder extends BlockFalling
{
	public BlockGunpowder()
	{
		super(Material.field_151595_p);
	}

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }
	
}
