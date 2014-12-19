package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNetherWood extends Block
{
	public BlockNetherWood()
	{
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return false;
    }

}
