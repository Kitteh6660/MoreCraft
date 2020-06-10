package kittehmod.morecraft.block;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.worldgen.NetherwoodTree;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
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

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreCraft.MODID);
	
	//--LIST OF BLOCKS--\\
    //Doors & Gates
    public static final RegistryObject<Block> NETHERBRICK_DOOR = BLOCKS.register("netherbrick_door", () -> new ModDoorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 8.0F).sound(SoundType.STONE))); 
	public static final RegistryObject<Block> NETHERWOOD_DOOR = BLOCKS.register("netherwood_door", () -> new ModDoorBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 4.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GLASS_DOOR = BLOCKS.register("glass_door", () -> new ModDoorBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0F, 2.0F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BONE_DOOR = BLOCKS.register("bone_door", () -> new ModDoorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5F, 4.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHERBRICK_FENCE_GATE = BLOCKS.register("netherbrick_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 8.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHERWOOD_FENCE_GATE = BLOCKS.register("netherwood_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 4.0F).sound(SoundType.WOOD)));

    //Ores
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new ModOreBlock(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(3.0F, 3.0F)));
   
    //Storage Blocks
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", () -> new Block(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.GROUND)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLAZE_BLOCK = BLOCKS.register("blaze_block", () -> new BlazeBlock(Block.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(5.0F, 6.0F).lightValue(15).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ENDER_BLOCK = BLOCKS.register("ender_block", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(2.5F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GUNPOWDER_BLOCK = BLOCKS.register("gunpowder_block", () -> new GunpowderBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F, 2.0F).sound(SoundType.SAND)));
    
    //Netherwood
    public static final RegistryObject<Block> NETHERWOOD_LOG = BLOCKS.register("netherwood_log", () -> new NetherwoodLogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_LOG = BLOCKS.register("stripped_netherwood_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_WOOD = BLOCKS.register("netherwood_wood", () -> new NetherwoodLogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> STRIPPED_NETHERWOOD_WOOD = BLOCKS.register("stripped_netherwood_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_PLANKS = BLOCKS.register("netherwood_planks", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_LEAVES = BLOCKS.register("netherwood_leaves", () -> new NetherwoodLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F, 1.0F))); 
    public static final RegistryObject<Block> NETHERWOOD_SAPLING = BLOCKS.register("netherwood_sapling", () -> new NetherwoodSaplingBlock(new NetherwoodTree(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F, 0F).sound(SoundType.PLANT))); 
    public static final RegistryObject<Block> NETHERWOOD_STAIRS = BLOCKS.register("netherwood_stairs", () -> new ModStairsBlock(NETHERWOOD_PLANKS.get().getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_SLAB = BLOCKS.register("netherwood_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_CHEST = BLOCKS.register("netherwood_chest", () -> new NetherwoodChestBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 6.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_CHEST_TRAPPED = BLOCKS.register("netherwood_trapped_chest", () -> new NetherwoodTrappedChestBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 6.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_CRAFTING_TABLE = BLOCKS.register("netherwood_crafting_table", () -> new NetherwoodCraftingTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_FENCE = BLOCKS.register("netherwood_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_TRAPDOOR = BLOCKS.register("netherwood_trapdoor", () -> new ModTrapDoorBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 4.0F).sound(SoundType.WOOD))); 
    public static final RegistryObject<Block> NETHERWOOD_SIGN = BLOCKS.register("netherwood_sign", () -> new NetherwoodStandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_WALL_SIGN = BLOCKS.register("netherwood_wall_sign", () -> new NetherwoodWallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_BUTTON = BLOCKS.register("netherwood_button", () -> new ModButtonBlock(true, Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHERWOOD_PRESSURE_PLATE = BLOCKS.register("netherwood_pressure_plate", () -> new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));

    //Heads
    public static final RegistryObject<Block> SPIDER_HEAD = BLOCKS.register("spider_head", () -> new ModSkullBlock(ModSkullBlock.Types.SPIDER, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F))); 
    public static final RegistryObject<Block> CAVE_SPIDER_HEAD = BLOCKS.register("cave_spider_head", () -> new ModSkullBlock(ModSkullBlock.Types.CAVE_SPIDER, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F))); 
    public static final RegistryObject<Block> ZOMBIE_PIGMAN_HEAD  = BLOCKS.register("zombie_pigman_head", () -> new ModSkullBlock(ModSkullBlock.Types.ZOMBIE_PIGMAN, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F))); 
    public static final RegistryObject<Block> BLAZE_HEAD = BLOCKS.register("blaze_head", () -> new ModSkullBlock(ModSkullBlock.Types.BLAZE, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> ENDERMAN_HEAD = BLOCKS.register("enderman_head", () -> new ModSkullBlock(ModSkullBlock.Types.ENDERMAN, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));

    public static final RegistryObject<Block> WALL_SPIDER_HEAD = BLOCKS.register("wall_spider_head", () -> new ModWallSkullBlock(ModSkullBlock.Types.SPIDER, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> WALL_CAVE_SPIDER_HEAD = BLOCKS.register("wall_cave_spider_head", () -> new ModWallSkullBlock(ModSkullBlock.Types.CAVE_SPIDER, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> WALL_ZOMBIE_PIGMAN_HEAD  = BLOCKS.register("wall_zombie_pigman_head", () -> new ModWallSkullBlock(ModSkullBlock.Types.ZOMBIE_PIGMAN, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> WALL_BLAZE_HEAD = BLOCKS.register("wall_blaze_head", () -> new ModWallSkullBlock(ModSkullBlock.Types.BLAZE, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> WALL_ENDERMAN_HEAD = BLOCKS.register("wall_enderman_head", () -> new ModWallSkullBlock(ModSkullBlock.Types.ENDERMAN, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0F)));

    //Others
    public static final RegistryObject<Block> SOUL_GLASS = BLOCKS.register("soul_glass", () -> new GlassBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F, 3.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SOUL_GLASS_PANE = BLOCKS.register("soul_glass_pane", () -> new ModPaneBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5F, 3.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FLESH_CARPET = BLOCKS.register("flesh_carpet", () -> new ModCarpetBlock(DyeColor.WHITE, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(0.5F, 1.0F).sound(SoundType.NETHER_WART)));
    public static final RegistryObject<Block> BONE_LADDER = BLOCKS.register("bone_ladder", () -> new BoneLadderBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 3.0F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch", () -> new GlowstoneTorchBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.0F, 1.0F).lightValue(15).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WALL_GLOWSTONE_TORCH = BLOCKS.register("wall_glowstone_torch", () -> new GlowstoneWallTorchBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.0F, 1.0F).lightValue(15).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BEDROCK_BRICK = BLOCKS.register("bedrock_brick", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1F, 3600000F).sound(SoundType.STONE)));
    @SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_NETHERWOOD_SAPLING = BLOCKS.register("potted_netherwood_sapling", () -> new FlowerPotBlock(NETHERWOOD_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F)));

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
