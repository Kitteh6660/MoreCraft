package kittehmod.morecraft.block;

import java.util.function.ToIntFunction;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.addons.ModBarrelBlock;
import kittehmod.morecraft.block.addons.ModBookcaseBlock;
import kittehmod.morecraft.block.addons.ModCrateBlock;
import kittehmod.morecraft.block.addons.ModHedgeBlock;
import kittehmod.morecraft.block.addons.ModPostBlock;
import kittehmod.morecraft.block.addons.ModTallDoorBlock;
import kittehmod.morecraft.block.addons.ModVerticalSlabBlock;
import kittehmod.morecraft.blockentity.ModBlockEntityType;
import kittehmod.morecraft.worldgen.NetherwoodTree;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreCraft.MODID);
	
	//--LIST OF BLOCKS--\\
	//The Missing Stairs, Slabs, and Walls, most vanilla-like
    public static final RegistryObject<Block> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new ModStairsBlock(Blocks.TUFF.defaultBlockState(), Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));    
    
    public static final RegistryObject<Block> CALCITE_STAIRS = BLOCKS.register("calcite_stairs", () -> new ModStairsBlock(Blocks.CALCITE.defaultBlockState(), Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = BLOCKS.register("calcite_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = BLOCKS.register("calcite_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));    

    public static final RegistryObject<Block> DRIPSTONE_STAIRS = BLOCKS.register("dripstone_stairs", () -> new ModStairsBlock(Blocks.DRIPSTONE_BLOCK.defaultBlockState(), Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_SLAB = BLOCKS.register("dripstone_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_WALL = BLOCKS.register("dripstone_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));    

    public static final RegistryObject<Block> SMOOTH_BASALT_STAIRS = BLOCKS.register("smooth_basalt_stairs", () -> new ModStairsBlock(Blocks.SMOOTH_BASALT.defaultBlockState(), Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_SLAB = BLOCKS.register("smooth_basalt_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_WALL = BLOCKS.register("smooth_basalt_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));    

    //Doors & Gates
    public static final RegistryObject<Block> NETHERBRICK_DOOR = BLOCKS.register("netherbrick_door", () -> new DoorBlock(Block.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.STONE).noOcclusion())); 
	public static final RegistryObject<Block> NETHERWOOD_DOOR = BLOCKS.register("netherwood_door", () -> new DoorBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> NETHERITE_DOOR = BLOCKS.register("netherite_door", () -> new DoorBlock(Block.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> GLASS_DOOR = BLOCKS.register("glass_door", () -> new DoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> SOUL_GLASS_DOOR = BLOCKS.register("soul_glass_door", () -> new DoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> BONE_DOOR = BLOCKS.register("bone_door", () -> new DoorBlock(Block.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.STONE).noOcclusion()));
    public static final RegistryObject<Block> NETHERBRICK_TRAPDOOR = BLOCKS.register("netherbrick_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_TRAPDOOR = BLOCKS.register("netherwood_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> NETHERITE_TRAPDOOR = BLOCKS.register("netherite_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GLASS_TRAPDOOR = BLOCKS.register("glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> SOUL_GLASS_TRAPDOOR = BLOCKS.register("soul_glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BONE_TRAPDOOR = BLOCKS.register("bone_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> NETHERBRICK_FENCE_GATE = BLOCKS.register("netherbrick_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.STONE).strength(3.0F, 8.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE_GATE = BLOCKS.register("netherwood_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).strength(2.5F, 4.0F).sound(SoundType.WOOD)));

    //Ores
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
   
    //Storage Blocks
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", () -> new Block(Block.Properties.of(Material.PLANT).strength(1.0F, 1.0F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLAZE_BLOCK = BLOCKS.register("blaze_block", () -> new BlazeBlock(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> ENDER_BLOCK = BLOCKS.register("ender_block", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GUNPOWDER_BLOCK = BLOCKS.register("gunpowder_block", () -> new GunpowderBlock(Block.Properties.of(Material.SAND).strength(0.5F, 2.0F).sound(SoundType.SAND)));
    
    //Netherwood
    public static final RegistryObject<Block> NETHERWOOD_LOG = BLOCKS.register("netherwood_log", () -> new ModLogBlock(Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_LOG = BLOCKS.register("stripped_netherwood_log", () -> new RotatedPillarBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_WOOD = BLOCKS.register("netherwood_wood", () -> new ModLogBlock(Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_WOOD = BLOCKS.register("stripped_netherwood_wood", () -> new RotatedPillarBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PLANKS = BLOCKS.register("netherwood_planks", () -> new Block(Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_LEAVES = BLOCKS.register("netherwood_leaves", () -> new ModLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F, 1.0F).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_SAPLING = BLOCKS.register("netherwood_sapling", () -> new NetherSaplingBlock(new NetherwoodTree(), Block.Properties.of(Material.PLANT).sound(SoundType.WOOD).noCollission().randomTicks().instabreak()));
    public static final RegistryObject<Block> NETHERWOOD_STAIRS = BLOCKS.register("netherwood_stairs", () -> new ModStairsBlock(NETHERWOOD_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SLAB = BLOCKS.register("netherwood_slab", () -> new SlabBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_CHEST = BLOCKS.register("netherwood_chest", () -> new ModChestBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F, 6.0F).sound(SoundType.WOOD), () -> { return ModBlockEntityType.NETHERWOOD_CHEST.get(); }));
    public static final RegistryObject<Block> NETHERWOOD_CHEST_TRAPPED = BLOCKS.register("netherwood_trapped_chest", () -> new ModTrappedChestBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_BOOKSHELF = BLOCKS.register("netherwood_bookshelf", () -> new ModBookshelfBlock(Block.Properties.of(Material.NETHER_WOOD).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE = BLOCKS.register("netherwood_fence", () -> new FenceBlock(Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SIGN = BLOCKS.register("netherwood_sign", () -> new ModStandingSignBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_WALL_SIGN = BLOCKS.register("netherwood_wall_sign", () -> new ModWallSignBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BUTTON = BLOCKS.register("netherwood_button", () -> new WoodButtonBlock(Block.Properties.of(Material.NETHER_WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PRESSURE_PLATE = BLOCKS.register("netherwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.NETHER_WOOD, NETHERWOOD_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    //Others
    public static final RegistryObject<Block> SOUL_GLASS = BLOCKS.register("soul_glass", () -> new GlassBlock(Block.Properties.of(Material.GLASS).strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> SOUL_GLASS_PANE = BLOCKS.register("soul_glass_pane", () -> new IronBarsBlock(Block.Properties.of(Material.GLASS).strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> FLESH_CARPET = BLOCKS.register("flesh_carpet", () -> new CarpetBlock(Block.Properties.of(Material.CLOTH_DECORATION).strength(0.5F, 1.0F).sound(SoundType.NETHER_WART)));
    public static final RegistryObject<Block> BONE_LADDER = BLOCKS.register("bone_ladder", () -> new LadderBlock(Block.Properties.of(Material.STONE).strength(1.0F, 3.0F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> GLOW_INK_TORCH = BLOCKS.register("glow_ink_torch", () -> new WaterloggableTorchBlock(Block.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 10; })));
    public static final RegistryObject<Block> WALL_GLOW_INK_TORCH = BLOCKS.register("wall_glow_ink_torch", () -> new WaterloggableWallTorchBlock(Block.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 10; })));
    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch", () -> new WaterloggableTorchBlock(Block.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> WALL_GLOWSTONE_TORCH = BLOCKS.register("wall_glowstone_torch", () -> new WaterloggableWallTorchBlock(Block.Properties.of(Material.WOOD).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
	public static final RegistryObject<Block> GLOWSTONE_LANTERN = BLOCKS.register("glowstone_lantern", () -> new LanternBlock(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235447_0_) -> { return 15; }).noOcclusion()));    
	public static final RegistryObject<Block> BEDROCK_BRICK = BLOCKS.register("bedrock_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_STAIRS = BLOCKS.register("bedrock_brick_stairs", () -> new ModStairsBlock(BEDROCK_BRICK.get().defaultBlockState(), Block.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_SLAB = BLOCKS.register("bedrock_brick_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_WALL = BLOCKS.register("bedrock_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
    public static final RegistryObject<Block> KILN = BLOCKS.register("kiln", () -> new KilnBlock(Block.Properties.of(Material.STONE).strength(3.5F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(litBlockEmission(13))));
	public static final RegistryObject<Block> POTTED_NETHERWOOD_SAPLING = BLOCKS.register("potted_netherwood_sapling", () -> new FlowerPotBlock(null, () -> { return NETHERWOOD_SAPLING.get(); }, Block.Properties.of(Material.PLANT).strength(0.0F)));
    public static final RegistryObject<Block> DEEPSLATE_BUTTON = BLOCKS.register("deepslate_button", () -> new StoneButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F)));
    public static final RegistryObject<Block> DEEPSLATE_PRESSURE_PLATE = BLOCKS.register("deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.of(Material.STONE, Blocks.POLISHED_DEEPSLATE.defaultMaterialColor()).noCollission().strength(0.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WARDEN_HEAD = BLOCKS.register("warden_head", () -> new WardenHeadBlock(Block.Properties.of(Material.SCULK).strength(1.0F, 3.0F).sound(SoundType.SCULK).noOcclusion()));
    public static final RegistryObject<Block> WARDEN_WALL_HEAD = BLOCKS.register("warden_wall_head", () -> new WallWardenHeadBlock(Block.Properties.of(Material.SCULK).strength(1.0F, 3.0F).sound(SoundType.SCULK).noOcclusion()));

    //Quark
    public static final RegistryObject<Block> NETHERWOOD_LADDER = BLOCKS.register("netherwood_ladder", () -> new LadderBlock(Block.Properties.of(Material.NETHER_WOOD).strength(0.4F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> VERTICAL_NETHERWOOD_PLANKS = ModBlocks.BLOCKS.register("vertical_netherwood_planks", () -> new Block(Block.Properties.of(Material.NETHER_WOOD).strength(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_VERTICAL_SLAB = ModBlocks.BLOCKS.register("netherwood_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_POST = ModBlocks.BLOCKS.register("netherwood_post", () -> new ModPostBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_POST = ModBlocks.BLOCKS.register("stripped_netherwood_post", () -> new ModPostBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_HEDGE = ModBlocks.BLOCKS.register("netherwood_hedge", () -> new ModHedgeBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> NETHERWOOD_LEAF_CARPET = BLOCKS.register("netherwood_leaf_carpet", () -> new CarpetBlock(Block.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> BEDROCK_BRICK_VERTICAL_SLAB = ModBlocks.BLOCKS.register("bedrock_brick_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_VERTICAL_SLAB = ModBlocks.BLOCKS.register("smooth_basalt_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    
    //Charm
    public static final RegistryObject<Block> NETHERWOOD_CRATE = ModBlocks.BLOCKS.register("netherwood_crate", () -> new ModCrateBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BOOKCASE = ModBlocks.BLOCKS.register("netherwood_bookcase", () -> new ModBookcaseBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BARREL = ModBlocks.BLOCKS.register("netherwood_barrel", () -> new ModBarrelBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    
    //Buzzier Bees
    public static final RegistryObject<Block> NETHERWOOD_BEEHIVE = ModBlocks.BLOCKS.register("netherwood_beehive", () -> new BeehiveBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    
    //Dramatic Doors
    public static final RegistryObject<Block> TALL_NETHERBRICK_DOOR = BLOCKS.register("tall_netherbrick_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.STONE).strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion())); 
	public static final RegistryObject<Block> TALL_NETHERWOOD_DOOR = BLOCKS.register("tall_netherwood_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.WOOD).strength(2.5F, 4.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> TALL_NETHERITE_DOOR = BLOCKS.register("tall_netherite_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.METAL).strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> TALL_GLASS_DOOR = BLOCKS.register("tall_glass_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> TALL_SOUL_GLASS_DOOR = BLOCKS.register("tall_soul_glass_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.GLASS).strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> TALL_BONE_DOOR = BLOCKS.register("tall_bone_door", () -> new ModTallDoorBlock(Block.Properties.of(Material.STONE).strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion()));
	
	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return (blockState) -> {
			return blockState.getValue(BlockStateProperties.LIT) ? lightValue : 0;
		};
   }
	
}
