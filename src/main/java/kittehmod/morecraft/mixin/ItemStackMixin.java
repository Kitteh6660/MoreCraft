package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import kittehmod.morecraft.enchantments.ModEnchantments;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemStack.class)
public class ItemStackMixin
{

	@Inject(at = @At(value = "RETURN"), method = "getBarWidth()I", cancellable = true)
	private void injectBarWidth(CallbackInfoReturnable<Integer> ci) {
		if (((ItemStack)(Object)this).getEnchantmentLevel(ModEnchantments.REINFORCEMENT.get()) > 0) {
			ci.setReturnValue(Math.round(13.0F - (float)((ItemStack)(Object)this).getDamageValue() * 13.0F / (float)((ItemStack)(Object)this).getMaxDamage()));
		}
	}
	
	@Inject(at = @At(value = "RETURN"), method = "getBarColor()I", cancellable = true)
	private void injectBarColor(CallbackInfoReturnable<Integer> ci) {
		if (((ItemStack)(Object)this).getEnchantmentLevel(ModEnchantments.REINFORCEMENT.get()) > 0) {
			float stackMaxDamage = ((ItemStack)(Object)this).getMaxDamage();
			float f = Math.max(0.0F, (stackMaxDamage - (float)((ItemStack)(Object)this).getDamageValue()) / stackMaxDamage);
			ci.setReturnValue(Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F));
		}
	}
	
	@Inject(at = @At(value = "RETURN"), method = "getMaxDamage()I", cancellable = true)
	private void injectMaxDamage(CallbackInfoReturnable<Integer> ci) {
		ItemStack stack = ((ItemStack)(Object)this);
		int baseDurability = (stack).getItem().getMaxDamage(stack);
		int bonusDurability = (int)Math.ceil(stack.getEnchantmentLevel(ModEnchantments.REINFORCEMENT.get()) * Math.max(5, baseDurability * 0.1));
		bonusDurability = Mth.clamp(bonusDurability, 0, 32767);
		ci.setReturnValue(baseDurability + bonusDurability);
	}
}
