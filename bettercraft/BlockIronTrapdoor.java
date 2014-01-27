package kittehmod.bettercraft;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockIronTrapdoor extends BlockTrapDoor
{
    protected BlockIronTrapdoor(int par1, Material par2Material)
    {
        super(par1, par2Material);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
}
