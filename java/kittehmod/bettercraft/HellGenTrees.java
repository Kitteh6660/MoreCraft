package kittehmod.bettercraft;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class HellGenTrees extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;

    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;

    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;

    public HellGenTrees(boolean p_i2027_1_)
    {
        this(p_i2027_1_, 4, 0, 0, false);
    }

    public HellGenTrees(boolean p_i2028_1_, int p_i2028_2_, int p_i2028_3_, int p_i2028_4_, boolean p_i2028_5_)
    {
        super(p_i2028_1_);
        this.minTreeHeight = p_i2028_2_;
        this.metaWood = p_i2028_3_;
        this.metaLeaves = p_i2028_4_;
        this.vinesGrow = p_i2028_5_;
    }

    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int var6 = p_76484_2_.nextInt(3) + this.minTreeHeight;
        boolean var7 = true;

        if (p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256)
        {
            byte var9;
            int var11;
            Block var12;

            for (int var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8)
            {
                var9 = 1;

                if (var8 == p_76484_4_)
                {
                    var9 = 0;
                }

                if (var8 >= p_76484_4_ + 1 + var6 - 2)
                {
                    var9 = 2;
                }

                for (int var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10)
                {
                    for (var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            var12 = p_76484_1_.getBlock(var10, var8, var11);

                            if (!this.func_150523_a(var12))
                            {
                                var7 = false;
                            }
                        }
                        else
                        {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7)
            {
                return false;
            }
            else
            {
                Block var19 = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ - 1, p_76484_5_);

                if ((var19 == Blocks.grass || var19 == Blocks.dirt || var19 == Blocks.farmland || var19 == Blocks.soul_sand) && p_76484_4_ < 256 - var6 - 1)
                {
                	if (var19 != Blocks.soul_sand)
                	{
                		this.func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.dirt);
                	}
                    var9 = 3;
                    byte var20 = 0;
                    int var13;
                    int var14;
                    int var15;
                    int var21;

                    for (var11 = p_76484_4_ - var9 + var6; var11 <= p_76484_4_ + var6; ++var11)
                    {
                        var21 = var11 - (p_76484_4_ + var6);
                        var13 = var20 + 1 - var21 / 2;

                        for (var14 = p_76484_3_ - var13; var14 <= p_76484_3_ + var13; ++var14)
                        {
                            var15 = var14 - p_76484_3_;

                            for (int var16 = p_76484_5_ - var13; var16 <= p_76484_5_ + var13; ++var16)
                            {
                                int var17 = var16 - p_76484_5_;

                                if (Math.abs(var15) != var13 || Math.abs(var17) != var13 || p_76484_2_.nextInt(2) != 0 && var21 != 0)
                                {
                                    Block var18 = p_76484_1_.getBlock(var14, var11, var16);

                                    if (var18.getMaterial() == Material.air || var18.getMaterial() == Material.leaves)
                                    {
                                    	p_76484_1_.setBlock(var14, var11, var16, BetterCraft.NetherLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (var11 = 0; var11 < var6; ++var11)
                    {
                        var12 = p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + var11, p_76484_5_);

                        if (var12.getMaterial() == Material.air || var12.getMaterial() == Material.leaves)
                        {
                        	p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + var11, p_76484_5_, BetterCraft.NetherLog);
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