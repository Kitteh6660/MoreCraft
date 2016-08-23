package kittehmod.bettercraft.block;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSoulGlass extends BlockGlass
{
	@SideOnly(Side.CLIENT)
	
    public BlockSoulGlass(Material par2Material, boolean par3)
    {
        super(par2Material, par3);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }

}
