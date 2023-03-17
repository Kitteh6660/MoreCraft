package kittehmod.morecraft.init.addons;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.init.ModBlocks;
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
import net.minecraftforge.registries.RegistryObject;
import twilightforest.block.BanisterBlock;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogHorizontal;
import twilightforest.block.HollowLogVertical;
import twilightforest.item.HollowLogItem;

public class ModTFRegistries
{
	private final RegistryObject<HollowLogHorizontal> HOLLOW_NETHERWOOD_LOG_HORIZONTAL = ModBlocks.BLOCKS.register("hollow_netherwood_log_horizontal", () -> new HollowLogHorizontal(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
	private final RegistryObject<HollowLogVertical> HOLLOW_NETHERWOOD_LOG_VERTICAL = ModBlocks.BLOCKS.register("hollow_netherwood_log_vertical", () -> new HollowLogVertical(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD), this.HOLLOW_NETHERWOOD_LOG_CLIMBABLE));
	private final RegistryObject<HollowLogClimbable> HOLLOW_NETHERWOOD_LOG_CLIMBABLE = ModBlocks.BLOCKS.register("hollow_netherwood_log_climbable", () -> new HollowLogClimbable(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD), this.HOLLOW_NETHERWOOD_LOG_VERTICAL));
	
	public static final ResourceLocation NETHERWOOD_HOLLOW_LOG_LOCATION = new ResourceLocation(MoreCraft.MODID, "hollow_netherwood_log");
	public static final ResourceLocation NETHERWOOD_BANISTER_LOCATION = new ResourceLocation(MoreCraft.MODID, "netherwood_banister");
		
    @SubscribeEvent
    public void register(RegisterEvent event) {
    	event.register(ForgeRegistries.Keys.BLOCKS, helper -> {
    		helper.register(NETHERWOOD_BANISTER_LOCATION, new BanisterBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 4.0F).sound(SoundType.WOOD)));
    	} );
    	event.register(ForgeRegistries.Keys.ITEMS, helper -> {
    		helper.register(NETHERWOOD_HOLLOW_LOG_LOCATION, new HollowLogItem(HOLLOW_NETHERWOOD_LOG_HORIZONTAL, HOLLOW_NETHERWOOD_LOG_VERTICAL, HOLLOW_NETHERWOOD_LOG_CLIMBABLE, new Item.Properties().tab(ModItems.conditionallyAddTab("twilightforest", ModItems.getTabWithMatchingName("twilightforest", CreativeModeTab.TAB_BUILDING_BLOCKS)))));
    		helper.register(NETHERWOOD_BANISTER_LOCATION, new BlockItem(ForgeRegistries.BLOCKS.getValue(NETHERWOOD_BANISTER_LOCATION), new Item.Properties().tab(ModItems.conditionallyAddTab("twilightforest", ModItems.getTabWithMatchingName("twilightforest", CreativeModeTab.TAB_DECORATIONS)))));
    	} );
    }
}
