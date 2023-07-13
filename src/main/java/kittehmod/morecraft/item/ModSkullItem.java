package kittehmod.morecraft.item;

import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;

public class ModSkullItem extends StandingAndWallBlockItem {

	public ModSkullItem(Block floorBlockIn, Block wallBlockIn, Properties builder) {
		super(floorBlockIn, wallBlockIn, builder, Direction.DOWN);
	}

}
