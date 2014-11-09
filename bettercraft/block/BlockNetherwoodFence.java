package kittehmod.bettercraft.block;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockNetherwoodFence extends BlockFence
{
	public BlockNetherwoodFence(String p_i45406_1_, Material material) 
	{
		super(p_i45406_1_, Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return BetterCraft.NetherPlanks.getBlockTextureFromSide(p_149691_1_);
    }
    
    public Boolean canBurn()
    {
    	return false;
    }

}
