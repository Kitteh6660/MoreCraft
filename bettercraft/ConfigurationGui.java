package kittehmod.bettercraft;

import cpw.mods.fml.client.config.GuiConfig;  
import net.minecraft.client.gui.GuiScreen;  
import net.minecraftforge.common.config.ConfigElement;  
import net.minecraftforge.common.config.Configuration;

public class ConfigurationGui extends GuiConfig 
{  
    public ConfigurationGui(GuiScreen parent) 
    {
        super(parent, new ConfigElement(BetterCraft.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "bettercraft", false, false, GuiConfig.getAbridgedConfigPath(BetterCraft.config.toString()));
    }
}