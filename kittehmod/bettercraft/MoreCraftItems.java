package kittehmod.bettercraft;

import kittehmod.bettercraft.item.ItemBlazeArmor;
import kittehmod.bettercraft.item.ItemBonelordArmor;
import kittehmod.bettercraft.item.ItemEnderdragonArmor;
import kittehmod.bettercraft.item.ItemNewDoor;
import kittehmod.bettercraft.item.ItemNormalArmor;
import kittehmod.bettercraft.item.ItemNormalAxe;
import kittehmod.bettercraft.item.ItemNormalHoe;
import kittehmod.bettercraft.item.ItemNormalPickaxe;
import kittehmod.bettercraft.item.ItemNormalSpade;
import kittehmod.bettercraft.item.ItemNormalSword;
import kittehmod.bettercraft.item.ItemSlimeArmor;
import kittehmod.bettercraft.item.ItemWitherArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreCraftItems {

	// -- FOOD -- \\
    public static final Item cooked_flesh = (new ItemFood(8, 0.8F, true)).setPotionEffect(Potion.confusion.id, 20, 0, 0.1F).setUnlocalizedName("cooked_flesh");
    public static final Item spider_raw = (new ItemFood(3, 0.3F, true)).setPotionEffect(Potion.poison.id, 5, 0, 0.5F).setPotionEffect(Potion.confusion.id, 30, 0, 0.1F).setPotionEffect(Potion.blindness.id, 30, 0, 0.1F).setUnlocalizedName("spider_raw");
    public static final Item spider_cooked = (new ItemFood(7, 0.7F, true)).setUnlocalizedName("spider_cooked");
    public static final Item apple_pie = (new ItemFood(8, 0.8F, false)).setPotionEffect(Potion.regeneration.id, 5, 0, 0.3F).setUnlocalizedName("apple_pie");
    public static final Item cake_slice = (new ItemFood(2, 0.3F, false)).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.25F).setUnlocalizedName("cake_slice");
    public static final Item squid_raw = (new ItemFood(3, 0.3F, false)).setPotionEffect(Potion.harm.id, 0, 0, 0.3F).setUnlocalizedName("squid_raw");
    public static final Item squid_cooked = (new ItemFood(6, 0.6F, false)).setUnlocalizedName("squid_cooked");
    public static final Item egg_cooked = (new ItemFood(6, 0.5F, false)).setUnlocalizedName("egg_cooked");
    public static final Item guardian_meat_raw = new ItemFood(3, 0.3F, false).setUnlocalizedName("guardian_meat_raw");
    public static final Item guardian_meat_cooked = new ItemFood(7, 0.7F, false).setPotionEffect(Potion.waterBreathing.id, 30, 0, 1.0F).setUnlocalizedName("guardian_meat_cooked");
    
    // -- MATERIALS -- \\
    public static final Item ender_brick = (new Item()).setUnlocalizedName("ender_brick").setCreativeTab(CreativeTabs.tabMaterials);   
    public static final Item ruby = new Item().setUnlocalizedName("ruby").setCreativeTab(CreativeTabs.tabMaterials);    
    public static final Item wither_bone = new Item().setUnlocalizedName("wither_bone").setCreativeTab(CreativeTabs.tabMaterials);
    //public static final Item guardian_scale = new Item().setUnlocalizedName("guardian_scale").setCreativeTab(CreativeTabs.tabMaterials);
    
	// -- DOOR ITEMS -- \\
    public static final Item netherbrick_door_item = (new ItemDoor(MoreCraftBlocks.netherbrick_door)).setUnlocalizedName("netherbrick_door_item");
    public static final Item netherwood_door_item = (new ItemDoor(MoreCraftBlocks.netherwood_door)).setUnlocalizedName("netherwood_door_item");
	public static final Item glass_door_item = (new ItemDoor(MoreCraftBlocks.glass_door)).setUnlocalizedName("glass_door_item");
    public static final Item bone_door_item = (new ItemDoor(MoreCraftBlocks.bone_door)).setUnlocalizedName("bone_door_item");
    
	// -- HORSE ARMOUR -- \\ Not Active.
    /*public static final Item bone_horse_armor = (new ItemHorseArmor()).setUnlocalizedName("bone_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item emerald_horse_armor = (new ItemHorseArmor()).setUnlocalizedName("emerald_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item ruby_horse_armor = (new ItemHorseArmor()).setUnlocalizedName("ruby_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item obsidian_horse_armor = (new ItemHorseArmor()).setUnlocalizedName("obsidian_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);*/
    
	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final Item slime_helmet = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, 0, "slime", Items.slime_ball).setUnlocalizedName("slime_helmet");
    public static final Item slime_chestplate = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, 1, "slime", Items.slime_ball).setUnlocalizedName("slime_chestplate");
    public static final Item slime_leggings = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, 2, "slime", Items.slime_ball).setUnlocalizedName("slime_leggings");
    public static final Item slime_boots = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, 3, "slime", Items.slime_ball).setUnlocalizedName("slime_boots");
    
    public static final Item flesh_helmet = new ItemNormalArmor(MoreCraft.FLESH_A, 4, 0, "flesh", Items.rotten_flesh).setUnlocalizedName("flesh_helmet");
    public static final Item flesh_chestplate = new ItemNormalArmor(MoreCraft.FLESH_A, 4, 1, "flesh", Items.rotten_flesh).setUnlocalizedName("flesh_chestplate");
    public static final Item flesh_leggings = new ItemNormalArmor(MoreCraft.FLESH_A, 4, 2, "flesh", Items.rotten_flesh).setUnlocalizedName("flesh_leggings");
    public static final Item flesh_boots = new ItemNormalArmor(MoreCraft.FLESH_A, 4, 3, "flesh", Items.rotten_flesh).setUnlocalizedName("flesh_boots");
	
    public static final Item spidersilk_helmet = new ItemNormalArmor(MoreCraft.WEB_A, 4, 0, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("spidersilk_helmet");
    public static final Item spidersilk_chestplate = new ItemNormalArmor(MoreCraft.WEB_A, 4, 1, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("spidersilk_chestplate");
    public static final Item spidersilk_leggings = new ItemNormalArmor(MoreCraft.WEB_A, 4, 2, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("spidersilk_leggings");
    public static final Item spidersilk_boots = new ItemNormalArmor(MoreCraft.WEB_A, 4, 3, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("spidersilk_boots");
    
    public static final Item obsidian_helmet = new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, 0, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_helmet");
    public static final Item obsidian_chestplate =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, 1, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_chestplate");
    public static final Item obsidian_leggings =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, 2, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_leggings");
    public static final Item obsidian_boots =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, 3, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_boots");
    public static final Item obsidian_pickaxe = new ItemNormalPickaxe(MoreCraft.OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_pickaxe");
    public static final Item obsidian_axe = new ItemNormalAxe(MoreCraft.OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_axe");
    public static final Item obsidian_shovel = new ItemNormalSpade(MoreCraft.OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_shovel");
    public static final Item obsidian_hoe = new ItemNormalHoe(MoreCraft.OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_hoe");
    public static final Item obsidian_sword = new ItemNormalSword(MoreCraft.OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("obsidian_sword");
    
    public static final Item bone_helmet = new ItemNormalArmor(MoreCraft.BONE_A, 4, 0, "bone", Items.bone).setUnlocalizedName("bone_helmet");
    public static final Item bone_chestplate = new ItemNormalArmor(MoreCraft.BONE_A, 4, 1, "bone", Items.bone).setUnlocalizedName("bone_chestplate");
    public static final Item bone_leggings = new ItemNormalArmor(MoreCraft.BONE_A, 4, 2, "bone", Items.bone).setUnlocalizedName("bone_leggings");
    public static final Item bone_boots = new ItemNormalArmor(MoreCraft.BONE_A, 4, 3, "bone", Items.bone).setUnlocalizedName("bone_boots");
    public static final Item bone_pickaxe = new ItemNormalPickaxe(MoreCraft.BONE_T, Items.bone).setUnlocalizedName("bone_pickaxe");
    public static final Item bone_axe = new ItemNormalAxe(MoreCraft.BONE_T, Items.bone).setUnlocalizedName("bone_axe");
    public static final Item bone_shovel = new ItemNormalSpade(MoreCraft.BONE_T, Items.bone).setUnlocalizedName("bone_shovel");
    public static final Item bone_hoe = new ItemNormalHoe(MoreCraft.BONE_T, Items.bone).setUnlocalizedName("bone_hoe");
    public static final Item bone_sword = new ItemNormalSword(MoreCraft.BONE_T, Items.bone).setUnlocalizedName("bone_sword");
    
    public static final Item witherbone_helmet = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, 0, "witherbone", wither_bone).setUnlocalizedName("witherbone_helmet");
    public static final Item witherbone_chestplate = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, 1, "witherbone", wither_bone).setUnlocalizedName("witherbone_chestplate");
    public static final Item witherbone_leggings = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, 2, "witherbone", wither_bone).setUnlocalizedName("witherbone_leggings");
    public static final Item witherbone_boots = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, 3, "witherbone", wither_bone).setUnlocalizedName("witherbone_boots");
    public static final Item witherbone_pickaxe = new ItemNormalPickaxe(MoreCraft.WITHERBONE_T, wither_bone).setUnlocalizedName("witherbone_pickaxe");
    public static final Item witherbone_axe = new ItemNormalAxe(MoreCraft.WITHERBONE_T, wither_bone).setUnlocalizedName("witherbone_axe");
    public static final Item witherbone_shovel = new ItemNormalSpade(MoreCraft.WITHERBONE_T, wither_bone).setUnlocalizedName("witherbone_shovel");
    public static final Item witherbone_hoe = new ItemNormalHoe(MoreCraft.WITHERBONE_T, wither_bone).setUnlocalizedName("witherbone_hoe");
    public static final Item witherbone_sword = new ItemNormalSword(MoreCraft.WITHERBONE_T, wither_bone).setUnlocalizedName("witherbone_sword");
    
    public static final Item emerald_helmet = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, 0, "emerald", Items.emerald).setUnlocalizedName("emerald_helmet");
    public static final Item emerald_chestplate = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, 1, "emerald", Items.emerald).setUnlocalizedName("emerald_chestplate");
    public static final Item emerald_leggings = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, 2, "emerald", Items.emerald).setUnlocalizedName("emerald_leggings");
    public static final Item emerald_boots = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, 3, "emerald", Items.emerald).setUnlocalizedName("emerald_boots");
    public static final Item emerald_pickaxe = new ItemNormalPickaxe(MoreCraft.EMERALD_T, Items.emerald).setUnlocalizedName("emerald_pickaxe");
    public static final Item emerald_axe = new ItemNormalAxe(MoreCraft.EMERALD_T, Items.emerald).setUnlocalizedName("emerald_axe");
    public static final Item emerald_shovel = new ItemNormalSpade(MoreCraft.EMERALD_T, Items.emerald).setUnlocalizedName("emerald_shovel");
    public static final Item emerald_hoe = new ItemNormalHoe(MoreCraft.EMERALD_T, Items.emerald).setUnlocalizedName("emerald_hoe");
    public static final Item emerald_sword = new ItemNormalSword(MoreCraft.EMERALD_T, Items.emerald).setUnlocalizedName("emerald_sword");
    
    public static final Item ruby_helmet = new ItemNormalArmor(MoreCraft.RUBY_A, 4, 0, "ruby", ruby).setUnlocalizedName("ruby_helmet");
    public static final Item ruby_chestplate = new ItemNormalArmor(MoreCraft.RUBY_A, 4, 1, "ruby", ruby).setUnlocalizedName("ruby_chestplate");
    public static final Item ruby_leggings = new ItemNormalArmor(MoreCraft.RUBY_A, 4, 2, "ruby", ruby).setUnlocalizedName("ruby_leggings");
    public static final Item ruby_boots = new ItemNormalArmor(MoreCraft.RUBY_A, 4, 3, "ruby", ruby).setUnlocalizedName("ruby_boots");
    public static final Item ruby_pickaxe = new ItemNormalPickaxe(MoreCraft.RUBY_T, ruby).setUnlocalizedName("ruby_pickaxe");
    public static final Item ruby_axe = new ItemNormalAxe(MoreCraft.RUBY_T, ruby).setUnlocalizedName("ruby_axe");
    public static final Item ruby_shovel = new ItemNormalSpade(MoreCraft.RUBY_T, ruby).setUnlocalizedName("ruby_shovel");
    public static final Item ruby_hoe = new ItemNormalHoe(MoreCraft.RUBY_T, ruby).setUnlocalizedName("ruby_hoe");
    public static final Item ruby_sword = new ItemNormalSword(MoreCraft.RUBY_T, ruby).setUnlocalizedName("ruby_sword");
    
    public static final Item blaze_helmet = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, 0, "blaze", Items.blaze_rod).setUnlocalizedName("blaze_helmet");
    public static final Item blaze_chestplate = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, 1, "blaze", Items.blaze_rod).setUnlocalizedName("blaze_chestplate");
    public static final Item blaze_leggings = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, 2, "blaze", Items.blaze_rod).setUnlocalizedName("blaze_leggings");
    public static final Item blaze_boots = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, 3, "blaze", Items.blaze_rod).setUnlocalizedName("blaze_boots");
    public static final Item blaze_pickaxe = new ItemNormalPickaxe(MoreCraft.BLAZE_T, Items.blaze_rod).setUnlocalizedName("blaze_pickaxe");
    public static final Item blaze_axe = new ItemNormalAxe(MoreCraft.BLAZE_T, Items.blaze_rod).setUnlocalizedName("blaze_axe");
    public static final Item blaze_shovel = new ItemNormalSpade(MoreCraft.BLAZE_T, Items.blaze_rod).setUnlocalizedName("blaze_shovel");
    public static final Item blaze_hoe = new ItemNormalHoe(MoreCraft.BLAZE_T, Items.blaze_rod).setUnlocalizedName("blaze_hoe");
    public static final Item blaze_sword = new ItemNormalSword(MoreCraft.BLAZE_T, Items.blaze_rod).setUnlocalizedName("blaze_sword");
    
    public static final Item ender_helmet = new ItemNormalArmor(MoreCraft.ENDER_A, 4, 0, "ender", Items.ender_pearl).setUnlocalizedName("ender_helmet");
    public static final Item ender_chestplate = new ItemNormalArmor(MoreCraft.ENDER_A, 4, 1, "ender", Items.ender_pearl).setUnlocalizedName("ender_chestplate");
    public static final Item ender_leggings = new ItemNormalArmor(MoreCraft.ENDER_A, 4, 2, "ender", Items.ender_pearl).setUnlocalizedName("ender_leggings");
    public static final Item ender_boots = new ItemNormalArmor(MoreCraft.ENDER_A, 4, 3, "ender", Items.ender_pearl).setUnlocalizedName("ender_boots");
    public static final Item ender_pickaxe = new ItemNormalPickaxe(MoreCraft.ENDER_T, Items.ender_pearl).setUnlocalizedName("ender_pickaxe");
    public static final Item ender_axe = new ItemNormalAxe(MoreCraft.ENDER_T, Items.ender_pearl).setUnlocalizedName("ender_axe");
    public static final Item ender_shovel = new ItemNormalSpade(MoreCraft.ENDER_T, Items.ender_pearl).setUnlocalizedName("ender_shovel");
    public static final Item ender_hoe = new ItemNormalHoe(MoreCraft.ENDER_T, Items.ender_pearl).setUnlocalizedName("ender_hoe");
    public static final Item ender_sword = new ItemNormalSword(MoreCraft.ENDER_T, Items.ender_pearl).setUnlocalizedName("ender_sword");
    
    public static final Item endstone_pickaxe = new ItemNormalPickaxe(MoreCraft.ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("endstone_pickaxe");
    public static final Item endstone_axe = new ItemNormalAxe(MoreCraft.ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("endstone_axe");
    public static final Item endstone_shovel = new ItemNormalSpade(MoreCraft.ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("endstone_shovel");
    public static final Item endstone_hoe = new ItemNormalHoe(MoreCraft.ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("endstone_hoe");
    public static final Item endstone_sword = new ItemNormalSword(MoreCraft.ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("endstone_sword");
    
    public static final Item netherrack_pickaxe = new ItemNormalPickaxe(MoreCraft.NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("netherrack_pickaxe");
    public static final Item netherrack_axe = new ItemNormalAxe(MoreCraft.NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("netherrack_axe");
    public static final Item netherrack_shovel = new ItemNormalSpade(MoreCraft.NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("netherrack_shovel");
    public static final Item netherrack_hoe = new ItemNormalHoe(MoreCraft.NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("netherrack_hoe");
    public static final Item netherrack_sword = new ItemNormalSword(MoreCraft.NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("netherrack_sword");
    /*
    public static final Item guardian_helmet = new ItemNormalArmor(MoreCraft.GUARDIAN_A, 4, 0, "guardian", guardian_scale).setUnlocalizedName("guardian_helmet");
    public static final Item guardian_chestplate = new ItemNormalArmor(MoreCraft.GUARDIAN_A, 4, 1, "guardian", guardian_scale).setUnlocalizedName("guardian_chestplate");
    public static final Item guardian_leggings = new ItemNormalArmor(MoreCraft.GUARDIAN_A, 4, 2, "guardian", guardian_scale).setUnlocalizedName("guardian_leggings");
    public static final Item guardian_boots = new ItemNormalArmor(MoreCraft.GUARDIAN_A, 4, 3, "guardian", guardian_scale).setUnlocalizedName("guardian_boots");
     */
    public static final Item bonelord_helmet = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, 0, "necro", Items.bone).setUnlocalizedName("bonelord_helmet");
    public static final Item bonelord_chestplate = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, 1, "necro", Items.bone).setUnlocalizedName("bonelord_chestplate");
    public static final Item bonelord_leggings = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, 2, "necro", Items.bone).setUnlocalizedName("bonelord_leggings");
    public static final Item bonelord_boots = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, 3, "necro", Items.bone).setUnlocalizedName("bonelord_boots");
    
    public static final Item enderdragon_helmet = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, 0, "enderdragon").setUnlocalizedName("enderdragon_helmet");
    public static final Item enderdragon_chestplate = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, 1, "enderdragon").setUnlocalizedName("enderdragon_chestplate");
    public static final Item enderdragon_leggings = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, 2, "enderdragon").setUnlocalizedName("enderdragon_leggings");
    public static final Item enderdragon_boots = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, 3, "enderdragon").setUnlocalizedName("enderdragon_boots");
    
    public static final Item bedrock_helmet = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, 0, "bedrock", Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_helmet");
    public static final Item bedrock_chestplate = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, 1, "bedrock", Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_chestplate");
    public static final Item bedrock_leggings = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, 2, "bedrock", Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_leggings");
    public static final Item bedrock_boots = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, 3, "bedrock", Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_boots");  
    public static final Item bedrock_pickaxe = new ItemNormalPickaxe(MoreCraft.BEDROCK_T, Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_pickaxe");
    public static final Item bedrock_axe = new ItemNormalAxe(MoreCraft.BEDROCK_T, Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_axe");
    public static final Item bedrock_shovel = new ItemNormalSpade(MoreCraft.BEDROCK_T, Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_shovel");
    public static final Item bedrock_hoe = new ItemNormalHoe(MoreCraft.BEDROCK_T, Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_hoe");
    public static final Item bedrock_sword = new ItemNormalSword(MoreCraft.BEDROCK_T, Item.getItemFromBlock(Blocks.bedrock)).setUnlocalizedName("bedrock_sword");
    
    public static void registerItems() {
    	GameRegistry.registerItem(cooked_flesh, "cooked_flesh");
    	GameRegistry.registerItem(spider_raw, "spider_raw");
    	GameRegistry.registerItem(spider_cooked, "spider_cooked");
    	GameRegistry.registerItem(apple_pie, "apple_pie");
    	GameRegistry.registerItem(cake_slice, "cake_slice");
    	GameRegistry.registerItem(squid_raw, "squid_raw");
    	GameRegistry.registerItem(squid_cooked, "squid_cooked");
    	GameRegistry.registerItem(egg_cooked, "egg_cooked");
    	GameRegistry.registerItem(guardian_meat_raw, "guardian_meat_raw");
    	GameRegistry.registerItem(guardian_meat_cooked, "guardian_meat_cooked");

    	GameRegistry.registerItem(ender_brick, "ender_brick");
    	GameRegistry.registerItem(ruby, "ruby");
    	GameRegistry.registerItem(wither_bone, "wither_bone");
    	//GameRegistry.registerItem(guardian_scale, "guardian_scale");

    	GameRegistry.registerItem(netherbrick_door_item, "netherbrick_door_item");
    	GameRegistry.registerItem(netherwood_door_item, "netherwood_door_item");
    	GameRegistry.registerItem(glass_door_item, "glass_door_item");
    	GameRegistry.registerItem(bone_door_item, "bone_door_item");

    	GameRegistry.registerItem(slime_helmet, "slime_helmet");
    	GameRegistry.registerItem(slime_chestplate, "slime_chestplate");
    	GameRegistry.registerItem(slime_leggings, "slime_leggings");
    	GameRegistry.registerItem(slime_boots, "slime_boots");
    	
    	GameRegistry.registerItem(flesh_helmet, "flesh_helmet");
    	GameRegistry.registerItem(flesh_chestplate, "flesh_chestplate");
    	GameRegistry.registerItem(flesh_leggings, "flesh_leggings");
    	GameRegistry.registerItem(flesh_boots, "flesh_boots");

    	GameRegistry.registerItem(spidersilk_helmet, "spidersilk_helmet");
    	GameRegistry.registerItem(spidersilk_chestplate, "spidersilk_chestplate");
    	GameRegistry.registerItem(spidersilk_leggings, "spidersilk_leggings");
    	GameRegistry.registerItem(spidersilk_boots, "spidersilk_boots");
    	
    	GameRegistry.registerItem(obsidian_helmet, "obsidian_helmet");
    	GameRegistry.registerItem(obsidian_chestplate, "obsidian_chestplate");
    	GameRegistry.registerItem(obsidian_leggings, "obsidian_leggings");
    	GameRegistry.registerItem(obsidian_boots, "obsidian_boots");
    	GameRegistry.registerItem(obsidian_pickaxe, "obsidian_pickaxe");
    	GameRegistry.registerItem(obsidian_axe, "obsidian_axe");
    	GameRegistry.registerItem(obsidian_shovel, "obsidian_shovel");
    	GameRegistry.registerItem(obsidian_hoe, "obsidian_hoe");
    	GameRegistry.registerItem(obsidian_sword, "obsidian_sword");

    	GameRegistry.registerItem(bone_helmet, "bone_helmet");
    	GameRegistry.registerItem(bone_chestplate, "bone_chestplate");
    	GameRegistry.registerItem(bone_leggings, "bone_leggings");
    	GameRegistry.registerItem(bone_boots, "bone_boots");
    	GameRegistry.registerItem(bone_pickaxe, "bone_pickaxe");
    	GameRegistry.registerItem(bone_axe, "bone_axe");
    	GameRegistry.registerItem(bone_shovel, "bone_shovel");
    	GameRegistry.registerItem(bone_hoe, "bone_hoe");
    	GameRegistry.registerItem(bone_sword, "bone_sword");

    	GameRegistry.registerItem(witherbone_helmet, "witherbone_helmet");
    	GameRegistry.registerItem(witherbone_chestplate, "witherbone_chestplate");
    	GameRegistry.registerItem(witherbone_leggings, "witherbone_leggings");
    	GameRegistry.registerItem(witherbone_boots, "witherbone_boots");
    	GameRegistry.registerItem(witherbone_pickaxe, "witherbone_pickaxe");
    	GameRegistry.registerItem(witherbone_axe, "witherbone_axe");
    	GameRegistry.registerItem(witherbone_shovel, "witherbone_shovel");
    	GameRegistry.registerItem(witherbone_hoe, "witherbone_hoe");
    	GameRegistry.registerItem(witherbone_sword, "witherbone_sword");

    	GameRegistry.registerItem(emerald_helmet, "emerald_helmet");
    	GameRegistry.registerItem(emerald_chestplate, "emerald_chestplate");
    	GameRegistry.registerItem(emerald_leggings, "emerald_leggings");
    	GameRegistry.registerItem(emerald_boots, "emerald_boots");
    	GameRegistry.registerItem(emerald_pickaxe, "emerald_pickaxe");
    	GameRegistry.registerItem(emerald_axe, "emerald_axe");
    	GameRegistry.registerItem(emerald_shovel, "emerald_shovel");
    	GameRegistry.registerItem(emerald_hoe, "emerald_hoe");
    	GameRegistry.registerItem(emerald_sword, "emerald_sword");

    	GameRegistry.registerItem(ruby_helmet, "ruby_helmet");
    	GameRegistry.registerItem(ruby_chestplate, "ruby_chestplate");
    	GameRegistry.registerItem(ruby_leggings, "ruby_leggings");
    	GameRegistry.registerItem(ruby_boots, "ruby_boots");
    	GameRegistry.registerItem(ruby_pickaxe, "ruby_pickaxe");
    	GameRegistry.registerItem(ruby_axe, "ruby_axe");
    	GameRegistry.registerItem(ruby_shovel, "ruby_shovel");
    	GameRegistry.registerItem(ruby_hoe, "ruby_hoe");
    	GameRegistry.registerItem(ruby_sword, "ruby_sword");

    	GameRegistry.registerItem(blaze_helmet, "blaze_helmet");
    	GameRegistry.registerItem(blaze_chestplate, "blaze_chestplate");
    	GameRegistry.registerItem(blaze_leggings, "blaze_leggings");
    	GameRegistry.registerItem(blaze_boots, "blaze_boots");
    	GameRegistry.registerItem(blaze_pickaxe, "blaze_pickaxe");
    	GameRegistry.registerItem(blaze_axe, "blaze_axe");
    	GameRegistry.registerItem(blaze_shovel, "blaze_shovel");
    	GameRegistry.registerItem(blaze_hoe, "blaze_hoe");
    	GameRegistry.registerItem(blaze_sword, "blaze_sword");

    	GameRegistry.registerItem(ender_helmet, "ender_helmet");
    	GameRegistry.registerItem(ender_chestplate, "ender_chestplate");
    	GameRegistry.registerItem(ender_leggings, "ender_leggings");
    	GameRegistry.registerItem(ender_boots, "ender_boots");
    	GameRegistry.registerItem(ender_pickaxe, "ender_pickaxe");
    	GameRegistry.registerItem(ender_axe, "ender_axe");
    	GameRegistry.registerItem(ender_shovel, "ender_shovel");
    	GameRegistry.registerItem(ender_hoe, "ender_hoe");
    	GameRegistry.registerItem(ender_sword, "ender_sword");

    	GameRegistry.registerItem(endstone_pickaxe, "endstone_pickaxe");
    	GameRegistry.registerItem(endstone_axe, "endstone_axe");
    	GameRegistry.registerItem(endstone_shovel, "endstone_shovel");
    	GameRegistry.registerItem(endstone_hoe, "endstone_hoe");
    	GameRegistry.registerItem(endstone_sword, "endstone_sword");
    	
    	GameRegistry.registerItem(netherrack_pickaxe, "netherrack_pickaxe");
    	GameRegistry.registerItem(netherrack_axe, "netherrack_axe");
    	GameRegistry.registerItem(netherrack_shovel, "netherrack_shovel");
    	GameRegistry.registerItem(netherrack_hoe, "netherrack_hoe");
    	GameRegistry.registerItem(netherrack_sword, "netherrack_sword");
    	/*
    	GameRegistry.registerItem(guardian_helmet, "guardian_helmet");
    	GameRegistry.registerItem(guardian_chestplate, "guardian_chestplate");
    	GameRegistry.registerItem(guardian_leggings, "guardian_leggings");
    	GameRegistry.registerItem(guardian_boots, "guardian_boots");*/
    	
    	GameRegistry.registerItem(bonelord_helmet, "bonelord_helmet");
    	GameRegistry.registerItem(bonelord_chestplate, "bonelord_chestplate");
    	GameRegistry.registerItem(bonelord_leggings, "bonelord_leggings");
    	GameRegistry.registerItem(bonelord_boots, "bonelord_boots");
    	
    	GameRegistry.registerItem(enderdragon_helmet, "enderdragon_helmet");
    	GameRegistry.registerItem(enderdragon_chestplate, "enderdragon_chestplate");
    	GameRegistry.registerItem(enderdragon_leggings, "enderdragon_leggings");
    	GameRegistry.registerItem(enderdragon_boots, "enderdragon_boots");

    	GameRegistry.registerItem(bedrock_helmet, "bedrock_helmet");
    	GameRegistry.registerItem(bedrock_chestplate, "bedrock_chestplate");
    	GameRegistry.registerItem(bedrock_leggings, "bedrock_leggings");
    	GameRegistry.registerItem(bedrock_boots, "bedrock_boots");
    	GameRegistry.registerItem(bedrock_pickaxe, "bedrock_pickaxe");
    	GameRegistry.registerItem(bedrock_axe, "bedrock_axe");
    	GameRegistry.registerItem(bedrock_shovel, "bedrock_shovel");
    	GameRegistry.registerItem(bedrock_hoe, "bedrock_hoe");
    	GameRegistry.registerItem(bedrock_sword, "bedrock_sword");
    }
}
