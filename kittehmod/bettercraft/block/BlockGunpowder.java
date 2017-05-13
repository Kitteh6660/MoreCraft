package kittehmod.bettercraft.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGunpowder extends BlockFalling
{
	public BlockGunpowder()
	{
		super(Material.SAND);
		this.setSoundType(SoundType.SAND);
	}

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }
	
}
