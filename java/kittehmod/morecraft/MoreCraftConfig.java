package kittehmod.morecraft;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.Reloading;

public class MoreCraftConfig {
	
	public static MoreCraftConfig config;
	
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	public static final String CATEGORY_GENERAL = "general";
	public static final String SUBCATEGORY_RECIPES = "recipes";
	public static final String SUBCATEGORY_DROPS = "drops";
	public static final String SUBCATEGORY_GENERATION = "generation";
	
	public static ForgeConfigSpec.BooleanValue hardcoreRecipes;
	public static ForgeConfigSpec.BooleanValue sillyRecipes; //Enables silly recipes.
	public static ForgeConfigSpec.BooleanValue salvageRecipes;
	public static ForgeConfigSpec.BooleanValue overrideMobDrops; //Overrides mob drops.
	public static ForgeConfigSpec.BooleanValue mobHeadDrops; //Enables mob head drops.
	public static ForgeConfigSpec.IntValue generateNetherwoodTrees; //Enables Netherwood trees generation.
	
	static {
		initializeConfig();
		
        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	private static void initializeConfig()
	{
		COMMON_BUILDER.comment("MoreCraft").push(CATEGORY_GENERAL);
		
        COMMON_BUILDER.push(SUBCATEGORY_RECIPES);

        hardcoreRecipes = COMMON_BUILDER
                .comment("Hardcore Recipes\n" + "Default: False")
                .define("hardcore_recipes", false);

        sillyRecipes = COMMON_BUILDER
                .comment("Silly Recipes\n" + "Default: False")
                .define("silly_recipes", false);

        salvageRecipes = COMMON_BUILDER
                .comment("Salvage Recipes (Not Yet Re-Implemented)\n" + "Default: True")
                .define("salvage_recipes", true);

        COMMON_BUILDER.pop();
        
        COMMON_BUILDER.push(SUBCATEGORY_DROPS);
        
        overrideMobDrops = COMMON_BUILDER
                .comment("Override Mob Drops\n" + "Default: True")
                .define("override_mob_drops", true);
        
        mobHeadDrops = COMMON_BUILDER
                .comment("Mob Head Drops\n" + "Default: True")
                .define("mob_head_drops", true);
        
        COMMON_BUILDER.pop();
        
		COMMON_BUILDER.push(SUBCATEGORY_GENERATION);

        generateNetherwoodTrees = COMMON_BUILDER
                .comment("Netherwood Trees Frequency\n" + "Default: " + 16)
                .defineInRange("netherwood_gen_freq", 16, 0, 50);
        
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
    public static void configLoaded(final ModConfig.Loading event) {
        
    }

    @SubscribeEvent
    public static void configFileReload(final Reloading event) {

    }
	
}
