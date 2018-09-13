package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMorePanes extends BlockPane {

	public BlockMorePanes(Material materialIn, boolean canDrop) {
		super(materialIn, canDrop);
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
}
