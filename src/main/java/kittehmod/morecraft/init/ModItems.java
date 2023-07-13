package kittehmod.morecraft.init;

import kittehmod.morecraft.ModCompats;
import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.entity.NetherBoat;
import kittehmod.morecraft.item.BlazeArmorItem;
import kittehmod.morecraft.item.ElytraBlueprintItem;
import kittehmod.morecraft.item.EnderdragonArmorItem;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterials;
import kittehmod.morecraft.item.ModAxeItem;
import kittehmod.morecraft.item.ModChestItem;
import kittehmod.morecraft.item.ModFoods;
import kittehmod.morecraft.item.ModHoeItem;
import kittehmod.morecraft.item.ModHorseArmorItem;
import kittehmod.morecraft.item.ModPickaxeItem;
import kittehmod.morecraft.item.ModRarity;
import kittehmod.morecraft.item.ModShovelItem;
import kittehmod.morecraft.item.ModSwordItem;
import kittehmod.morecraft.item.ModTier;
import kittehmod.morecraft.item.NetherBoatItem;
import kittehmod.morecraft.item.PatinaItem;
import kittehmod.morecraft.item.RandomEffectFoodItem;
import kittehmod.morecraft.item.WardenHeadItem;
import kittehmod.morecraft.item.WitherBonemealItem;
import kittehmod.morecraft.item.WoolArmorItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreCraft.MODID);
		
	// -- BLOCKS -- \\
	public static final RegistryObject<Item> TUFF_STAIRS = ITEMS.register("tuff_stairs", () -> new BlockItem(ModBlocks.TUFF_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> TUFF_SLAB = ITEMS.register("tuff_slab", () -> new BlockItem(ModBlocks.TUFF_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> TUFF_WALL = ITEMS.register("tuff_wall", () -> new BlockItem(ModBlocks.TUFF_WALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> CALCITE_STAIRS = ITEMS.register("calcite_stairs", () -> new BlockItem(ModBlocks.CALCITE_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CALCITE_SLAB = ITEMS.register("calcite_slab", () -> new BlockItem(ModBlocks.CALCITE_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> CALCITE_WALL = ITEMS.register("calcite_wall", () -> new BlockItem(ModBlocks.CALCITE_WALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRIPSTONE_STAIRS = ITEMS.register("dripstone_stairs", () -> new BlockItem(ModBlocks.DRIPSTONE_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRIPSTONE_SLAB = ITEMS.register("dripstone_slab", () -> new BlockItem(ModBlocks.DRIPSTONE_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> DRIPSTONE_WALL = ITEMS.register("dripstone_wall", () -> new BlockItem(ModBlocks.DRIPSTONE_WALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> SMOOTH_BASALT_STAIRS = ITEMS.register("smooth_basalt_stairs", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SMOOTH_BASALT_SLAB = ITEMS.register("smooth_basalt_slab", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> SMOOTH_BASALT_WALL = ITEMS.register("smooth_basalt_wall", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_WALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> QUARTZ_BRICK_STAIRS = ITEMS.register("quartz_brick_stairs", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> QUARTZ_BRICK_SLAB = ITEMS.register("quartz_brick_slab", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> QUARTZ_BRICK_WALL = ITEMS.register("quartz_brick_wall", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_WALL.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> NETHERWOOD_LOG = ITEMS.register("netherwood_log", () -> new BlockItem(ModBlocks.NETHERWOOD_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_LOG = ITEMS.register("stripped_netherwood_log", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_LOG.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_WOOD = ITEMS.register("netherwood_wood", () -> new BlockItem(ModBlocks.NETHERWOOD_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> STRIPPED_NETHERWOOD_WOOD = ITEMS.register("stripped_netherwood_wood", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_LEAVES = ITEMS.register("netherwood_leaves", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_SAPLING = ITEMS.register("netherwood_sapling", () -> new BlockItem(ModBlocks.NETHERWOOD_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_PLANKS = ITEMS.register("netherwood_planks", () -> new BlockItem(ModBlocks.NETHERWOOD_PLANKS.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_STAIRS = ITEMS.register("netherwood_stairs", () -> new BlockItem(ModBlocks.NETHERWOOD_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_SLAB = ITEMS.register("netherwood_slab", () -> new BlockItem(ModBlocks.NETHERWOOD_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_SIGN = ITEMS.register("netherwood_sign", () -> new SignItem((new Item.Properties()).stacksTo(16), ModBlocks.NETHERWOOD_SIGN.get(), ModBlocks.NETHERWOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> NETHERWOOD_HANGING_SIGN = ITEMS.register("netherwood_hanging_sign", () -> new HangingSignItem(ModBlocks.NETHERWOOD_HANGING_SIGN.get(), ModBlocks.NETHERWOOD_WALL_HANGING_SIGN.get(), (new Item.Properties()).stacksTo(16)));
	public static final RegistryObject<Item> NETHERWOOD_FENCE = ITEMS.register("netherwood_fence", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_BUTTON = ITEMS.register("netherwood_button", () -> new BlockItem(ModBlocks.NETHERWOOD_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_PRESSURE_PLATE = ITEMS.register("netherwood_pressure_plate", () -> new BlockItem(ModBlocks.NETHERWOOD_PRESSURE_PLATE.get(), new Item.Properties()));
		
	public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties()));
	public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = ITEMS.register("deepslate_ruby_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_RUBY_ORE.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> FLESH_BLOCK = ITEMS.register("flesh_block", () -> new BlockItem(ModBlocks.FLESH_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLAZE_BLOCK = ITEMS.register("blaze_block", () -> new BlockItem(ModBlocks.BLAZE_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> ENDER_BLOCK = ITEMS.register("ender_block", () -> new BlockItem(ModBlocks.ENDER_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> GUNPOWDER_BLOCK = ITEMS.register("gunpowder_block", () -> new BlockItem(ModBlocks.GUNPOWDER_BLOCK.get(), new Item.Properties()));

	public static final RegistryObject<Item> SOUL_GLASS = ITEMS.register("soul_glass", () -> new BlockItem(ModBlocks.SOUL_GLASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOUL_GLASS_PANE = ITEMS.register("soul_glass_pane", () -> new BlockItem(ModBlocks.SOUL_GLASS_PANE.get(), new Item.Properties()));
	public static final RegistryObject<Item> FLESH_CARPET = ITEMS.register("flesh_carpet", () -> new BlockItem(ModBlocks.FLESH_CARPET.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONE_LADDER = ITEMS.register("bone_ladder", () -> new BlockItem(ModBlocks.BONE_LADDER.get(), new Item.Properties()));
	public static final RegistryObject<Item> GLOW_INK_TORCH = ITEMS.register("glow_ink_torch", () -> new StandingAndWallBlockItem(ModBlocks.GLOW_INK_TORCH.get(), ModBlocks.WALL_GLOW_INK_TORCH.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> GLOWSTONE_TORCH = ITEMS.register("glowstone_torch", () -> new StandingAndWallBlockItem(ModBlocks.GLOWSTONE_TORCH.get(), ModBlocks.WALL_GLOWSTONE_TORCH.get(), new Item.Properties(), Direction.DOWN));
	public static final RegistryObject<Item> GLOWSTONE_LANTERN = ITEMS.register("glowstone_lantern", () -> new BlockItem(ModBlocks.GLOWSTONE_LANTERN.get(), new Item.Properties()));
	public static final RegistryObject<Item> BEDROCK_BRICK = ITEMS.register("bedrock_brick", () -> new BlockItem(ModBlocks.BEDROCK_BRICK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BEDROCK_BRICK_STAIRS = ITEMS.register("bedrock_brick_stairs", () -> new BlockItem(ModBlocks.BEDROCK_BRICK_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<Item> BEDROCK_BRICK_SLAB = ITEMS.register("bedrock_brick_slab", () -> new BlockItem(ModBlocks.BEDROCK_BRICK_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<Item> BEDROCK_BRICK_WALL = ITEMS.register("bedrock_brick_wall", () -> new BlockItem(ModBlocks.BEDROCK_BRICK_WALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> KILN = ITEMS.register("kiln", () -> new BlockItem(ModBlocks.KILN.get(), new Item.Properties()));
	public static final RegistryObject<Item> DEEPSLATE_BUTTON = ITEMS.register("deepslate_button", () -> new BlockItem(ModBlocks.DEEPSLATE_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<Item> DEEPSLATE_PRESSURE_PLATE = ITEMS.register("deepslate_pressure_plate", () -> new BlockItem(ModBlocks.DEEPSLATE_PRESSURE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> WARDEN_HEAD = ITEMS.register("warden_head", () -> new WardenHeadItem(ModBlocks.WARDEN_HEAD.get(), ModBlocks.WARDEN_WALL_HEAD.get(), new Item.Properties().rarity(ModRarity.LEGENDARY)));

	// -- DOORS -- \\
    public static final RegistryObject<Item> NETHERBRICK_DOOR = ITEMS.register("netherbrick_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERBRICK_DOOR.get(), (new Item.Properties())));
    public static final RegistryObject<Item> NETHERWOOD_DOOR = ITEMS.register("netherwood_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERWOOD_DOOR.get(), (new Item.Properties())));
    public static final RegistryObject<Item> NETHERITE_DOOR = ITEMS.register("netherite_door", () -> new DoubleHighBlockItem(ModBlocks.NETHERITE_DOOR.get(), (new Item.Properties()).fireResistant()));
	public static final RegistryObject<Item> GLASS_DOOR = ITEMS.register("glass_door", () -> new DoubleHighBlockItem(ModBlocks.GLASS_DOOR.get(), (new Item.Properties())));
	public static final RegistryObject<Item> SOUL_GLASS_DOOR = ITEMS.register("soul_glass_door", () -> new DoubleHighBlockItem(ModBlocks.SOUL_GLASS_DOOR.get(), (new Item.Properties())));
    public static final RegistryObject<Item> BONE_DOOR = ITEMS.register("bone_door", () -> new DoubleHighBlockItem(ModBlocks.BONE_DOOR.get(), (new Item.Properties())));
	
	public static final RegistryObject<Item> NETHERBRICK_TRAPDOOR = ITEMS.register("netherbrick_trapdoor", () -> new BlockItem(ModBlocks.NETHERBRICK_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_TRAPDOOR = ITEMS.register("netherwood_trapdoor", () -> new BlockItem(ModBlocks.NETHERWOOD_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERITE_TRAPDOOR = ITEMS.register("netherite_trapdoor", () -> new BlockItem(ModBlocks.NETHERITE_TRAPDOOR.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> GLASS_TRAPDOOR = ITEMS.register("glass_trapdoor", () -> new BlockItem(ModBlocks.GLASS_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> SOUL_GLASS_TRAPDOOR = ITEMS.register("soul_glass_trapdoor", () -> new BlockItem(ModBlocks.SOUL_GLASS_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<Item> BONE_TRAPDOOR = ITEMS.register("bone_trapdoor", () -> new BlockItem(ModBlocks.BONE_TRAPDOOR.get(), new Item.Properties()));
    
    public static final RegistryObject<Item> NETHERBRICK_FENCE_GATE = ITEMS.register("netherbrick_fence_gate", () -> new BlockItem(ModBlocks.NETHERBRICK_FENCE_GATE.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_FENCE_GATE = ITEMS.register("netherwood_fence_gate", () -> new BlockItem(ModBlocks.NETHERWOOD_FENCE_GATE.get(), new Item.Properties()));
	
	// -- FOOD -- \\
    public static final RegistryObject<Item> COOKED_FLESH = ITEMS.register("cooked_flesh", () -> new Item(new Item.Properties().food(ModFoods.COOKED_FLESH)));
    public static final RegistryObject<Item> RAW_CHEVON = ITEMS.register("raw_chevon", () -> new Item(new Item.Properties().food(ModFoods.CHEVON_RAW)));
    public static final RegistryObject<Item> COOKED_CHEVON = ITEMS.register("cooked_chevon", () -> new Item(new Item.Properties().food(ModFoods.CHEVON_COOKED)));
    public static final RegistryObject<Item> RAW_FROG_LEGS = ITEMS.register("raw_frog_legs", () -> new Item(new Item.Properties().food(ModFoods.FROG_LEGS_RAW)));
    public static final RegistryObject<Item> COOKED_FROG_LEGS = ITEMS.register("cooked_frog_legs", () -> new Item(new Item.Properties().food(ModFoods.FROG_LEGS_COOKED)));
    public static final RegistryObject<Item> RAW_SPIDER = ITEMS.register("raw_spider", () -> new Item(new Item.Properties().food(ModFoods.SPIDER_RAW)));
    public static final RegistryObject<Item> COOKED_SPIDER = ITEMS.register("cooked_spider", () -> new Item(new Item.Properties().food(ModFoods.SPIDER_COOKED)));
    public static final RegistryObject<Item> RAW_SQUID = ITEMS.register("raw_squid", () -> new Item(new Item.Properties().food(ModFoods.SQUID_RAW)));
    public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid", () -> new Item(new Item.Properties().food(ModFoods.SQUID_COOKED)));
    public static final RegistryObject<Item> RAW_GUARDIAN_MEAT = ITEMS.register("raw_guardian_meat", () -> new Item(new Item.Properties().food(ModFoods.GUARDIAN_MEAT_RAW)));
    public static final RegistryObject<Item> COOKED_GUARDIAN_MEAT = ITEMS.register("cooked_guardian_meat", () -> new Item(new Item.Properties().food(ModFoods.GUARDIAN_MEAT_COOKED)));
    public static final RegistryObject<Item> RAW_DRAGON_MEAT = ITEMS.register("raw_dragon_meat", () -> new Item(new Item.Properties().food(ModFoods.DRAGON_MEAT_RAW).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COOKED_DRAGON_MEAT = ITEMS.register("cooked_dragon_meat", () -> new Item(new Item.Properties().food(ModFoods.DRAGON_MEAT_COOKED).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> BEEF_STEW = ITEMS.register("beef_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.BEEF_STEW).stacksTo(1)));
    public static final RegistryObject<Item> PORK_STEW = ITEMS.register("pork_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.PORK_STEW).stacksTo(1)));
    public static final RegistryObject<Item> MUTTON_STEW = ITEMS.register("mutton_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.MUTTON_STEW).stacksTo(1)));
    public static final RegistryObject<Item> CHICKEN_STEW = ITEMS.register("chicken_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.CHICKEN_STEW).stacksTo(1)));
    public static final RegistryObject<Item> CHEVON_STEW = ITEMS.register("chevon_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.CHEVON_STEW).stacksTo(1)));
    public static final RegistryObject<Item> SPIDER_STEW = ITEMS.register("spider_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.SPIDER_STEW).stacksTo(1)));
    public static final RegistryObject<Item> FISH_STEW = ITEMS.register("fish_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.FISH_STEW).stacksTo(1)));
    public static final RegistryObject<Item> GUARDIAN_STEW = ITEMS.register("guardian_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.GUARDIAN_STEW).stacksTo(1)));
    public static final RegistryObject<Item> DRAGON_STEW = ITEMS.register("dragon_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.DRAGON_STEW).stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NETHERSHROOM_STEW = ITEMS.register("nethershroom_stew", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.NETHERSHROOM_STEW).stacksTo(1)));

    public static final RegistryObject<Item> COOKED_EGG = ITEMS.register("cooked_egg", () -> new Item(new Item.Properties().food(ModFoods.COOKED_EGG)));
    public static final RegistryObject<Item> CAKE_SLICE = ITEMS.register("cake_slice", () -> new Item(new Item.Properties().food(ModFoods.CAKE_SLICE)));
    public static final RegistryObject<Item> NETHER_APPLE = ITEMS.register("nether_apple", () -> new RandomEffectFoodItem(new Item.Properties().food(ModFoods.NETHER_APPLE)));

    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().food(ModFoods.APPLE_PIE)));
    public static final RegistryObject<Item> NETHER_APPLE_PIE = ITEMS.register("nether_apple_pie", () -> new RandomEffectFoodItem(new Item.Properties().food(ModFoods.NETHER_APPLE_PIE)));
    public static final RegistryObject<Item> SWEETBERRY_PIE = ITEMS.register("sweetberry_pie", () -> new Item(new Item.Properties().food(ModFoods.SWEETBERRY_PIE)));

    // -- MATERIALS -- \\
    public static final RegistryObject<Item> PATINA = ITEMS.register("patina", () -> new PatinaItem(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHER_BONE = ITEMS.register("wither_bone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHER_BONE_MEAL = ITEMS.register("wither_bone_meal", () -> new WitherBonemealItem(new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_SCALES = ITEMS.register("guardian_scales", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERDRAGON_SCALES = ITEMS.register("enderdragon_scales", () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> ELYTRA_BLUEPRINT = ITEMS.register("elytra_blueprint", () -> new ElytraBlueprintItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENDER_DRAGON_WINGS = ITEMS.register("ender_dragon_wings", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    
	// -- TRANSPORTATION ITEMS -- \\
    public static final RegistryObject<Item> CRIMSON_BOAT = ITEMS.register("crimson_boat", () -> new NetherBoatItem(false, NetherBoat.Type.CRIMSON, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> CRIMSON_CHEST_BOAT = ITEMS.register("crimson_chest_boat", () -> new NetherBoatItem(true, NetherBoat.Type.CRIMSON, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> WARPED_BOAT = ITEMS.register("warped_boat", () -> new NetherBoatItem(false, NetherBoat.Type.WARPED, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> WARPED_CHEST_BOAT = ITEMS.register("warped_chest_boat", () -> new NetherBoatItem(true, NetherBoat.Type.WARPED, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> NETHERWOOD_BOAT = ITEMS.register("netherwood_boat", () -> new NetherBoatItem(false, NetherBoat.Type.NETHERWOOD, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> NETHERWOOD_CHEST_BOAT = ITEMS.register("netherwood_chest_boat", () -> new NetherBoatItem(true, NetherBoat.Type.NETHERWOOD, new Item.Properties().stacksTo(1).fireResistant()));

    // QUARK
    public static final RegistryObject<Item> VERTICAL_NETHERWOOD_PLANKS = ITEMS.register("vertical_netherwood_planks", () -> new BlockItem(ModBlocks.VERTICAL_NETHERWOOD_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_VERTICAL_SLAB = ITEMS.register("netherwood_vertical_slab", () -> new BlockItem(ModBlocks.NETHERWOOD_VERTICAL_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_POST = ITEMS.register("netherwood_post", () -> new BlockItem(ModBlocks.NETHERWOOD_POST.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_NETHERWOOD_POST = ITEMS.register("stripped_netherwood_post", () -> new BlockItem(ModBlocks.STRIPPED_NETHERWOOD_POST.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_HEDGE = ITEMS.register("netherwood_hedge", () -> new BlockItem(ModBlocks.NETHERWOOD_HEDGE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_LEAF_CARPET = ITEMS.register("netherwood_leaf_carpet", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), new Item.Properties()));

    public static final RegistryObject<Item> BEDROCK_BRICK_VERTICAL_SLAB = ModItems.ITEMS.register("bedrock_brick_vertical_slab", () -> new BlockItem(ModBlocks.BEDROCK_BRICK_VERTICAL_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMOOTH_BASALT_VERTICAL_SLAB = ModItems.ITEMS.register("smooth_basalt_vertical_slab", () -> new BlockItem(ModBlocks.SMOOTH_BASALT_VERTICAL_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_BRICK_VERTICAL_SLAB = ModItems.ITEMS.register("quartz_brick_vertical_slab", () -> new BlockItem(ModBlocks.QUARTZ_BRICK_VERTICAL_SLAB.get(), new Item.Properties()));

    // WOODWORKS
    public static final RegistryObject<Item> NETHERWOOD_BOARDS = ITEMS.register("netherwood_boards", () -> new BlockItem(ModBlocks.NETHERWOOD_BOARDS.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_LADDER = ITEMS.register("netherwood_ladder", () -> new BlockItem(ModBlocks.NETHERWOOD_LADDER.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_BOOKSHELF = ITEMS.register("netherwood_bookshelf", () -> new BlockItem(ModBlocks.NETHERWOOD_BOOKSHELF.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_CHEST = ITEMS.register("netherwood_chest", () -> new ModChestItem(ModBlocks.NETHERWOOD_CHEST.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHERWOOD_TRAPPED_CHEST = ITEMS.register("netherwood_trapped_chest", () -> new ModChestItem(ModBlocks.NETHERWOOD_CHEST_TRAPPED.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_LEAF_PILE = ITEMS.register("netherwood_leaf_pile", () -> new BlockItem(ModBlocks.NETHERWOOD_LEAF_PILE.get(), new Item.Properties()));
    
    // CHARM
    public static final RegistryObject<Item> NETHERWOOD_CRATE = ModItems.ITEMS.register("netherwood_crate", () -> new BlockItem(ModBlocks.NETHERWOOD_CRATE.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NETHERWOOD_BOOKCASE = ModItems.ITEMS.register("netherwood_bookcase", () -> new BlockItem(ModBlocks.NETHERWOOD_BOOKCASE.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERWOOD_BARREL = ModItems.ITEMS.register("netherwood_barrel", () -> new BlockItem(ModBlocks.NETHERWOOD_BARREL.get(), new Item.Properties()));
       
	// -- HORSE ARMOUR -- \\
    public static final RegistryObject<Item> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor", () -> new ModHorseArmorItem(5, "copper", (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> BONE_HORSE_ARMOR = ITEMS.register("bone_horse_armor", () -> new ModHorseArmorItem(4, "bone", (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor", () -> new ModHorseArmorItem(10, "emerald", (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor", () -> new ModHorseArmorItem(8, "ruby", (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> OBSIDIAN_HORSE_ARMOR = ITEMS.register("obsidian_horse_armor", () -> new ModHorseArmorItem(9, "obsidian", (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor", () -> new ModHorseArmorItem(12, "netherite", (new Item.Properties()).stacksTo(1).fireResistant()));

	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final RegistryObject<Item> WOOL_HELMET = ITEMS.register("wool_helmet", () -> new WoolArmorItem(ModArmorMaterials.WOOL, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WOOL_CHESTPLATE = ITEMS.register("wool_chestplate", () -> new WoolArmorItem(ModArmorMaterials.WOOL, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WOOL_LEGGINGS = ITEMS.register("wool_leggings", () -> new WoolArmorItem(ModArmorMaterials.WOOL, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WOOL_BOOTS = ITEMS.register("wool_boots", () -> new WoolArmorItem(ModArmorMaterials.WOOL, Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ModArmorItem(ModArmorMaterials.COPPER, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ModArmorItem(ModArmorMaterials.COPPER, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ModArmorItem(ModArmorMaterials.COPPER, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ModArmorItem(ModArmorMaterials.COPPER, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new ModPickaxeItem(ModTier.COPPER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new ModAxeItem(ModTier.COPPER, 6.0F, -3.15F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ModShovelItem(ModTier.COPPER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new ModHoeItem(ModTier.COPPER, -2, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new ModSwordItem(ModTier.COPPER, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> SLIME_HELMET = ITEMS.register("slime_helmet", () -> new ModArmorItem(ModArmorMaterials.SLIME, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SLIME_CHESTPLATE = ITEMS.register("slime_chestplate", () -> new ModArmorItem(ModArmorMaterials.SLIME, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SLIME_LEGGINGS = ITEMS.register("slime_leggings", () -> new ModArmorItem(ModArmorMaterials.SLIME, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SLIME_BOOTS = ITEMS.register("slime_boots", () -> new ModArmorItem(ModArmorMaterials.SLIME, Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> FLESH_HELMET = ITEMS.register("flesh_helmet", () -> new ModArmorItem(ModArmorMaterials.FLESH, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> FLESH_CHESTPLATE = ITEMS.register("flesh_chestplate", () -> new ModArmorItem(ModArmorMaterials.FLESH, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> FLESH_LEGGINGS = ITEMS.register("flesh_leggings", () -> new ModArmorItem(ModArmorMaterials.FLESH, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> FLESH_BOOTS = ITEMS.register("flesh_boots", () -> new ModArmorItem(ModArmorMaterials.FLESH, Type.BOOTS, new Item.Properties()));
 	
    public static final RegistryObject<Item> SPIDERSILK_HELMET = ITEMS.register("spidersilk_helmet", () -> new ModArmorItem(ModArmorMaterials.SILK, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SPIDERSILK_CHESTPLATE = ITEMS.register("spidersilk_chestplate", () -> new ModArmorItem(ModArmorMaterials.SILK, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SPIDERSILK_LEGGINGS = ITEMS.register("spidersilk_leggings", () -> new ModArmorItem(ModArmorMaterials.SILK, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SPIDERSILK_BOOTS = ITEMS.register("spidersilk_boots", () -> new ModArmorItem(ModArmorMaterials.SILK, Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new ModPickaxeItem(ModTier.OBSIDIAN, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new ModAxeItem(ModTier.OBSIDIAN, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ModShovelItem(ModTier.OBSIDIAN, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new ModHoeItem(ModTier.OBSIDIAN, -3, 0.0F, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new ModSwordItem(ModTier.OBSIDIAN, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> BONE_HELMET = ITEMS.register("bone_helmet", () -> new ModArmorItem(ModArmorMaterials.BONE, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BONE_CHESTPLATE = ITEMS.register("bone_chestplate", () -> new ModArmorItem(ModArmorMaterials.BONE, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BONE_LEGGINGS = ITEMS.register("bone_leggings", () -> new ModArmorItem(ModArmorMaterials.BONE, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BONE_BOOTS = ITEMS.register("bone_boots", () -> new ModArmorItem(ModArmorMaterials.BONE, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BONE_PICKAXE = ITEMS.register("bone_pickaxe", () -> new ModPickaxeItem(ModTier.BONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_AXE = ITEMS.register("bone_axe", () -> new ModAxeItem(ModTier.BONE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_SHOVEL = ITEMS.register("bone_shovel", () -> new ModShovelItem(ModTier.BONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_HOE = ITEMS.register("bone_hoe", () -> new ModHoeItem(ModTier.BONE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword", () -> new ModSwordItem(ModTier.BONE, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> WITHERBONE_HELMET = ITEMS.register("witherbone_helmet", () -> new ModArmorItem(ModArmorMaterials.WITHERBONE, Type.HELMET, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_CHESTPLATE = ITEMS.register("witherbone_chestplate", () -> new ModArmorItem(ModArmorMaterials.WITHERBONE, Type.CHESTPLATE, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_LEGGINGS = ITEMS.register("witherbone_leggings", () -> new ModArmorItem(ModArmorMaterials.WITHERBONE, Type.LEGGINGS, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_BOOTS = ITEMS.register("witherbone_boots", () -> new ModArmorItem(ModArmorMaterials.WITHERBONE, Type.BOOTS, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_PICKAXE = ITEMS.register("witherbone_pickaxe", () -> new ModPickaxeItem(ModTier.WITHERBONE, 1, -2.8F, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_AXE = ITEMS.register("witherbone_axe", () -> new ModAxeItem(ModTier.WITHERBONE, 5.0F, -3.0F, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SHOVEL = ITEMS.register("witherbone_shovel", () -> new ModShovelItem(ModTier.WITHERBONE, 1.5F, -3.0F, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_HOE = ITEMS.register("witherbone_hoe", () -> new ModHoeItem(ModTier.WITHERBONE, -4, 0.0F, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    public static final RegistryObject<Item> WITHERBONE_SWORD = ITEMS.register("witherbone_sword", () -> new ModSwordItem(ModTier.WITHERBONE, 3, -2.4F, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ModArmorItem(ModArmorMaterials.EMERALD, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ModArmorItem(ModArmorMaterials.EMERALD, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ModArmorItem(ModArmorMaterials.EMERALD, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ModArmorItem(ModArmorMaterials.EMERALD, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new ModPickaxeItem(ModTier.EMERALD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new ModAxeItem(ModTier.EMERALD, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ModShovelItem(ModTier.EMERALD, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new ModHoeItem(ModTier.EMERALD, -3, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new ModSwordItem(ModTier.EMERALD, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ModArmorItem(ModArmorMaterials.RUBY, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ModArmorItem(ModArmorMaterials.RUBY, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ModArmorItem(ModArmorMaterials.RUBY, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ModArmorItem(ModArmorMaterials.RUBY, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new ModPickaxeItem(ModTier.RUBY, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new ModAxeItem(ModTier.RUBY, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ModShovelItem(ModTier.RUBY, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new ModHoeItem(ModTier.RUBY, -2, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new ModSwordItem(ModTier.RUBY, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> ENDER_HELMET = ITEMS.register("ender_helmet", () -> new ModArmorItem(ModArmorMaterials.ENDER, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_CHESTPLATE = ITEMS.register("ender_chestplate", () -> new ModArmorItem(ModArmorMaterials.ENDER, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_LEGGINGS = ITEMS.register("ender_leggings", () -> new ModArmorItem(ModArmorMaterials.ENDER, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new ModArmorItem(ModArmorMaterials.ENDER, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_PICKAXE = ITEMS.register("ender_pickaxe", () -> new ModPickaxeItem(ModTier.ENDER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_AXE = ITEMS.register("ender_axe", () -> new ModAxeItem(ModTier.ENDER, 5.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_SHOVEL = ITEMS.register("ender_shovel", () -> new ModShovelItem(ModTier.ENDER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_HOE = ITEMS.register("ender_hoe", () -> new ModHoeItem(ModTier.ENDER, -3, -1.0F, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_SWORD = ITEMS.register("ender_sword", () -> new ModSwordItem(ModTier.ENDER, 3, -2.4F, new Item.Properties()));
    
    public static final RegistryObject<Item> BLAZE_HELMET = ITEMS.register("blaze_helmet", () -> new BlazeArmorItem(ModArmorMaterials.BLAZE, Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_CHESTPLATE = ITEMS.register("blaze_chestplate", () -> new BlazeArmorItem(ModArmorMaterials.BLAZE, Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_LEGGINGS = ITEMS.register("blaze_leggings", () -> new BlazeArmorItem(ModArmorMaterials.BLAZE, Type.LEGGINGS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_BOOTS = ITEMS.register("blaze_boots", () -> new BlazeArmorItem(ModArmorMaterials.BLAZE, Type.BOOTS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_PICKAXE = ITEMS.register("blaze_pickaxe", () -> new ModPickaxeItem(ModTier.BLAZE, 1, -2.8F, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_AXE = ITEMS.register("blaze_axe", () -> new ModAxeItem(ModTier.BLAZE, 6.0F, -3.1F, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SHOVEL = ITEMS.register("blaze_shovel", () -> new ModShovelItem(ModTier.BLAZE, 1.5F, -3.0F, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_HOE = ITEMS.register("blaze_hoe", () -> new ModHoeItem(ModTier.BLAZE, -3, -1.0F, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLAZE_SWORD = ITEMS.register("blaze_sword", () -> new ModSwordItem(ModTier.BLAZE, 3, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDSTONE_PICKAXE = ITEMS.register("endstone_pickaxe", () -> new ModPickaxeItem(ModTier.ENDSTONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ENDSTONE_AXE = ITEMS.register("endstone_axe", () -> new ModAxeItem(ModTier.ENDSTONE, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> ENDSTONE_SHOVEL = ITEMS.register("endstone_shovel", () -> new ModShovelItem(ModTier.ENDSTONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ENDSTONE_HOE = ITEMS.register("endstone_hoe", () -> new ModHoeItem(ModTier.ENDSTONE, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> ENDSTONE_SWORD = ITEMS.register("endstone_sword", () -> new ModSwordItem(ModTier.ENDSTONE, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> NETHERRACK_PICKAXE = ITEMS.register("netherrack_pickaxe", () -> new ModPickaxeItem(ModTier.NETHERRACK, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERRACK_AXE = ITEMS.register("netherrack_axe", () -> new ModAxeItem(ModTier.NETHERRACK, 7.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERRACK_SHOVEL = ITEMS.register("netherrack_shovel", () -> new ModShovelItem(ModTier.NETHERRACK, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERRACK_HOE = ITEMS.register("netherrack_hoe", () -> new ModHoeItem(ModTier.NETHERRACK, -1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERRACK_SWORD = ITEMS.register("netherrack_sword", () -> new ModSwordItem(ModTier.NETHERRACK, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> BONELORD_HELMET = ITEMS.register("bonelord_helmet", () -> new ModArmorItem(ModArmorMaterials.BONELORD, Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_CHESTPLATE = ITEMS.register("bonelord_chestplate", () -> new ModArmorItem(ModArmorMaterials.BONELORD, Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_LEGGINGS = ITEMS.register("bonelord_leggings", () -> new ModArmorItem(ModArmorMaterials.BONELORD, Type.LEGGINGS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BONELORD_BOOTS = ITEMS.register("bonelord_boots", () -> new ModArmorItem(ModArmorMaterials.BONELORD, Type.BOOTS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    
    public static final RegistryObject<Item> ENDERDRAGON_HELMET = ITEMS.register("enderdragon_helmet", () -> new EnderdragonArmorItem(ModArmorMaterials.ENDERDRAGON, Type.HELMET, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_CHESTPLATE = ITEMS.register("enderdragon_chestplate", () -> new EnderdragonArmorItem(ModArmorMaterials.ENDERDRAGON, Type.CHESTPLATE, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_LEGGINGS = ITEMS.register("enderdragon_leggings", () -> new EnderdragonArmorItem(ModArmorMaterials.ENDERDRAGON, Type.LEGGINGS, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ENDERDRAGON_BOOTS = ITEMS.register("enderdragon_boots", () -> new EnderdragonArmorItem(ModArmorMaterials.ENDERDRAGON, Type.BOOTS, new Item.Properties().rarity(Rarity.EPIC)));
    
    public static final RegistryObject<Item> WINGED_ENDERDRAGON_CHESTPLATE = ITEMS.register("winged_enderdragon_chestplate", () -> new EnderdragonArmorItem(ModArmorMaterials.WINGED_ENDERDRAGON, Type.CHESTPLATE, new Item.Properties().rarity(ModRarity.LEGENDARY)));
    
    public static final RegistryObject<Item> BEDROCK_HELMET = ITEMS.register("bedrock_helmet", () -> new ModArmorItem(ModArmorMaterials.BEDROCK, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate", () -> new ModArmorItem(ModArmorMaterials.BEDROCK, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings", () -> new ModArmorItem(ModArmorMaterials.BEDROCK, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_BOOTS = ITEMS.register("bedrock_boots", () -> new ModArmorItem(ModArmorMaterials.BEDROCK, Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe", () -> new ModPickaxeItem(ModTier.BEDROCK, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_AXE = ITEMS.register("bedrock_axe", () -> new ModAxeItem(ModTier.BEDROCK, 4.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_SHOVEL = ITEMS.register("bedrock_shovel", () -> new ModShovelItem(ModTier.BEDROCK, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_HOE = ITEMS.register("bedrock_hoe", () -> new ModHoeItem(ModTier.BEDROCK, -4, 0.0F, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_SWORD = ITEMS.register("bedrock_sword", () -> new ModSwordItem(ModTier.BEDROCK, 3, -2.4F, new Item.Properties()));
    
    @SubscribeEvent
    public static void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
    	MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	// Insert into vanilla tabs.
    	if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    		map.putAfter(Items.WARPED_BUTTON.getDefaultInstance(), NETHERWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_LOG.get().getDefaultInstance(), NETHERWOOD_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_WOOD.get().getDefaultInstance(), STRIPPED_NETHERWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_NETHERWOOD_LOG.get().getDefaultInstance(), STRIPPED_NETHERWOOD_WOOD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(STRIPPED_NETHERWOOD_WOOD.get().getDefaultInstance(), NETHERWOOD_PLANKS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_PLANKS.get().getDefaultInstance(), NETHERWOOD_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_STAIRS.get().getDefaultInstance(), NETHERWOOD_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_SLAB.get().getDefaultInstance(), NETHERWOOD_FENCE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_FENCE.get().getDefaultInstance(), NETHERWOOD_FENCE_GATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_FENCE_GATE.get().getDefaultInstance(), NETHERWOOD_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_DOOR.get().getDefaultInstance(), NETHERWOOD_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_TRAPDOOR.get().getDefaultInstance(), NETHERWOOD_PRESSURE_PLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_PRESSURE_PLATE.get().getDefaultInstance(), NETHERWOOD_BUTTON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		if (!ModCompats.QUARK_INSTALLED && !ModList.get().isLoaded("caverns_and_chasms")) {
    			map.putAfter(Items.POLISHED_ANDESITE_SLAB.getDefaultInstance(), Items.CALCITE.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(Items.CALCITE.getDefaultInstance(), CALCITE_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CALCITE_STAIRS.get().getDefaultInstance(), CALCITE_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CALCITE_SLAB.get().getDefaultInstance(), CALCITE_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(CALCITE_WALL.get().getDefaultInstance(), Items.TUFF.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(Items.TUFF.getDefaultInstance(), TUFF_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(TUFF_STAIRS.get().getDefaultInstance(), TUFF_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(TUFF_SLAB.get().getDefaultInstance(), TUFF_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(TUFF_WALL.get().getDefaultInstance(), Items.DRIPSTONE_BLOCK.getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(Items.DRIPSTONE_BLOCK.getDefaultInstance(), DRIPSTONE_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(DRIPSTONE_STAIRS.get().getDefaultInstance(), DRIPSTONE_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(DRIPSTONE_SLAB.get().getDefaultInstance(), DRIPSTONE_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
			map.putAfter(Items.SMOOTH_BASALT.getDefaultInstance(), SMOOTH_BASALT_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(SMOOTH_BASALT_STAIRS.get().getDefaultInstance(), SMOOTH_BASALT_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(SMOOTH_BASALT_SLAB.get().getDefaultInstance(), SMOOTH_BASALT_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(Items.QUARTZ_BRICKS.getDefaultInstance(), QUARTZ_BRICK_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(QUARTZ_BRICK_STAIRS.get().getDefaultInstance(), QUARTZ_BRICK_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.putAfter(QUARTZ_BRICK_SLAB.get().getDefaultInstance(), QUARTZ_BRICK_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.put(BEDROCK_BRICK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.put(BEDROCK_BRICK_STAIRS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.put(BEDROCK_BRICK_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
			map.put(BEDROCK_BRICK_WALL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DEEPSLATE_TILE_WALL.getDefaultInstance(), DEEPSLATE_PRESSURE_PLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(DEEPSLATE_PRESSURE_PLATE.get().getDefaultInstance(), DEEPSLATE_BUTTON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.put(GLASS_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(GLASS_DOOR.get().getDefaultInstance(), GLASS_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.put(SOUL_GLASS_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SOUL_GLASS_DOOR.get().getDefaultInstance(), SOUL_GLASS_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.NETHERITE_BLOCK.getDefaultInstance(), NETHERITE_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERITE_DOOR.get().getDefaultInstance(), NETHERITE_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.NETHER_BRICK_FENCE.getDefaultInstance(), NETHERBRICK_FENCE_GATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERBRICK_FENCE_GATE.get().getDefaultInstance(), NETHERBRICK_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERBRICK_DOOR.get().getDefaultInstance(), NETHERBRICK_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.BONE_BLOCK.getDefaultInstance(), BONE_DOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_DOOR.get().getDefaultInstance(), BONE_TRAPDOOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_TRAPDOOR.get().getDefaultInstance(), FLESH_BLOCK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_BLOCK.get().getDefaultInstance(), FLESH_CARPET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_CARPET.get().getDefaultInstance(), GUNPOWDER_BLOCK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(GUNPOWDER_BLOCK.get().getDefaultInstance(), ENDER_BLOCK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_BLOCK.get().getDefaultInstance(), BLAZE_BLOCK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.EMERALD_BLOCK.getDefaultInstance(), RUBY_BLOCK.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		if (ModCompats.QUARK_INSTALLED) {
    			map.putAfter(NETHERWOOD_SLAB.get().getDefaultInstance(), NETHERWOOD_VERTICAL_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(SMOOTH_BASALT_SLAB.get().getDefaultInstance(), SMOOTH_BASALT_VERTICAL_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(QUARTZ_BRICK_SLAB.get().getDefaultInstance(), QUARTZ_BRICK_VERTICAL_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.putAfter(BEDROCK_BRICK_SLAB.get().getDefaultInstance(), BEDROCK_BRICK_VERTICAL_SLAB.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			
    			map.putAfter(NETHERWOOD_PLANKS.get().getDefaultInstance(), VERTICAL_NETHERWOOD_PLANKS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_POST.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(STRIPPED_NETHERWOOD_POST.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_LEAF_CARPET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_HEDGE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModCompats.WOODWORKS_INSTALLED) {
    			map.put(NETHERWOOD_BOARDS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_LEAF_PILE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
    		map.putAfter(Items.GLASS.getDefaultInstance(), SOUL_GLASS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.GLASS_PANE.getDefaultInstance(), SOUL_GLASS_PANE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);    		
    	}
    	if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
    		map.putAfter(Items.DEEPSLATE_EMERALD_ORE.getDefaultInstance(), RUBY_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_ORE.get().getDefaultInstance(), DEEPSLATE_RUBY_ORE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.WARPED_STEM.getDefaultInstance(), NETHERWOOD_LOG.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CHERRY_SAPLING.getDefaultInstance(), NETHERWOOD_SAPLING.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    		if (!ModCompats.CLAYWORKS_INSTALLED) {
    			map.putAfter(Items.BLAST_FURNACE.getDefaultInstance(), KILN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		map.putAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), NETHERWOOD_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_SIGN.get().getDefaultInstance(), NETHERWOOD_HANGING_SIGN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.REDSTONE_TORCH.getDefaultInstance(), GLOW_INK_TORCH.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(GLOW_INK_TORCH.get().getDefaultInstance(), GLOWSTONE_TORCH.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.SOUL_LANTERN.getDefaultInstance(), GLOWSTONE_LANTERN.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DRAGON_HEAD.getDefaultInstance(), WARDEN_HEAD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.LADDER.getDefaultInstance(), BONE_LADDER.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CHEST.getDefaultInstance(), NETHERWOOD_CHEST.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		if (ModList.get().isLoaded("charm")) {
    			map.put(NETHERWOOD_CRATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_BOOKCASE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_BARREL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    		if (ModCompats.QUARK_INSTALLED || ModCompats.WOODWORKS_INSTALLED) {
    			map.put(NETHERWOOD_BOOKSHELF.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    			map.put(NETHERWOOD_LADDER.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
    		map.putAfter(Items.TRAPPED_CHEST.getDefaultInstance(), NETHERWOOD_TRAPPED_CHEST.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
    		map.putAfter(Items.STONE_HOE.getDefaultInstance(), COPPER_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_SHOVEL.get().getDefaultInstance(), COPPER_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_PICKAXE.get().getDefaultInstance(), COPPER_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_AXE.get().getDefaultInstance(), COPPER_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.NETHERITE_HOE.getDefaultInstance(), BONE_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_SHOVEL.get().getDefaultInstance(), BONE_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_PICKAXE.get().getDefaultInstance(), BONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_AXE.get().getDefaultInstance(), BONE_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_HOE.get().getDefaultInstance(), WITHERBONE_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_SHOVEL.get().getDefaultInstance(), WITHERBONE_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_PICKAXE.get().getDefaultInstance(), WITHERBONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_AXE.get().getDefaultInstance(), WITHERBONE_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_HOE.get().getDefaultInstance(), NETHERRACK_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_SHOVEL.get().getDefaultInstance(), NETHERRACK_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_PICKAXE.get().getDefaultInstance(), NETHERRACK_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_AXE.get().getDefaultInstance(), NETHERRACK_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_HOE.get().getDefaultInstance(), ENDSTONE_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_SHOVEL.get().getDefaultInstance(), ENDSTONE_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_PICKAXE.get().getDefaultInstance(), ENDSTONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_AXE.get().getDefaultInstance(), ENDSTONE_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_HOE.get().getDefaultInstance(), EMERALD_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_SHOVEL.get().getDefaultInstance(), EMERALD_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_PICKAXE.get().getDefaultInstance(), EMERALD_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_AXE.get().getDefaultInstance(), EMERALD_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_HOE.get().getDefaultInstance(), RUBY_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_SHOVEL.get().getDefaultInstance(), RUBY_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_PICKAXE.get().getDefaultInstance(), RUBY_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_AXE.get().getDefaultInstance(), RUBY_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_HOE.get().getDefaultInstance(), OBSIDIAN_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_SHOVEL.get().getDefaultInstance(), OBSIDIAN_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_PICKAXE.get().getDefaultInstance(), OBSIDIAN_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_AXE.get().getDefaultInstance(), OBSIDIAN_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_HOE.get().getDefaultInstance(), BLAZE_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_SHOVEL.get().getDefaultInstance(), BLAZE_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_PICKAXE.get().getDefaultInstance(), BLAZE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_AXE.get().getDefaultInstance(), BLAZE_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_HOE.get().getDefaultInstance(), ENDER_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_SHOVEL.get().getDefaultInstance(), ENDER_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_PICKAXE.get().getDefaultInstance(), ENDER_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_AXE.get().getDefaultInstance(), ENDER_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_HOE.get().getDefaultInstance(), BEDROCK_SHOVEL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_SHOVEL.get().getDefaultInstance(), BEDROCK_PICKAXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_PICKAXE.get().getDefaultInstance(), BEDROCK_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_AXE.get().getDefaultInstance(), BEDROCK_HOE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.BAMBOO_CHEST_RAFT.getDefaultInstance(), CRIMSON_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CRIMSON_BOAT.get().getDefaultInstance(), CRIMSON_CHEST_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CRIMSON_CHEST_BOAT.get().getDefaultInstance(), WARPED_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WARPED_BOAT.get().getDefaultInstance(), WARPED_CHEST_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WARPED_CHEST_BOAT.get().getDefaultInstance(), NETHERWOOD_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERWOOD_BOAT.get().getDefaultInstance(), NETHERWOOD_CHEST_BOAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.COMBAT) {
    		map.putAfter(Items.STONE_SWORD.getDefaultInstance(), COPPER_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.NETHERITE_SWORD.getDefaultInstance(), BONE_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_SWORD.get().getDefaultInstance(), WITHERBONE_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_SWORD.get().getDefaultInstance(), NETHERRACK_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_SWORD.get().getDefaultInstance(), ENDSTONE_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_SWORD.get().getDefaultInstance(), EMERALD_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_SWORD.get().getDefaultInstance(), RUBY_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_SWORD.get().getDefaultInstance(), OBSIDIAN_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_SWORD.get().getDefaultInstance(), BLAZE_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_SWORD.get().getDefaultInstance(), ENDER_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_SWORD.get().getDefaultInstance(), BEDROCK_SWORD.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.STONE_AXE.getDefaultInstance(), COPPER_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.NETHERITE_AXE.getDefaultInstance(), BONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_AXE.get().getDefaultInstance(), WITHERBONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_AXE.get().getDefaultInstance(), NETHERRACK_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERRACK_AXE.get().getDefaultInstance(), ENDSTONE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDSTONE_AXE.get().getDefaultInstance(), EMERALD_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_AXE.get().getDefaultInstance(), RUBY_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_AXE.get().getDefaultInstance(), OBSIDIAN_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_AXE.get().getDefaultInstance(), BLAZE_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BLAZE_AXE.get().getDefaultInstance(), ENDER_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDER_AXE.get().getDefaultInstance(), BEDROCK_AXE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.LEATHER_BOOTS.getDefaultInstance(), WOOL_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WOOL_HELMET.get().getDefaultInstance(), WOOL_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WOOL_CHESTPLATE.get().getDefaultInstance(), WOOL_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WOOL_LEGGINGS.get().getDefaultInstance(), WOOL_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CHAINMAIL_BOOTS.getDefaultInstance(), COPPER_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_HELMET.get().getDefaultInstance(), COPPER_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_CHESTPLATE.get().getDefaultInstance(), COPPER_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COPPER_LEGGINGS.get().getDefaultInstance(), COPPER_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.TURTLE_HELMET.getDefaultInstance(), EMERALD_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_HELMET.get().getDefaultInstance(), EMERALD_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_CHESTPLATE.get().getDefaultInstance(), EMERALD_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_LEGGINGS.get().getDefaultInstance(), EMERALD_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_BOOTS.get().getDefaultInstance(), RUBY_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_HELMET.get().getDefaultInstance(), RUBY_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_CHESTPLATE.get().getDefaultInstance(), RUBY_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_LEGGINGS.get().getDefaultInstance(), RUBY_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_BOOTS.get().getDefaultInstance(), OBSIDIAN_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_HELMET.get().getDefaultInstance(), OBSIDIAN_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_CHESTPLATE.get().getDefaultInstance(), OBSIDIAN_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_LEGGINGS.get().getDefaultInstance(), OBSIDIAN_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_BOOTS.get().getDefaultInstance(), FLESH_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_HELMET.get().getDefaultInstance(), FLESH_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_CHESTPLATE.get().getDefaultInstance(), FLESH_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_LEGGINGS.get().getDefaultInstance(), FLESH_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FLESH_BOOTS.get().getDefaultInstance(), SPIDERSILK_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SPIDERSILK_HELMET.get().getDefaultInstance(), SPIDERSILK_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SPIDERSILK_CHESTPLATE.get().getDefaultInstance(), SPIDERSILK_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SPIDERSILK_LEGGINGS.get().getDefaultInstance(), SPIDERSILK_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SPIDERSILK_BOOTS.get().getDefaultInstance(), BONE_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_HELMET.get().getDefaultInstance(), BONE_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_CHESTPLATE.get().getDefaultInstance(), BONE_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_LEGGINGS.get().getDefaultInstance(), BONE_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONE_BOOTS.get().getDefaultInstance(), BONELORD_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONELORD_HELMET.get().getDefaultInstance(), BONELORD_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONELORD_CHESTPLATE.get().getDefaultInstance(), BONELORD_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONELORD_LEGGINGS.get().getDefaultInstance(), BONELORD_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BONELORD_BOOTS.get().getDefaultInstance(), WITHERBONE_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_HELMET.get().getDefaultInstance(), WITHERBONE_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_CHESTPLATE.get().getDefaultInstance(), WITHERBONE_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_LEGGINGS.get().getDefaultInstance(), WITHERBONE_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WITHERBONE_BOOTS.get().getDefaultInstance(), ENDERDRAGON_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDERDRAGON_HELMET.get().getDefaultInstance(), ENDERDRAGON_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDERDRAGON_CHESTPLATE.get().getDefaultInstance(), ENDERDRAGON_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDERDRAGON_LEGGINGS.get().getDefaultInstance(), ENDERDRAGON_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDERDRAGON_BOOTS.get().getDefaultInstance(), WINGED_ENDERDRAGON_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(WINGED_ENDERDRAGON_CHESTPLATE.get().getDefaultInstance(), BEDROCK_HELMET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_HELMET.get().getDefaultInstance(), BEDROCK_CHESTPLATE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_CHESTPLATE.get().getDefaultInstance(), BEDROCK_LEGGINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEDROCK_LEGGINGS.get().getDefaultInstance(), BEDROCK_BOOTS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putBefore(Items.IRON_HORSE_ARMOR.getDefaultInstance(), COPPER_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.DIAMOND_HORSE_ARMOR.getDefaultInstance(), NETHERITE_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(NETHERITE_HORSE_ARMOR.get().getDefaultInstance(), EMERALD_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(EMERALD_HORSE_ARMOR.get().getDefaultInstance(), RUBY_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RUBY_HORSE_ARMOR.get().getDefaultInstance(), OBSIDIAN_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(OBSIDIAN_HORSE_ARMOR.get().getDefaultInstance(), BONE_HORSE_ARMOR.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
    		map.putAfter(Items.COOKED_MUTTON.getDefaultInstance(), RAW_CHEVON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RAW_CHEVON.get().getDefaultInstance(), COOKED_CHEVON.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COOKED_CHEVON.get().getDefaultInstance(), RAW_FROG_LEGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RAW_FROG_LEGS.get().getDefaultInstance(), COOKED_FROG_LEGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COOKED_FROG_LEGS.get().getDefaultInstance(), RAW_SPIDER.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RAW_SPIDER.get().getDefaultInstance(), COOKED_SPIDER.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COOKED_SPIDER.get().getDefaultInstance(), RAW_GUARDIAN_MEAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RAW_GUARDIAN_MEAT.get().getDefaultInstance(), COOKED_GUARDIAN_MEAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(COOKED_GUARDIAN_MEAT.get().getDefaultInstance(), RAW_DRAGON_MEAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(RAW_DRAGON_MEAT.get().getDefaultInstance(), COOKED_DRAGON_MEAT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.ROTTEN_FLESH.getDefaultInstance(), COOKED_FLESH.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.RABBIT_STEW.getDefaultInstance(), BEEF_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(BEEF_STEW.get().getDefaultInstance(), PORK_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(PORK_STEW.get().getDefaultInstance(), CHICKEN_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CHICKEN_STEW.get().getDefaultInstance(), CHEVON_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(CHEVON_STEW.get().getDefaultInstance(), SPIDER_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SPIDER_STEW.get().getDefaultInstance(), FISH_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(FISH_STEW.get().getDefaultInstance(), GUARDIAN_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(GUARDIAN_STEW.get().getDefaultInstance(), DRAGON_STEW.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.CAKE.getDefaultInstance(), CAKE_SLICE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.APPLE.getDefaultInstance(), NETHER_APPLE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.PUMPKIN_PIE.getDefaultInstance(), SWEETBERRY_PIE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(SWEETBERRY_PIE.get().getDefaultInstance(), APPLE_PIE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(APPLE_PIE.get().getDefaultInstance(), NETHER_APPLE_PIE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    	if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
    		map.putAfter(Items.DISC_FRAGMENT_5.getDefaultInstance(), PATINA.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putBefore(Items.IRON_NUGGET.getDefaultInstance(), COPPER_NUGGET.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.EMERALD.getDefaultInstance(), RUBY.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.BONE.getDefaultInstance(), WITHER_BONE.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.BONE_MEAL.getDefaultInstance(), WITHER_BONE_MEAL.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.RABBIT_HIDE.getDefaultInstance(), ENDERDRAGON_SCALES.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(ENDERDRAGON_SCALES.get().getDefaultInstance(), ENDER_DRAGON_WINGS.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		map.putAfter(Items.BOOK.getDefaultInstance(), ELYTRA_BLUEPRINT.get().getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    }
	
}
