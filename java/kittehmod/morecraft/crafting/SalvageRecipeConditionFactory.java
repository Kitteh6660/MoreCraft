/*package kittehmod.morecraft.crafting;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraftforge.common.util.JsonUtils;

public class SalvageRecipeConditionFactory implements IConditionFactory {
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		boolean value = JsonUtils.getBoolean(json , "value", true);
		return () -> MoreCraft.salvageRecipes == value;
	}
}
*/