package kittehmod.morecraft.item;

import java.util.function.Supplier;

import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public class ModItemTier implements IItemTier {

    private int harvestLevel;
    private int maxUses;
    private float efficiency;
    private float attackDamage;
    private int enchantability;
    private LazyLoadBase<Ingredient> repairMaterial;
	
    public static ModItemTier BONE = new ModItemTier(1, 100, 4.0F, 1, 15, () -> { return Ingredient.fromItems(Items.BONE); }); //EnumHelper.addToolMaterial("BoneT", 1, 100, 4.0F, 1, 15);
    public static ModItemTier WITHERBONE = new ModItemTier(3, 6248, 12.0F, 4, 22, () -> { return Ingredient.fromItems(ModItems.WITHER_BONE.get()); });
    public static ModItemTier OBSIDIAN = new ModItemTier(3, 16, 14.0F, 4, 15, () -> { return Ingredient.fromItems(Blocks.OBSIDIAN); });
    public static ModItemTier EMERALD = new ModItemTier(3, 768, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(Items.EMERALD); });
    public static ModItemTier RUBY = new ModItemTier(2, 500, 6.0F, 2, 21, () -> { return Ingredient.fromItems(ModItems.RUBY.get()); });
    public static ModItemTier ENDER = new ModItemTier(2, 250, 6.0F, 3, 15, () -> { return Ingredient.fromItems(Items.ENDER_PEARL); });
    public static ModItemTier BLAZE = new ModItemTier(2, 100, 7.0F, 2, 15, () -> { return Ingredient.fromItems(Items.BLAZE_ROD); });
    public static ModItemTier NETHERRACK = new ModItemTier(1, 59, 3.5F, 1, 8, () -> { return Ingredient.fromItems(Blocks.NETHERRACK); });
    public static ModItemTier ENDSTONE = new ModItemTier(1, 188, 4.0F, 1, 5, () -> { return Ingredient.fromItems(Blocks.END_STONE); });
    public static ModItemTier BEDROCK = new ModItemTier(3, -1, 20.0F, 5, 30, () -> { return Ingredient.fromItems(Blocks.BEDROCK); });
    
	public ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
	      this.harvestLevel = harvestLevelIn;
	      this.maxUses = maxUsesIn;
	      this.efficiency = efficiencyIn;
	      this.attackDamage = attackDamageIn;
	      this.enchantability = enchantabilityIn;
	      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
	}
	
    @Override
    public int getMaxUses() { return this.maxUses; }

    @Override
    public float getEfficiency() { return this.efficiency; }

    @Override
    public float getAttackDamage() { return this.attackDamage; }

    @Override
    public int getHarvestLevel() { return this.harvestLevel; }

    @Override
    public int getEnchantability() { return this.enchantability; }

    @Override
    public Ingredient getRepairMaterial() { return this.repairMaterial.getValue(); }
	
}
