package kittehmod.bettercraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemNewDoor extends ItemDoor {

    private Block block;

    public ItemNewDoor(Block block)
    {
    	super(block);
        this.block = block;
        this.func_77637_a(CreativeTabs.field_78028_d);
    }
	
    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side != EnumFacing.UP)
        {
            return false;
        }
        else
        {
            IBlockState iblockstate = worldIn.func_180495_p(pos);
            Block block = iblockstate.func_177230_c();

            if (!block.func_176200_f(worldIn, pos))
            {
                pos = pos.func_177972_a(side);
            }

            if (!playerIn.func_175151_a(pos, side, stack))
            {
                return false;
            }
            else if (!this.block.func_176196_c(worldIn, pos))
            {
                return false;
            }
            else
            {
                func_179235_a(worldIn, pos, EnumFacing.func_176733_a((double)playerIn.field_70177_z), this.block);
                --stack.field_77994_a;
                return true;
            }
        }
    }
    
}
