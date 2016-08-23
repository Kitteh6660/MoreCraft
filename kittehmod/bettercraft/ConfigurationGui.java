package kittehmod.bettercraft;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigurationGui extends GuiConfig 
{  
    public ConfigurationGui(GuiScreen parent) 
    {
        super(parent, new ConfigElement(MoreCraft.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "bettercraft", false, false, GuiConfig.getAbridgedConfigPath(MoreCraft.config.toString()));
    }
}