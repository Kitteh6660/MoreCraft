package kittehmod.morecraft;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent.Reloading;

public class MoreCraftConfig {
	
	public static MoreCraftConfig config;
	
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    //private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	//public static ForgeConfigSpec CLIENT_CONFIG;
	
	public static final String CATEGORY_GENERAL = "general";
	public static final String SUBCATEGORY_RECIPES = "recipes";
	public static final String SUBCATEGORY_DROPS = "drops";
	public static final String SUBCATEGORY_GENERATION = "generation";
	
	public static ForgeConfigSpec.BooleanValue preventCactusDestroyItems;
	public static ForgeConfigSpec.BooleanValue hardcoreRecipes;
	public static ForgeConfigSpec.BooleanValue sillyRecipes; //Enables silly recipes.
	public static ForgeConfigSpec.BooleanValue salvageRecipes;
	public static ForgeConfigSpec.BooleanValue overrideMobDrops; //Overrides mob drops.
	public static ForgeConfigSpec.BooleanValue mobHeadDrops; //Enables mob head drops.
	public static ForgeConfigSpec.BooleanValue chevonDrops; //Enables chevon drops.
	public static ForgeConfigSpec.BooleanValue frogLegsDrops; //Enables frog legs drops.
	public static ForgeConfigSpec.IntValue generateNetherwoodTrees; //Enables Netherwood trees generation.
	public static ForgeConfigSpec.IntValue rubyOreGenMaxHeight; //Determines max height of Ruby Ores.
	public static ForgeConfigSpec.IntValue rubyOreGenFreq; //Determines frequency of Ruby Ore veins.
	public static ForgeConfigSpec.IntValue rubyOreGenSize; //Determines max size of Ruby Ore veins.
	
	static {
		initializeConfig();
		
        COMMON_CONFIG = COMMON_BUILDER.build();
        //CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	private static void initializeConfig()
	{
		COMMON_BUILDER.comment("MoreCraft").push(CATEGORY_GENERAL);
		
        preventCactusDestroyItems = COMMON_BUILDER
                .comment("Prevent Cactus Destroy Items: When set to true, cactus will no longer be able to destroy dropped items.  " + "Default: True")
                .define("prevent_cactus_destroy_items", true);
		
        COMMON_BUILDER.push(SUBCATEGORY_RECIPES);

        hardcoreRecipes = COMMON_BUILDER
                .comment("Hardcore Recipes: Makes certain modded recipes more difficult.  " + "Default: False")
                .define("hardcore_recipes", false);

        sillyRecipes = COMMON_BUILDER
                .comment("Silly Recipes: Enables certain, silly recipes.  " + "Default: False")
                .define("silly_recipes", false);

        salvageRecipes = COMMON_BUILDER
                .comment("Salvage Recipe: Enables recipes that allows you to salvage certain items back into materials.  " + "Default: True")
                .define("salvage_recipes", true);

        COMMON_BUILDER.pop();
        
        COMMON_BUILDER.push(SUBCATEGORY_DROPS);
        
        overrideMobDrops = COMMON_BUILDER
                .comment("Override Mob Drops: Determines if Spider and Squid default drops should be replaced.  " + "Default: true")
                .define("override_mob_drops", true);
        
        mobHeadDrops = COMMON_BUILDER
                .comment("Mob Head Drops: Determines if mob heads should drop rarely.  " + "Default: true")
                .define("mob_head_drops", true);
        
        chevonDrops = COMMON_BUILDER
                .comment("Chevon Drops: Determines if goats should drop meat on death. Disable if you have other Chevon-adding mods installed.  " + "Default: true")
                .define("chevon_drops", true);
        
        frogLegsDrops = COMMON_BUILDER
                .comment("Frog Legs Drops: Determines if frogs should drop frog legs on death. Disable if you have other Frog Legs-adding mods installed.  " + "Default: true")
                .define("frog_legs_drops", true);
        
        COMMON_BUILDER.pop();
        
		COMMON_BUILDER.push(SUBCATEGORY_GENERATION);

        generateNetherwoodTrees = COMMON_BUILDER
                .comment("Netherwood Trees Frequency: How many attempts should be made per chunk to generate Netherwood Trees.  " + "Default: " + 12)
                .defineInRange("netherwood_gen_freq", 12, 0, 50);

        rubyOreGenMaxHeight = COMMON_BUILDER
                .comment("Ruby Ore Max Height: The maximum Y position the ruby ores can generate up to.  " + "Default: " + 32)
                .defineInRange("ruby_ore_gen_max_height", 32, 1, 256);
        
        rubyOreGenFreq = COMMON_BUILDER
                .comment("Ruby Ore Frequency: How many attempts at generating ruby ores.  " + "Default: " + 2)
                .defineInRange("ruby_ore_gen_freq", 2, 0, 16);
        
        rubyOreGenSize = COMMON_BUILDER
                .comment("Ruby Ore Vein Size: The maximum size of ruby ore veins.  " + "Default: " + 8)
                .defineInRange("ruby_ore_gen_size", 8, 1, 16);
        
        COMMON_BUILDER.pop();
	}
	
    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
    
    @SubscribeEvent
    public static void configLoaded(final ModConfig event) {
        
    }

    @SubscribeEvent
    public static void configFileReload(final Reloading event) {

    }
	
}
