package kittehmod.morecraft.init;

import java.util.function.ToIntFunction;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.block.BlazeBlock;
import kittehmod.morecraft.block.GunpowderBlock;
import kittehmod.morecraft.block.KilnBlock;
import kittehmod.morecraft.block.ModBlockSetType;
import kittehmod.morecraft.block.ModBookshelfBlock;
import kittehmod.morecraft.block.ModCeilingHangingSignBlock;
import kittehmod.morecraft.block.ModChestBlock;
import kittehmod.morecraft.block.ModLeavesBlock;
import kittehmod.morecraft.block.ModLogBlock;
import kittehmod.morecraft.block.ModStairsBlock;
import kittehmod.morecraft.block.ModStandingSignBlock;
import kittehmod.morecraft.block.ModTrappedChestBlock;
import kittehmod.morecraft.block.ModWallHangingSignBlock;
import kittehmod.morecraft.block.ModWallSignBlock;
import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.block.NetherSaplingBlock;
import kittehmod.morecraft.block.WallWardenHeadBlock;
import kittehmod.morecraft.block.WardenHeadBlock;
import kittehmod.morecraft.block.WaterloggableTorchBlock;
import kittehmod.morecraft.block.WaterloggableWallTorchBlock;
import kittehmod.morecraft.block.addons.ModBarrelBlock;
import kittehmod.morecraft.block.addons.ModBookcaseBlock;
import kittehmod.morecraft.block.addons.ModCrateBlock;
import kittehmod.morecraft.block.addons.ModHedgeBlock;
import kittehmod.morecraft.block.addons.ModPostBlock;
import kittehmod.morecraft.block.addons.ModVerticalSlabBlock;
import kittehmod.morecraft.worldgen.NetherwoodTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
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
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
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
    public static final RegistryObject<Block> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new ModStairsBlock(Blocks.TUFF.defaultBlockState(), Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.TUFF)));    
    
    public static final RegistryObject<Block> CALCITE_STAIRS = BLOCKS.register("calcite_stairs", () -> new ModStairsBlock(Blocks.CALCITE.defaultBlockState(), Block.Properties.of().requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = BLOCKS.register("calcite_slab", () -> new SlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = BLOCKS.register("calcite_wall", () -> new WallBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(0.75F).sound(SoundType.CALCITE)));    

    public static final RegistryObject<Block> DRIPSTONE_STAIRS = BLOCKS.register("dripstone_stairs", () -> new ModStairsBlock(Blocks.DRIPSTONE_BLOCK.defaultBlockState(), Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_SLAB = BLOCKS.register("dripstone_slab", () -> new SlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_WALL = BLOCKS.register("dripstone_wall", () -> new WallBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)));    

    public static final RegistryObject<Block> SMOOTH_BASALT_STAIRS = BLOCKS.register("smooth_basalt_stairs", () -> new ModStairsBlock(Blocks.SMOOTH_BASALT.defaultBlockState(), Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_SLAB = BLOCKS.register("smooth_basalt_slab", () -> new SlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_WALL = BLOCKS.register("smooth_basalt_wall", () -> new WallBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));    

    public static final RegistryObject<Block> QUARTZ_BRICK_STAIRS = BLOCKS.register("quartz_brick_stairs", () -> new ModStairsBlock(Blocks.QUARTZ_BRICKS.defaultBlockState(), Block.Properties.of().requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> QUARTZ_BRICK_SLAB = BLOCKS.register("quartz_brick_slab", () -> new SlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> QUARTZ_BRICK_WALL = BLOCKS.register("quartz_brick_wall", () -> new WallBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)));    
    
    //Doors & Gates
    public static final RegistryObject<Block> NETHERBRICK_DOOR = BLOCKS.register("netherbrick_door", () -> new DoorBlock(Block.Properties.of().strength(5.0F, 8.0F).sound(SoundType.STONE).noOcclusion(), BlockSetType.STONE)); 
	public static final RegistryObject<Block> NETHERWOOD_DOOR = BLOCKS.register("netherwood_door", () -> new DoorBlock(Block.Properties.of().strength(2.5F, 4.0F).sound(SoundType.NETHER_WOOD).noOcclusion(), ModBlockSetType.NETHERWOOD));
	public static final RegistryObject<Block> NETHERITE_DOOR = BLOCKS.register("netherite_door", () -> new DoorBlock(Block.Properties.of().strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops(), BlockSetType.IRON));
	public static final RegistryObject<Block> GLASS_DOOR = BLOCKS.register("glass_door", () -> new DoorBlock(Block.Properties.of().strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion(), BlockSetType.STONE));
	public static final RegistryObject<Block> SOUL_GLASS_DOOR = BLOCKS.register("soul_glass_door", () -> new DoorBlock(Block.Properties.of().strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion(), BlockSetType.STONE));
	public static final RegistryObject<Block> BONE_DOOR = BLOCKS.register("bone_door", () -> new DoorBlock(Block.Properties.of().strength(2.5F, 4.0F).sound(SoundType.STONE).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> NETHERBRICK_TRAPDOOR = BLOCKS.register("netherbrick_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(5.0F, 8.0F).sound(SoundType.NETHER_BRICKS).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> NETHERWOOD_TRAPDOOR = BLOCKS.register("netherwood_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD).noOcclusion(), ModBlockSetType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERITE_TRAPDOOR = BLOCKS.register("netherite_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(50.0F, 1200.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops(), BlockSetType.IRON));
    public static final RegistryObject<Block> GLASS_TRAPDOOR = BLOCKS.register("glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> SOUL_GLASS_TRAPDOOR = BLOCKS.register("soul_glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(1.0F, 2.0F).sound(SoundType.GLASS).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> BONE_TRAPDOOR = BLOCKS.register("bone_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(2.5F, 4.0F).sound(SoundType.BONE_BLOCK).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> NETHERBRICK_FENCE_GATE = BLOCKS.register("netherbrick_fence_gate", () -> new FenceGateBlock(Block.Properties.of().strength(3.0F, 8.0F).sound(SoundType.STONE), WoodType.CRIMSON));
    public static final RegistryObject<Block> NETHERWOOD_FENCE_GATE = BLOCKS.register("netherwood_fence_gate", () -> new FenceGateBlock(Block.Properties.of().strength(2.5F, 4.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));

    //Ores
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new DropExperienceBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new DropExperienceBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
   
    //Storage Blocks
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", () -> new Block(Block.Properties.of().strength(1.0F, 1.0F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLAZE_BLOCK = BLOCKS.register("blaze_block", () -> new BlazeBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> ENDER_BLOCK = BLOCKS.register("ender_block", () -> new Block(Block.Properties.of().requiresCorrectToolForDrops().strength(2.5F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GUNPOWDER_BLOCK = BLOCKS.register("gunpowder_block", () -> new GunpowderBlock(Block.Properties.of().strength(0.5F, 2.0F).sound(SoundType.SAND)));
    
    //Netherwood
    public static final RegistryObject<Block> NETHERWOOD_LOG = BLOCKS.register("netherwood_log", () -> new ModLogBlock(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_LOG = BLOCKS.register("stripped_netherwood_log", () -> new RotatedPillarBlock(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_WOOD = BLOCKS.register("netherwood_wood", () -> new ModLogBlock(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_WOOD = BLOCKS.register("stripped_netherwood_wood", () -> new RotatedPillarBlock(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PLANKS = BLOCKS.register("netherwood_planks", () -> new Block(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_LEAVES = BLOCKS.register("netherwood_leaves", () -> new ModLeavesBlock(Block.Properties.of().strength(0.2F, 1.0F).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_SAPLING = BLOCKS.register("netherwood_sapling", () -> new NetherSaplingBlock(new NetherwoodTreeGrower(), Block.Properties.of().sound(SoundType.NETHER_WOOD).noCollission().randomTicks().instabreak()));
    public static final RegistryObject<Block> NETHERWOOD_STAIRS = BLOCKS.register("netherwood_stairs", () -> new ModStairsBlock(NETHERWOOD_PLANKS.get().defaultBlockState(), Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SLAB = BLOCKS.register("netherwood_slab", () -> new SlabBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE = BLOCKS.register("netherwood_fence", () -> new FenceBlock(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_SIGN = BLOCKS.register("netherwood_sign", () -> new ModStandingSignBlock(Block.Properties.of().noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_WALL_SIGN = BLOCKS.register("netherwood_wall_sign", () -> new ModWallSignBlock(Block.Properties.of().noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_HANGING_SIGN = BLOCKS.register("netherwood_hanging_sign", () -> new ModCeilingHangingSignBlock(Block.Properties.of().noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_WALL_HANGING_SIGN = BLOCKS.register("netherwood_wall_hanging_sign", () -> new ModWallHangingSignBlock(Block.Properties.of().noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BUTTON = BLOCKS.register("netherwood_button", () -> new ButtonBlock(Block.Properties.of().noCollission().strength(0.5F).sound(SoundType.NETHER_WOOD), BlockSetType.CRIMSON, 30, true));
    public static final RegistryObject<Block> NETHERWOOD_PRESSURE_PLATE = BLOCKS.register("netherwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of().noCollission().strength(0.5F).sound(SoundType.NETHER_WOOD), BlockSetType.CRIMSON));

    //Others
    public static final RegistryObject<Block> SOUL_GLASS = BLOCKS.register("soul_glass", () -> new GlassBlock(Block.Properties.of().strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> SOUL_GLASS_PANE = BLOCKS.register("soul_glass_pane", () -> new IronBarsBlock(Block.Properties.of().strength(0.5F, 3.0F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> FLESH_CARPET = BLOCKS.register("flesh_carpet", () -> new CarpetBlock(Block.Properties.of().strength(0.5F, 1.0F).sound(SoundType.NETHER_WART)));
    public static final RegistryObject<Block> BONE_LADDER = BLOCKS.register("bone_ladder", () -> new LadderBlock(Block.Properties.of().strength(1.0F, 3.0F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> GLOW_INK_TORCH = BLOCKS.register("glow_ink_torch", () -> new WaterloggableTorchBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 10; })));
    public static final RegistryObject<Block> WALL_GLOW_INK_TORCH = BLOCKS.register("wall_glow_ink_torch", () -> new WaterloggableWallTorchBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 10; })));
    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch", () -> new WaterloggableTorchBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
    public static final RegistryObject<Block> WALL_GLOWSTONE_TORCH = BLOCKS.register("wall_glowstone_torch", () -> new WaterloggableWallTorchBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235464_0_) -> { return 15; })));
	public static final RegistryObject<Block> GLOWSTONE_LANTERN = BLOCKS.register("glowstone_lantern", () -> new LanternBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235447_0_) -> { return 15; }).noOcclusion()));    
	public static final RegistryObject<Block> BEDROCK_BRICK = BLOCKS.register("bedrock_brick", () -> new Block(Block.Properties.of().strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_STAIRS = BLOCKS.register("bedrock_brick_stairs", () -> new ModStairsBlock(BEDROCK_BRICK.get().defaultBlockState(), Block.Properties.of().strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_SLAB = BLOCKS.register("bedrock_brick_slab", () -> new SlabBlock(Block.Properties.of().strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
	public static final RegistryObject<Block> BEDROCK_BRICK_WALL = BLOCKS.register("bedrock_brick_wall", () -> new WallBlock(Block.Properties.of().strength(-1F, 3600000F).requiresCorrectToolForDrops().sound(SoundType.STONE)));   
    public static final RegistryObject<Block> KILN = BLOCKS.register("kiln", () -> new KilnBlock(Block.Properties.of().strength(3.5F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(litBlockEmission(13))));
	public static final RegistryObject<Block> POTTED_NETHERWOOD_SAPLING = BLOCKS.register("potted_netherwood_sapling", () -> new FlowerPotBlock(null, () -> { return NETHERWOOD_SAPLING.get(); }, Block.Properties.of().strength(0.0F)));
    public static final RegistryObject<Block> DEEPSLATE_BUTTON = BLOCKS.register("deepslate_button", () -> new ButtonBlock(Block.Properties.of().noCollission().strength(0.5F), BlockSetType.STONE, 20, false));
    public static final RegistryObject<Block> DEEPSLATE_PRESSURE_PLATE = BLOCKS.register("deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.of().noCollission().strength(0.5F).requiresCorrectToolForDrops(), BlockSetType.STONE));
    public static final RegistryObject<Block> WARDEN_HEAD = BLOCKS.register("warden_head", () -> new WardenHeadBlock(Block.Properties.of().strength(1.0F, 3.0F).sound(SoundType.SCULK).noOcclusion()));
    public static final RegistryObject<Block> WARDEN_WALL_HEAD = BLOCKS.register("warden_wall_head", () -> new WallWardenHeadBlock(Block.Properties.of().strength(1.0F, 3.0F).sound(SoundType.SCULK).noOcclusion()));

    //Quark
    public static final RegistryObject<Block> VERTICAL_NETHERWOOD_PLANKS = ModBlocks.BLOCKS.register("vertical_netherwood_planks", () -> new Block(Block.Properties.of().strength(3.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_VERTICAL_SLAB = ModBlocks.BLOCKS.register("netherwood_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_POST = ModBlocks.BLOCKS.register("netherwood_post", () -> new ModPostBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_POST = ModBlocks.BLOCKS.register("stripped_netherwood_post", () -> new ModPostBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_HEDGE = ModBlocks.BLOCKS.register("netherwood_hedge", () -> new ModHedgeBlock(Block.Properties.of().strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> NETHERWOOD_LEAF_CARPET = BLOCKS.register("netherwood_leaf_carpet", () -> new CarpetBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> BEDROCK_BRICK_VERTICAL_SLAB = ModBlocks.BLOCKS.register("bedrock_brick_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMOOTH_BASALT_VERTICAL_SLAB = ModBlocks.BLOCKS.register("smooth_basalt_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> QUARTZ_BRICK_VERTICAL_SLAB = ModBlocks.BLOCKS.register("quartz_brick_vertical_slab", () -> new ModVerticalSlabBlock(Block.Properties.of().requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.STONE)));

    //Charm
    public static final RegistryObject<Block> NETHERWOOD_CRATE = ModBlocks.BLOCKS.register("netherwood_crate", () -> new ModCrateBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BOOKCASE = ModBlocks.BLOCKS.register("netherwood_bookcase", () -> new ModBookcaseBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD), ModWoodType.NETHERWOOD));
    public static final RegistryObject<Block> NETHERWOOD_BARREL = ModBlocks.BLOCKS.register("netherwood_barrel", () -> new ModBarrelBlock(Block.Properties.of().strength(2.0F, 4.0F).sound(SoundType.NETHER_WOOD)));
        
    //Woodworks
    public static final RegistryObject<Block> NETHERWOOD_BOARDS = BLOCKS.register("netherwood_boards", () -> new RotatedPillarBlock(Block.Properties.of().strength(1.5F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_BOOKSHELF = BLOCKS.register("netherwood_bookshelf", () -> new ModBookshelfBlock(Block.Properties.of().strength(1.5F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_CHEST = BLOCKS.register("netherwood_chest", () -> new ModChestBlock(Block.Properties.of().strength(2.5F, 6.0F).sound(SoundType.NETHER_WOOD), () -> { return ModBlockEntityType.NETHERWOOD_CHEST.get(); }));
    public static final RegistryObject<Block> NETHERWOOD_CHEST_TRAPPED = BLOCKS.register("netherwood_trapped_chest", () -> new ModTrappedChestBlock(Block.Properties.of().strength(2.5F, 6.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_LADDER = BLOCKS.register("netherwood_ladder", () -> new LadderBlock(Block.Properties.of().strength(0.4F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<Block> NETHERWOOD_LEAF_PILE = BLOCKS.register("netherwood_leaf_pile", () -> new CarpetBlock(Block.Properties.of().noCollission().instabreak().sound(SoundType.GRASS)));

    
	private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
		return (blockState) -> {
			return blockState.getValue(BlockStateProperties.LIT) ? lightValue : 0;
		};
   }
	
}
