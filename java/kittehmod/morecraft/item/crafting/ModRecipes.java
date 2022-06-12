package kittehmod.morecraft.item.crafting;

import java.util.List;

import com.google.common.collect.ImmutableList;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MoreCraft.MODID);

	public static final RegistryObject<RecipeSerializer<?>> KILN = RECIPE_SERIALIZERS.register("kiln", () -> new KilnRecipeSerializer<>(KilnRecipe::new, 100));

	public static final RecipeBookType KILN_RECIPE_BOOK = RecipeBookType.create("morecraft:kiln");
	
	public static final RecipeBookCategories KILN_SEARCH = RecipeBookCategories.create("morecraft:kiln_search", new ItemStack(Items.COMPASS));
	public static final RecipeBookCategories KILN_BLOCKS = RecipeBookCategories.create("morecraft:kiln_blocks", new ItemStack(Items.BRICKS));
	public static final RecipeBookCategories KILN_MISC = RecipeBookCategories.create("morecraft:kiln_misc", new ItemStack(Items.BRICK), new ItemStack(Items.POPPED_CHORUS_FRUIT));
	public static final List<RecipeBookCategories> KILN_CATEGORIES = ImmutableList.of(KILN_SEARCH, KILN_BLOCKS, KILN_MISC);
	
}
