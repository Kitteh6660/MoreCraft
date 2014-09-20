package kittehmod.bettercraft;

import java.util.Random;

import kittehmod.bettercraft.block.BlockBedrockBricks;
import kittehmod.bettercraft.block.BlockBlazeBlock;
import kittehmod.bettercraft.block.BlockEnderBrickSlab;
import kittehmod.bettercraft.block.BlockGunpowder;
import kittehmod.bettercraft.block.BlockIronTrapdoor;
import kittehmod.bettercraft.block.BlockMoreDoors;
import kittehmod.bettercraft.block.BlockNetherBrickFenceGate;
import kittehmod.bettercraft.block.BlockNetherLeaves;
import kittehmod.bettercraft.block.BlockNetherLog;
import kittehmod.bettercraft.block.BlockNetherSapling;
import kittehmod.bettercraft.block.BlockNetherWood;
import kittehmod.bettercraft.block.BlockNetherwoodChest;
import kittehmod.bettercraft.block.BlockNetherwoodSlab;
import kittehmod.bettercraft.block.BlockNormal;
import kittehmod.bettercraft.block.BlockNormalStairs;
import kittehmod.bettercraft.block.BlockOreRuby;
import kittehmod.bettercraft.block.BlockSlimeBlock;
import kittehmod.bettercraft.block.BlockSoulGlass;
import kittehmod.bettercraft.block.BlockStorage;
import kittehmod.bettercraft.item.ItemBlazeSword;
import kittehmod.bettercraft.item.ItemBlazeSword;
import kittehmod.bettercraft.item.ItemBonelordArmor;
import kittehmod.bettercraft.item.ItemEnderdragonArmor;
import kittehmod.bettercraft.item.ItemEnderbrickSlab;
import kittehmod.bettercraft.item.ItemMoreDoors;
import kittehmod.bettercraft.item.ItemNormalArmor;
import kittehmod.bettercraft.item.ItemNormalAxe;
import kittehmod.bettercraft.item.ItemNormalHoe;
import kittehmod.bettercraft.item.ItemNormalPickaxe;
import kittehmod.bettercraft.item.ItemNormalSpade;
import kittehmod.bettercraft.item.ItemNormalSword;
import kittehmod.bettercraft.item.ItemSlimeArmor;
import kittehmod.bettercraft.item.ItemWitherSword;
import kittehmod.bettercraft.item.ItemNetherwoodSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
//import net.minecraft.src.ModLoader; --Deprecated.
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "bettercraft", name = "BetterCraft", version = "2.7a1")

public class BetterCraft 
{
    public static final String modid = "bettercraft";
    public static final String version = "2.7a1";
	
