package kittehmod.bettercraft;

import kittehmod.bettercraft.item.ItemBlazeArmor;
import kittehmod.bettercraft.item.ItemBonelordArmor;
import kittehmod.bettercraft.item.ItemEnderdragonArmor;
import kittehmod.bettercraft.item.ItemNetherApple;
import kittehmod.bettercraft.item.ItemNetherwoodBoat;
import kittehmod.bettercraft.item.ItemNormalArmor;
import kittehmod.bettercraft.item.ItemNormalAxe;
import kittehmod.bettercraft.item.ItemNormalHoe;
import kittehmod.bettercraft.item.ItemNormalPickaxe;
import kittehmod.bettercraft.item.ItemNormalSpade;
import kittehmod.bettercraft.item.ItemNormalSword;
import kittehmod.bettercraft.item.ItemSlimeArmor;
import kittehmod.bettercraft.item.ItemWitherArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreCraftItems {

	// -- FOOD -- \\
    public static final Item COOKED_FLESH = (new ItemFood(8, 0.8F, true)).setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20, 0), 0.1F).setUnlocalizedName("cooked_flesh");
    public static final Item SPIDER_RAW = (new ItemFood(3, 0.3F, true)).setPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 30, 0), 0.1F).setUnlocalizedName("spider_raw");
    public static final Item SPIDER_COOKED = (new ItemFood(7, 0.7F, true)).setUnlocalizedName("spider_cooked");
    public static final Item APPLE_PIE = (new ItemFood(8, 0.8F, false)).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5, 0), 0.3F).setUnlocalizedName("apple_pie");
    public static final Item CAKE_SLICE = (new ItemFood(2, 0.3F, false)).setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 0), 0.25F).setUnlocalizedName("cake_slice");
    public static final Item SQUID_RAW = (new ItemFood(3, 0.3F, false)).setPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 0, 0), 0.3F).setUnlocalizedName("squid_raw");
    public static final Item SQUID_COOKED = (new ItemFood(6, 0.6F, false)).setUnlocalizedName("squid_cooked");
    public static final Item EGG_COOKED = (new ItemFood(6, 0.5F, false)).setUnlocalizedName("egg_cooked");
    public static final Item GUARDIAN_MEAT_RAW = new ItemFood(3, 0.3F, true).setUnlocalizedName("guardian_meat_raw");
    public static final Item GUARDIAN_MEAT_COOKED = new ItemFood(7, 0.7F, true).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30, 0), 1.0F).setUnlocalizedName("guardian_meat_cooked");
    public static final Item NETHER_APPLE = (new ItemNetherApple()).setUnlocalizedName("nether_apple");
    
    // -- MATERIALS -- \\
    public static final Item RUBY = new Item().setUnlocalizedName("ruby").setCreativeTab(CreativeTabs.MATERIALS);    
    public static final Item WITHER_BONE = new Item().setUnlocalizedName("wither_bone").setCreativeTab(CreativeTabs.MATERIALS);
    public static final Item ENDERDRAGON_SCALES = new Item().setUnlocalizedName("enderdragon_scales").setCreativeTab(CreativeTabs.MATERIALS);    
    
	// -- DOOR ITEMS -- \\
    public static final Item NETHERBRICK_DOOR = (new ItemDoor(MoreCraftBlocks.NETHERBRICK_DOOR)).setUnlocalizedName("netherbrick_door");
    public static final Item NETHERWOOD_DOOR = (new ItemDoor(MoreCraftBlocks.NETHERWOOD_DOOR)).setUnlocalizedName("netherwood_door");
	public static final Item GLASS_DOOR = (new ItemDoor(MoreCraftBlocks.GLASS_DOOR)).setUnlocalizedName("glass_door");
    public static final Item BONE_DOOR = (new ItemDoor(MoreCraftBlocks.BONE_DOOR)).setUnlocalizedName("bone_door");
    
	// -- BOAT ITEMS -- \\
    public static final Item NETHERWOOD_BOAT = new ItemNetherwoodBoat().setUnlocalizedName("netherwood_boat");
    
	// -- HORSE ARMOUR -- \\ Not Active.
    /*public static final Item BONE_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("bone_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item EMERALD_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("emerald_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item RUBY_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("ruby_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item OBSIDIAN_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("obsidian_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);*/
    
	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final Item SLIME_HELMET = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("slime_helmet");
    public static final Item SLIME_CHESTPLATE = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("slime_chestplate");
    public static final Item SLIME_LEGGINGS = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("slime_leggings");
    public static final Item SLIME_BOOTS = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("slime_boots");
    
    public static final Item FLESH_HELMET = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("flesh_helmet");
    public static final Item FLESH_CHESTPLATE = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("flesh_chestplate");
    public static final Item FLESH_LEGGINGS = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("flesh_leggings");
    public static final Item FLESH_BOOTS = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("flesh_boots");
	
    public static final Item SPIDERSILK_HELMET = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("spidersilk_helmet");
    public static final Item SPIDERSILK_CHESTPLATE = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("spidersilk_chestplate");
    public static final Item SPIDERSILK_LEGGINGS = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("spidersilk_leggings");
    public static final Item SPIDERSILK_BOOTS = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("spidersilk_boots");
    
    public static final Item OBSIDIAN_HELMET = new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("obsidian_helmet");
    public static final Item OBSIDIAN_CHESTPLATE =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("obsidian_chestplate");
    public static final Item OBSIDIAN_LEGGINGS =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("obsidian_leggings");
    public static final Item OBSIDIAN_BOOTS =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("obsidian_boots");
    public static final Item OBSIDIAN_PICKAXE = new ItemNormalPickaxe(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_pickaxe");
    public static final Item OBSIDIAN_AXE = new ItemNormalAxe(MoreCraft.OBSIDIAN_T, 11, 1.0F).setUnlocalizedName("obsidian_axe");
    public static final Item OBSIDIAN_SHOVEL = new ItemNormalSpade(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_shovel");
    public static final Item OBSIDIAN_HOE = new ItemNormalHoe(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_hoe");
    public static final Item OBSIDIAN_SWORD = new ItemNormalSword(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_sword");
    
    public static final Item BONE_HELMET = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bone_helmet");
    public static final Item BONE_CHESTPLATE = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bone_chestplate");
    public static final Item BONE_LEGGINGS = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bone_leggings");
    public static final Item BONE_BOOTS = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bone_boots");
    public static final Item BONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.BONE_T).setUnlocalizedName("bone_pickaxe");
    public static final Item BONE_AXE = new ItemNormalAxe(MoreCraft.BONE_T, 9, 0.8F).setUnlocalizedName("bone_axe");
    public static final Item BONE_SHOVEL = new ItemNormalSpade(MoreCraft.BONE_T).setUnlocalizedName("bone_shovel");
    public static final Item BONE_HOE = new ItemNormalHoe(MoreCraft.BONE_T).setUnlocalizedName("bone_hoe");
    public static final Item BONE_SWORD = new ItemNormalSword(MoreCraft.BONE_T).setUnlocalizedName("bone_sword");
    
    public static final Item WITHERBONE_HELMET = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("witherbone_helmet");
    public static final Item WITHERBONE_CHESTPLATE = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("witherbone_chestplate");
    public static final Item WITHERBONE_LEGGINGS = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("witherbone_leggings");
    public static final Item WITHERBONE_BOOTS = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("witherbone_boots");
    public static final Item WITHERBONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_pickaxe");
    public static final Item WITHERBONE_AXE = new ItemNormalAxe(MoreCraft.WITHERBONE_T, 10, 1.0F).setUnlocalizedName("witherbone_axe");
    public static final Item WITHERBONE_SHOVEL = new ItemNormalSpade(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_shovel");
    public static final Item WITHERBONE_HOE = new ItemNormalHoe(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_hoe");
    public static final Item WITHERBONE_SWORD = new ItemNormalSword(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_sword");
    
    public static final Item EMERALD_HELMET = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("emerald_helmet");
    public static final Item EMERALD_CHESTPLATE = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("emerald_chestplate");
    public static final Item EMERALD_LEGGINGS = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("emerald_leggings");
    public static final Item EMERALD_BOOTS = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("emerald_boots");
    public static final Item EMERALD_PICKAXE = new ItemNormalPickaxe(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_pickaxe");
    public static final Item EMERALD_AXE = new ItemNormalAxe(MoreCraft.EMERALD_T, 9, 1.0F).setUnlocalizedName("emerald_axe");
    public static final Item EMERALD_SHOVEL = new ItemNormalSpade(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_shovel");
    public static final Item EMERALD_HOE = new ItemNormalHoe(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_hoe");
    public static final Item EMERALD_SWORD = new ItemNormalSword(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_sword");
    
    public static final Item RUBY_HELMET = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("ruby_helmet");
    public static final Item RUBY_CHESTPLATE = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("ruby_chestplate");
    public static final Item RUBY_LEGGINGS = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("ruby_leggings");
    public static final Item RUBY_BOOTS = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("ruby_boots");
    public static final Item RUBY_PICKAXE = new ItemNormalPickaxe(MoreCraft.RUBY_T).setUnlocalizedName("ruby_pickaxe");
    public static final Item RUBY_AXE = new ItemNormalAxe(MoreCraft.RUBY_T, 9, 0.9F).setUnlocalizedName("ruby_axe");
    public static final Item RUBY_SHOVEL = new ItemNormalSpade(MoreCraft.RUBY_T).setUnlocalizedName("ruby_shovel");
    public static final Item RUBY_HOE = new ItemNormalHoe(MoreCraft.RUBY_T).setUnlocalizedName("ruby_hoe");
    public static final Item RUBY_SWORD = new ItemNormalSword(MoreCraft.RUBY_T).setUnlocalizedName("ruby_sword");
    
    public static final Item BLAZE_HELMET = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("blaze_helmet");
    public static final Item BLAZE_CHESTPLATE = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("blaze_chestplate");
    public static final Item BLAZE_LEGGINGS = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("blaze_leggings");
    public static final Item BLAZE_BOOTS = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("blaze_boots");
    public static final Item BLAZE_PICKAXE = new ItemNormalPickaxe(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_pickaxe");
    public static final Item BLAZE_AXE = new ItemNormalAxe(MoreCraft.BLAZE_T, 9, 0.9F).setUnlocalizedName("blaze_axe");
    public static final Item BLAZE_SHOVEL = new ItemNormalSpade(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_shovel");
    public static final Item BLAZE_HOE = new ItemNormalHoe(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_hoe");
    public static final Item BLAZE_SWORD = new ItemNormalSword(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_sword");
    
    public static final Item ENDER_HELMET = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("ender_helmet");
    public static final Item ENDER_CHESTPLATE = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("ender_chestplate");
    public static final Item ENDER_LEGGINGS = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("ender_leggings");
    public static final Item ENDER_BOOTS = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("ender_boots");
    public static final Item ENDER_PICKAXE = new ItemNormalPickaxe(MoreCraft.ENDER_T).setUnlocalizedName("ender_pickaxe");
    public static final Item ENDER_AXE = new ItemNormalAxe(MoreCraft.ENDER_T, 10, 0.9F).setUnlocalizedName("ender_axe");
    public static final Item ENDER_SHOVEL = new ItemNormalSpade(MoreCraft.ENDER_T).setUnlocalizedName("ender_shovel");
    public static final Item ENDER_HOE = new ItemNormalHoe(MoreCraft.ENDER_T).setUnlocalizedName("ender_hoe");
    public static final Item ENDER_SWORD = new ItemNormalSword(MoreCraft.ENDER_T).setUnlocalizedName("ender_sword");
    
    public static final Item ENDSTONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_pickaxe");
    public static final Item ENDSTONE_AXE = new ItemNormalAxe(MoreCraft.ENDSTONE_T, 9, 0.8F).setUnlocalizedName("endstone_axe");
    public static final Item ENDSTONE_SHOVEL = new ItemNormalSpade(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_shovel");
    public static final Item ENDSTONE_HOE = new ItemNormalHoe(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_hoe");
    public static final Item ENDSTONE_SWORD = new ItemNormalSword(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_sword");
    
    public static final Item NETHERRACK_PICKAXE = new ItemNormalPickaxe(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_pickaxe");
    public static final Item NETHERRACK_AXE = new ItemNormalAxe(MoreCraft.NETHERRACK_T, 9, 0.8F).setUnlocalizedName("netherrack_axe");
    public static final Item NETHERRACK_SHOVEL = new ItemNormalSpade(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_shovel");
    public static final Item NETHERRACK_HOE = new ItemNormalHoe(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_hoe");
    public static final Item NETHERRACK_SWORD = new ItemNormalSword(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_sword");

    public static final Item BONELORD_HELMET = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bonelord_helmet");
    public static final Item BONELORD_CHESTPLATE = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bonelord_chestplate");
    public static final Item BONELORD_LEGGINGS = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bonelord_leggings");
    public static final Item BONELORD_BOOTS = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bonelord_boots");
    
    public static final Item ENDERDRAGON_HELMET = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("enderdragon_helmet");
    public static final Item ENDERDRAGON_CHESTPLATE = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("enderdragon_chestplate");
    public static final Item ENDERDRAGON_LEGGINGS = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("enderdragon_leggings");
    public static final Item ENDERDRAGON_BOOTS = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("enderdragon_boots");
    
    public static final Item BEDROCK_HELMET = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bedrock_helmet");
    public static final Item BEDROCK_CHESTPLATE = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bedrock_chestplate");
    public static final Item BEDROCK_LEGGINGS = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bedrock_leggings");
    public static final Item BEDROCK_BOOTS = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bedrock_boots");  
    public static final Item BEDROCK_PICKAXE = new ItemNormalPickaxe(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_pickaxe");
    public static final Item BEDROCK_AXE = new ItemNormalAxe(MoreCraft.BEDROCK_T, 11, 1.0F).setUnlocalizedName("bedrock_axe");
    public static final Item BEDROCK_SHOVEL = new ItemNormalSpade(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_shovel");
    public static final Item BEDROCK_HOE = new ItemNormalHoe(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_hoe");
    public static final Item BEDROCK_SWORD = new ItemNormalSword(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_sword");
    
    public static void registerItems() {
    	GameRegistry.registerItem(COOKED_FLESH, "cooked_flesh");
    	GameRegistry.registerItem(SPIDER_RAW, "spider_raw");
    	GameRegistry.registerItem(SPIDER_COOKED, "spider_cooked");
    	GameRegistry.registerItem(APPLE_PIE, "apple_pie");
    	GameRegistry.registerItem(CAKE_SLICE, "cake_slice");
    	GameRegistry.registerItem(SQUID_RAW, "squid_raw");
    	GameRegistry.registerItem(SQUID_COOKED, "squid_cooked");
    	GameRegistry.registerItem(EGG_COOKED, "egg_cooked");
    	GameRegistry.registerItem(GUARDIAN_MEAT_RAW, "guardian_meat_raw");
    	GameRegistry.registerItem(GUARDIAN_MEAT_COOKED, "guardian_meat_cooked");
    	GameRegistry.registerItem(NETHER_APPLE, "nether_apple");

    	GameRegistry.registerItem(RUBY, "ruby");
    	GameRegistry.registerItem(WITHER_BONE, "wither_bone");
    	GameRegistry.registerItem(ENDERDRAGON_SCALES, "enderdragon_scales");

    	GameRegistry.registerItem(NETHERWOOD_BOAT, "netherwood_boat");
    	
    	GameRegistry.registerItem(NETHERBRICK_DOOR, "netherbrick_door_item");
    	GameRegistry.registerItem(NETHERWOOD_DOOR, "netherwood_door_item");
    	GameRegistry.registerItem(GLASS_DOOR, "glass_door_item");
    	GameRegistry.registerItem(BONE_DOOR, "bone_door_item");

    	GameRegistry.registerItem(SLIME_HELMET, "slime_helmet");
    	GameRegistry.registerItem(SLIME_CHESTPLATE, "slime_chestplate");
    	GameRegistry.registerItem(SLIME_LEGGINGS, "slime_leggings");
    	GameRegistry.registerItem(SLIME_BOOTS, "slime_boots");
    	
    	GameRegistry.registerItem(FLESH_HELMET, "flesh_helmet");
    	GameRegistry.registerItem(FLESH_CHESTPLATE, "flesh_chestplate");
    	GameRegistry.registerItem(FLESH_LEGGINGS, "flesh_leggings");
    	GameRegistry.registerItem(FLESH_BOOTS, "flesh_boots");

    	GameRegistry.registerItem(SPIDERSILK_HELMET, "spidersilk_helmet");
    	GameRegistry.registerItem(SPIDERSILK_CHESTPLATE, "spidersilk_chestplate");
    	GameRegistry.registerItem(SPIDERSILK_LEGGINGS, "spidersilk_leggings");
    	GameRegistry.registerItem(SPIDERSILK_BOOTS, "spidersilk_boots");
    	
    	GameRegistry.registerItem(OBSIDIAN_HELMET, "obsidian_helmet");
    	GameRegistry.registerItem(OBSIDIAN_CHESTPLATE, "obsidian_chestplate");
    	GameRegistry.registerItem(OBSIDIAN_LEGGINGS, "obsidian_leggings");
    	GameRegistry.registerItem(OBSIDIAN_BOOTS, "obsidian_boots");
    	GameRegistry.registerItem(OBSIDIAN_PICKAXE, "obsidian_pickaxe");
    	GameRegistry.registerItem(OBSIDIAN_AXE, "obsidian_axe");
    	GameRegistry.registerItem(OBSIDIAN_SHOVEL, "obsidian_shovel");
    	GameRegistry.registerItem(OBSIDIAN_HOE, "obsidian_hoe");
    	GameRegistry.registerItem(OBSIDIAN_SWORD, "obsidian_sword");

    	GameRegistry.registerItem(BONE_HELMET, "bone_helmet");
    	GameRegistry.registerItem(BONE_CHESTPLATE, "bone_chestplate");
    	GameRegistry.registerItem(BONE_LEGGINGS, "bone_leggings");
    	GameRegistry.registerItem(BONE_BOOTS, "bone_boots");
    	GameRegistry.registerItem(BONE_PICKAXE, "bone_pickaxe");
    	GameRegistry.registerItem(BONE_AXE, "bone_axe");
    	GameRegistry.registerItem(BONE_SHOVEL, "bone_shovel");
    	GameRegistry.registerItem(BONE_HOE, "bone_hoe");
    	GameRegistry.registerItem(BONE_SWORD, "bone_sword");

    	GameRegistry.registerItem(WITHERBONE_HELMET, "witherbone_helmet");
    	GameRegistry.registerItem(WITHERBONE_CHESTPLATE, "witherbone_chestplate");
    	GameRegistry.registerItem(WITHERBONE_LEGGINGS, "witherbone_leggings");
    	GameRegistry.registerItem(WITHERBONE_BOOTS, "witherbone_boots");
    	GameRegistry.registerItem(WITHERBONE_PICKAXE, "witherbone_pickaxe");
    	GameRegistry.registerItem(WITHERBONE_AXE, "witherbone_axe");
    	GameRegistry.registerItem(WITHERBONE_SHOVEL, "witherbone_shovel");
    	GameRegistry.registerItem(WITHERBONE_HOE, "witherbone_hoe");
    	GameRegistry.registerItem(WITHERBONE_SWORD, "witherbone_sword");

    	GameRegistry.registerItem(EMERALD_HELMET, "emerald_helmet");
    	GameRegistry.registerItem(EMERALD_CHESTPLATE, "emerald_chestplate");
    	GameRegistry.registerItem(EMERALD_LEGGINGS, "emerald_leggings");
    	GameRegistry.registerItem(EMERALD_BOOTS, "emerald_boots");
    	GameRegistry.registerItem(EMERALD_PICKAXE, "emerald_pickaxe");
    	GameRegistry.registerItem(EMERALD_AXE, "emerald_axe");
    	GameRegistry.registerItem(EMERALD_SHOVEL, "emerald_shovel");
    	GameRegistry.registerItem(EMERALD_HOE, "emerald_hoe");
    	GameRegistry.registerItem(EMERALD_SWORD, "emerald_sword");

    	GameRegistry.registerItem(RUBY_HELMET, "ruby_helmet");
    	GameRegistry.registerItem(RUBY_CHESTPLATE, "ruby_chestplate");
    	GameRegistry.registerItem(RUBY_LEGGINGS, "ruby_leggings");
    	GameRegistry.registerItem(RUBY_BOOTS, "ruby_boots");
    	GameRegistry.registerItem(RUBY_PICKAXE, "ruby_pickaxe");
    	GameRegistry.registerItem(RUBY_AXE, "ruby_axe");
    	GameRegistry.registerItem(RUBY_SHOVEL, "ruby_shovel");
    	GameRegistry.registerItem(RUBY_HOE, "ruby_hoe");
    	GameRegistry.registerItem(RUBY_SWORD, "ruby_sword");

    	GameRegistry.registerItem(BLAZE_HELMET, "blaze_helmet");
    	GameRegistry.registerItem(BLAZE_CHESTPLATE, "blaze_chestplate");
    	GameRegistry.registerItem(BLAZE_LEGGINGS, "blaze_leggings");
    	GameRegistry.registerItem(BLAZE_BOOTS, "blaze_boots");
    	GameRegistry.registerItem(BLAZE_PICKAXE, "blaze_pickaxe");
    	GameRegistry.registerItem(BLAZE_AXE, "blaze_axe");
    	GameRegistry.registerItem(BLAZE_SHOVEL, "blaze_shovel");
    	GameRegistry.registerItem(BLAZE_HOE, "blaze_hoe");
    	GameRegistry.registerItem(BLAZE_SWORD, "blaze_sword");

    	GameRegistry.registerItem(ENDER_HELMET, "ender_helmet");
    	GameRegistry.registerItem(ENDER_CHESTPLATE, "ender_chestplate");
    	GameRegistry.registerItem(ENDER_LEGGINGS, "ender_leggings");
    	GameRegistry.registerItem(ENDER_BOOTS, "ender_boots");
    	GameRegistry.registerItem(ENDER_PICKAXE, "ender_pickaxe");
    	GameRegistry.registerItem(ENDER_AXE, "ender_axe");
    	GameRegistry.registerItem(ENDER_SHOVEL, "ender_shovel");
    	GameRegistry.registerItem(ENDER_HOE, "ender_hoe");
    	GameRegistry.registerItem(ENDER_SWORD, "ender_sword");

    	GameRegistry.registerItem(ENDSTONE_PICKAXE, "endstone_pickaxe");
    	GameRegistry.registerItem(ENDSTONE_AXE, "endstone_axe");
    	GameRegistry.registerItem(ENDSTONE_SHOVEL, "endstone_shovel");
    	GameRegistry.registerItem(ENDSTONE_HOE, "endstone_hoe");
    	GameRegistry.registerItem(ENDSTONE_SWORD, "endstone_sword");
    	
    	GameRegistry.registerItem(NETHERRACK_PICKAXE, "netherrack_pickaxe");
    	GameRegistry.registerItem(NETHERRACK_AXE, "netherrack_axe");
    	GameRegistry.registerItem(NETHERRACK_SHOVEL, "netherrack_shovel");
    	GameRegistry.registerItem(NETHERRACK_HOE, "netherrack_hoe");
    	GameRegistry.registerItem(NETHERRACK_SWORD, "netherrack_sword");
    	/*
    	GameRegistry.registerItem(guardian_helmet, "guardian_helmet");
    	GameRegistry.registerItem(guardian_chestplate, "guardian_chestplate");
    	GameRegistry.registerItem(guardian_leggings, "guardian_leggings");
    	GameRegistry.registerItem(guardian_boots, "guardian_boots");*/
    	
    	GameRegistry.registerItem(BONELORD_HELMET, "bonelord_helmet");
    	GameRegistry.registerItem(BONELORD_CHESTPLATE, "bonelord_chestplate");
    	GameRegistry.registerItem(BONELORD_LEGGINGS, "bonelord_leggings");
    	GameRegistry.registerItem(BONELORD_BOOTS, "bonelord_boots");
    	
    	GameRegistry.registerItem(ENDERDRAGON_HELMET, "enderdragon_helmet");
    	GameRegistry.registerItem(ENDERDRAGON_CHESTPLATE, "enderdragon_chestplate");
    	GameRegistry.registerItem(ENDERDRAGON_LEGGINGS, "enderdragon_leggings");
    	GameRegistry.registerItem(ENDERDRAGON_BOOTS, "enderdragon_boots");

    	GameRegistry.registerItem(BEDROCK_HELMET, "bedrock_helmet");
    	GameRegistry.registerItem(BEDROCK_CHESTPLATE, "bedrock_chestplate");
    	GameRegistry.registerItem(BEDROCK_LEGGINGS, "bedrock_leggings");
    	GameRegistry.registerItem(BEDROCK_BOOTS, "bedrock_boots");
    	GameRegistry.registerItem(BEDROCK_PICKAXE, "bedrock_pickaxe");
    	GameRegistry.registerItem(BEDROCK_AXE, "bedrock_axe");
    	GameRegistry.registerItem(BEDROCK_SHOVEL, "bedrock_shovel");
    	GameRegistry.registerItem(BEDROCK_HOE, "bedrock_hoe");
    	GameRegistry.registerItem(BEDROCK_SWORD, "bedrock_sword");
    }
}
