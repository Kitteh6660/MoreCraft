package kittehmod.morecraft.item;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.client.ModItemStackTileEntityRenderer;
import kittehmod.morecraft.entity.NetherBoatEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.TallBlockItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreCraft.MODID);
	
	// -- BLOCKS -- \\
	public static final RegistryObject<Item> NETHERWOOD_LOG = ITEMS.register("netherwood_log", () -> new BlockItem(ModBlocks.NETHERWOOD_LOG.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_LOG = ITEMS.register("stripped_netherwood_log", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_LOG.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_WOOD = ITEMS.register("netherwood_wood", () -> new BlockItem(ModBlocks.NETHERWOOD_WOOD.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_WOOD = ITEMS.register("stripped_netherwood_wood", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_WOOD.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_LEAVES = ITEMS.register("netherwood_leaves", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAVES.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_SAPLING = ITEMS.register("netherwood_sapling", () -> new BlockItem(ModBlocks.NETHERWOOD_SAPLING.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_PLANKS = ITEMS.register("netherwood_planks", () -> new BlockItem(ModBlocks.NETHERWOOD_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_STAIRS = ITEMS.register("netherwood_stairs", () -> new BlockItem(ModBlocks.NETHERWOOD_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_SLAB = ITEMS.register("netherwood_slab", () -> new BlockItem(ModBlocks.NETHERWOOD_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_SIGN = ITEMS.register("netherwood_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ItemGroup.DECORATIONS), ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> NETHERWOOD_FENCE = ITEMS.register("netherwood_fence", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_CRAFTING_TABLE = ITEMS.register("netherwood_crafting_table", () -> new BlockItem(ModBlocks.NETHERWOOD_CRAFTING_TABLE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_CHEST = ITEMS.register("netherwood_chest", () -> new BlockItem(ModBlocks.NETHERWOOD_CHEST.get(), new Item.Properties().group(ItemGroup.DECORATIONS).setISTER(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> NETHERWOOD_TRAPPED_CHEST = ITEMS.register("netherwood_trapped_chest", () -> new BlockItem(ModBlocks.NETHERWOOD_CHEST_TRAPPED.get(), new Item.Properties().group(ItemGroup.REDSTONE).setISTER(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> NETHERWOOD_BUTTON = ITEMS.register("netherwood_button", () -> new BlockItem(ModBlocks.NETHERWOOD_BUTTON.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_PRESSURE_PLATE = ITEMS.register("netherwood_pressure_plate", () -> new BlockItem(ModBlocks.NETHERWOOD_PRESSURE_PLATE.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

	public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> FLESH_BLOCK = ITEMS.register("flesh_block", () -> new BlockItem(ModBlocks.FLESH_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLAZE_BLOCK = ITEMS.register("blaze_block", () -> new BlockItem(ModBlocks.BLAZE_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ENDER_BLOCK = ITEMS.register("ender_block", () -> new BlockItem(ModBlocks.ENDER_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GUNPOWDER_BLOCK = ITEMS.register("gunpowder_block", () -> new BlockItem(ModBlocks.GUNPOWDER_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> SOUL_GLASS = ITEMS.register("soul_glass", () -> new BlockItem(ModBlocks.SOUL_GLASS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SOUL_GLASS_PANE = ITEMS.register("soul_glass_pane", () -> new BlockItem(ModBlocks.SOUL_GLASS_PANE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> FLESH_CARPET = ITEMS.register("flesh_carpet", () -> new BlockItem(ModBlocks.FLESH_CARPET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> BONE_LADDER = ITEMS.register("bone_ladder", () -> new BlockItem(ModBlocks.BONE_LADDER.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> GLOWSTONE_TORCH = ITEMS.register("glowstone_torch", () -> new WallOrFloorItem(ModBlocks.GLOWSTONE_TORCH.get(), ModBlocks.WALL_GLOWSTONE_TORCH.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> BEDROCK_BRICK = ITEMS.register("bedrock_brick", () -> new BlockItem(ModBlocks.BEDROCK_BRICK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	//Not currently available in creative tabs or obtainable due to bugs.
	/*public static final RegistryObject<Item> SPIDER_HEAD = ITEMS.register("spider_head", () -> new ModSkullItem(ModBlocks.SPIDER_HEAD.get(), ModBlocks.WALL_SPIDER_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).setTEISR(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> CAVE_SPIDER_HEAD = ITEMS.register("cave_spider_head", () -> new ModSkullItem(ModBlocks.CAVE_SPIDER_HEAD.get(), ModBlocks.WALL_CAVE_SPIDER_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).setTEISR(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> ZOMBIE_PIGMAN_HEAD  = ITEMS.register("zombie_pigman_head", () -> new ModSkullItem(ModBlocks.ZOMBIE_PIGMAN_HEAD.get(), ModBlocks.WALL_ZOMBIE_PIGMAN_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).setTEISR(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> BLAZE_HEAD = ITEMS.register("blaze_head", () -> new ModSkullItem(ModBlocks.BLAZE_HEAD.get(), ModBlocks.WALL_BLAZE_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).setTEISR(() -> ModItemStackTileEntityRenderer::new)));
	public static final RegistryObject<Item> ENDERMAN_HEAD = ITEMS.register("enderman_head", () -> new ModSkullItem(ModBlocks.ENDERMAN_HEAD.get(), ModBlocks.WALL_ENDERMAN_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).setTEISR(() -> ModItemStackTileEntityRenderer::new)));
	 */
	// -- DOORS -- \\
    public static final RegistryObject<Item> NETHERBRICK_DOOR = ITEMS.register("netherbrick_door", () -> new TallBlockItem(ModBlocks.NETHERBRICK_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));
    public static final RegistryObject<Item> NETHERWOOD_DOOR = ITEMS.register("netherwood_door", () -> new TallBlockItem(ModBlocks.NETHERWOOD_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));
    public static final RegistryObject<Item> NETHERITE_DOOR = ITEMS.register("netherite_door", () -> new TallBlockItem(ModBlocks.NETHERITE_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE).func_234689_a_()));
	public static final RegistryObject<Item> GLASS_DOOR = ITEMS.register("glass_door", () -> new TallBlockItem(ModBlocks.GLASS_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));
    public static final RegistryObject<Item> BONE_DOOR = ITEMS.register("bone_door", () -> new TallBlockItem(ModBlocks.BONE_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));
	
	public static final RegistryObject<Item> NETHERBRICK_FENCE_GATE = ITEMS.register("netherbrick_fence_gate", () -> new BlockItem(ModBlocks.NETHERBRICK_FENCE_GATE.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_FENCE_GATE = ITEMS.register("netherwood_fence_gate", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE_GATE.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

	public static final RegistryObject<Item> NETHERWOOD_TRAPDOOR = ITEMS.register("netherwood_trapdoor", () -> new BlockItem(ModBlocks.NETHERWOOD_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	
	// -- FOOD -- \\
    public static final RegistryObject<Item> COOKED_FLESH = ITEMS.register("cooked_flesh", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COOKED_FLESH)));
    public static final RegistryObject<Item> RAW_SPIDER = ITEMS.register("raw_spider", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SPIDER_RAW)));
    public static final RegistryObject<Item> COOKED_SPIDER = ITEMS.register("cooked_spider", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SPIDER_COOKED)));
    public static final RegistryObject<Item> RAW_SQUID = ITEMS.register("raw_squid", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SQUID_RAW)));
    public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SQUID_COOKED)));
    public static final RegistryObject<Item> RAW_GUARDIAN_MEAT = ITEMS.register("raw_guardian_meat", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GUARDIAN_MEAT_RAW)));
    public static final RegistryObject<Item> COOKED_GUARDIAN_MEAT = ITEMS.register("cooked_guardian_meat", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GUARDIAN_MEAT_COOKED)));

    public static final RegistryObject<Item> COOKED_EGG = ITEMS.register("cooked_egg", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COOKED_EGG)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.APPLE_PIE)));
    public static final RegistryObject<Item> NETHER_APPLE = ITEMS.register("nether_apple", () -> new RandomEffectFoodItem(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.NETHER_APPLE)));
    public static final RegistryObject<Item> NETHER_APPLE_PIE = ITEMS.register("nether_apple_pie", () -> new RandomEffectFoodItem(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.NETHER_APPLE_PIE)));
    public static final RegistryObject<Item> CAKE_SLICE = ITEMS.register("cake_slice", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CAKE_SLICE)));

    // -- MATERIALS -- \\
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> WITHER_BONE_MEAL = ITEMS.register("wither_bone_meal", () -> new WitherBonemealItem(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ENDERDRAGON_SCALES = ITEMS.register("enderdragon_scales", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    
	// -- BOAT ITEMS -- \\
    public static final RegistryObject<Item> NETHERWOOD_BOAT = ITEMS.register("netherwood_boat", () -> new NetherBoatItem(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1).func_234689_a_(), NetherBoatEntity.Type.NETHERWOOD));
    public static final RegistryObject<Item> WARPED_BOAT = ITEMS.register("warped_boat", () -> new NetherBoatItem(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1).func_234689_a_(), NetherBoatEntity.Type.WARPED));
    public static final RegistryObject<Item> CRIMSON_BOAT = ITEMS.register("crimson_boat", () -> new NetherBoatItem(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1).func_234689_a_(), NetherBoatEntity.Type.CRIMSON));
    
	// -- HORSE ARMOUR -- \\
    public static final RegistryObject<Item> BONE_HORSE_ARMOR = ITEMS.register("bone_horse_armor", () -> new ModHorseArmorItem(4, "bone", (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor", () -> new ModHorseArmorItem(10, "emerald", (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor", () -> new ModHorseArmorItem(8, "ruby", (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> OBSIDIAN_HORSE_ARMOR = ITEMS.register("obsidian_horse_armor", () -> new ModHorseArmorItem(9, "obsidian", (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor", () -> new ModHorseArmorItem(12, "netherite", (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)));

	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final RegistryObject<Item> SLIME_HELMET = ITEMS.register("slime_helmet", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SLIME_CHESTPLATE = ITEMS.register("slime_chestplate", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SLIME_LEGGINGS = ITEMS.register("slime_leggings", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SLIME_BOOTS = ITEMS.register("slime_boots", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> FLESH_HELMET = ITEMS.register("flesh_helmet", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FLESH_CHESTPLATE = ITEMS.register("flesh_chestplate", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FLESH_LEGGINGS = ITEMS.register("flesh_leggings", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> FLESH_BOOTS = ITEMS.register("flesh_boots", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
 	
    public static final RegistryObject<Item> SPIDERSILK_HELMET = ITEMS.register("spidersilk_helmet", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_CHESTPLATE = ITEMS.register("spidersilk_chestplate", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_LEGGINGS = ITEMS.register("spidersilk_leggings", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_BOOTS = ITEMS.register("spidersilk_boots", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new ModPickaxeItem(ModItemTier.OBSIDIAN, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new ModAxeItem(ModItemTier.OBSIDIAN, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ModShovelItem(ModItemTier.OBSIDIAN, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new ModHoeItem(ModItemTier.OBSIDIAN, -3, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new ModSwordItem(ModItemTier.OBSIDIAN, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> BONE_HELMET = ITEMS.register("bone_helmet", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BONE_CHESTPLATE = ITEMS.register("bone_chestplate", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BONE_LEGGINGS = ITEMS.register("bone_leggings", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BONE_BOOTS = ITEMS.register("bone_boots", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BONE_PICKAXE = ITEMS.register("bone_pickaxe", () -> new ModPickaxeItem(ModItemTier.BONE, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BONE_AXE = ITEMS.register("bone_axe", () -> new ModAxeItem(ModItemTier.BONE, 7.0F, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BONE_SHOVEL = ITEMS.register("bone_shovel", () -> new ModShovelItem(ModItemTier.BONE, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BONE_HOE = ITEMS.register("bone_hoe", () -> new ModHoeItem(ModItemTier.BONE, -1, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword", () -> new ModSwordItem(ModItemTier.BONE, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> WITHERBONE_HELMET = ITEMS.register("witherbone_helmet", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_CHESTPLATE = ITEMS.register("witherbone_chestplate", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_LEGGINGS = ITEMS.register("witherbone_leggings", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_BOOTS = ITEMS.register("witherbone_boots", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_PICKAXE = ITEMS.register("witherbone_pickaxe", () -> new ModPickaxeItem(ModItemTier.WITHERBONE, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_AXE = ITEMS.register("witherbone_axe", () -> new ModAxeItem(ModItemTier.WITHERBONE, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SHOVEL = ITEMS.register("witherbone_shovel", () -> new ModShovelItem(ModItemTier.WITHERBONE, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_HOE = ITEMS.register("witherbone_hoe", () -> new ModHoeItem(ModItemTier.WITHERBONE, -4, -2.0F, new Item.Properties().group(ItemGroup.TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SWORD = ITEMS.register("witherbone_sword", () -> new ModSwordItem(ModItemTier.WITHERBONE, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT).rarity(ModRarity.LEGENDARY)));
    
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new ModPickaxeItem(ModItemTier.EMERALD, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new ModAxeItem(ModItemTier.EMERALD, 5.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ModShovelItem(ModItemTier.EMERALD, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new ModHoeItem(ModItemTier.EMERALD, -3, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new ModSwordItem(ModItemTier.EMERALD, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new ModPickaxeItem(ModItemTier.RUBY, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new ModAxeItem(ModItemTier.RUBY, 6.0F, -3.1F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ModShovelItem(ModItemTier.RUBY, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new ModHoeItem(ModItemTier.RUBY, -2, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new ModSwordItem(ModItemTier.RUBY, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> ENDER_HELMET = ITEMS.register("ender_helmet", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ENDER_CHESTPLATE = ITEMS.register("ender_chestplate", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ENDER_LEGGINGS = ITEMS.register("ender_leggings", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ENDER_PICKAXE = ITEMS.register("ender_pickaxe", () -> new ModPickaxeItem(ModItemTier.ENDER, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDER_AXE = ITEMS.register("ender_axe", () -> new ModAxeItem(ModItemTier.ENDER, 5.0F, -3.1F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDER_SHOVEL = ITEMS.register("ender_shovel", () -> new ModShovelItem(ModItemTier.ENDER, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDER_HOE = ITEMS.register("ender_hoe", () -> new ModHoeItem(ModItemTier.ENDER, -2, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDER_SWORD = ITEMS.register("ender_sword", () -> new ModSwordItem(ModItemTier.ENDER, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> BLAZE_HELMET = ITEMS.register("blaze_helmet", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_CHESTPLATE = ITEMS.register("blaze_chestplate", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_LEGGINGS = ITEMS.register("blaze_leggings", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_BOOTS = ITEMS.register("blaze_boots", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_PICKAXE = ITEMS.register("blaze_pickaxe", () -> new ModPickaxeItem(ModItemTier.BLAZE, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_AXE = ITEMS.register("blaze_axe", () -> new ModAxeItem(ModItemTier.BLAZE, 6.0F, -3.1F, new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SHOVEL = ITEMS.register("blaze_shovel", () -> new ModShovelItem(ModItemTier.BLAZE, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_HOE = ITEMS.register("blaze_hoe", () -> new ModHoeItem(ModItemTier.BLAZE, -2, -2.0F, new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SWORD = ITEMS.register("blaze_sword", () -> new ModSwordItem(ModItemTier.BLAZE, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDSTONE_PICKAXE = ITEMS.register("endstone_pickaxe", () -> new ModPickaxeItem(ModItemTier.ENDSTONE, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_AXE = ITEMS.register("endstone_axe", () -> new AxeItem(ModItemTier.ENDSTONE, 7.0F, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_SHOVEL = ITEMS.register("endstone_shovel", () -> new ModShovelItem(ModItemTier.ENDSTONE, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_HOE = ITEMS.register("endstone_hoe", () -> new ModHoeItem(ModItemTier.ENDSTONE, -1, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_SWORD = ITEMS.register("endstone_sword", () -> new ModSwordItem(ModItemTier.ENDSTONE, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> NETHERRACK_PICKAXE = ITEMS.register("netherrack_pickaxe", () -> new ModPickaxeItem(ModItemTier.NETHERRACK, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_AXE = ITEMS.register("netherrack_axe", () -> new ModAxeItem(ModItemTier.NETHERRACK, 7.0F, -3.2F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_SHOVEL = ITEMS.register("netherrack_shovel", () -> new ModShovelItem(ModItemTier.NETHERRACK, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_HOE = ITEMS.register("netherrack_hoe", () -> new ModHoeItem(ModItemTier.NETHERRACK, -1, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_SWORD = ITEMS.register("netherrack_sword", () -> new ModSwordItem(ModItemTier.NETHERRACK, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BONELORD_HELMET = ITEMS.register("bonelord_helmet", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_CHESTPLATE = ITEMS.register("bonelord_chestplate", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_LEGGINGS = ITEMS.register("bonelord_leggings", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_BOOTS = ITEMS.register("bonelord_boots", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDERDRAGON_HELMET = ITEMS.register("enderdragon_helmet", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_CHESTPLATE = ITEMS.register("enderdragon_chestplate", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_LEGGINGS = ITEMS.register("enderdragon_leggings", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_BOOTS = ITEMS.register("enderdragon_boots", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe", () -> new ModPickaxeItem(ModItemTier.BEDROCK, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BEDROCK_AXE = ITEMS.register("bedrock_axe", () -> new ModAxeItem(ModItemTier.BEDROCK, 4.0F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel", () -> new ModShovelItem(ModItemTier.BEDROCK, 1.5F, -3.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BEDROCK_HOE = ITEMS.register("bedrock_hoe", () -> new ModHoeItem(ModItemTier.BEDROCK, -4, -2.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () -> new ModSwordItem(ModItemTier.BEDROCK, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));

	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerItems(final RegistryEvent.Register<Item> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