	// The instance of your mod that Forge uses.
	@Instance(value = "BetterCraft")
	public static BetterCraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "kittehmod.bettercraft.client.ClientProxy", serverSide = "kittehmod.bettercraft.CommonProxy")
	public static CommonProxy proxy;

    public static ToolMaterial BONE_T = EnumHelper.addToolMaterial("BoneT", 1, 100, 4.0F, 1, 15);
    public static ToolMaterial WITHERBONE_T = EnumHelper.addToolMaterial("WitherBoneT", 3, 6248, 12.0F, 4, 22);
    public static ToolMaterial OBSIDIAN_T = EnumHelper.addToolMaterial("ObsidianT", 3, 16, 14.0F, 4, 15);
    public static ToolMaterial EMERALD_T = EnumHelper.addToolMaterial("EmeraldT", 3, 768, 8.0F, 3.0F, 10);
    public static ToolMaterial RUBY_T = EnumHelper.addToolMaterial("RubyT", 2, 500, 6.0F, 2, 21);
    public static ToolMaterial ENDER_T = EnumHelper.addToolMaterial("EnderT", 2, 250, 6.0F, 3, 15);
    public static ToolMaterial BLAZE_T = EnumHelper.addToolMaterial("BlazeT", 2, 100, 7.0F, 2, 15);
    public static ToolMaterial NETHERRACK_T = EnumHelper.addToolMaterial("NetherrackT", 1, 59, 3.5F, 1, 8);
    public static ToolMaterial ENDSTONE_T = EnumHelper.addToolMaterial("EndstoneT", 1, 188, 4.0F, 1, 5);

    public static ArmorMaterial SLIME_A = EnumHelper.addArmorMaterial("SlimeA", 8, new int[] { 2, 3, 2, 2 }, 20);
    public static ArmorMaterial FLESH_A = EnumHelper.addArmorMaterial("FleshA", 4, new int[] { 1, 3, 2, 1 }, 17);
    public static ArmorMaterial WEB_A = EnumHelper.addArmorMaterial("WebA", 24, new int[] { 2, 3, 3, 2 }, 15);
    public static ArmorMaterial BONE_A = EnumHelper.addArmorMaterial("BoneA", 12, new int[] { 2, 5, 3, 2 }, 15);
    public static ArmorMaterial WITHERBONE_A = EnumHelper.addArmorMaterial("WitherBoneA", 132, new int[] { 3, 8, 6, 3 }, 16);
    public static ArmorMaterial OBSIDIAN_A = EnumHelper.addArmorMaterial("ObsidianA", 3, new int[] { 4, 8, 6, 4 }, 28);
    public static ArmorMaterial EMERALD_A = EnumHelper.addArmorMaterial("EmeraldA", 28, new int[] { 3, 7, 5, 3 }, 18);
    public static ArmorMaterial RUBY_A = EnumHelper.addArmorMaterial("RubyA", 20, new int[] { 2, 6, 5, 2 }, 25);
    public static ArmorMaterial ENDER_A = EnumHelper.addArmorMaterial("EnderA", 15, new int[] { 3, 6, 5, 3 }, 15);
    public static ArmorMaterial BLAZE_A = EnumHelper.addArmorMaterial("BlazeA", 10, new int[] { 3, 5, 5, 3 }, 10);
    public static ArmorMaterial BONELORD_A = EnumHelper.addArmorMaterial("BoneLordA", 20, new int[] { 3, 6, 6, 3 }, 25);
    public static ArmorMaterial ENDERDRAGON_A = EnumHelper.addArmorMaterial("DragonScaleA", -1, new int[] { 4, 8, 6, 4 }, 30);
    
    public static final Block BoneBlock = new BlockStorage(Material.rock).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setBlockName("blockBone").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:BoneBlock");
    public static final Block FleshBlock = new BlockStorage(Material.cloth).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundTypeCloth).setBlockName("blockFlesh").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:FleshBlock");
    public static final Block doorNether = new BlockMoreDoors(Material.rock).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundTypeStone).setBlockName("doorNether").setBlockTextureName("doorNether");
    public static final Block doorGlass = new BlockMoreDoors(Material.glass).setHardness(1.0F).setResistance(3.0F).setStepSound(Block.soundTypeGlass).setBlockName("doorGlass").setBlockTextureName("doorGlass");
    public static final Block doorNetherwood = new BlockMoreDoors(Material.wood).setHardness(2.5F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setBlockName("doorNetherwood").setBlockTextureName("doorNetherwood");

    public static final Block NetherBrickFenceGate = new BlockNetherBrickFenceGate().setHardness(2.0F).setResistance(20.0F).setStepSound(Block.soundTypeStone).setBlockName("NetherBrickFenceGate").setBlockTextureName("NetherBrickFenceGate");
    public static final Block StoneStair = new BlockNormalStairs(Blocks.stone, 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("stairStone").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:StoneStair");
    public static final Block RubyOre = new BlockOreRuby(Material.rock).setHardness(4.0F).setResistance(2.0F).setStepSound(Block.soundTypeStone).setBlockName("oreRuby").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:RubyOre");
    public static final Block RubyBlock = new BlockStorage(Material.rock).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("blockRuby").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:RubyBlock");
    public static final Block BlazeBlock = new BlockBlazeBlock().setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeMetal).setLightLevel(1.0F).setBlockName("blockBlaze").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:BlazeBlock");
    public static final Block EndBrickBlock = new BlockNormal(Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setBlockName("enderBrick").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:EndBrickBlock");
    public static final Block EndBrickStair = new BlockNormalStairs(EndBrickBlock, 0).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setBlockName("stairsEnderBrick").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:EndBrickBlock");
    public static final BlockSlab EndBrickSlab = (BlockSlab) new BlockEnderBrickSlab(false, Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setBlockName("slabEnderBrick").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:EndBrickBlock");
    public static final BlockSlab EndBrickSlabFull = (BlockSlab) new BlockEnderBrickSlab(true, Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundTypeStone).setBlockName("slabEnderBrick").setBlockTextureName("bettercraft:EndBrickBlock");
    public static final Block IronTrapdoor = new BlockIronTrapdoor(Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("trapdoorIron").setCreativeTab(CreativeTabs.tabRedstone).setBlockTextureName("bettercraft:trapdoorIron");
    public static final Block NetherLog = new BlockNetherLog().setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setBlockName("netherLog").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:NetherLog");
    public static final Block NetherPlanks = new BlockNetherWood().setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setBlockName("netherPlanks").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:NetherPlanks");
    public static final BlockNetherLeaves NetherLeaves = (BlockNetherLeaves) new BlockNetherLeaves().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("netherLeaves").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName("bettercraft:NetherLeaves");   
    public static final Block NetherSapling = new BlockNetherSapling().setHardness(0F).setResistance(1.0F).setStepSound(Block.soundTypeGrass).setBlockName("netherSapling").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName("bettercraft:NetherSapling");
    public static final Block NetherWoodStairs = new BlockNormalStairs(NetherPlanks, 0).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setBlockName("stairsNetherwood").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:NetherPlanksStair");
    public static final BlockSlab NetherWoodSlab = (BlockSlab) new BlockNetherwoodSlab(false, Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setBlockName("slabNetherwood").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:NetherPlanks");
    public static final BlockSlab NetherWoodSlabFull = (BlockSlab) new BlockNetherwoodSlab(true, Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundTypeWood).setBlockName("slabNetherwood").setBlockTextureName("bettercraft:NetherPlanks");
    public static final Block SoulGlass = new BlockSoulGlass(Material.glass, false).setHardness(0.5F).setResistance(15.0F).setStepSound(Block.soundTypeGlass).setBlockName("soulGlass").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:SoulGlass");
    public static final BlockNetherwoodChest NetherwoodChest = (BlockNetherwoodChest)(new BlockNetherwoodChest(0)).setHardness(2.5F).setResistance(7.0F).setStepSound(Block.soundTypeWood).setBlockName("chestNetherwood").setCreativeTab(CreativeTabs.tabDecorations);    
    public static final Block EnderBlock = new BlockStorage(Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("blockEnder").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:EnderBlock");    
    public static final Block GunpowderBlock = new BlockGunpowder().setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("blockGunpowder").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:GunpowderBlock");    
    public static final Block SlimeBlock = new BlockSlimeBlock(Material.sand).setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundTypeSand).setBlockName("blockSlime").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:SlimeBlock");    
    public static final Block BedrockBrick = new BlockBedrockBricks(Material.rock).setBlockUnbreakable().setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("bedrockBrick").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bettercraft:BedrockBrick");    
    
    //--LIST OF ITEMS--\\
    public static final Item fleshCooked = (new ItemFood(8, 0.8F, true)).setPotionEffect(Potion.confusion.id, 20, 0, 0.1F).setUnlocalizedName("fleshCooked").setTextureName("bettercraft:CookedFlesh");
    public static final Item spiderMeatRaw = (new ItemFood(3, 0.3F, true)).setPotionEffect(Potion.poison.id, 5, 0, 0.5F).setPotionEffect(Potion.confusion.id, 30, 0, 0.1F).setPotionEffect(Potion.blindness.id, 30, 0, 0.1F).setUnlocalizedName("spiderRaw").setTextureName("bettercraft:RawSpiderMeat");
    public static final Item spiderMeatCooked = (new ItemFood(7, 0.7F, true)).setUnlocalizedName("spiderCooked").setTextureName("bettercraft:CookedSpiderMeat");
    public static final Item applePie = (new ItemFood(8, 0.8F, false)).setPotionEffect(Potion.regeneration.id, 5, 0, 0.3F).setUnlocalizedName("applePie").setTextureName("bettercraft:ApplePie");
    public static final Item cakeSlice = (new ItemFood(2, 0.3F, false)).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.25F).setUnlocalizedName("cakeSlice").setTextureName("bettercraft:CakeSlice");
    public static final Item squid = (new ItemFood(3, 0.3F, false)).setPotionEffect(Potion.harm.id, 0, 0, 0.3F).setUnlocalizedName("squidRaw").setTextureName("bettercraft:RawSquid");
    public static final Item calamari = (new ItemFood(6, 0.6F, false)).setUnlocalizedName("calamari").setTextureName("bettercraft:CookedSquid");
    public static final Item lambchopRaw = (new ItemFood(3, 0.3F, true)).setUnlocalizedName("muttonRaw").setTextureName("bettercraft:LambChopRaw");
    public static final Item lambchopCooked = (new ItemFood(8, 0.8F, true)).setUnlocalizedName("muttonCooked").setTextureName("bettercraft:LambChopCooked");
    public static final Item eggFried = (new ItemFood(6, 0.5F, false)).setUnlocalizedName("eggCooked").setTextureName("bettercraft:FriedEgg");
    
    public static final Item EnderBrick = (new Item()).setUnlocalizedName("brickEnder").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bettercraft:ender_brick");
    public static final Item NetherBrickDoor = (new ItemMoreDoors(doorNether)).setUnlocalizedName("doorNether").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorNether");
    public static final Item GlassDoor = (new ItemMoreDoors(doorGlass)).setUnlocalizedName("doorGlass").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorGlass");
    public static final Item NetherwoodDoor = (new ItemMoreDoors(doorNetherwood)).setUnlocalizedName("doorNetherwood").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorNetherwood");
    
    //Not active.
    //public static final Item HorseArmorBone = (new Item(6640)).setUnlocalizedName("horseArmorBone").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/bone_horse_armor");
    //public static final Item HorseArmorEmerald = (new Item(6641)).setUnlocalizedName("horseArmorEmerald").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/emerald_horse_armor");
    //public static final Item HorseArmorRuby = (new Item(6642)).setUnlocalizedName("horseArmorRuby").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/ruby_horse_armor");
    //public static final Item HorseArmorObsidian = (new Item(6643)).setUnlocalizedName("horseArmorObsidian").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/obsidian_horse_armor");
    
    public static final Item helmetSlime = new ItemSlimeArmor(SLIME_A, 4, 0, "slime", Items.slime_ball).setUnlocalizedName("helmetSlime").setTextureName("bettercraft:slime_helmet");
    public static final Item chestplateSlime = new ItemSlimeArmor(SLIME_A, 4, 1, "slime", Items.slime_ball).setUnlocalizedName("chestplateSlime").setTextureName("bettercraft:slime_chestplate");
    public static final Item leggingsSlime = new ItemSlimeArmor(SLIME_A, 4, 2, "slime", Items.slime_ball).setUnlocalizedName("leggingsSlime").setTextureName("bettercraft:slime_leggings");
    public static final Item bootsSlime = new ItemSlimeArmor(SLIME_A, 4, 3, "slime", Items.slime_ball).setUnlocalizedName("bootsSlime").setTextureName("bettercraft:slime_boots");
   
    public static final Item helmetFlesh = new ItemNormalArmor(FLESH_A, 4, 0, "flesh", Items.rotten_flesh).setUnlocalizedName("helmetFlesh").setTextureName("bettercraft:flesh_helmet");
    public static final Item chestplateFlesh = new ItemNormalArmor(FLESH_A, 4, 1, "flesh", Items.rotten_flesh).setUnlocalizedName("chestplateFlesh").setTextureName("bettercraft:flesh_chestplate");
    public static final Item leggingsFlesh = new ItemNormalArmor(FLESH_A, 4, 2, "flesh", Items.rotten_flesh).setUnlocalizedName("leggingsFlesh").setTextureName("bettercraft:flesh_leggings");
    public static final Item bootsFlesh = new ItemNormalArmor(FLESH_A, 4, 3, "flesh", Items.rotten_flesh).setUnlocalizedName("bootsFlesh").setTextureName("bettercraft:flesh_boots");
	
    public static final Item helmetSilk = new ItemNormalArmor(WEB_A, 4, 0, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("helmetSilk").setTextureName("bettercraft:spidersilk_helmet");
    public static final Item chestplateSilk = new ItemNormalArmor(WEB_A, 4, 1, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("chestplateSilk").setTextureName("bettercraft:spidersilk_chestplate");
    public static final Item leggingsSilk = new ItemNormalArmor(WEB_A, 4, 2, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("leggingsSilk").setTextureName("bettercraft:spidersilk_leggings");
    public static final Item bootsSilk = new ItemNormalArmor(WEB_A, 4, 3, "cobweb", Item.getItemFromBlock(Blocks.web)).setUnlocalizedName("bootsSilk").setTextureName("bettercraft:spidersilk_boots");
    
    public static final Item pickaxeObsidian = new ItemNormalPickaxe(OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("pickaxeObsidian").setTextureName("bettercraft:obsidian_pickaxe");
    public static final Item axeObsidian = new ItemNormalAxe(OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("axeObsidian").setTextureName("bettercraft:obsidian_axe");
    public static final Item shovelObsidian = new ItemNormalSpade(OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("shovelObsidian").setTextureName("bettercraft:obsidian_shovel");
    public static final Item hoeObsidian = new ItemNormalHoe(OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("hoeObsidian").setTextureName("bettercraft:obsidian_hoe");
    public static final Item swordObsidian = new ItemNormalSword(OBSIDIAN_T, Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("swordObsidian").setTextureName("bettercraft:obsidian_sword");
    
    public static final Item helmetObsidian = new ItemNormalArmor(OBSIDIAN_A, 4, 0, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("helmetObsidian").setTextureName("bettercraft:obsidian_helmet");
    public static final Item chestplateObsidian =  new ItemNormalArmor(OBSIDIAN_A, 4, 1, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("chestplateObsidian").setTextureName("bettercraft:obsidian_chestplate");
    public static final Item leggingsObsidian =  new ItemNormalArmor(OBSIDIAN_A, 4, 2, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("leggingsObsidian").setTextureName("bettercraft:obsidian_leggings");
    public static final Item bootsObsidian =  new ItemNormalArmor(OBSIDIAN_A, 4, 3, "obsidian", Item.getItemFromBlock(Blocks.obsidian)).setUnlocalizedName("bootsObsidian").setTextureName("bettercraft:obsidian_boots");
    
    public static final Item pickaxeBone = new ItemNormalPickaxe(BONE_T, Items.bone).setUnlocalizedName("pickaxeBone").setTextureName("bettercraft:bone_pickaxe");
    public static final Item axeBone = new ItemNormalAxe(BONE_T, Items.bone).setUnlocalizedName("axeBone").setTextureName("bettercraft:bone_axe");
    public static final Item shovelBone = new ItemNormalSpade(BONE_T, Items.bone).setUnlocalizedName("shovelBone").setTextureName("bettercraft:bone_shovel");
    public static final Item hoeBone = new ItemNormalHoe(BONE_T, Items.bone).setUnlocalizedName("hoeBone").setTextureName("bettercraft:bone_hoe");
    public static final Item swordBone = new ItemNormalSword(BONE_T, Items.bone).setUnlocalizedName("swordBone").setTextureName("bettercraft:bone_sword");
    
    public static final Item helmetBone = new ItemNormalArmor(BONE_A, 4, 0, "bone", Items.bone).setUnlocalizedName("helmetBone").setTextureName("bettercraft:bone_helmet");
    public static final Item chestplateBone = new ItemNormalArmor(BONE_A, 4, 1, "bone", Items.bone).setUnlocalizedName("chestplateBone").setTextureName("bettercraft:bone_chestplate");
    public static final Item leggingsBone = new ItemNormalArmor(BONE_A, 4, 2, "bone", Items.bone).setUnlocalizedName("leggingsBone").setTextureName("bettercraft:bone_leggings");
    public static final Item bootsBone = new ItemNormalArmor(BONE_A, 4, 3, "bone", Items.bone).setUnlocalizedName("bootsBone").setTextureName("bettercraft:bone_boots");
    
    public static final Item WitherBone = new Item().setUnlocalizedName("WitherBone").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bettercraft:wither_bone");

    public static final Item pickaxeWitherbone = new ItemNormalPickaxe(WITHERBONE_T, WitherBone).setUnlocalizedName("pickaxeWitherbone").setTextureName("bettercraft:witherbone_pickaxe");
    public static final Item axeWitherbone = new ItemNormalAxe(WITHERBONE_T, WitherBone).setUnlocalizedName("axeWitherbone").setTextureName("bettercraft:witherbone_axe");
    public static final Item shovelWitherbone = new ItemNormalSpade(WITHERBONE_T, WitherBone).setUnlocalizedName("shovelWitherbone").setTextureName("bettercraft:witherbone_shovel");
    public static final Item hoeWitherbone = new ItemNormalHoe(WITHERBONE_T, WitherBone).setUnlocalizedName("hoeWitherbone").setTextureName("bettercraft:witherbone_hoe");
    public static final Item swordWitherbone = new ItemWitherSword(WITHERBONE_T, WitherBone).setUnlocalizedName("swordWitherbone").setTextureName("bettercraft:witherbone_sword");
    
    public static final Item helmetWitherbone = new ItemNormalArmor(WITHERBONE_A, 4, 0, "witherbone", WitherBone).setUnlocalizedName("helmetWitherbone").setTextureName("bettercraft:witherbone_helmet");
    public static final Item chestplateWitherbone = new ItemNormalArmor(WITHERBONE_A, 4, 1, "witherbone", WitherBone).setUnlocalizedName("chestplateWitherbone").setTextureName("bettercraft:witherbone_chestplate");
    public static final Item leggingsWitherbone = new ItemNormalArmor(WITHERBONE_A, 4, 2, "witherbone", WitherBone).setUnlocalizedName("leggingsWitherbone").setTextureName("bettercraft:witherbone_leggings");
    public static final Item bootsWitherbone = new ItemNormalArmor(WITHERBONE_A, 4, 3, "witherbone", WitherBone).setUnlocalizedName("bootsWitherbone").setTextureName("bettercraft:witherbone_boots");

    public static final Item pickaxeEmerald = new ItemNormalPickaxe(EMERALD_T, Items.emerald).setUnlocalizedName("pickaxeEmerald").setTextureName("bettercraft:emerald_pickaxe");
    public static final Item axeEmerald = new ItemNormalAxe(EMERALD_T, Items.emerald).setUnlocalizedName("axeEmerald").setTextureName("bettercraft:emerald_axe");
    public static final Item shovelEmerald = new ItemNormalSpade(EMERALD_T, Items.emerald).setUnlocalizedName("shovelEmerald").setTextureName("bettercraft:emerald_shovel");
    public static final Item hoeEmerald = new ItemNormalHoe(EMERALD_T, Items.emerald).setUnlocalizedName("hoeEmerald").setTextureName("bettercraft:emerald_hoe");
    public static final Item swordEmerald = new ItemNormalSword(EMERALD_T, Items.emerald).setUnlocalizedName("swordEmerald").setTextureName("bettercraft:emerald_sword");
    
    public static final Item helmetEmerald = new ItemNormalArmor(EMERALD_A, 4, 0, "emerald", Items.emerald).setUnlocalizedName("helmetEmerald").setTextureName("bettercraft:emerald_helmet");
    public static final Item chestplateEmerald = new ItemNormalArmor(EMERALD_A, 4, 1, "emerald", Items.emerald).setUnlocalizedName("chestplateEmerald").setTextureName("bettercraft:emerald_chestplate");
    public static final Item leggingsEmerald = new ItemNormalArmor(EMERALD_A, 4, 2, "emerald", Items.emerald).setUnlocalizedName("leggingsEmerald").setTextureName("bettercraft:emerald_leggings");
    public static final Item bootsEmerald = new ItemNormalArmor(EMERALD_A, 4, 3, "emerald", Items.emerald).setUnlocalizedName("bootsEmerald").setTextureName("bettercraft:emerald_boots");

    public static final Item ruby = new Item().setUnlocalizedName("ruby").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("ruby");    

    public static final Item pickaxeRuby = new ItemNormalPickaxe(RUBY_T, ruby).setUnlocalizedName("pickaxeRuby").setTextureName("bettercraft:ruby_pickaxe");
    public static final Item axeRuby = new ItemNormalAxe(RUBY_T, ruby).setUnlocalizedName("axeRuby").setTextureName("bettercraft:ruby_axe");
    public static final Item shovelRuby = new ItemNormalSpade(RUBY_T, ruby).setUnlocalizedName("shovelRuby").setTextureName("bettercraft:ruby_shovel");
    public static final Item hoeRuby = new ItemNormalHoe(RUBY_T, ruby).setUnlocalizedName("hoeRuby").setTextureName("bettercraft:ruby_hoe");
    public static final Item swordRuby = new ItemNormalSword(RUBY_T, ruby).setUnlocalizedName("swordRuby").setTextureName("bettercraft:ruby_sword");
    
    public static final Item helmetRuby = new ItemNormalArmor(RUBY_A, 4, 0, "ruby", ruby).setUnlocalizedName("helmetRuby").setTextureName("bettercraft:ruby_helmet");
    public static final Item chestplateRuby = new ItemNormalArmor(RUBY_A, 4, 1, "ruby", ruby).setUnlocalizedName("chestplateRuby").setTextureName("bettercraft:ruby_chestplate");
    public static final Item leggingsRuby = new ItemNormalArmor(RUBY_A, 4, 2, "ruby", ruby).setUnlocalizedName("leggingsRuby").setTextureName("bettercraft:ruby_leggings");
    public static final Item bootsRuby = new ItemNormalArmor(RUBY_A, 4, 3, "ruby", ruby).setUnlocalizedName("bootsRuby").setTextureName("bettercraft:ruby_boots");
    
    public static final Item pickaxeBlaze = new ItemNormalPickaxe(BLAZE_T, Items.blaze_rod).setUnlocalizedName("pickaxeBlaze").setTextureName("bettercraft:blaze_pickaxe");
    public static final Item axeBlaze = new ItemNormalAxe(BLAZE_T, Items.blaze_rod).setUnlocalizedName("axeBlaze").setTextureName("bettercraft:blaze_axe");
    public static final Item shovelBlaze = new ItemNormalSpade(BLAZE_T, Items.blaze_rod).setUnlocalizedName("shovelBlaze").setTextureName("bettercraft:blaze_shovel");
    public static final Item hoeBlaze = new ItemNormalHoe(BLAZE_T, Items.blaze_rod).setUnlocalizedName("hoeBlaze").setTextureName("bettercraft:blaze_hoe");
    public static final Item swordBlaze = new ItemBlazeSword(BLAZE_T, Items.blaze_rod).setUnlocalizedName("swordBlaze").setTextureName("bettercraft:blaze_sword");
    
    public static final Item helmetBlaze = new ItemNormalArmor(BLAZE_A, 4, 0, "blaze", Items.blaze_rod).setUnlocalizedName("helmetBlaze").setTextureName("bettercraft:blaze_helmet");
    public static final Item chestplateBlaze = new ItemNormalArmor(BLAZE_A, 4, 1, "blaze", Items.blaze_rod).setUnlocalizedName("chestplateBlaze").setTextureName("bettercraft:blaze_chestplate");
    public static final Item leggingsBlaze = new ItemNormalArmor(BLAZE_A, 4, 2, "blaze", Items.blaze_rod).setUnlocalizedName("leggingsBlaze").setTextureName("bettercraft:blaze_leggings");
    public static final Item bootsBlaze = new ItemNormalArmor(BLAZE_A, 4, 3, "blaze", Items.blaze_rod).setUnlocalizedName("bootsBlaze").setTextureName("bettercraft:blaze_boots");

    public static final Item pickaxeEnder = new ItemNormalPickaxe(ENDER_T, Items.ender_pearl).setUnlocalizedName("pickaxeEnder").setTextureName("bettercraft:ender_pickaxe");
    public static final Item axeEnder = new ItemNormalAxe(ENDER_T, Items.ender_pearl).setUnlocalizedName("axeEnder").setTextureName("bettercraft:ender_axe");
    public static final Item shovelEnder = new ItemNormalSpade(ENDER_T, Items.ender_pearl).setUnlocalizedName("shovelEnder").setTextureName("bettercraft:ender_shovel");
    public static final Item hoeEnder = new ItemNormalHoe(ENDER_T, Items.ender_pearl).setUnlocalizedName("hoeEnder").setTextureName("bettercraft:ender_hoe");
    public static final Item swordEnder = new ItemNormalSword(ENDER_T, Items.ender_pearl).setUnlocalizedName("swordEnder").setTextureName("bettercraft:ender_sword");
    
    public static final Item helmetEnder = new ItemNormalArmor(ENDER_A, 4, 0, "ender", Items.ender_pearl).setUnlocalizedName("helmetEnder").setTextureName("bettercraft:ender_helmet");
    public static final Item chestplateEnder = new ItemNormalArmor(ENDER_A, 4, 1, "ender", Items.ender_pearl).setUnlocalizedName("chestplateEnder").setTextureName("bettercraft:ender_chestplate");
    public static final Item leggingsEnder = new ItemNormalArmor(ENDER_A, 4, 2, "ender", Items.ender_pearl).setUnlocalizedName("leggingsEnder").setTextureName("bettercraft:ender_leggings");
    public static final Item bootsEnder = new ItemNormalArmor(ENDER_A, 4, 3, "ender", Items.ender_pearl).setUnlocalizedName("bootsEnder").setTextureName("bettercraft:ender_boots");
    
    public static final Item pickaxeEndstone = new ItemNormalPickaxe(ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("pickaxeEndstone").setTextureName("bettercraft:endstone_pickaxe");
    public static final Item axeEndstone = new ItemNormalAxe(ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("axeEndstone").setTextureName("bettercraft:endstone_axe");
    public static final Item shovelEndstone = new ItemNormalSpade(ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("shovelEndstone").setTextureName("bettercraft:endstone_shovel");
    public static final Item hoeEndstone = new ItemNormalHoe(ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("hoeEndstone").setTextureName("bettercraft:endstone_hoe");
    public static final Item swordEndstone = new ItemNormalSword(ENDSTONE_T, Item.getItemFromBlock(Blocks.end_stone)).setUnlocalizedName("swordEndstone").setTextureName("bettercraft:endstone_sword");

    public static final Item pickaxeNetherrack = new ItemNormalPickaxe(NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("pickaxeNetherrack").setTextureName("bettercraft:netherrack_pickaxe");
    public static final Item axeNetherrack = new ItemNormalAxe(NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("axeNetherrack").setTextureName("bettercraft:netherrack_axe");
    public static final Item shovelNetherrack = new ItemNormalSpade(NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("shovelNetherrack").setTextureName("bettercraft:netherrack_shovel");
    public static final Item hoeNetherrack = new ItemNormalHoe(NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("hoeNetherrack").setTextureName("bettercraft:netherrack_hoe");
    public static final Item swordNetherrack = new ItemNormalSword(NETHERRACK_T, Item.getItemFromBlock(Blocks.netherrack)).setUnlocalizedName("swordNetherrack").setTextureName("bettercraft:netherrack_sword");
    
    public static final Item helmetBonelord = new ItemBonelordArmor(BONELORD_A, 4, 0, "necro", Items.bone).setUnlocalizedName("helmetBonelord").setTextureName("bettercraft:bonelord_helmet");
    public static final Item chestplateBonelord = new ItemBonelordArmor(BONELORD_A, 4, 1, "necro", Items.bone).setUnlocalizedName("chestplateBonelord").setTextureName("bettercraft:bonelord_chestplate");
    public static final Item leggingsBonelord = new ItemBonelordArmor(BONELORD_A, 4, 2, "necro", Items.bone).setUnlocalizedName("leggingsBonelord").setTextureName("bettercraft:bonelord_leggings");
    public static final Item bootsBonelord = new ItemBonelordArmor(BONELORD_A, 4, 3, "necro", Items.bone).setUnlocalizedName("bootsBonelord").setTextureName("bettercraft:bonelord_boots");

    public static final Item helmetEnderdragon = new ItemEnderdragonArmor(ENDERDRAGON_A, 4, 0, "enderdragon").setUnlocalizedName("helmetEnderdragon").setTextureName("bettercraft:enderdragon_helmet");
    public static final Item chestplateEnderdragon = new ItemEnderdragonArmor(ENDERDRAGON_A, 4, 1, "enderdragon").setUnlocalizedName("chestplateEnderdragon").setTextureName("bettercraft:enderdragon_chestplate");
    public static final Item leggingsEnderdragon = new ItemEnderdragonArmor(ENDERDRAGON_A, 4, 2, "enderdragon").setUnlocalizedName("leggingsEnderdragon").setTextureName("bettercraft:enderdragon_leggings");
    public static final Item bootsEnderdragon = new ItemEnderdragonArmor(ENDERDRAGON_A, 4, 3, "enderdragon").setUnlocalizedName("bootsEnderdragon").setTextureName("bettercraft:enderdragon_boots");
    
    
    
	@EventHandler
	// used in 1.6.2
	// @PreInit // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new MobDrop());
		MinecraftForge.EVENT_BUS.register(new BonemealUsage());
	}

	@EventHandler
	// used in 1.6.2
	// @Init // used in 1.5.2
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		
		//Register blocks
    	GameRegistry.registerBlock(BoneBlock, "blockBone");
    	GameRegistry.registerBlock(FleshBlock, "blockFlesh");
    	GameRegistry.registerBlock(StoneStair, "stairStone");
    	GameRegistry.registerBlock(doorNether, "doorNetherBlock");
    	GameRegistry.registerBlock(doorGlass, "doorGlassBlock");
    	GameRegistry.registerBlock(doorNetherwood, "doorNetherwoodBlock");
    	GameRegistry.registerBlock(NetherBrickFenceGate, "gateNetherBrick");
    	GameRegistry.registerBlock(RubyOre, "oreRuby");
    	GameRegistry.registerBlock(RubyBlock, "blockRuby");
    	GameRegistry.registerBlock(BlazeBlock, "blockBlaze");
    	GameRegistry.registerBlock(EndBrickBlock, "enderBrick");
    	GameRegistry.registerBlock(EndBrickStair, "stairsEnderBrick");
    	GameRegistry.registerBlock(EndBrickSlab, ItemEnderbrickSlab.class, "slabEnderBrick");
    	GameRegistry.registerBlock(EndBrickSlabFull, ItemEnderbrickSlab.class, "slabEnderBrickFull");
    	GameRegistry.registerBlock(IronTrapdoor, "trapdoorIron");
    	GameRegistry.registerBlock(NetherLog, "netherWood");
    	GameRegistry.registerBlock(NetherPlanks, "netherPlanks");
    	GameRegistry.registerBlock(NetherLeaves, "netherLeaves");
    	GameRegistry.registerBlock(NetherSapling, "netherSapling");
    	GameRegistry.registerBlock(NetherWoodStairs, "stairsNetherwood");
    	GameRegistry.registerBlock(NetherWoodSlab, ItemNetherwoodSlab.class, "slabNetherwood");
    	GameRegistry.registerBlock(NetherWoodSlabFull, ItemNetherwoodSlab.class, "slabNetherwoodFull");
    	GameRegistry.registerBlock(SoulGlass, "soulGlass");
    	GameRegistry.registerBlock(NetherwoodChest, "chestNetherwood");
    	GameRegistry.registerBlock(EnderBlock, "blockEnder");  
    	GameRegistry.registerBlock(GunpowderBlock, "blockGunpowder");
    	GameRegistry.registerBlock(SlimeBlock, "blockSlime");
    	GameRegistry.registerBlock(BedrockBrick, "bedrockBricks");

    	//Register food
    	GameRegistry.registerItem(fleshCooked, "fleshCooked");
    	GameRegistry.registerItem(spiderMeatRaw, "spiderRaw");
    	GameRegistry.registerItem(spiderMeatCooked, "spiderCooked");
    	GameRegistry.registerItem(applePie, "applePie");
    	GameRegistry.registerItem(cakeSlice, "cakeSlice");
    	GameRegistry.registerItem(squid, "squidRaw");
    	GameRegistry.registerItem(calamari, "calamari");
    	GameRegistry.registerItem(lambchopRaw, "lambchopRaw");
    	GameRegistry.registerItem(lambchopCooked, "lambchopCooked");
    	GameRegistry.registerItem(eggFried, "eggFried");
    	//Register materials
    	GameRegistry.registerItem(EnderBrick, "brickEnder");
    	GameRegistry.registerItem(ruby, "ruby");
    	GameRegistry.registerItem(WitherBone, "boneWither");
    	//Register door items
    	GameRegistry.registerItem(NetherBrickDoor, "doorNetherbrick");
    	GameRegistry.registerItem(GlassDoor, "doorGlass");
    	GameRegistry.registerItem(NetherwoodDoor, "doorNetherwood");
    	//Register tools
    	GameRegistry.registerItem(pickaxeObsidian, "pickaxeObsidian");
    	GameRegistry.registerItem(axeObsidian, "axeObsidian");
    	GameRegistry.registerItem(shovelObsidian, "shovelObsidian");
    	GameRegistry.registerItem(hoeObsidian, "hoeObsidian");
    	GameRegistry.registerItem(swordObsidian, "swordObsidian");

    	GameRegistry.registerItem(pickaxeBone, "pickaxeBone");
    	GameRegistry.registerItem(axeBone, "axeBone");
    	GameRegistry.registerItem(shovelBone, "shovelBone");
    	GameRegistry.registerItem(hoeBone, "hoeBone");
    	GameRegistry.registerItem(swordBone, "swordBone");

    	GameRegistry.registerItem(pickaxeWitherbone, "pickaxeWitherBone");
    	GameRegistry.registerItem(axeWitherbone, "axeWitherBone");
    	GameRegistry.registerItem(shovelWitherbone, "shovelWitherBone");
    	GameRegistry.registerItem(hoeWitherbone, "hoeWitherBone");
    	GameRegistry.registerItem(swordWitherbone, "swordWitherBone");

    	GameRegistry.registerItem(pickaxeEmerald, "pickaxeEmerald");
    	GameRegistry.registerItem(axeEmerald, "axeEmerald");
    	GameRegistry.registerItem(shovelEmerald, "shovelEmerald");
    	GameRegistry.registerItem(hoeEmerald, "hoeEmerald");
    	GameRegistry.registerItem(swordEmerald, "swordEmerald");

    	GameRegistry.registerItem(pickaxeRuby, "pickaxeRuby");
    	GameRegistry.registerItem(axeRuby, "axeRuby");
    	GameRegistry.registerItem(shovelRuby, "shovelRuby");
    	GameRegistry.registerItem(hoeRuby, "hoeRuby");
    	GameRegistry.registerItem(swordRuby, "swordRuby");

    	GameRegistry.registerItem(pickaxeBlaze, "pickaxeBlaze");
    	GameRegistry.registerItem(axeBlaze, "axeBlaze");
    	GameRegistry.registerItem(shovelBlaze, "shovelBlaze");
    	GameRegistry.registerItem(hoeBlaze, "hoeBlaze");
    	GameRegistry.registerItem(swordBlaze, "swordBlaze");

    	GameRegistry.registerItem(pickaxeEnder, "pickaxeEnder");
    	GameRegistry.registerItem(axeEnder, "axeEnder");
    	GameRegistry.registerItem(shovelEnder, "shovelEnder");
    	GameRegistry.registerItem(hoeEnder, "hoeEnder");
    	GameRegistry.registerItem(swordEnder, "swordEnder");

    	GameRegistry.registerItem(pickaxeNetherrack, "pickaxeNetherrack");
    	GameRegistry.registerItem(axeNetherrack, "axeNetherrack");
    	GameRegistry.registerItem(shovelNetherrack, "shovelNetherrack");
    	GameRegistry.registerItem(hoeNetherrack, "hoeNetherrack");
    	GameRegistry.registerItem(swordNetherrack, "swordNetherrack");

    	GameRegistry.registerItem(pickaxeEndstone, "pickaxeEndstone");
    	GameRegistry.registerItem(axeEndstone, "axeEndstone");
    	GameRegistry.registerItem(shovelEndstone, "shovelEndstone");
    	GameRegistry.registerItem(hoeEndstone, "hoeEndstone");
    	GameRegistry.registerItem(swordEndstone, "swordEndstone");

    	//Register armour
     	GameRegistry.registerItem(helmetSlime, "helmetSlime");
       	GameRegistry.registerItem(chestplateSlime, "chestplateSlime");
    	GameRegistry.registerItem(leggingsSlime, "leggingsSlime");
    	GameRegistry.registerItem(bootsSlime, "bootsSlime");

    	GameRegistry.registerItem(helmetFlesh, "helmetFlesh");
    	GameRegistry.registerItem(chestplateFlesh, "chestplateFlesh");
    	GameRegistry.registerItem(leggingsFlesh, "leggingsFlesh");
    	GameRegistry.registerItem(bootsFlesh, "bootsFlesh");

    	GameRegistry.registerItem(helmetSilk, "helmetSilk");
    	GameRegistry.registerItem(chestplateSilk, "chestplateSilk");
    	GameRegistry.registerItem(leggingsSilk, "leggingsSilk");
    	GameRegistry.registerItem(bootsSilk, "bootsSilk");

    	GameRegistry.registerItem(helmetObsidian, "helmetObsidian");
    	GameRegistry.registerItem(chestplateObsidian, "chestplateObsidian");
    	GameRegistry.registerItem(leggingsObsidian, "leggingsObsidian");
    	GameRegistry.registerItem(bootsObsidian, "bootsObsidian");

    	GameRegistry.registerItem(helmetBone, "helmetBone");
    	GameRegistry.registerItem(chestplateBone, "chestplateBone");
    	GameRegistry.registerItem(leggingsBone, "leggingsBone");
    	GameRegistry.registerItem(bootsBone, "bootsBone");

    	GameRegistry.registerItem(helmetWitherbone, "helmetWitherBone");
    	GameRegistry.registerItem(chestplateWitherbone, "chestplateWitherBone");
    	GameRegistry.registerItem(leggingsWitherbone, "leggingsWitherBone");
    	GameRegistry.registerItem(bootsWitherbone, "bootsWitherBone");

    	GameRegistry.registerItem(helmetEmerald, "helmetEmerald");
    	GameRegistry.registerItem(chestplateEmerald, "chestplateEmerald");
    	GameRegistry.registerItem(leggingsEmerald, "leggingsEmerald");
    	GameRegistry.registerItem(bootsEmerald, "bootsEmerald");

    	GameRegistry.registerItem(helmetRuby, "helmetRuby");
    	GameRegistry.registerItem(chestplateRuby, "chestplateRuby");
    	GameRegistry.registerItem(leggingsRuby, "leggingsRuby");
    	GameRegistry.registerItem(bootsRuby, "bootsRuby");
    	
    	GameRegistry.registerItem(helmetBlaze, "helmetBlaze");
    	GameRegistry.registerItem(chestplateBlaze, "chestplateBlaze");
    	GameRegistry.registerItem(leggingsBlaze, "leggingsBlaze");
    	GameRegistry.registerItem(bootsBlaze, "bootsBlaze");
    	
    	GameRegistry.registerItem(helmetEnder, "helmetEnder");
    	GameRegistry.registerItem(chestplateEnder, "chestplateEnder");
    	GameRegistry.registerItem(leggingsEnder, "leggingsEnder");
    	GameRegistry.registerItem(bootsEnder, "bootsEnder");
    	
    	GameRegistry.registerItem(helmetBonelord, "helmetBonelord");
    	GameRegistry.registerItem(chestplateBonelord, "chestplateBonelord");
    	GameRegistry.registerItem(leggingsBonelord, "leggingsBonelord");
    	GameRegistry.registerItem(bootsBonelord, "bootsBonelord");
    	
    	GameRegistry.registerItem(helmetEnderdragon, "helmetDragonscale");
    	GameRegistry.registerItem(chestplateEnderdragon, "chestplateDragonscale");
    	GameRegistry.registerItem(leggingsEnderdragon, "leggingsDragonscale");
    	GameRegistry.registerItem(bootsEnderdragon, "bootsDragonscale");

    	//Register tile entities
    	GameRegistry.registerTileEntity(TileEntityNetherwoodChest.class, "tileentitynetherchest");
        
		//MinecraftForge.setBlockHarvestLevel(BoneBlock, "pickaxe", 0);
		//MinecraftForge.setBlockHarvestLevel(StoneStair, "pickaxe", 0);           
		//MinecraftForge.setBlockHarvestLevel(RubyOre, "pickaxe", 2);
		//MinecraftForge.setBlockHarvestLevel(RubyBlock, "pickaxe", 2);           

        
        //Smelt and process items.
        GameRegistry.addSmelting(ruby, new ItemStack(RubyOre), 3.0F);
        
        //Item storage recipes.
        GameRegistry.addRecipe(new ItemStack(BoneBlock, 1), "###", "###", "###",'#', Items.bone);
        GameRegistry.addRecipe(new ItemStack(RubyBlock, 1), "###", "###", "###",'#', ruby);

        GameRegistry.addRecipe(new ItemStack(Items.bone, 9), "###", "###", "###",'#', BoneBlock);
        GameRegistry.addRecipe(new ItemStack(ruby, 9), "###", "###", "###",'#', RubyBlock);

        // ~ -- RECIPES -- ~ \\
        
        //--Bone Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetBone, 1), new Object[] {"KKK", "K K", 'K', Items.bone});
        GameRegistry.addRecipe(new ItemStack(chestplateBone, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.bone});
        GameRegistry.addRecipe(new ItemStack(leggingsBone, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.bone});
        GameRegistry.addRecipe(new ItemStack(bootsBone, 1), new Object[] {"K K", "K K", 'K', Items.bone});
        GameRegistry.addRecipe(new ItemStack(pickaxeBone, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.bone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeBone, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.bone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelBone, 1), new Object[] {"K", "S", "S", 'K', Items.bone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeBone, 1), new Object[] {"KK", " S", " S", 'K', Items.bone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordBone, 1), new Object[] {"K", "K", "S", 'K', Items.bone, 'S', Items.stick}); 
        
        //--Wither Bone Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetWitherbone, 1), new Object[] {"KKK", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(chestplateWitherbone, 1), new Object[] {"K K", "KKK", "KKK", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(leggingsWitherbone, 1), new Object[] {"KKK", "K K", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(bootsWitherbone, 1), new Object[] {"K K", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(pickaxeWitherbone, 1), new Object[] {"KKK", " S ", " S ", 'K', WitherBone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeWitherbone, 1), new Object[] {"KK ", "KS ", " S ", 'K', WitherBone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelWitherbone, 1), new Object[] {"K", "S", "S", 'K', WitherBone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeWitherbone, 1), new Object[] {"KK", " S", " S", 'K', WitherBone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordWitherbone, 1), new Object[] {"K", "K", "S", 'K', WitherBone, 'S', Items.stick});
        
        //--Obsidian Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetObsidian, 1), new Object[] {"KKK", "K K", 'K', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(chestplateObsidian, 1), new Object[] {"K K", "KKK", "KKK", 'K', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(leggingsObsidian, 1), new Object[] {"KKK", "K K", "K K", 'K', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(bootsObsidian, 1), new Object[] {"K K", "K K", 'K', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(pickaxeObsidian, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.obsidian, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeObsidian, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.obsidian, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelObsidian, 1), new Object[] {"K", "S", "S", 'K', Blocks.obsidian, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeObsidian, 1), new Object[] {"KK", " S", " S", 'K', Blocks.obsidian, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordObsidian, 1), new Object[] {"K", "K", "S", 'K', Blocks.obsidian, 'S', Items.stick});

        //--Emerald Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetEmerald, 1), new Object[] {"KKK", "K K", 'K', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(chestplateEmerald, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(leggingsEmerald, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(bootsEmerald, 1), new Object[] {"K K", "K K", 'K', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(pickaxeEmerald, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeEmerald, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelEmerald, 1), new Object[] {"K", "S", "S", 'K', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeEmerald, 1), new Object[] {"KK", " S", " S", 'K', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordEmerald, 1), new Object[] {"K", "K", "S", 'K', Items.emerald, 'S', Items.stick});

        //--ruby Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetRuby, 1), new Object[] {"KKK", "K K", 'K', ruby});
        GameRegistry.addRecipe(new ItemStack(chestplateRuby, 1), new Object[] {"K K", "KKK", "KKK", 'K', ruby});
        GameRegistry.addRecipe(new ItemStack(leggingsRuby, 1), new Object[] {"KKK", "K K", "K K", 'K', ruby});
        GameRegistry.addRecipe(new ItemStack(bootsRuby, 1), new Object[] {"K K", "K K", 'K', ruby});
        GameRegistry.addRecipe(new ItemStack(pickaxeRuby, 1), new Object[] {"KKK", " S ", " S ", 'K', ruby, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeRuby, 1), new Object[] {"KK ", "KS ", " S ", 'K', ruby, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelRuby, 1), new Object[] {"K", "S", "S", 'K', ruby, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeRuby, 1), new Object[] {"KK", " S", " S", 'K', ruby, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordRuby, 1), new Object[] {"K", "K", "S", 'K', ruby, 'S', Items.stick});
        
        //--Blaze Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetBlaze, 1), new Object[] {"KKK", "K K", 'K', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(chestplateBlaze, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(leggingsBlaze, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(bootsBlaze, 1), new Object[] {"K K", "K K", 'K', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(pickaxeBlaze, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.blaze_rod, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeBlaze, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.blaze_rod, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelBlaze, 1), new Object[] {"K", "S", "S", 'K', Items.blaze_rod, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeBlaze, 1), new Object[] {"KK", " S", " S", 'K', Items.blaze_rod, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordBlaze, 1), new Object[] {"K", "K", "S", 'K', Items.blaze_rod, 'S', Items.stick});

        //--Ender Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetEnder, 1), new Object[] {"KKK", "K K", 'K', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(chestplateEnder, 1), new Object[] {"K K", "KKK", "KKK", 'K', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(leggingsEnder, 1), new Object[] {"KKK", "K K", "K K", 'K', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(bootsEnder, 1), new Object[] {"K K", "K K", 'K', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(pickaxeEnder, 1), new Object[] {"KKK", " S ", " S ", 'K', Items.ender_pearl, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeEnder, 1), new Object[] {"KK ", "KS ", " S ", 'K', Items.ender_pearl, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelEnder, 1), new Object[] {"K", "S", "S", 'K', Items.ender_pearl, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeEnder, 1), new Object[] {"KK", " S", " S", 'K', Items.ender_pearl, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordEnder, 1), new Object[] {"K", "K", "S", 'K', Items.ender_pearl, 'S', Items.stick});
        
        //--Endstone Tools--\\
        GameRegistry.addRecipe(new ItemStack(pickaxeEndstone, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.end_stone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeEndstone, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.end_stone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelEndstone, 1), new Object[] {"K", "S", "S", 'K', Blocks.end_stone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeEndstone, 1), new Object[] {"KK", " S", " S", 'K', Blocks.end_stone, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordEndstone, 1), new Object[] {"K", "K", "S", 'K', Blocks.end_stone, 'S', Items.stick});

        //--Netherrack Tools--\\
        GameRegistry.addRecipe(new ItemStack(pickaxeNetherrack, 1), new Object[] {"KKK", " S ", " S ", 'K', Blocks.netherrack, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(axeNetherrack, 1), new Object[] {"KK ", "KS ", " S ", 'K', Blocks.netherrack, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(shovelNetherrack, 1), new Object[] {"K", "S", "S", 'K', Blocks.netherrack, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(hoeNetherrack, 1), new Object[] {"KK", " S", " S", 'K', Blocks.netherrack, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(swordNetherrack, 1), new Object[] {"K", "K", "S", 'K', Blocks.netherrack, 'S', Items.stick});

        //--Slime Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetSlime, 1), new Object[] {"###", "# #", '#', Items.slime_ball});
        GameRegistry.addRecipe(new ItemStack(chestplateSlime, 1), new Object[] {"# #", "###", "###", '#', Items.slime_ball});
        GameRegistry.addRecipe(new ItemStack(leggingsSlime, 1), new Object[] {"###", "# #", "# #", '#', Items.slime_ball});
        GameRegistry.addRecipe(new ItemStack(bootsSlime, 1), new Object[] {"# #", "# #", '#', Items.slime_ball});
        
        //--Rotten Flesh Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetFlesh, 1), new Object[] {"###", "# #", '#', Items.rotten_flesh});
        GameRegistry.addRecipe(new ItemStack(chestplateFlesh, 1), new Object[] {"# #", "###", "###", '#', Items.rotten_flesh});
        GameRegistry.addRecipe(new ItemStack(leggingsFlesh, 1), new Object[] {"###", "# #", "# #", '#', Items.rotten_flesh});
        GameRegistry.addRecipe(new ItemStack(bootsFlesh, 1), new Object[] {"# #", "# #", '#', Items.rotten_flesh});
        
        //--Spider Silk Armor--\\
        GameRegistry.addRecipe(new ItemStack(helmetSilk, 1), new Object[] {"###", "# #", '#', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(chestplateSilk, 1), new Object[] {"# #", "###", "###", '#', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(leggingsSilk, 1), new Object[] {"###", "# #", "# #", '#', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(bootsSilk, 1), new Object[] {"# #", "# #", '#', Blocks.web});

        //--Necro Armour--\\
        GameRegistry.addRecipe(new ItemStack(helmetBonelord, 1), new Object[] {"BBB", "C C", 'B', Items.bone, 'C', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(chestplateBonelord, 1), new Object[] {"B B", "CCC", "BBB", 'B', Items.bone, 'C', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(leggingsBonelord, 1), new Object[] {"BBB", "C C", "B B", 'B', Items.bone, 'C', Blocks.web});
        GameRegistry.addRecipe(new ItemStack(bootsBonelord, 1), new Object[] {"C C", "B B", 'B', Items.bone, 'C', Blocks.web});

        
        
        //--Block Recipes--\\
        
        // Items into Storage Blocks
        GameRegistry.addRecipe(new ItemStack(BoneBlock, 1), new Object[] {"###","###","###",'#', Items.bone});
        GameRegistry.addRecipe(new ItemStack(FleshBlock, 1), new Object[] {"###","###","###",'#', Items.rotten_flesh});
        GameRegistry.addRecipe(new ItemStack(RubyBlock, 1), new Object[] {"###","###","###",'#', ruby});
        GameRegistry.addRecipe(new ItemStack(BlazeBlock, 1), new Object[] {"###","###","###",'#', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(EnderBlock, 1), new Object[] {"###","###","###",'#', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(GunpowderBlock, 1), new Object[] {"###","###","###",'#', Items.gunpowder});
        GameRegistry.addRecipe(new ItemStack(SlimeBlock, 1), new Object[] {"###","###","###",'#', Items.slime_ball});

        // Storage Blocks into Items
        GameRegistry.addRecipe(new ItemStack(Items.bone, 9), new Object[] {"B",'B', BoneBlock});
        GameRegistry.addRecipe(new ItemStack(Items.rotten_flesh, 9), new Object[] {"B",'B', FleshBlock});
        GameRegistry.addRecipe(new ItemStack(ruby, 9), new Object[] {"B",'B', RubyBlock});
        GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 9), new Object[] {"B",'B', BlazeBlock});
        GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] {"B",'B', EnderBlock});
        GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] {"B",'B', GunpowderBlock});
        GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] {"B",'B', SlimeBlock});
        
        // Decorative Blocks
        GameRegistry.addRecipe(new ItemStack(EndBrickBlock, 1), new Object[] {"##","##",'#', EnderBrick});

        // Slabs and Stairs
        GameRegistry.addRecipe(new ItemStack(EndBrickStair, 4), new Object[] {"  #"," ##","###",'#', EndBrickBlock});
        GameRegistry.addRecipe(new ItemStack(StoneStair, 4), new Object[] {"  #"," ##","###",'#', Blocks.stone});
        GameRegistry.addRecipe(new ItemStack(NetherWoodStairs, 4), new Object[] {"  #"," ##","###",'#', NetherPlanks});

        GameRegistry.addRecipe(new ItemStack(EndBrickSlab, 6), new Object[] {"###",'#', EndBrickBlock});
        GameRegistry.addRecipe(new ItemStack(NetherWoodSlab, 6), new Object[] {"###",'#', NetherPlanks});

        // Convert Logs to Planks
        GameRegistry.addRecipe(new ItemStack(NetherPlanks, 4), new Object[] {"#", '#', NetherLog});

               
        //--IMPORTANT RECIPES--\\
        GameRegistry.addRecipe(new ItemStack(Blocks.web, 1), new Object[] {"S S", " S ", "S S", 'S', Items.string});
        GameRegistry.addRecipe(new ItemStack(WitherBone, 4), new Object[] {"OBO", "BNB", "OBO", 'O', Items.coal, 'B', Items.bone, 'N', Items.nether_star});
        GameRegistry.addRecipe(new ItemStack(IronTrapdoor, 1), new Object[] {"II", "II",'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(Blocks.anvil, 1, 1), new Object[] {"III", "IAI", "III", 'I', Items.iron_ingot, 'A', new ItemStack(Blocks.anvil, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Blocks.anvil, 1, 0), new Object[] {"III", "IAI", "III", 'I', Items.iron_ingot, 'A', new ItemStack(Blocks.anvil, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Items.saddle, 1), new Object[] {"LLL", "LSL", "I I", 'I', Items.iron_ingot, 'L', Items.leather, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(NetherBrickDoor, 1), new Object[] {"BB", "BB", "BB", 'B', Blocks.nether_brick});
		GameRegistry.addRecipe(new ItemStack(GlassDoor, 1), new Object[] {"BB", "BB", "BB", 'B', Blocks.glass});
		GameRegistry.addRecipe(new ItemStack(NetherBrickFenceGate, 1), new Object[] {"#B#", "#B#", 'B', Blocks.nether_brick, '#', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(BedrockBrick, 4), new Object[] {"##", "##", '#', Blocks.bedrock});
		
		/*Horse Armour*/
        GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.iron_ingot, 'C', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.gold_ingot, 'C', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor, 1), new Object[] {"  #", "#C#", "###", '#', Items.diamond, 'C', Blocks.wool});
        
		/*Nether wood planks recipes*/
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"B", "B", 'B', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), new Object[] {"BB", "BB", 'B', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] {"###", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(NetherwoodChest, 1), new Object[] {"###", "# #", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"###", "#D#", "###", '#', NetherPlanks, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(Blocks.noteblock, 1), new Object[] {"###", "#R#", "###", '#', NetherPlanks, 'R', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', NetherPlanks});

		GameRegistry.addRecipe(new ItemStack(NetherwoodDoor, 1), new Object[] {"##", "##", "##", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Items.boat, 1), new Object[] {"# #", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Items.sign, 3), new Object[] {"###", "###", "S", '#', NetherPlanks, 'S', Items.stick});

		GameRegistry.addRecipe(new ItemStack(NetherWoodSlab, 6), new Object[] {"###", '#', NetherPlanks});
		
		GameRegistry.addRecipe(new ItemStack(Items.wooden_sword, 1), new Object[] {"#", "#", "S", '#', NetherPlanks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.wooden_pickaxe, 1), new Object[] {"###", " S ", " S ", '#', NetherPlanks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[] {"##", "#S", " S", '#', NetherPlanks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.wooden_shovel, 1), new Object[] {"#", "S", "S", '#', NetherPlanks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[] {"##", " S", " S", '#', NetherPlanks, 'S', Items.stick});
		
        GameRegistry.addShapelessRecipe(new ItemStack(Items.spider_eye, 1), new Object[] {spiderMeatRaw});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 0), new Object[] {squid});

        GameRegistry.addShapelessRecipe(new ItemStack(cakeSlice, 6), new Object[] {Items.cake});
        GameRegistry.addShapelessRecipe(new ItemStack(applePie, 1), new Object[] {Items.egg, Items.apple, Items.sugar});

        
        /*Rotten flesh recipes, used as substitute for leather.*/
        GameRegistry.addRecipe(new ItemStack(Items.item_frame, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Items.stick, 'F', Items.rotten_flesh});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] {Items.paper, Items.paper, Items.paper, Items.rotten_flesh});
        
        // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
        
        //--Convert slabs and stairs to full blocks--\\
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 0), new Object[] {"SS", "SS", 'S', Blocks.oak_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 1), new Object[] {"SS", "SS", 'S', Blocks.spruce_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 2), new Object[] {"SS", "SS", 'S', Blocks.birch_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 3), new Object[] {"SS", "SS", 'S', Blocks.jungle_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 4), new Object[] {"SS", "SS", 'S', Blocks.acacia_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 5), new Object[] {"SS", "SS", 'S', Blocks.dark_oak_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 6), new Object[] {"SS", "SS", 'S', Blocks.stone_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 6), new Object[] {"SS", "SS", 'S', Blocks.sandstone_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 6), new Object[] {"SS", "SS", 'S', Blocks.brick_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 6), new Object[] {"SS", "SS", 'S', Blocks.stone_brick_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 6), new Object[] {"SS", "SS", 'S', Blocks.nether_brick_stairs});
        GameRegistry.addRecipe(new ItemStack(Blocks.quartz_block, 6), new Object[] {"SS", "SS", 'S', Blocks.quartz_stairs}); //--Quartz stairs to quartz blocks.
        GameRegistry.addRecipe(new ItemStack(EndBrickBlock, 6), new Object[] {"SS", "SS", 'S', EndBrickStair}); //--Ender Brick stairs to ender brick blocks.
        GameRegistry.addRecipe(new ItemStack(Blocks.stone, 6), new Object[] {"SS", "SS", 'S', StoneStair}); //--Smooth Stone stairs to smooth stone blocks.
        GameRegistry.addRecipe(new ItemStack(NetherPlanks, 6), new Object[] {"SS", "SS", 'S', NetherWoodStairs});

        
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 4), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 5), new Object[] {"#", "#", '#', new ItemStack(Blocks.wooden_slab, 1, 5)});
        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(Blocks.stone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 5)});
        GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 1), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, 6)});
        
        //--Dismantling objects--\\
        GameRegistry.addRecipe(new ItemStack(Items.stick, 1), new Object[] {"AA", "AA", 'A', Items.arrow});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.fence});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 6), new Object[] {Items.wooden_door});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] {Items.boat});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2), new Object[] {Items.sign});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 3), new Object[] {Items.bow});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 8), new Object[] {Blocks.chest});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 3), new Object[] {Blocks.trapdoor});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 6), new Object[] {Blocks.fence_gate});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] {Blocks.lever});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new Object[] {Blocks.ladder});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] {Blocks.crafting_table});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new Object[] {Blocks.quartz_block});
        
        
        // ~ --FURNACE RECIPES -- ~ \\

        //--Procession--\\
        GameRegistry.addSmelting(RubyOre, new ItemStack(ruby), 2.0F);
        GameRegistry.addSmelting(Blocks.end_stone, new ItemStack(EnderBrick), 1.0F); 
        GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(SoulGlass), 0.5F); 
        
        //--Cooking food--\\
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(fleshCooked), 1.0F);
        GameRegistry.addSmelting(spiderMeatRaw, new ItemStack(spiderMeatCooked), 1.0F);
        GameRegistry.addSmelting(lambchopRaw, new ItemStack(BetterCraft.lambchopCooked), 1.0F);
        GameRegistry.addSmelting(squid, new ItemStack(BetterCraft.calamari), 1.0F);
        GameRegistry.addSmelting(Items.egg, new ItemStack(BetterCraft.eggFried), 1.0F);
		
        //--Melting down--\\
        GameRegistry.addSmelting(Items.iron_door, new ItemStack(Items.iron_ingot, 6), 0.5F);
        GameRegistry.addSmelting(Items.minecart, new ItemStack(Items.iron_ingot, 5), 0.5F);
        GameRegistry.addSmelting(Items.cauldron, new ItemStack(Items.iron_ingot, 7), 0.5F);
        
        GameRegistry.registerWorldGenerator(new BetterCraftGenerator(), 1);
    }
	
    public static void oreRegistration()
    {
            //|--| Register blocks to Ore Dictionary |--|\\
    	
    		//ruby ores and blocks
    		OreDictionary.registerOre("oreRuby", RubyOre);
    		OreDictionary.registerOre("blockRuby", RubyBlock);
    		
    		//Netherwood
    		OreDictionary.registerOre("logNetherwood", NetherLog);
    		OreDictionary.registerOre("plankNetherwood", NetherPlanks);
    		OreDictionary.registerOre("leavesNetherwood", NetherLeaves);
    		OreDictionary.registerOre("saplingNetherwood", NetherSapling);
    		OreDictionary.registerOre("chestNetherwood", NetherwoodChest);
    		
    		//Ender Bricks block
    		OreDictionary.registerOre("blockEnderBricks", EndBrickBlock);
    		
    		//Blocks made from vanilla resources.
    		OreDictionary.registerOre("blockFlesh", FleshBlock);
    		OreDictionary.registerOre("blockBones", BoneBlock);
    		OreDictionary.registerOre("blockSlime", SlimeBlock);
    		OreDictionary.registerOre("blockGunpowder", GunpowderBlock);
    		OreDictionary.registerOre("blockBlaze", BlazeBlock);
    		OreDictionary.registerOre("blockEnder", EnderBlock);
    		
    		//|--| Register items to Ore Dictionary |--|\\
            OreDictionary.registerOre("gemRuby", ruby);
            OreDictionary.registerOre("boneWither", WitherBone);
            OreDictionary.registerOre("brickEnder", EnderBrick);
            
    }

	
	/*public void generateNether(World world, Random random, int blockX, int blockZ)
	{
		HellGenTrees tree = new HellGenTrees();
	
		for(int x = 0; x<8; x++)
		{
			int i = blockX + random.nextInt(128);
			int k = blockZ + random.nextInt(128);
			int j = world.getHeightValue(i, k);
			tree.generate(world, random, i, j, k);
		}
	}*/
	
	@EventHandler
	// used in 1.6.2
	// @PostInit // used in 1.5.2
	public void postInit(FMLPostInitializationEvent event) 
	{
		// Stub Method
	}
	
	/*public void generateSurface(World world, Random random, int blockCoordsX, int blockCoordsZ)
	{
		for(int k = 0; k < 10; k++) {
			int firstBlockXCoord = blockCoordsX + random.nextInt(16);
			int firstBlockYCoord = random.nextInt(64);
			int firstBlockZCoord = blockCoordsZ + random.nextInt(16);
			(new WorldGenMinable(BetterCraft.RubyOre.blockID, 16)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
	}*/
}