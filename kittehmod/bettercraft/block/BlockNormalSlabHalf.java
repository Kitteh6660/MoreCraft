package kittehmod.bettercraft.block;

import net.minecraft.block.material.Material;

public class BlockNormalSlabHalf extends BlockNormalSlab {
	
	public BlockNormalSlabHalf(Material material) {
		super (material);
	}
	
    @Override
    public boolean isDouble() {
        return false;
    }
}
