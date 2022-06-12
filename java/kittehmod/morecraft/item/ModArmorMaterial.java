package kittehmod.morecraft.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements ArmorMaterial {
	COPPER("copper", 10, new int[]{2, 4, 5, 2}, 17, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.COPPER_INGOT)),
	WOOL("wool", 8, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, Ingredient.of(ItemTags.WOOL)),
	SLIME("slime", 8, new int[]{2, 2, 3, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, Ingredient.of(Items.SLIME_BALL)),
	FLESH("flesh", 4, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, Ingredient.of(Items.ROTTEN_FLESH)),
	SILK("spidersilk", 15, new int[]{2, 3, 3, 2}, 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, Ingredient.of(Items.COBWEB)),
	BONE("bone", 15, new int[]{2, 3, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, Ingredient.of(Items.BONE)),
	WITHERBONE("witherbone", 35, new int[]{3, 6, 8, 3}, 20, SoundEvents.ARMOR_EQUIP_TURTLE, 3.0F, 0.1F, Ingredient.of(ModItems.WITHER_BONE.get())),
	BONELORD("bonelord", 20, new int[]{3, 6, 6, 3}, 18, SoundEvents.ARMOR_EQUIP_TURTLE, 1.0F, 0.0F, Ingredient.of(Items.BONE)),
	OBSIDIAN("obsidian", 3, new int[]{3, 6, 8, 3}, 27, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F, Ingredient.of(Items.OBSIDIAN)),
	EMERALD("emerald", 28, new int[]{3, 5, 7, 3}, 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, Ingredient.of(Items.EMERALD)),
	RUBY("ruby", 20, new int[]{3, 5, 6, 3}, 23, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, Ingredient.of(ModItems.RUBY.get())),
	ENDER("ender", 15, new int[]{3, 5, 6, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, Ingredient.of(Items.ENDER_PEARL)),
	BLAZE("blaze", 10, new int[]{3, 5, 5, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Ingredient.of(Items.BLAZE_ROD)),
	ENDERDRAGON("enderdragon", 128, new int[]{3, 5, 7, 3}, 30, SoundEvents.ARMOR_EQUIP_LEATHER, 3.0F, 0.1F, Ingredient.of(ModItems.ENDERDRAGON_SCALES.get())),
	BEDROCK("bedrock", 99999999, new int[]{4, 6, 8, 4}, 30, SoundEvents.ARMOR_EQUIP_IRON, 5.0F, 0.2F, Ingredient.of(Items.BEDROCK));
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockbackResist;
	private final Ingredient repairMaterial;

	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, float knockbackResistIn, Ingredient repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = toughnessIn;
		this.knockbackResist = knockbackResistIn;
		this.repairMaterial = repairMaterialSupplier;
	}
	
	public int getDurabilityForSlot(EquipmentSlot slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDefenseForSlot(EquipmentSlot slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	public Ingredient getRepairIngredient() {
		return this.repairMaterial;
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResist;
	}

}
