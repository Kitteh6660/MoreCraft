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
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_boots, 1), new Object[] {"K K", "K K", 'K', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.field_151103_aS, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.field_151103_aS, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.field_151103_aS, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.field_151103_aS, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_sword, 1), new Object[] {"K", "K", "S", 'K', Items.field_151103_aS, 'S', Items.field_151055_y}); 
	    
	    //--Wither Bone Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.wither_bone});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.wither_bone, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.wither_bone, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_shovel, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.wither_bone, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_hoe, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.wither_bone, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_sword, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.wither_bone, 'S', Items.field_151055_y});
	    
	    //--Obsidian Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_helmet, 1), new Object[] {"KKK", "K K", 'K', Blocks.field_150343_Z});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.field_150343_Z});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.field_150343_Z});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_boots, 1), new Object[] {"K K", "K K", 'K', Blocks.field_150343_Z});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.field_150343_Z, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.field_150343_Z, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.field_150343_Z, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.field_150343_Z, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.obsidian_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.field_150343_Z, 'S', Items.field_151055_y});
	
	    //--Emerald Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.field_151166_bC});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.field_151166_bC});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.field_151166_bC});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_boots, 1), new Object[] {"K K", "K K", 'K', Items.field_151166_bC});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.field_151166_bC, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.field_151166_bC, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.field_151166_bC, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.field_151166_bC, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.emerald_sword, 1), new Object[] {"K", "K", "S", 'K', Items.field_151166_bC, 'S', Items.field_151055_y});
	
	    //--Ruby Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.ruby, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.ruby, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_shovel, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.ruby, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_hoe, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.ruby, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby_sword, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.ruby, 'S', Items.field_151055_y});
	    
	    //--Blaze Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.field_151072_bj});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.field_151072_bj});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.field_151072_bj});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_boots, 1), new Object[] {"K K", "K K", 'K', Items.field_151072_bj});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.field_151072_bj, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.field_151072_bj, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.field_151072_bj, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.field_151072_bj, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.blaze_sword, 1), new Object[] {"K", "K", "S", 'K', Items.field_151072_bj, 'S', Items.field_151055_y});
	
	    //--Ender Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_helmet, 1), new Object[] {"KKK", "K K", 'K', Items.field_151079_bi});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.field_151079_bi});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.field_151079_bi});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_boots, 1), new Object[] {"K K", "K K", 'K', Items.field_151079_bi});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.field_151079_bi, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.field_151079_bi, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_shovel, 1), new Object[] {"K", "S", "S", 'K', Items.field_151079_bi, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_hoe, 1), new Object[] {"KK", " S", " S", 'K', Items.field_151079_bi, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_sword, 1), new Object[] {"K", "K", "S", 'K', Items.field_151079_bi, 'S', Items.field_151055_y});
	    
	    //--Endstone Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.field_150377_bs, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.field_150377_bs, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.field_150377_bs, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.field_150377_bs, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ender_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.field_150377_bs, 'S', Items.field_151055_y});
	
	    //--Netherrack Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.field_150424_aL, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.field_150424_aL, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.field_150424_aL, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.field_150424_aL, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherrack_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.field_150424_aL, 'S', Items.field_151055_y});
	
	    //--Slime Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_helmet, 1), new Object[] {"###", "# #", '#', Items.field_151123_aH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_chestplate, 1), new Object[] {"# #", "###", "###", '#', Items.field_151123_aH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_leggings, 1), new Object[] {"###", "# #", "# #", '#', Items.field_151123_aH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.slime_boots, 1), new Object[] {"# #", "# #", '#', Items.field_151123_aH});
	    
	    //--Rotten Flesh Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_helmet, 1), new Object[] {"###", "# #", '#', Items.field_151078_bh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_chestplate, 1), new Object[] {"# #", "###", "###", '#', Items.field_151078_bh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_leggings, 1), new Object[] {"###", "# #", "# #", '#', Items.field_151078_bh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.flesh_boots, 1), new Object[] {"# #", "# #", '#', Items.field_151078_bh});
	    
	    //--Spider Silk Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_helmet, 1), new Object[] {"###", "# #", '#', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_chestplate, 1), new Object[] {"# #", "###", "###", '#', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_leggings, 1), new Object[] {"###", "# #", "# #", '#', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.spidersilk_boots, 1), new Object[] {"# #", "# #", '#', Blocks.field_150321_G});
	
	    //--Necro Armour--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_helmet, 1), new Object[] {"BBB", "C C", 'B', Items.field_151103_aS, 'C', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_chestplate, 1), new Object[] {"B B", "CCC", "BBB", 'B', Items.field_151103_aS, 'C', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_leggings, 1), new Object[] {"BBB", "C C", "B B", 'B', Items.field_151103_aS, 'C', Blocks.field_150321_G});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bonelord_boots, 1), new Object[] {"C C", "B B", 'B', Items.field_151103_aS, 'C', Blocks.field_150321_G});
	
	    //--Guardian Tools/Armor--\\
	    /*GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_helmet, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.guardian_scale});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.guardian_boots, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.guardian_scale});
	    */
	    //--Bedrock Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_helmet, 1), new Object[] {"KKK", "K K", 'K', Blocks.field_150357_h});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_chestplate, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.field_150357_h});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_leggings, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.field_150357_h});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_boots, 1), new Object[] {"K K", "K K", 'K', Blocks.field_150357_h});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_pickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.field_150357_h, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_axe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.field_150357_h, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_shovel, 1), new Object[] {"K", "S", "S", 'K', Blocks.field_150357_h, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_hoe, 1), new Object[] {"KK", " S", " S", 'K', Blocks.field_150357_h, 'S', Items.field_151055_y});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bedrock_sword, 1), new Object[] {"K", "K", "S", 'K', Blocks.field_150357_h, 'S', Items.field_151055_y});
	    
	    
	    //--Block Recipes--\\
	    
	    // Items into Storage Blocks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bone_block, 1), new Object[] {"###","###","###",'#', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.flesh_block, 1), new Object[] {"###","###","###",'#', Items.field_151078_bh});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ruby_block, 1), new Object[] {"###","###","###",'#', MoreCraftItems.ruby});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.blaze_block, 1), new Object[] {"###","###","###",'#', Items.field_151072_bj});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ender_block, 1), new Object[] {"###","###","###",'#', Items.field_151079_bi});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.gunpowder_block, 1), new Object[] {"###","###","###",'#', Items.field_151016_H});
	
	    // Storage Blocks into Items
	    GameRegistry.addRecipe(new ItemStack(Items.field_151103_aS, 9), new Object[] {"B",'B', MoreCraftBlocks.bone_block});
	    GameRegistry.addRecipe(new ItemStack(Items.field_151078_bh, 9), new Object[] {"B",'B', MoreCraftBlocks.flesh_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ruby, 9), new Object[] {"B",'B', MoreCraftBlocks.ruby_block});
	    GameRegistry.addRecipe(new ItemStack(Items.field_151072_bj, 9), new Object[] {"B",'B', MoreCraftBlocks.blaze_block});
	    GameRegistry.addRecipe(new ItemStack(Items.field_151079_bi, 9), new Object[] {"B",'B', MoreCraftBlocks.ender_block});
	    GameRegistry.addRecipe(new ItemStack(Items.field_151016_H, 9), new Object[] {"B",'B', MoreCraftBlocks.gunpowder_block});
	    
	    // Decorative Blocks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 1), new Object[] {"##","##",'#', MoreCraftItems.ender_brick});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bone_ladder, 3), new Object[] {"# #", "###", "# #", '#', Items.field_151103_aS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.glowstone_torch, 1), new Object[] {"G", "S", 'G', Items.field_151114_aO, 'S', Items.field_151055_y});
	
	    // Slabs and Stairs
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_stairs, 4), new Object[] {"  #"," ##","###",'#', MoreCraftBlocks.enderbrick_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.stone_stairs, 4), new Object[] {"  #"," ##","###",'#', Blocks.field_150348_b});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_stairs, 4), new Object[] {"  #"," ##","###",'#', MoreCraftBlocks.netherwood_planks});
	
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_slab, 6), new Object[] {"###",'#', MoreCraftBlocks.enderbrick_block});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_slab, 6), new Object[] {"###",'#', MoreCraftBlocks.netherwood_planks});
	
	    // Convert Logs to Planks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 4), new Object[] {"#", '#', MoreCraftBlocks.netherwood_log});
	
	    //--IMPORTANT RECIPES--\\
	    if (!MoreCraft.hardcoreRecipes) GameRegistry.addRecipe(new ItemStack(Blocks.field_150321_G, 1), new Object[] {"S S", " S ", "S S", 'S', Items.field_151007_F});
	    else GameRegistry.addRecipe(new ItemStack(Blocks.field_150321_G, 1), new Object[] {"SSS", "SSS", "SSS", 'S', Items.field_151007_F}); //If hardcore recipes are enabled, take 9 strings to make 1 cobweb.
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.wither_bone, 4), new Object[] {"OBO", "BNB", "OBO", 'O', Items.field_151044_h, 'B', Items.field_151103_aS, 'N', Items.field_151156_bN});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150467_bQ, 1, 1), new Object[] {"III", "IAI", "III", 'I', Items.field_151042_j, 'A', new ItemStack(Blocks.field_150467_bQ, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150467_bQ, 1, 0), new Object[] {"III", "IAI", "III", 'I', Items.field_151042_j, 'A', new ItemStack(Blocks.field_150467_bQ, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Items.field_151141_av, 1), new Object[] {"LLL", "LSL", "I I", 'I', Items.field_151042_j, 'L', Items.field_151116_aA, 'S', Items.field_151007_F});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherbrick_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.field_150385_bj});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.glass_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.field_150359_w});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.bone_door_item, 3), new Object[] {"BB", "BB", "BB", 'B', Items.field_151103_aS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherbrick_fence_gate, 1), new Object[] {"#B#", "#B#", 'B', Blocks.field_150385_bj, '#', Items.field_151130_bT});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.bedrock_brick, 4), new Object[] {"##", "##", '#', Blocks.field_150357_h});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.soul_glass_pane, 16), new Object[] {"###", "###", '#', MoreCraftBlocks.soul_glass});
		GameRegistry.addRecipe(new ItemStack(Items.field_151069_bo, 3), new Object[] {"# #", " # ", '#', MoreCraftBlocks.soul_glass});
		//Needed because otherwise, these vanilla items would be unobtainable.
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151070_bp, 1), new Object[] {MoreCraftItems.spider_raw});
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151100_aR, 1, 0), new Object[] {MoreCraftItems.squid_raw});
		
		/*Horse Armour*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.field_151138_bX, 1), new Object[] {"  #", "#C#", "###", '#', Items.field_151042_j, 'C', Blocks.field_150325_L});
	        GameRegistry.addRecipe(new ItemStack(Items.field_151136_bY, 1), new Object[] {"  #", "#C#", "###", '#', Items.field_151043_k, 'C', Blocks.field_150325_L});
	        GameRegistry.addRecipe(new ItemStack(Items.field_151125_bZ, 1), new Object[] {"  #", "#C#", "###", '#', Items.field_151045_i, 'C', Blocks.field_150325_L});
	    }
		/*Nether wood planks recipes*/
		GameRegistry.addRecipe(new ItemStack(Items.field_151055_y, 4), new Object[] {"B", "B", 'B', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_crafting_table, 1), new Object[] {"BB", "BB", 'B', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150415_aT, 2), new Object[] {"###", "###", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150471_bO, 1), new Object[] {"#", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_chest, 1), new Object[] {"###", "# #", "###", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150421_aI, 1), new Object[] {"###", "#D#", "###", '#', MoreCraftBlocks.netherwood_planks, 'D', Items.field_151045_i});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150323_B, 1), new Object[] {"###", "#R#", "###", '#', MoreCraftBlocks.netherwood_planks, 'R', Items.field_151137_ax});
		GameRegistry.addRecipe(new ItemStack(Blocks.field_150452_aw, 1), new Object[] {"##", '#', MoreCraftBlocks.netherwood_planks});
	
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.netherwood_door_item, 3), new Object[] {"##", "##", "##", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_fence_gate, 1), new Object[] {"I#I", "I#I", '#', MoreCraftBlocks.netherwood_planks, 'I', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_fence, 3), new Object[] {"#I#", "#I#", '#', MoreCraftBlocks.netherwood_planks, 'I', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(Items.field_151124_az, 1), new Object[] {"# #", "###", '#', MoreCraftBlocks.netherwood_planks});
		GameRegistry.addRecipe(new ItemStack(Items.field_151155_ap, 3), new Object[] {"###", "###", "S", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
	
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_slab, 6), new Object[] {"###", '#', MoreCraftBlocks.netherwood_planks});
		
		GameRegistry.addRecipe(new ItemStack(Items.field_151041_m, 1), new Object[] {"#", "#", "S", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(Items.field_151039_o, 1), new Object[] {"###", " S ", " S ", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(Items.field_151053_p, 1), new Object[] {"##", "#S", " S", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(Items.field_151038_n, 1), new Object[] {"#", "S", "S", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
		GameRegistry.addRecipe(new ItemStack(Items.field_151017_I, 1), new Object[] {"##", " S", " S", '#', MoreCraftBlocks.netherwood_planks, 'S', Items.field_151055_y});
	
	    //Food recipes
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.cake_slice, 6), new Object[] {Items.field_151105_aU});
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.apple_pie, 1), new Object[] {Items.field_151110_aK, Items.field_151034_e, Items.field_151102_aT});
	    
	    /*Rotten flesh recipes, used as substitute for leather.*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.field_151160_bD, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Items.field_151055_y, 'F', Items.field_151078_bh});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151122_aG, 1), new Object[] {Items.field_151121_aF, Items.field_151121_aF, Items.field_151121_aF, Items.field_151078_bh});
	    }
	    /*Silly recipes.*/
	    if (MoreCraft.sillyRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150357_h, 1), new Object[] {"BS", 'B', Items.field_151104_aV, 'S', Blocks.field_150348_b});
	    }
	    
	    // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
	    
	    //--Convert slabs and stairs to full blocks--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 0), new Object[] {"SS", "SS", 'S', Blocks.field_150476_ad});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 1), new Object[] {"SS", "SS", 'S', Blocks.field_150485_bF});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 2), new Object[] {"SS", "SS", 'S', Blocks.field_150487_bG});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 3), new Object[] {"SS", "SS", 'S', Blocks.field_150481_bH});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 4), new Object[] {"SS", "SS", 'S', Blocks.field_150400_ck});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 6, 5), new Object[] {"SS", "SS", 'S', Blocks.field_150401_cl});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150347_e, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150446_ar});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150322_A, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150372_bz});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150336_V, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150389_bf});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150417_aV, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150390_bg});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150385_bj, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150387_bl});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150371_ca, 6), new Object[] {"SS", "SS", 'S', Blocks.field_150370_cb}); //--Quartz stairs to quartz blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150348_b, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.stone_stairs}); //--Smooth Stone stairs to smooth stone blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_180395_cM, 6), new Object[] {"SS", "SS", 'S', Blocks.field_180396_cN});
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.enderbrick_stairs}); //--Ender Brick stairs to ender brick blocks.
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.netherwood_stairs});
	
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 1)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 2)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 4), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 4)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 1, 5), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150376_bx, 1, 5)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150347_e, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150333_U, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150348_b, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150333_U, 1, 0)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 1)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150336_V, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150333_U, 1, 4)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 5)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(Blocks.field_150385_bj, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.field_150333_U, 1, 6)});
	        //GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab2, 1, 0)}); //Already in vanilla.
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.enderbrick_block, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.enderbrick_slab, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.netherwood_slab, 1, 0)});
	    }
	    
	    //--Dismantling objects--\\
	    if (MoreCraft.salvageRecipes) {
	    	//Items
	        GameRegistry.addRecipe(new ItemStack(Items.field_151055_y, 1), new Object[] {"AA", "AA", 'A', Items.field_151032_g});

	        //Blocks
	        //Fences
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180407_aO});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180408_aP});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180404_aQ});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180403_aR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180406_aS});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_180405_aT});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {MoreCraftBlocks.netherwood_fence});
	        //Fence Gates
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180390_bo});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180391_bp});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180392_bq});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180386_br});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180385_bs});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {Blocks.field_180387_bt});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 6), new Object[] {MoreCraftBlocks.netherwood_fence_gate});
	        //Doors
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179570_aq});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179569_ar});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179568_as});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179567_at});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179571_av});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_179572_au});
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 4), new Object[] {Items.field_151124_az});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] {Items.field_151155_ap});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 3), new Object[] {Items.field_151031_f});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 8), new Object[] {Blocks.field_150486_ae});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 3), new Object[] {Blocks.field_150415_aT});

	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150347_e, 1), new Object[] {Blocks.field_150442_at});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y, 2), new Object[] {Blocks.field_150468_ap});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 4), new Object[] {Blocks.field_150462_ai});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151128_bU, 4), new Object[] {Blocks.field_150371_ca});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 8), new Object[] {MoreCraftBlocks.netherwood_chest});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.netherwood_planks, 4), new Object[] {MoreCraftBlocks.netherwood_crafting_table});
	    }
	    
	    // ~ --FURNACE RECIPES -- ~ \\
	
	    //--Procession--\\
	    GameRegistry.addSmelting(MoreCraftBlocks.ruby_ore, new ItemStack(MoreCraftItems.ruby), 2.0F);
	    GameRegistry.addSmelting(Blocks.field_150377_bs, new ItemStack(MoreCraftItems.ender_brick), 1.0F); 
	    GameRegistry.addSmelting(Blocks.field_150425_aM, new ItemStack(MoreCraftBlocks.soul_glass), 0.5F); 
	    
	    //--Cooking food--\\
	    GameRegistry.addSmelting(Items.field_151078_bh, new ItemStack(MoreCraftItems.cooked_flesh), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.spider_raw, new ItemStack(MoreCraftItems.spider_cooked), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.squid_raw, new ItemStack(MoreCraftItems.squid_cooked), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.guardian_meat_raw, new ItemStack(MoreCraftItems.guardian_meat_cooked), 1.0F);
	    GameRegistry.addSmelting(Items.field_151110_aK, new ItemStack(MoreCraftItems.egg_cooked), 1.0F);
		
	    //--Melting down--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addSmelting(Items.field_151139_aw, new ItemStack(Items.field_151042_j, 2), 0.5F);
	        GameRegistry.addSmelting(Items.field_151143_au, new ItemStack(Items.field_151042_j, 5), 0.5F);
	        GameRegistry.addSmelting(Items.field_151066_bu, new ItemStack(Items.field_151042_j, 7), 0.5F);
	    }
	}
}
