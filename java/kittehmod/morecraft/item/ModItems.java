package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.entity.MinecartCraftingTable;
import kittehmod.morecraft.entity.NetherBoat;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreCraft.MODID);
	
	// -- BLOCKS -- \\
	public static final RegistryObject<Item> TUFF_STAIRS = ITEMS.register("tuff_stairs", () -> new BlockItem(ModBlocks.TUFF_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TUFF_SLAB = ITEMS.register("tuff_slab", () -> new BlockItem(ModBlocks.TUFF_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TUFF_WALL = ITEMS.register("tuff_wall", () -> new BlockItem(ModBlocks.TUFF_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> CALCITE_STAIRS = ITEMS.register("calcite_stairs", () -> new BlockItem(ModBlocks.CALCITE_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CALCITE_SLAB = ITEMS.register("calcite_slab", () -> new BlockItem(ModBlocks.CALCITE_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CALCITE_WALL = ITEMS.register("calcite_wall", () -> new BlockItem(ModBlocks.CALCITE_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> DRIPSTONE_STAIRS = ITEMS.register("dripstone_stairs", () -> new BlockItem(ModBlocks.DRIPSTONE_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DRIPSTONE_SLAB = ITEMS.register("dripstone_slab", () -> new BlockItem(ModBlocks.DRIPSTONE_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DRIPSTONE_WALL = ITEMS.register("dripstone_wall", () -> new BlockItem(ModBlocks.DRIPSTONE_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> SMOOTH_BASALT_STAIRS = ITEMS.register("smooth_basalt_stairs", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SMOOTH_BASALT_SLAB = ITEMS.register("smooth_basalt_slab", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SMOOTH_BASALT_WALL = ITEMS.register("smooth_basalt_wall", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> SPRUCE_CRAFTING_TABLE = ITEMS.register("spruce_crafting_table", () -> new ModCraftingTableItem(ModBlocks.SPRUCE_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> BIRCH_CRAFTING_TABLE = ITEMS.register("birch_crafting_table", () -> new ModCraftingTableItem(ModBlocks.BIRCH_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> JUNGLE_CRAFTING_TABLE = ITEMS.register("jungle_crafting_table", () -> new ModCraftingTableItem(ModBlocks.JUNGLE_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> ACACIA_CRAFTING_TABLE = ITEMS.register("acacia_crafting_table", () -> new ModCraftingTableItem(ModBlocks.ACACIA_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> DARK_OAK_CRAFTING_TABLE = ITEMS.register("dark_oak_crafting_table", () -> new ModCraftingTableItem(ModBlocks.DARK_OAK_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> CRIMSON_CRAFTING_TABLE = ITEMS.register("crimson_crafting_table", () -> new ModCraftingTableItem(ModBlocks.CRIMSON_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> WARPED_CRAFTING_TABLE = ITEMS.register("warped_crafting_table", () -> new ModCraftingTableItem(ModBlocks.WARPED_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_CRAFTING_TABLE = ITEMS.register("netherwood_crafting_table", () -> new ModCraftingTableItem(ModBlocks.NETHERWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	public static final RegistryObject<Item> NETHERWOOD_LOG = ITEMS.register("netherwood_log", () -> new BlockItem(ModBlocks.NETHERWOOD_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_LOG = ITEMS.register("stripped_netherwood_log", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_WOOD = ITEMS.register("netherwood_wood", () -> new BlockItem(ModBlocks.NETHERWOOD_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_WOOD = ITEMS.register("stripped_netherwood_wood", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_LEAVES = ITEMS.register("netherwood_leaves", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_SAPLING = ITEMS.register("netherwood_sapling", () -> new BlockItem(ModBlocks.NETHERWOOD_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_PLANKS = ITEMS.register("netherwood_planks", () -> new BlockItem(ModBlocks.NETHERWOOD_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_STAIRS = ITEMS.register("netherwood_stairs", () -> new BlockItem(ModBlocks.NETHERWOOD_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_SLAB = ITEMS.register("netherwood_slab", () -> new BlockItem(ModBlocks.NETHERWOOD_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_SIGN = ITEMS.register("netherwood_sign", () -> new ModSignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> NETHERWOOD_FENCE = ITEMS.register("netherwood_fence", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_BOOKSHELF = ITEMS.register("netherwood_bookshelf", () -> new BlockItem(ModBlocks.NETHERWOOD_BOOKSHELF.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHERWOOD_CHEST = ITEMS.register("netherwood_chest", () -> new ModChestItem(ModBlocks.NETHERWOOD_CHEST.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> NETHERWOOD_TRAPPED_CHEST = ITEMS.register("netherwood_trapped_chest", () -> new ModChestItem(ModBlocks.NETHERWOOD_CHEST_TRAPPED.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_BUTTON = ITEMS.register("netherwood_button", () -> new BlockItem(ModBlocks.NETHERWOOD_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_PRESSURE_PLATE = ITEMS.register("netherwood_pressure_plate", () -> new BlockItem(ModBlocks.NETHERWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
		
	public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = ITEMS.register("deepslate_ruby_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> FLESH_BLOCK = ITEMS.register("flesh_block", () -> new BlockItem(ModBlocks.FLESH_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLAZE_BLOCK = ITEMS.register("blaze_block", () -> new BlockItem(ModBlocks.BLAZE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ENDER_BLOCK = ITEMS.register("ender_block", () -> new BlockItem(ModBlocks.ENDER_BLOCK.get(), new Item.Properties().tab(ModList.get().isLoaded("charm") ? null : CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GUNPOWDER_BLOCK = ITEMS.register("gunpowder_block", () -> new BlockItem(ModBlocks.GUNPOWDER_BLOCK.get(), new Item.Properties().tab(ModList.get().isLoaded("charm") ? null : CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> SOUL_GLASS = ITEMS.register("soul_glass", () -> new BlockItem(ModBlocks.SOUL_GLASS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SOUL_GLASS_PANE = ITEMS.register("soul_glass_pane", () -> new BlockItem(ModBlocks.SOUL_GLASS_PANE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> FLESH_CARPET = ITEMS.register("flesh_carpet", () -> new BlockItem(ModBlocks.FLESH_CARPET.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> BONE_LADDER = ITEMS.register("bone_ladder", () -> new BlockItem(ModBlocks.BONE_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> GLOWSTONE_TORCH = ITEMS.register("glowstone_torch", () -> new StandingAndWallBlockItem(ModBlocks.GLOWSTONE_TORCH.get(), ModBlocks.WALL_GLOWSTONE_TORCH.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> GLOWSTONE_LANTERN = ITEMS.register("glowstone_lantern", () -> new BlockItem(ModBlocks.GLOWSTONE_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> KILN = ITEMS.register("kiln", () -> new BlockItem(ModBlocks.KILN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> BEDROCK_BRICK = ITEMS.register("bedrock_brick", () -> new BlockItem(ModBlocks.BEDROCK_BRICK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	// -- DOORS -- \\
    public static final RegistryObject<Item> NETHERBRICK_DOOR = ITEMS.register("netherbrick_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERBRICK_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> NETHERWOOD_DOOR = ITEMS.register("netherwood_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERWOOD_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> NETHERITE_DOOR = ITEMS.register("netherite_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERITE_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE).fireResistant()));
	public static final RegistryObject<Item> GLASS_DOOR = ITEMS.register("glass_door", () -> new DoubleHighBlockItem(ModBlocks.GLASS_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<Item> BONE_DOOR = ITEMS.register("bone_door", () -> new DoubleHighBlockItem(ModBlocks.BONE_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
	
	public static final RegistryObject<Item> NETHERBRICK_TRAPDOOR = ITEMS.register("netherbrick_trapdoor", () -> new BlockItem(ModBlocks.NETHERBRICK_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_TRAPDOOR = ITEMS.register("netherwood_trapdoor", () -> new BlockItem(ModBlocks.NETHERWOOD_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> NETHERITE_TRAPDOOR = ITEMS.register("netherite_trapdoor", () -> new BlockItem(ModBlocks.NETHERITE_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).fireResistant()));
	public static final RegistryObject<Item> GLASS_TRAPDOOR = ITEMS.register("glass_trapdoor", () -> new BlockItem(ModBlocks.GLASS_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> BONE_TRAPDOOR = ITEMS.register("bone_trapdoor", () -> new BlockItem(ModBlocks.BONE_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    
    public static final RegistryObject<Item> NETHERBRICK_FENCE_GATE = ITEMS.register("netherbrick_fence_gate", () -> new BlockItem(ModBlocks.NETHERBRICK_FENCE_GATE.get(), new Item.Properties().tab(ModList.get().isLoaded("quark") ? null : CreativeModeTab.TAB_REDSTONE)));
	public static final RegistryObject<Item> NETHERWOOD_FENCE_GATE = ITEMS.register("netherwood_fence_gate", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	
	// -- FOOD -- \\
    public static final RegistryObject<Item> COOKED_FLESH = ITEMS.register("cooked_flesh", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_FLESH)));
    public static final RegistryObject<Item> RAW_CHEVON = ITEMS.register("raw_chevon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEVON_RAW)));
    public static final RegistryObject<Item> COOKED_CHEVON = ITEMS.register("cooked_chevon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEVON_COOKED)));
    public static final RegistryObject<Item> RAW_SPIDER = ITEMS.register("raw_spider", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SPIDER_RAW)));
    public static final RegistryObject<Item> COOKED_SPIDER = ITEMS.register("cooked_spider", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SPIDER_COOKED)));
    public static final RegistryObject<Item> RAW_SQUID = ITEMS.register("raw_squid", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SQUID_RAW)));
    public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SQUID_COOKED)));
    public static final RegistryObject<Item> RAW_GUARDIAN_MEAT = ITEMS.register("raw_guardian_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.GUARDIAN_MEAT_RAW)));
    public static final RegistryObject<Item> COOKED_GUARDIAN_MEAT = ITEMS.register("cooked_guardian_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.GUARDIAN_MEAT_COOKED)));
    public static final RegistryObject<Item> RAW_DRAGON_MEAT = ITEMS.register("raw_dragon_meat", () -> new Item(new Item.Properties().tab(null).food(ModFoods.DRAGON_MEAT_RAW).rarity(Rarity.UNCOMMON))); //Not used at the moment.
    public static final RegistryObject<Item> COOKED_DRAGON_MEAT = ITEMS.register("cooked_dragon_meat", () -> new Item(new Item.Properties().tab(null).food(ModFoods.DRAGON_MEAT_COOKED).rarity(Rarity.UNCOMMON))); //Not used at the moment.

    public static final RegistryObject<Item> BEEF_STEW = ITEMS.register("beef_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BEEF_STEW).stacksTo(1)));
    public static final RegistryObject<Item> PORK_STEW = ITEMS.register("pork_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.PORK_STEW).stacksTo(1)));
    public static final RegistryObject<Item> MUTTON_STEW = ITEMS.register("mutton_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.MUTTON_STEW).stacksTo(1)));
    public static final RegistryObject<Item> CHICKEN_STEW = ITEMS.register("chicken_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHICKEN_STEW).stacksTo(1)));
    public static final RegistryObject<Item> CHEVON_STEW = ITEMS.register("chevon_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CHEVON_STEW).stacksTo(1)));
    public static final RegistryObject<Item> SPIDER_STEW = ITEMS.register("spider_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SPIDER_STEW).stacksTo(1)));
    public static final RegistryObject<Item> FISH_STEW = ITEMS.register("fish_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.FISH_STEW).stacksTo(1)));
    public static final RegistryObject<Item> GUARDIAN_STEW = ITEMS.register("guardian_stew", () -> new BowlFoodItem(new Item.Properties().tab(null).food(ModFoods.GUARDIAN_STEW).stacksTo(1))); //Not used at the moment.
    public static final RegistryObject<Item> DRAGON_STEW = ITEMS.register("dragon_stew", () -> new BowlFoodItem(new Item.Properties().tab(null).food(ModFoods.DRAGON_STEW).stacksTo(1).rarity(Rarity.UNCOMMON))); //Not used at the moment.
    public static final RegistryObject<Item> NETHERSHROOM_STEW = ITEMS.register("nethershroom_stew", () -> new BowlFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.NETHERSHROOM_STEW).stacksTo(1)));

    public static final RegistryObject<Item> COOKED_EGG = ITEMS.register("cooked_egg", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.COOKED_EGG)));
    public static final RegistryObject<Item> CAKE_SLICE = ITEMS.register("cake_slice", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CAKE_SLICE)));
    public static final RegistryObject<Item> NETHER_APPLE = ITEMS.register("nether_apple", () -> new RandomEffectFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.NETHER_APPLE)));

    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.APPLE_PIE)));
    public static final RegistryObject<Item> NETHER_APPLE_PIE = ITEMS.register("nether_apple_pie", () -> new RandomEffectFoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.NETHER_APPLE_PIE)));
    public static final RegistryObject<Item> SWEETBERRY_PIE = ITEMS.register("sweetberry_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.SWEETBERRY_PIE)));

    // -- MATERIALS -- \\
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> WITHER_BONE_MEAL = ITEMS.register("wither_bone_meal", () -> new WitherBonemealItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GUARDIAN_SCALES = ITEMS.register("guardian_scales", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistryObject<Item> ENDERDRAGON_SCALES = ITEMS.register("enderdragon_scales", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));
    
	// -- TRANSPORTATION ITEMS -- \\
    public static final RegistryObject<Item> CRIMSON_BOAT = ITEMS.register("crimson_boat", () -> new NetherBoatItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1).fireResistant(), NetherBoat.Type.CRIMSON));
    public static final RegistryObject<Item> WARPED_BOAT = ITEMS.register("warped_boat", () -> new NetherBoatItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1).fireResistant(), NetherBoat.Type.WARPED));
    public static final RegistryObject<Item> NETHERWOOD_BOAT = ITEMS.register("netherwood_boat", () -> new NetherBoatItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1).fireResistant(), NetherBoat.Type.NETHERWOOD));

    public static final RegistryObject<Item> OAK_CRAFTING_TABLE_MINECART = ITEMS.register("oak_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.OAK));
    public static final RegistryObject<Item> SPRUCE_CRAFTING_TABLE_MINECART = ITEMS.register("spruce_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.SPRUCE));
    public static final RegistryObject<Item> BIRCH_CRAFTING_TABLE_MINECART = ITEMS.register("birch_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.BIRCH));
    public static final RegistryObject<Item> JUNGLE_CRAFTING_TABLE_MINECART = ITEMS.register("jungle_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.JUNGLE));
    public static final RegistryObject<Item> ACACIA_CRAFTING_TABLE_MINECART = ITEMS.register("acacia_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.ACACIA));
    public static final RegistryObject<Item> DARK_OAK_CRAFTING_TABLE_MINECART = ITEMS.register("dark_oak_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.DARK_OAK));
    public static final RegistryObject<Item> CRIMSON_CRAFTING_TABLE_MINECART = ITEMS.register("crimson_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.CRIMSON));
    public static final RegistryObject<Item> WARPED_CRAFTING_TABLE_MINECART = ITEMS.register("warped_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.WARPED));
    public static final RegistryObject<Item> NETHERWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("netherwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION).stacksTo(1), MinecartCraftingTable.CraftingTableType.NETHERWOOD));
    
    // QUARK ADDONS
    public static final RegistryObject<Item> NETHERWOOD_LADDER = ModItems.ITEMS.register("netherwood_ladder", () -> new BlockItem(ModBlocks.NETHERWOOD_LADDER.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_DECORATIONS))));
    public static final RegistryObject<Item> VERTICAL_NETHERWOOD_PLANKS = ModItems.ITEMS.register("vertical_netherwood_planks", () -> new BlockItem(ModBlocks.VERTICAL_NETHERWOOD_PLANKS.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> NETHERWOOD_VERTICAL_SLAB = ModItems.ITEMS.register("netherwood_vertical_slab", () -> new BlockItem(ModBlocks.NETHERWOOD_VERTICAL_SLAB.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> NETHERWOOD_POST = ModItems.ITEMS.register("netherwood_post", () -> new BlockItem(ModBlocks.NETHERWOOD_POST.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> STRIPPED_NETHERWOOD_POST = ModItems.ITEMS.register("stripped_netherwood_post", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_POST.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> NETHERWOOD_HEDGE = ModItems.ITEMS.register("netherwood_hedge", () -> new BlockItem(ModBlocks.NETHERWOOD_HEDGE.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_DECORATIONS))));
    public static final RegistryObject<Item> NETHERWOOD_LEAF_CARPET = ModItems.ITEMS.register("netherwood_leaf_carpet", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_DECORATIONS))));

    public static final RegistryObject<Item> TUFF_VERTICAL_SLAB = ModItems.ITEMS.register("tuff_vertical_slab", () -> new BlockItem(ModBlocks.TUFF_VERTICAL_SLAB.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> CALCITE_VERTICAL_SLAB = ModItems.ITEMS.register("calcite_vertical_slab", () -> new BlockItem(ModBlocks.CALCITE_VERTICAL_SLAB.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> DRIPSTONE_VERTICAL_SLAB = ModItems.ITEMS.register("dripstone_vertical_slab", () -> new BlockItem(ModBlocks.DRIPSTONE_VERTICAL_SLAB.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> SMOOTH_BASALT_VERTICAL_SLAB = ModItems.ITEMS.register("smooth_basalt_vertical_slab", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_VERTICAL_SLAB.get(), new Item.Properties().tab(conditionallyAddTab("quark", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    
    // CHARM ADDONS
    public static final RegistryObject<Item> NETHERWOOD_CRATE = ModItems.ITEMS.register("netherwood_crate", () -> new BlockItem(ModBlocks.NETHERWOOD_CRATE.get(), new Item.Properties().tab(conditionallyAddTab("charm", CreativeModeTab.TAB_DECORATIONS)).stacksTo(1)));
    public static final RegistryObject<Item> NETHERWOOD_BOOKCASE = ModItems.ITEMS.register("netherwood_bookcase", () -> new BlockItem(ModBlocks.NETHERWOOD_BOOKCASE.get(), new Item.Properties().tab(conditionallyAddTab("charm", CreativeModeTab.TAB_DECORATIONS))));
    public static final RegistryObject<Item> NETHERWOOD_BARREL = ModItems.ITEMS.register("netherwood_barrel", () -> new BlockItem(ModBlocks.NETHERWOOD_BARREL.get(), new Item.Properties().tab(conditionallyAddTab("charm", CreativeModeTab.TAB_DECORATIONS))));
   
    // BUZZIER BEES
    public static final RegistryObject<Item> NETHERWOOD_BEEHIVE = ModItems.ITEMS.register("netherwood_beehive", () -> new BlockItem(ModBlocks.NETHERWOOD_BEEHIVE.get(), new Item.Properties().tab(conditionallyAddTab("buzzier_bees", CreativeModeTab.TAB_DECORATIONS))));
    
    // DRAMATIC DOORS
    public static final RegistryObject<Item> TALL_NETHERBRICK_DOOR = ITEMS.register("tall_netherbrick_door", () -> new ModTallDoorItem(ModBlocks.TALL_NETHERBRICK_DOOR.get(), (new Item.Properties()).tab(conditionallyAddTab("dramaticdoors", getTabWithMatchingName("dramaticdoors")))));
    public static final RegistryObject<Item> TALL_NETHERWOOD_DOOR = ITEMS.register("tall_netherwood_door", () -> new ModTallDoorItem(ModBlocks.TALL_NETHERWOOD_DOOR.get(), (new Item.Properties()).tab(conditionallyAddTab("dramaticdoors", getTabWithMatchingName("dramaticdoors")))));
    public static final RegistryObject<Item> TALL_NETHERITE_DOOR = ITEMS.register("tall_netherite_door", () -> new ModTallDoorItem(ModBlocks.TALL_NETHERITE_DOOR.get(), (new Item.Properties()).tab(conditionallyAddTab("dramaticdoors", getTabWithMatchingName("dramaticdoors"))).fireResistant()));
	public static final RegistryObject<Item> TALL_GLASS_DOOR = ITEMS.register("tall_glass_door", () -> new ModTallDoorItem(ModBlocks.TALL_GLASS_DOOR.get(), (new Item.Properties()).tab(conditionallyAddTab("dramaticdoors", getTabWithMatchingName("dramaticdoors")))));
    public static final RegistryObject<Item> TALL_BONE_DOOR = ITEMS.register("tall_bone_door", () -> new ModTallDoorItem(ModBlocks.TALL_BONE_DOOR.get(), (new Item.Properties()).tab(conditionallyAddTab("dramaticdoors", getTabWithMatchingName("dramaticdoors")))));
    
	// -- HORSE ARMOUR -- \\
    public static final RegistryObject<Item> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor", () -> new ModHorseArmorItem(5, "copper", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BONE_HORSE_ARMOR = ITEMS.register("bone_horse_armor", () -> new ModHorseArmorItem(4, "bone", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor", () -> new ModHorseArmorItem(10, "emerald", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor", () -> new ModHorseArmorItem(8, "ruby", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> OBSIDIAN_HORSE_ARMOR = ITEMS.register("obsidian_horse_armor", () -> new ModHorseArmorItem(9, "obsidian", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor", () -> new ModHorseArmorItem(12, "netherite", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC).fireResistant()));

	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ModArmorItem(ModArmorMaterial.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ModArmorItem(ModArmorMaterial.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ModArmorItem(ModArmorMaterial.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ModArmorItem(ModArmorMaterial.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new ModPickaxeItem(ModTier.COPPER, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new ModAxeItem(ModTier.COPPER, 6.0F, -3.15F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ModShovelItem(ModTier.COPPER, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new ModHoeItem(ModTier.COPPER, -3, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new ModSwordItem(ModTier.COPPER, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> SLIME_HELMET = ITEMS.register("slime_helmet", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SLIME_CHESTPLATE = ITEMS.register("slime_chestplate", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SLIME_LEGGINGS = ITEMS.register("slime_leggings", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SLIME_BOOTS = ITEMS.register("slime_boots", () -> new ModArmorItem(ModArmorMaterial.SLIME, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> FLESH_HELMET = ITEMS.register("flesh_helmet", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> FLESH_CHESTPLATE = ITEMS.register("flesh_chestplate", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> FLESH_LEGGINGS = ITEMS.register("flesh_leggings", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> FLESH_BOOTS = ITEMS.register("flesh_boots", () -> new ModArmorItem(ModArmorMaterial.FLESH, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
 	
    public static final RegistryObject<Item> SPIDERSILK_HELMET = ITEMS.register("spidersilk_helmet", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_CHESTPLATE = ITEMS.register("spidersilk_chestplate", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_LEGGINGS = ITEMS.register("spidersilk_leggings", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> SPIDERSILK_BOOTS = ITEMS.register("spidersilk_boots", () -> new ModArmorItem(ModArmorMaterial.SILK, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ModArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new ModPickaxeItem(ModTier.OBSIDIAN, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new ModAxeItem(ModTier.OBSIDIAN, 5.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ModShovelItem(ModTier.OBSIDIAN, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new ModHoeItem(ModTier.OBSIDIAN, -3, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new ModSwordItem(ModTier.OBSIDIAN, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> BONE_HELMET = ITEMS.register("bone_helmet", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BONE_CHESTPLATE = ITEMS.register("bone_chestplate", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BONE_LEGGINGS = ITEMS.register("bone_leggings", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BONE_BOOTS = ITEMS.register("bone_boots", () -> new ModArmorItem(ModArmorMaterial.BONE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BONE_PICKAXE = ITEMS.register("bone_pickaxe", () -> new ModPickaxeItem(ModTier.BONE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BONE_AXE = ITEMS.register("bone_axe", () -> new ModAxeItem(ModTier.BONE, 7.0F, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BONE_SHOVEL = ITEMS.register("bone_shovel", () -> new ModShovelItem(ModTier.BONE, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BONE_HOE = ITEMS.register("bone_hoe", () -> new ModHoeItem(ModTier.BONE, -1, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword", () -> new ModSwordItem(ModTier.BONE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> WITHERBONE_HELMET = ITEMS.register("witherbone_helmet", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_CHESTPLATE = ITEMS.register("witherbone_chestplate", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_LEGGINGS = ITEMS.register("witherbone_leggings", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_BOOTS = ITEMS.register("witherbone_boots", () -> new ModArmorItem(ModArmorMaterial.WITHERBONE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_PICKAXE = ITEMS.register("witherbone_pickaxe", () -> new ModPickaxeItem(ModTier.WITHERBONE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_AXE = ITEMS.register("witherbone_axe", () -> new ModAxeItem(ModTier.WITHERBONE, 5.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SHOVEL = ITEMS.register("witherbone_shovel", () -> new ModShovelItem(ModTier.WITHERBONE, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_HOE = ITEMS.register("witherbone_hoe", () -> new ModHoeItem(ModTier.WITHERBONE, -4, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SWORD = ITEMS.register("witherbone_sword", () -> new ModSwordItem(ModTier.WITHERBONE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(ModRarity.LEGENDARY)));
    
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ModArmorItem(ModArmorMaterial.EMERALD, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new ModPickaxeItem(ModTier.EMERALD, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new ModAxeItem(ModTier.EMERALD, 5.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ModShovelItem(ModTier.EMERALD, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new ModHoeItem(ModTier.EMERALD, -3, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new ModSwordItem(ModTier.EMERALD, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ModArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new ModPickaxeItem(ModTier.RUBY, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new ModAxeItem(ModTier.RUBY, 6.0F, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ModShovelItem(ModTier.RUBY, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new ModHoeItem(ModTier.RUBY, -2, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new ModSwordItem(ModTier.RUBY, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> ENDER_HELMET = ITEMS.register("ender_helmet", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> ENDER_CHESTPLATE = ITEMS.register("ender_chestplate", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> ENDER_LEGGINGS = ITEMS.register("ender_leggings", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new ModArmorItem(ModArmorMaterial.ENDER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> ENDER_PICKAXE = ITEMS.register("ender_pickaxe", () -> new ModPickaxeItem(ModTier.ENDER, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDER_AXE = ITEMS.register("ender_axe", () -> new ModAxeItem(ModTier.ENDER, 5.0F, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDER_SHOVEL = ITEMS.register("ender_shovel", () -> new ModShovelItem(ModTier.ENDER, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDER_HOE = ITEMS.register("ender_hoe", () -> new ModHoeItem(ModTier.ENDER, -2, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDER_SWORD = ITEMS.register("ender_sword", () -> new ModSwordItem(ModTier.ENDER, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> BLAZE_HELMET = ITEMS.register("blaze_helmet", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_CHESTPLATE = ITEMS.register("blaze_chestplate", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_LEGGINGS = ITEMS.register("blaze_leggings", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_BOOTS = ITEMS.register("blaze_boots", () -> new BlazeArmorItem(ModArmorMaterial.BLAZE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_PICKAXE = ITEMS.register("blaze_pickaxe", () -> new ModPickaxeItem(ModTier.BLAZE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_AXE = ITEMS.register("blaze_axe", () -> new ModAxeItem(ModTier.BLAZE, 6.0F, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SHOVEL = ITEMS.register("blaze_shovel", () -> new ModShovelItem(ModTier.BLAZE, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_HOE = ITEMS.register("blaze_hoe", () -> new ModHoeItem(ModTier.BLAZE, -2, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SWORD = ITEMS.register("blaze_sword", () -> new ModSwordItem(ModTier.BLAZE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDSTONE_PICKAXE = ITEMS.register("endstone_pickaxe", () -> new ModPickaxeItem(ModTier.ENDSTONE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_AXE = ITEMS.register("endstone_axe", () -> new ModAxeItem(ModTier.ENDSTONE, 7.0F, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_SHOVEL = ITEMS.register("endstone_shovel", () -> new ModShovelItem(ModTier.ENDSTONE, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_HOE = ITEMS.register("endstone_hoe", () -> new ModHoeItem(ModTier.ENDSTONE, -1, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> ENDSTONE_SWORD = ITEMS.register("endstone_sword", () -> new ModSwordItem(ModTier.ENDSTONE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> NETHERRACK_PICKAXE = ITEMS.register("netherrack_pickaxe", () -> new ModPickaxeItem(ModTier.NETHERRACK, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_AXE = ITEMS.register("netherrack_axe", () -> new ModAxeItem(ModTier.NETHERRACK, 7.0F, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_SHOVEL = ITEMS.register("netherrack_shovel", () -> new ModShovelItem(ModTier.NETHERRACK, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_HOE = ITEMS.register("netherrack_hoe", () -> new ModHoeItem(ModTier.NETHERRACK, -1, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERRACK_SWORD = ITEMS.register("netherrack_sword", () -> new ModSwordItem(ModTier.NETHERRACK, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> BONELORD_HELMET = ITEMS.register("bonelord_helmet", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_CHESTPLATE = ITEMS.register("bonelord_chestplate", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_LEGGINGS = ITEMS.register("bonelord_leggings", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_BOOTS = ITEMS.register("bonelord_boots", () -> new ModArmorItem(ModArmorMaterial.BONELORD, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDERDRAGON_HELMET = ITEMS.register("enderdragon_helmet", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_CHESTPLATE = ITEMS.register("enderdragon_chestplate", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_LEGGINGS = ITEMS.register("enderdragon_leggings", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_BOOTS = ITEMS.register("enderdragon_boots", () -> new EnderdragonArmorItem(ModArmorMaterial.ENDERDRAGON, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ModArmorItem(ModArmorMaterial.BEDROCK, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe", () -> new ModPickaxeItem(ModTier.BEDROCK, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BEDROCK_AXE = ITEMS.register("bedrock_axe", () -> new ModAxeItem(ModTier.BEDROCK, 4.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel", () -> new ModShovelItem(ModTier.BEDROCK, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BEDROCK_HOE = ITEMS.register("bedrock_hoe", () -> new ModHoeItem(ModTier.BEDROCK, -4, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () -> new ModSwordItem(ModTier.BEDROCK, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    @Nullable
    private static CreativeModeTab conditionallyAddTab(String modid, CreativeModeTab tab) {
    	if (ModList.get().isLoaded(modid)) {
    		return tab;
    	}
    	else {
    		return null;
    	}
    }
    
    private static CreativeModeTab getTabWithMatchingName(String tabName) {
    	CreativeModeTab tab = null;
    	for (CreativeModeTab tempTab : CreativeModeTab.TABS) {
    		TranslatableComponent tabComp = (TranslatableComponent) tempTab.getDisplayName();
    		if (tabComp.getKey().equalsIgnoreCase("itemGroup." + tabName)) {
    			tab = tempTab;
    			break;
    		}
    	}
    	return tab;
    }
    
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerItems(final RegistryEvent.Register<Item> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
