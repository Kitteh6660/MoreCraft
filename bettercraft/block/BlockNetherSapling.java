package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.BetterCraft;
import kittehmod.bettercraft.HellGenTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BlockNetherSapling extends BlockBush
{
	public BlockNetherSapling() 
	{
		super();
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}


	protected boolean canThisPlantGrowOnThisBlockID(Block i) 
	{
		return i == Blocks.grass || i == Blocks.dirt || i == Blocks.soul_sand; // Makes this grow on grass.
	}

	public void updateTick(World world, int i, int j, int k, Random random) 
	{
		if (world.isRemote) 
		{
			return;
		}
		super.updateTick(world, i, j, k, random);

		if (world.getBlockLightValue(i, j + 1, k) >= 9
				&& random.nextInt(7) == 0) {
			growTree(world, i, j, k, random);
		}
	}

	public void growTree(World world, int i, int j, int k, Random random) 
	{
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, Blocks.air, 0, l);
		Object obj = null;
		obj = new HellGenTrees(true);
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) 
		{
			world.setBlock(i, j, k, BetterCraft.NetherSapling, 0, l);
			//(new HellGenTrees(true)).generate(world, random, i, j, k);
		}
	}

	public int damageDropped(int i) 
	{
		return i & 3;
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) 
	{
		return (par1World.getFullBlockLightValue(par2, par3, par4) >= 0 || par1World.canBlockSeeTheSky(par2, par3, par4))&& this.canThisPlantGrowOnThisBlockID(par1World.getBlock(par2, par3 - 1, par4));
	}

}