package kittehmod.bettercraft.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import kittehmod.bettercraft.TileEntityNetherwoodChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherwoodChest extends BlockChest 
{
	private final Random rand = new Random();
	public BlockNetherwoodChest() 
	{
		super(0);
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack)
	{
		Block block = world.getBlock(posX, posY, posZ - 1);
		Block block1 = world.getBlock(posX, posY, posZ + 1);
		Block block2 = world.getBlock(posX - 1, posY, posZ);
		Block block3 = world.getBlock(posX + 1, posY, posZ);
		byte b0 = 0;
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0)
		{
			b0 = 2;
		}
		if (l == 1)
		{
			b0 = 5;
		}
		if (l == 2)
		{
			b0 = 3;
		}
		if (l == 3)
		{
			b0 = 4;
		}
		if (block != this && block1 != this && block2 != this && block3 != this)
		{
			world.setBlockMetadataWithNotify(posX, posY, posZ, b0, 3);
		}
		else
		{
			if ((block == this || block1 == this) && (b0 == 4 || b0 == 5))
			{
				if (block == this)
				{
					world.setBlockMetadataWithNotify(posX, posY, posZ - 1, b0, 3);
				}
				else
				{
					world.setBlockMetadataWithNotify(posX, posY, posZ + 1, b0, 3);
				}
				world.setBlockMetadataWithNotify(posX, posY, posZ, b0, 3);
			}
			if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3))
			{
				if (block2 == this)
				{
					world.setBlockMetadataWithNotify(posX - 1, posY, posZ, b0, 3);
				}
				else
				{
					world.setBlockMetadataWithNotify(posX + 1, posY, posZ, b0, 3);
				}
				world.setBlockMetadataWithNotify(posX, posY, posZ, b0, 3);
			}
		}
		if (stack.hasDisplayName())
		{
			((TileEntityNetherwoodChest)world.getTileEntity(posX, posY, posZ)).getInventoryName(); //.func_145976_a(stack.getDisplayName());
		}
	}
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	public void onNeighborBlockChange(World world, int posX, int posY, int posZ, Block block)
	{
		super.onNeighborBlockChange(world, posX, posY, posZ, block);
		TileEntityNetherwoodChest TileEntityNetherwoodChest = (TileEntityNetherwoodChest)world.getTileEntity(posX, posY, posZ);
		if (TileEntityNetherwoodChest != null)
		{
			TileEntityNetherwoodChest.updateContainingBlockInfo();
		}
	}
	public void breakBlock(World p_149749_1_, int coordX, int coordY, int coordZ, Block p_149749_5_, int p_149749_6_)
	{
		TileEntityNetherwoodChest TileEntityNetherwoodChest = (TileEntityNetherwoodChest)p_149749_1_.getTileEntity(coordX, coordY, coordZ);
		if (TileEntityNetherwoodChest != null)
		{
			for (int i1 = 0; i1 < TileEntityNetherwoodChest.getSizeInventory(); ++i1)
			{
				ItemStack itemstack = TileEntityNetherwoodChest.getStackInSlot(i1);
				if (itemstack != null)
				{
					float f = this.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;
					for (float f2 = this.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; p_149749_1_.spawnEntityInWorld(entityitem))
					{
						int j1 = this.rand.nextInt(21) + 10;
						if (j1 > itemstack.stackSize)
						{
							j1 = itemstack.stackSize;
						}
						itemstack.stackSize -= j1;
						entityitem = new EntityItem(p_149749_1_, (double)((float)coordX + f), (double)((float)coordY + f1), (double)((float)coordZ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
						entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
						}
					}
				}
			}
			//p_149749_1_.func_147453_f(coordX, coordY, coordZ, p_149749_5_);
		}
		super.breakBlock(p_149749_1_, coordX, coordY, coordZ, p_149749_5_, p_149749_6_);
	}
	
	public IInventory func_149951_m(World world, int posX, int posY, int posZ)
	{
		Object object = (TileEntityNetherwoodChest)world.getTileEntity(posX, posY, posZ);
		if (object == null)
		{
			return null;
		}
		else if (world.isSideSolid(posX, posY + 1, posZ, DOWN))
		{
			return null;
		}
		else if (func_149953_o(world, posX, posY, posZ))
		{
			return null;
		}
		else if (world.getBlock(posX - 1, posY, posZ) == this && (world.isSideSolid(posX - 1, posY + 1, posZ, DOWN) || func_149953_o(world, posX - 1, posY, posZ)))
		{
			return null;
		}
		else if (world.getBlock(posX + 1, posY, posZ) == this && (world.isSideSolid(posX + 1, posY + 1, posZ, DOWN) || func_149953_o(world, posX + 1, posY, posZ)))
		{
			return null;
		}
		else if (world.getBlock(posX, posY, posZ - 1) == this && (world.isSideSolid(posX, posY + 1, posZ - 1, DOWN) || func_149953_o(world, posX, posY, posZ - 1)))
		{
			return null;
		}
		else if (world.getBlock(posX, posY, posZ + 1) == this && (world.isSideSolid(posX, posY + 1, posZ + 1, DOWN) || func_149953_o(world, posX, posY, posZ + 1)))
		{
			return null;
		}
		else
		{
			if (world.getBlock(posX - 1, posY, posZ) == this)
			{
				object = new InventoryLargeChest("Large Chest", (TileEntityNetherwoodChest)world.getTileEntity(posX - 1, posY, posZ), (IInventory)object);
			}
			if (world.getBlock(posX + 1, posY, posZ) == this)
			{
				object = new InventoryLargeChest("Large Chest", (IInventory)object, (TileEntityNetherwoodChest)world.getTileEntity(posX + 1, posY, posZ));
			}
			if (world.getBlock(posX, posY, posZ - 1) == this)
			{
				object = new InventoryLargeChest("Large Chest", (TileEntityNetherwoodChest)world.getTileEntity(posX, posY, posZ - 1), (IInventory)object);
			}
			if (world.getBlock(posX, posY, posZ + 1) == this)
			{
				object = new InventoryLargeChest("Large Chest", (IInventory)object, (TileEntityNetherwoodChest)world.getTileEntity(posX, posY, posZ + 1));
			}
			return (IInventory)object;
		}
	}
	private static boolean func_149953_o(World p_149953_0_, int p_149953_1_, int p_149953_2_, int p_149953_3_)
	{
		Iterator var4 = p_149953_0_.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double)p_149953_1_, (double)(p_149953_2_ + 1), (double)p_149953_3_, (double)(p_149953_1_ + 1), (double)(p_149953_2_ + 2), (double)(p_149953_3_ + 1))).iterator();
        EntityOcelot var6;

        do
        {
            if (!var4.hasNext())
            {
                return false;
            }

            Entity var5 = (Entity)var4.next();
            var6 = (EntityOcelot)var5;
        }
        while (!var6.isSitting());

        return true;
    }
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		TileEntityNetherwoodChest TileEntityNetherwoodChest = new TileEntityNetherwoodChest();
		return TileEntityNetherwoodChest;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.blockIcon = p_149651_1_.registerIcon("bettercraft:NetherPlanks");
	}
	

}