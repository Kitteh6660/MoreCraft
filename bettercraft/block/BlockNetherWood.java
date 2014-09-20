package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherWood extends Block
{
	public BlockNetherWood()
	{
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
    public boolean canBurn()
    {
    	return false;
    }

}
