package kittehmod.morecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerNetherWorkbench extends ContainerWorkbench
{
    /** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public InventoryCraftResult craftResult = new InventoryCraftResult();
    private final World world;
    /** Position of the workbench */
    private final BlockPos pos;
    private final EntityPlayer player;
    
    public ContainerNetherWorkbench(InventoryPlayer playerInventory, World worldIn, BlockPos posIn)
    {
    	super(playerInventory, worldIn, posIn);
        this.world = worldIn;
        this.pos = posIn;
        this.player = playerInventory.player;
    }

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        if (this.world.getBlockState(this.pos).getBlock() != MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE)
        {
            return false;
        }
        else
        {
            return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

}