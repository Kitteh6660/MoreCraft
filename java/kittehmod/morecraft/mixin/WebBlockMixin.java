package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@Mixin(WebBlock.class)
public class WebBlockMixin
{

	//@Inject(at = @At(value = "INVOKE"), method = "entityInside(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V")
	@Overwrite
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		double baseHSpd = 0.25D;
		float baseVSpd = 0.05F;
		if (entity instanceof LivingEntity) {
			LivingEntity le = (LivingEntity)entity;
			baseHSpd += ModArmorItem.countPiecesOfMaterial(le, ModArmorMaterial.SILK) * 0.25;
			baseVSpd += ModArmorItem.countPiecesOfMaterial(le, ModArmorMaterial.SILK) * 0.05;
		}
		entity.makeStuckInBlock(state, new Vec3(baseHSpd, (double)baseVSpd, baseHSpd));
	}
}
