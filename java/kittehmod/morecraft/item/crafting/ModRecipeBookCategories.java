package kittehmod.morecraft.item.crafting;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModRecipeBookCategories
{	
	public static final RecipeBookCategories KILN_SEARCH = RecipeBookCategories.create("morecraft:kiln_search", new ItemStack(Items.COMPASS));
	public static final RecipeBookCategories KILN_BLOCKS = RecipeBookCategories.create("morecraft:kiln_blocks", new ItemStack(Items.BRICKS));
	public static final RecipeBookCategories KILN_MISC = RecipeBookCategories.create("morecraft:kiln_misc", new ItemStack(Items.BRICK), new ItemStack(Items.POPPED_CHORUS_FRUIT));
	public static final List<RecipeBookCategories> KILN_CATEGORIES = ImmutableList.of(KILN_SEARCH, KILN_BLOCKS, KILN_MISC);
}
