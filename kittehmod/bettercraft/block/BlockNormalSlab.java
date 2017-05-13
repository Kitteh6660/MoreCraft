package kittehmod.bettercraft.block;

import java.util.Random;

import javax.annotation.Nullable;

import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockNormalSlab extends BlockSlab 
{
    public static final PropertyEnum<BlockSlab.EnumBlockHalf> HALF = PropertyEnum.<BlockSlab.EnumBlockHalf>create("half", BlockSlab.EnumBlockHalf.class);
    public static final PropertyEnum<BlockNormalSlab.Variant> VARIANT = PropertyEnum.<BlockNormalSlab.Variant>create("variant", BlockNormalSlab.Variant.class);

    public BlockNormalSlab(Material material)
    {
        super(material);
        IBlockState iblockstate = this.blockState.getBaseState();

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, BlockNormalSlab.Variant.DEFAULT));
        if (!this.isDouble()) this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if (this == MoreCraftBlocks.ENDSTONE_BRICK_SLAB || this == MoreCraftBlocks.ENDSTONE_BRICK_SLAB_FULL) {
    		return Item.getItemFromBlock(MoreCraftBlocks.ENDSTONE_BRICK_SLAB);
    	}
    	else if (this == MoreCraftBlocks.NETHERWOOD_SLAB || this == MoreCraftBlocks.NETHERWOOD_SLAB_FULL) {
    		return Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_SLAB);
    	}
        return Item.getItemFromBlock(Blocks.PURPUR_SLAB);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
    	if (this == MoreCraftBlocks.ENDSTONE_BRICK_SLAB || this == MoreCraftBlocks.ENDSTONE_BRICK_SLAB_FULL) {
    		return new ItemStack(MoreCraftBlocks.ENDSTONE_BRICK_SLAB);
    	}
    	else if (this == MoreCraftBlocks.NETHERWOOD_SLAB || this == MoreCraftBlocks.NETHERWOOD_SLAB_FULL) {
    		return new ItemStack(MoreCraftBlocks.NETHERWOOD_SLAB);
    	}
        return new ItemStack(Blocks.PURPUR_SLAB);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockNormalSlab.Variant.DEFAULT);

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}): new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
    }

    /**
     * Returns the slab block name with the type associated with it
     */
    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName();
    }

    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return BlockNormalSlab.Variant.DEFAULT;
    }

    public static class Double extends BlockNormalSlab
        {
            public Double(Material material) {
				super(material);
				this.getDefaultState();
			}

			public boolean isDouble()
            {
                return true;
            }
        }

    public static class Half extends BlockNormalSlab
        {
            public Half(Material material) {
				super(material);
				this.getDefaultState();
			}

			public boolean isDouble()
            {
                return false;
            }
        }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;

        public String getName()
        {
            return "default";
        }
    }
    
    /**
     * Sets the footstep sound for the block. Returns the object for convenience in constructing.
     */
	@Override
    public Block setSoundType(SoundType sound)
    {
        super.setSoundType(sound);
        return this;
    }
    
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != MoreCraftBlocks.ENDSTONE_BRICK_SLAB && this != MoreCraftBlocks.ENDSTONE_BRICK_SLAB_FULL;
	    }
	    return true;
	}
	
}
