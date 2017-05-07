package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import kittehmod.bettercraft.block.BlockNetherwoodChest;

public class TileEntityNetherwoodChest extends TileEntityChest
{
	private String customName;
	private int cachedChestType;
	private ItemStack[] chestContents = new ItemStack[36];
	/**
	 * Contains the chest tile located adjacent to this one (if any)
	 */
	public TileEntityNetherwoodChest adjacentChestZNeg;
	/**
	 * Contains the chest tile located adjacent to this one (if any)
	 */
	public TileEntityNetherwoodChest adjacentChestXPos;
	/**
	 * Contains the chest tile located adjacent to this one (if any)
	 */
	public TileEntityNetherwoodChest adjacentChestXNeg;
	/**
	 * Contains the chest tile located adjacent to this one (if any)
	 */
	public TileEntityNetherwoodChest adjacentChestZPos;
	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.customName : "Chest";
	}
	
	/**
	 * Returns if the inventory is named
	 */
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}
	
	public void func_145976_a(String p_145976_1_)
	{
		this.customName = p_145976_1_;
	}

	private void func_145978_a(TileEntityNetherwoodChest p_145978_1_, int p_145978_2_)
	{
		if (p_145978_1_.isInvalid())
		{
			this.adjacentChestChecked = false;
		}
		else if (this.adjacentChestChecked)
		{
			switch (p_145978_2_)
			{
			case 0:
				if (this.adjacentChestZPos != p_145978_1_)
				{
					this.adjacentChestChecked = false;
				}
				break;
			case 1:
				if (this.adjacentChestXNeg != p_145978_1_)
				{
					this.adjacentChestChecked = false;
				}
				break;
			case 2:
				if (this.adjacentChestZNeg != p_145978_1_)
				{
					this.adjacentChestChecked = false;
				}
				break;
			case 3:
				if (this.adjacentChestXPos != p_145978_1_)
				{
					this.adjacentChestChecked = false;
				}
			}
		}
	}
	/**
	 * Performs the check for adjacent chests to determine if this chest is double or not.
	 */
	public void checkForAdjacentChests()
	{
		if (!this.adjacentChestChecked)
		{
			this.adjacentChestChecked = true;
			this.adjacentChestZNeg = null;
			this.adjacentChestXPos = null;
			this.adjacentChestXNeg = null;
			this.adjacentChestZPos = null;
			if (this.func_145977_a(this.xCoord - 1, this.yCoord, this.zCoord))
			{
				this.adjacentChestXNeg = (TileEntityNetherwoodChest)this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
			}
			if (this.func_145977_a(this.xCoord + 1, this.yCoord, this.zCoord))
			{
				this.adjacentChestXPos = (TileEntityNetherwoodChest)this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
			}
			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord - 1))
			{
				this.adjacentChestZNeg = (TileEntityNetherwoodChest)this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
			}
			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord + 1))
			{
				this.adjacentChestZPos = (TileEntityNetherwoodChest)this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
			}
			if (this.adjacentChestZNeg != null)
			{
				this.adjacentChestZNeg.func_145978_a(this, 0);
			}
			if (this.adjacentChestZPos != null)
			{
				this.adjacentChestZPos.func_145978_a(this, 2);
			}
			if (this.adjacentChestXPos != null)
			{
				this.adjacentChestXPos.func_145978_a(this, 1);
			}
			if (this.adjacentChestXNeg != null)
			{
				this.adjacentChestXNeg.func_145978_a(this, 3);
			}
		}
	}
	private boolean func_145977_a(int coordX, int coordY, int coordZ)
	{
		Block block = this.worldObj.getBlock(coordX, coordY, coordZ);
		return block instanceof BlockNetherwoodChest;
	}
	public int func_145980_j()
	{
		if (this.cachedChestType == -1)
		{
			if (this.worldObj == null || !(this.getBlockType() instanceof BlockNetherwoodChest))
			{
				return 0;
			}
			this.cachedChestType = 0;
		}
		return this.cachedChestType;
	}
}