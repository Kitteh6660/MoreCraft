package kittehmod.bettercraft;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
//import net.minecraft.src.ModLoader; --Deprecated.
//import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = "MoreCraft", modid = MoreCraft.MODID, version = MoreCraft.VERSION, guiFactory = "kittehmod.bettercraft.ConfigurationGuiFactory"/*, dependencies = "after:malisisdoors"*/)
public class MoreCraft 
{
    public static final String MODID = "bettercraft";
    public static final String VERSION = "2.8";
	
	// The instance of your mod that Forge uses.
	@Instance("bettercraft")
	public static MoreCraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "kittehmod.bettercraft.client.ClientProxy", serverSide = "kittehmod.bettercraft.CommonProxy")
	public static CommonProxy proxy;
	
	public static Configuration config;
	public static Boolean hardcoreRecipes;
	public static Boolean sillyRecipes; //Enables silly recipes.
	public static Boolean salvageRecipes;
	public static Boolean overrideMobDrops; //Overrides mob drops.
	public static Boolean endermanBlockDrops; //Enables Enderman dropping carried block on death.
	public static Boolean mobHeadDrops; //Enables mob head drops.
	public static Integer generateNetherwoodTrees; //Enables Netherwood trees generation.
	
	public static EnumRarity LEGENDARY = EnumHelper.addRarity("Legendary", EnumChatFormatting.GOLD, "Legendary");

    public static ToolMaterial BONE_T = EnumHelper.addToolMaterial("BoneT", 1, 100, 4.0F, 1, 15);
    public static ToolMaterial WITHERBONE_T = EnumHelper.addToolMaterial("WitherBoneT", 3, 6248, 12.0F, 4, 22);
    public static ToolMaterial OBSIDIAN_T = EnumHelper.addToolMaterial("ObsidianT", 3, 16, 14.0F, 4, 15);
    public static ToolMaterial EMERALD_T = EnumHelper.addToolMaterial("EmeraldT", 3, 768, 8.0F, 3.0F, 10);
    public static ToolMaterial RUBY_T = EnumHelper.addToolMaterial("RubyT", 2, 500, 6.0F, 2, 21);
    public static ToolMaterial ENDER_T = EnumHelper.addToolMaterial("EnderT", 2, 250, 6.0F, 3, 15);
    public static ToolMaterial BLAZE_T = EnumHelper.addToolMaterial("BlazeT", 2, 100, 7.0F, 2, 15);
    public static ToolMaterial NETHERRACK_T = EnumHelper.addToolMaterial("NetherrackT", 1, 59, 3.5F, 1, 8);
    public static ToolMaterial ENDSTONE_T = EnumHelper.addToolMaterial("EndstoneT", 1, 188, 4.0F, 1, 5);
    public static ToolMaterial BEDROCK_T = EnumHelper.addToolMaterial("BedrockT", 3, -1, 20.0F, 5, 30);
    
    public static ArmorMaterial SLIME_A = EnumHelper.addArmorMaterial("SlimeA", "slime", 8, new int[] { 2, 3, 2, 2 }, 20);
    public static ArmorMaterial FLESH_A = EnumHelper.addArmorMaterial("FleshA", "flesh", 4, new int[] { 1, 3, 2, 1 }, 17);
    public static ArmorMaterial WEB_A = EnumHelper.addArmorMaterial("WebA", "spidersilk", 24, new int[] { 2, 3, 3, 2 }, 15);
    public static ArmorMaterial BONE_A = EnumHelper.addArmorMaterial("BoneA", "bone", 12, new int[] { 2, 5, 3, 2 }, 15);
    public static ArmorMaterial WITHERBONE_A = EnumHelper.addArmorMaterial("WitherBoneA", "witherbone", 132, new int[] { 3, 8, 6, 3 }, 16);
    public static ArmorMaterial OBSIDIAN_A = EnumHelper.addArmorMaterial("ObsidianA", "obsidian", 3, new int[] { 4, 8, 6, 4 }, 28);
    public static ArmorMaterial EMERALD_A = EnumHelper.addArmorMaterial("EmeraldA", "emerald", 28, new int[] { 3, 7, 5, 3 }, 18);
    public static ArmorMaterial RUBY_A = EnumHelper.addArmorMaterial("RubyA", "ruby", 20, new int[] { 2, 6, 5, 2 }, 25);
    public static ArmorMaterial ENDER_A = EnumHelper.addArmorMaterial("EnderA", "ender", 15, new int[] { 3, 6, 5, 3 }, 15);
    public static ArmorMaterial BLAZE_A = EnumHelper.addArmorMaterial("BlazeA", "blaze", 10, new int[] { 3, 5, 5, 3 }, 10);
    public static ArmorMaterial GUARDIAN_A = EnumHelper.addArmorMaterial("GuardianA", "guardian", 18, new int[] { 3, 5, 4, 3 }, 20);
    public static ArmorMaterial BONELORD_A = EnumHelper.addArmorMaterial("BoneLordA", "bonelord", 20, new int[] { 3, 6, 6, 3 }, 25);
    public static ArmorMaterial ENDERDRAGON_A = EnumHelper.addArmorMaterial("DragonScaleA", "dragonscale", 99999999, new int[] { 4, 8, 6, 4 }, 30);
    public static ArmorMaterial BEDROCK_A = EnumHelper.addArmorMaterial("BedrockA", "bedrock", 99999999, new int[] { 5, 8, 6, 5 }, 30);

	@EventHandler
	// used in 1.6.2
	// @PreInit // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		//------
		//Recipes
		hardcoreRecipes = config.getBoolean("hardcoreRecipes", config.CATEGORY_GENERAL, false, "Disables certain recipes and make some recipes harder. \n§4Restart required!§r");
		sillyRecipes = config.getBoolean("sillyRecipes", config.CATEGORY_GENERAL, false, "Enable or disable silly recipes such as crafting a bedrock using a bed and a stone. \n§4Restart required!§r");
		salvageRecipes = config.getBoolean("salvageRecipes", config.CATEGORY_GENERAL, true, "Enable or disable recipes involving dismantling items to get resources back. It also includes converting stairs and slabs back to blocks. \n§4Restart required!§r");
		//Mob Drops
		overrideMobDrops = config.getBoolean("overrideMobDrops", config.CATEGORY_GENERAL, true, "Override drops of sheeps, squids, and spiders to drop the new items? You still can get the vanilla resources. \n§2Doesn't require restart.§r");
		endermanBlockDrops = config.getBoolean("endermanBlockDrops", config.CATEGORY_GENERAL, true, "Allow Endermen to drop carried blocks on death? \n§2Doesn't require restart.§r");
		mobHeadDrops = config.getBoolean("mobHeadDrops", config.CATEGORY_GENERAL, true, "Should mobs rarely drop head when killed? \n(Note: Applies to Creepers, Zombies, and Skeletons) \n§2Doesn't require restart.§r");
		//Generation
		generateNetherwoodTrees = config.getInt("generateNetherwoodTrees", config.CATEGORY_GENERAL, 16, 0, 32, "The amount of Netherwood trees to attempt to generate per chunk. This only affects new chunks. \n§2Doesn't require restart.§r");
		//------
		config.save();
		
		MoreCraftBlocks.registerBlocks();
		MoreCraftItems.registerItems();
	}

	@EventHandler
	// used in 1.6.2
	// @Init // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityNetherwoodChest.class, "tileentitynetherchest");
        GameRegistry.registerWorldGenerator(new MoreCraftGenerator(), 1);
        proxy.registerRenderers();
        
        MoreCraftRecipes.registerRecipes();
		MinecraftForge.EVENT_BUS.register(new MobDrop());
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		FMLCommonHandler.instance().bus().register(new ConfigurationEvents());
    }
	
	
	
    public static void oreRegistration()
    {
        //|--| Register blocks to Ore Dictionary |--|\\
	
		//ruby ores and blocks
		OreDictionary.registerOre("ruby_ore", MoreCraftBlocks.ruby_ore);
		OreDictionary.registerOre("ruby_block", MoreCraftBlocks.ruby_block);
		
		//Netherwood
		OreDictionary.registerOre("netherwood_log", MoreCraftBlocks.netherwood_log);
		OreDictionary.registerOre("netherwood_planks", MoreCraftBlocks.netherwood_planks);
		OreDictionary.registerOre("netherwood_leaves", MoreCraftBlocks.netherwood_leaves);
		OreDictionary.registerOre("netherwood_sapling", MoreCraftBlocks.netherwood_sapling);
		OreDictionary.registerOre("netherwood_chest", MoreCraftBlocks.netherwood_chest);
		
		//Ender Bricks block
		OreDictionary.registerOre("enderbrick_block", MoreCraftBlocks.enderbrick_block);
		
		//Blocks made from vanilla resources.
		OreDictionary.registerOre("flesh_block", MoreCraftBlocks.flesh_block);
		OreDictionary.registerOre("bone_block", MoreCraftBlocks.bone_block);
		OreDictionary.registerOre("gunpowder_block", MoreCraftBlocks.gunpowder_block);
		OreDictionary.registerOre("blaze_block", MoreCraftBlocks.blaze_block);
		OreDictionary.registerOre("ender_block", MoreCraftBlocks.ender_block);
		
		//|--| Register items to Ore Dictionary |--|\\
        OreDictionary.registerOre("ruby_gem", MoreCraftItems.ruby);
        OreDictionary.registerOre("wither_bone", MoreCraftItems.wither_bone);
        OreDictionary.registerOre("ender_brick", MoreCraftItems.ender_brick);
        
    }

    public static void syncConfig() {
    	System.out.println("Syncing...");
    	//Recipes
        hardcoreRecipes = config.getBoolean("hardcoreRecipes", Configuration.CATEGORY_GENERAL, hardcoreRecipes, "");
        sillyRecipes = config.getBoolean("sillyRecipes", Configuration.CATEGORY_GENERAL, sillyRecipes, "");
        salvageRecipes = config.getBoolean("salvageRecipes", Configuration.CATEGORY_GENERAL, salvageRecipes, "");
        //Mob Drops
        overrideMobDrops = config.getBoolean("overrideMobDrops", Configuration.CATEGORY_GENERAL, overrideMobDrops, "");
        endermanBlockDrops = config.getBoolean("endermanBlockDrops", Configuration.CATEGORY_GENERAL, endermanBlockDrops, "");
        mobHeadDrops = config.getBoolean("mobHeadDrops", Configuration.CATEGORY_GENERAL, mobHeadDrops, "");
        //Generation
        generateNetherwoodTrees = config.getInt("generateNetherwoodTrees", Configuration.CATEGORY_GENERAL, generateNetherwoodTrees, 0, 32, "");

        if(config.hasChanged())
            config.save();
    }
    
	@EventHandler
	// used in 1.6.2
	// @PostInit // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
	
}