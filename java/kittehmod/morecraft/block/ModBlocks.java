package kittehmod.morecraft.block;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.addons.ModBarrelBlock;
import kittehmod.morecraft.block.addons.ModBookcaseBlock;
import kittehmod.morecraft.block.addons.ModCrateBlock;
import kittehmod.morecraft.block.addons.ModHedgeBlock;
import kittehmod.morecraft.block.addons.ModPostBlock;
import kittehmod.morecraft.block.addons.ModTallDoorBlock;
import kittehmod.morecraft.block.addons.ModVerticalSlabBlock;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import kittehmod.morecraft.worldgen.NetherwoodTree;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreCraft.MODID);
	
	//--LIST OF BLOCKS--\\
    //Doors & Gates
    public static final RegistryObject<Block> NETHERBRICK_DOOR = BLOCKS.register("netherbrick_door", () -> new ModDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion())); 
	public static final RegistryObject<Block> NETHERWOOD_DOOR = BLOCKS.register("netherwood_door", () -> new ModDoorBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> NETHERITE_DOOR = BLOCKS.register("netherite_door", () -> new ModDoorBlock(AbstractBlock.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3)));
	public static final RegistryObject<Block> GLASS_DOOR = BLOCKS.register("glass_door", () -> new ModDoorBlock(AbstractBlock.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> BONE_DOOR = BLOCKS.register("bone_door", () -> new ModDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> NETHERBRICK_TRAPDOOR = BLOCKS.register("netherbrick_trapdoor", () -> new ModTrapDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_TRAPDOOR = BLOCKS.register("netherwood_trapdoor", () -> new ModTrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> NETHERITE_TRAPDOOR = BLOCKS.register("netherite_trapdoor", () -> new ModTrapDoorBlock(AbstractBlock.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<Block> GLASS_TRAPDOOR = BLOCKS.register("glass_trapdoor", () -> new ModTrapDoorBlock(AbstractBlock.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BONE_TRAPDOOR = BLOCKS.register("bone_trapdoor", () -> new ModTrapDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> NETHERBRICK_FENCE_GATE = BLOCKS.register("netherbrick_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.STONE).strength(3.0F, 8.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE_GATE = BLOCKS.register("netherwood_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK)));

    //Ores
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().harvestLevel(2).strength(3.0F, 3.0F)));
   
    //Storage Blocks
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", () -> new Block(AbstractBlock.Properties.of(Material.PLANT).strength(1.0F, 1.0F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLAZE_BLOCK = BLOCKS.register("blaze_block", () -> new BlazeBlock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> ENDER_BLOCK = BLOCKS.register("ender_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(2.5F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GUNPOWDER_BLOCK = BLOCKS.register("gunpowder_block", () -> new GunpowderBlock(AbstractBlock.Properties.of(Material.SAND).strength(0.5F, 2.0F).sound(SoundType.SAND)));
    
    //Netherwood
    public static final RegistryObject<Block> NETHERWOOD_LOG = BLOCKS.register("netherwood_log", () -> new ModLogBlock(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_LOG = BLOCKS.register("stripped_netherwood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_PURPLE).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_WOOD = BLOCKS.register("netherwood_wood", () -> new ModLogBlock(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_WOOD = BLOCKS.register("stripped_netherwood_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_PURPLE).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PLANKS = BLOCKS.register("netherwood_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_LEAVES = BLOCKS.register("netherwood_leaves", () -> new ModLeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).harvestTool(ToolType.HOE).strength(0.2F, 1.0F).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_SAPLING = BLOCKS.register("netherwood_sapling", () -> new NetherSaplingBlock(new NetherwoodTree(), AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.WOOD).noCollission().randomTicks().instabreak()));
    public static final RegistryObject<Block> NETHERWOOD_STAIRS = BLOCKS.register("netherwood_stairs", () -> new ModStairsBlock(NETHERWOOD_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SLAB = BLOCKS.register("netherwood_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_CHEST = BLOCKS.register("netherwood_chest", () -> new ModChestBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(2.5F, 6.0F).sound(SoundType.WOOD), () -> { return ModTileEntityType.NETHERWOOD_CHEST.get(); }));
    public static final RegistryObject<Block> NETHERWOOD_CHEST_TRAPPED = BLOCKS.register("netherwood_trapped_chest", () -> new ModTrappedChestBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(2.5F, 6.0F).sound(SoundType.WOOD), () -> { return ModTileEntityType.NETHERWOOD_TRAPPED_CHEST.get(); }));
    public static final RegistryObject<Block> NETHERWOOD_BOOKSHELF = BLOCKS.register("netherwood_bookshelf", () -> new ModBookshelfBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE = BLOCKS.register("netherwood_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SIGN = BLOCKS.register("netherwood_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_WALL_SIGN = BLOCKS.register("netherwood_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BUTTON = BLOCKS.register("netherwood_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PRESSURE_PLATE = BLOCKS.register("netherwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, NETHERWOOD_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    //Crafting Tables
    public static final RegistryObject<Block> SPRUCE_CRAFTING_TABLE = BLOCKS.register("spruce_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_CRAFTING_TABLE = BLOCKS.register("birch_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_CRAFTING_TABLE = BLOCKS.register("jungle_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_CRAFTING_TABLE = BLOCKS.register("acacia_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_CRAFTING_TABLE = BLOCKS.register("dark_oak_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_CRAFTING_TABLE = BLOCKS.register("crimson_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_CRAFTING_TABLE = BLOCKS.register("warped_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_CRAFTING_TABLE = BLOCKS.register("netherwood_crafting_table", () -> new ModCraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    //Others
    public static final RegistryObject<Block> SOUL_GLASS = BLOCKS.register("soul_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> SOUL_GLASS_PANE = BLOCKS.register("soul_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> FLESH_CARPET = BLOCKS.register("flesh_carpet", () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.of(Material.CLOTH_DECORATION).strength(0.5F, 1.0F).sound(SoundType.NETHER_WART)));
    public static final RegistryObject<Block> BONE_LADDER = BLOCKS.register("bone_ladder", () -> new LadderBlock(AbstractBlock.Properties.of(Material.STONE).strength(1.0F, 3.0F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch", () -> new GlowstoneTorchBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> WALL_GLOWSTONE_TORCH = BLOCKS.register("wall_glowstone_torch", () -> new GlowstoneWallTorchBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
	public static final RegistryObject<Block> GLOWSTONE_LANTERN = BLOCKS.register("glowstone_lantern", () -> new LanternBlock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235447_0_) -> { return 15; }).noOcclusion()));    
	public static final RegistryObject<Block> BEDROCK_BRICK = BLOCKS.register("bedrock_brick", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_STAIRS = BLOCKS.register("bedrock_brick_stairs", () -> new ModStairsBlock(BEDROCK_BRICK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_SLAB = BLOCKS.register("bedrock_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_WALL = BLOCKS.register("bedrock_brick_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
    public static final RegistryObject<Block> KILN = BLOCKS.register("kiln", () -> new KilnBlock(AbstractBlock.Properties.of(Material.STONE).strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    @SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_NETHERWOOD_SAPLING = BLOCKS.register("potted_netherwood_sapling", () -> new FlowerPotBlock(NETHERWOOD_SAPLING.get(), AbstractBlock.Properties.of(Material.PLANT).strength(0.0F)));

    //--MOD ADDONS--\\
    //Quark
    public static final RegistryObject<Block> NETHERWOOD_LADDER = BLOCKS.register("netherwood_ladder", () -> new LadderBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(0.4F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> VERTICAL_NETHERWOOD_PLANKS = ModBlocks.BLOCKS.register("vertical_netherwood_planks", () -> new Block(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_VERTICAL_SLAB = ModBlocks.BLOCKS.register("netherwood_vertical_slab", () -> new ModVerticalSlabBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_POST = ModBlocks.BLOCKS.register("netherwood_post", () -> new ModPostBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_POST = ModBlocks.BLOCKS.register("stripped_netherwood_post", () -> new ModPostBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_HEDGE = ModBlocks.BLOCKS.register("netherwood_hedge", () -> new ModHedgeBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> NETHERWOOD_LEAF_CARPET = BLOCKS.register("netherwood_leaf_carpet", () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).harvestTool(ToolType.HOE).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BEDROCK_BRICK_VERTICAL_SLAB = ModBlocks.BLOCKS.register("bedrock_brick_vertical_slab", () -> new ModVerticalSlabBlock(AbstractBlock.Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).sound(SoundType.STONE)));

    //Charm
    public static final RegistryObject<Block> NETHERWOOD_CRATE = ModBlocks.BLOCKS.register("netherwood_crate", () -> new ModCrateBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BOOKCASE = ModBlocks.BLOCKS.register("netherwood_bookcase", () -> new ModBookcaseBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BARREL = ModBlocks.BLOCKS.register("netherwood_barrel", () -> new ModBarrelBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));

    //Buzzier Bees
    public static final RegistryObject<Block> NETHERWOOD_BEEHIVE = ModBlocks.BLOCKS.register("netherwood_beehive", () -> new BeehiveBlock(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).harvestTool(ToolType.AXE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    
    //Dramatic Doors
    public static final RegistryObject<Block> TALL_NETHERBRICK_DOOR = BLOCKS.register("tall_netherbrick_door", () -> new ModTallDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion())); 
	public static final RegistryObject<Block> TALL_NETHERWOOD_DOOR = BLOCKS.register("tall_netherwood_door", () -> new ModTallDoorBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> TALL_NETHERITE_DOOR = BLOCKS.register("tall_netherite_door", () -> new ModTallDoorBlock(AbstractBlock.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3)));
	public static final RegistryObject<Block> TALL_GLASS_DOOR = BLOCKS.register("tall_glass_door", () -> new ModTallDoorBlock(AbstractBlock.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> TALL_BONE_DOOR = BLOCKS.register("tall_bone_door", () -> new ModTallDoorBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion()));

    
	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(MoreCraft.MODID, name));
		}

		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
		
	    @SubscribeEvent
	    public static void registerBlocks(final RegistryEvent.Register<Block> event) { 
	    	event.getRegistry().registerAll();
	    }
	    
	    @SubscribeEvent
	    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
