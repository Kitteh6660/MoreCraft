package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockBlazeBlock extends Block
{
	public BlockBlazeBlock()
	{
		super(Material.field_151573_f);
		this.func_149647_a(CreativeTabs.field_78030_b);
	}
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.func_70015_d(4);
    }

}
