package kittehmod.bettercraft.client;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister {

	public static void reg(Block block) {
		if (!block.getUnlocalizedName().contains("door")) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MoreCraft.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	public static void registerBlockRenderer() {
		//Blocks
		reg(MoreCraftBlocks.netherbrick_door);
		reg(MoreCraftBlocks.netherwood_door);
		reg(MoreCraftBlocks.bone_door);
		reg(MoreCraftBlocks.glass_door);
		reg(MoreCraftBlocks.netherbrick_fence_gate);
		reg(MoreCraftBlocks.netherwood_fence_gate);
		
    	reg(MoreCraftBlocks.bone_block);
    	reg(MoreCraftBlocks.flesh_block);
    	reg(MoreCraftBlocks.ruby_block);
    	reg(MoreCraftBlocks.blaze_block);
    	reg(MoreCraftBlocks.ender_block);
    	reg(MoreCraftBlocks.gunpowder_block);

    	reg(MoreCraftBlocks.ruby_ore);
    	
    	reg(MoreCraftBlocks.netherwood_log);
    	reg(MoreCraftBlocks.netherwood_planks);
    	reg(MoreCraftBlocks.netherwood_leaves);
    	reg(MoreCraftBlocks.netherwood_sapling);
    	reg(MoreCraftBlocks.netherwood_stairs);
    	reg(MoreCraftBlocks.netherwood_slab);
    	reg(MoreCraftBlocks.netherwood_slab_full);
    	reg(MoreCraftBlocks.netherwood_chest);
    	reg(MoreCraftBlocks.netherwood_crafting_table);
    	reg(MoreCraftBlocks.netherwood_fence);
    	
    	reg(MoreCraftBlocks.enderbrick_block);
    	reg(MoreCraftBlocks.enderbrick_stairs);
    	reg(MoreCraftBlocks.enderbrick_slab);
    	reg(MoreCraftBlocks.enderbrick_slab_full);
    	
    	reg(MoreCraftBlocks.stone_stairs);
    	reg(MoreCraftBlocks.soul_glass);
    	reg(MoreCraftBlocks.soul_glass_pane);
    	reg(MoreCraftBlocks.bone_ladder);
    	reg(MoreCraftBlocks.glowstone_torch);
    	reg(MoreCraftBlocks.bedrock_brick);
	}
	
}
