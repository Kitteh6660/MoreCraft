package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherWood extends Block
{
	public BlockNetherWood(int par1, int par2)
	{
        super(par1, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
    public boolean canBurn()
    {
    	return false;
    }

}
