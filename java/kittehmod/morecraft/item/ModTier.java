package kittehmod.morecraft.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTier implements Tier {

    private int harvestLevel;
    private int maxUses;
    private float efficiency;
    private float attackDamage;
    private int enchantability;
    private Ingredient repairMaterial;
	
    public static ModTier BONE = new ModTier(1, 100, 4.0F, 1.0F, 15, Ingredient.of(Items.BONE));
    public static ModTier COPPER = new ModTier(1, 188, 5.0F, 2.0F, 17, Ingredient.of(Items.COPPER_INGOT));
    public static ModTier WITHERBONE = new ModTier(4, 1855, 10.0F, 4, 18, Ingredient.of(ModItems.WITHER_BONE.get()));
    public static ModTier OBSIDIAN = new ModTier(3, 16, 12.0F, 4.0F, 24, Ingredient.of(Items.OBSIDIAN));
    public static ModTier EMERALD = new ModTier(3, 384, 8.0F, 3.0F, 14, Ingredient.of(Items.EMERALD));
    public static ModTier RUBY = new ModTier(2, 500, 6.0F, 2.0F, 20, Ingredient.of(ModItems.RUBY.get()));
    public static ModTier ENDER = new ModTier(2, 250, 6.0F, 3.0F, 15, Ingredient.of(Items.ENDER_PEARL));
    public static ModTier BLAZE = new ModTier(2, 100, 7.0F, 2.0F, 15, Ingredient.of(Items.BLAZE_ROD));
    public static ModTier NETHERRACK = new ModTier(1, 59, 3.5F, 1, 8, Ingredient.of(Items.NETHERRACK));
    public static ModTier ENDSTONE = new ModTier(1, 188, 4.0F, 1, 5, Ingredient.of(Items.END_STONE));
    public static ModTier BEDROCK = new ModTier(4, -1, 20.0F, 5.0F, 30, Ingredient.of(Items.BEDROCK));
    
	public ModTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Ingredient repairMaterialIn) {
	      this.harvestLevel = harvestLevelIn;
	      this.maxUses = maxUsesIn;
	      this.efficiency = efficiencyIn;
	      this.attackDamage = attackDamageIn;
	      this.enchantability = enchantabilityIn;
	      this.repairMaterial = repairMaterialIn;
	}
	
    @Override
    public int getUses() { return this.maxUses; }

    @Override
    public float getSpeed() { return this.efficiency; }

    @Override
    public float getAttackDamageBonus() { return this.attackDamage; }

    @Override
    public int getLevel() { return this.harvestLevel; }

    @Override
    public int getEnchantmentValue() { return this.enchantability; }

    @Override
    public Ingredient getRepairIngredient() { return this.repairMaterial; }
	
}
