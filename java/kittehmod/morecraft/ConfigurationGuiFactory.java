package kittehmod.morecraft;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigurationGuiFactory implements IModGuiFactory {  
    @Override
    public void initialize(Minecraft minecraftInstance) {}

    
	@Override
	public boolean hasConfigGui() { return true; }

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) { return new MoreCraftConfigGui(parentScreen); }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }
    
    public static class MoreCraftConfigGui extends GuiConfig
    {
        public MoreCraftConfigGui(GuiScreen parent) 
        {
            super(parent, new ConfigElement(MoreCraft.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "morecraft", false, false, GuiConfig.getAbridgedConfigPath(MoreCraft.config.toString()));
        }
    }
}