package kittehmod.morecraft.worldgen;

import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGenerator {

    public static void setupGeneration() {
		SetupOverworldGeneration();
		SetupNetherGeneration();
    }
	
	public static void SetupOverworldGeneration() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 1, 4, 64)));
		}
		
	}
	
	public static void SetupNetherGeneration() {
		Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(
			ModFeatures.NETHERWOOD_TREE.get(), 
			IFeatureConfig.NO_FEATURE_CONFIG, 
			Placement.COUNT_RANGE, 
			new CountRangeConfig(MoreCraftConfig.generateNetherwoodTrees.get(), 0, 6, 224)
		));
	}
	
}

// -- OLD CODE --

/*import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.AbstractChunkProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MoreCraftGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, ChunkGenerator chunkGenerator, AbstractChunkProvider chunkProvider) {
        if (world.getDimension().getType() == DimensionType.THE_NETHER) {
            generateNether(world, chunkGenerator, random, chunkX * 16, chunkZ * 16);
        }
        else if (world.getDimension().getType() == DimensionType.OVERWORLD) {
            generateSurface(world, chunkGenerator, random, chunkX * 16, chunkZ * 16);
        }
        else if (world.getDimension().getType() == DimensionType.THE_END) {
            generateEnd(world, chunkGenerator, random, chunkX * 16, chunkZ * 16);
        }
	}

	private void generateEnd(World world, ChunkGenerator<?> chunkGenerator, Random rand, int chunkX, int chunkZ) 
	{
		
	}

	private void generateSurface(World worldIn, ChunkGenerator<?> chunkGenerator, Random rand, int chunkX, int chunkZ) 
	{
        for(int k = 0; k < 4; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(32);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	BlockPos pos = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        	
        	//OreFeature rubyOreGen = new OreFeature(MoreCraftBlocks.RUBY_ORE.get().getDefaultState(), 4);
        	//rubyOreGen.generate(worldIn, rand, pos);
        	//System.out.println("Generated ruby ore!");
        }
	}

	private void generateNether(World worldIn, ChunkGenerator<?> chunkGenerator, Random rand, int chunkX, int chunkZ) 
	{
		if (MoreCraftConfig.generateNetherwoodTrees <= 0) { return; } //If disabled, don't generate trees.
		
        for(int k = 0; k < MoreCraftConfig.generateNetherwoodTrees; k++)
        {
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = 8 + rand.nextInt(100);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	Boolean eligible = true;
        	BlockPos pos = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        	
        	for (int i = 1; i < 5; i++) { //Shift generation towards available air, attempt up to 5 times per tree.
        		if (worldIn.getBlockState(pos.up(i)) == Blocks.AIR.getDefaultState()) {
        			pos = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ());
        			break;
        		}
        	}
        	for (int i = 1; i < 5; i++) { //Check if the 4 blocks above are air eligible.
        		if (worldIn.getBlockState(pos.up(i)) != Blocks.AIR.getDefaultState()) {
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
        		NetherwoodTreeFeature netherTree = new NetherwoodTreeFeature(NoFeatureConfig::deserialize, true, false);
        		//netherTree.place(worldIn, chunkGenerator, rand, pos, config);
        	}
        }
	}*
}*/