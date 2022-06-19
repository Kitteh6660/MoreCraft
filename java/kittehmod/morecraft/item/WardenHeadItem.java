package kittehmod.morecraft.item;

import java.util.function.Consumer;

import kittehmod.morecraft.client.ModBEWLR;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;

public class WardenHeadItem extends StandingAndWallBlockItem
{
	public WardenHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
		super(floorBlock, wallBlock, properties);
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IItemRenderProperties() {
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
				return ModBEWLR.INSTANCE;
			}
		});
	}
}
