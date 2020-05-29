/*package kittehmod.morecraft.crafting;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraftforge.common.util.JsonUtils;

public class HardcoreRecipeConditionFactory implements IConditionFactory {
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		boolean value = JsonUtils.readNBT(json, "value").getBoolean("hardcore_recipes");
		return () -> MoreCraftConfig.hardcoreRecipes.get() == value;
	}
}
*/