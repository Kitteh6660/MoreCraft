package kittehmod.bettercraft.client;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister {

	private static boolean shouldHaveInventoryModel(Block block) {
		if (block.getUnlocalizedName().contains("door")) {
			return false;
		}
		if (block == MoreCraftBlocks.NETHERWOOD_SLAB_FULL || block == MoreCraftBlocks.ENDSTONE_BRICK_SLAB_FULL) {
			return false;
		}
		return true;
	}
	
	public static void reg(Block block) {
		if (shouldHaveInventoryModel(block)) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MoreCraft.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	public static void registerBlockRenderer() {
		//Blocks
		reg(MoreCraftBlocks.NETHERBRICK_DOOR);
		reg(MoreCraftBlocks.NETHERWOOD_DOOR);
		reg(MoreCraftBlocks.BONE_DOOR);
		reg(MoreCraftBlocks.GLASS_DOOR);
		reg(MoreCraftBlocks.NETHERBRICK_FENCE_GATE);
		reg(MoreCraftBlocks.NETHERWOOD_FENCE_GATE);
		
    	reg(MoreCraftBlocks.FLESH_BLOCK);
    	reg(MoreCraftBlocks.RUBY_BLOCK);
    	reg(MoreCraftBlocks.BLAZE_BLOCK);
    	reg(MoreCraftBlocks.ENDER_BLOCK);
    	reg(MoreCraftBlocks.GUNPOWDER_BLOCK);

    	reg(MoreCraftBlocks.RUBY_ORE);
    	
    	reg(MoreCraftBlocks.NETHERWOOD_LOG);
    	reg(MoreCraftBlocks.NETHERWOOD_PLANKS);
    	reg(MoreCraftBlocks.NETHERWOOD_LEAVES);
    	reg(MoreCraftBlocks.NETHERWOOD_SAPLING);
    	reg(MoreCraftBlocks.NETHERWOOD_STAIRS);
    	reg(MoreCraftBlocks.NETHERWOOD_SLAB);
    	reg(MoreCraftBlocks.NETHERWOOD_CHEST);
    	reg(MoreCraftBlocks.NETHERWOOD_CHEST_TRAPPED);
    	reg(MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE);
    	reg(MoreCraftBlocks.NETHERWOOD_FENCE);
    	
    	reg(MoreCraftBlocks.ENDSTONE_BRICK_STAIRS);
    	reg(MoreCraftBlocks.ENDSTONE_BRICK_SLAB);
    	
    	reg(MoreCraftBlocks.STONE_STAIRS);
    	reg(MoreCraftBlocks.SOUL_GLASS);
    	reg(MoreCraftBlocks.SOUL_GLASS_PANE);
    	reg(MoreCraftBlocks.BONE_LADDER);
    	reg(MoreCraftBlocks.GLOWSTONE_TORCH);
    	reg(MoreCraftBlocks.BEDROCK_BRICK);
	}
	
}
