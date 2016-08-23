package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MoreCraftGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionId()){
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
        	
        	WorldGenerator rubyOreGen = new WorldGenMinable(MoreCraftBlocks.ruby_ore.getDefaultState(), 4);
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
        		if (worldIn.getBlockState(new BlockPos(pos.add(0, 1, 0))) != Blocks.air.getDefaultState()) {
        			pos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        		}
        		else {
        			break;
        		}
        	}
        	for (int i = 1; i < 5; i++) { //Check if the 4 blocks above are air eligible.
        		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ())) != Blocks.air.getDefaultState()) {
        			eligible = false;
        		}
        	}
        	if (!eligible) { //Ineligible? Skip over.
        		//System.out.println("Skipped");
        		continue;
        	}
        	
        	if (worldIn.getBlockState(new BlockPos(pos)) == Blocks.netherrack.getDefaultState() || worldIn.getBlockState(new BlockPos(pos)) == Blocks.soul_sand.getDefaultState())
        	{
        		worldIn.setBlockState(pos, Blocks.soul_sand.getDefaultState(), 2);
        		WorldGenerator netherTree = new WorldGenNetherTrees(true, 4, MoreCraftBlocks.netherwood_log.getDefaultState(), MoreCraftBlocks.netherwood_leaves.getDefaultState(), false);
        		
        		//IBlockState iblockstate = Blocks.air.getDefaultState();
        		//worldIn.setBlockState(pos, iblockstate, 2);
        		
        		//System.out.println("Generating...");
        		if (!netherTree.generate(worldIn, rand, pos.add(0, 1, 0))) {
        			//System.out.println("Unable to generate tree.");
        		}
        	}
        }
	}
}