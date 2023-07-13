package kittehmod.morecraft.init.addons;

import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;

import kittehmod.morecraft.ModCompats;
import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class ModBlueprintRegistries
{
	public static final ResourceLocation NETHERWOOD_BEEHIVE_LOCATION = new ResourceLocation(MoreCraft.MODID, "netherwood_beehive");
	public static final ResourceLocation WARPED_BEEHIVE_LOCATION = new ResourceLocation("woodworks", "warped_beehive"); // For reference
	
    @SubscribeEvent
    public void register(RegisterEvent event) {
    	event.register(ForgeRegistries.Keys.BLOCKS, helper -> { 
    		helper.register(NETHERWOOD_BEEHIVE_LOCATION, new BlueprintBeehiveBlock(Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    	} );
    	event.register(ForgeRegistries.Keys.ITEMS, helper -> { 
    		helper.register(NETHERWOOD_BEEHIVE_LOCATION, new BlockItem(ForgeRegistries.BLOCKS.getValue(NETHERWOOD_BEEHIVE_LOCATION), new Item.Properties()));
    	} );
    }
    
    @SubscribeEvent
    public void assignItemsToTabs(BuildCreativeModeTabContentsEvent event) {
    	MutableHashedLinkedMap<ItemStack, TabVisibility> map = event.getEntries();
    	if (ModCompats.WOODWORKS_INSTALLED) {
    		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
    			map.putAfter(ForgeRegistries.ITEMS.getValue(WARPED_BEEHIVE_LOCATION).getDefaultInstance(), ForgeRegistries.ITEMS.getValue(NETHERWOOD_BEEHIVE_LOCATION).getDefaultInstance(), TabVisibility.PARENT_AND_SEARCH_TABS);
    		}
    	}
    	if (ModCompats.BOATLOAD_INSTALLED) {
    		// If one day, then possibly add Crimson, Warped, and Netherwood long boats?
    	}
    }
}
