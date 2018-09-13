package kittehmod.morecraft;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MoreCraftGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
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

	private void generateSurface(World worldIn, Random rand, int chunkX, int chunkZ) 
	{
        for(int k = 0; k < 4; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(32);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	BlockPos pos = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        	
        	WorldGenerator rubyOreGen = new WorldGenMinable(MoreCraftBlocks.RUBY_ORE.getDefaultState(), 4);
        	rubyOreGen.generate(worldIn, rand, pos);
        	//System.out.println("Generated ruby ore!");
        }
	}

	private void generateNether(World worldIn, Random rand, int chunkX, int chunkZ) 
	{
		if (MoreCraft.generateNetherwoodTrees <= 0) { return; } //If disabled, don't generate trees.
		
        for(int k = 0; k < MoreCraft.generateNetherwoodTrees; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = 8 + rand.nextInt(100);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	Boolean eligible = true;
        	BlockPos pos = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        	
        	for (int i = 1; i < 5; i++) { //Shift generation towards available air, attempt up to 5 times per tree.
        		if (worldIn.getBlockState(new BlockPos(pos.add(0, 1, 0))) != Blocks.AIR.getDefaultState()) {
        			pos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        		}
        		else {
        			break;
        		}
        	}
        	for (int i = 1; i < 5; i++) { //Check if the 4 blocks above are air eligible.
        		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ())) != Blocks.AIR.getDefaultState()) {
        			eligible = false;
        		}
        	}
        	if (!eligible) { //Ineligible? Skip over.
        		//System.out.println("Skipped");
        		continue;
        	}
        	
        	if (worldIn.getBlockState(new BlockPos(pos)) == Blocks.NETHERRACK.getDefaultState() || worldIn.getBlockState(new BlockPos(pos)) == Blocks.SOUL_SAND.getDefaultState())
        	{
        		worldIn.setBlockState(pos, Blocks.SOUL_SAND.getDefaultState(), 2);
        		WorldGenerator netherTree = new WorldGenNetherTrees(true);
        		
        		//System.out.println("Generating...");
        		if (!netherTree.generate(worldIn, rand, pos.add(0, 1, 0))) {
        			//System.out.println("Unable to generate tree.");
        		}
        	}
        }
	}

}