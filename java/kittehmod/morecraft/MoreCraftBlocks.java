package kittehmod.morecraft;

import kittehmod.morecraft.block.BlockBlazeBlock;
import kittehmod.morecraft.block.BlockBoneLadder;
import kittehmod.morecraft.block.BlockGlowstoneTorch;
import kittehmod.morecraft.block.BlockGunpowder;
import kittehmod.morecraft.block.BlockMoreDoors;
import kittehmod.morecraft.block.BlockMorePanes;
import kittehmod.morecraft.block.BlockNetherLeaves;
import kittehmod.morecraft.block.BlockNetherLog;
import kittehmod.morecraft.block.BlockNetherSapling;
import kittehmod.morecraft.block.BlockNetherWood;
import kittehmod.morecraft.block.BlockNetherwoodChest;
import kittehmod.morecraft.block.BlockNetherwoodCraftingTable;
import kittehmod.morecraft.block.BlockNormal;
import kittehmod.morecraft.block.BlockNormalSlab;
import kittehmod.morecraft.block.BlockNormalStairs;
import kittehmod.morecraft.block.BlockOreRuby;
import kittehmod.morecraft.block.BlockSoulGlass;
import kittehmod.morecraft.block.BlockStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class MoreCraftBlocks {
	//--LIST OF BLOCKS--\\
    //Doors & Gates
    public static final Block NETHERBRICK_DOOR = new BlockMoreDoors(Material.ROCK).setSoundType(SoundType.STONE).setHardness(5.0F).setResistance(20.0F).setUnlocalizedName("netherbrick_door").setRegistryName("netherbrick_door");
	public static final Block NETHERWOOD_DOOR = new BlockMoreDoors(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("netherwood_door").setRegistryName("netherwood_door");
	public static final Block GLASS_DOOR = new BlockMoreDoors(Material.GLASS).setSoundType(SoundType.GLASS).setHardness(1.0F).setResistance(3.0F).setUnlocalizedName("glass_door").setRegistryName("glass_door");
	public static final Block BONE_DOOR = new BlockMoreDoors(Material.ROCK).setSoundType(SoundType.WOOD).setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("bone_door").setRegistryName("bone_door");
    public static final Block NETHERBRICK_FENCE_GATE = new BlockFenceGate(BlockPlanks.EnumType.OAK)/*.setSoundType(SoundType.STONE)*/.setHardness(3.0F).setResistance(20.0F).setUnlocalizedName("netherbrick_fence_gate").setRegistryName("netherbrick_fence_gate");
    public static final Block NETHERWOOD_FENCE_GATE = new BlockFenceGate(BlockPlanks.EnumType.SPRUCE)/*.setSoundType(SoundType.WOOD)*/.setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("netherwood_fence_gate").setRegistryName("netherwood_fence_gate");

    //Ores
    public static final Block RUBY_ORE = new BlockOreRuby(Material.ROCK).setHardness(4.0F).setResistance(2.0F).setUnlocalizedName("ruby_ore").setRegistryName("ruby_ore");
   
    //Storage Blocks
    public static final Block FLESH_BLOCK = new BlockStorage(Material.CLOTH).setSoundType(SoundType.CLOTH).setHardness(1.0F).setResistance(2.0F).setUnlocalizedName("flesh_block").setRegistryName("flesh_block");
    public static final Block RUBY_BLOCK = new BlockStorage(Material.ROCK).setSoundType(SoundType.METAL).setHardness(6.0F).setResistance(10.0F).setUnlocalizedName("ruby_block").setRegistryName("ruby_block");
    public static final Block BLAZE_BLOCK = new BlockBlazeBlock().setHardness(10.0F).setResistance(15.0F).setLightLevel(1.0F).setUnlocalizedName("blaze_block").setRegistryName("blaze_block");
    public static final Block ENDER_BLOCK = new BlockStorage(Material.ROCK).setSoundType(SoundType.STONE).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("ender_block").setRegistryName("ender_block");
    public static final Block GUNPOWDER_BLOCK = new BlockGunpowder().setHardness(0.5F).setResistance(5.0F).setUnlocalizedName("gunpowder_block").setRegistryName("gunpowder_block");
    
    //Netherwood
    public static final Block NETHERWOOD_LOG = new BlockNetherLog().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_log").setRegistryName("netherwood_log");
    public static final Block NETHERWOOD_PLANKS = new BlockNetherWood().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_planks").setRegistryName("netherwood_planks");
    public static final BlockNetherLeaves NETHERWOOD_LEAVES = (BlockNetherLeaves) new BlockNetherLeaves().setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("netherwood_leaves").setRegistryName("netherwood_leaves");   
    public static final Block NETHERWOOD_SAPLING = new BlockNetherSapling().setHardness(0F).setResistance(1.0F).setUnlocalizedName("netherwood_sapling").setRegistryName("netherwood_sapling");
    public static final Block NETHERWOOD_STAIRS = new BlockNormalStairs(NETHERWOOD_PLANKS.getDefaultState()).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_stairs").setRegistryName("netherwood_stairs");
    public static final Block NETHERWOOD_SLAB = new BlockNormalSlab.Half(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_slab").setRegistryName("netherwood_slab");
    public static final Block NETHERWOOD_SLAB_FULL = new BlockNormalSlab.Double(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_slab").setRegistryName("netherwood_slab_full");
    public static final BlockNetherwoodChest NETHERWOOD_CHEST = (BlockNetherwoodChest)(new BlockNetherwoodChest(BlockNetherwoodChest.Type.BASIC)).setHardness(2.5F).setResistance(7.0F).setUnlocalizedName("netherwood_chest").setRegistryName("netherwood_chest");    
    public static final BlockNetherwoodChest NETHERWOOD_CHEST_TRAPPED = (BlockNetherwoodChest)(new BlockNetherwoodChest(BlockNetherwoodChest.Type.TRAP)).setHardness(2.5F).setResistance(7.0F).setUnlocalizedName("netherwood_chest_trap").setRegistryName("netherwood_chest_trap");
    public static final Block NETHERWOOD_CRAFTING_TABLE = new BlockNetherwoodCraftingTable().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_crafting_table").setRegistryName("netherwood_crafting_table");
    public static final Block NETHERWOOD_FENCE = new BlockFence(Material.WOOD, MapColor.OBSIDIAN).setHardness(2.0F).setResistance(20.0F).setUnlocalizedName("netherwood_fence").setRegistryName("netherwood_fence");

    //Ender Bricks
    public static final Block ENDSTONE_BRICK_STAIRS = new BlockNormalStairs(Blocks.END_BRICKS.getDefaultState()).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_stairs").setRegistryName("enderbrick_stairs");
    public static final Block ENDSTONE_BRICK_SLAB = new BlockNormalSlab.Half(Material.ROCK).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_slab").setRegistryName("enderbrick_slab");
    public static final Block ENDSTONE_BRICK_SLAB_FULL = new BlockNormalSlab.Double(Material.ROCK).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_slab").setRegistryName("enderbrick_slab_full");
    
    //Others
    public static final Block STONE_STAIRS = new BlockNormalStairs(Blocks.STONE.getDefaultState()).setSoundType(SoundType.STONE).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("stone_stairs").setRegistryName("stone_stairs");
    public static final Block SOUL_GLASS = new BlockSoulGlass(Material.GLASS, false).setHardness(0.5F).setResistance(15.0F).setUnlocalizedName("soul_glass").setRegistryName("soul_glass");
    public static final Block SOUL_GLASS_PANE = new BlockMorePanes(Material.GLASS, false).setSoundType(SoundType.GLASS).setHardness(0.5F).setResistance(15.0F).setUnlocalizedName("soul_glass_pane").setRegistryName("soul_glass_pane");
    public static final Block BONE_LADDER = new BlockBoneLadder().setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("bone_ladder").setRegistryName("bone_ladder");
    public static final Block GLOWSTONE_TORCH = new BlockGlowstoneTorch().setUnlocalizedName("glowstone_torch").setLightLevel(1.0F).setRegistryName("glowstone_torch");
    public static final Block BEDROCK_BRICK = new BlockNormal(Material.ROCK).setSoundType(SoundType.STONE).setBlockUnbreakable().setResistance(6000000.0F).setUnlocalizedName("bedrock_brick").setRegistryName("bedrock_brick");    

	@EventBusSubscriber(modid = MoreCraft.MODID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerBlocks(final RegistryEvent.Register<Block> event) { 
	    	final IForgeRegistry<Block> registry = event.getRegistry();
	    	
	    	registry.register(NETHERBRICK_DOOR);
	    	registry.register(NETHERWOOD_DOOR);
	    	registry.register(GLASS_DOOR);
	    	registry.register(BONE_DOOR);
	    	registry.register(NETHERBRICK_FENCE_GATE);
	    	registry.register(NETHERWOOD_FENCE_GATE);
	    	
	    	registry.register(RUBY_ORE);
	    	
	    	registry.register(FLESH_BLOCK);
	    	registry.register(RUBY_BLOCK);
	    	registry.register(BLAZE_BLOCK);
	    	registry.register(ENDER_BLOCK);
	    	registry.register(GUNPOWDER_BLOCK);
	    	
	    	registry.register(NETHERWOOD_LOG);
	    	registry.register(NETHERWOOD_PLANKS);
	    	registry.register(NETHERWOOD_LEAVES);
	    	registry.register(NETHERWOOD_SAPLING);
	    	registry.register(NETHERWOOD_STAIRS);
	    	registry.register(NETHERWOOD_SLAB); //, ItemNormalSlab.class, "netherwood_slab", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, false
	    	registry.register(NETHERWOOD_SLAB_FULL); //, ItemNormalSlab.class, "netherwood_slab_full", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, true
	    	registry.register(NETHERWOOD_CHEST);
	    	registry.register(NETHERWOOD_CHEST_TRAPPED);
	    	registry.register(NETHERWOOD_CRAFTING_TABLE);
	    	registry.register(NETHERWOOD_FENCE);
	    	
	    	if (!Loader.isModLoaded("quark")) {
		    	registry.register(ENDSTONE_BRICK_STAIRS);
		    	registry.register(ENDSTONE_BRICK_SLAB);
		    	registry.register(ENDSTONE_BRICK_SLAB_FULL);
		    	registry.register(STONE_STAIRS);
	    	}
	    	registry.register(SOUL_GLASS);
	    	registry.register(SOUL_GLASS_PANE);
	    	registry.register(BONE_LADDER);
	    	registry.register(GLOWSTONE_TORCH);
	    	registry.register(BEDROCK_BRICK);
	    }
	    
	    @SubscribeEvent
	    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
	    	final IForgeRegistry<Item> registry = event.getRegistry();
	    	
	    	registry.register(new ItemBlock(NETHERBRICK_FENCE_GATE).setRegistryName(NETHERBRICK_FENCE_GATE.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_FENCE_GATE).setRegistryName(NETHERWOOD_FENCE_GATE.getRegistryName()));

	    	registry.register(new ItemBlock(RUBY_ORE).setRegistryName(RUBY_ORE.getRegistryName()));

	    	registry.register(new ItemBlock(FLESH_BLOCK).setRegistryName(FLESH_BLOCK.getRegistryName()));
	    	registry.register(new ItemBlock(RUBY_BLOCK).setRegistryName(RUBY_BLOCK.getRegistryName()));
	    	registry.register(new ItemBlock(BLAZE_BLOCK).setRegistryName(BLAZE_BLOCK.getRegistryName()));
	    	registry.register(new ItemBlock(ENDER_BLOCK).setRegistryName(ENDER_BLOCK.getRegistryName()));
	    	registry.register(new ItemBlock(GUNPOWDER_BLOCK).setRegistryName(GUNPOWDER_BLOCK.getRegistryName()));
	    	
	    	registry.register(new ItemBlock(NETHERWOOD_LOG).setRegistryName(NETHERWOOD_LOG.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_PLANKS).setRegistryName(NETHERWOOD_PLANKS.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_LEAVES).setRegistryName(NETHERWOOD_LEAVES.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_SAPLING).setRegistryName(NETHERWOOD_SAPLING.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_STAIRS).setRegistryName(NETHERWOOD_STAIRS.getRegistryName()));
	    	registry.register(new ItemSlab(NETHERWOOD_SLAB, (BlockNormalSlab.Half) NETHERWOOD_SLAB, (BlockNormalSlab.Double) NETHERWOOD_SLAB_FULL).setRegistryName(NETHERWOOD_SLAB.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_CHEST).setRegistryName(NETHERWOOD_CHEST.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_CHEST_TRAPPED).setRegistryName(NETHERWOOD_CHEST_TRAPPED.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_CRAFTING_TABLE).setRegistryName(NETHERWOOD_CRAFTING_TABLE.getRegistryName()));
	    	registry.register(new ItemBlock(NETHERWOOD_FENCE).setRegistryName(NETHERWOOD_FENCE.getRegistryName()));

	    	if (!Loader.isModLoaded("quark")) {
	    		registry.register(new ItemBlock(ENDSTONE_BRICK_STAIRS).setRegistryName(ENDSTONE_BRICK_STAIRS.getRegistryName()));
	    		registry.register((ItemSlab) new ItemSlab(ENDSTONE_BRICK_SLAB, (BlockNormalSlab.Half) ENDSTONE_BRICK_SLAB, (BlockNormalSlab.Double) ENDSTONE_BRICK_SLAB_FULL).setRegistryName(ENDSTONE_BRICK_SLAB.getRegistryName()));
	    		registry.register(new ItemBlock(STONE_STAIRS).setRegistryName(STONE_STAIRS.getRegistryName()));
	    	}

	    	registry.register(new ItemBlock(SOUL_GLASS).setRegistryName(SOUL_GLASS.getRegistryName()));
	    	registry.register(new ItemBlock(SOUL_GLASS_PANE).setRegistryName(SOUL_GLASS_PANE.getRegistryName()));
	    	registry.register(new ItemBlock(BONE_LADDER).setRegistryName(BONE_LADDER.getRegistryName()));
	    	registry.register(new ItemBlock(GLOWSTONE_TORCH).setRegistryName(GLOWSTONE_TORCH.getRegistryName()));
	    	registry.register(new ItemBlock(BEDROCK_BRICK).setRegistryName(BEDROCK_BRICK.getRegistryName()));
	    	
	    }
	}
}
