package kittehmod.bettercraft.block;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.BlockSlab.EnumBlockHalf;
public abstract class BlockNormalSlab extends BlockSlab 
{
    private static final int HALF_META_BIT = 8;
    
    public BlockNormalSlab(Material materialIn)
    {
        super(materialIn);
        IBlockState iblockstate = this.field_176227_L.func_177621_b();
        
        if (!this.func_176552_j())
        {
            iblockstate = iblockstate.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM);
            this.func_149647_a(CreativeTabs.field_78030_b);
        }
    }
    
    /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public final String func_150002_b(final int metadata) {
        return this.func_149739_a();
    }

    /**
     * Gets the value of the variant property based on the item.
     * @param itemStack item stack.
     * @return the variant value null.
     */
    @Override
    public final Object func_176553_a(final ItemStack stack) {
    	return BlockPlanks.EnumType.func_176837_a(stack.func_77960_j() & 7);
    }

    /**
     * Gets the variant property.
     * @return the variant property null.
     */
    @Override
    public final IProperty func_176551_l() {
        return null;
    }

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public final IBlockState func_176203_a(final int meta) {
        IBlockState blockState = this.func_176223_P();
        if (!this.func_176552_j()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.func_177226_a(field_176554_a, value);
        }

        return blockState;
    }


    
    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int func_176201_c(IBlockState state)
    {
        int i = 0;

        if (!this.func_176552_j() && state.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public final int func_180651_a(final IBlockState state) {
        return 0;
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param blockState the block's state.
     * @param random the random number generator
     * @param unused an integer.
     * @return the half slab item.
     */
    @Override
    public final Item func_180660_a(
        final IBlockState blockState,
        final java.util.Random random,
        final int unused) {
        return Item.func_150898_a(this);
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param world the world
     * @param blockPos the block position.
     * @return the item dropped, the half slab.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final net.minecraft.item.Item func_180665_b(final net.minecraft.world.World world, final net.minecraft.util.BlockPos blockPos) {
        return Item.func_150898_a(this);
    }

    /**
     * Creates the block state object.
     * @return the block state with properties defined.
     */
    @Override
    protected final BlockState func_180661_e() {
        if (this.func_176552_j()) {
            return new BlockState(this, new IProperty[] {});
        } else {
            return new BlockState(this, new IProperty[] {field_176554_a});
        }
    }

	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != MoreCraftBlocks.enderbrick_slab && this != MoreCraftBlocks.enderbrick_slab_full;
	    }
	    return true;
	}
}
