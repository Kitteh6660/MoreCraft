package kittehmod.bettercraft;

import kittehmod.bettercraft.client.RenderNetherwoodBoat;
import kittehmod.bettercraft.entity.EntityNetherwoodBoat;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
//import net.minecraft.src.ModLoader; --Deprecated.
//import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = "MoreCraft", modid = MoreCraft.MODID, version = MoreCraft.VERSION, guiFactory = "kittehmod.bettercraft.ConfigurationGuiFactory"/*, dependencies = "after:malisisdoors"*/)
public class MoreCraft 
{
    public static final String MODID = "bettercraft";
    public static final String VERSION = "2.9.2";
	
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
	public static Boolean mobHeadDrops; //Enables mob head drops.
	public static Integer generateNetherwoodTrees; //Enables Netherwood trees generation.
	
	public static EnumRarity LEGENDARY = EnumHelper.addRarity("Legendary", TextFormatting.GOLD, "Legendary");
	
	//public static BlockChest.Type NETHERWOOD_CHEST = EnumHelper.addEnum(BlockChest.Type.class, "NETHER", "nether", 2);
	
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
    
    public static ArmorMaterial SLIME_A = EnumHelper.addArmorMaterial("SlimeA", "bettercraft:slime", 8, new int[] { 2, 3, 2, 2 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static ArmorMaterial FLESH_A = EnumHelper.addArmorMaterial("FleshA", "bettercraft:flesh", 4, new int[] { 1, 3, 2, 1 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static ArmorMaterial WEB_A = EnumHelper.addArmorMaterial("WebA", "bettercraft:spidersilk", 24, new int[] { 2, 3, 3, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static ArmorMaterial BONE_A = EnumHelper.addArmorMaterial("BoneA", "bettercraft:bone", 12, new int[] { 2, 5, 3, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static ArmorMaterial WITHERBONE_A = EnumHelper.addArmorMaterial("WitherBoneA", "bettercraft:witherbone", 132, new int[] { 3, 8, 6, 3 }, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
    public static ArmorMaterial OBSIDIAN_A = EnumHelper.addArmorMaterial("ObsidianA", "bettercraft:obsidian", 3, new int[] { 4, 8, 6, 4 }, 28, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
    public static ArmorMaterial EMERALD_A = EnumHelper.addArmorMaterial("EmeraldA", "bettercraft:emerald", 28, new int[] { 3, 7, 5, 3 }, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    public static ArmorMaterial RUBY_A = EnumHelper.addArmorMaterial("RubyA", "bettercraft:ruby", 20, new int[] { 2, 6, 5, 2 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
    public static ArmorMaterial ENDER_A = EnumHelper.addArmorMaterial("EnderA", "bettercraft:ender", 15, new int[] { 3, 6, 5, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static ArmorMaterial BLAZE_A = EnumHelper.addArmorMaterial("BlazeA", "bettercraft:blaze", 10, new int[] { 3, 5, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static ArmorMaterial BONELORD_A = EnumHelper.addArmorMaterial("BoneLordA", "bettercraft:bonelord", 20, new int[] { 3, 6, 6, 3 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static ArmorMaterial ENDERDRAGON_A = EnumHelper.addArmorMaterial("DragonScaleA", "bettercraft:enderdragon", 128, new int[] { 4, 8, 6, 4 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);
    public static ArmorMaterial BEDROCK_A = EnumHelper.addArmorMaterial("BedrockA", "bettercraft:bedrock", 99999999, new int[] { 5, 8, 6, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);

	@EventHandler
	// used in 1.6.2
	// @PreInit // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		//------
		//Recipes
		hardcoreRecipes = (boolean) config.get(config.CATEGORY_GENERAL, "hardcoreRecipes", false, "Disables certain recipes and make some recipes harder. \n§4Restart required!§r").getBoolean();
		sillyRecipes = (boolean) config.get(config.CATEGORY_GENERAL, "sillyRecipes", false, "Enable or disable silly recipes such as crafting a bedrock using a bed and a stone. \n§4Restart required!§r").getBoolean();
		salvageRecipes = (boolean) config.get(config.CATEGORY_GENERAL, "salvageRecipes", true, "Enable or disable recipes involving dismantling items to get resources back. It also includes converting stairs and slabs back to blocks. \n§4Restart required!§r").getBoolean();
		
		//Mob Drops
		overrideMobDrops = (boolean) config.get(config.CATEGORY_GENERAL, "overrideMobDrops", true, "Override drops of squids and spiders to drop the new items? You still can get the vanilla resources. \n§2Doesn't require restart.§r").getBoolean();
		mobHeadDrops = (boolean) config.get(config.CATEGORY_GENERAL, "mobHeadDrops", true, "Should mobs rarely drop head when killed? \n(Note: Applies to Creepers, Zombies, Skeletons, and Enderdragons) \n§2Doesn't require restart.§r").getBoolean();
		//Generation
		generateNetherwoodTrees = (int) config.get(config.CATEGORY_GENERAL, "generateNetherwoodTrees", 16, "The amount of Netherwood trees to attempt to generate per chunk. This only affects new chunks. \n§2Doesn't require restart.§r", 0, 32).setConfigEntryClass(MoreCraft.proxy.getSliderClass()).getInt();;
		//------
		config.save();
		
		MoreCraftBlocks.registerBlocks();
		MoreCraftItems.registerItems();
		MoreCraftEntities.registerEntities();
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherwoodBoat.class, new IRenderFactory() {
			@Override public Render<? super EntityNetherwoodBoat> createRenderFor(RenderManager manager) { return new RenderNetherwoodBoat(manager); }	
		});
	}

	@EventHandler
	// used in 1.6.2
	// @Init // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
        oreRegistration();
        setRepairMaterials();
        MoreCraftRecipes.registerRecipes();
        proxy.registerRenderers();

        GameRegistry.registerWorldGenerator(new MoreCraftGenerator(), 1);		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
 		MinecraftForge.EVENT_BUS.register(new MobDrop());
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		FMLCommonHandler.instance().bus().register(new ConfigurationEvents());
		
		Blocks.MOB_SPAWNER.setCreativeTab(CreativeTabs.MISC);
		Blocks.DRAGON_EGG.setCreativeTab(CreativeTabs.DECORATIONS);
    }
	
    public static void oreRegistration()
    {
        //|--| Register blocks to Ore Dictionary |--|\\
	
		OreDictionary.registerOre("blockGlass", MoreCraftBlocks.SOUL_GLASS);
		OreDictionary.registerOre("blockGlassColorless", MoreCraftBlocks.SOUL_GLASS);
		OreDictionary.registerOre("paneGlass", MoreCraftBlocks.SOUL_GLASS_PANE);
		OreDictionary.registerOre("paneGlassColorless", MoreCraftBlocks.SOUL_GLASS_PANE);
    	
    	//Ruby ores and blocks
		OreDictionary.registerOre("oreRuby", MoreCraftBlocks.RUBY_ORE);
		OreDictionary.registerOre("blockRuby", MoreCraftBlocks.RUBY_BLOCK);
		
		//Netherwood
		OreDictionary.registerOre("treeWood", MoreCraftBlocks.NETHERWOOD_LOG);
		OreDictionary.registerOre("plankWood", MoreCraftBlocks.NETHERWOOD_PLANKS);
		OreDictionary.registerOre("stairWood", MoreCraftBlocks.NETHERWOOD_STAIRS);
		OreDictionary.registerOre("slabWood", MoreCraftBlocks.NETHERWOOD_SLAB);
		OreDictionary.registerOre("treeLeaves", MoreCraftBlocks.NETHERWOOD_LEAVES);
		OreDictionary.registerOre("treeSapling", MoreCraftBlocks.NETHERWOOD_SAPLING);
		
		//Blocks made from vanilla resources.
		OreDictionary.registerOre("blockFlesh", MoreCraftBlocks.FLESH_BLOCK);
		OreDictionary.registerOre("blockGunpowder", MoreCraftBlocks.GUNPOWDER_BLOCK);
		OreDictionary.registerOre("blockBlaze", MoreCraftBlocks.BLAZE_BLOCK);
		OreDictionary.registerOre("blockEnder", MoreCraftBlocks.ENDER_BLOCK);
		
		//|--| Register items to Ore Dictionary |--|\\
        OreDictionary.registerOre("gemRuby", MoreCraftItems.RUBY);
        OreDictionary.registerOre("boneWither", MoreCraftItems.WITHER_BONE);
        OreDictionary.registerOre("scaleEnder", MoreCraftItems.ENDERDRAGON_SCALES);
    }

    public static void setRepairMaterials()
    {
        BONE_T.setRepairItem(new ItemStack(Items.BONE));
        WITHERBONE_T.setRepairItem(new ItemStack(MoreCraftItems.WITHER_BONE));
        OBSIDIAN_T.setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN)));
        EMERALD_T.setRepairItem(new ItemStack(Items.EMERALD));
        RUBY_T.setRepairItem(new ItemStack(MoreCraftItems.RUBY));
        ENDER_T.setRepairItem(new ItemStack(Items.ENDER_PEARL));
        BLAZE_T.setRepairItem(new ItemStack(Items.BLAZE_ROD));
        NETHERRACK_T.setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.NETHERRACK)));
        ENDSTONE_T.setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.END_STONE)));
        BEDROCK_T.setRepairItem(new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK)));
        
        SLIME_A.customCraftingMaterial = Items.SLIME_BALL;
        FLESH_A.customCraftingMaterial = Items.ROTTEN_FLESH;
        WEB_A.customCraftingMaterial = Item.getItemFromBlock(Blocks.WEB);
        BONE_A.customCraftingMaterial = Items.BONE;
        WITHERBONE_A.customCraftingMaterial = MoreCraftItems.WITHER_BONE;
        OBSIDIAN_A.customCraftingMaterial = Item.getItemFromBlock(Blocks.OBSIDIAN);
        EMERALD_A.customCraftingMaterial = Items.EMERALD;
        RUBY_A.customCraftingMaterial = MoreCraftItems.RUBY;
        ENDER_A.customCraftingMaterial = Items.ENDER_PEARL;
        BLAZE_A.customCraftingMaterial = Items.BLAZE_ROD;
        BONELORD_A.customCraftingMaterial = Items.BONE;
        ENDERDRAGON_A.customCraftingMaterial = MoreCraftItems.ENDERDRAGON_SCALES;
        BEDROCK_A.customCraftingMaterial = Item.getItemFromBlock(Blocks.BEDROCK);
    }
    
    public static void syncConfig() {
    	System.out.println("Syncing...");
    	//Recipes
        hardcoreRecipes = config.getBoolean("hardcoreRecipes", Configuration.CATEGORY_GENERAL, hardcoreRecipes, "");
        sillyRecipes = config.getBoolean("sillyRecipes", Configuration.CATEGORY_GENERAL, sillyRecipes, "");
        salvageRecipes = config.getBoolean("salvageRecipes", Configuration.CATEGORY_GENERAL, salvageRecipes, "");
        //Mob Drops
        overrideMobDrops = config.getBoolean("overrideMobDrops", Configuration.CATEGORY_GENERAL, overrideMobDrops, "");
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