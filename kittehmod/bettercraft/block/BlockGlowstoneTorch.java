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
		this.func_149647_a(CreativeTabs.field_78031_c);
	}
	
	@Override
	public int func_149750_m() {
		return 15;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		//Glowstone torch doesn't emit particles.
	}
}
