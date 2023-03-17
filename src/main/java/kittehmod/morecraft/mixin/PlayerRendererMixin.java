package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import kittehmod.morecraft.client.renderer.EnderdragonArmorWingsLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

@Mixin(PlayerRenderer.class)
public class PlayerRendererMixin
{
	@Inject(at = @At(value = "TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Z)V")
	private void injectInit(EntityRendererProvider.Context context, boolean slim, CallbackInfo ci) {
		((PlayerRenderer)(Object)this).addLayer(new EnderdragonArmorWingsLayer<>(((PlayerRenderer)(Object)this), context.getModelSet()));
	}
}
