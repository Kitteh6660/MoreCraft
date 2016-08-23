package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMoreDoors extends BlockDoor 
{

	public BlockMoreDoors(Material par2Material) 
	{
		super(par2Material);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return this.getItem();
    }
	
	private Item getItem()
    {
    	return this == MoreCraftBlocks.netherbrick_door ? MoreCraftItems.netherbrick_door_item : 
 		       this == MoreCraftBlocks.netherwood_door ? MoreCraftItems.netherwood_door_item : 
    	       this == MoreCraftBlocks.glass_door ? MoreCraftItems.glass_door_item : 
        	   this == MoreCraftBlocks.bone_door ? MoreCraftItems.bone_door_item : 
    				Items.oak_door;
    }

    @Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
        return this == MoreCraftBlocks.netherbrick_door ? MoreCraftItems.netherbrick_door_item : 
               this == MoreCraftBlocks.netherwood_door ? MoreCraftItems.netherwood_door_item : 
               this == MoreCraftBlocks.glass_door ? MoreCraftItems.glass_door_item : 
               this == MoreCraftBlocks.bone_door ? MoreCraftItems.bone_door_item : 
            	    Items.oak_door;
	}

}