package kittehmod.bettercraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import kittehmod.bettercraft.MoreCraftItems;
import kittehmod.bettercraft.MoreCraftBlocks;

public class MoreCraftRecipes {
	
	public static void registerRecipes() {	    
	    //--Bone Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_HELMET, 1), new Object[] {"KKK", "K K", 'K', Items.BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_BOOTS, 1), new Object[] {"K K", "K K", 'K', Items.BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Items.BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_HOE, 1), new Object[] {"KK", " S", " S", 'K', Items.BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_SWORD, 1), new Object[] {"K", "K", "S", 'K', Items.BONE, 'S', Items.STICK}); 
	    
	    //--Wither Bone Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_HELMET, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.WITHER_BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.WITHER_BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.WITHER_BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_BOOTS, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.WITHER_BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.WITHER_BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.WITHER_BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.WITHER_BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_HOE, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.WITHER_BONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHERBONE_SWORD, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.WITHER_BONE, 'S', Items.STICK});
	    
	    //--Obsidian Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_HELMET, 1), new Object[] {"KKK", "K K", 'K', Blocks.OBSIDIAN});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.OBSIDIAN});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.OBSIDIAN});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_BOOTS, 1), new Object[] {"K K", "K K", 'K', Blocks.OBSIDIAN});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.OBSIDIAN, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.OBSIDIAN, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Blocks.OBSIDIAN, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_HOE, 1), new Object[] {"KK", " S", " S", 'K', Blocks.OBSIDIAN, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.OBSIDIAN_SWORD, 1), new Object[] {"K", "K", "S", 'K', Blocks.OBSIDIAN, 'S', Items.STICK});
	
	    //--Emerald Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_HELMET, 1), new Object[] {"KKK", "K K", 'K', Items.EMERALD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.EMERALD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.EMERALD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_BOOTS, 1), new Object[] {"K K", "K K", 'K', Items.EMERALD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.EMERALD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.EMERALD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Items.EMERALD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_HOE, 1), new Object[] {"KK", " S", " S", 'K', Items.EMERALD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.EMERALD_SWORD, 1), new Object[] {"K", "K", "S", 'K', Items.EMERALD, 'S', Items.STICK});
	
	    //--Ruby Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_HELMET, 1), new Object[] {"KKK", "K K", 'K', MoreCraftItems.RUBY});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', MoreCraftItems.RUBY});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', MoreCraftItems.RUBY});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_BOOTS, 1), new Object[] {"K K", "K K", 'K', MoreCraftItems.RUBY});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', MoreCraftItems.RUBY, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', MoreCraftItems.RUBY, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', MoreCraftItems.RUBY, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_HOE, 1), new Object[] {"KK", " S", " S", 'K', MoreCraftItems.RUBY, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY_SWORD, 1), new Object[] {"K", "K", "S", 'K', MoreCraftItems.RUBY, 'S', Items.STICK});
	    
	    //--Blaze Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_HELMET, 1), new Object[] {"KKK", "K K", 'K', Items.BLAZE_ROD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.BLAZE_ROD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.BLAZE_ROD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_BOOTS, 1), new Object[] {"K K", "K K", 'K', Items.BLAZE_ROD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.BLAZE_ROD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.BLAZE_ROD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Items.BLAZE_ROD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_HOE, 1), new Object[] {"KK", " S", " S", 'K', Items.BLAZE_ROD, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BLAZE_SWORD, 1), new Object[] {"K", "K", "S", 'K', Items.BLAZE_ROD, 'S', Items.STICK});
	
	    //--Ender Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_HELMET, 1), new Object[] {"KKK", "K K", 'K', Items.ENDER_PEARL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.ENDER_PEARL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.ENDER_PEARL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_BOOTS, 1), new Object[] {"K K", "K K", 'K', Items.ENDER_PEARL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.ENDER_PEARL, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.ENDER_PEARL, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Items.ENDER_PEARL, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_HOE, 1), new Object[] {"KK", " S", " S", 'K', Items.ENDER_PEARL, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_SWORD, 1), new Object[] {"K", "K", "S", 'K', Items.ENDER_PEARL, 'S', Items.STICK});
	    
	    //--Endstone Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.END_STONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.END_STONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Blocks.END_STONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_HOE, 1), new Object[] {"KK", " S", " S", 'K', Blocks.END_STONE, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDER_SWORD, 1), new Object[] {"K", "K", "S", 'K', Blocks.END_STONE, 'S', Items.STICK});
	
	    //--Netherrack Tools--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERRACK_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.NETHERRACK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERRACK_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.NETHERRACK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERRACK_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Blocks.NETHERRACK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERRACK_HOE, 1), new Object[] {"KK", " S", " S", 'K', Blocks.NETHERRACK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERRACK_SWORD, 1), new Object[] {"K", "K", "S", 'K', Blocks.NETHERRACK, 'S', Items.STICK});
	
	    //--Slime Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SLIME_HELMET, 1), new Object[] {"###", "# #", '#', Items.SLIME_BALL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SLIME_CHESTPLATE, 1), new Object[] {"# #", "###", "###", '#', Items.SLIME_BALL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SLIME_LEGGINGS, 1), new Object[] {"###", "# #", "# #", '#', Items.SLIME_BALL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SLIME_BOOTS, 1), new Object[] {"# #", "# #", '#', Items.SLIME_BALL});
	    
	    //--Rotten Flesh Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.FLESH_HELMET, 1), new Object[] {"###", "# #", '#', Items.ROTTEN_FLESH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.FLESH_CHESTPLATE, 1), new Object[] {"# #", "###", "###", '#', Items.ROTTEN_FLESH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.FLESH_LEGGINGS, 1), new Object[] {"###", "# #", "# #", '#', Items.ROTTEN_FLESH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.FLESH_BOOTS, 1), new Object[] {"# #", "# #", '#', Items.ROTTEN_FLESH});
	    
	    //--Spider Silk Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SPIDERSILK_HELMET, 1), new Object[] {"###", "# #", '#', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SPIDERSILK_CHESTPLATE, 1), new Object[] {"# #", "###", "###", '#', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SPIDERSILK_LEGGINGS, 1), new Object[] {"###", "# #", "# #", '#', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.SPIDERSILK_BOOTS, 1), new Object[] {"# #", "# #", '#', Blocks.WEB});
	
	    //--Necro Armour--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONELORD_HELMET, 1), new Object[] {"BBB", "C C", 'B', Items.BONE, 'C', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONELORD_CHESTPLATE, 1), new Object[] {"B B", "CCC", "BBB", 'B', Items.BONE, 'C', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONELORD_LEGGINGS, 1), new Object[] {"BBB", "C C", "B B", 'B', Items.BONE, 'C', Blocks.WEB});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONELORD_BOOTS, 1), new Object[] {"C C", "B B", 'B', Items.BONE, 'C', Blocks.WEB});
	
	    //--Enderdragon Armour--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDERDRAGON_HELMET, 1), new Object[] {"###", "# #", '#', MoreCraftItems.ENDERDRAGON_SCALES});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDERDRAGON_CHESTPLATE, 1), new Object[] {"# #", "###", "###", '#', MoreCraftItems.ENDERDRAGON_SCALES});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDERDRAGON_LEGGINGS, 1), new Object[] {"###", "# #", "# #", '#', MoreCraftItems.ENDERDRAGON_SCALES});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.ENDERDRAGON_BOOTS, 1), new Object[] {"# #", "# #", '#', MoreCraftItems.ENDERDRAGON_SCALES});
	    
	    //--Bedrock Tools/Armor--\\
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_HELMET, 1), new Object[] {"KKK", "K K", 'K', Blocks.BEDROCK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_CHESTPLATE, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.BEDROCK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_LEGGINGS, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.BEDROCK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_BOOTS, 1), new Object[] {"K K", "K K", 'K', Blocks.BEDROCK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_PICKAXE, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.BEDROCK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_AXE, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.BEDROCK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_SHOVEL, 1), new Object[] {"K", "S", "S", 'K', Blocks.BEDROCK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_HOE, 1), new Object[] {"KK", " S", " S", 'K', Blocks.BEDROCK, 'S', Items.STICK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BEDROCK_SWORD, 1), new Object[] {"K", "K", "S", 'K', Blocks.BEDROCK, 'S', Items.STICK});
	    
	    
	    //--Block Recipes--\\
	    
	    // Items into Storage Blocks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.FLESH_BLOCK, 1), new Object[] {"###","###","###",'#', Items.ROTTEN_FLESH});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.RUBY_BLOCK, 1), new Object[] {"###","###","###",'#', MoreCraftItems.RUBY});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.BLAZE_BLOCK, 1), new Object[] {"###","###","###",'#', Items.BLAZE_ROD});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ENDER_BLOCK, 1), new Object[] {"###","###","###",'#', Items.ENDER_PEARL});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.GUNPOWDER_BLOCK, 1), new Object[] {"###","###","###",'#', Items.GUNPOWDER});
	
	    // Storage Blocks into Items
	    GameRegistry.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 9), new Object[] {"B",'B', MoreCraftBlocks.FLESH_BLOCK});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.RUBY, 9), new Object[] {"B",'B', MoreCraftBlocks.RUBY_BLOCK});
	    GameRegistry.addRecipe(new ItemStack(Items.BLAZE_ROD, 9), new Object[] {"B",'B', MoreCraftBlocks.BLAZE_BLOCK});
	    GameRegistry.addRecipe(new ItemStack(Items.ENDER_PEARL, 9), new Object[] {"B",'B', MoreCraftBlocks.ENDER_BLOCK});
	    GameRegistry.addRecipe(new ItemStack(Items.GUNPOWDER, 9), new Object[] {"B",'B', MoreCraftBlocks.GUNPOWDER_BLOCK});
	    
	    // Decorative Blocks
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.BONE_LADDER, 3), new Object[] {"# #", "###", "# #", '#', Items.BONE});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.GLOWSTONE_TORCH, 1), new Object[] {"G", "S", 'G', Items.GLOWSTONE_DUST, 'S', Items.STICK});
	
	    // Slabs and Stairs
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ENDSTONE_BRICK_STAIRS, 4), new Object[] {"  #"," ##","###",'#', Blocks.END_BRICKS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_STAIRS, 4), new Object[] {"  #"," ##","###",'#', MoreCraftBlocks.NETHERWOOD_PLANKS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.STONE_STAIRS, 4), new Object[] {"  #"," ##","###",'#', Blocks.STONE});
	
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.ENDSTONE_BRICK_SLAB, 6), new Object[] {"###",'#', Blocks.END_BRICKS});
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_SLAB, 6), new Object[] {"###",'#', MoreCraftBlocks.NETHERWOOD_PLANKS});
	
	    // Convert Logs to Planks
	    GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 4), new Object[] {"#", '#', MoreCraftBlocks.NETHERWOOD_LOG});
	
	    //--IMPORTANT RECIPES--\\
	    if (!MoreCraft.hardcoreRecipes) GameRegistry.addRecipe(new ItemStack(Blocks.WEB, 1), new Object[] {"S S", " S ", "S S", 'S', Items.STRING});
	    else GameRegistry.addRecipe(new ItemStack(Blocks.WEB, 1), new Object[] {"SSS", "SSS", "SSS", 'S', Items.STRING}); //If hardcore recipes are enabled, take 9 strings to make 1 cobweb.
	    GameRegistry.addRecipe(new ItemStack(MoreCraftItems.WITHER_BONE, 4), new Object[] {"OBO", "BNB", "OBO", 'O', Items.COAL, 'B', Items.BONE, 'N', Items.NETHER_STAR});
		GameRegistry.addRecipe(new ItemStack(Blocks.ANVIL, 1, 1), new Object[] {"III", "IAI", "III", 'I', Items.IRON_INGOT, 'A', new ItemStack(Blocks.ANVIL, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Blocks.ANVIL, 1, 0), new Object[] {"III", "IAI", "III", 'I', Items.IRON_INGOT, 'A', new ItemStack(Blocks.ANVIL, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Items.SADDLE, 1), new Object[] {"LLL", "LSL", "I I", 'I', Items.IRON_INGOT, 'L', Items.LEATHER, 'S', Items.STRING});
		if (!MoreCraft.hardcoreRecipes) GameRegistry.addRecipe(new ItemStack(Items.NAME_TAG, 1), new Object[] {"  S", " P ", "P  ", 'S', Items.STRING, 'P', Items.PAPER});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERBRICK_DOOR, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.NETHER_BRICK});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.GLASS_DOOR, 3), new Object[] {"BB", "BB", "BB", 'B', Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.BONE_DOOR, 3), new Object[] {"BB", "BB", "BB", 'B', Items.BONE});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERBRICK_FENCE_GATE, 1), new Object[] {"#B#", "#B#", 'B', Blocks.NETHER_BRICK, '#', Items.NETHERBRICK});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.BEDROCK_BRICK, 4), new Object[] {"##", "##", '#', Blocks.BEDROCK});
		//Soul Glass as substitute for regular glass
		GameRegistry.addRecipe(new ItemStack(Blocks.BEACON, 1), new Object[] {"###", "#N#", "OOO", '#', MoreCraftBlocks.SOUL_GLASS, 'N', Items.NETHER_STAR, 'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.DAYLIGHT_DETECTOR, "###", "CCC", "SSS", '#', MoreCraftBlocks.SOUL_GLASS, 'C', Items.QUARTZ, 'S', "slabWood"));
		GameRegistry.addRecipe(new ItemStack(Items.END_CRYSTAL, 1), new Object[] {"###", "#E#", "#T#", '#', MoreCraftBlocks.SOUL_GLASS, 'E', Items.ENDER_EYE, 'T', Items.GHAST_TEAR});
		GameRegistry.addRecipe(new ItemStack(Items.GLASS_BOTTLE, 3), new Object[] {"# #", " # ", '#', MoreCraftBlocks.SOUL_GLASS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.GLASS_DOOR, 1), new Object[] {"##", "##", "##", '#', MoreCraftBlocks.SOUL_GLASS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.SOUL_GLASS_PANE, 16), new Object[] {"###", "###", '#', MoreCraftBlocks.SOUL_GLASS});
		//Needed because otherwise, these vanilla items would be unobtainable.
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.SPIDER_EYE, 1), new Object[] {MoreCraftItems.SPIDER_RAW});
	    GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, 0), new Object[] {MoreCraftItems.SQUID_RAW});
		
		/*Horse Armour*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR, 1), new Object[] {"  #", "#C#", "###", '#', Items.IRON_INGOT, 'C', Blocks.WOOL});
	        GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1), new Object[] {"  #", "#C#", "###", '#', Items.GOLD_INGOT, 'C', Blocks.WOOL});
	        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR, 1), new Object[] {"  #", "#C#", "###", '#', Items.DIAMOND, 'C', Blocks.WOOL});
	    }
		/*Nether wood planks recipes*/
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERWOOD_BOAT, 1), new Object[] {"# #", "###", '#', MoreCraftBlocks.NETHERWOOD_PLANKS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE, 1), new Object[] {"BB", "BB", 'B', MoreCraftBlocks.NETHERWOOD_PLANKS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_CHEST, 1), new Object[] {"###", "# #", "###", '#', MoreCraftBlocks.NETHERWOOD_PLANKS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftItems.NETHERWOOD_DOOR, 3), new Object[] {"##", "##", "##", '#', MoreCraftBlocks.NETHERWOOD_PLANKS});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_FENCE_GATE, 1), new Object[] {"I#I", "I#I", '#', MoreCraftBlocks.NETHERWOOD_PLANKS, 'I', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_FENCE, 3), new Object[] {"#I#", "#I#", '#', MoreCraftBlocks.NETHERWOOD_PLANKS, 'I', Items.STICK});	
		GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_SLAB, 6), new Object[] {"###", '#', MoreCraftBlocks.NETHERWOOD_PLANKS});
		
	    //Food recipes
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.CAKE_SLICE, 6), new Object[] {Items.CAKE});
	    GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftItems.APPLE_PIE, 1), new Object[] {Items.EGG, Items.APPLE, Items.SUGAR});
	    if (!MoreCraft.hardcoreRecipes) GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 1), new Object[] {"###", "#A#", "###", '#', Blocks.GOLD_BLOCK, 'A', Items.APPLE});
	    
	    /*Rotten flesh recipes, used as substitute for leather.*/
	    if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.ITEM_FRAME, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Items.STICK, 'F', Items.ROTTEN_FLESH});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.BOOK, 1), new Object[] {Items.PAPER, Items.PAPER, Items.PAPER, Items.ROTTEN_FLESH});
	    }
	    /*Silly recipes.*/
	    if (MoreCraft.sillyRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.BEDROCK, 1), new Object[] {"BS", 'B', Items.BED, 'S', Blocks.STONE});
	    }
	    
	    // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
	    
	    //--Convert slabs and stairs to full blocks--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 0), new Object[] {"SS", "SS", 'S', Blocks.OAK_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 1), new Object[] {"SS", "SS", 'S', Blocks.SPRUCE_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 2), new Object[] {"SS", "SS", 'S', Blocks.BIRCH_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 3), new Object[] {"SS", "SS", 'S', Blocks.JUNGLE_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 4), new Object[] {"SS", "SS", 'S', Blocks.ACACIA_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 6, 5), new Object[] {"SS", "SS", 'S', Blocks.DARK_OAK_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE, 6), new Object[] {"SS", "SS", 'S', Blocks.STONE_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.SANDSTONE, 6), new Object[] {"SS", "SS", 'S', Blocks.SANDSTONE_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.BRICK_BLOCK, 6), new Object[] {"SS", "SS", 'S', Blocks.BRICK_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.STONEBRICK, 6), new Object[] {"SS", "SS", 'S', Blocks.STONE_BRICK_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.NETHER_BRICK, 6), new Object[] {"SS", "SS", 'S', Blocks.NETHER_BRICK_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 6), new Object[] {"SS", "SS", 'S', Blocks.QUARTZ_STAIRS}); //--Quartz stairs to quartz blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.STONE, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.STONE_STAIRS}); //--Smooth Stone stairs to smooth stone blocks.
	        GameRegistry.addRecipe(new ItemStack(Blocks.RED_SANDSTONE, 6), new Object[] {"SS", "SS", 'S', Blocks.RED_SANDSTONE_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PURPUR_BLOCK, 6), new Object[] {"SS", "SS", 'S', Blocks.PURPUR_STAIRS});
	        GameRegistry.addRecipe(new ItemStack(Blocks.END_BRICKS, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.ENDSTONE_BRICK_STAIRS}); //--Ender Brick stairs to ender brick blocks.
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 6), new Object[] {"SS", "SS", 'S', MoreCraftBlocks.NETHERWOOD_STAIRS});
	
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 1)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 2)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 4), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 4)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 5), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 5)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 3)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.STONE, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 0)});

	        GameRegistry.addRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 4)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.NETHER_BRICK, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 6)});
	        GameRegistry.addRecipe(new ItemStack(Blocks.END_BRICKS, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.ENDSTONE_BRICK_SLAB, 1, 0)});
	        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.NETHERWOOD_SLAB, 1, 0)});
	    }
	    
	    //--Dismantling objects--\\
	    if (MoreCraft.salvageRecipes) {
	    	//Items
	        GameRegistry.addRecipe(new ItemStack(Items.STICK, 1), new Object[] {"AA", "AA", 'A', Items.ARROW});

	        //Blocks
	        //Fences
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.OAK_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.SPRUCE_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.BIRCH_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.JUNGLE_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.DARK_OAK_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.ACACIA_FENCE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {MoreCraftBlocks.NETHERWOOD_FENCE});
	        //Fence Gates
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.OAK_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.SPRUCE_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.BIRCH_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.JUNGLE_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.DARK_OAK_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {Blocks.ACACIA_FENCE_GATE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 6), new Object[] {MoreCraftBlocks.NETHERWOOD_FENCE_GATE});
	        //Doors
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.OAK_DOOR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.SPRUCE_DOOR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.BIRCH_DOOR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.JUNGLE_DOOR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.DARK_OAK_DOOR});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.ACACIA_DOOR});
	        
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 4), new Object[] {Items.BOAT});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 2), new Object[] {Items.SIGN});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 3), new Object[] {Items.BOW});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 8), new Object[] {Blocks.CHEST});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 3), new Object[] {Blocks.TRAPDOOR});

	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new Object[] {Blocks.LEVER});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), new Object[] {Blocks.LADDER});
	        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 4), new Object[] {Blocks.CRAFTING_TABLE});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.QUARTZ, 4), new Object[] {Blocks.QUARTZ_BLOCK});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 8), new Object[] {MoreCraftBlocks.NETHERWOOD_CHEST});
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 4), new Object[] {MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE});
	    }
	    
	    // ~ --FURNACE RECIPES -- ~ \\
	
	    //--Procession--\\
	    GameRegistry.addSmelting(MoreCraftBlocks.RUBY_ORE, new ItemStack(MoreCraftItems.RUBY), 2.0F);
	    //GameRegistry.addSmelting(Blocks.END_STONE, new ItemStack(MoreCraftItems.ender_brick), 1.0F); 
	    GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(MoreCraftBlocks.SOUL_GLASS), 0.5F); 
	    
	    //--Cooking food--\\
	    GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(MoreCraftItems.COOKED_FLESH), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.SPIDER_RAW, new ItemStack(MoreCraftItems.SPIDER_COOKED), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.SQUID_RAW, new ItemStack(MoreCraftItems.SQUID_COOKED), 1.0F);
	    GameRegistry.addSmelting(MoreCraftItems.GUARDIAN_MEAT_RAW, new ItemStack(MoreCraftItems.GUARDIAN_MEAT_COOKED), 1.0F);
	    GameRegistry.addSmelting(Items.EGG, new ItemStack(MoreCraftItems.EGG_COOKED), 1.0F);
		
	    //--Melting down--\\
	    if (MoreCraft.salvageRecipes) {
	        GameRegistry.addSmelting(Items.IRON_DOOR, new ItemStack(Items.IRON_INGOT, 2), 0.5F);
	        GameRegistry.addSmelting(Items.MINECART, new ItemStack(Items.IRON_INGOT, 5), 0.5F);
	        GameRegistry.addSmelting(Items.CAULDRON, new ItemStack(Items.IRON_INGOT, 7), 0.5F);
	    }
	}
}
