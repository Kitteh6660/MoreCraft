package kittehmod.morecraft.init.addons;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.item.ModFDFoods;
import kittehmod.morecraft.item.ModKnifeItem;
import kittehmod.morecraft.item.ModTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ModFDRegistries
{
	public static final ResourceLocation NETHERWOOD_CABINET_LOCATION = new ResourceLocation(MoreCraft.MODID, "netherwood_cabinet");
	
	public static final ResourceLocation COPPER_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "copper_knife");
    public static final ResourceLocation BONE_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "bone_knife");
    public static final ResourceLocation EMERALD_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "emerald_knife");
    public static final ResourceLocation RUBY_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "ruby_knife");
    public static final ResourceLocation OBSIDIAN_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "obsidian_knife");
    public static final ResourceLocation BLAZE_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "blaze_knife");
	    
    public static final ResourceLocation RAW_CHEVON_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "raw_chevon_chops");
    public static final ResourceLocation COOKED_CHEVON_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "cooked_chevon_chops");
    public static final ResourceLocation RAW_MINCED_SPIDER_LOCATION = new ResourceLocation(MoreCraft.MODID, "raw_minced_spider");
    public static final ResourceLocation COOKED_MINCED_SPIDER_LOCATION = new ResourceLocation(MoreCraft.MODID, "cooked_minced_spider");
    public static final ResourceLocation RAW_GUARDIAN_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "raw_guardian_cuts");
    public static final ResourceLocation COOKED_GUARDIAN_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "cooked_guardian_cuts");
    public static final ResourceLocation RAW_DRAGON_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "raw_dragon_chops");
    public static final ResourceLocation COOKED_DRAGON_CHOPS_LOCATION = new ResourceLocation(MoreCraft.MODID, "cooked_dragon_chops");
    public static final ResourceLocation DRAGON_CASSEROLE_LOCATION = new ResourceLocation(MoreCraft.MODID, "dragon_casserole");
    
    @SubscribeEvent
    public void register(RegisterEvent event) {
    	event.register(ForgeRegistries.Keys.BLOCKS, helper -> { 
    		helper.register(NETHERWOOD_CABINET_LOCATION, new CabinetBlock(Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    	});
    	event.register(ForgeRegistries.Keys.ITEMS, helper -> { 
    		helper.register(NETHERWOOD_CABINET_LOCATION, new BlockItem(ForgeRegistries.BLOCKS.getValue(NETHERWOOD_CABINET_LOCATION), new Item.Properties()));
    		helper.register(COPPER_KNIFE_LOCATION, new ModKnifeItem(ModTier.COPPER, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(BONE_KNIFE_LOCATION, new ModKnifeItem(ModTier.BONE, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(EMERALD_KNIFE_LOCATION, new ModKnifeItem(ModTier.EMERALD, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(RUBY_KNIFE_LOCATION, new ModKnifeItem(ModTier.RUBY, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(OBSIDIAN_KNIFE_LOCATION, new ModKnifeItem(ModTier.OBSIDIAN, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(BLAZE_KNIFE_LOCATION, new ModKnifeItem(ModTier.BLAZE, 0, -2, new Item.Properties().stacksTo(1)));
    		helper.register(RAW_CHEVON_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.RAW_CHEVON_CHOPS)));
    		helper.register(COOKED_CHEVON_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.COOKED_CHEVON_CHOPS)));
    		helper.register(RAW_MINCED_SPIDER_LOCATION, new Item(new Item.Properties().food(ModFDFoods.RAW_MINCED_SPIDER)));
    		helper.register(COOKED_MINCED_SPIDER_LOCATION, new Item(new Item.Properties().food(ModFDFoods.COOKED_MINCED_SPIDER)));
    		helper.register(RAW_GUARDIAN_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.RAW_GUARDIAN_CUTS)));
    		helper.register(COOKED_GUARDIAN_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.COOKED_GUARDIAN_CUTS)));
    		helper.register(RAW_DRAGON_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.RAW_DRAGON_CHOPS)));
    		helper.register(COOKED_DRAGON_CHOPS_LOCATION, new Item(new Item.Properties().food(ModFDFoods.COOKED_DRAGON_CHOPS)));
    		helper.register(DRAGON_CASSEROLE_LOCATION, new Item(new Item.Properties().food(ModFDFoods.DRAGON_CASSEROLE).rarity(Rarity.UNCOMMON)));
    	});
    }
    
    @SubscribeEvent
    public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
    	MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
	    	map.putAfter(ModItems.WARPED_CABINET.get().getDefaultInstance(), ForgeRegistries.ITEMS.getValue(NETHERWOOD_CABINET_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putBefore(ModItems.IRON_KNIFE.get().getDefaultInstance(), ForgeRegistries.ITEMS.getValue(COPPER_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putAfter(ModItems.GOLDEN_KNIFE.get().getDefaultInstance(), ForgeRegistries.ITEMS.getValue(BONE_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putAfter(ForgeRegistries.ITEMS.getValue(BONE_KNIFE_LOCATION).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(EMERALD_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putAfter(ForgeRegistries.ITEMS.getValue(EMERALD_KNIFE_LOCATION).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(RUBY_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putAfter(ForgeRegistries.ITEMS.getValue(RUBY_KNIFE_LOCATION).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(OBSIDIAN_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.putAfter(ForgeRegistries.ITEMS.getValue(OBSIDIAN_KNIFE_LOCATION).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(BLAZE_KNIFE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(RAW_CHEVON_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(COOKED_CHEVON_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(RAW_MINCED_SPIDER_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(COOKED_MINCED_SPIDER_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(RAW_GUARDIAN_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(COOKED_GUARDIAN_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(RAW_DRAGON_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(COOKED_DRAGON_CHOPS_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
	    	map.put(ForgeRegistries.ITEMS.getValue(DRAGON_CASSEROLE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    	}
    }
}
