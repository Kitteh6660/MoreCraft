package kittehmod.morecraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
/*import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import kittehmod.morecraft.enchantments.ModEnchantments;
import net.minecraft.util.Mth;*/
import net.minecraft.world.item.ItemStack;

//Not used at the moment.
@Mixin(ItemStack.class)
public class ItemStackMixin
{

	/*@Inject(at = @At(value = "RETURN"), method = "getMaxDamage()I", cancellable = true)
	private void injectMaxDamage(CallbackInfoReturnable<Integer> ci) {
		ItemStack stack = ((ItemStack)(Object)this);
		int baseDurability = (stack).getItem().getMaxDamage(stack);
		int bonusDurability = (int)Math.ceil(stack.getEnchantmentLevel(ModEnchantments.REINFORCEMENT.get()) * Math.max(5, baseDurability * 0.1));
		bonusDurability = Mth.clamp(bonusDurability, 0, 32767);
		ci.setReturnValue(baseDurability + bonusDurability);
	}*/
}
