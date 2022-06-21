package kittehmod.morecraft.enchantments;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEnchantments
{
	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoreCraft.MODID);
	
	public static final RegistryObject<Enchantment> MAGIC_PROTECTION = ENCHANTMENTS.register("magic_protection", () -> new MagicProtectionEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	public static final RegistryObject<Enchantment> ENDER_BANE = ENCHANTMENTS.register("ender_bane", () -> new EnderBaneEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
}
