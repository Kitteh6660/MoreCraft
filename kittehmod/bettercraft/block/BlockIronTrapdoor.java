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
        this.func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.func_149647_a(CreativeTabs.field_78028_d);
    }
}
