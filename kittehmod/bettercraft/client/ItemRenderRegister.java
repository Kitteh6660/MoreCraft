package kittehmod.bettercraft.client;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {

	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MoreCraft.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerItemRenderer() {
		//Items
    	reg(MoreCraftItems.COOKED_FLESH);
    	reg(MoreCraftItems.SPIDER_RAW);
    	reg(MoreCraftItems.SPIDER_COOKED);
    	reg(MoreCraftItems.APPLE_PIE);
    	reg(MoreCraftItems.CAKE_SLICE);
    	reg(MoreCraftItems.SQUID_RAW);
    	reg(MoreCraftItems.SQUID_COOKED);
    	reg(MoreCraftItems.EGG_COOKED);
    	reg(MoreCraftItems.GUARDIAN_MEAT_RAW);
    	reg(MoreCraftItems.GUARDIAN_MEAT_COOKED);
    	reg(MoreCraftItems.NETHER_APPLE);

    	reg(MoreCraftItems.RUBY);
    	reg(MoreCraftItems.WITHER_BONE);
    	reg(MoreCraftItems.ENDERDRAGON_SCALES);

    	reg(MoreCraftItems.NETHERBRICK_DOOR);
    	reg(MoreCraftItems.NETHERWOOD_DOOR);
    	reg(MoreCraftItems.GLASS_DOOR);
    	reg(MoreCraftItems.BONE_DOOR);
    	
    	reg(MoreCraftItems.NETHERWOOD_BOAT);
    	
    	reg(MoreCraftItems.SLIME_HELMET);
    	reg(MoreCraftItems.SLIME_CHESTPLATE);
    	reg(MoreCraftItems.SLIME_LEGGINGS);
    	reg(MoreCraftItems.SLIME_BOOTS);
    	
    	reg(MoreCraftItems.FLESH_HELMET);
    	reg(MoreCraftItems.FLESH_CHESTPLATE);
    	reg(MoreCraftItems.FLESH_LEGGINGS);
    	reg(MoreCraftItems.FLESH_BOOTS);

    	reg(MoreCraftItems.SPIDERSILK_HELMET);
    	reg(MoreCraftItems.SPIDERSILK_CHESTPLATE);
    	reg(MoreCraftItems.SPIDERSILK_LEGGINGS);
    	reg(MoreCraftItems.SPIDERSILK_BOOTS);
    	
    	reg(MoreCraftItems.OBSIDIAN_HELMET);
    	reg(MoreCraftItems.OBSIDIAN_CHESTPLATE);
    	reg(MoreCraftItems.OBSIDIAN_LEGGINGS);
    	reg(MoreCraftItems.OBSIDIAN_BOOTS);
    	reg(MoreCraftItems.OBSIDIAN_PICKAXE);
    	reg(MoreCraftItems.OBSIDIAN_AXE);
    	reg(MoreCraftItems.OBSIDIAN_SHOVEL);
    	reg(MoreCraftItems.OBSIDIAN_HOE);
    	reg(MoreCraftItems.OBSIDIAN_SWORD);

    	reg(MoreCraftItems.BONE_HELMET);
    	reg(MoreCraftItems.BONE_CHESTPLATE);
    	reg(MoreCraftItems.BONE_LEGGINGS);
    	reg(MoreCraftItems.BONE_BOOTS);
    	reg(MoreCraftItems.BONE_PICKAXE);
    	reg(MoreCraftItems.BONE_AXE);
    	reg(MoreCraftItems.BONE_SHOVEL);
    	reg(MoreCraftItems.BONE_HOE);
    	reg(MoreCraftItems.BONE_SWORD);

    	reg(MoreCraftItems.WITHERBONE_HELMET);
    	reg(MoreCraftItems.WITHERBONE_CHESTPLATE);
    	reg(MoreCraftItems.WITHERBONE_LEGGINGS);
    	reg(MoreCraftItems.WITHERBONE_BOOTS);
    	reg(MoreCraftItems.WITHERBONE_PICKAXE);
    	reg(MoreCraftItems.WITHERBONE_AXE);
    	reg(MoreCraftItems.WITHERBONE_SHOVEL);
    	reg(MoreCraftItems.WITHERBONE_HOE);
    	reg(MoreCraftItems.WITHERBONE_SWORD);

    	reg(MoreCraftItems.EMERALD_HELMET);
    	reg(MoreCraftItems.EMERALD_CHESTPLATE);
    	reg(MoreCraftItems.EMERALD_LEGGINGS);
    	reg(MoreCraftItems.EMERALD_BOOTS);
    	reg(MoreCraftItems.EMERALD_PICKAXE);
    	reg(MoreCraftItems.EMERALD_AXE);
    	reg(MoreCraftItems.EMERALD_SHOVEL);
    	reg(MoreCraftItems.EMERALD_HOE);
    	reg(MoreCraftItems.EMERALD_SWORD);

    	reg(MoreCraftItems.RUBY_HELMET);
    	reg(MoreCraftItems.RUBY_CHESTPLATE);
    	reg(MoreCraftItems.RUBY_LEGGINGS);
    	reg(MoreCraftItems.RUBY_BOOTS);
    	reg(MoreCraftItems.RUBY_PICKAXE);
    	reg(MoreCraftItems.RUBY_AXE);
    	reg(MoreCraftItems.RUBY_SHOVEL);
    	reg(MoreCraftItems.RUBY_HOE);
    	reg(MoreCraftItems.RUBY_SWORD);

    	reg(MoreCraftItems.BLAZE_HELMET);
    	reg(MoreCraftItems.BLAZE_CHESTPLATE);
    	reg(MoreCraftItems.BLAZE_LEGGINGS);
    	reg(MoreCraftItems.BLAZE_BOOTS);
    	reg(MoreCraftItems.BLAZE_PICKAXE);
    	reg(MoreCraftItems.BLAZE_AXE);
    	reg(MoreCraftItems.BLAZE_SHOVEL);
    	reg(MoreCraftItems.BLAZE_HOE);
    	reg(MoreCraftItems.BLAZE_SWORD);

    	reg(MoreCraftItems.ENDER_HELMET);
    	reg(MoreCraftItems.ENDER_CHESTPLATE);
    	reg(MoreCraftItems.ENDER_LEGGINGS);
    	reg(MoreCraftItems.ENDER_BOOTS);
    	reg(MoreCraftItems.ENDER_PICKAXE);
    	reg(MoreCraftItems.ENDER_AXE);
    	reg(MoreCraftItems.ENDER_SHOVEL);
    	reg(MoreCraftItems.ENDER_HOE);
    	reg(MoreCraftItems.ENDER_SWORD);

    	reg(MoreCraftItems.ENDSTONE_PICKAXE);
    	reg(MoreCraftItems.ENDSTONE_AXE);
    	reg(MoreCraftItems.ENDSTONE_SHOVEL);
    	reg(MoreCraftItems.ENDSTONE_HOE);
    	reg(MoreCraftItems.ENDSTONE_SWORD);
    	
    	reg(MoreCraftItems.NETHERRACK_PICKAXE);
    	reg(MoreCraftItems.NETHERRACK_AXE);
    	reg(MoreCraftItems.NETHERRACK_SHOVEL);
    	reg(MoreCraftItems.NETHERRACK_HOE);
    	reg(MoreCraftItems.NETHERRACK_SWORD);
    	
    	/*reg(MoreCraftItems.guardian_helmet);
    	reg(MoreCraftItems.guardian_chestplate);
    	reg(MoreCraftItems.guardian_leggings);
    	reg(MoreCraftItems.guardian_boots);*/
    	
    	reg(MoreCraftItems.BONELORD_HELMET);
    	reg(MoreCraftItems.BONELORD_CHESTPLATE);
    	reg(MoreCraftItems.BONELORD_LEGGINGS);
    	reg(MoreCraftItems.BONELORD_BOOTS);
    	
    	reg(MoreCraftItems.ENDERDRAGON_HELMET);
    	reg(MoreCraftItems.ENDERDRAGON_CHESTPLATE);
    	reg(MoreCraftItems.ENDERDRAGON_LEGGINGS);
    	reg(MoreCraftItems.ENDERDRAGON_BOOTS);

    	reg(MoreCraftItems.BEDROCK_HELMET);
    	reg(MoreCraftItems.BEDROCK_CHESTPLATE);
    	reg(MoreCraftItems.BEDROCK_LEGGINGS);
    	reg(MoreCraftItems.BEDROCK_BOOTS);
    	reg(MoreCraftItems.BEDROCK_PICKAXE);
    	reg(MoreCraftItems.BEDROCK_AXE);
    	reg(MoreCraftItems.BEDROCK_SHOVEL);
    	reg(MoreCraftItems.BEDROCK_HOE);
    	reg(MoreCraftItems.BEDROCK_SWORD);
    }
}
