package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import kittehmod.morecraft.client.renderer.EnderdragonArmorWingsLayer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

@Mixin(ArmorStandRenderer.class)
public class ArmorStandRendererMixin
{
	@Inject(at = @At(value = "TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void injectInit(EntityRendererProvider.Context context, CallbackInfo ci) {
		((ArmorStandRenderer)(Object)this).addLayer(new EnderdragonArmorWingsLayer<>(((ArmorStandRenderer)(Object)this), context.getModelSet()));
	}
}
