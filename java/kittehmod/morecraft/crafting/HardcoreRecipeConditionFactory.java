package kittehmod.morecraft.crafting;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class HardcoreRecipeConditionFactory implements IConditionFactory {
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		boolean value = JsonUtils.getBoolean(json , "value", true);
		return () -> MoreCraft.hardcoreRecipes == value;
	}
}
