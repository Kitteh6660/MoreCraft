package kittehmod.bettercraft.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockNetherwoodFence extends BlockFence
{
	public BlockNetherwoodFence(String p_i45406_1_, Material material) 
	{
		super(Material.field_151575_d);
		this.func_149647_a(CreativeTabs.field_78031_c);
	}

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
    }

}
