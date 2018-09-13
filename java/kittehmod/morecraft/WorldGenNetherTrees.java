package kittehmod.morecraft;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public class WorldGenNetherTrees extends WorldGenAbstractTree
{
    private static final IBlockState DEFAULT_TRUNK = MoreCraftBlocks.NETHERWOOD_LOG.getDefaultState();
    private static final IBlockState DEFAULT_LEAF = MoreCraftBlocks.NETHERWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;

    public WorldGenNetherTrees(boolean notify)
    {
    	this(notify, 4, DEFAULT_TRUNK, DEFAULT_LEAF, false);
    }

    public WorldGenNetherTrees(boolean notify, int p_i46446_2_, IBlockState p_i46446_3_, IBlockState p_i46446_4_, boolean p_i46446_5_)
    {
        super(notify);
        this.minTreeHeight = p_i46446_2_;
        this.metaWood = p_i46446_3_;
        this.metaLeaves = p_i46446_4_;
        this.vinesGrow = p_i46446_5_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= 256)
        {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.setPos(l, j, i1)))
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
                IBlockState state = worldIn.getBlockState(position.down());

                if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (IPlantable) MoreCraftBlocks.NETHERWOOD_SAPLING) && position.getY() < worldIn.getHeight() - i - 1)
                {
                    //this.setDirtAt(worldIn, position.down());
                    int k2 = 3;
                    int l2 = 0;

                    for (int i3 = position.getY() - k2 + i; i3 <= position.getY() + i; ++i3)
                    {
                        int i4 = i3 - (position.getY() + i);
                        int j1 = l2 + 1 - i4 / 2;

                        for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1)
                        {
                            int l1 = k1 - position.getX();

                            for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2)
                            {
                                int j2 = i2 - position.getZ();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos) || state.getMaterial() == Material.VINE)
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }
                    
                    for (int j3 = 0; j3 < i; ++j3)
                    {
                        BlockPos upN = position.up(j3);
                        state = worldIn.getBlockState(upN);

                        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);
                        }
                    }
                    if (this.vinesGrow)
                    {
                        for (int k3 = position.getY() - 3 + i; k3 <= position.getY() + i; ++k3)
                        {
                            int j4 = k3 - (position.getY() + i);
                            int k4 = 2 - j4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4)
                            {
                                for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5)
                                {
                                    blockpos$mutableblockpos1.setPos(l4, k3, i5);
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
                                        EnumFacing enumfacing1 = enumfacing.getOpposite();
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