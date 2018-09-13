package kittehmod.morecraft;

import kittehmod.morecraft.block.BlockNetherwoodChest;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileEntityNetherwoodChest extends TileEntityChest
{
	private String customName;
	private BlockNetherwoodChest.Type cachedChestType;
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
	
    @SuppressWarnings("incomplete-switch")
    private void setNeighbor(TileEntityNetherwoodChest chestTe, EnumFacing side)
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
    
    /**
     * Performs the check for adjacent chests to determine if this chest is double or not.
     */
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
            TileEntity tileentity = this.world.getTileEntity(blockpos);

            if (tileentity instanceof TileEntityNetherwoodChest)
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
        if (this.world == null)
        {
            return false;
        }
        else
        {
            Block block = this.world.getBlockState(posIn).getBlock();
            return block instanceof BlockNetherwoodChest && ((BlockNetherwoodChest)block).chestType == this.getNetherChestType();
        }
    }
    
    @SuppressWarnings("incomplete-switch")
	private void func_174910_a(TileEntityNetherwoodChest chestTe, EnumFacing side)
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
    
    public BlockNetherwoodChest.Type getNetherChestType()
    {
        if (this.cachedChestType == null)
        {
            if (this.world == null || !(this.getBlockType() instanceof BlockNetherwoodChest))
            {
                return BlockNetherwoodChest.Type.BASIC;
            }

            this.cachedChestType = ((BlockNetherwoodChest)this.getBlockType()).chestType;
        }

        return this.cachedChestType;
    }
    
}