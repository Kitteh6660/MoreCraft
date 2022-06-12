package kittehmod.morecraft.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.util.GsonHelper;

public class KilnRecipeSerializer<T extends AbstractCookingRecipe> implements RecipeSerializer<T>
{
	protected final RecipeType<?> type = ModRecipeType.KILN.get();
	protected final int cookingTime;
	private final KilnRecipeSerializer.IFactory<T> factory;

	public KilnRecipeSerializer(KilnRecipeSerializer.IFactory<T> factory, int cookingTime) {
		this.cookingTime = cookingTime;
		this.factory = factory;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public T fromJson(ResourceLocation recipeId, JsonObject json) {
		String s = GsonHelper.getAsString(json, "group", "");
		JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		// Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
		if (!json.has("result"))
			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
		ItemStack itemstack;
		if (json.get("result").isJsonObject())
			itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
		else {
			String s1 = GsonHelper.getAsString(json, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> { return new IllegalStateException("Item: " + s1 + " does not exist"); }));
		}
		float f = GsonHelper.getAsFloat(json, "experience", 0.0F);
		int i = GsonHelper.getAsInt(json, "cookingtime", this.cookingTime);
		return this.factory.create(recipeId, s, ingredient, itemstack, f, i);
	}
	
	@Override
	public T fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
		String s = buffer.readUtf(32767);
		Ingredient ingredient = Ingredient.fromNetwork(buffer);
		ItemStack itemstack = buffer.readItem();
		float f = buffer.readFloat();
		int i = buffer.readVarInt();
		return this.factory.create(recipeId, s, ingredient, itemstack, f, i);
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, T recipe) {
		buffer.writeUtf(recipe.getGroup());
		recipe.getIngredients().get(0).toNetwork(buffer);
		buffer.writeItem(recipe.getResultItem());
		buffer.writeFloat(recipe.getExperience());
		buffer.writeVarInt(recipe.getCookingTime());
	}

	interface IFactory<T extends AbstractCookingRecipe>
	{
		T create(ResourceLocation p_create_1_, String p_create_2_, Ingredient p_create_3_, ItemStack p_create_4_, float p_create_5_, int p_create_6_);
	}

}
