package kittehmod.morecraft.block;

import kittehmod.morecraft.ContainerNetherWorkbench;
import kittehmod.morecraft.GuiHandler;
import kittehmod.morecraft.MoreCraft;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockNetherwoodCraftingTable extends BlockWorkbench
{
    
	public BlockNetherwoodCraftingTable() 
	{
		super();
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setSoundType(SoundType.WOOD);
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	//FMLNetworkHandler.openGui(playerIn, MoreCraft.instance, GuiWorkbench, worldIn, pos.getX(), pos.getY(), pos.getZ());
        	playerIn.displayGui(new BlockNetherwoodCraftingTable.InterfaceCraftingTable(worldIn, pos));
        	playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
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
        public String getName()
        {
            return "crafting_table";
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(Blocks.CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerNetherWorkbench(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
}
