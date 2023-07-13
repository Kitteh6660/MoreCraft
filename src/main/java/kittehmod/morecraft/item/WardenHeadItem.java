package kittehmod.morecraft.item;

import java.util.function.Consumer;

import kittehmod.morecraft.client.ModBEWLR;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class WardenHeadItem extends StandingAndWallBlockItem implements Equipable
{
	public WardenHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
		super(floorBlock, wallBlock, properties, Direction.DOWN);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return ModBEWLR.INSTANCE;
			}
		});
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}
}
