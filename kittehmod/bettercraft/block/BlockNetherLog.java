package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNetherLog extends BlockLog
{
    public BlockNetherLog()
    {
    	this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176299_a, BlockLog.EnumAxis.Y));
    }

    public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = i + 1;

        if (worldIn.func_175707_a(pos.func_177982_a(-j, -j, -j), pos.func_177982_a(j, j, j)))
        {
            for (BlockPos blockpos : BlockPos.func_177980_a(pos.func_177982_a(-i, -i, -i), pos.func_177982_a(i, i, i)))
            {
                IBlockState iblockstate = worldIn.func_180495_p(blockpos);

                if (iblockstate.func_177230_c().isLeaves(worldIn, blockpos))
                {
                    iblockstate.func_177230_c().beginLeavesDecay(worldIn, blockpos);
                }
            }
        }
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int func_149745_a(Random par1Random)
    {
        return 1;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Block idDropped(int par1, Random par2Random, int par3)
    {
        return MoreCraftBlocks.netherwood_log;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @SuppressWarnings("incomplete-switch")
    public int func_176201_c(IBlockState state)
    {
        int i = 0;

        switch ((BlockLog.EnumAxis)state.func_177229_b(field_176299_a))
        {
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    protected BlockState func_180661_e()
    {
        return new BlockState(this, new IProperty[] {field_176299_a});
    }
    
    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return super.func_180642_a(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).func_177226_a(field_176299_a, BlockLog.EnumAxis.func_176870_a(facing.func_176740_k()));
    }

    @Override public boolean canSustainLeaves(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
    @Override public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }

    public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");

        private final String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String func_176610_l()
        {
            return this.name;
        }
    }
    
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }
}
