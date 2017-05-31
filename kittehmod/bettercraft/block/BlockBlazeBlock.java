package kittehmod.bettercraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBlazeBlock extends Block
{
	public BlockBlazeBlock()
	{
		super(Material.IRON);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setSoundType(SoundType.METAL);
	}
    
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		entityIn.setFire(4);
    }

}
