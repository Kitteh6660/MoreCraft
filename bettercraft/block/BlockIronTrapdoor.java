package kittehmod.bettercraft.block;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockIronTrapdoor extends BlockTrapDoor
{
    public BlockIronTrapdoor(Material par2Material)
    {
        super(par2Material);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
}
