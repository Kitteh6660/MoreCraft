package kittehmod.morecraft.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class KilnRecipeSerializer<T extends AbstractCookingRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T>
{
	protected final IRecipeType<?> type = IModRecipeType.KILN;
	protected final int cookingTime;
	private final KilnRecipeSerializer.IFactory<T> factory;

	public KilnRecipeSerializer(KilnRecipeSerializer.IFactory<T> factory, int cookingTime) {
		this.cookingTime = cookingTime;
		this.factory = factory;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public T fromJson(ResourceLocation recipeId, JsonObject json) {
		String s = JSONUtils.getAsString(json, "group", "");
		JsonElement jsonelement = (JsonElement) (JSONUtils.isArrayNode(json, "ingredient") ? JSONUtils.getAsJsonArray(json, "ingredient") : JSONUtils.getAsJsonObject(json, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		// Forge: Check if primitive string to keep vanilla or a object which can
		// contain a count field.
		if (!json.has("result"))
			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
		ItemStack itemstack;
		if (json.get("result").isJsonObject())
			itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
		else {
			String s1 = JSONUtils.getAsString(json, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> { return new IllegalStateException("Item: " + s1 + " does not exist"); }));
		}
		float f = JSONUtils.getAsFloat(json, "experience", 0.0F);
		int i = JSONUtils.getAsInt(json, "cookingtime", this.cookingTime);
		return this.factory.create(recipeId, s, ingredient, itemstack, f, i);
	}
	
	@Override
	public T fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
		String s = buffer.readUtf(32767);
		Ingredient ingredient = Ingredient.fromNetwork(buffer);
		ItemStack itemstack = buffer.readItem();
		float f = buffer.readFloat();
		int i = buffer.readVarInt();
		return this.factory.create(recipeId, s, ingredient, itemstack, f, i);
	}

	@Override
	public void toNetwork(PacketBuffer buffer, T recipe) {
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
