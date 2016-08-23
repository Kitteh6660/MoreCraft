package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.WorldGenNetherTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockNetherSapling extends BlockBush implements IGrowable
{
    //public static final PropertyEnum<BlockPlanks.EnumType> TYPE = PropertyEnum.<BlockPlanks.EnumType>create("type", BlockPlanks.EnumType.class);
    public static final PropertyInteger STAGE = PropertyInteger.func_177719_a("stage", 0, 1);

	public BlockNetherSapling() 
	{
		this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(STAGE, Integer.valueOf(0)));
		float f = 0.4F;
		func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.func_149647_a(CreativeTabs.field_78031_c);
	}

	@Override
	protected boolean func_149854_a(Block ground)
	{
		return ground == Blocks.field_150349_c || ground == Blocks.field_150346_d || ground == Blocks.field_150458_ak || ground == Blocks.field_150425_aM; // Makes this grow on grass.
	}

    public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.field_72995_K)
        {
            super.func_180650_b(worldIn, pos, state, rand);

            if (worldIn.func_175671_l(pos.func_177984_a()) >= 0 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if ((state.func_177229_b(STAGE)) == 0)
        {
            worldIn.func_180501_a(pos, state.func_177231_a(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
    	
        WorldGenerator netherTree = new WorldGenNetherTrees(true, 4, MoreCraftBlocks.netherwood_log.func_176223_P(), MoreCraftBlocks.netherwood_leaves.func_176223_P(), false);

        IBlockState iblockstate2 = Blocks.field_150350_a.func_176223_P();
        worldIn.func_180501_a(pos, iblockstate2, 4);

        if (!netherTree.func_180709_b(worldIn, rand, pos.func_177982_a(0, 0, 0))) {
            worldIn.func_180501_a(pos, state, 4);
        }
    }

    /*private boolean func_181624_a(World p_181624_1_, BlockPos p_181624_2_, int p_181624_3_, int p_181624_4_, BlockPlanks.EnumType p_181624_5_)
    {
        return this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_, 0, p_181624_4_), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_ + 1, 0, p_181624_4_), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_, 0, p_181624_4_ + 1), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_ + 1, 0, p_181624_4_ + 1), p_181624_5_);
    }*/
    
    /**
     * Whether this IGrowable can grow
     */
    public boolean func_176473_a(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean func_180670_a(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.field_73012_v.nextFloat() < 0.45D;
    }

    public void func_176474_b(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }
	
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().func_177226_a(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        int i = 0;
        i = i | ((Integer)state.func_177229_b(STAGE)).intValue() << 3;
        return i;
    }

    
    protected BlockState func_180661_e()
    {
        return new BlockState(this, new IProperty[] {STAGE});
    }
    
}