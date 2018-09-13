package kittehmod.morecraft.block;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBoneLadder extends BlockLadder 
{
	public BlockBoneLadder() {
		super();
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setSoundType(SoundType.STONE);
	}
}
