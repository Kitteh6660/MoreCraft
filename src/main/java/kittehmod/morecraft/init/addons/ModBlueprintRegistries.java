package kittehmod.morecraft.init.addons;

import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.init.ModItems;
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

public class ModBlueprintRegistries
{
	public static final ResourceLocation NETHERWOOD_BEEHIVE_LOCATION = new ResourceLocation(MoreCraft.MODID, "netherwood_beehive");
	
    @SubscribeEvent
    public void register(RegisterEvent event) {
    	event.register(ForgeRegistries.Keys.BLOCKS, helper -> { 
    		helper.register(NETHERWOOD_BEEHIVE_LOCATION, new BlueprintBeehiveBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    	} );
    	event.register(ForgeRegistries.Keys.ITEMS, helper -> { 
    		helper.register(NETHERWOOD_BEEHIVE_LOCATION, new BlockItem(ForgeRegistries.BLOCKS.getValue(NETHERWOOD_BEEHIVE_LOCATION), new Item.Properties().tab(ModItems.conditionallyAddTab("woodworks", CreativeModeTab.TAB_DECORATIONS))));
    	} );
    }
}
