package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import kittehmod.morecraft.MoreCraftConfig;
import kittehmod.morecraft.item.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CactusBlock.class)
public class CactusBlockMixin
{
	@Inject(at = @At(value = "HEAD"), method = "entityInside(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)V", cancellable = true)
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
		if (entity instanceof ItemEntity) {
			if (MoreCraftConfig.preventCactusDestroyItems.get()) {
				ci.cancel();
			}
			ModItemTags.CACTUS_IMMUNE.toString();
			ItemEntity itemEntity = (ItemEntity)entity;
			if (itemEntity.getItem().is(ModItemTags.CACTUS_IMMUNE)) {
				ci.cancel();
			}
		}
	}
}
