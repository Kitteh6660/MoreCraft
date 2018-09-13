package kittehmod.morecraft.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNetherwoodFence extends BlockFence
{
	public BlockNetherwoodFence(String p_i45406_1_, MapColor color) 
	{
		super(Material.WOOD, color);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
    }

}
