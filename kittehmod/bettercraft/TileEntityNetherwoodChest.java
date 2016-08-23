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
		if (p_145978_1_.func_145837_r())
		{
			this.field_145984_a = false;
		}
		else if (this.field_145984_a)
		{
			switch (p_145978_2_)
			{
			case 0:
				if (this.adjacentChestZPos != p_145978_1_)
				{
					this.field_145984_a = false;
				}
				break;
			case 1:
				if (this.adjacentChestXNeg != p_145978_1_)
				{
					this.field_145984_a = false;
				}
				break;
			case 2:
				if (this.adjacentChestZNeg != p_145978_1_)
				{
					this.field_145984_a = false;
				}
				break;
			case 3:
				if (this.adjacentChestXPos != p_145978_1_)
				{
					this.field_145984_a = false;
				}
			}
		}
	}
    public void func_145979_i()
    {
        if (!this.field_145984_a)
        {
            this.field_145984_a = true;
            this.adjacentChestXNeg = this.func_174911_a(EnumFacing.WEST);
            this.adjacentChestXPos = this.func_174911_a(EnumFacing.EAST);
            this.adjacentChestZNeg = this.func_174911_a(EnumFacing.NORTH);
            this.adjacentChestZPos = this.func_174911_a(EnumFacing.SOUTH);
        }
    }

    protected TileEntityNetherwoodChest func_174911_a(EnumFacing side)
    {
        BlockPos blockpos = this.field_174879_c.func_177972_a(side);

        if (this.isChestAt(blockpos))
        {
            TileEntity tileentity = this.field_145850_b.func_175625_s(blockpos);

            if (tileentity instanceof TileEntityChest)
            {
                TileEntityNetherwoodChest tileentitychest = (TileEntityNetherwoodChest)tileentity;
                tileentitychest.func_174910_a(this, side.func_176734_d());
                return tileentitychest;
            }
        }

        return null;
    }
    
    private boolean isChestAt(BlockPos posIn)
    {
        if (this.field_145850_b == null)
        {
            return false;
        }
        else
        {
            Block block = this.field_145850_b.func_180495_p(posIn).func_177230_c();
            return block instanceof BlockNetherwoodChest && ((BlockNetherwoodChest)block).field_149956_a == this.func_145980_j();
        }
    }
    
    @SuppressWarnings("incomplete-switch")
	private void func_174910_a(TileEntityChest chestTe, EnumFacing side)
    {
        if (chestTe.func_145837_r())
        {
            this.field_145984_a = false;
        }
        else if (this.field_145984_a)
        {
            switch (side)
            {
                case NORTH:

                    if (this.adjacentChestZNeg != chestTe)
                    {
                        this.field_145984_a = false;
                    }

                    break;
                case SOUTH:

                    if (this.adjacentChestZPos != chestTe)
                    {
                        this.field_145984_a = false;
                    }

                    break;
                case EAST:

                    if (this.adjacentChestXPos != chestTe)
                    {
                        this.field_145984_a = false;
                    }

                    break;
                case WEST:

                    if (this.adjacentChestXNeg != chestTe)
                    {
                        this.field_145984_a = false;
                    }
            }
        }
    }
    
}