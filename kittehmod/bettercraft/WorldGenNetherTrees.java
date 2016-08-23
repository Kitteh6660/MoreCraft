package kittehmod.bettercraft;

import java.util.Random;

import kittehmod.bettercraft.block.BlockNetherLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenNetherTrees extends WorldGenAbstractTree
{
    private static final IBlockState field_181653_a = MoreCraftBlocks.netherwood_log.func_176223_P();
    private static final IBlockState field_181654_b = MoreCraftBlocks.netherwood_leaves.func_176223_P().func_177226_a(BlockNetherLeaves.field_176236_b, Boolean.valueOf(false));
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;

    public WorldGenNetherTrees(boolean p_i2027_1_)
    {
        this(p_i2027_1_, 4, field_181653_a, field_181654_b, false);
    }

    public WorldGenNetherTrees(boolean p_i46446_1_, int p_i46446_2_, IBlockState p_i46446_3_, IBlockState p_i46446_4_, boolean p_i46446_5_)
    {
        super(p_i46446_1_);
        this.minTreeHeight = p_i46446_2_;
        this.metaWood = p_i46446_3_;
        this.metaLeaves = p_i46446_4_;
        this.vinesGrow = p_i46446_5_;
    }

    public boolean func_180709_b(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (position.func_177956_o() >= 1 && position.func_177956_o() + i + 1 <= 256)
        {
            for (int j = position.func_177956_o(); j <= position.func_177956_o() + 1 + i; ++j)
            {
                int k = 1;

                if (j == position.func_177956_o())
                {
                    k = 0;
                }

                if (j >= position.func_177956_o() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.func_177958_n() - k; l <= position.func_177958_n() + k && flag; ++l)
                {
                    for (int i1 = position.func_177952_p() - k; i1 <= position.func_177952_p() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.func_181079_c(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.func_177977_b();
                Block block1 = worldIn.func_180495_p(down).func_177230_c();
                boolean isSoil = block1.canSustainPlant(worldIn, down, net.minecraft.util.EnumFacing.UP, (IPlantable)MoreCraftBlocks.netherwood_sapling);

                if (isSoil && position.func_177956_o() < 256 - i - 1)
                {
                    block1.onPlantGrow(worldIn, down, position);
                    int k2 = 3;
                    int l2 = 0;

                    for (int i3 = position.func_177956_o() - k2 + i; i3 <= position.func_177956_o() + i; ++i3)
                    {
                        int i4 = i3 - (position.func_177956_o() + i);
                        int j1 = l2 + 1 - i4 / 2;

                        for (int k1 = position.func_177958_n() - j1; k1 <= position.func_177958_n() + j1; ++k1)
                        {
                            int l1 = k1 - position.func_177958_n();

                            for (int i2 = position.func_177952_p() - j1; i2 <= position.func_177952_p() + j1; ++i2)
                            {
                                int j2 = i2 - position.func_177952_p();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    Block block = worldIn.func_180495_p(blockpos).func_177230_c();

                                    if (block.isAir(worldIn, blockpos) || block.isLeaves(worldIn, blockpos) || block.func_149688_o() == Material.field_151582_l)
                                    {
                                        this.func_175903_a(worldIn, blockpos, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (int j3 = 0; j3 < i; ++j3)
                    {
                        BlockPos upN = position.func_177981_b(j3);
                        Block block2 = worldIn.func_180495_p(upN).func_177230_c();

                        if (block2.isAir(worldIn, upN) || block2.isLeaves(worldIn, upN) || block2.func_149688_o() == Material.field_151582_l)
                        {
                            this.func_175903_a(worldIn, position.func_177981_b(j3), this.metaWood);
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (int k3 = position.func_177956_o() - 3 + i; k3 <= position.func_177956_o() + i; ++k3)
                        {
                            int j4 = k3 - (position.func_177956_o() + i);
                            int k4 = 2 - j4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for (int l4 = position.func_177958_n() - k4; l4 <= position.func_177958_n() + k4; ++l4)
                            {
                                for (int i5 = position.func_177952_p() - k4; i5 <= position.func_177952_p() + k4; ++i5)
                                {
                                    blockpos$mutableblockpos1.func_181079_c(l4, k3, i5);
                                }
                            }
                        }

                        if (rand.nextInt(5) == 0 && i > 5)
                        {
                            for (int l3 = 0; l3 < 2; ++l3)
                            {
                                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
                                {
                                    if (rand.nextInt(4 - l3) == 0)
                                    {
                                        EnumFacing enumfacing1 = enumfacing.func_176734_d();
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}