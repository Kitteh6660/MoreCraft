package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BetterCraftGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) 
	{
		
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) 
	{
        for(int k = 0; k < 4; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(32);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(BetterCraft.RubyOre, 4)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) 
	{
		if (!BetterCraft.generateNetherwoodTrees) { return; } //If disabled, don't generate trees.
		
        for(int k = 0; k < 32; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(128);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	if (world.getBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord) == Blocks.netherrack || world.getBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord) == Blocks.soul_sand)
        	{
        		world.setBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord, Blocks.soul_sand);
        		(new HellGenTrees(true)).generate(world, rand, firstBlockXCoord, firstBlockYCoord+1, firstBlockZCoord);
        	}
        }
	}
}