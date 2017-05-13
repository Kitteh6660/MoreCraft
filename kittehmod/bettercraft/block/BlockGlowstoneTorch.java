package kittehmod.bettercraft.block;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlowstoneTorch extends BlockTorch {
	
	public BlockGlowstoneTorch() {
		super();
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		//Glowstone torch doesn't emit particles.
	}
}
