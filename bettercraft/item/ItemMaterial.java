package kittehmod.bettercraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMaterial extends Item 
{

	public ItemMaterial() 
	{
		super();
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}