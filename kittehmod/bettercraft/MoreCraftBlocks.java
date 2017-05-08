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
import kittehmod.bettercraft.block.BlockNormalSlabDouble;
import kittehmod.bettercraft.block.BlockNormalSlabHalf;
import kittehmod.bettercraft.block.BlockNormalStairs;
import kittehmod.bettercraft.block.BlockOreRuby;
import kittehmod.bettercraft.block.BlockSoulGlass;
import kittehmod.bettercraft.block.BlockStorage;
import kittehmod.bettercraft.item.ItemNormalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreCraftBlocks {
	//--LIST OF BLOCKS--\\
    //Doors & Gates
    public static final Block netherbrick_door = new BlockMoreDoors(Material.rock).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("netherbrick_door");
	public static final Block netherwood_door = new BlockMoreDoors(Material.wood).setHardness(2.5F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_door");
	public static final Block glass_door = new BlockMoreDoors(Material.glass).setHardness(1.0F).setResistance(3.0F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_door");
	public static final Block bone_door = new BlockMoreDoors(Material.rock).setHardness(2.5F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setUnlocalizedName("bone_door");
    public static final Block netherbrick_fence_gate = new BlockFenceGate(BlockPlanks.EnumType.OAK).setHardness(2.5F).setResistance(20.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("netherbrick_fence_gate");
    public static final Block netherwood_fence_gate = new BlockFenceGate(BlockPlanks.EnumType.SPRUCE).setHardness(3.0F).setResistance(20.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("netherwood_fence_gate");

    //Ores
    public static final Block ruby_ore = new BlockOreRuby(Material.rock).setHardness(4.0F).setResistance(2.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("ruby_ore");
   
    //Storage Blocks
    public static final Block bone_block = new BlockStorage(Material.rock).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("bone_block");
    public static final Block flesh_block = new BlockStorage(Material.cloth).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("flesh_block");
    public static final Block ruby_block = new BlockStorage(Material.rock).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("ruby_block");
    public static final Block blaze_block = new BlockBlazeBlock().setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setLightLevel(1.0F).setUnlocalizedName("blaze_block");
    public static final Block ender_block = new BlockStorage(Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("ender_block");
    public static final Block gunpowder_block = new BlockGunpowder().setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("gunpowder_block");
    
    //Netherwood
    public static final Block netherwood_log = new BlockNetherLog().setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_log");
    public static final Block netherwood_planks = new BlockNetherWood().setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_planks");
    public static final BlockNetherLeaves netherwood_leaves = (BlockNetherLeaves) new BlockNetherLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setUnlocalizedName("netherwood_leaves");   
    public static final Block netherwood_sapling = new BlockNetherSapling().setHardness(0F).setResistance(1.0F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("netherwood_sapling");
    public static final Block netherwood_stairs = new BlockNormalStairs(netherwood_planks.getDefaultState()).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_stairs");
    public static final Block netherwood_slab = new BlockNormalSlabHalf(Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_slab");
    public static final Block netherwood_slab_full = new BlockNormalSlabDouble(Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_slab");
    public static final BlockNetherwoodChest netherwood_chest = (BlockNetherwoodChest)(new BlockNetherwoodChest()).setHardness(2.5F).setResistance(7.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_chest");    
    public static final Block netherwood_crafting_table = new BlockNetherwoodCraftingTable().setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_crafting_table");
    public static final Block netherwood_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(20.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("netherwood_fence");

    //Ender Bricks
    public static final Block enderbrick_block = new BlockNormal(Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("enderbrick_block");
    public static final Block enderbrick_stairs = new BlockNormalStairs(enderbrick_block.getDefaultState()).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("enderbrick_stairs");
    public static final Block enderbrick_slab = new BlockNormalSlabHalf(Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("enderbrick_slab");
    public static final Block enderbrick_slab_full = new BlockNormalSlabDouble(Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("enderbrick_slab");
    
    //Others
    public static final Block stone_stairs = new BlockNormalStairs(Blocks.stone.getDefaultState()).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("stone_stairs");
    public static final Block soul_glass = new BlockSoulGlass(Material.glass, false).setHardness(0.5F).setResistance(15.0F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("soul_glass");
    public static final Block soul_glass_pane = new BlockMorePanes(Material.glass, false).setHardness(0.5F).setResistance(15.0F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("soul_glass_pane");
    public static final Block bone_ladder = new BlockBoneLadder().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("bone_ladder");
    public static final Block glowstone_torch = new BlockGlowstoneTorch().setUnlocalizedName("glowstone_torch");
    public static final Block bedrock_brick = new BlockNormal(Material.rock).setBlockUnbreakable().setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("bedrock_brick");    

    public static void registerBlocks() {
    	GameRegistry.registerBlock(netherbrick_door, "netherbrick_door");
    	GameRegistry.registerBlock(netherwood_door, "netherwood_door");
    	GameRegistry.registerBlock(glass_door, "glass_door");
    	GameRegistry.registerBlock(bone_door, "bone_door");
    	GameRegistry.registerBlock(netherbrick_fence_gate, "netherbrick_fence_gate");
    	GameRegistry.registerBlock(netherwood_fence_gate, "netherwood_fence_gate");
    	
    	GameRegistry.registerBlock(ruby_ore, "ruby_ore");
    	
    	GameRegistry.registerBlock(bone_block, "bone_block");
    	GameRegistry.registerBlock(flesh_block, "flesh_block");
    	GameRegistry.registerBlock(ruby_block, "ruby_block");
    	GameRegistry.registerBlock(blaze_block, "blaze_block");
    	GameRegistry.registerBlock(ender_block, "ender_block");
    	GameRegistry.registerBlock(gunpowder_block, "gunpowder_block");
    	
    	GameRegistry.registerBlock(netherwood_log, "netherwood_log");
    	GameRegistry.registerBlock(netherwood_planks, "netherwood_planks");
    	GameRegistry.registerBlock(netherwood_leaves, "netherwood_leaves");
    	GameRegistry.registerBlock(netherwood_sapling, "netherwood_sapling");
    	GameRegistry.registerBlock(netherwood_stairs, "netherwood_stairs");
    	GameRegistry.registerBlock(netherwood_slab, ItemNormalSlab.class, "netherwood_slab", netherwood_slab, netherwood_slab_full, false);
    	GameRegistry.registerBlock(netherwood_slab_full, ItemNormalSlab.class, "netherwood_slab_full", netherwood_slab, netherwood_slab_full, true);
    	GameRegistry.registerBlock(netherwood_chest, "netherwood_chest");
    	GameRegistry.registerBlock(netherwood_crafting_table, "netherwood_crafting_table");
    	GameRegistry.registerBlock(netherwood_fence, "netherwood_fence");
    	
    	GameRegistry.registerBlock(enderbrick_block, "enderbrick_block");
    	GameRegistry.registerBlock(enderbrick_stairs, "enderbrick_stairs");
    	GameRegistry.registerBlock(enderbrick_slab, ItemNormalSlab.class, "enderbrick_slab", enderbrick_slab, enderbrick_slab_full, false);
    	GameRegistry.registerBlock(enderbrick_slab_full, ItemNormalSlab.class, "enderbrick_slab_full", enderbrick_slab, enderbrick_slab_full, true);
    	
    	GameRegistry.registerBlock(stone_stairs, "stone_stairs");
    	GameRegistry.registerBlock(soul_glass, "soul_glass");
    	GameRegistry.registerBlock(soul_glass_pane, "soul_glass_pane");
    	GameRegistry.registerBlock(bone_ladder, "bone_ladder");
    	GameRegistry.registerBlock(glowstone_torch, "glowstone_torch");
    	GameRegistry.registerBlock(bedrock_brick, "bedrock_brick");
    }
    
}
