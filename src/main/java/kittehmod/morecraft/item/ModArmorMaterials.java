package kittehmod.morecraft.item;

import java.util.EnumMap;
import java.util.function.Supplier;

import kittehmod.morecraft.init.ModItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum ModArmorMaterials implements StringRepresentable, ArmorMaterial {
	COPPER("copper", 10, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 17, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.of(Items.COPPER_INGOT); }),
	RUBY("ruby", 20, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 23, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> { return Ingredient.of(ModItems.RUBY.get()); }),
	EMERALD("emerald", 28, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> { return Ingredient.of(Items.EMERALD); }),
	OBSIDIAN("obsidian", 3, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 27, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F, () -> { return Ingredient.of(Items.OBSIDIAN); }),
	WOOL("wool", 8, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(ItemTags.WOOL); }),
	FLESH("flesh", 4, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.ROTTEN_FLESH); }),
	SILK("spidersilk", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.ROTTEN_FLESH); }),
	SLIME("slime", 8, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> { return Ingredient.of(Items.SLIME_BALL); }),
	ENDER("ender", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> { return Ingredient.of(Items.ENDER_PEARL); }),
	BLAZE("blaze", 10, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 11, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> { return Ingredient.of(Items.BLAZE_ROD); }),
	BONE("bone", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 2);
	}), 15, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> { return Ingredient.of(Items.BONE); }),
	BONELORD("bonelord", 20, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 18, SoundEvents.ARMOR_EQUIP_TURTLE, 1.0F, 0.0F, () -> { return Ingredient.of(Items.BONE); }),
	WITHERBONE("witherbone", 35, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 20, SoundEvents.ARMOR_EQUIP_TURTLE, 3.0F, 0.1F, () -> { return Ingredient.of(ModItems.WITHER_BONE.get()); }),
	ENDERDRAGON("enderdragon", 128, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 30, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.2F, () -> { return Ingredient.of(ModItems.ENDERDRAGON_SCALES.get()); }),
	WINGED_ENDERDRAGON("winged_enderdragon", 128, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 4);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 30, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.2F, () -> { return Ingredient.of(ModItems.ENDERDRAGON_SCALES.get()); }),
	BEDROCK("bedrock", 99999999, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 4);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 4);
	}), 30, SoundEvents.ARMOR_EQUIP_IRON, 5.0F, 0.2F, () -> { return Ingredient.of(Items.BEDROCK); });
	
	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
		p_266653_.put(ArmorItem.Type.BOOTS, 13);
		p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
		p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
		p_266653_.put(ArmorItem.Type.HELMET, 11);
	});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private ModArmorMaterials(String p_268171_, int p_268303_, EnumMap<ArmorItem.Type, Integer> p_267941_, int p_268086_, SoundEvent p_268145_, float p_268058_, float p_268180_, Supplier<Ingredient> p_268256_) {
		this.name = p_268171_;
		this.durabilityMultiplier = p_268303_;
		this.protectionFunctionForType = p_267941_;
		this.enchantmentValue = p_268086_;
		this.sound = p_268145_;
		this.toughness = p_268058_;
		this.knockbackResistance = p_268180_;
		this.repairIngredient = new LazyLoadedValue<>(p_268256_);
	}
	
	public int getDurabilityForType(ArmorItem.Type p_266745_) {
		return HEALTH_FUNCTION_FOR_TYPE.get(p_266745_) * this.durabilityMultiplier;
	}

	public int getDefenseForType(ArmorItem.Type p_266752_) {
		return this.protectionFunctionForType.get(p_266752_);
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	public String getSerializedName() {
		return this.name;
	}
}
