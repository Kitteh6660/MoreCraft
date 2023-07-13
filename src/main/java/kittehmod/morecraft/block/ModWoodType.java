package kittehmod.morecraft.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodType 
{
	public static final WoodType NETHERWOOD = WoodType.register(new WoodType("morecraft:netherwood", ModBlockSetType.NETHERWOOD, SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN));
}
