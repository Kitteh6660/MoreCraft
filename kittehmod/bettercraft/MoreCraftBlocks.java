package kittehmod.bettercraft;

import kittehmod.bettercraft.block.BlockBlazeBlock;
import kittehmod.bettercraft.block.BlockBoneLadder;
import kittehmod.bettercraft.block.BlockGlowstoneTorch;
import kittehmod.bettercraft.block.BlockGunpowder;
import kittehmod.bettercraft.block.BlockMoreDoors;
import kittehmod.bettercraft.block.BlockMorePanes;
import kittehmod.bettercraft.block.BlockNetherLeaves;
import kittehmod.bettercraft.block.BlockNetherLog;
import kittehmod.bettercraft.block.BlockNetherSapling;
import kittehmod.bettercraft.block.BlockNetherWood;
import kittehmod.bettercraft.block.BlockNetherwoodChest;
import kittehmod.bettercraft.block.BlockNetherwoodCraftingTable;
import kittehmod.bettercraft.block.BlockNormal;
import kittehmod.bettercraft.block.BlockNormalSlab;
import kittehmod.bettercraft.block.BlockNormalStairs;
import kittehmod.bettercraft.block.BlockOreRuby;
import kittehmod.bettercraft.block.BlockSoulGlass;
import kittehmod.bettercraft.block.BlockStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

    public static void registerBlocks() {    	
    	GameRegistry.register(NETHERBRICK_DOOR);
    	GameRegistry.register(NETHERWOOD_DOOR);
    	GameRegistry.register(GLASS_DOOR);
    	GameRegistry.register(BONE_DOOR);
    	GameRegistry.register(NETHERBRICK_FENCE_GATE);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERBRICK_FENCE_GATE), NETHERBRICK_FENCE_GATE.getRegistryName());
    	GameRegistry.register(NETHERWOOD_FENCE_GATE);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_FENCE_GATE), NETHERWOOD_FENCE_GATE.getRegistryName());
    	
    	GameRegistry.register(RUBY_ORE);
    	GameRegistry.register((ItemBlock) new ItemBlock(RUBY_ORE), RUBY_ORE.getRegistryName());
    	
    	GameRegistry.register(FLESH_BLOCK);
    	GameRegistry.register((ItemBlock) new ItemBlock(FLESH_BLOCK), FLESH_BLOCK.getRegistryName());
    	GameRegistry.register(RUBY_BLOCK);
    	GameRegistry.register((ItemBlock) new ItemBlock(RUBY_BLOCK), RUBY_BLOCK.getRegistryName());
    	GameRegistry.register(BLAZE_BLOCK);
    	GameRegistry.register((ItemBlock) new ItemBlock(BLAZE_BLOCK), BLAZE_BLOCK.getRegistryName());
    	GameRegistry.register(ENDER_BLOCK);
    	GameRegistry.register((ItemBlock) new ItemBlock(ENDER_BLOCK), ENDER_BLOCK.getRegistryName());
    	GameRegistry.register(GUNPOWDER_BLOCK);
    	GameRegistry.register((ItemBlock) new ItemBlock(GUNPOWDER_BLOCK), GUNPOWDER_BLOCK.getRegistryName());
    	
    	GameRegistry.register(NETHERWOOD_LOG);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_LOG), NETHERWOOD_LOG.getRegistryName());
    	GameRegistry.register(NETHERWOOD_PLANKS);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_PLANKS), NETHERWOOD_PLANKS.getRegistryName());
    	GameRegistry.register(NETHERWOOD_LEAVES);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_LEAVES), NETHERWOOD_LEAVES.getRegistryName());
    	GameRegistry.register(NETHERWOOD_SAPLING);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_SAPLING), NETHERWOOD_SAPLING.getRegistryName());
    	GameRegistry.register(NETHERWOOD_STAIRS);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_STAIRS), NETHERWOOD_STAIRS.getRegistryName());
    	GameRegistry.register(NETHERWOOD_SLAB); //, ItemNormalSlab.class, "netherwood_slab", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, false
    	GameRegistry.register(NETHERWOOD_SLAB_FULL); //, ItemNormalSlab.class, "netherwood_slab_full", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, true
    	GameRegistry.register((ItemSlab) new ItemSlab(NETHERWOOD_SLAB, (BlockNormalSlab.Half) NETHERWOOD_SLAB, (BlockNormalSlab.Double) NETHERWOOD_SLAB_FULL), NETHERWOOD_SLAB.getRegistryName());
    	GameRegistry.register(NETHERWOOD_CHEST);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_CHEST), NETHERWOOD_CHEST.getRegistryName());
    	GameRegistry.register(NETHERWOOD_CHEST_TRAPPED);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_CHEST_TRAPPED), NETHERWOOD_CHEST_TRAPPED.getRegistryName());
    	GameRegistry.register(NETHERWOOD_CRAFTING_TABLE);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_CRAFTING_TABLE), NETHERWOOD_CRAFTING_TABLE.getRegistryName());
    	GameRegistry.register(NETHERWOOD_FENCE);
    	GameRegistry.register((ItemBlock) new ItemBlock(NETHERWOOD_FENCE), NETHERWOOD_FENCE.getRegistryName());
    	
    	if (!Loader.isModLoaded("quark")) {
	    	GameRegistry.register(ENDSTONE_BRICK_STAIRS);
	    	GameRegistry.register((ItemBlock) new ItemBlock(ENDSTONE_BRICK_STAIRS), ENDSTONE_BRICK_STAIRS.getRegistryName());
	    	GameRegistry.register(ENDSTONE_BRICK_SLAB);
	    	GameRegistry.register(ENDSTONE_BRICK_SLAB_FULL);
	    	GameRegistry.register((ItemSlab) new ItemSlab(ENDSTONE_BRICK_SLAB, (BlockNormalSlab.Half) ENDSTONE_BRICK_SLAB, (BlockNormalSlab.Double) ENDSTONE_BRICK_SLAB_FULL), ENDSTONE_BRICK_SLAB.getRegistryName());
	    	
	    	GameRegistry.register(STONE_STAIRS);
	    	GameRegistry.register((ItemBlock) new ItemBlock(STONE_STAIRS), STONE_STAIRS.getRegistryName());
    	}
    	GameRegistry.register(SOUL_GLASS);
    	GameRegistry.register((ItemBlock) new ItemBlock(SOUL_GLASS), SOUL_GLASS.getRegistryName());
    	GameRegistry.register(SOUL_GLASS_PANE);
    	GameRegistry.register((ItemBlock) new ItemBlock(SOUL_GLASS_PANE), SOUL_GLASS_PANE.getRegistryName());
    	GameRegistry.register(BONE_LADDER);
    	GameRegistry.register((ItemBlock) new ItemBlock(BONE_LADDER), BONE_LADDER.getRegistryName());
    	GameRegistry.register(GLOWSTONE_TORCH);
    	GameRegistry.register((ItemBlock) new ItemBlock(GLOWSTONE_TORCH), GLOWSTONE_TORCH.getRegistryName());
    	GameRegistry.register(BEDROCK_BRICK);
    	GameRegistry.register((ItemBlock) new ItemBlock(BEDROCK_BRICK), BEDROCK_BRICK.getRegistryName());
    }
    
}
