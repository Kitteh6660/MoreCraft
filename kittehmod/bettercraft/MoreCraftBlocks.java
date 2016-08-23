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
import kittehmod.bettercraft.block.BlockNormalSlabDouble;
import kittehmod.bettercraft.block.BlockNormalSlabHalf;
import kittehmod.bettercraft.block.BlockNormalStairs;
import kittehmod.bettercraft.block.BlockOreRuby;
import kittehmod.bettercraft.block.BlockSoulGlass;
import kittehmod.bettercraft.block.BlockStorage;
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
    public static final Block netherbrick_door = new BlockMoreDoors(Material.field_151576_e).func_149711_c(5.0F).func_149752_b(20.0F).func_149672_a(Block.field_149769_e).func_149663_c("netherbrick_door");
	public static final Block netherwood_door = new BlockMoreDoors(Material.field_151575_d).func_149711_c(2.5F).func_149752_b(7.5F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_door");
	public static final Block glass_door = new BlockMoreDoors(Material.field_151592_s).func_149711_c(1.0F).func_149752_b(3.0F).func_149672_a(Block.field_149778_k).func_149663_c("glass_door");
	public static final Block bone_door = new BlockMoreDoors(Material.field_151576_e).func_149711_c(2.5F).func_149752_b(7.5F).func_149672_a(Block.field_149766_f).func_149663_c("bone_door");
    public static final Block netherbrick_fence_gate = new BlockFenceGate(BlockPlanks.EnumType.OAK).func_149711_c(2.0F).func_149752_b(20.0F).func_149672_a(Block.field_149769_e).func_149663_c("netherbrick_fence_gate");
    public static final Block netherwood_fence_gate = new BlockFenceGate(BlockPlanks.EnumType.SPRUCE).func_149711_c(2.0F).func_149752_b(20.0F).func_149672_a(Block.field_149769_e).func_149663_c("netherwood_fence_gate");

    //Ores
    public static final Block ruby_ore = new BlockOreRuby(Material.field_151576_e).func_149711_c(4.0F).func_149752_b(2.0F).func_149672_a(Block.field_149769_e).func_149663_c("ruby_ore");
   
    //Storage Blocks
    public static final Block bone_block = new BlockStorage(Material.field_151576_e).func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149769_e).func_149663_c("bone_block");
    public static final Block flesh_block = new BlockStorage(Material.field_151580_n).func_149711_c(1.0F).func_149752_b(2.0F).func_149672_a(Block.field_149775_l).func_149663_c("flesh_block");
    public static final Block ruby_block = new BlockStorage(Material.field_151576_e).func_149711_c(6.0F).func_149752_b(10.0F).func_149672_a(Block.field_149777_j).func_149663_c("ruby_block");
    public static final Block blaze_block = new BlockBlazeBlock().func_149711_c(10.0F).func_149752_b(15.0F).func_149672_a(Block.field_149777_j).func_149715_a(1.0F).func_149663_c("blaze_block");
    public static final Block ender_block = new BlockStorage(Material.field_151576_e).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(Block.field_149769_e).func_149663_c("ender_block");
    public static final Block gunpowder_block = new BlockGunpowder().func_149711_c(0.5F).func_149752_b(5.0F).func_149672_a(Block.field_149769_e).func_149663_c("gunpowder_block");
    
    //Netherwood
    public static final Block netherwood_log = new BlockNetherLog().func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_log");
    public static final Block netherwood_planks = new BlockNetherWood().func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_planks");
    public static final BlockNetherLeaves netherwood_leaves = (BlockNetherLeaves) new BlockNetherLeaves().func_149711_c(0.2F).func_149713_g(1).func_149672_a(Block.field_149779_h).func_149663_c("netherwood_leaves");   
    public static final Block netherwood_sapling = new BlockNetherSapling().func_149711_c(0F).func_149752_b(1.0F).func_149672_a(Block.field_149779_h).func_149663_c("netherwood_sapling");
    public static final Block netherwood_stairs = new BlockNormalStairs(netherwood_planks.func_176223_P()).func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_stairs");
    public static final Block netherwood_slab = new BlockNormalSlabHalf(Material.field_151575_d).func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_slab");
    public static final Block netherwood_slab_full = new BlockNormalSlabDouble(Material.field_151575_d).func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_slab");
    public static final BlockNetherwoodChest netherwood_chest = (BlockNetherwoodChest)(new BlockNetherwoodChest(0)).func_149711_c(2.5F).func_149752_b(7.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_chest");    
    public static final Block netherwood_crafting_table = new BlockNetherwoodCraftingTable().func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_crafting_table");
    public static final Block netherwood_fence = new BlockFence(Material.field_151575_d).func_149711_c(2.0F).func_149752_b(20.0F).func_149672_a(Block.field_149766_f).func_149663_c("netherwood_fence");

    //Ender Bricks
    public static final Block enderbrick_block = new BlockNormal(Material.field_151576_e).func_149711_c(10.0F).func_149752_b(15.0F).func_149672_a(Block.field_149769_e).func_149663_c("enderbrick_block");
    public static final Block enderbrick_stairs = new BlockNormalStairs(enderbrick_block.func_176223_P()).func_149711_c(10.0F).func_149752_b(15.0F).func_149672_a(Block.field_149769_e).func_149663_c("enderbrick_stairs");
    public static final Block enderbrick_slab = new BlockNormalSlabHalf(Material.field_151576_e).func_149711_c(10.0F).func_149752_b(15.0F).func_149672_a(Block.field_149769_e).func_149663_c("enderbrick_slab");
    public static final Block enderbrick_slab_full = new BlockNormalSlabDouble(Material.field_151576_e).func_149711_c(10.0F).func_149752_b(15.0F).func_149672_a(Block.field_149769_e).func_149663_c("enderbrick_slab");
    
    //Others
    public static final Block stone_stairs = new BlockNormalStairs(Blocks.field_150348_b.func_176223_P()).func_149711_c(1.5F).func_149752_b(10.0F).func_149672_a(Block.field_149769_e).func_149663_c("stone_stairs");
    public static final Block soul_glass = new BlockSoulGlass(Material.field_151592_s, false).func_149711_c(0.5F).func_149752_b(15.0F).func_149672_a(Block.field_149778_k).func_149663_c("soul_glass");
    public static final Block soul_glass_pane = new BlockMorePanes(Material.field_151592_s, false).func_149711_c(0.5F).func_149752_b(15.0F).func_149672_a(Block.field_149778_k).func_149663_c("soul_glass_pane");
    public static final Block bone_ladder = new BlockBoneLadder().func_149711_c(1.5F).func_149752_b(10.0F).func_149672_a(Block.field_149769_e).func_149663_c("bone_ladder");
    public static final Block glowstone_torch = new BlockGlowstoneTorch().func_149663_c("glowstone_torch");
    public static final Block bedrock_brick = new BlockNormal(Material.field_151576_e).func_149722_s().func_149752_b(5.0F).func_149672_a(Block.field_149769_e).func_149663_c("bedrock_brick");    

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
    	GameRegistry.registerBlock(netherwood_slab, "netherwood_slab");
    	GameRegistry.registerBlock(netherwood_slab_full, "netherwood_slab_full");
    	GameRegistry.registerBlock(netherwood_chest, "netherwood_chest");
    	GameRegistry.registerBlock(netherwood_crafting_table, "netherwood_crafting_table");
    	GameRegistry.registerBlock(netherwood_fence, "netherwood_fence");
    	
    	GameRegistry.registerBlock(enderbrick_block, "enderbrick_block");
    	GameRegistry.registerBlock(enderbrick_stairs, "enderbrick_stairs");
    	GameRegistry.registerBlock(enderbrick_slab, "enderbrick_slab");
    	GameRegistry.registerBlock(enderbrick_slab_full, "enderbrick_slab_full");
    	
    	GameRegistry.registerBlock(stone_stairs, "stone_stairs");
    	GameRegistry.registerBlock(soul_glass, "soul_glass");
    	GameRegistry.registerBlock(soul_glass_pane, "soul_glass_pane");
    	GameRegistry.registerBlock(bone_ladder, "bone_ladder");
    	GameRegistry.registerBlock(glowstone_torch, "glowstone_torch");
    	GameRegistry.registerBlock(bedrock_brick, "bedrock_brick");
    }
    
}
