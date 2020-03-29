package kittehmod.morecraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class MoreCraftRecipes {
	
	public static void registerRecipes() 
	{
		// ~ --CRAFTING RECIPES -- ~ \\
		//The contents of the crafting table recipes have been chopped up and redone in JSON.

		/*Soul Glass as substitute for regular glass*/
		/*GameRegistry.addRecipe(new ItemStack(Blocks.BEACON, 1), new Object[] {"###", "#N#", "OOO", '#', MoreCraftBlocks.SOUL_GLASS, 'N', Items.NETHER_STAR, 'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.DAYLIGHT_DETECTOR, "###", "CCC", "SSS", '#', MoreCraftBlocks.SOUL_GLASS, 'C', Items.QUARTZ, 'S', "slabWood"));
		GameRegistry.addRecipe(new ItemStack(Items.END_CRYSTAL, 1), new Object[] {"###", "#E#", "#T#", '#', MoreCraftBlocks.SOUL_GLASS, 'E', Items.ENDER_EYE, 'T', Items.GHAST_TEAR});

	    */
	    /*Rotten flesh recipes, used as substitute for leather.*/
	    /*if (!MoreCraft.hardcoreRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Items.ITEM_FRAME, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Items.STICK, 'F', Items.ROTTEN_FLESH});
	        GameRegistry.addShapelessRecipe(new ItemStack(Items.BOOK, 1), new Object[] {Items.PAPER, Items.PAPER, Items.PAPER, Items.ROTTEN_FLESH});
	    }*/
	    /*Silly recipes.*/
	    /*if (MoreCraft.sillyRecipes) {
	        GameRegistry.addRecipe(new ItemStack(Blocks.BEDROCK, 1), new Object[] {"BS", 'B', Items.BED, 'S', Blocks.STONE});
	    }*/
	    
	    // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
	    
	    //--Convert slabs and stairs to full blocks--\\
	    /*if (MoreCraft.salvageRecipes) {
	    	if (!Loader.isModLoaded("quark")) {
	    		//Stairs
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
		        //Slabs
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 0)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 1)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 2)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 3)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 4), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 4)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 5), new Object[] {"#", "#", '#', new ItemStack(Blocks.WOODEN_SLAB, 1, 5)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 3)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.STONE, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 0)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 4)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.NETHER_BRICK, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.STONE_SLAB, 1, 6)});
		        GameRegistry.addRecipe(new ItemStack(Blocks.END_BRICKS, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.ENDSTONE_BRICK_SLAB, 1, 0)});
		        GameRegistry.addRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 1), new Object[] {"#", "#", '#', new ItemStack(MoreCraftBlocks.NETHERWOOD_SLAB, 1, 0)});
	    	}
	    }*/
	    
	    //--Dismantling objects--\\
	    /*if (MoreCraft.salvageRecipes) {
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
	        GameRegistry.addShapelessRecipe(new ItemStack(MoreCraftBlocks.NETHERWOOD_PLANKS, 2), new Object[] {MoreCraftItems.NETHERWOOD_DOOR});
	    }
	    */
		
	    // ~ --FURNACE RECIPES -- ~ \\
	
	    //--Procession--\\
	    GameRegistry.addSmelting(MoreCraftBlocks.RUBY_ORE, new ItemStack(MoreCraftItems.RUBY), 2.0F);
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
	public static void fixRecipes() {
		IForgeRegistryModifiable registry = (IForgeRegistryModifiable)ForgeRegistries.RECIPES;
		IForgeRegistryEntry recipe = registry.getValue(new ResourceLocation("minecraft:chest"));
		registry.remove(recipe.getRegistryName());
		//registry.add(-1, recipe);
	}	
}
