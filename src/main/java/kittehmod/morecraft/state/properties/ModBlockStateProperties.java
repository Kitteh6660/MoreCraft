package kittehmod.morecraft.state.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockStateProperties
{
	public static final BooleanProperty JUMPSCARE_READY = BooleanProperty.create("jumpscare_ready");
	public static final EnumProperty<TripleBlockThird> TRIPLE_BLOCK_THIRD = EnumProperty.create("third", TripleBlockThird.class);
	public static final EnumProperty<BanisterShape> BANISTER_SHAPE = EnumProperty.create("banister_shape", BanisterShape.class);
}
