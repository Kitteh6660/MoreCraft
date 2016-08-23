package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
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
    public void checkForAdjacentChests()
    {
        if (!this.adjacentChestChecked)
        {
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
            this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
            this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
            this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
        }
    }

    protected TileEntityNetherwoodChest getAdjacentChest(EnumFacing side)
    {
        BlockPos blockpos = this.pos.offset(side);

        if (this.isChestAt(blockpos))
        {
            TileEntity tileentity = this.worldObj.getTileEntity(blockpos);

            if (tileentity instanceof TileEntityChest)
            {
                TileEntityNetherwoodChest tileentitychest = (TileEntityNetherwoodChest)tileentity;
                tileentitychest.func_174910_a(this, side.getOpposite());
                return tileentitychest;
            }
        }

        return null;
    }
    
    private boolean isChestAt(BlockPos posIn)
    {
        if (this.worldObj == null)
        {
            return false;
        }
        else
        {
            Block block = this.worldObj.getBlockState(posIn).getBlock();
            return block instanceof BlockNetherwoodChest && ((BlockNetherwoodChest)block).chestType == this.getChestType();
        }
    }
    
    @SuppressWarnings("incomplete-switch")
	private void func_174910_a(TileEntityChest chestTe, EnumFacing side)
    {
        if (chestTe.isInvalid())
        {
            this.adjacentChestChecked = false;
        }
        else if (this.adjacentChestChecked)
        {
            switch (side)
            {
                case NORTH:

                    if (this.adjacentChestZNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case SOUTH:

                    if (this.adjacentChestZPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case EAST:

                    if (this.adjacentChestXPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case WEST:

                    if (this.adjacentChestXNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }
            }
        }
    }
    
}