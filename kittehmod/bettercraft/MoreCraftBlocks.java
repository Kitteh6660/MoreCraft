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
import kittehmod.bettercraft.item.ItemNormalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreCraftBlocks {
	//--LIST OF BLOCKS--\\
    //Doors & Gates
    public static final Block NETHERBRICK_DOOR = new BlockMoreDoors(Material.ROCK).setSoundType(SoundType.STONE).setHardness(5.0F).setResistance(20.0F).setUnlocalizedName("netherbrick_door");
	public static final Block NETHERWOOD_DOOR = new BlockMoreDoors(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("netherwood_door");
	public static final Block GLASS_DOOR = new BlockMoreDoors(Material.GLASS).setSoundType(SoundType.GLASS).setHardness(1.0F).setResistance(3.0F).setUnlocalizedName("glass_door");
	public static final Block BONE_DOOR = new BlockMoreDoors(Material.ROCK).setSoundType(SoundType.WOOD).setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("bone_door");
    public static final Block NETHERBRICK_FENCE_GATE = new BlockFenceGate(BlockPlanks.EnumType.OAK)/*.setSoundType(SoundType.STONE)*/.setHardness(3.0F).setResistance(20.0F).setUnlocalizedName("netherbrick_fence_gate");
    public static final Block NETHERWOOD_FENCE_GATE = new BlockFenceGate(BlockPlanks.EnumType.SPRUCE)/*.setSoundType(SoundType.WOOD)*/.setHardness(2.5F).setResistance(7.5F).setUnlocalizedName("netherwood_fence_gate");

    //Ores
    public static final Block RUBY_ORE = new BlockOreRuby(Material.ROCK).setHardness(4.0F).setResistance(2.0F).setUnlocalizedName("ruby_ore");
   
    //Storage Blocks
    public static final Block FLESH_BLOCK = new BlockStorage(Material.CLOTH).setSoundType(SoundType.CLOTH).setHardness(1.0F).setResistance(2.0F).setUnlocalizedName("flesh_block");
    public static final Block RUBY_BLOCK = new BlockStorage(Material.ROCK).setSoundType(SoundType.METAL).setHardness(6.0F).setResistance(10.0F).setUnlocalizedName("ruby_block");
    public static final Block BLAZE_BLOCK = new BlockBlazeBlock().setHardness(10.0F).setResistance(15.0F).setLightLevel(1.0F).setUnlocalizedName("blaze_block");
    public static final Block ENDER_BLOCK = new BlockStorage(Material.ROCK).setSoundType(SoundType.STONE).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("ender_block");
    public static final Block GUNPOWDER_BLOCK = new BlockGunpowder().setHardness(0.5F).setResistance(5.0F).setUnlocalizedName("gunpowder_block");
    
    //Netherwood
    public static final Block NETHERWOOD_LOG = new BlockNetherLog().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_log");
    public static final Block NETHERWOOD_PLANKS = new BlockNetherWood().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_planks");
    public static final BlockNetherLeaves NETHERWOOD_LEAVES = (BlockNetherLeaves) new BlockNetherLeaves().setHardness(0.2F).setLightOpacity(1).setUnlocalizedName("netherwood_leaves");   
    public static final Block NETHERWOOD_SAPLING = new BlockNetherSapling().setHardness(0F).setResistance(1.0F).setUnlocalizedName("netherwood_sapling");
    public static final Block NETHERWOOD_STAIRS = new BlockNormalStairs(NETHERWOOD_PLANKS.getDefaultState()).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_stairs");
    public static final Block NETHERWOOD_SLAB = new BlockNormalSlab.Half(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_slab");
    public static final Block NETHERWOOD_SLAB_FULL = new BlockNormalSlab.Double(Material.WOOD).setSoundType(SoundType.WOOD).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_slab");
    public static final BlockNetherwoodChest NETHERWOOD_CHEST = (BlockNetherwoodChest)(new BlockNetherwoodChest()).setHardness(2.5F).setResistance(7.0F).setUnlocalizedName("netherwood_chest");    
    public static final Block NETHERWOOD_CRAFTING_TABLE = new BlockNetherwoodCraftingTable().setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("netherwood_crafting_table");
    public static final Block NETHERWOOD_FENCE = new BlockFence(Material.WOOD, MapColor.OBSIDIAN).setHardness(2.0F).setResistance(20.0F).setUnlocalizedName("netherwood_fence");

    //Ender Bricks
    public static final Block ENDSTONE_BRICK_STAIRS = new BlockNormalStairs(Blocks.END_BRICKS.getDefaultState()).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_stairs");
    public static final Block ENDSTONE_BRICK_SLAB = new BlockNormalSlab.Half(Material.ROCK).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_slab");
    public static final Block ENDSTONE_BRICK_SLAB_FULL = new BlockNormalSlab.Double(Material.ROCK).setSoundType(SoundType.STONE).setHardness(10.0F).setResistance(15.0F).setUnlocalizedName("enderbrick_slab");
    
    //Others
    public static final Block STONE_STAIRS = new BlockNormalStairs(Blocks.STONE.getDefaultState()).setSoundType(SoundType.STONE).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("stone_stairs");
    public static final Block SOUL_GLASS = new BlockSoulGlass(Material.GLASS, false).setHardness(0.5F).setResistance(15.0F).setUnlocalizedName("soul_glass");
    public static final Block SOUL_GLASS_PANE = new BlockMorePanes(Material.GLASS, false).setSoundType(SoundType.GLASS).setHardness(0.5F).setResistance(15.0F).setUnlocalizedName("soul_glass_pane");
    public static final Block BONE_LADDER = new BlockBoneLadder().setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("bone_ladder");
    public static final Block GLOWSTONE_TORCH = new BlockGlowstoneTorch().setUnlocalizedName("glowstone_torch").setLightLevel(1.0F);
    public static final Block BEDROCK_BRICK = new BlockNormal(Material.ROCK).setSoundType(SoundType.STONE).setBlockUnbreakable().setResistance(5.0F).setUnlocalizedName("bedrock_brick");    

    public static void registerBlocks() {
    	GameRegistry.registerBlock(NETHERBRICK_DOOR, "netherbrick_door");
    	GameRegistry.registerBlock(NETHERWOOD_DOOR, "netherwood_door");
    	GameRegistry.registerBlock(GLASS_DOOR, "glass_door");
    	GameRegistry.registerBlock(BONE_DOOR, "bone_door");
    	GameRegistry.registerBlock(NETHERBRICK_FENCE_GATE, "netherbrick_fence_gate");
    	GameRegistry.registerBlock(NETHERWOOD_FENCE_GATE, "netherwood_fence_gate");
    	
    	GameRegistry.registerBlock(RUBY_ORE, "ruby_ore");
    	
    	GameRegistry.registerBlock(FLESH_BLOCK, "flesh_block");
    	GameRegistry.registerBlock(RUBY_BLOCK, "ruby_block");
    	GameRegistry.registerBlock(BLAZE_BLOCK, "blaze_block");
    	GameRegistry.registerBlock(ENDER_BLOCK, "ender_block");
    	GameRegistry.registerBlock(GUNPOWDER_BLOCK, "gunpowder_block");
    	
    	GameRegistry.registerBlock(NETHERWOOD_LOG, "netherwood_log");
    	GameRegistry.registerBlock(NETHERWOOD_PLANKS, "netherwood_planks");
    	GameRegistry.registerBlock(NETHERWOOD_LEAVES, "netherwood_leaves");
    	GameRegistry.registerBlock(NETHERWOOD_SAPLING, "netherwood_sapling");
    	GameRegistry.registerBlock(NETHERWOOD_STAIRS, "netherwood_stairs");
    	GameRegistry.registerBlock(NETHERWOOD_SLAB, ItemNormalSlab.class, "netherwood_slab", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, false);
    	GameRegistry.registerBlock(NETHERWOOD_SLAB_FULL, ItemNormalSlab.class, "netherwood_slab_full", NETHERWOOD_SLAB, NETHERWOOD_SLAB_FULL, true);
    	GameRegistry.registerBlock(NETHERWOOD_CHEST, "netherwood_chest");
    	GameRegistry.registerBlock(NETHERWOOD_CRAFTING_TABLE, "netherwood_crafting_table");
    	GameRegistry.registerBlock(NETHERWOOD_FENCE, "netherwood_fence");
    	
    	GameRegistry.registerBlock(ENDSTONE_BRICK_STAIRS, "enderbrick_stairs");
    	GameRegistry.registerBlock(ENDSTONE_BRICK_SLAB, ItemNormalSlab.class, "enderbrick_slab", ENDSTONE_BRICK_SLAB, ENDSTONE_BRICK_SLAB_FULL, false);
    	GameRegistry.registerBlock(ENDSTONE_BRICK_SLAB_FULL, ItemNormalSlab.class, "enderbrick_slab_full", ENDSTONE_BRICK_SLAB, ENDSTONE_BRICK_SLAB_FULL, true);
    	
    	GameRegistry.registerBlock(STONE_STAIRS, "stone_stairs");
    	GameRegistry.registerBlock(SOUL_GLASS, "soul_glass");
    	GameRegistry.registerBlock(SOUL_GLASS_PANE, "soul_glass_pane");
    	GameRegistry.registerBlock(BONE_LADDER, "bone_ladder");
    	GameRegistry.registerBlock(GLOWSTONE_TORCH, "glowstone_torch");
    	GameRegistry.registerBlock(BEDROCK_BRICK, "bedrock_brick");
    }
    
}
