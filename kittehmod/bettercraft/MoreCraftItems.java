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
    public static final Item COOKED_FLESH = (new ItemFood(8, 0.8F, true)).setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 0), 0.1F).setUnlocalizedName("cooked_flesh").setRegistryName("cooked_flesh");
    public static final Item SPIDER_RAW = (new ItemFood(3, 0.3F, true)).setPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 600, 0), 0.1F).setUnlocalizedName("spider_raw").setRegistryName("spider_raw");
    public static final Item SPIDER_COOKED = (new ItemFood(7, 0.7F, true)).setUnlocalizedName("spider_cooked").setRegistryName("spider_cooked");
    public static final Item APPLE_PIE = (new ItemFood(8, 0.8F, false)).setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 0), 0.3F).setUnlocalizedName("apple_pie").setRegistryName("apple_pie");
    public static final Item CAKE_SLICE = (new ItemFood(2, 0.3F, false)).setPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0), 0.25F).setUnlocalizedName("cake_slice").setRegistryName("cake_slice");
    public static final Item SQUID_RAW = (new ItemFood(3, 0.3F, false)).setPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 0, 0), 0.3F).setUnlocalizedName("squid_raw").setRegistryName("squid_raw");
    public static final Item SQUID_COOKED = (new ItemFood(6, 0.6F, false)).setUnlocalizedName("squid_cooked").setRegistryName("squid_cooked");
    public static final Item EGG_COOKED = (new ItemFood(6, 0.5F, false)).setUnlocalizedName("egg_cooked").setRegistryName("egg_cooked");
    public static final Item GUARDIAN_MEAT_RAW = new ItemFood(3, 0.3F, true).setUnlocalizedName("guardian_meat_raw").setRegistryName("guardian_meat_raw");
    public static final Item GUARDIAN_MEAT_COOKED = new ItemFood(7, 0.7F, true).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 300, 0), 1.0F).setUnlocalizedName("guardian_meat_cooked").setRegistryName("guardian_meat_cooked");
    public static final Item NETHER_APPLE = (new ItemNetherApple()).setUnlocalizedName("nether_apple").setRegistryName("nether_apple");
    
    // -- MATERIALS -- \\
    public static final Item RUBY = new Item().setUnlocalizedName("ruby").setCreativeTab(CreativeTabs.MATERIALS).setRegistryName("ruby");    
    public static final Item WITHER_BONE = new Item().setUnlocalizedName("wither_bone").setCreativeTab(CreativeTabs.MATERIALS).setRegistryName("wither_bone");
    public static final Item ENDERDRAGON_SCALES = new Item().setUnlocalizedName("enderdragon_scales").setCreativeTab(CreativeTabs.MATERIALS).setRegistryName("enderdragon_scales");
    
	// -- DOOR ITEMS -- \\
    public static final Item NETHERBRICK_DOOR = (new ItemDoor(MoreCraftBlocks.NETHERBRICK_DOOR)).setUnlocalizedName("netherbrick_door").setRegistryName("netherbrick_door");
    public static final Item NETHERWOOD_DOOR = (new ItemDoor(MoreCraftBlocks.NETHERWOOD_DOOR)).setUnlocalizedName("netherwood_door").setRegistryName("netherwood_door");
	public static final Item GLASS_DOOR = (new ItemDoor(MoreCraftBlocks.GLASS_DOOR)).setUnlocalizedName("glass_door").setRegistryName("glass_door");
    public static final Item BONE_DOOR = (new ItemDoor(MoreCraftBlocks.BONE_DOOR)).setUnlocalizedName("bone_door").setRegistryName("bone_door");
    
	// -- BOAT ITEMS -- \\
    public static final Item NETHERWOOD_BOAT = new ItemNetherwoodBoat().setUnlocalizedName("netherwood_boat").setRegistryName("netherwood_boat");
    
	// -- HORSE ARMOUR -- \\ Not Active.
    /*public static final Item BONE_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("bone_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item EMERALD_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("emerald_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item RUBY_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("ruby_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    public static final Item OBSIDIAN_HORSE_ARMOR = (new ItemHorseArmor()).setUnlocalizedName("obsidian_horse_armor").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);*/
    
	// -- TOOLS, WEAPONS, ARMOUR -- \\
    public static final Item SLIME_HELMET = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("slime_helmet").setRegistryName("slime_helmet");
    public static final Item SLIME_CHESTPLATE = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("slime_chestplate").setRegistryName("slime_chestplate");
    public static final Item SLIME_LEGGINGS = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("slime_leggings").setRegistryName("slime_leggings");
    public static final Item SLIME_BOOTS = new ItemSlimeArmor(MoreCraft.SLIME_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("slime_boots").setRegistryName("slime_boots");
    
    public static final Item FLESH_HELMET = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("flesh_helmet").setRegistryName("flesh_helmet");
    public static final Item FLESH_CHESTPLATE = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("flesh_chestplate").setRegistryName("flesh_chestplate");
    public static final Item FLESH_LEGGINGS = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("flesh_leggings").setRegistryName("flesh_leggings");
    public static final Item FLESH_BOOTS = new ItemNormalArmor(MoreCraft.FLESH_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("flesh_boots").setRegistryName("flesh_boots");
	
    public static final Item SPIDERSILK_HELMET = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("spidersilk_helmet").setRegistryName("spidersilk_helmet");
    public static final Item SPIDERSILK_CHESTPLATE = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("spidersilk_chestplate").setRegistryName("spidersilk_chestplate");
    public static final Item SPIDERSILK_LEGGINGS = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("spidersilk_leggings").setRegistryName("spidersilk_leggings");
    public static final Item SPIDERSILK_BOOTS = new ItemNormalArmor(MoreCraft.WEB_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("spidersilk_boots").setRegistryName("spidersilk_boots");
    
    public static final Item OBSIDIAN_HELMET = new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("obsidian_helmet").setRegistryName("obsidian_helmet");
    public static final Item OBSIDIAN_CHESTPLATE =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("obsidian_chestplate").setRegistryName("obsidian_chestplate");
    public static final Item OBSIDIAN_LEGGINGS =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("obsidian_leggings").setRegistryName("obsidian_leggings");
    public static final Item OBSIDIAN_BOOTS =  new ItemNormalArmor(MoreCraft.OBSIDIAN_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("obsidian_boots").setRegistryName("obsidian_boots");
    public static final Item OBSIDIAN_PICKAXE = new ItemNormalPickaxe(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_pickaxe").setRegistryName("obsidian_pickaxe");
    public static final Item OBSIDIAN_AXE = new ItemNormalAxe(MoreCraft.OBSIDIAN_T, 11, 1.0F).setUnlocalizedName("obsidian_axe").setRegistryName("obsidian_axe");
    public static final Item OBSIDIAN_SHOVEL = new ItemNormalSpade(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_shovel").setRegistryName("obsidian_shovel");
    public static final Item OBSIDIAN_HOE = new ItemNormalHoe(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_hoe").setRegistryName("obsidian_hoe");
    public static final Item OBSIDIAN_SWORD = new ItemNormalSword(MoreCraft.OBSIDIAN_T).setUnlocalizedName("obsidian_sword").setRegistryName("obsidian_sword");
    
    public static final Item BONE_HELMET = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bone_helmet").setRegistryName("bone_helmet");
    public static final Item BONE_CHESTPLATE = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bone_chestplate").setRegistryName("bone_chestplate");
    public static final Item BONE_LEGGINGS = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bone_leggings").setRegistryName("bone_leggings");
    public static final Item BONE_BOOTS = new ItemNormalArmor(MoreCraft.BONE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bone_boots").setRegistryName("bone_boots");
    public static final Item BONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.BONE_T).setUnlocalizedName("bone_pickaxe").setRegistryName("bone_pickaxe");
    public static final Item BONE_AXE = new ItemNormalAxe(MoreCraft.BONE_T, 9, 0.8F).setUnlocalizedName("bone_axe").setRegistryName("bone_axe");
    public static final Item BONE_SHOVEL = new ItemNormalSpade(MoreCraft.BONE_T).setUnlocalizedName("bone_shovel").setRegistryName("bone_shovel");
    public static final Item BONE_HOE = new ItemNormalHoe(MoreCraft.BONE_T).setUnlocalizedName("bone_hoe").setRegistryName("bone_hoe");
    public static final Item BONE_SWORD = new ItemNormalSword(MoreCraft.BONE_T).setUnlocalizedName("bone_sword").setRegistryName("bone_sword");
    
    public static final Item WITHERBONE_HELMET = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("witherbone_helmet").setRegistryName("witherbone_helmet");
    public static final Item WITHERBONE_CHESTPLATE = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("witherbone_chestplate").setRegistryName("witherbone_chestplate");
    public static final Item WITHERBONE_LEGGINGS = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("witherbone_leggings").setRegistryName("witherbone_leggings");
    public static final Item WITHERBONE_BOOTS = new ItemWitherArmor(MoreCraft.WITHERBONE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("witherbone_boots").setRegistryName("witherbone_boots");
    public static final Item WITHERBONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_pickaxe").setRegistryName("witherbone_pickaxe");
    public static final Item WITHERBONE_AXE = new ItemNormalAxe(MoreCraft.WITHERBONE_T, 10, 1.0F).setUnlocalizedName("witherbone_axe").setRegistryName("witherbone_axe");
    public static final Item WITHERBONE_SHOVEL = new ItemNormalSpade(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_shovel").setRegistryName("witherbone_shovel");
    public static final Item WITHERBONE_HOE = new ItemNormalHoe(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_hoe").setRegistryName("witherbone_hoe");
    public static final Item WITHERBONE_SWORD = new ItemNormalSword(MoreCraft.WITHERBONE_T).setUnlocalizedName("witherbone_sword").setRegistryName("witherbone_sword");
    
    public static final Item EMERALD_HELMET = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("emerald_helmet").setRegistryName("emerald_helmet");
    public static final Item EMERALD_CHESTPLATE = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("emerald_chestplate").setRegistryName("emerald_chestplate");
    public static final Item EMERALD_LEGGINGS = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("emerald_leggings").setRegistryName("emerald_leggings");
    public static final Item EMERALD_BOOTS = new ItemNormalArmor(MoreCraft.EMERALD_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("emerald_boots").setRegistryName("emerald_boots");
    public static final Item EMERALD_PICKAXE = new ItemNormalPickaxe(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_pickaxe").setRegistryName("emerald_pickaxe");
    public static final Item EMERALD_AXE = new ItemNormalAxe(MoreCraft.EMERALD_T, 9, 1.0F).setUnlocalizedName("emerald_axe").setRegistryName("emerald_axe");
    public static final Item EMERALD_SHOVEL = new ItemNormalSpade(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_shovel").setRegistryName("emerald_shovel");
    public static final Item EMERALD_HOE = new ItemNormalHoe(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_hoe").setRegistryName("emerald_hoe");
    public static final Item EMERALD_SWORD = new ItemNormalSword(MoreCraft.EMERALD_T).setUnlocalizedName("emerald_sword").setRegistryName("emerald_sword");
    
    public static final Item RUBY_HELMET = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("ruby_helmet").setRegistryName("ruby_helmet");
    public static final Item RUBY_CHESTPLATE = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("ruby_chestplate").setRegistryName("ruby_chestplate");
    public static final Item RUBY_LEGGINGS = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("ruby_leggings").setRegistryName("ruby_leggings");
    public static final Item RUBY_BOOTS = new ItemNormalArmor(MoreCraft.RUBY_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("ruby_boots").setRegistryName("ruby_boots");
    public static final Item RUBY_PICKAXE = new ItemNormalPickaxe(MoreCraft.RUBY_T).setUnlocalizedName("ruby_pickaxe").setRegistryName("ruby_pickaxe");
    public static final Item RUBY_AXE = new ItemNormalAxe(MoreCraft.RUBY_T, 9, 0.9F).setUnlocalizedName("ruby_axe").setRegistryName("ruby_axe");
    public static final Item RUBY_SHOVEL = new ItemNormalSpade(MoreCraft.RUBY_T).setUnlocalizedName("ruby_shovel").setRegistryName("ruby_shovel");
    public static final Item RUBY_HOE = new ItemNormalHoe(MoreCraft.RUBY_T).setUnlocalizedName("ruby_hoe").setRegistryName("ruby_hoe");
    public static final Item RUBY_SWORD = new ItemNormalSword(MoreCraft.RUBY_T).setUnlocalizedName("ruby_sword").setRegistryName("ruby_sword");
    
    public static final Item BLAZE_HELMET = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("blaze_helmet").setRegistryName("blaze_helmet");
    public static final Item BLAZE_CHESTPLATE = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("blaze_chestplate").setRegistryName("blaze_chestplate");
    public static final Item BLAZE_LEGGINGS = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("blaze_leggings").setRegistryName("blaze_leggings");
    public static final Item BLAZE_BOOTS = new ItemBlazeArmor(MoreCraft.BLAZE_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("blaze_boots").setRegistryName("blaze_boots");
    public static final Item BLAZE_PICKAXE = new ItemNormalPickaxe(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_pickaxe").setRegistryName("blaze_pickaxe");
    public static final Item BLAZE_AXE = new ItemNormalAxe(MoreCraft.BLAZE_T, 9, 0.9F).setUnlocalizedName("blaze_axe").setRegistryName("blaze_axe");
    public static final Item BLAZE_SHOVEL = new ItemNormalSpade(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_shovel").setRegistryName("blaze_shovel");
    public static final Item BLAZE_HOE = new ItemNormalHoe(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_hoe").setRegistryName("blaze_hoe");
    public static final Item BLAZE_SWORD = new ItemNormalSword(MoreCraft.BLAZE_T).setUnlocalizedName("blaze_sword").setRegistryName("blaze_sword");
    
    public static final Item ENDER_HELMET = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("ender_helmet").setRegistryName("ender_helmet");
    public static final Item ENDER_CHESTPLATE = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("ender_chestplate").setRegistryName("ender_chestplate");
    public static final Item ENDER_LEGGINGS = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("ender_leggings").setRegistryName("ender_leggings");
    public static final Item ENDER_BOOTS = new ItemNormalArmor(MoreCraft.ENDER_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("ender_boots").setRegistryName("ender_boots");
    public static final Item ENDER_PICKAXE = new ItemNormalPickaxe(MoreCraft.ENDER_T).setUnlocalizedName("ender_pickaxe").setRegistryName("ender_pickaxe");
    public static final Item ENDER_AXE = new ItemNormalAxe(MoreCraft.ENDER_T, 10, 0.9F).setUnlocalizedName("ender_axe").setRegistryName("ender_axe");
    public static final Item ENDER_SHOVEL = new ItemNormalSpade(MoreCraft.ENDER_T).setUnlocalizedName("ender_shovel").setRegistryName("ender_shovel");
    public static final Item ENDER_HOE = new ItemNormalHoe(MoreCraft.ENDER_T).setUnlocalizedName("ender_hoe").setRegistryName("ender_hoe");
    public static final Item ENDER_SWORD = new ItemNormalSword(MoreCraft.ENDER_T).setUnlocalizedName("ender_sword").setRegistryName("ender_sword");
    
    public static final Item ENDSTONE_PICKAXE = new ItemNormalPickaxe(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_pickaxe").setRegistryName("endstone_pickaxe");
    public static final Item ENDSTONE_AXE = new ItemNormalAxe(MoreCraft.ENDSTONE_T, 9, 0.8F).setUnlocalizedName("endstone_axe").setRegistryName("endstone_axe");
    public static final Item ENDSTONE_SHOVEL = new ItemNormalSpade(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_shovel").setRegistryName("endstone_shovel");
    public static final Item ENDSTONE_HOE = new ItemNormalHoe(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_hoe").setRegistryName("endstone_hoe");
    public static final Item ENDSTONE_SWORD = new ItemNormalSword(MoreCraft.ENDSTONE_T).setUnlocalizedName("endstone_sword").setRegistryName("endstone_sword");
    
    public static final Item NETHERRACK_PICKAXE = new ItemNormalPickaxe(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_pickaxe").setRegistryName("netherrack_pickaxe");
    public static final Item NETHERRACK_AXE = new ItemNormalAxe(MoreCraft.NETHERRACK_T, 9, 0.8F).setUnlocalizedName("netherrack_axe").setRegistryName("netherrack_axe");
    public static final Item NETHERRACK_SHOVEL = new ItemNormalSpade(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_shovel").setRegistryName("netherrack_shovel");
    public static final Item NETHERRACK_HOE = new ItemNormalHoe(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_hoe").setRegistryName("netherrack_hoe");
    public static final Item NETHERRACK_SWORD = new ItemNormalSword(MoreCraft.NETHERRACK_T).setUnlocalizedName("netherrack_sword").setRegistryName("netherrack_sword");

    public static final Item BONELORD_HELMET = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bonelord_helmet").setRegistryName("bonelord_helmet");
    public static final Item BONELORD_CHESTPLATE = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bonelord_chestplate").setRegistryName("bonelord_chestplate");
    public static final Item BONELORD_LEGGINGS = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bonelord_leggings").setRegistryName("bonelord_leggings");
    public static final Item BONELORD_BOOTS = new ItemBonelordArmor(MoreCraft.BONELORD_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bonelord_boots").setRegistryName("bonelord_boots");
    
    public static final Item ENDERDRAGON_HELMET = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("enderdragon_helmet").setRegistryName("enderdragon_helmet");
    public static final Item ENDERDRAGON_CHESTPLATE = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("enderdragon_chestplate").setRegistryName("enderdragon_chestplate");
    public static final Item ENDERDRAGON_LEGGINGS = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("enderdragon_leggings").setRegistryName("enderdragon_leggings");
    public static final Item ENDERDRAGON_BOOTS = new ItemEnderdragonArmor(MoreCraft.ENDERDRAGON_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("enderdragon_boots").setRegistryName("enderdragon_boots");
    
    public static final Item BEDROCK_HELMET = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("bedrock_helmet").setRegistryName("bedrock_helmet");
    public static final Item BEDROCK_CHESTPLATE = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("bedrock_chestplate").setRegistryName("bedrock_chestplate");
    public static final Item BEDROCK_LEGGINGS = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("bedrock_leggings").setRegistryName("bedrock_leggings");
    public static final Item BEDROCK_BOOTS = new ItemNormalArmor(MoreCraft.BEDROCK_A, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bedrock_boots").setRegistryName("bedrock_boots");  
    public static final Item BEDROCK_PICKAXE = new ItemNormalPickaxe(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_pickaxe").setRegistryName("bedrock_pickaxe");
    public static final Item BEDROCK_AXE = new ItemNormalAxe(MoreCraft.BEDROCK_T, 11, 1.0F).setUnlocalizedName("bedrock_axe").setRegistryName("bedrock_axe");
    public static final Item BEDROCK_SHOVEL = new ItemNormalSpade(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_shovel").setRegistryName("bedrock_shovel");
    public static final Item BEDROCK_HOE = new ItemNormalHoe(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_hoe").setRegistryName("bedrock_hoe");
    public static final Item BEDROCK_SWORD = new ItemNormalSword(MoreCraft.BEDROCK_T).setUnlocalizedName("bedrock_sword").setRegistryName("bedrock_sword");
    
    public static void registerItems() {
    	GameRegistry.register(COOKED_FLESH);
    	GameRegistry.register(SPIDER_RAW);
    	GameRegistry.register(SPIDER_COOKED);
    	GameRegistry.register(APPLE_PIE);
    	GameRegistry.register(CAKE_SLICE);
    	GameRegistry.register(SQUID_RAW);
    	GameRegistry.register(SQUID_COOKED);
    	GameRegistry.register(EGG_COOKED);
    	GameRegistry.register(GUARDIAN_MEAT_RAW);
    	GameRegistry.register(GUARDIAN_MEAT_COOKED);
    	GameRegistry.register(NETHER_APPLE);

    	GameRegistry.register(RUBY);
    	GameRegistry.register(WITHER_BONE);
    	GameRegistry.register(ENDERDRAGON_SCALES);

    	GameRegistry.register(NETHERWOOD_BOAT);
    	
    	GameRegistry.register(NETHERBRICK_DOOR);
    	GameRegistry.register(NETHERWOOD_DOOR);
    	GameRegistry.register(GLASS_DOOR);
    	GameRegistry.register(BONE_DOOR);

    	GameRegistry.register(SLIME_HELMET);
    	GameRegistry.register(SLIME_CHESTPLATE);
    	GameRegistry.register(SLIME_LEGGINGS);
    	GameRegistry.register(SLIME_BOOTS);
    	
    	GameRegistry.register(FLESH_HELMET);
    	GameRegistry.register(FLESH_CHESTPLATE);
    	GameRegistry.register(FLESH_LEGGINGS);
    	GameRegistry.register(FLESH_BOOTS);

    	GameRegistry.register(SPIDERSILK_HELMET);
    	GameRegistry.register(SPIDERSILK_CHESTPLATE);
    	GameRegistry.register(SPIDERSILK_LEGGINGS);
    	GameRegistry.register(SPIDERSILK_BOOTS);
    	
    	GameRegistry.register(OBSIDIAN_HELMET);
    	GameRegistry.register(OBSIDIAN_CHESTPLATE);
    	GameRegistry.register(OBSIDIAN_LEGGINGS);
    	GameRegistry.register(OBSIDIAN_BOOTS);
    	GameRegistry.register(OBSIDIAN_PICKAXE);
    	GameRegistry.register(OBSIDIAN_AXE);
    	GameRegistry.register(OBSIDIAN_SHOVEL);
    	GameRegistry.register(OBSIDIAN_HOE);
    	GameRegistry.register(OBSIDIAN_SWORD);

    	GameRegistry.register(BONE_HELMET);
    	GameRegistry.register(BONE_CHESTPLATE);
    	GameRegistry.register(BONE_LEGGINGS);
    	GameRegistry.register(BONE_BOOTS);
    	GameRegistry.register(BONE_PICKAXE);
    	GameRegistry.register(BONE_AXE);
    	GameRegistry.register(BONE_SHOVEL);
    	GameRegistry.register(BONE_HOE);
    	GameRegistry.register(BONE_SWORD);

    	GameRegistry.register(WITHERBONE_HELMET);
    	GameRegistry.register(WITHERBONE_CHESTPLATE);
    	GameRegistry.register(WITHERBONE_LEGGINGS);
    	GameRegistry.register(WITHERBONE_BOOTS);
    	GameRegistry.register(WITHERBONE_PICKAXE);
    	GameRegistry.register(WITHERBONE_AXE);
    	GameRegistry.register(WITHERBONE_SHOVEL);
    	GameRegistry.register(WITHERBONE_HOE);
    	GameRegistry.register(WITHERBONE_SWORD);

    	GameRegistry.register(EMERALD_HELMET);
    	GameRegistry.register(EMERALD_CHESTPLATE);
    	GameRegistry.register(EMERALD_LEGGINGS);
    	GameRegistry.register(EMERALD_BOOTS);
    	GameRegistry.register(EMERALD_PICKAXE);
    	GameRegistry.register(EMERALD_AXE);
    	GameRegistry.register(EMERALD_SHOVEL);
    	GameRegistry.register(EMERALD_HOE);
    	GameRegistry.register(EMERALD_SWORD);

    	GameRegistry.register(RUBY_HELMET);
    	GameRegistry.register(RUBY_CHESTPLATE);
    	GameRegistry.register(RUBY_LEGGINGS);
    	GameRegistry.register(RUBY_BOOTS);
    	GameRegistry.register(RUBY_PICKAXE);
    	GameRegistry.register(RUBY_AXE);
    	GameRegistry.register(RUBY_SHOVEL);
    	GameRegistry.register(RUBY_HOE);
    	GameRegistry.register(RUBY_SWORD);

    	GameRegistry.register(BLAZE_HELMET);
    	GameRegistry.register(BLAZE_CHESTPLATE);
    	GameRegistry.register(BLAZE_LEGGINGS);
    	GameRegistry.register(BLAZE_BOOTS);
    	GameRegistry.register(BLAZE_PICKAXE);
    	GameRegistry.register(BLAZE_AXE);
    	GameRegistry.register(BLAZE_SHOVEL);
    	GameRegistry.register(BLAZE_HOE);
    	GameRegistry.register(BLAZE_SWORD);

    	GameRegistry.register(ENDER_HELMET);
    	GameRegistry.register(ENDER_CHESTPLATE);
    	GameRegistry.register(ENDER_LEGGINGS);
    	GameRegistry.register(ENDER_BOOTS);
    	GameRegistry.register(ENDER_PICKAXE);
    	GameRegistry.register(ENDER_AXE);
    	GameRegistry.register(ENDER_SHOVEL);
    	GameRegistry.register(ENDER_HOE);
    	GameRegistry.register(ENDER_SWORD);

    	GameRegistry.register(ENDSTONE_PICKAXE);
    	GameRegistry.register(ENDSTONE_AXE);
    	GameRegistry.register(ENDSTONE_SHOVEL);
    	GameRegistry.register(ENDSTONE_HOE);
    	GameRegistry.register(ENDSTONE_SWORD);
    	
    	GameRegistry.register(NETHERRACK_PICKAXE);
    	GameRegistry.register(NETHERRACK_AXE);
    	GameRegistry.register(NETHERRACK_SHOVEL);
    	GameRegistry.register(NETHERRACK_HOE);
    	GameRegistry.register(NETHERRACK_SWORD);

    	GameRegistry.register(BONELORD_HELMET);
    	GameRegistry.register(BONELORD_CHESTPLATE);
    	GameRegistry.register(BONELORD_LEGGINGS);
    	GameRegistry.register(BONELORD_BOOTS);
    	
    	GameRegistry.register(ENDERDRAGON_HELMET);
    	GameRegistry.register(ENDERDRAGON_CHESTPLATE);
    	GameRegistry.register(ENDERDRAGON_LEGGINGS);
    	GameRegistry.register(ENDERDRAGON_BOOTS);

    	GameRegistry.register(BEDROCK_HELMET);
    	GameRegistry.register(BEDROCK_CHESTPLATE);
    	GameRegistry.register(BEDROCK_LEGGINGS);
    	GameRegistry.register(BEDROCK_BOOTS);
    	GameRegistry.register(BEDROCK_PICKAXE);
    	GameRegistry.register(BEDROCK_AXE);
    	GameRegistry.register(BEDROCK_SHOVEL);
    	GameRegistry.register(BEDROCK_HOE);
    	GameRegistry.register(BEDROCK_SWORD);
    }
}
