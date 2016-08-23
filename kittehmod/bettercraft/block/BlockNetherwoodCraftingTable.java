package kittehmod.bettercraft.block;

import kittehmod.bettercraft.GuiHandler;
import kittehmod.bettercraft.MoreCraft;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockNetherwoodCraftingTable extends BlockWorkbench
{
    
	public BlockNetherwoodCraftingTable() 
	{
		super();
		this.func_149647_a(CreativeTabs.field_78031_c);
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.field_72995_K)
        {
            return true;
        }
        else
        {
            //playerIn.displayGui(new WorkbenchGui(worldIn, pos));
        	//playerIn.displayGui(new BlockNetherwoodCraftingTable.InterfaceCraftingTable(worldIn, pos));
        	FMLNetworkHandler.openGui(playerIn, MoreCraft.instance, GuiHandler.CRAFTING_GUI, worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
            playerIn.func_71029_a(StatList.field_181742_Z);
            return true;
        }
    }
    
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
    }
    
    public static class InterfaceCraftingTable implements IInteractionObject
    {
    	
        private final World world;
        private final BlockPos position;

        public InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String func_70005_c_()
        {
            return null;
        }

        /**
         * Returns true if this thing is named
         */
        public boolean func_145818_k_()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public IChatComponent func_145748_c_()
        {
            return new ChatComponentTranslation(Blocks.field_150462_ai.func_149739_a() + ".name", new Object[0]);
        }

        public Container func_174876_a(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerWorkbench(playerInventory, this.world, this.position);
        }

        public String func_174875_k()
        {
            return "minecraft:crafting_table";
        }
    }
}
