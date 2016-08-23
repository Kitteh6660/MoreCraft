package kittehmod.bettercraft.client;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.MoreCraftBlocks;
import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {

	public static void reg(Item item) {
	    Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178086_a(item, 0, new ModelResourceLocation(MoreCraft.MODID + ":" + item.func_77658_a().substring(5), "inventory"));
	}
	
	public static void registerItemRenderer() {
		//Items
    	reg(MoreCraftItems.cooked_flesh);
    	reg(MoreCraftItems.spider_raw);
    	reg(MoreCraftItems.spider_cooked);
    	reg(MoreCraftItems.apple_pie);
    	reg(MoreCraftItems.cake_slice);
    	reg(MoreCraftItems.squid_raw);
    	reg(MoreCraftItems.squid_cooked);
    	reg(MoreCraftItems.egg_cooked);
    	reg(MoreCraftItems.guardian_meat_raw);
    	reg(MoreCraftItems.guardian_meat_cooked);

    	reg(MoreCraftItems.ender_brick);
    	reg(MoreCraftItems.ruby);
    	reg(MoreCraftItems.wither_bone);
    	//reg(MoreCraftItems.guardian_scale);

    	reg(MoreCraftItems.netherbrick_door_item);
    	reg(MoreCraftItems.netherwood_door_item);
    	reg(MoreCraftItems.glass_door_item);
    	reg(MoreCraftItems.bone_door_item);

    	reg(MoreCraftItems.slime_helmet);
    	reg(MoreCraftItems.slime_chestplate);
    	reg(MoreCraftItems.slime_leggings);
    	reg(MoreCraftItems.slime_boots);
    	
    	reg(MoreCraftItems.flesh_helmet);
    	reg(MoreCraftItems.flesh_chestplate);
    	reg(MoreCraftItems.flesh_leggings);
    	reg(MoreCraftItems.flesh_boots);

    	reg(MoreCraftItems.spidersilk_helmet);
    	reg(MoreCraftItems.spidersilk_chestplate);
    	reg(MoreCraftItems.spidersilk_leggings);
    	reg(MoreCraftItems.spidersilk_boots);
    	
    	reg(MoreCraftItems.obsidian_helmet);
    	reg(MoreCraftItems.obsidian_chestplate);
    	reg(MoreCraftItems.obsidian_leggings);
    	reg(MoreCraftItems.obsidian_boots);
    	reg(MoreCraftItems.obsidian_pickaxe);
    	reg(MoreCraftItems.obsidian_axe);
    	reg(MoreCraftItems.obsidian_shovel);
    	reg(MoreCraftItems.obsidian_hoe);
    	reg(MoreCraftItems.obsidian_sword);

    	reg(MoreCraftItems.bone_helmet);
    	reg(MoreCraftItems.bone_chestplate);
    	reg(MoreCraftItems.bone_leggings);
    	reg(MoreCraftItems.bone_boots);
    	reg(MoreCraftItems.bone_pickaxe);
    	reg(MoreCraftItems.bone_axe);
    	reg(MoreCraftItems.bone_shovel);
    	reg(MoreCraftItems.bone_hoe);
    	reg(MoreCraftItems.bone_sword);

    	reg(MoreCraftItems.witherbone_helmet);
    	reg(MoreCraftItems.witherbone_chestplate);
    	reg(MoreCraftItems.witherbone_leggings);
    	reg(MoreCraftItems.witherbone_boots);
    	reg(MoreCraftItems.witherbone_pickaxe);
    	reg(MoreCraftItems.witherbone_axe);
    	reg(MoreCraftItems.witherbone_shovel);
    	reg(MoreCraftItems.witherbone_hoe);
    	reg(MoreCraftItems.witherbone_sword);

    	reg(MoreCraftItems.emerald_helmet);
    	reg(MoreCraftItems.emerald_chestplate);
    	reg(MoreCraftItems.emerald_leggings);
    	reg(MoreCraftItems.emerald_boots);
    	reg(MoreCraftItems.emerald_pickaxe);
    	reg(MoreCraftItems.emerald_axe);
    	reg(MoreCraftItems.emerald_shovel);
    	reg(MoreCraftItems.emerald_hoe);
    	reg(MoreCraftItems.emerald_sword);

    	reg(MoreCraftItems.ruby_helmet);
    	reg(MoreCraftItems.ruby_chestplate);
    	reg(MoreCraftItems.ruby_leggings);
    	reg(MoreCraftItems.ruby_boots);
    	reg(MoreCraftItems.ruby_pickaxe);
    	reg(MoreCraftItems.ruby_axe);
    	reg(MoreCraftItems.ruby_shovel);
    	reg(MoreCraftItems.ruby_hoe);
    	reg(MoreCraftItems.ruby_sword);

    	reg(MoreCraftItems.blaze_helmet);
    	reg(MoreCraftItems.blaze_chestplate);
    	reg(MoreCraftItems.blaze_leggings);
    	reg(MoreCraftItems.blaze_boots);
    	reg(MoreCraftItems.blaze_pickaxe);
    	reg(MoreCraftItems.blaze_axe);
    	reg(MoreCraftItems.blaze_shovel);
    	reg(MoreCraftItems.blaze_hoe);
    	reg(MoreCraftItems.blaze_sword);

    	reg(MoreCraftItems.ender_helmet);
    	reg(MoreCraftItems.ender_chestplate);
    	reg(MoreCraftItems.ender_leggings);
    	reg(MoreCraftItems.ender_boots);
    	reg(MoreCraftItems.ender_pickaxe);
    	reg(MoreCraftItems.ender_axe);
    	reg(MoreCraftItems.ender_shovel);
    	reg(MoreCraftItems.ender_hoe);
    	reg(MoreCraftItems.ender_sword);

    	reg(MoreCraftItems.endstone_pickaxe);
    	reg(MoreCraftItems.endstone_axe);
    	reg(MoreCraftItems.endstone_shovel);
    	reg(MoreCraftItems.endstone_hoe);
    	reg(MoreCraftItems.endstone_sword);
    	
    	reg(MoreCraftItems.netherrack_pickaxe);
    	reg(MoreCraftItems.netherrack_axe);
    	reg(MoreCraftItems.netherrack_shovel);
    	reg(MoreCraftItems.netherrack_hoe);
    	reg(MoreCraftItems.netherrack_sword);
    	
    	/*reg(MoreCraftItems.guardian_helmet);
    	reg(MoreCraftItems.guardian_chestplate);
    	reg(MoreCraftItems.guardian_leggings);
    	reg(MoreCraftItems.guardian_boots);*/
    	
    	reg(MoreCraftItems.bonelord_helmet);
    	reg(MoreCraftItems.bonelord_chestplate);
    	reg(MoreCraftItems.bonelord_leggings);
    	reg(MoreCraftItems.bonelord_boots);
    	
    	reg(MoreCraftItems.enderdragon_helmet);
    	reg(MoreCraftItems.enderdragon_chestplate);
    	reg(MoreCraftItems.enderdragon_leggings);
    	reg(MoreCraftItems.enderdragon_boots);

    	reg(MoreCraftItems.bedrock_helmet);
    	reg(MoreCraftItems.bedrock_chestplate);
    	reg(MoreCraftItems.bedrock_leggings);
    	reg(MoreCraftItems.bedrock_boots);
    	reg(MoreCraftItems.bedrock_pickaxe);
    	reg(MoreCraftItems.bedrock_axe);
    	reg(MoreCraftItems.bedrock_shovel);
    	reg(MoreCraftItems.bedrock_hoe);
    	reg(MoreCraftItems.bedrock_sword);
    }
}
