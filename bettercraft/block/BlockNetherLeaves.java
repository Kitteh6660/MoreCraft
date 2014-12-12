package kittehmod.bettercraft.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNetherLeaves extends BlockLeavesBase
{

	private int field_94394_cP;
	int adjacentTreeBlocks[];

	public BlockNetherLeaves()
	{
		super(Material.leaves, false);
		this.setTickRandomly(true);
	}

	public int getBlockColor()
	{
		double d = 0.5D;
		double d1 = 1.0D;
		return 0;
	}
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte var7 = 1;
		int var8 = var7 + 1;

		if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
		{
			for (int var9 = -var7; var9 <= var7; ++var9)
			{
				for (int var10 = -var7; var10 <= var7; ++var10)
				{
					for (int var11 = -var7; var11 <= var7; ++var11)
					{
						Block var12 = par1World.getBlock(par2 + var9, par3 + var10, par4 + var11);

						if (var12 == BetterCraft.NetherLeaves)
						{
							int var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11);
							par1World.setBlockMetadataWithNotify(par2 + var9, par3 + var10, par4 + var11, var13 | 8, 4);
						}
					}
				}
			}
		}
	}

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int i, int j, int k, Random p_149674_5_)
    {
    	
        if (!world.isRemote)
        {
        	
            int var6 = world.getBlockMetadata(i, j, k);
            if (var6 == 0) //((var6 & 8) != 0 && (var6 & 4) == 0)
            {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;

                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[var9 * var9 * var9];
                }

                int var12;

                if (world.checkChunksExist(i - var8, j - var8, k - var8, i + var8, j + var8, k + var8))
                {
                    int var13;
                    int var14;

                    for (var12 = -var7; var12 <= var7; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                Block var15 = world.getBlock(i + var12, j + var13, k + var14);

                                if (var15 != BetterCraft.NetherLog)
                                {
                                    if (var15.getMaterial() == Material.leaves)
                                    {
                                        this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                    }
                                    else
                                    {
                                        this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                    }
                                }
                                else
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                }
                            }
                        }
                    }

                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                for (int var16 = -var7; var16 <= var7; ++var16)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var16 + var11] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var16 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var16 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var16 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var16 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var16 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var16 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var16 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var16 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var16 + var11 - 1)] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var16 + var11 - 1)] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var16 + var11 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var16 + var11 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

                if (var12 >= 0)
                {
                    world.setBlockMetadataWithNotify(i, j, k, var6 & -9, 4);
                }
                else
                {
                    this.removeLeaves(world, i, j, k);
                }
            }
        }
    }
	
	private void removeLeaves(World world, int i, int j, int k)
	{
		dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
		world.setBlockToAir(i, j, k);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && par5Random.nextInt(15) == 1)
		{
			double var6 = (double)((float)par2 + par5Random.nextFloat());
			double var8 = (double)par3 - 0.05D;
			double var10 = (double)((float)par4 + par5Random.nextFloat());
			par1World.spawnParticle("dripWater", var6, var8, var10, 0.0D, 0.0D, 0.0D);
		}
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) != 0 ? 0 : 1;
	}

	public Item getItemDropped(int par1, Random random, int zero) 
	{
		return Item.getItemFromBlock(BetterCraft.NetherSapling); //Makes your leaves drop your type of sapling.
	}

    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int fortune)
    {
		if (world.rand.nextInt(50/(fortune+1)) == 0)
		{
			dropBlockAsItem(world, i, j, k, new ItemStack(Items.apple, 1, 0)); //Makes your leaf have a 1/50 chance to drop an apple.
		}
		else if (world.rand.nextInt(20/(fortune+1)) == 0)
		{
			dropBlockAsItem(world, i, j, k, new ItemStack(BetterCraft.NetherSapling, 1, 0)); //Makes your leaf have a 1/20 chance to drop an apple.			
		}
    }

	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	{
		if (!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().getItem() == Items.shears)
		{
			entityplayer.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
			dropBlockAsItem(world, i, j, k, new ItemStack(BetterCraft.NetherLeaves, 1, l & 3));
		}
		else
		{
			//dropBlockAsItemWithChance(world, i, j, k, l);
			super.harvestBlock(world, entityplayer, i, j, k, l);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean par1)
	{
		this.field_150121_P = par1;
		this.field_94394_cP = par1 ? 0 : 1;
	}

	public int damageDropped(int i)
	{
		return i & 3;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public void onEntityWalking(World world, int i, int j, int k, Entity entity)
	{
		super.onEntityWalking(world, i, j, k, entity);
	}

    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		Block var6 = par1IBlockAccess.getBlock(par2, par3, par4);
		return !this.field_150121_P && var6 == this ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
	}

	
}