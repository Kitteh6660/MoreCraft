package kittehmod.morecraft.block;

import java.util.Random;

import javax.annotation.Nullable;

import kittehmod.morecraft.MoreCraftBlocks;
import kittehmod.morecraft.MoreCraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
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
	}

	@Override
    public Block setSoundType(SoundType sound)
    {
        super.setSoundType(sound);
        return this;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }
	
	private Item getItem()
    {
    	return this == MoreCraftBlocks.NETHERBRICK_DOOR ? MoreCraftItems.NETHERBRICK_DOOR : 
 		       this == MoreCraftBlocks.NETHERWOOD_DOOR ? MoreCraftItems.NETHERWOOD_DOOR : 
    	       this == MoreCraftBlocks.GLASS_DOOR ? MoreCraftItems.GLASS_DOOR : 
        	   this == MoreCraftBlocks.BONE_DOOR ? MoreCraftItems.BONE_DOOR : 
    				Items.OAK_DOOR;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
    }

}