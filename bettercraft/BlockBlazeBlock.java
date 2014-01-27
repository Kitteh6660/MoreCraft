package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockBlazeBlock extends Block
{
	public BlockBlazeBlock(int par1, int par2)
	{
	super(par1, Material.iron);
	}
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.setFire(4);
    }

}
