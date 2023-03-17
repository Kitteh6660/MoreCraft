package kittehmod.morecraft.init.addons;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.init.ModItems;
import kittehmod.morecraft.item.ModKnifeItem;
import kittehmod.morecraft.item.ModTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class ModFDRegistries
{
	public static final ResourceLocation NETHERWOOD_CABINET_LOCATION = new ResourceLocation(MoreCraft.MODID, "netherwood_cabinet");
	
	public static final ResourceLocation COPPER_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "copper_knife");
    public static final ResourceLocation BONE_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "bone_knife");
    public static final ResourceLocation EMERALD_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "emerald_knife");
    public static final ResourceLocation RUBY_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "ruby_knife");
    public static final ResourceLocation OBSIDIAN_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "obsidian_knife");
    public static final ResourceLocation BLAZE_KNIFE_LOCATION = new ResourceLocation(MoreCraft.MODID, "blaze_knife");
	    
    @SubscribeEvent
    public void register(RegisterEvent event) {
    	event.register(ForgeRegistries.Keys.BLOCKS, helper -> { 
    		helper.register(NETHERWOOD_CABINET_LOCATION, new CabinetBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    	});
    	event.register(ForgeRegistries.Keys.ITEMS, helper -> { 
    		helper.register(NETHERWOOD_CABINET_LOCATION, new BlockItem(ForgeRegistries.BLOCKS.getValue(NETHERWOOD_CABINET_LOCATION), new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_DECORATIONS)))));
    		helper.register(COPPER_KNIFE_LOCATION, new ModKnifeItem(ModTier.COPPER, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    		helper.register(BONE_KNIFE_LOCATION, new ModKnifeItem(ModTier.BONE, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    		helper.register(EMERALD_KNIFE_LOCATION, new ModKnifeItem(ModTier.EMERALD, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    		helper.register(RUBY_KNIFE_LOCATION, new ModKnifeItem(ModTier.RUBY, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    		helper.register(OBSIDIAN_KNIFE_LOCATION, new ModKnifeItem(ModTier.OBSIDIAN, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    		helper.register(BLAZE_KNIFE_LOCATION, new ModKnifeItem(ModTier.BLAZE, 0, -2, new Item.Properties().tab(ModItems.conditionallyAddTab("farmersdelight", ModItems.getTabWithMatchingName("farmersdelight", CreativeModeTab.TAB_COMBAT))).stacksTo(1)));
    	});
    }
}
