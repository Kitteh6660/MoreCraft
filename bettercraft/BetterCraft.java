package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.potion.Potion;
//import net.minecraft.src.ModLoader; --Deprecated.
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "BetterCraft", name = "BetterCraft", version = "2.6b3")
@NetworkMod(clientSideRequired = true)
public class BetterCraft 
{
	// The instance of your mod that Forge uses.
	@Instance(value = "BetterCraft")
	public static BetterCraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "kittehmod.bettercraft.client.ClientProxy", serverSide = "kittehmod.bettercraft.CommonProxy")
	public static CommonProxy proxy;

    public static EnumToolMaterial BONE_T = EnumHelper.addToolMaterial("BoneT", 1, 100, 4.0F, 1, 15);
    public static EnumToolMaterial WITHERBONE_T = EnumHelper.addToolMaterial("WitherBoneT", 3, 6248, 12.0F, 4, 22);
    public static EnumToolMaterial OBSIDIAN_T = EnumHelper.addToolMaterial("ObsidianT", 3, 16, 14.0F, 4, 15);
    public static EnumToolMaterial EMERALD_T = EnumHelper.addToolMaterial("EmeraldT", 3, 768, 8.0F, 3.0F, 10);
    public static EnumToolMaterial RUBY_T = EnumHelper.addToolMaterial("RubyT", 2, 500, 6.0F, 2, 21);
    public static EnumToolMaterial ENDER_T = EnumHelper.addToolMaterial("EnderT", 2, 250, 6.0F, 3, 15);
    public static EnumToolMaterial BLAZE_T = EnumHelper.addToolMaterial("BlazeT", 2, 100, 7.0F, 2, 15);
    public static EnumToolMaterial NETHERRACK_T = EnumHelper.addToolMaterial("NetherrackT", 1, 59, 3.5F, 1, 8);
    public static EnumToolMaterial ENDSTONE_T = EnumHelper.addToolMaterial("EndstoneT", 1, 188, 4.0F, 1, 5);

    public static EnumArmorMaterial SLIME_A = EnumHelper.addArmorMaterial("SlimeA", 8, new int[] { 2, 3, 2, 2 }, 20);
    public static EnumArmorMaterial FLESH_A = EnumHelper.addArmorMaterial("FleshA", 4, new int[] { 1, 3, 2, 1 }, 17);
    public static EnumArmorMaterial WEB_A = EnumHelper.addArmorMaterial("WebA", 24, new int[] { 2, 3, 3, 2 }, 15);
    public static EnumArmorMaterial BONE_A = EnumHelper.addArmorMaterial("BoneA", 12, new int[] { 2, 5, 3, 2 }, 15);
    public static EnumArmorMaterial WITHERBONE_A = EnumHelper.addArmorMaterial("WitherBoneA", 132, new int[] { 3, 8, 6, 3 }, 16);
    public static EnumArmorMaterial OBSIDIAN_A = EnumHelper.addArmorMaterial("ObsidianA", 3, new int[] { 4, 8, 6, 4 }, 28);
    public static EnumArmorMaterial EMERALD_A = EnumHelper.addArmorMaterial("EmeraldA", 28, new int[] { 3, 7, 5, 3 }, 18);
    public static EnumArmorMaterial RUBY_A = EnumHelper.addArmorMaterial("RubyA", 20, new int[] { 2, 6, 5, 2 }, 25);
    public static EnumArmorMaterial ENDER_A = EnumHelper.addArmorMaterial("EnderA", 15, new int[] { 3, 6, 5, 3 }, 15);
    public static EnumArmorMaterial BLAZE_A = EnumHelper.addArmorMaterial("BlazeA", 10, new int[] { 3, 5, 5, 3 }, 10);
    public static EnumArmorMaterial BONELORD_A = EnumHelper.addArmorMaterial("BoneLordA", 20, new int[] { 3, 6, 6, 3 }, 25);
    public static EnumArmorMaterial ENDERDRAGON_A = EnumHelper.addArmorMaterial("DragonScaleA", -1, new int[] { 4, 8, 6, 4 }, 30);
    
    public static final Block BoneBlock = new BlockStorage(176, Material.rock).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("BoneBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:BoneBlock");
    public static final Block FleshBlock = new BlockStorage(177, Material.cloth).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("FleshBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:FleshBlock");
    public static final Block doorNether = new BlockMoreDoors(178, Material.rock).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("doorNether").setTextureName("doorNether");
    public static final Block doorGlass = new BlockMoreDoors(179, Material.glass).setHardness(1.0F).setResistance(3.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("doorGlass").setTextureName("doorGlass");
    public static final Block doorNetherwood = new BlockMoreDoors(180, Material.wood).setHardness(2.5F).setResistance(7.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("doorNetherwood").setTextureName("doorNetherwood");

    public static final Block NetherBrickFenceGate = new BlockNetherBrickFenceGate(181).setHardness(2.0F).setResistance(20.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("NetherBrickFenceGate").setTextureName("NetherBrickFenceGate");
    public static final Block StoneStair = new BlockNormalStairs(182, Block.stone, 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("StoneStair").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:StoneStair");
    public static final Block RubyOre = new BlockOreRuby(183, Material.rock).setHardness(4.0F).setResistance(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("RubyOre").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:RubyOre");
    public static final Block RubyBlock = new BlockStorage(184, Material.rock).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RubyBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:RubyBlock");
    public static final Block BlazeBlock = new BlockBlazeBlock(185, 0).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundMetalFootstep).setLightValue(1.0F).setUnlocalizedName("BlazeBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:BlazeBlock");
    public static final Block EndBrickBlock = new Block(186, Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EndBrickBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:EndBrickBlock");
    public static final Block EndBrickStair = new BlockNormalStairs(187, EndBrickBlock, 0).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EndBrickBlockStair").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:EndBrickBlock");
    public static final BlockHalfSlab EndBrickSlab = (BlockHalfSlab) new BlockEnderBrickSlab(188, false, Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EndBrickSlab").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:EndBrickBlock");
    public static final BlockHalfSlab EndBrickSlabFull = (BlockHalfSlab) new BlockEnderBrickSlab(189, true, Material.rock).setHardness(10.0F).setResistance(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EndBrickSlab").setTextureName("bettercraft:EndBrickBlock");
    public static final Block IronTrapdoor = new BlockIronTrapdoor(190, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("trapdoorIron").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:trapdoorIron");
    public static final Block NetherLog = new BlockNetherLog(191).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherLog").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:NetherLog");
    public static final Block NetherPlanks = new BlockNetherWood(192, 0).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherPlanks").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:NetherPlanks");
    public static final BlockNetherLeaves NetherLeaves = (BlockNetherLeaves) new BlockNetherLeaves(193).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("NetherLeaves").setCreativeTab(CreativeTabs.tabDecorations).setTextureName("bettercraft:NetherLeaves");   
    public static final Block NetherSapling = new BlockNetherSapling(194).setHardness(0F).setResistance(1.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("NetherSapling").setCreativeTab(CreativeTabs.tabDecorations).setTextureName("bettercraft:NetherSapling");
    public static final Block NetherWoodStairs = new BlockNormalStairs(195, NetherPlanks, 0).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherPlanksStair").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:NetherPlanksStair");
    public static final BlockHalfSlab NetherWoodSlab = (BlockHalfSlab) new BlockNetherwoodSlab(196, false, Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherPlanksSlab").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:NetherPlanks");
    public static final BlockHalfSlab NetherWoodSlabFull = (BlockHalfSlab) new BlockNetherwoodSlab(197, true, Material.wood).setHardness(3.0F).setResistance(8.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherPlanksSlab").setTextureName("bettercraft:NetherPlanksSlab");
    public static final Block SoulGlass = new BlockSoulGlass(198, Material.glass, false).setHardness(0.5F).setResistance(15.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("SoulGlass").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:SoulGlass");
    public static final Block NetherwoodChest = new BlockNetherwoodChest(199, 2).setHardness(2.5F).setResistance(7.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("NetherwoodChest").setCreativeTab(CreativeTabs.tabDecorations);    
    public static final Block EnderBlock = new BlockStorage(200, Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EnderBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:EnderBlock");    
    public static final Block GunpowderBlock = new BlockSand(201).setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("GunpowderBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:GunpowderBlock");    
    public static final Block SlimeBlock = new BlockSlimeBlock(202, Material.sand).setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("SlimeBlock").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:SlimeBlock");    
    public static final Block BedrockBrick = new BlockBedrockBricks(203, Material.rock).setBlockUnbreakable().setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("BedrockBrick").setCreativeTab(CreativeTabs.tabBlock).setTextureName("bettercraft:BedrockBrick");    
    //ID 203-210 reserved for additional blocks.
    
    
    //--LIST OF ITEMS
    public static final Item fleshCooked = (new ItemFood(6600, 8, 0.8F, true)).setPotionEffect(Potion.confusion.id, 20, 0, 0.1F).setUnlocalizedName("CookedFlesh").setTextureName("bettercraft:CookedFlesh");
    public static final Item spiderMeatRaw = (new ItemFood(6601, 3, 0.3F, true)).setPotionEffect(Potion.poison.id, 5, 0, 0.5F).setPotionEffect(Potion.confusion.id, 30, 0, 0.1F).setPotionEffect(Potion.blindness.id, 30, 0, 0.1F).setUnlocalizedName("RawSpiderMeat").setTextureName("bettercraft:RawSpiderMeat");
    public static final Item spiderMeatCooked = (new ItemFood(6602, 7, 0.7F, true)).setPotionEffect(Potion.confusion.id, 30, 0, 0.05F).setPotionEffect(Potion.confusion.id, 15, 0, 0.02F).setUnlocalizedName("CookedSpiderMeat").setTextureName("bettercraft:CookedSpiderMeat");
    public static final Item applePie = (new ItemFood(6603, 8, 0.8F, false)).setPotionEffect(Potion.heal.id, 0, 0, 1.0F).setUnlocalizedName("ApplePie").setTextureName("bettercraft:ApplePie");
    public static final Item cakeSlice = (new ItemFood(6604, 2, 0.3F, false)).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.25F).setUnlocalizedName("CakeSlice").setTextureName("bettercraft:CakeSlice");
    public static final Item squid = (new ItemFood(6605, 3, 0.3F, false)).setPotionEffect(Potion.harm.id, 0, 0, 0.3F).setUnlocalizedName("RawSquid").setTextureName("bettercraft:RawSquid");
    public static final Item calamari = (new ItemFood(6606, 6, 0.6F, false)).setUnlocalizedName("CookedSquid").setTextureName("bettercraft:CookedSquid");
    public static final Item lambchopRaw = (new ItemFood(6607, 3, 0.3F, true)).setUnlocalizedName("LambChopRaw").setTextureName("bettercraft:LambChopRaw");
    public static final Item lambchopCooked = (new ItemFood(6608, 8, 0.8F, true)).setUnlocalizedName("LambChopCooked").setTextureName("bettercraft:LambChopCooked");
    public static final Item eggFried = (new ItemFood(6609, 6, 0.5F, false)).setUnlocalizedName("FriedEgg").setTextureName("bettercraft:FriedEgg");
    //ID 6610-6629 reserved for more food.
    
    public static final Item EnderBrick = (new Item(6630)).setUnlocalizedName("EnderBrick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bettercraft:EnderBrick");
    public static final Item NetherBrickDoor = (new ItemMoreDoors(6631, doorNether)).setUnlocalizedName("doorNether").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorNether");
    public static final Item GlassDoor = (new ItemMoreDoors(6632, doorGlass)).setUnlocalizedName("doorGlass").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorGlass");
    public static final Item NetherwoodDoor = (new ItemMoreDoors(6633, doorNetherwood)).setUnlocalizedName("doorNetherwood").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("bettercraft:doorNetherwood");
    //ID 6634-6639 reserved for more doors.
    
    //ID 6640-6643 reserved for four additional horse armors.
    //public static final Item HorseArmorBone = (new Item(6640)).setUnlocalizedName("horseArmorBone").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/bone_horse_armor");
    //public static final Item HorseArmorEmerald = (new Item(6641)).setUnlocalizedName("horseArmorEmerald").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/emerald_horse_armor");
    //public static final Item HorseArmorRuby = (new Item(6642)).setUnlocalizedName("horseArmorRuby").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/ruby_horse_armor");
    //public static final Item HorseArmorObsidian = (new Item(6643)).setUnlocalizedName("horseArmorObsidian").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("bettercraft:entity/horse/obsidian_horse_armor");
    
    //ID 6644-6647 reserved for one additional armour set.
    
    public static final Item SlimeHelmet = new ItemSlimeArmor(6638, SLIME_A, 4, 0, "slime", Item.slimeBall.itemID).setUnlocalizedName("SlimeHelmet").setTextureName("bettercraft:SlimeHelmet");
    public static final Item SlimeBody = new ItemSlimeArmor(6639, SLIME_A, 4, 1, "slime", Item.slimeBall.itemID).setUnlocalizedName("SlimeChestplate").setTextureName("bettercraft:SlimeChestplate");
    public static final Item SlimeLegs = new ItemSlimeArmor(6640, SLIME_A, 4, 2, "slime", Item.slimeBall.itemID).setUnlocalizedName("SlimeLeggings").setTextureName("bettercraft:SlimeLeggings");
    public static final Item SlimeBoots = new ItemSlimeArmor(6641, SLIME_A, 4, 3, "slime", Item.slimeBall.itemID).setUnlocalizedName("SlimeBoots").setTextureName("bettercraft:SlimeBoots");
    
    public static final Item FleshHelmet = new ItemNormalArmor(6642, FLESH_A, 4, 0, "flesh", Item.rottenFlesh.itemID).setUnlocalizedName("FleshHelmet").setTextureName("bettercraft:FleshHelmet");
    public static final Item FleshBody = new ItemNormalArmor(6643, FLESH_A, 4, 1, "flesh", Item.rottenFlesh.itemID).setUnlocalizedName("FleshChestplate").setTextureName("bettercraft:FleshChestplate");
    public static final Item FleshLegs = new ItemNormalArmor(6644, FLESH_A, 4, 2, "flesh", Item.rottenFlesh.itemID).setUnlocalizedName("FleshLeggings").setTextureName("bettercraft:FleshLeggings");
    public static final Item FleshBoots = new ItemNormalArmor(6645, FLESH_A, 4, 3, "flesh", Item.rottenFlesh.itemID).setUnlocalizedName("FleshBoots").setTextureName("bettercraft:FleshBoots");
	
    public static final Item CobwebHelmet = new ItemNormalArmor(6646, WEB_A, 4, 0, "cobweb", Block.web.blockID).setUnlocalizedName("WebHelmet").setTextureName("bettercraft:WebHelmet");
    public static final Item CobwebBody = new ItemNormalArmor(6647, WEB_A, 4, 1, "cobweb", Block.web.blockID).setUnlocalizedName("WebChestplate").setTextureName("bettercraft:WebChestplate");
    public static final Item CobwebLegs = new ItemNormalArmor(6648, WEB_A, 4, 2, "cobweb", Block.web.blockID).setUnlocalizedName("WebLeggings").setTextureName("bettercraft:WebLeggings");
    public static final Item CobwebBoots = new ItemNormalArmor(6649, WEB_A, 4, 3, "cobweb", Block.web.blockID).setUnlocalizedName("WebBoots").setTextureName("bettercraft:WebBoots");
    
    public static final Item ObsidianPickaxe = new ItemNormalPickaxe(6651, OBSIDIAN_T, Block.obsidian.blockID).setUnlocalizedName("ObsidianPickaxe").setTextureName("bettercraft:ObsidianPickaxe");
    public static final Item ObsidianAxe = new ItemNormalAxe(6652, OBSIDIAN_T, Block.obsidian.blockID).setUnlocalizedName("ObsidianAxe").setTextureName("bettercraft:ObsidianAxe");
    public static final Item ObsidianShovel = new ItemNormalSpade(6653, OBSIDIAN_T, Block.obsidian.blockID).setUnlocalizedName("ObsidianShovel").setTextureName("bettercraft:ObsidianShovel");
    public static final Item ObsidianHoe = new ItemNormalHoe(6654, OBSIDIAN_T, Block.obsidian.blockID).setUnlocalizedName("ObsidianHoe").setTextureName("bettercraft:ObsidianHoe");
    public static final Item ObsidianSword = new ItemNormalSword(6655, OBSIDIAN_T, Block.obsidian.blockID).setUnlocalizedName("ObsidianSword").setTextureName("bettercraft:ObsidianSword");
    
    public static final Item ObsidianHelmet = new ItemNormalArmor(6656, OBSIDIAN_A, 4, 0, "obsidian", Block.obsidian.blockID).setUnlocalizedName("ObsidianHelmet").setTextureName("bettercraft:ObsidianHelmet");
    public static final Item ObsidianBody =  new ItemNormalArmor(6657, OBSIDIAN_A, 4, 1, "obsidian", Block.obsidian.blockID).setUnlocalizedName("ObsidianChestplate").setTextureName("bettercraft:ObsidianChestplate");
    public static final Item ObsidianLegs =  new ItemNormalArmor(6658, OBSIDIAN_A, 4, 2, "obsidian", Block.obsidian.blockID).setUnlocalizedName("ObsidianLeggings").setTextureName("bettercraft:ObsidianLeggings");
    public static final Item ObsidianBoots =  new ItemNormalArmor(6659, OBSIDIAN_A, 4, 3, "obsidian", Block.obsidian.blockID).setUnlocalizedName("ObsidianBoots").setTextureName("bettercraft:ObsidianBoots");
    
    public static final Item BonePickaxe = new ItemNormalPickaxe(6671, BONE_T, Item.bone.itemID).setUnlocalizedName("BonePickaxe").setTextureName("bettercraft:BonePickaxe");
    public static final Item BoneAxe = new ItemNormalAxe(6672, BONE_T, Item.bone.itemID).setUnlocalizedName("BoneAxe").setTextureName("bettercraft:BoneAxe");
    public static final Item BoneShovel = new ItemNormalSpade(6673, BONE_T, Item.bone.itemID).setUnlocalizedName("BoneShovel").setTextureName("bettercraft:BoneShovel");
    public static final Item BoneHoe = new ItemNormalHoe(6674, BONE_T, Item.bone.itemID).setUnlocalizedName("BoneHoe").setTextureName("bettercraft:BoneHoe");
    public static final Item BoneSword = new ItemNormalSword(6675, BONE_T, Item.bone.itemID).setUnlocalizedName("BoneSword").setTextureName("bettercraft:BoneSword");
    
    public static final Item BoneHelmet = new ItemNormalArmor(6676, BONE_A, 4, 0, "bone", Item.bone.itemID).setUnlocalizedName("BoneHelmet").setTextureName("bettercraft:BoneHelmet");
    public static final Item BoneBody = new ItemNormalArmor(6677, BONE_A, 4, 1, "bone", Item.bone.itemID).setUnlocalizedName("BoneChestplate").setTextureName("bettercraft:BoneChestplate");
    public static final Item BoneLegs = new ItemNormalArmor(6678, BONE_A, 4, 2, "bone", Item.bone.itemID).setUnlocalizedName("BoneLeggings").setTextureName("bettercraft:BoneLeggings");
    public static final Item BoneBoots = new ItemNormalArmor(6679, BONE_A, 4, 3, "bone", Item.bone.itemID).setUnlocalizedName("BoneBoots").setTextureName("bettercraft:BoneBoots");
    
    public static final Item WitherBone = new Item(6680).setUnlocalizedName("WitherBone").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bettercraft:WitherBone");

    public static final Item WitherBonePickaxe = new ItemNormalPickaxe(6681, WITHERBONE_T, WitherBone.itemID).setUnlocalizedName("WitherBonePickaxe").setTextureName("bettercraft:WitherBonePickaxe");
    public static final Item WitherBoneAxe = new ItemNormalAxe(6682, WITHERBONE_T, WitherBone.itemID).setUnlocalizedName("WitherBoneAxe").setTextureName("bettercraft:WitherBoneAxe");
    public static final Item WitherBoneShovel = new ItemNormalSpade(6683, WITHERBONE_T, WitherBone.itemID).setUnlocalizedName("WitherBoneShovel").setTextureName("bettercraft:WitherBoneShovel");
    public static final Item WitherBoneHoe = new ItemNormalHoe(6684, WITHERBONE_T, WitherBone.itemID).setUnlocalizedName("WitherBoneHoe").setTextureName("bettercraft:WitherBoneHoe");
    public static final Item WitherBoneSword = new ItemWitherSword(6685, WITHERBONE_T, WitherBone.itemID).setUnlocalizedName("WitherBoneSword").setTextureName("bettercraft:WitherBoneSword");
    
    public static final Item WitherBoneHelmet = new ItemNormalArmor(6686, WITHERBONE_A, 4, 0, "witherbone", WitherBone.itemID).setUnlocalizedName("WitherBoneHelmet").setTextureName("bettercraft:WitherBoneHelmet");
    public static final Item WitherBoneBody = new ItemNormalArmor(6687, WITHERBONE_A, 4, 1, "witherbone", WitherBone.itemID).setUnlocalizedName("WitherBoneChestplate").setTextureName("bettercraft:WitherBoneChestplate");
    public static final Item WitherBoneLegs = new ItemNormalArmor(6688, WITHERBONE_A, 4, 2, "witherbone", WitherBone.itemID).setUnlocalizedName("WitherBoneLeggings").setTextureName("bettercraft:WitherBoneLeggings");
    public static final Item WitherBoneBoots = new ItemNormalArmor(6689, WITHERBONE_A, 4, 3, "witherbone", WitherBone.itemID).setUnlocalizedName("WitherBoneBoots").setTextureName("bettercraft:WitherBoneBoots");

    public static final Item EmeraldPickaxe = new ItemNormalPickaxe(6691, EMERALD_T, Item.emerald.itemID).setUnlocalizedName("EmeraldPickaxe").setTextureName("bettercraft:EmeraldPickaxe");
    public static final Item EmeraldAxe = new ItemNormalAxe(6692, EnumToolMaterial.EMERALD, Item.emerald.itemID).setUnlocalizedName("EmeraldAxe").setTextureName("bettercraft:EmeraldAxe");
    public static final Item EmeraldShovel = new ItemNormalSpade(6693, EnumToolMaterial.EMERALD, Item.emerald.itemID).setUnlocalizedName("EmeraldShovel").setTextureName("bettercraft:EmeraldShovel");
    public static final Item EmeraldHoe = new ItemNormalHoe(6694, EnumToolMaterial.EMERALD, Item.emerald.itemID).setUnlocalizedName("EmeraldHoe").setTextureName("bettercraft:EmeraldHoe");
    public static final Item EmeraldSword = new ItemNormalSword(6695, EnumToolMaterial.EMERALD, Item.emerald.itemID).setUnlocalizedName("EmeraldSword").setTextureName("bettercraft:EmeraldSword");
    
    public static final Item EmeraldHelmet = new ItemNormalArmor(6696, EMERALD_A, 4, 0, "emerald", Item.emerald.itemID).setUnlocalizedName("EmeraldHelmet").setTextureName("bettercraft:EmeraldHelmet");
    public static final Item EmeraldBody = new ItemNormalArmor(6697, EMERALD_A, 4, 1, "emerald", Item.emerald.itemID).setUnlocalizedName("EmeraldChestplate").setTextureName("bettercraft:EmeraldChestplate");
    public static final Item EmeraldLegs = new ItemNormalArmor(6698, EMERALD_A, 4, 2, "emerald", Item.emerald.itemID).setUnlocalizedName("EmeraldLeggings").setTextureName("bettercraft:EmeraldLeggings");
    public static final Item EmeraldBoots = new ItemNormalArmor(6699, EMERALD_A, 4, 3, "emerald", Item.emerald.itemID).setUnlocalizedName("EmeraldBoots").setTextureName("bettercraft:EmeraldBoots");

    public static final Item Ruby = (new Item(6700)).setUnlocalizedName("ruby").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("ruby");    

    public static final Item RubyPickaxe = new ItemNormalPickaxe(6701, RUBY_T, Ruby.itemID).setUnlocalizedName("RubyPickaxe").setTextureName("bettercraft:RubyPickaxe");
    public static final Item RubyAxe = new ItemNormalAxe(6702, RUBY_T, Ruby.itemID).setUnlocalizedName("RubyAxe").setTextureName("bettercraft:RubyAxe");
    public static final Item RubyShovel = new ItemNormalSpade(6703, RUBY_T, Ruby.itemID).setUnlocalizedName("RubyShovel").setTextureName("bettercraft:RubyShovel");
    public static final Item RubyHoe = new ItemNormalHoe(6704, RUBY_T, Ruby.itemID).setUnlocalizedName("RubyHoe").setTextureName("bettercraft:RubyHoe");
    public static final Item RubySword = new ItemNormalSword(6705, RUBY_T, Ruby.itemID).setUnlocalizedName("RubySword").setTextureName("bettercraft:RubySword");
    
    public static final Item RubyHelmet = new ItemNormalArmor(6706, RUBY_A, 4, 0, "ruby", Ruby.itemID).setUnlocalizedName("RubyHelmet").setTextureName("bettercraft:RubyHelmet");
    public static final Item RubyBody = new ItemNormalArmor(6707, RUBY_A, 4, 1, "ruby", Ruby.itemID).setUnlocalizedName("RubyChestplate").setTextureName("bettercraft:RubyChestplate");
    public static final Item RubyLegs = new ItemNormalArmor(6708, RUBY_A, 4, 2, "ruby", Ruby.itemID).setUnlocalizedName("RubyLeggings").setTextureName("bettercraft:RubyLeggings");
    public static final Item RubyBoots = new ItemNormalArmor(6709, RUBY_A, 4, 3, "ruby", Ruby.itemID).setUnlocalizedName("RubyBoots").setTextureName("bettercraft:RubyBoots");
    
    public static final Item BlazePickaxe = new ItemNormalPickaxe(6711, BLAZE_T, Item.blazeRod.itemID).setUnlocalizedName("BlazePickaxe").setTextureName("bettercraft:BlazePickaxe");
    public static final Item BlazeAxe = new ItemNormalAxe(6712, BLAZE_T, Item.blazeRod.itemID).setUnlocalizedName("BlazeAxe").setTextureName("bettercraft:BlazeAxe");
    public static final Item BlazeShovel = new ItemNormalSpade(6713, BLAZE_T, Item.blazeRod.itemID).setUnlocalizedName("BlazeShovel").setTextureName("bettercraft:BlazeShovel");
    public static final Item BlazeHoe = new ItemNormalHoe(6714, BLAZE_T, Item.blazeRod.itemID).setUnlocalizedName("BlazeHoe").setTextureName("bettercraft:BlazeHoe");
    public static final Item BlazeSword = new ItemBlazeSword(6715, BLAZE_T, Item.blazeRod.itemID).setUnlocalizedName("BlazeSword").setTextureName("bettercraft:BlazeSword");
    
    public static final Item BlazeHelmet = new ItemNormalArmor(6716, BLAZE_A, 4, 0, "blaze", Item.blazeRod.itemID).setUnlocalizedName("BlazeHelmet").setTextureName("bettercraft:BlazeHelmet");
    public static final Item BlazeBody = new ItemNormalArmor(6717, BLAZE_A, 4, 1, "blaze", Item.blazeRod.itemID).setUnlocalizedName("BlazeChestplate").setTextureName("bettercraft:BlazeChestplate");
    public static final Item BlazeLegs = new ItemNormalArmor(6718, BLAZE_A, 4, 2, "blaze", Item.blazeRod.itemID).setUnlocalizedName("BlazeLeggings").setTextureName("bettercraft:BlazeLeggings");
    public static final Item BlazeBoots = new ItemNormalArmor(6719, BLAZE_A, 4, 3, "blaze", Item.blazeRod.itemID).setUnlocalizedName("BlazeBoots").setTextureName("bettercraft:BlazeBoots");

    public static final Item EnderPickaxe = new ItemNormalPickaxe(6721, ENDER_T, Item.enderPearl.itemID).setUnlocalizedName("EnderPickaxe").setTextureName("bettercraft:EnderPickaxe");
    public static final Item EnderAxe = new ItemNormalAxe(6722, ENDER_T, Item.enderPearl.itemID).setUnlocalizedName("EnderAxe").setTextureName("bettercraft:EnderAxe");
    public static final Item EnderShovel = new ItemNormalSpade(6723, ENDER_T, Item.enderPearl.itemID).setUnlocalizedName("EnderShovel").setTextureName("bettercraft:EnderShovel");
    public static final Item EnderHoe = new ItemNormalHoe(6724, ENDER_T, Item.enderPearl.itemID).setUnlocalizedName("EnderHoe").setTextureName("bettercraft:EnderHoe");
    public static final Item EnderSword = new ItemNormalSword(6725, ENDER_T, Item.enderPearl.itemID).setUnlocalizedName("EnderSword").setTextureName("bettercraft:EnderSword");
    
    public static final Item EnderHelmet = new ItemNormalArmor(6726, ENDER_A, 4, 0, "ender", Item.enderPearl.itemID).setUnlocalizedName("EnderHelmet").setTextureName("bettercraft:EnderHelmet");
    public static final Item EnderBody = new ItemNormalArmor(6727, ENDER_A, 4, 1, "ender", Item.enderPearl.itemID).setUnlocalizedName("EnderChestplate").setTextureName("bettercraft:EnderChestplate");
    public static final Item EnderLegs = new ItemNormalArmor(6728, ENDER_A, 4, 2, "ender", Item.enderPearl.itemID).setUnlocalizedName("EnderLeggings").setTextureName("bettercraft:EnderLeggings");
    public static final Item EnderBoots = new ItemNormalArmor(6729, ENDER_A, 4, 3, "ender", Item.enderPearl.itemID).setUnlocalizedName("EnderBoots").setTextureName("bettercraft:EnderBoots");
    
    public static final Item EndstonePickaxe = new ItemNormalPickaxe(6731, ENDSTONE_T, Block.whiteStone.blockID).setUnlocalizedName("EndstonePickaxe").setTextureName("bettercraft:EndstonePickaxe");
    public static final Item EndstoneAxe = new ItemNormalAxe(6732, ENDSTONE_T, Block.whiteStone.blockID).setUnlocalizedName("EndstoneAxe").setTextureName("bettercraft:EndstoneAxe");
    public static final Item EndstoneShovel = new ItemNormalSpade(6733, ENDSTONE_T, Block.whiteStone.blockID).setUnlocalizedName("EndstoneShovel").setTextureName("bettercraft:EndstoneShovel");
    public static final Item EndstoneHoe = new ItemNormalHoe(6734, ENDSTONE_T, Block.whiteStone.blockID).setUnlocalizedName("EndstoneHoe").setTextureName("bettercraft:EndstoneHoe");
    public static final Item EndstoneSword = new ItemNormalSword(6735, ENDSTONE_T, Block.whiteStone.blockID).setUnlocalizedName("EndstoneSword").setTextureName("bettercraft:EndstoneSword");

    public static final Item NetherrackPickaxe = new ItemNormalPickaxe(6736, NETHERRACK_T, Block.netherrack.blockID).setUnlocalizedName("NetherrackPickaxe").setTextureName("bettercraft:NetherrackPickaxe");
    public static final Item NetherrackAxe = new ItemNormalAxe(6737, NETHERRACK_T, Block.netherrack.blockID).setUnlocalizedName("NetherrackAxe").setTextureName("bettercraft:NetherrackAxe");
    public static final Item NetherrackShovel = new ItemNormalSpade(6738, NETHERRACK_T, Block.netherrack.blockID).setUnlocalizedName("NetherrackShovel").setTextureName("bettercraft:NetherrackShovel");
    public static final Item NetherrackHoe = new ItemNormalHoe(6739, NETHERRACK_T, Block.netherrack.blockID).setUnlocalizedName("NetherrackHoe").setTextureName("bettercraft:NetherrackHoe");
    public static final Item NetherrackSword = new ItemNormalSword(6740, NETHERRACK_T, Block.netherrack.blockID).setUnlocalizedName("NetherrackSword").setTextureName("bettercraft:NetherrackSword");
    
    public static final Item NecroHelmet = new ItemBonelordArmor(6741, BONELORD_A, 4, 0, "necro", Item.bone.itemID).setUnlocalizedName("NecroHelmet").setTextureName("bettercraft:NecroHelmet");
    public static final Item NecroBody = new ItemBonelordArmor(6742, BONELORD_A, 4, 1, "necro", Item.bone.itemID).setUnlocalizedName("NecroChestplate").setTextureName("bettercraft:NecroChestplate");
    public static final Item NecroLegs = new ItemBonelordArmor(6743, BONELORD_A, 4, 2, "necro", Item.bone.itemID).setUnlocalizedName("NecroLeggings").setTextureName("bettercraft:NecroLeggings");
    public static final Item NecroBoots = new ItemBonelordArmor(6744, BONELORD_A, 4, 3, "necro", Item.bone.itemID).setUnlocalizedName("NecroBoots").setTextureName("bettercraft:NecroBoots");

    public static final Item DragonscaleHelmet = new ItemEnderArmor(6745, ENDERDRAGON_A, 4, 0, "enderdragon").setUnlocalizedName("EnderdragonHelmet").setTextureName("bettercraft:EnderdragonHelmet");
    public static final Item DragonscaleBody = new ItemEnderArmor(6746, ENDERDRAGON_A, 4, 1, "enderdragon").setUnlocalizedName("EnderdragonChestplate").setTextureName("bettercraft:EnderdragonChestplate");
    public static final Item DragonscaleLegs = new ItemEnderArmor(6747, ENDERDRAGON_A, 4, 2, "enderdragon").setUnlocalizedName("EnderdragonLeggings").setTextureName("bettercraft:EnderdragonLeggings");
    public static final Item DragonscaleBoots = new ItemEnderArmor(6748, ENDERDRAGON_A, 4, 3, "enderdragon").setUnlocalizedName("EnderdragonBoots").setTextureName("bettercraft:EnderdragonBoots");
    
    
    
	@EventHandler
	// used in 1.6.2
	// @PreInit // used in 1.5.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new EnderdragonDrop());
		MinecraftForge.EVENT_BUS.register(new MobDrop());
		MinecraftForge.EVENT_BUS.register(new BonemealUsage());
	}

	@EventHandler
	// used in 1.6.2
	// @Init // used in 1.5.2
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
    	GameRegistry.registerBlock(BoneBlock, "blockBone");
    	GameRegistry.registerBlock(FleshBlock, "blockFlesh");
    	GameRegistry.registerBlock(StoneStair, "stairStone");
    	GameRegistry.registerBlock(doorNether, "doorNether");
    	GameRegistry.registerBlock(doorGlass, "doorGlass");
    	GameRegistry.registerBlock(doorNetherwood, "doorNetherwood");
    	GameRegistry.registerBlock(NetherBrickFenceGate, "netherBrickGate");
    	GameRegistry.registerBlock(RubyOre, "oreRuby");
    	GameRegistry.registerBlock(RubyBlock, "blockRuby");
    	GameRegistry.registerBlock(BlazeBlock, "blockBlaze");
    	GameRegistry.registerBlock(EndBrickBlock, "enderBrick");
    	GameRegistry.registerBlock(EndBrickStair, "stairsEnderBrick");
    	GameRegistry.registerBlock(EndBrickSlab, "slabEnderBrick");
    	GameRegistry.registerBlock(EndBrickSlabFull, "slabEnderBrickFull");
    	GameRegistry.registerBlock(IronTrapdoor, "trapdoorIron");
    	GameRegistry.registerBlock(NetherLog, "netherWood");
    	GameRegistry.registerBlock(NetherPlanks, "netherPlanks");
    	GameRegistry.registerBlock(NetherLeaves, "netherLeaves");
    	GameRegistry.registerBlock(NetherSapling, "netherSapling");
    	GameRegistry.registerBlock(NetherWoodStairs, "stairsNetherwood");
    	GameRegistry.registerBlock(NetherWoodSlab, "slabNetherwood");
    	GameRegistry.registerBlock(NetherWoodSlabFull, "slabNetherwoodFull");
    	GameRegistry.registerBlock(SoulGlass, "soulGlass");
    	GameRegistry.registerBlock(NetherwoodChest, "chestNetherwood");
    	GameRegistry.registerBlock(EnderBlock, "blockEnder");  
    	GameRegistry.registerBlock(GunpowderBlock, "blockGunpowder");
    	GameRegistry.registerBlock(SlimeBlock, "blockSlime");
    	GameRegistry.registerBlock(BedrockBrick, "bedrockBricks");

        LanguageRegistry.addName(BoneBlock, "Block of Bones");
        LanguageRegistry.addName(FleshBlock, "Block of Rotten Flesh");
        LanguageRegistry.addName(StoneStair, "Stone Stairs");
        LanguageRegistry.addName(RubyOre, "Ruby Ore");
        LanguageRegistry.addName(RubyBlock, "Block of Ruby");
        LanguageRegistry.addName(BlazeBlock, "Blazing Block");
        LanguageRegistry.addName(EndBrickBlock, "Ender Brick");
        LanguageRegistry.addName(EndBrickStair, "Ender Brick Stairs");
        LanguageRegistry.addName(EndBrickSlab, "Ender Brick Slab");
        LanguageRegistry.addName(EndBrickSlabFull, "Ender Brick Slab");
        LanguageRegistry.addName(IronTrapdoor, "Iron Trapdoor");
        LanguageRegistry.addName(NetherLog, "Netherwood Wood");
        LanguageRegistry.addName(NetherPlanks, "Netherwood Planks");
        LanguageRegistry.addName(NetherLeaves, "Netherwood Leaves");
        LanguageRegistry.addName(NetherSapling, "Netherwood Sapling");
        LanguageRegistry.addName(NetherWoodStairs, "Netherwood Stairs");
        LanguageRegistry.addName(NetherWoodSlab, "Netherwood Slab");
        LanguageRegistry.addName(NetherWoodSlabFull, "Netherwood Slab");
        LanguageRegistry.addName(SoulGlass, "Soul Glass");
        LanguageRegistry.addName(NetherwoodChest, "Netherwood Chest");
        LanguageRegistry.addName(EnderBlock, "Ender Block");
        LanguageRegistry.addName(GunpowderBlock, "Block of Gunpowder");
        LanguageRegistry.addName(SlimeBlock, "Block of Slime");
        LanguageRegistry.addName(BedrockBrick, "Bedrock Brick");

        LanguageRegistry.addName(fleshCooked, "Cooked Flesh");
        LanguageRegistry.addName(spiderMeatRaw, "Spider");
        LanguageRegistry.addName(spiderMeatCooked, "Fried Spider");
        LanguageRegistry.addName(applePie, "Apple Pie");
        LanguageRegistry.addName(cakeSlice, "Cake Slice");
        LanguageRegistry.addName(squid, "Squid");
        LanguageRegistry.addName(calamari, "Calamari");
        LanguageRegistry.addName(lambchopRaw, "Raw Lambchop");
        LanguageRegistry.addName(lambchopCooked, "Cooked Lambchop");
        LanguageRegistry.addName(eggFried, "Fried Egg");

        LanguageRegistry.addName(NetherBrickDoor, "Nether Brick Door");
        LanguageRegistry.addName(GlassDoor, "Glass Door");
        LanguageRegistry.addName(NetherwoodDoor, "Netherwood Door");
        
        LanguageRegistry.addName(NetherBrickFenceGate, "Nether Brick Fence Gate");
        
        LanguageRegistry.addName(BonePickaxe, "Bone Pickaxe");
        LanguageRegistry.addName(BoneAxe, "Bone Axe");
        LanguageRegistry.addName(BoneShovel, "Bone Shovel");
        LanguageRegistry.addName(BoneHoe, "Bone Hoe");
        LanguageRegistry.addName(BoneSword, "Bone Sword");
        LanguageRegistry.addName(BoneHelmet, "Bone Helmet");
        LanguageRegistry.addName(BoneBody, "Bone Chestplate");
        LanguageRegistry.addName(BoneLegs, "Bone Leggings");
        LanguageRegistry.addName(BoneBoots, "Bone Boots");
        
        LanguageRegistry.addName(ObsidianPickaxe, "Obsidian Pickaxe");
        LanguageRegistry.addName(ObsidianAxe, "Obsidian Axe");
        LanguageRegistry.addName(ObsidianShovel, "Obsidian Shovel");
        LanguageRegistry.addName(ObsidianHoe, "Obsidian Hoe");
        LanguageRegistry.addName(ObsidianSword, "Obsidian Sword");
        LanguageRegistry.addName(ObsidianHelmet, "Obsidian Helmet");
        LanguageRegistry.addName(ObsidianBody, "Obsidian Chestplate");
        LanguageRegistry.addName(ObsidianLegs, "Obsidian Leggings");
        LanguageRegistry.addName(ObsidianBoots, "Obsidian Boots");
        
        LanguageRegistry.addName(WitherBone, "Wither Bone");
        LanguageRegistry.addName(WitherBonePickaxe, "\u00a76Wither Pickaxe");
        LanguageRegistry.addName(WitherBoneAxe, "\u00a76Wither Axe");
        LanguageRegistry.addName(WitherBoneShovel, "\u00a76Wither Shovel");
        LanguageRegistry.addName(WitherBoneHoe, "\u00a76Wither Hoe");
        LanguageRegistry.addName(WitherBoneSword, "\u00a76Wither Sword");
        LanguageRegistry.addName(WitherBoneHelmet, "\u00a76Wither Helmet");
        LanguageRegistry.addName(WitherBoneBody, "\u00a76Wither Chestplate");
        LanguageRegistry.addName(WitherBoneLegs, "\u00a76Wither Leggings");
        LanguageRegistry.addName(WitherBoneBoots, "\u00a76Wither Boots");

        LanguageRegistry.addName(EmeraldPickaxe, "Emerald Pickaxe");
        LanguageRegistry.addName(EmeraldAxe, "Emerald Axe");
        LanguageRegistry.addName(EmeraldShovel, "Emerald Shovel");
        LanguageRegistry.addName(EmeraldHoe, "Emerald Hoe");
        LanguageRegistry.addName(EmeraldSword, "Emerald Sword");
        LanguageRegistry.addName(EmeraldHelmet, "Emerald Helmet");
        LanguageRegistry.addName(EmeraldBody, "Emerald Chestplate");
        LanguageRegistry.addName(EmeraldLegs, "Emerald Leggings");
        LanguageRegistry.addName(EmeraldBoots, "Emerald Boots");

        LanguageRegistry.addName(RubyPickaxe, "Ruby Pickaxe");
        LanguageRegistry.addName(RubyAxe, "Ruby Axe");
        LanguageRegistry.addName(RubyShovel, "Ruby Shovel");
        LanguageRegistry.addName(RubyHoe, "Ruby Hoe");
        LanguageRegistry.addName(RubySword, "Ruby Sword");
        LanguageRegistry.addName(RubyHelmet, "Ruby Helmet");
        LanguageRegistry.addName(RubyBody, "Ruby Chestplate");
        LanguageRegistry.addName(RubyLegs, "Ruby Leggings");
        LanguageRegistry.addName(RubyBoots, "Ruby Boots");
        
        LanguageRegistry.addName(BlazePickaxe, "Blaze Pickaxe");
        LanguageRegistry.addName(BlazeAxe, "Blaze Axe");
        LanguageRegistry.addName(BlazeShovel, "Blaze Shovel");
        LanguageRegistry.addName(BlazeHoe, "Blaze Hoe");
        LanguageRegistry.addName(BlazeSword, "Blaze Sword");
        LanguageRegistry.addName(BlazeHelmet, "Blaze Helmet");
        LanguageRegistry.addName(BlazeBody, "Blaze Chestplate");
        LanguageRegistry.addName(BlazeLegs, "Blaze Leggings");
        LanguageRegistry.addName(BlazeBoots, "Blaze Boots");

        LanguageRegistry.addName(EnderPickaxe, "Ender Pickaxe");
        LanguageRegistry.addName(EnderAxe, "Ender Axe");
        LanguageRegistry.addName(EnderShovel, "Ender Shovel");
        LanguageRegistry.addName(EnderHoe, "Ender Hoe");
        LanguageRegistry.addName(EnderSword, "Ender Sword");
        LanguageRegistry.addName(EnderHelmet, "Ender Helmet");
        LanguageRegistry.addName(EnderBody, "Ender Chestplate");
        LanguageRegistry.addName(EnderLegs, "Ender Leggings");
        LanguageRegistry.addName(EnderBoots, "Ender Boots");

        LanguageRegistry.addName(SlimeHelmet, "Slimy Helmet");
        LanguageRegistry.addName(SlimeBody, "Slimy Chestplate");
        LanguageRegistry.addName(SlimeLegs, "Slimy Leggings");
        LanguageRegistry.addName(SlimeBoots, "Slimy Boots");

        LanguageRegistry.addName(FleshHelmet, "Flesh Helmet");
        LanguageRegistry.addName(FleshBody, "Flesh Chestplate");
        LanguageRegistry.addName(FleshLegs, "Flesh Leggings");
        LanguageRegistry.addName(FleshBoots, "Flesh Boots");
        
        LanguageRegistry.addName(CobwebHelmet, "Spider Silk Cap");
        LanguageRegistry.addName(CobwebBody, "Spider Silk Tunic");
        LanguageRegistry.addName(CobwebLegs, "Spider Silk Pants");
        LanguageRegistry.addName(CobwebBoots, "Spider Silk Boots");

        LanguageRegistry.addName(NecroHelmet, "Bone Lord Helmet");
        LanguageRegistry.addName(NecroBody, "Bone Lord Chestplate");
        LanguageRegistry.addName(NecroLegs, "Bone Lord Leggings");
        LanguageRegistry.addName(NecroBoots, "Bone Lord Boots");

        LanguageRegistry.addName(DragonscaleHelmet, "Enderdragon Scale Helmet");
        LanguageRegistry.addName(DragonscaleBody, "Enderdragon Scale Chestplate");
        LanguageRegistry.addName(DragonscaleLegs, "Enderdragon Scale Leggings");
        LanguageRegistry.addName(DragonscaleBoots, "Enderdragon Scale Boots");

        LanguageRegistry.addName(EndstonePickaxe, "Endstone Pickaxe");
        LanguageRegistry.addName(EndstoneAxe, "Endstone Axe");
        LanguageRegistry.addName(EndstoneShovel, "Endstone Shovel");
        LanguageRegistry.addName(EndstoneHoe, "Endstone Hoe");
        LanguageRegistry.addName(EndstoneSword, "Endstone Sword");

        LanguageRegistry.addName(NetherrackPickaxe, "Netherrack Pickaxe");
        LanguageRegistry.addName(NetherrackAxe, "Netherrack Axe");
        LanguageRegistry.addName(NetherrackShovel, "Netherrack Shovel");
        LanguageRegistry.addName(NetherrackHoe, "Netherrack Hoe");
        LanguageRegistry.addName(NetherrackSword, "Netherrack Sword");
        
        LanguageRegistry.addName(EnderBrick, "Ender Brick");        

        LanguageRegistry.addName(WitherBone, "Wither Bone");
        
		MinecraftForge.setBlockHarvestLevel(BoneBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(StoneStair, "pickaxe", 0);           
		MinecraftForge.setBlockHarvestLevel(RubyOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(RubyBlock, "pickaxe", 2);           

        
        //Smelt and process items.
        GameRegistry.addSmelting(Ruby.itemID, new ItemStack(RubyOre), 3.0F);
        
        //Item storage recipes.
        GameRegistry.addRecipe(new ItemStack(BoneBlock, 1), "###", "###", "###",'#', Item.bone);
        GameRegistry.addRecipe(new ItemStack(RubyBlock, 1), "###", "###", "###",'#', Ruby);

        GameRegistry.addRecipe(new ItemStack(Item.bone, 9), "###", "###", "###",'#', BoneBlock);
        GameRegistry.addRecipe(new ItemStack(Ruby, 9), "###", "###", "###",'#', RubyBlock);

        // ~ -- RECIPES -- ~ \\
        
        //--Bone Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(BoneHelmet, 1), new Object[] {"KKK", "K K", 'K', Item.bone});
        GameRegistry.addRecipe(new ItemStack(BoneBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Item.bone});
        GameRegistry.addRecipe(new ItemStack(BoneLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Item.bone});
        GameRegistry.addRecipe(new ItemStack(BoneBoots, 1), new Object[] {"K K", "K K", 'K', Item.bone});
        GameRegistry.addRecipe(new ItemStack(BonePickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Item.bone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BoneAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Item.bone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BoneShovel, 1), new Object[] {"K", "S", "S", 'K', Item.bone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BoneHoe, 1), new Object[] {"KK", " S", " S", 'K', Item.bone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BoneSword, 1), new Object[] {"K", "K", "S", 'K', Item.bone, 'S', Item.stick}); 
        
        //--Wither Bone Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(WitherBoneHelmet, 1), new Object[] {"KKK", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(WitherBoneBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(WitherBoneLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(WitherBoneBoots, 1), new Object[] {"K K", "K K", 'K', WitherBone});
        GameRegistry.addRecipe(new ItemStack(WitherBonePickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', WitherBone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(WitherBoneAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', WitherBone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(WitherBoneShovel, 1), new Object[] {"K", "S", "S", 'K', WitherBone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(WitherBoneHoe, 1), new Object[] {"KK", " S", " S", 'K', WitherBone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(WitherBoneSword, 1), new Object[] {"K", "K", "S", 'K', WitherBone, 'S', Item.stick});
        
        //--Obsidian Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(ObsidianHelmet, 1), new Object[] {"KKK", "K K", 'K', Block.obsidian});
        GameRegistry.addRecipe(new ItemStack(ObsidianBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Block.obsidian});
        GameRegistry.addRecipe(new ItemStack(ObsidianLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Block.obsidian});
        GameRegistry.addRecipe(new ItemStack(ObsidianBoots, 1), new Object[] {"K K", "K K", 'K', Block.obsidian});
        GameRegistry.addRecipe(new ItemStack(ObsidianPickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Block.obsidian, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ObsidianAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Block.obsidian, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ObsidianShovel, 1), new Object[] {"K", "S", "S", 'K', Block.obsidian, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ObsidianHoe, 1), new Object[] {"KK", " S", " S", 'K', Block.obsidian, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ObsidianSword, 1), new Object[] {"K", "K", "S", 'K', Block.obsidian, 'S', Item.stick});

        //--Emerald Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(EmeraldHelmet, 1), new Object[] {"KKK", "K K", 'K', Item.emerald});
        GameRegistry.addRecipe(new ItemStack(EmeraldBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Item.emerald});
        GameRegistry.addRecipe(new ItemStack(EmeraldLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Item.emerald});
        GameRegistry.addRecipe(new ItemStack(EmeraldBoots, 1), new Object[] {"K K", "K K", 'K', Item.emerald});
        GameRegistry.addRecipe(new ItemStack(EmeraldPickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Item.emerald, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EmeraldAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Item.emerald, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EmeraldShovel, 1), new Object[] {"K", "S", "S", 'K', Item.emerald, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EmeraldHoe, 1), new Object[] {"KK", " S", " S", 'K', Item.emerald, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EmeraldSword, 1), new Object[] {"K", "K", "S", 'K', Item.emerald, 'S', Item.stick});

        //--Ruby Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(RubyHelmet, 1), new Object[] {"KKK", "K K", 'K', Ruby});
        GameRegistry.addRecipe(new ItemStack(RubyBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Ruby});
        GameRegistry.addRecipe(new ItemStack(RubyLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Ruby});
        GameRegistry.addRecipe(new ItemStack(RubyBoots, 1), new Object[] {"K K", "K K", 'K', Ruby});
        GameRegistry.addRecipe(new ItemStack(RubyPickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Ruby, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(RubyAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Ruby, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(RubyShovel, 1), new Object[] {"K", "S", "S", 'K', Ruby, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(RubyHoe, 1), new Object[] {"KK", " S", " S", 'K', Ruby, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(RubySword, 1), new Object[] {"K", "K", "S", 'K', Ruby, 'S', Item.stick});
        
        //--Blaze Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(BlazeHelmet, 1), new Object[] {"KKK", "K K", 'K', Item.blazeRod});
        GameRegistry.addRecipe(new ItemStack(BlazeBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Item.blazeRod});
        GameRegistry.addRecipe(new ItemStack(BlazeLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Item.blazeRod});
        GameRegistry.addRecipe(new ItemStack(BlazeBoots, 1), new Object[] {"K K", "K K", 'K', Item.blazeRod});
        GameRegistry.addRecipe(new ItemStack(BlazePickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Item.blazeRod, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BlazeAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Item.blazeRod, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BlazeShovel, 1), new Object[] {"K", "S", "S", 'K', Item.blazeRod, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BlazeHoe, 1), new Object[] {"KK", " S", " S", 'K', Item.blazeRod, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(BlazeSword, 1), new Object[] {"K", "K", "S", 'K', Item.blazeRod, 'S', Item.stick});

        //--Ender Tools/Armor--\\
        GameRegistry.addRecipe(new ItemStack(EnderHelmet, 1), new Object[] {"KKK", "K K", 'K', Item.enderPearl});
        GameRegistry.addRecipe(new ItemStack(EnderBody, 1), new Object[] {"K K", "KKK", "KKK", 'K', Item.enderPearl});
        GameRegistry.addRecipe(new ItemStack(EnderLegs, 1), new Object[] {"KKK", "K K", "K K", 'K', Item.enderPearl});
        GameRegistry.addRecipe(new ItemStack(EnderBoots, 1), new Object[] {"K K", "K K", 'K', Item.enderPearl});
        GameRegistry.addRecipe(new ItemStack(EnderPickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Item.enderPearl, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EnderAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Item.enderPearl, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EnderShovel, 1), new Object[] {"K", "S", "S", 'K', Item.enderPearl, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EnderHoe, 1), new Object[] {"KK", " S", " S", 'K', Item.enderPearl, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EnderSword, 1), new Object[] {"K", "K", "S", 'K', Item.enderPearl, 'S', Item.stick});
        
        //--Endstone Tools--\\
        GameRegistry.addRecipe(new ItemStack(EndstonePickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Block.whiteStone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EndstoneAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Block.whiteStone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EndstoneShovel, 1), new Object[] {"K", "S", "S", 'K', Block.whiteStone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EndstoneHoe, 1), new Object[] {"KK", " S", " S", 'K', Block.whiteStone, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(EndstoneSword, 1), new Object[] {"K", "K", "S", 'K', Block.whiteStone, 'S', Item.stick});

        //--Netherrack Tools--\\
        GameRegistry.addRecipe(new ItemStack(NetherrackPickaxe, 1), new Object[] {"KKK", " S ", " S ", 'K', Block.netherrack, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(NetherrackAxe, 1), new Object[] {"KK ", "KS ", " S ", 'K', Block.netherrack, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(NetherrackShovel, 1), new Object[] {"K", "S", "S", 'K', Block.netherrack, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(NetherrackHoe, 1), new Object[] {"KK", " S", " S", 'K', Block.netherrack, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(NetherrackSword, 1), new Object[] {"K", "K", "S", 'K', Block.netherrack, 'S', Item.stick});

        //--Slime Armor--\\
        GameRegistry.addRecipe(new ItemStack(SlimeHelmet, 1), new Object[] {"###", "# #", '#', Item.slimeBall});
        GameRegistry.addRecipe(new ItemStack(SlimeBody, 1), new Object[] {"# #", "###", "###", '#', Item.slimeBall});
        GameRegistry.addRecipe(new ItemStack(SlimeLegs, 1), new Object[] {"###", "# #", "# #", '#', Item.slimeBall});
        GameRegistry.addRecipe(new ItemStack(SlimeBoots, 1), new Object[] {"# #", "# #", '#', Item.slimeBall});
        
        //--Rotten Flesh Armor--\\
        GameRegistry.addRecipe(new ItemStack(FleshHelmet, 1), new Object[] {"###", "# #", '#', Item.rottenFlesh});
        GameRegistry.addRecipe(new ItemStack(FleshBody, 1), new Object[] {"# #", "###", "###", '#', Item.rottenFlesh});
        GameRegistry.addRecipe(new ItemStack(FleshLegs, 1), new Object[] {"###", "# #", "# #", '#', Item.rottenFlesh});
        GameRegistry.addRecipe(new ItemStack(FleshBoots, 1), new Object[] {"# #", "# #", '#', Item.rottenFlesh});
        
        //--Spider Silk Armor--\\
        GameRegistry.addRecipe(new ItemStack(CobwebHelmet, 1), new Object[] {"###", "# #", '#', Block.web});
        GameRegistry.addRecipe(new ItemStack(CobwebBody, 1), new Object[] {"# #", "###", "###", '#', Block.web});
        GameRegistry.addRecipe(new ItemStack(CobwebLegs, 1), new Object[] {"###", "# #", "# #", '#', Block.web});
        GameRegistry.addRecipe(new ItemStack(CobwebBoots, 1), new Object[] {"# #", "# #", '#', Block.web});

        //--Necro Armour--\\
        GameRegistry.addRecipe(new ItemStack(NecroHelmet, 1), new Object[] {"BBB", "C C", 'B', Item.bone, 'C', Block.web});
        GameRegistry.addRecipe(new ItemStack(NecroBody, 1), new Object[] {"B B", "CCC", "BBB", 'B', Item.bone, 'C', Block.web});
        GameRegistry.addRecipe(new ItemStack(NecroLegs, 1), new Object[] {"BBB", "C C", "B B", 'B', Item.bone, 'C', Block.web});
        GameRegistry.addRecipe(new ItemStack(NecroBoots, 1), new Object[] {"C C", "B B", 'B', Item.bone, 'C', Block.web});

        
        
        //--Block Recipes--\\
        
        // Items into Storage Blocks
        GameRegistry.addRecipe(new ItemStack(BoneBlock, 1), new Object[] {"###","###","###",'#', Item.bone});
        GameRegistry.addRecipe(new ItemStack(FleshBlock, 1), new Object[] {"###","###","###",'#', Item.rottenFlesh});
        GameRegistry.addRecipe(new ItemStack(RubyBlock, 1), new Object[] {"###","###","###",'#', Ruby});
        GameRegistry.addRecipe(new ItemStack(BlazeBlock, 1), new Object[] {"###","###","###",'#', Item.blazeRod});
        GameRegistry.addRecipe(new ItemStack(EnderBlock, 1), new Object[] {"###","###","###",'#', Item.enderPearl});
        GameRegistry.addRecipe(new ItemStack(GunpowderBlock, 1), new Object[] {"###","###","###",'#', Item.gunpowder});
        GameRegistry.addRecipe(new ItemStack(SlimeBlock, 1), new Object[] {"###","###","###",'#', Item.slimeBall});

        // Storage Blocks into Items
        GameRegistry.addRecipe(new ItemStack(Item.bone, 9), new Object[] {"B",'B', BoneBlock});
        GameRegistry.addRecipe(new ItemStack(Item.rottenFlesh, 9), new Object[] {"B",'B', FleshBlock});
        GameRegistry.addRecipe(new ItemStack(Ruby, 9), new Object[] {"B",'B', RubyBlock});
        GameRegistry.addRecipe(new ItemStack(Item.blazeRod, 9), new Object[] {"B",'B', BlazeBlock});
        GameRegistry.addRecipe(new ItemStack(Item.enderPearl, 9), new Object[] {"B",'B', EnderBlock});
        GameRegistry.addRecipe(new ItemStack(Item.gunpowder, 9), new Object[] {"B",'B', GunpowderBlock});
        GameRegistry.addRecipe(new ItemStack(Item.slimeBall, 9), new Object[] {"B",'B', SlimeBlock});
        
        // Decorative Blocks
        GameRegistry.addRecipe(new ItemStack(EndBrickBlock, 1), new Object[] {"##","##",'#', EnderBrick});

        // Slabs and Stairs
        GameRegistry.addRecipe(new ItemStack(EndBrickStair, 4), new Object[] {"  #"," ##","###",'#', EndBrickBlock});
        GameRegistry.addRecipe(new ItemStack(StoneStair, 4), new Object[] {"  #"," ##","###",'#', Block.stone});
        GameRegistry.addRecipe(new ItemStack(NetherWoodStairs, 4), new Object[] {"  #"," ##","###",'#', NetherPlanks});

        GameRegistry.addRecipe(new ItemStack(EndBrickSlab, 6), new Object[] {"###",'#', EndBrickBlock});
        GameRegistry.addRecipe(new ItemStack(NetherWoodSlab, 6), new Object[] {"###",'#', NetherPlanks});

        // Convert Logs to Planks
        GameRegistry.addRecipe(new ItemStack(NetherPlanks, 4), new Object[] {"#", '#', NetherLog});

               
        //--IMPORTANT RECIPES--\\
        GameRegistry.addRecipe(new ItemStack(Block.web, 1), new Object[] {"S S", " S ", "S S", 'S', Item.silk});
        GameRegistry.addRecipe(new ItemStack(WitherBone, 4), new Object[] {"OBO", "BNB", "OBO", 'O', Block.obsidian, 'B', Item.bone, 'N', Item.netherStar});
        GameRegistry.addRecipe(new ItemStack(IronTrapdoor, 1), new Object[] {"III", "ITI", "III",'I', Item.ingotIron, 'T', Block.trapdoor});
		GameRegistry.addRecipe(new ItemStack(Block.anvil, 1, 1), new Object[] {"III", "IAI", "III", 'I', Item.ingotIron, 'A', new ItemStack(Block.anvil, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Block.anvil, 1, 0), new Object[] {"III", "IAI", "III", 'I', Item.ingotIron, 'A', new ItemStack(Block.anvil, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Item.saddle, 1), new Object[] {"LLL", "LSL", "I I", 'I', Item.ingotIron, 'L', Item.leather, 'S', Item.silk});
		GameRegistry.addRecipe(new ItemStack(NetherBrickDoor, 1), new Object[] {"BB", "BB", "BB", 'B', Block.netherBrick});
		GameRegistry.addRecipe(new ItemStack(GlassDoor, 1), new Object[] {"BB", "BB", "BB", 'B', Block.glass});
		GameRegistry.addRecipe(new ItemStack(NetherBrickFenceGate, 1), new Object[] {"#B#", "#B#", 'B', Block.netherBrick, '#', Item.netherrackBrick});
		
		/*Horse Armour*/
        GameRegistry.addRecipe(new ItemStack(Item.horseArmorIron, 1), new Object[] {"  #", "#C#", "###", '#', Item.ingotIron, 'C', Block.cloth});
        GameRegistry.addRecipe(new ItemStack(Item.horseArmorGold, 1), new Object[] {"  #", "#C#", "###", '#', Item.ingotGold, 'C', Block.cloth});
        GameRegistry.addRecipe(new ItemStack(Item.horseArmorDiamond, 1), new Object[] {"  #", "#C#", "###", '#', Item.diamond, 'C', Block.cloth});
        
		/*Nether wood planks recipes*/
		GameRegistry.addRecipe(new ItemStack(Item.stick, 4), new Object[] {"B", "B", 'B', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Block.workbench, 1), new Object[] {"BB", "BB", 'B', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Block.trapdoor, 2), new Object[] {"###", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Block.woodenButton, 1), new Object[] {"#", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(NetherwoodChest, 1), new Object[] {"###", "# #", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Block.jukebox, 1), new Object[] {"###", "#D#", "###", '#', NetherPlanks, 'D', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Block.music, 1), new Object[] {"###", "#R#", "###", '#', NetherPlanks, 'R', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] {"##", '#', NetherPlanks});

		GameRegistry.addRecipe(new ItemStack(NetherwoodDoor, 1), new Object[] {"##", "##", "##", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Item.boat, 1), new Object[] {"# #", "###", '#', NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(Item.sign, 3), new Object[] {"###", "###", "S", '#', NetherPlanks, 'S', Item.stick});

		GameRegistry.addRecipe(new ItemStack(NetherWoodSlab, 6), new Object[] {"###", '#', NetherPlanks});
		
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1), new Object[] {"#", "#", "S", '#', NetherPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1), new Object[] {"###", " S ", " S ", '#', NetherPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1), new Object[] {"##", "#S", " S", '#', NetherPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1), new Object[] {"#", "S", "S", '#', NetherPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1), new Object[] {"##", " S", " S", '#', NetherPlanks, 'S', Item.stick});
		
        GameRegistry.addShapelessRecipe(new ItemStack(Item.spiderEye, 1), new Object[] {spiderMeatRaw});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 1, 0), new Object[] {squid});

        GameRegistry.addShapelessRecipe(new ItemStack(cakeSlice, 6), new Object[] {Item.cake});
        GameRegistry.addShapelessRecipe(new ItemStack(applePie, 1), new Object[] {Item.egg, Item.appleRed, Item.sugar});

        
        /*Rotten flesh recipes, used as substitute for leather.*/
        GameRegistry.addRecipe(new ItemStack(Item.itemFrame, 1), new Object[] {"SSS", "SFS", "SSS", 'S', Item.stick, 'F', Item.rottenFlesh});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.book, 1), new Object[] {Item.paper, Item.paper, Item.paper, Item.rottenFlesh});
        
        // ~ --DISMANTLE/SALVAGE RECIPES-- ~ \\
        
        //--Convert slabs and stairs to full blocks--\\
        GameRegistry.addRecipe(new ItemStack(Block.planks, 6, 0), new Object[] {"SS", "SS", 'S', Block.stairsWoodOak});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 6, 1), new Object[] {"SS", "SS", 'S', Block.stairsWoodSpruce});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 6, 2), new Object[] {"SS", "SS", 'S', Block.stairsWoodBirch});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 6, 3), new Object[] {"SS", "SS", 'S', Block.stairsWoodJungle});
        GameRegistry.addRecipe(new ItemStack(Block.cobblestone, 6), new Object[] {"SS", "SS", 'S', Block.stairsCobblestone});
        GameRegistry.addRecipe(new ItemStack(Block.sandStone, 6), new Object[] {"SS", "SS", 'S', Block.stairsSandStone});
        GameRegistry.addRecipe(new ItemStack(Block.brick, 6), new Object[] {"SS", "SS", 'S', Block.stairsBrick});
        GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 6), new Object[] {"SS", "SS", 'S', Block.stairsStoneBrick});
        GameRegistry.addRecipe(new ItemStack(Block.netherBrick, 6), new Object[] {"SS", "SS", 'S', Block.stairsNetherBrick});
        GameRegistry.addRecipe(new ItemStack(Block.blockNetherQuartz, 6), new Object[] {"SS", "SS", 'S', Block.stairsNetherQuartz}); //--Quartz stairs to quartz blocks.
        GameRegistry.addRecipe(new ItemStack(EndBrickBlock, 6), new Object[] {"SS", "SS", 'S', EndBrickStair}); //--Ender Brick stairs to ender brick blocks.
        GameRegistry.addRecipe(new ItemStack(Block.stone, 6), new Object[] {"SS", "SS", 'S', StoneStair}); //--Smooth Stone stairs to smooth stone blocks.
        GameRegistry.addRecipe(new ItemStack(NetherPlanks, 6), new Object[] {"SS", "SS", 'S', NetherWoodStairs});

        
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), new Object[] {"#", "#", '#', new ItemStack(Block.woodSingleSlab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), new Object[] {"#", "#", '#', new ItemStack(Block.woodSingleSlab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), new Object[] {"#", "#", '#', new ItemStack(Block.woodSingleSlab, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Block.woodSingleSlab, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(Block.cobblestone, 1), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(Block.stone, 1), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Block.sandStone, 1), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Block.brick, 1), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 3), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 5)});
        GameRegistry.addRecipe(new ItemStack(Block.netherBrick, 1), new Object[] {"#", "#", '#', new ItemStack(Block.stoneSingleSlab, 1, 6)});
        
        //--Dismantling objects--\\
        GameRegistry.addRecipe(new ItemStack(Item.stick, 1), new Object[] {"AA", "AA", 'A', Item.arrow});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 2), new Object[] {Block.fence});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 6), new Object[] {Item.doorWood});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 4), new Object[] {Item.boat});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 2), new Object[] {Item.sign});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 3), new Object[] {Item.bow});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 8), new Object[] {Block.chest});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3), new Object[] {Block.trapdoor});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 6), new Object[] {Block.fenceGate});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 1), new Object[] {Block.lever});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 2), new Object[] {Block.ladder});
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 4), new Object[] {Block.workbench});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.netherQuartz, 4), new Object[] {Block.blockNetherQuartz}); //--Turn Quartz block into 4 Nether Quartz.
        
        
        // ~ --FURNACE RECIPES -- ~ \\

        //--Procession--\\
        GameRegistry.addSmelting(RubyOre.blockID, new ItemStack(Ruby), 2.0F);
        GameRegistry.addSmelting(Block.whiteStone.blockID, new ItemStack(EnderBrick), 1.0F); 
        GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(SoulGlass), 0.5F); 
        
        //--Cooking food--\\
        GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(fleshCooked), 1.0F);
        GameRegistry.addSmelting(spiderMeatRaw.itemID, new ItemStack(spiderMeatCooked), 1.0F);
        GameRegistry.addSmelting(lambchopRaw.itemID, new ItemStack(BetterCraft.lambchopCooked), 1.0F);
        GameRegistry.addSmelting(squid.itemID, new ItemStack(BetterCraft.calamari), 1.0F);
        GameRegistry.addSmelting(Item.egg.itemID, new ItemStack(BetterCraft.eggFried), 1.0F);
		
        //--Melting down--\\
        GameRegistry.addSmelting(Item.doorIron.itemID, new ItemStack(Item.ingotIron, 6), 0.5F);
        GameRegistry.addSmelting(Item.minecartEmpty.itemID, new ItemStack(Item.ingotIron, 5), 0.5F);
        GameRegistry.addSmelting(Item.cauldron.itemID, new ItemStack(Item.ingotIron, 7), 0.5F);
        
        GameRegistry.registerWorldGenerator(new BetterCraftGenerator());
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