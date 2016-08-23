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
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
    }

}
