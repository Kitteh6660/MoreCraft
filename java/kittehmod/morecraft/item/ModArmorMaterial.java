package kittehmod.morecraft.item;

import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
	SLIME("slime", 8, new int[]{2, 2, 3, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
		return Ingredient.fromItems(Items.SLIME_BALL);
	}),
	FLESH("flesh", 4, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
		return Ingredient.fromItems(Items.ROTTEN_FLESH);
	}),
	SILK("spidersilk", 15, new int[]{2, 3, 3, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
		return Ingredient.fromItems(Items.COBWEB);
	}),
	BONE("bone", 15, new int[]{2, 3, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, () -> {
		return Ingredient.fromItems(Items.BONE);
	}),
	WITHERBONE("witherbone", 132, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 3.0F, () -> {
		return Ingredient.fromItems(ModItems.WITHER_BONE.get());
	}),
	BONELORD("bonelord", 20, new int[]{3, 6, 6, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 1.0F, () -> {
		return Ingredient.fromItems(Items.BONE);
	}),
	OBSIDIAN("obsidian", 3, new int[]{3, 6, 8, 3}, 28, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, () -> {
		return Ingredient.fromItems(Items.OBSIDIAN);
	}),
	EMERALD("emerald", 28, new int[]{3, 5, 7, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	}),
	RUBY("ruby", 20, new int[]{3, 5, 6, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, () -> {
		return Ingredient.fromItems(ModItems.RUBY.get());
	}),
	ENDER("ender", 15, new int[]{3, 5, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, () -> {
		return Ingredient.fromItems(Items.ENDER_PEARL);
	}),
	BLAZE("blaze", 10, new int[]{3, 5, 5, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
		return Ingredient.fromItems(Items.BLAZE_ROD);
	}),
	ENDERDRAGON("enderdragon", 128, new int[]{4, 5, 7, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F, () -> {
		return Ingredient.fromItems(ModItems.ENDERDRAGON_SCALES.get());
	}),
	BEDROCK("bedrock", 99999999, new int[]{4, 5, 7, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.0F, () -> {
		return Ingredient.fromItems(Items.BEDROCK);
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyLoadBase<Ingredient> repairMaterial;

	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = p_i48533_8_;
		this.repairMaterial = new LazyLoadBase<>(repairMaterialSupplier);
	}
	
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}
}
