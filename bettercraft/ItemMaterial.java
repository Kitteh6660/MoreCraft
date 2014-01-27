package kittehmod.bettercraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMaterial extends Item 
{

	public ItemMaterial(int id) 
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}