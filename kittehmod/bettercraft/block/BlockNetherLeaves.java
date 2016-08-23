package kittehmod.bettercraft.block;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.base.Predicate;

import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNetherLeaves extends BlockLeaves
{	
    public BlockNetherLeaves()
    {
    	this.field_150121_P = true;
    	this.field_176238_O = true;
    	this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176236_b, Boolean.valueOf(true)).func_177226_a(field_176237_a, Boolean.valueOf(true)));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int func_149635_D()
    {
    	return 0xFFFFFF;
        //return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int func_180644_h(IBlockState state)
    {
    	return super.func_180644_h(state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int func_180662_a(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
    	return 0xFFFFFF;
        //return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	super.func_180655_c(worldIn, pos, state, rand);
    	//this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
    }
    
	@Override
    public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.func_180653_a(worldIn, pos, state, chance, fortune);
    }

    protected void func_176234_a(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
        if (worldIn.field_73012_v.nextInt(30) == 0)
        {
            func_180635_a(worldIn, pos, new ItemStack(Items.field_151034_e, 1, 0));
        }
    }
    
    @Override
	public Item func_180660_a(IBlockState state, Random rand, int fortune)
	{
        return Item.func_150898_a(MoreCraftBlocks.netherwood_sapling);
	}
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().func_177226_a(field_176237_a, Boolean.valueOf((meta & 4) == 0)).func_177226_a(field_176236_b, Boolean.valueOf((meta & 8) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        int i = 0;

        if (!((Boolean)state.func_177229_b(field_176237_a)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.func_177229_b(field_176236_b)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    public BlockPlanks.EnumType func_176233_b(int meta)
    {
        return BlockPlanks.EnumType.func_176837_a((meta & 3) + 4);
    }

    protected BlockState func_180661_e()
    {
        return new BlockState(this, new IProperty[] {field_176236_b, field_176237_a});
    }

    public void func_180657_a(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
    {
        {
            super.func_180657_a(worldIn, player, pos, state, te);
        }
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.func_180495_p(pos);
        return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 1, 0)));
    }
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean func_149662_c()
    {
        return !this.field_150121_P;
    }

    /**
     * Pass true to draw this block using fancy graphics, or false for fast graphics.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void func_150122_b(boolean fancy)
    {
    	this.field_176238_O = true;
    	this.field_150121_P = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer func_180664_k()
    {
        return this.field_176238_O ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID;
    }

    @Override
    public boolean func_176214_u()
    {
        return false;
    }

}