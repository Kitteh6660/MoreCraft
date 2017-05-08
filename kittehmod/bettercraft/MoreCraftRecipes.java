package kittehmod.bettercraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import kittehmod.bettercraft.MoreCraftItems;
import kittehmod.bettercraft.MoreCraftBlocks;

public class MoreCraftRecipes {
	
	public static void registerRecipes() {	    
	    //--Bone Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_boots, 1), new Object[] {"K K", "K K", 'K', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_sword, 1), new Object[] {"K", "K", "S", 'K', Items.bone, 'S', Items.stick}); 
	    
	    //--Wither Bone Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.wither_bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.wither_bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_shovel, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.wither_bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_hoe, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.wither_bone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_sword, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.wither_bone, 'S', Items.stick});
	    
	    //--Obsidian Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_helmet, 1), new Object[] {"KKK", "K K", 'K', Blocks.obsidian});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.obsidian});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.obsidian});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_boots, 1), new Object[] {"K K", "K K", 'K', Blocks.obsidian});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.obsidian, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.obsidian, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.obsidian, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.obsidian, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.obsidian, 'S', Items.stick});
	
	    //--Emerald Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.emerald});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.emerald});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.emerald});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_boots, 1), new Object[] {"K K", "K K", 'K', Items.emerald});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.emerald, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.emerald, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.emerald, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.emerald, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_sword, 1), new Object[] {"K", "K", "S", 'K', Items.emerald, 'S', Items.stick});
	
	    //--Ruby Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.ruby, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.ruby, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_shovel, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.ruby, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_hoe, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.ruby, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_sword, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.ruby, 'S', Items.stick});
	    
	    //--Blaze Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.blaze_rod});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.blaze_rod});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.blaze_rod});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_boots, 1), new Object[] {"K K", "K K", 'K', Items.blaze_rod});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.blaze_rod, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.blaze_rod, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.blaze_rod, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.blaze_rod, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_sword, 1), new Object[] {"K", "K", "S", 'K', Items.blaze_rod, 'S', Items.stick});
	
	    //--Ender Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.ender_pearl});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.ender_pearl});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.ender_pearl});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_boots, 1), new Object[] {"K K", "K K", 'K', Items.ender_pearl});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.ender_pearl, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.ender_pearl, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.ender_pearl, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.ender_pearl, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_sword, 1), new Object[] {"K", "K", "S", 'K', Items.ender_pearl, 'S', Items.stick});
	    
	    //--Endstone Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.end_stone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.end_stone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.end_stone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.end_stone, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.end_stone, 'S', Items.stick});
	
	    //--Netherrack Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.netherrack, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.netherrack, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.netherrack, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.netherrack, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.netherrack, 'S', Items.stick});
	
	    //--Slime Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_helmet, 1), new Object[] {"###", "# #", '#', Items.slime_ball});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_chestplate, 1), new Object[] {"# #", "###", "###", '#', Items.slime_ball});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_leggings, 1), new Object[] {"###", "# #", "# #", '#', Items.slime_ball});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_boots, 1), new Object[] {"# #", "# #", '#', Items.slime_ball});
	    
	    //--Rotten Flesh Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_helmet, 1), new Object[] {"###", "# #", '#', Items.rotten_flesh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_chestplate, 1), new Object[] {"# #", "###", "###", '#', Items.rotten_flesh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_leggings, 1), new Object[] {"###", "# #", "# #", '#', Items.rotten_flesh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_boots, 1), new Object[] {"# #", "# #", '#', Items.rotten_flesh});
	    
	    //--Spider Silk Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_helmet, 1), new Object[] {"###", "# #", '#', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_chestplate, 1), new Object[] {"# #", "###", "###", '#', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_leggings, 1), new Object[] {"###", "# #", "# #", '#', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_boots, 1), new Object[] {"# #", "# #", '#', Blocks.web});
	
	    //--Necro Armour--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_helmet, 1), new Object[] {"BBB", "C C", 'B', Items.bone, 'C', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_chestplate, 1), new Object[] {"B B", "CCC", "BBB", 'B', Items.bone, 'C', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_leggings, 1), new Object[] {"BBB", "C C", "B B", 'B', Items.bone, 'C', Blocks.web});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_boots, 1), new Object[] {"C C", "B B", 'B', Items.bone, 'C', Blocks.web});
	
	    //--Guardian Tools/Armor--\\
	    /*GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.guardian_scale});
	    */
	    //--Bedrock Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_helmet, 1), new Object[] {"KKK", "K K", 'K', Blocks.bedrock});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.bedrock});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.bedrock});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_boots, 1), new Object[] {"K K", "K K", 'K', Blocks.bedrock});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.bedrock, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.bedrock, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.bedrock, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.bedrock, 'S', Items.stick});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.bedrock, 'S', Items.stick});
	    
	    
	    //--Block Recipes--\\
	    
	    // Items into Storage Blocks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bone_block, 1), new Object[] {"###","###","###",'#', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.flesh_block, 1), new Object[] {"###","###","###",'#', Items.rotten_flesh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ruby_block, 1), new Object[] {"###","###","###",'#', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.blaze_block, 1), new Object[] {"###","###","###",'#', Items.blaze_rod});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ender_block, 1), new Object[] {"###","###","###",'#', Items.ender_pearl});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.gunpowder_block, 1), new Object[] {"###","###","###",'#', Items.gunpowder});
	
	    // Storage Blocks into Items
	    GameRegistry.addRecipe(new ItemStack(Items.bone, 9), new Object[] {"B",'B', MoreCraftBlocks.bone_block});
	    GameRegistry.addRecipe(new ItemStack(Items.rotten_flesh, 9), new Object[] {"B",'B', MoreCraftBlocks.flesh_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby, 9), new Object[] {"B",'B', MoreCraftBlocks.ruby_block});
	    GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 9), new Object[] {"B",'B', MoreCraftBlocks.blaze_block});
	    GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] {"B",'B', MoreCraftBlocks.ender_block});
	    GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] {"B",'B', MoreCraftBlocks.gunpowder_block});
	    
	    // Decorative Blocks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 1), new Object[] {"##","##",'#', MoreCraftItems.ender_brick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bone_ladder, 3), new Object[] {"# #", "###", "# #", '#', Items.bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.glowstone_torch, 1), new Object[] {"G", "S", 'G', Items.glowstone_dust, 'S', Items.stick});
	
	    // Slabs and Stairs
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_stairs, 4), new Object[] {"  #"," ##","###",'#', MoreCraftBlocks.enderbrick_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.stone_stairs, 4), new Object[] {"  #"," ##","###",'#', Blocks.stone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_stairs, 4), new Object[] {"  #"," ##","###",'#', MoreCraftBlocks.netherwood_planks});
	
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_slab, 6), new Object[] {"###",'#', MoreCraftBlocks.enderbrick_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_slab, 6), new Object[] {"###",'#', MoreCraftBlocks.netherwood_planks});
	
	    // Convert Logs to Planks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 4), new Object[] {"#", '#', MoreCraftBlocks.netherwood_log});
	
	    //--IMPORTANT RECIPES--\\
	    if (!MoreCraft.hardcoreRecipes) GameRegistry.addRecipe(new ItemStack(Blocks.web, 1), new Object[] {"S S", " S ", "S S", 'S', Items.string});
	    else GameRegistry.addRecipe(new ItemStack(Blocks.web, 1), new Object[] {"SSS", "SSS", "SSS", 'S', Items.string}); //If hardcore recipes are enabled, take 9 strings to make 1 cobweb.
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.wither_bone, 4), new Object[] {"OBO", "BNB", "OBO", 'O', Items.coal, 'B', Items.bone, 'N', Items.nether_star});
		GameRegistry.addRecipe(new ItemStack(Blocks.anvil, 1, 1), new Object[] {"III", "IAI", "III", 'I', Items.iron_ingot, 'A', new ItemStack(Blocks.anvil, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Blocks.anvil, 1, 0), new Object[] {"III", "IAI", "III", 'I', Items.iron_ingot, 'A', new ItemStack(Blocks.anvil, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Items.saddle, 1), new Object[] {"LLL", "LSL", "I I", 'I', Items.iron_ingot, 'L', Items.leather, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherbrick_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.nether_brick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.glass_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.glass});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Items.bone});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherbrick_fence_gate, 1), new Object[] {"#B#", "#B#", 'B', Blocks.nether_brick, '#', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bedrock_brick, 4), new Object[] {"##", "##", '#', Blocks.bedrock});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.soul_glass_pane, 16), new Object[] {"###", "###", '#', MoreCraftBlocks.soul_glass});
		GameRegistry.addRecipe(new ItemStack(Items.glass_bottle, 3), new Object[] {"# #", " # ", '#', MoreCraftBlocks.soul_glass});
		//Needed because otherwise, these vanilla items would be unobtainable.
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.spider_eye, 1), new Object[] {MoreCraftItems.spider_raw});
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 0), new Object[] {MoreCraftItems.squid_raw});
		
		/*Horse Armour*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.iron_ingot, 'C', Blocks.wool});
	        GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.gold_ingot, 'C', Blocks.wool});
	        GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.diamond, 'C', Blocks.wool});
	    }
		/*Nether wood planks recipes*/
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_crafting_table, 1), new Object[] {"BB", "BB", 'B', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_chest, 1), new Object[] {"###", "# #", "###", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherwood_door_item, 3), new Object[] {"##", "##", "##", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_fence_gate, 1), new Object[] {"I#I", "I#I", '#', MoreCraftBlocks.netherwood_planks, 'I', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_fence, 3), new Object[] {"#I#", "#I#", '#', MoreCraftBlocks.netherwood_planks, 'I', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_slab, 6), new Object[] {"###", '#', MoreCraftBlocks.netherwood_planks});
		
	    //Food recipes
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.cake_slice, 6), new Object[] {Items.cake});
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.apple_pie, 1), new Object[] {Items.egg, Items.apple, Items.sugar});
	    
	    /*Rotten flesh recipes, used as substitute for leather.*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.item_frame, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Items.stick, 'F', Items.rotten_flesh});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] {Items.paper, Items.paper, Items.paper, Items.rotten_flesh});
	    }
	    /*Silly recipes.*/
	    if (MoreCraft.sillyRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.bedrock, 1), new Object[] {"BS", 'B', Items.bed, 'S', Blocks.stone});
	    }
	    
	    // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
	    
	    //--Convert slabs and stairs to full blocks--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 0), new Object[] {"SS", "SS", 'S', Blocks.oak_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 1), new Object[] {"SS", "SS", 'S', Blocks.spruce_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 2), new Object[] {"SS", "SS", 'S', Blocks.birch_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 3), new Object[] {"SS", "SS", 'S', Blocks.jungle_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 4), new Object[] {"SS", "SS", 'S', Blocks.acacia_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 5), new Object[] {"SS", "SS", 'S', Blocks.dark_oak_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 6), new Object[] {"SS", "SS", 'S', Blocks.stone_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 6), new Object[] {"SS", "SS", 'S', Blocks.sandstone_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 6), new Object[] {"SS", "SS", 'S', Blocks.brick_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 6), new Object[] {"SS", "SS", 'S', Blocks.stone_brick_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 6), new Object[] {"SS", "SS", 'S', Blocks.nether_brick_stairs});
	        GameRegistry.addRecipe(new ItemStack(Blocks.quartz_block, 6), new Object[] {"SS", "SS", 'S', Blocks.quartz_stairs}); //--Quartz stairs to quartz blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.stone, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.stone_stairs}); //--Smooth Stone stairs to smooth stone blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 6), new Object[] {"SS", "SS", 'S', Blocks.red_sandstone_stairs});
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.enderbrick_stairs}); //--Ender Brick stairs to ender brick blocks.
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.netherwood_stairs});
	
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 1)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 2)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 4), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 4)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 5), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 5)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.stone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 0)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 1)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 4)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 5)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 6)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab2, 1, 0)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.enderbrick_slab, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.netherwood_slab, 1, 0)});
	    }
	    
	    //--Dismantling objects--\\
	    if (MoreCraft.salvageRecipes) {
	    	//Items
	        GameRegistry.addRecipe(new ItemStack(Items.stick, 1), new Object[] {"AA", "AA", 'A', Items.arrow});

	        //Blocks
	        //Fences
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.oak_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.spruce_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.birch_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.jungle_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.dark_oak_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.acacia_fence});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {MoreCraftBlocks.netherwood_fence});
	        //Fence Gates
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.oak_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.spruce_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.birch_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.jungle_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.dark_oak_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.acacia_fence_gate});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {MoreCraftBlocks.netherwood_fence_gate});
	        //Doors
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.oak_door});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.spruce_door});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.birch_door});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.jungle_door});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.dark_oak_door});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.acacia_door});
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] {Items.boat});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.sign});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 3), new Object[] {Items.bow});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 8), new Object[] {Blocks.chest});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 3), new Object[] {Blocks.trapdoor});

	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] {Blocks.lever});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.ladder});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] {Blocks.crafting_table});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new Object[] {Blocks.quartz_block});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 8), new Object[] {MoreCraftBlocks.netherwood_chest});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 4), new Object[] {MoreCraftBlocks.netherwood_crafting_table});
	    }
	    
	    // ~ --FURNACE RECIPES -- ~ \\
	
	    //--Procession--\\
	    GameRegistry.addSmelting(MoreCraftBlocks.ruby_ore, new ItemStack(MoreCraftItems.ruby), 2.0F);
	    GameRegistry.addSmelting(Blocks.end_stone, new ItemStack(MoreCraftItems.ender_brick), 1.0F); 
	    GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(MoreCraftBlocks.soul_glass), 0.5F); 
	    
	    //--Cooking food--\\
	    GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(MoreCraftItems.cooked_flesh), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.spider_raw, new ItemStack(MoreCraftItems.spider_cooked), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.squid_raw, new ItemStack(MoreCraftItems.squid_cooked), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.guardian_meat_raw, new ItemStack(MoreCraftItems.guardian_meat_cooked), 1.0F);
	    GameRegistry.addSmelting(Items.egg, new ItemStack(MoreCraftItems.egg_cooked), 1.0F);
		
	    //--Melting down--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addSmelting(Items.iron_door, new ItemStack(Items.iron_ingot, 2), 0.5F);
	        GameRegistry.addSmelting(Items.minecart, new ItemStack(Items.iron_ingot, 5), 0.5F);
	        GameRegistry.addSmelting(Items.cauldron, new ItemStack(Items.iron_ingot, 7), 0.5F);
	    }
	}
}
