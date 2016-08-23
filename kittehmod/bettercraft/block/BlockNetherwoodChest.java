package kittehmod.bettercraft.block;

import java.util.Iterator;
import java.util.Random;

import kittehmod.bettercraft.TileEntityNetherwoodChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockNetherwoodChest extends BlockChest 
{
	private final Random field_149955_b = new Random();
	public BlockNetherwoodChest(int par1) 
	{
		super(par1);
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
    public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing enumfacing = EnumFacing.func_176731_b(MathHelper.func_76128_c((double)(placer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3).func_176734_d();
        state = state.func_177226_a(field_176459_a, enumfacing);
        BlockPos blockpos = pos.func_177978_c();
        BlockPos blockpos1 = pos.func_177968_d();
        BlockPos blockpos2 = pos.func_177976_e();
        BlockPos blockpos3 = pos.func_177974_f();
        boolean flag = this == worldIn.func_180495_p(blockpos).func_177230_c();
        boolean flag1 = this == worldIn.func_180495_p(blockpos1).func_177230_c();
        boolean flag2 = this == worldIn.func_180495_p(blockpos2).func_177230_c();
        boolean flag3 = this == worldIn.func_180495_p(blockpos3).func_177230_c();

        if (!flag && !flag1 && !flag2 && !flag3)
        {
            worldIn.func_180501_a(pos, state, 3);
        }
        else if (enumfacing.func_176740_k() != EnumFacing.Axis.X || !flag && !flag1)
        {
            if (enumfacing.func_176740_k() == EnumFacing.Axis.Z && (flag2 || flag3))
            {
                if (flag2)
                {
                    worldIn.func_180501_a(blockpos2, state, 3);
                }
                else
                {
                    worldIn.func_180501_a(blockpos3, state, 3);
                }

                worldIn.func_180501_a(pos, state, 3);
            }
        }
        else
        {
            if (flag)
            {
                worldIn.func_180501_a(blockpos, state, 3);
            }
            else
            {
                worldIn.func_180501_a(blockpos1, state, 3);
            }

            worldIn.func_180501_a(pos, state, 3);
        }

        if (stack.func_82837_s())
        {
            TileEntity tileentity = worldIn.func_175625_s(pos);

            if (tileentity instanceof TileEntityChest)
            {
                ((TileEntityChest)tileentity).func_145976_a(stack.func_82833_r());
            }
        }
    }
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
    public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.func_176204_a(worldIn, pos, state, neighborBlock);
        TileEntity tileentity = worldIn.func_175625_s(pos);

        if (tileentity instanceof TileEntityNetherwoodChest)
        {
            tileentity.func_145836_u();
        }
    }

    private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos)
    {
        for (Entity entity : worldIn.func_72872_a(EntityOcelot.class, new AxisAlignedBB((double)pos.func_177958_n(), (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p(), (double)(pos.func_177958_n() + 1), (double)(pos.func_177956_o() + 2), (double)(pos.func_177952_p() + 1))))
        {
            EntityOcelot entityocelot = (EntityOcelot)entity;

            if (entityocelot.func_70906_o())
            {
                return true;
            }
        }

        return false;
    }
    
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	@Override
	public TileEntity func_149915_a(World world, int p_149915_2_)
	{
		TileEntityNetherwoodChest TileEntityNetherwoodChest = new TileEntityNetherwoodChest();
		return TileEntityNetherwoodChest;
	}

}