package kittehmod.bettercraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler 
{
	public static int CRAFTING_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == CRAFTING_GUI)
		{
			return new WorkbenchContainer(player.inventory, world);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == CRAFTING_GUI)
		{
			return new WorkbenchGui(player.inventory, world);
		}
		return null;
	}

}