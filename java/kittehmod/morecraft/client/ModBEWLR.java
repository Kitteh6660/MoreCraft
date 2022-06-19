package kittehmod.morecraft.client;

import com.mojang.blaze3d.vertex.PoseStack;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.blockentity.ModChestBlockEntity;
import kittehmod.morecraft.blockentity.ModTrappedChestBlockEntity;
import kittehmod.morecraft.blockentity.WardenSkullBlockEntity;
import kittehmod.morecraft.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModBEWLR extends BlockEntityWithoutLevelRenderer
{
	public static ModBEWLR INSTANCE = new ModBEWLR(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
	
	private final ModChestBlockEntity netherwood_chest = new ModChestBlockEntity(BlockPos.ZERO, ModBlocks.NETHERWOOD_CHEST.get().defaultBlockState());
	private final ModTrappedChestBlockEntity netherwood_trapped_chest = new ModTrappedChestBlockEntity(BlockPos.ZERO, ModBlocks.NETHERWOOD_CHEST_TRAPPED.get().defaultBlockState());
	private final WardenSkullBlockEntity warden_skull = new WardenSkullBlockEntity(BlockPos.ZERO, ModBlocks.WARDEN_HEAD.get().defaultBlockState());
	private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;
	
	public ModBEWLR(BlockEntityRenderDispatcher berd, EntityModelSet ems) {
		super(berd, ems);
		this.blockEntityRenderDispatcher = berd;
	}
	
	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType transform, PoseStack pose, MultiBufferSource mbsource, int p_108834_, int p_108835_) {
		Item item = stack.getItem();
		BlockEntity blockentity;
		if (item instanceof BlockItem) {
			if (item == ModItems.NETHERWOOD_CHEST.get()) {
				blockentity = this.netherwood_chest;
			}
			else if (item == ModItems.NETHERWOOD_TRAPPED_CHEST.get()) {
				blockentity = this.netherwood_trapped_chest;
			}
			else if (item == ModItems.WARDEN_HEAD.get()) {
				blockentity = this.warden_skull;
			}
			else {
				blockentity = this.netherwood_chest;
			}
			this.blockEntityRenderDispatcher.renderItem(blockentity, pose, mbsource, p_108834_, p_108835_);
		}
	}
	
}
