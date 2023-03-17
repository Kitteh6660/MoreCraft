package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import kittehmod.morecraft.client.renderer.EnderdragonArmorWingsLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

@Mixin(HumanoidMobRenderer.class)
public class HumanoidMobRendererMixin
{
	@Inject(at = @At(value = "TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lnet/minecraft/client/model/HumanoidModel;FFFF)V")
	private void injectInit(EntityRendererProvider.Context context, HumanoidModel<?> model, float f1, float f2, float f3, float f4, CallbackInfo ci) {
		((HumanoidMobRenderer<?, ?>)(Object)this).addLayer(new EnderdragonArmorWingsLayer<>(((HumanoidMobRenderer)(Object)this), context.getModelSet()));
	}
}
