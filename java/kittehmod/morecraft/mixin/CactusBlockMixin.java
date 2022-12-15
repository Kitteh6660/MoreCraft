package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CactusBlock.class)
public class CactusBlockMixin
{
	@Overwrite
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity instanceof ItemEntity && MoreCraftConfig.preventCactusDestroyItems.get()) { 
			return; 
		}
		entity.hurt(DamageSource.CACTUS, 1.0F);
	}
}
