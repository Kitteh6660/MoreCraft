package kittehmod.bettercraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

public class BlockGlowstoneTorch extends BlockTorch {
	
	public BlockGlowstoneTorch() {
		super();
	}
	
	@Override
	public int getLightValue() {
		return 15;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		//Particles are disabled.
	}
}
