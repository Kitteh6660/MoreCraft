package kittehmod.bettercraft.block;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlowstoneTorch extends BlockTorch {
	
	public BlockGlowstoneTorch() {
		super();
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	public int getLightValue() {
		return 15;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		//Glowstone torch doesn't emit particles.
	}
}
